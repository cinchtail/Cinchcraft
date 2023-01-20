package com.cinchtail.cinchcraft.block.custom;

import com.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class AppleLeavesBlock extends LeavesBlock implements BonemealableBlock {
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;

    public AppleLeavesBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0).setValue(DISTANCE, 7).setValue(PERSISTENT, Boolean.FALSE).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public boolean isRandomlyTicking(BlockState blockState) {
        return blockState.getValue(DISTANCE) == 7 && !blockState.getValue(PERSISTENT);
    }

    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        serverLevel.setBlock(pos, updateDistance(blockState, serverLevel, pos), 3);
    }

    private static BlockState updateDistance(BlockState blockState, LevelAccessor levelAccessor, BlockPos pos) {
        int i = 7;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(Direction direction : Direction.values()) {
            blockpos$mutableblockpos.setWithOffset(pos, direction);
            i = Math.min(i, getDistanceAt(levelAccessor.getBlockState(blockpos$mutableblockpos)) + 1);
            if (i == 1) {
                break;
            }
        }

        return blockState.setValue(DISTANCE, i);
    }

    private static int getDistanceAt(BlockState blockState) {
        if (blockState.is(BlockTags.LOGS)) {
            return 0;
        } else {
            return blockState.getBlock() instanceof LeavesBlock ? blockState.getValue(DISTANCE) : 7;
        }
    }

    @Override
    protected boolean decaying(BlockState blockState) {
        return !blockState.getValue(PERSISTENT) && blockState.getValue(DISTANCE) == 7;
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        int i = blockState.getValue(AGE);
        if (i < 3 && serverLevel.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(serverLevel, pos, blockState, randomSource.nextInt(20) == 0)) {
            BlockState blockstate = blockState.setValue(AGE, i + 1);
            serverLevel.setBlock(pos, blockstate, 2);
            serverLevel.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(serverLevel, pos, blockState);
        }
        if (this.decaying(blockState)) {
            dropResources(blockState, serverLevel, pos);
            serverLevel.removeBlock(pos, false);
        }
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        int i = blockState.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(interactionHand).is(ModItems.COMPOST.get()) || player.getItemInHand(interactionHand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 2) {
            int j = 2 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(Items.APPLE, j + (flag ? 1 : 0)));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockstate = blockState.setValue(AGE, 0);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(blockState, level, pos, player, interactionHand, blockHitResult);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(AGE, PERSISTENT, WATERLOGGED, DISTANCE);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader p_256559_, BlockPos p_50898_, BlockState blockState, boolean p_50900_) {
        return blockState.getValue(AGE) < 3;
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos pos, BlockState blockState) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos pos, BlockState blockState) {
        int i = Math.min(3, blockState.getValue(AGE) + 1);
        serverLevel.setBlock(pos, blockState.setValue(AGE, i), 2);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 30;
    }
}


package com.cinchtail.cinchcraft.block.custom;

import com.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StrawberryPlantBlock extends BushBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D);

    public StrawberryPlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState blockState) {
        return new ItemStack(ModItems.STRAWBERRIES.get());
    }
    public VoxelShape getShape(BlockState p_54955_, BlockGetter p_54956_, BlockPos p_54957_, CollisionContext p_54958_) {
        return SHAPE;
    }
    public boolean isRandomlyTicking(BlockState blockState) {
        return blockState.getValue(AGE) < 3;
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        int i = blockState.getValue(AGE);
        if (i < 3 && serverLevel.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(serverLevel, pos, blockState, randomSource.nextInt(5) == 0)) {
            BlockState blockstate = blockState.setValue(AGE, i + 1);
            serverLevel.setBlock(pos, blockstate, 2);
            serverLevel.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(serverLevel, pos, blockState);
        }
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        int i = blockState.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(interactionHand).is(ModItems.COMPOST.get()) || player.getItemInHand(interactionHand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(ModItems.STRAWBERRIES.get(), j + (flag ? 1 : 0)));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockstate = blockState.setValue(AGE, 1);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(blockState, level, pos, player, interactionHand, blockHitResult);
        }
    }

    public boolean isValidBonemealTarget(BlockGetter blockGetter, BlockPos pos, BlockState blockState, boolean b) {
        return blockState.getValue(AGE) < 3;
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos pos, BlockState blockState) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos pos, BlockState blockState) {
        int i = Math.min(3, blockState.getValue(AGE) + 1);
        serverLevel.setBlock(pos, blockState.setValue(AGE, i), 2);
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(AGE);
    }
}
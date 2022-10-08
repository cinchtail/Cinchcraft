package com.cinchtail.cinchcraft.minecraft.block.custom;

import com.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ReplacedSweetBerryBushBlock extends BushBlock implements BonemealableBlock {
    private static final float HURT_SPEED_THRESHOLD = 0.003F;
    public static final int MAX_AGE = 3;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
    private static final VoxelShape MID_GROWTH_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public ReplacedSweetBerryBushBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState blockState) {
        return new ItemStack(Items.SWEET_BERRIES);
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
        if (blockState.getValue(AGE) == 0) {
            return SAPLING_SHAPE;
        } else {
            return blockState.getValue(AGE) < 3 ? MID_GROWTH_SHAPE : super.getShape(blockState, blockGetter, pos, collisionContext);
        }
    }
    public boolean isRandomlyTicking(BlockState p_57284_) {
        return p_57284_.getValue(AGE) < 3;
    }

    public void randomTick(BlockState p_222563_, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        int i = p_222563_.getValue(AGE);
        if (i < 3 && serverLevel.getRawBrightness(pos.above(), 0) >= 9 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(serverLevel, pos, p_222563_, randomSource.nextInt(5) == 0)) {
            BlockState blockstate = p_222563_.setValue(AGE, i + 1);
            serverLevel.setBlock(pos, blockstate, 2);
            serverLevel.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(serverLevel, pos, p_222563_);
        }

    }

    public void entityInside(BlockState blockState, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
            entity.makeStuckInBlock(blockState, new Vec3((double)0.8F, 0.75D, (double)0.8F));
            if (!level.isClientSide && blockState.getValue(AGE) > 0 && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
                double d0 = Math.abs(entity.getX() - entity.xOld);
                double d1 = Math.abs(entity.getZ() - entity.zOld);
                if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
                    entity.hurt(DamageSource.SWEET_BERRY_BUSH, 1.0F);
                }
            }

        }
    }

    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        int i = blockState.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(interactionHand).is(ModItems.COMPOST.get()) || player.getItemInHand(interactionHand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(Items.SWEET_BERRIES, j + (flag ? 1 : 0)));
            level.playSound((Player)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockstate = blockState.setValue(AGE, 1);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.use(blockState, level, pos, player, interactionHand, blockHitResult);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(AGE);
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
}
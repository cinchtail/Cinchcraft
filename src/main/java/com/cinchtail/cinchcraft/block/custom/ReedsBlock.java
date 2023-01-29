package com.cinchtail.cinchcraft.block.custom;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.util.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;


public class ReedsBlock extends DoublePlantBlock implements SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);

    public ReedsBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, Boolean.FALSE).setValue(FACING, Direction.NORTH));
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
        return SHAPE;
    }

    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos pos) {
        return blockState.is(ModBlockTags.REEDS_PLACEABLE) && blockGetter.getBlockState(pos.above()).is(Blocks.AIR) ||
                blockGetter.getBlockState(pos.below()).is(ModBlocks.REEDS.get()) && super.mayPlaceOn(blockState, blockGetter, pos);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        BlockState blockstate = super.getStateForPlacement(placeContext);
        return blockstate != null ? copyWaterloggedFrom(placeContext.getLevel(), placeContext.getClickedPos(), blockstate.setValue(FACING, placeContext.getHorizontalDirection().getOpposite())) : null;
    }

    public void setPlacedBy(Level blockstate1, BlockPos pos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        if (!blockstate1.isClientSide()) {
            BlockPos blockpos = pos.above();
            BlockState blockstate = DoublePlantBlock.copyWaterloggedFrom(blockstate1, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(FACING, blockState.getValue(FACING)));
            blockstate1.setBlock(blockpos, blockstate, 3);
        }

    }

    public FluidState getFluidState(BlockState blockState) {
        return blockState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(blockState);
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos pos) {
        if (blockState.getValue(HALF) == DoubleBlockHalf.UPPER) {
            return super.canSurvive(blockState, levelReader, pos);
        } else {
            BlockPos blockpos = pos.below();
            BlockState blockstate = levelReader.getBlockState(blockpos);
            return this.mayPlaceOn(blockstate, levelReader, blockpos);
        }
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState1, LevelAccessor levelAccessor, BlockPos pos, BlockPos pos1) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return super.updateShape(blockState, direction, blockState1, levelAccessor, pos, pos1);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(HALF, WATERLOGGED, FACING);
    }

    public float getMaxVerticalOffset() {
        return 0.1F;
    }
}


package com.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nullable;
import java.util.Objects;

public class Testing extends WallTorchBlock implements SimpleWaterloggedBlock {

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public Testing(Properties properties, ParticleOptions particleOptions) {
        super(properties, particleOptions);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE ));
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        FluidState fluidstate = placeContext.getLevel().getFluidState(placeContext.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;
        return Objects.requireNonNull(super.getStateForPlacement(placeContext)).setValue(WATERLOGGED, flag);
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState1, LevelAccessor levelAccessor, BlockPos pos, BlockPos pos1) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }

        return super.updateShape(blockState, direction, blockState1, levelAccessor, pos, pos1);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(WATERLOGGED).add(FACING);
    }
    public FluidState getFluidState(BlockState value) {
        return value.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(value);
    }
}
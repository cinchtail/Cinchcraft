package com.cinchtail.cinchcraft.block.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Objects;

public class GlowStoneWallTorchBlock extends GlowStoneTorchBlock {
    protected static final float AABB_OFFSET = 2.5F;
    private static final Map<Direction, VoxelShape> AABBS = Maps.newEnumMap(ImmutableMap.of(Direction.NORTH, Block.box(5.5D, 3.0D, 11.0D, 10.5D, 13.0D, 16.0D), Direction.SOUTH, Block.box(5.5D, 3.0D, 0.0D, 10.5D, 13.0D, 5.0D), Direction.WEST, Block.box(11.0D, 3.0D, 5.5D, 16.0D, 13.0D, 10.5D), Direction.EAST, Block.box(0.0D, 3.0D, 5.5D, 5.0D, 13.0D, 10.5D)));

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public GlowStoneWallTorchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    public String getDescriptionId() {
        return this.asItem().getDescriptionId();
    }

    public VoxelShape getShape(BlockState p_58152_, BlockGetter p_58153_, BlockPos p_58154_, CollisionContext p_58155_) {
        return getShape(p_58152_);
    }
    public static VoxelShape getShape(BlockState p_58157_) {
        return AABBS.get(p_58157_.getValue(FACING));
    }

    public boolean canSurvive(BlockState p_58133_, LevelReader p_58134_, BlockPos p_58135_) {
        Direction direction = p_58133_.getValue(FACING);
        BlockPos blockpos = p_58135_.relative(direction.getOpposite());
        BlockState blockstate = p_58134_.getBlockState(blockpos);
        return blockstate.isFaceSturdy(p_58134_, blockpos, direction);
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        BlockState blockstate = this.defaultBlockState();
        LevelReader levelreader = placeContext.getLevel();
        BlockPos blockpos = placeContext.getClickedPos();
        Direction[] adirection = placeContext.getNearestLookingDirections();
        FluidState fluidstate = placeContext.getLevel().getFluidState(placeContext.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;

        for(Direction direction : adirection) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction1 = direction.getOpposite();
                blockstate = blockstate.setValue(FACING, direction1);
                if (blockstate.canSurvive(levelreader, blockpos)) {
                    return Objects.requireNonNull(super.getStateForPlacement(placeContext)).setValue(WATERLOGGED, flag);
                }
            }
        }

        return null;
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState1, LevelAccessor levelAccessor, BlockPos pos, BlockPos pos1) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return direction.getOpposite() == blockState.getValue(FACING) && !blockState.canSurvive(levelAccessor, pos) ? Blocks.AIR.defaultBlockState() : blockState;
    }
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(WATERLOGGED).add(FACING);
    }
    public FluidState getFluidState(BlockState value) {
        return value.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(value);
    }
}
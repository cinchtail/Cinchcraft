package com.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;


public class ReedsBlock extends DoublePlantBlock implements SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;


    public ReedsBlock(BlockBehaviour.Properties p_154583_) {
        super(p_154583_);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, Boolean.FALSE));
    }

    public void setPlacedBy(Level p_154599_, BlockPos p_154600_, BlockState p_154601_, LivingEntity p_154602_, ItemStack p_154603_) {
        if (!p_154599_.isClientSide()) {
            BlockPos blockpos = p_154600_.above();
            BlockState blockstate = DoublePlantBlock.copyWaterloggedFrom(p_154599_, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER));
            p_154599_.setBlock(blockpos, blockstate, 3);
        }

    }

    public FluidState getFluidState(BlockState p_154634_) {
        return p_154634_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_154634_);
    }

    public BlockState updateShape(BlockState p_154625_, Direction p_154626_, BlockState p_154627_, LevelAccessor p_154628_, BlockPos p_154629_, BlockPos p_154630_) {
        if (p_154625_.getValue(WATERLOGGED)) {
            p_154628_.scheduleTick(p_154629_, Fluids.WATER, Fluids.WATER.getTickDelay(p_154628_));
        }

        return super.updateShape(p_154625_, p_154626_, p_154627_, p_154628_, p_154629_, p_154630_);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_154632_) {
        p_154632_.add(HALF, WATERLOGGED);
    }

    public float getMaxVerticalOffset() {
        return 0.1F;
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter fluidState, BlockPos above) {
        return blockState.is(BlockTags.DIRT) || blockState.is(Blocks.CLAY) ||
                blockState.is(Blocks.STONE) || blockState.is(Blocks.SAND) ||
                blockState.is(Blocks.RED_SAND)|| blockState.is(Blocks.MOSS_BLOCK)||
                blockState.is(Blocks.MUD) || blockState.is(Blocks.MUDDY_MANGROVE_ROOTS) ||
                blockState.is(Blocks.GRAVEL) && fluidState.getFluidState(above.above()).isSourceOfType(Fluids.WATER) && super.canSurvive(blockState, (LevelReader) fluidState, above);
    }
    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos pos) {
        BlockState soil = levelReader.getBlockState(pos.below());
        if (soil.canSustainPlant(levelReader, pos.below(), Direction.UP, this)) return true;
        BlockState blockstate = levelReader.getBlockState(pos.below());
        if (blockstate.is(this)) {
            return true;
        } else {
            if (blockstate.is(BlockTags.DIRT) || blockstate.is(Blocks.SAND) || blockstate.is(Blocks.RED_SAND)) {
                BlockPos blockpos = pos.below();

                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState blockstate1 = levelReader.getBlockState(blockpos.relative(direction));
                    FluidState fluidstate = levelReader.getFluidState(blockpos.relative(direction));
                    if (blockState.canBeHydrated(levelReader, pos, fluidstate, blockpos.relative(direction)) || blockstate1.is(Blocks.FROSTED_ICE)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}



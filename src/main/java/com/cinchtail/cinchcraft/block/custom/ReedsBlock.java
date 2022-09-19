package com.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SmallDripleafBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.Fluids;

public class ReedsBlock extends SmallDripleafBlock {

    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public ReedsBlock(BlockBehaviour.Properties aSuper) {
        super(aSuper);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, Boolean.FALSE));
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
    public boolean canSurvive(BlockState p_154615_, LevelReader p_154616_, BlockPos p_154617_) {
        if (p_154615_.getValue(HALF) == DoubleBlockHalf.UPPER) {
            return super.canSurvive(p_154615_, p_154616_, p_154617_);
        } else {
            BlockPos blockpos = p_154617_.below();
            BlockState blockstate = p_154616_.getBlockState(blockpos);
            return this.mayPlaceOn(blockstate, p_154616_, blockpos);
        }
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter blockGetter, BlockPos pos, BlockState blockState, boolean b) {
        return false;
    }
}



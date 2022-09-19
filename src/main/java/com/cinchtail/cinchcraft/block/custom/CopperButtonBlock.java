package com.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;

public class CopperButtonBlock extends ButtonBlock implements WeatheringCopper {


    protected CopperButtonBlock(boolean b, Properties properties) {
        super(b, properties);
    }

    @Override
    protected SoundEvent getSound(boolean p_51102_) {
        return null;
    }

    @Override
    public WeatherState getAge() {
        return null;
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        this.onRandomTick(blockState, serverLevel, pos, randomSource);
    }

    public boolean isRandomlyTicking(BlockState blockState) {
        return WeatheringCopper.getNext(blockState.getBlock()).isPresent();
    }
}

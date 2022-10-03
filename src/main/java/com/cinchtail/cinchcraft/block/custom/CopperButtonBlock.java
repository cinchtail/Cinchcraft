package com.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class CopperButtonBlock extends ButtonBlock implements WeatheringCopper {

    private final WeatheringCopper.WeatherState weatherState;
    public CopperButtonBlock(WeatheringCopper.WeatherState p_154925_, BlockBehaviour.Properties p_57060_) {
        super(false, p_57060_);
        this.weatherState = p_154925_;
    }

    @Override
    protected SoundEvent getSound(boolean p_51102_) {
        return null;
    }

    public void randomTick(BlockState p_222665_, ServerLevel p_222666_, BlockPos p_222667_, RandomSource p_222668_) {
        this.onRandomTick(p_222665_, p_222666_, p_222667_, p_222668_);
    }

    public boolean isRandomlyTicking(BlockState p_154935_) {
        return WeatheringCopper.getNext(p_154935_.getBlock()).isPresent();
    }

    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }
}

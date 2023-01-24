package com.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;



public class CopperButtonBlock extends ButtonBlock implements WeatheringCopper {

    private final WeatheringCopper.WeatherState weatherState;

    public CopperButtonBlock(Properties p_249680_, int p_250086_, boolean p_252349_, SoundEvent p_249688_, SoundEvent p_248800_, WeatherState weatherState) {
        super(p_249680_, p_250086_, p_252349_, p_249688_, p_248800_);
        this.weatherState = weatherState;
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

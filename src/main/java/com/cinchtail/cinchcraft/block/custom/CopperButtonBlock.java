package com.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;



public class CopperButtonBlock extends ButtonBlock implements ModWeatheringCopper {

    private final WeatheringCopper.WeatherState weatherState;
    public CopperButtonBlock(WeatheringCopper.WeatherState weatherState, BlockBehaviour.Properties properties) {
        super(false, properties);
        this.weatherState = weatherState;
    }
    @Override
    protected SoundEvent getSound(boolean p_51102_) {
        return null;
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        this.onRandomTick(blockState, serverLevel, pos, randomSource);
    }

    public boolean isRandomlyTicking(BlockState blockState) {
        return WeatheringCopper.getNext(blockState.getBlock()).isPresent();
    }

    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }
}

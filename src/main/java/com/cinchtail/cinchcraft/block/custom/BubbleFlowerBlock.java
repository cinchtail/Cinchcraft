package com.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.PlantType;

public class BubbleFlowerBlock extends FlowerBlock {

    public BubbleFlowerBlock(MobEffect pSuspiciousStewEffect, int pEffectDuration, Properties pProperties) {
        super(pSuspiciousStewEffect, pEffectDuration, pProperties);
    }
    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos) {
        return null;
    }

    @Override
    protected boolean mayPlaceOn(BlockState pSTate, BlockGetter pLevel, BlockPos pPos) {
        return pSTate.is(Blocks.END_STONE);
    }

    @Override
    public void entityInside(BlockState p_58238_, Level p_58239_, BlockPos p_58240_, Entity p_58241_) {
        if (p_58241_ instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)p_58241_;
            livingentity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60));
        }
    }
}

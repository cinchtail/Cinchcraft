package com.cinchtail.cinchcraft.minecraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ReplacedStonecutterBlock extends StonecutterBlock {
    public ReplacedStonecutterBlock(Properties properties) {
        super(properties);
    }
    public void stepOn(Level level, BlockPos pos, BlockState blockState, Entity entity) {
        if (!entity.isSteppingCarefully() && entity instanceof LivingEntity) {
            entity.hurt(DamageSource.GENERIC, 1.5F);
        }
        super.stepOn(level, pos, blockState, entity);
    }
}

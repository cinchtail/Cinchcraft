package com.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SuspiciousEffectHolder;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AlyssumFlowerBlock extends BushBlock implements SuspiciousEffectHolder {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D);
    private final MobEffect suspiciousStewEffect;
    private final int effectDuration;

    private final java.util.function.Supplier<MobEffect> suspiciousStewEffectSupplier;

    @Deprecated
    public AlyssumFlowerBlock(MobEffect mobEffect, int i, BlockBehaviour.Properties properties) {
        super(properties);
        this.suspiciousStewEffect = mobEffect;
        if (mobEffect.isInstantenous()) {
            this.effectDuration = i;
        } else {
            this.effectDuration = i * 20;
        }
        this.suspiciousStewEffectSupplier = net.minecraftforge.registries.ForgeRegistries.MOB_EFFECTS.getDelegateOrThrow(mobEffect);

    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
        Vec3 vec3 = blockState.getOffset(blockGetter, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    public MobEffect getSuspiciousEffect() {
        return this.suspiciousStewEffectSupplier.get();
    }

    public int getEffectDuration() {
        if (this.suspiciousStewEffect == null && !this.suspiciousStewEffectSupplier.get().isInstantenous()) return this.effectDuration * 20;
        return this.effectDuration;
    }
}
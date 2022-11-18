package com.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class FireFernBlock extends DoublePlantBlock {
    public FireFernBlock(Properties properties) {
        super(properties);
    }

    public void animateTick(BlockState blockState, Level level, BlockPos pos, RandomSource randomSource) {
        VoxelShape voxelshape = this.getShape(blockState, level, pos, CollisionContext.empty());
        Vec3 vec3 = voxelshape.bounds().getCenter();
        double d0 = (double)pos.getX() + vec3.x;
        double d1 = (double)pos.getZ() + vec3.z;

        for(int i = 0; i < 3; ++i) {
            if (randomSource.nextBoolean()) {
                level.addParticle(ParticleTypes.FLAME, d0 + randomSource.nextDouble() / 5.0D, (double)pos.getY() + (0.5D - randomSource.nextDouble()), d1 + randomSource.nextDouble() / 5.0D, 0.0D, 0.0D, 0.0D);
            }
        }

    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!entity.isSteppingCarefully() && entity instanceof LivingEntity) {
            entity.setSecondsOnFire(4);
        }
        super.stepOn(level, pos, state, entity);
    }
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos pos) {
        return super.mayPlaceOn(blockState, blockGetter, pos) || blockState.is(Blocks.NETHERRACK) || blockState.is(Blocks.SOUL_SAND) || blockState.is(Blocks.SOUL_SOIL) ||
                blockState.is(Blocks.BASALT) || blockState.is(Blocks.MAGMA_BLOCK) || blockState.is(Blocks.CRIMSON_NYLIUM) || blockState.is(Blocks.WARPED_NYLIUM) || blockState.is(Blocks.BLACKSTONE);
    }
}

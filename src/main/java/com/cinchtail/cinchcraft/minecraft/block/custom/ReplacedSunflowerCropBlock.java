package com.cinchtail.cinchcraft.minecraft.block.custom;

import com.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ReplacedSunflowerCropBlock extends DoublePlantBlock implements BonemealableBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;

    public ReplacedSunflowerCropBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(this.getAgeProperty(), 0));
    }

    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos pos) {
        return blockState.is(BlockTags.DIRT);
    }

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 7;
    }

    protected int getAge(BlockState blockState) {
        return blockState.getValue(this.getAgeProperty());
    }

    public BlockState getStateForAge(int i) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), i);
    }

    public boolean isMaxAge(BlockState blockState) {
        return blockState.getValue(this.getAgeProperty()) < this.getMaxAge();
    }

    public boolean isRandomlyTicking(BlockState blockState) {
        return this.isMaxAge(blockState);
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        if (!serverLevel.isAreaLoaded(pos, 1)) return;
        if (serverLevel.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(blockState);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this, serverLevel, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(serverLevel, pos, blockState, randomSource.nextInt((int)(25.0F / f) + 1) == 0)) {
                    serverLevel.setBlock(pos, this.getStateForAge(i + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(serverLevel, pos, blockState);
                }
            }
        }

    }

    public void growCrops(Level level, BlockPos pos, BlockState blockState) {
        int i = this.getAge(blockState) + this.getBonemealAgeIncrease(level);
        int j = this.getMaxAge();
        if (i > j) {
            i = j;
        }

        level.setBlock(pos, this.getStateForAge(i), 2);
    }

    protected int getBonemealAgeIncrease(Level level) {
        return Mth.nextInt(level.random, 2, 5);
    }

    protected static float getGrowthSpeed(Block block, BlockGetter blockGetter, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockpos = pos.below();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState blockstate = blockGetter.getBlockState(blockpos.offset(i, 0, j));
                if (blockstate.canSustainPlant(blockGetter, blockpos.offset(i, 0, j), net.minecraft.core.Direction.UP,
                        (net.minecraftforge.common.IPlantable) block)) {
                    f1 = 1.0F;
                    if (blockstate.isFertile(blockGetter, pos.offset(i, 0, j))) {
                        f1 = 3.0F;
                    }
                }

                if (i != 0 || j != 0) {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos1 = pos.north();
        BlockPos blockpos2 = pos.south();
        BlockPos blockpos3 = pos.west();
        BlockPos blockpos4 = pos.east();
        boolean flag = blockGetter.getBlockState(blockpos3).is(block) || blockGetter.getBlockState(blockpos4).is(block);
        boolean flag1 = blockGetter.getBlockState(blockpos1).is(block) || blockGetter.getBlockState(blockpos2).is(block);
        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = blockGetter.getBlockState(blockpos3.north()).is(block) || blockGetter.getBlockState(blockpos4.north()).is(block) ||
                    blockGetter.getBlockState(blockpos4.south()).is(block) || blockGetter.getBlockState(blockpos3.south()).is(block);
            if (flag2) {
                f /= 2.0F;
            }
        }

        return f;
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos pos) {
        if (blockState.getValue(HALF) != DoubleBlockHalf.UPPER) {
            return super.canSurvive(blockState, levelReader, pos);
        } else {
            BlockState blockstate = levelReader.getBlockState(pos.below());
            if (blockState.getBlock() != this) return super.canSurvive(blockState, levelReader, pos);
            return blockstate.is(this) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    public void entityInside(BlockState blockState, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof Ravager && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(level, entity)) {
            level.destroyBlock(pos, true, entity);
        }

        super.entityInside(blockState, level, pos, entity);
    }

    protected ItemLike getBaseSeedId() {
        return ModItems.SUNFLOWER_SEEDS.get();
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState blockState) {
        return new ItemStack(this.getBaseSeedId());
    }

    public boolean isValidBonemealTarget(BlockGetter blockGetter, BlockPos pos, BlockState blockState, boolean b) {
        return this.isMaxAge(blockState);
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos pos, BlockState blockState) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos pos, BlockState blockState) {
        this.growCrops(serverLevel, pos, blockState);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(AGE).add(HALF);
    }
}

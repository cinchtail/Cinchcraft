package com.cinchtail.cinchcraft.world.feature;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.block.custom.BlueBerryBushBlock;
import com.cinchtail.cinchcraft.block.custom.IcicleBlock;
import com.cinchtail.cinchcraft.cinchcraft;
import com.google.common.base.Suppliers;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WaterloggedVegetationPatchFeature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_KEY = registerKey("apple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_SPAWN_KEY = registerKey("apple_spawn");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RUBY_ORE_KEY = registerKey("overworld_ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COAL_ORE_KEY = registerKey("nether_coal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_IRON_ORE_KEY = registerKey("nether_iron_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COPPER_ORE_KEY = registerKey("nether_copper_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_LAPIS_LAZULI_ORE_KEY = registerKey("lapis_lazuli_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_REDSTONE_KEY = registerKey("nether_redstone_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_EMERALD_KEY = registerKey("nether_emerald_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_DIAMOND_ORE_KEY = registerKey("nether_diamond_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUTTER_CUP_KEY = registerKey("butter_cup");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CROCUS_KEY = registerKey("crocus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALYSSUM_FIELDS_KEY = registerKey("alyssum_fields");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALYSSUM_KEY = registerKey("alyssum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUBBLE_FLOWER_KEY = registerKey("bubble_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_CACTUS_KEY = registerKey("small_cactus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FIRE_FERN_KEY = registerKey("fire_fern");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBERRIES_KEY = registerKey("blueberries");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINEAPPLE_PLANT_KEY = registerKey("pineapple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRAWBERRY_KEY = registerKey("strawberry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOD_SWEET_BERRIE_KEY = registerKey("mod_sweet_berrie");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ICICLE_KEY = registerKey("icicle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REEDS_KEY = registerKey("reeds");



    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_RUBY_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.RUBY_ORE.get().defaultBlockState()),
            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_RUBY_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.NETHER_RUBY_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_IRON_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.NETHER_IRON_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_COPPER_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.NETHER_COPPER_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_COAL_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.NETHER_COAL_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_LAPIS_LAZULI_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.NETHER_LAPIS_LAZULI_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_REDSTONE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.NETHER_REDSTONE_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_DIAMOND_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.NETHER_DIAMOND_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_EMERALD_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), ModBlocks.NETHER_EMERALD_ORE.get().defaultBlockState())));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

        register(context, APPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.APPLE_LOG.get()),
                new StraightTrunkPlacer(2, 2, 3),
                BlockStateProvider.simple(ModBlocks.APPLE_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 2))
                .dirt(BlockStateProvider.simple(Blocks.DIRT)).build());

        register(context, APPLE_SPAWN_KEY, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                        placedFeatures.getOrThrow(ModPlacedFeatures.APPLE_CHECKED_KEY),
                        0.5F)), placedFeatures.getOrThrow(ModPlacedFeatures.APPLE_CHECKED_KEY)));

        register(context, OVERWORLD_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(OVERWORLD_RUBY_ORES.get(),8));
        register(context, NETHER_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(NETHER_RUBY_ORES.get(),3));
        register(context, NETHER_IRON_ORE_KEY, Feature.ORE, new OreConfiguration(NETHER_IRON_ORES.get(),5));
        register(context, NETHER_COPPER_ORE_KEY, Feature.ORE, new OreConfiguration(NETHER_COPPER_ORES.get(),5));
        register(context, NETHER_COAL_ORE_KEY, Feature.ORE, new OreConfiguration(NETHER_COAL_ORES.get(),4));
        register(context, NETHER_LAPIS_LAZULI_ORE_KEY, Feature.ORE, new OreConfiguration(NETHER_LAPIS_LAZULI_ORES.get(),3));
        register(context, NETHER_REDSTONE_KEY, Feature.ORE, new OreConfiguration(NETHER_REDSTONE_ORES.get(),3));
        register(context, NETHER_EMERALD_KEY, Feature.ORE, new OreConfiguration(NETHER_EMERALD_ORES.get(),3));
        register(context, NETHER_DIAMOND_ORE_KEY, Feature.ORE, new OreConfiguration(NETHER_DIAMOND_ORES.get(),3));

        register(context, BUTTER_CUP_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BUTTER_CUP.get())))));
        register(context, CROCUS_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CROCUS.get())))));
        register(context, ALYSSUM_FIELDS_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(3000, 20, 5, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ALYSSUM.get())))));
        register(context, ALYSSUM_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ALYSSUM.get())))));
        register(context, BUBBLE_FLOWER_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(20, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BUBBLE_FLOWER.get())))));

        register(context, BLUEBERRIES_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUEBERRY_BUSH.get().defaultBlockState().setValue(BlueBerryBushBlock.AGE, 3))))));
        register(context, PINEAPPLE_PLANT_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(15, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINEAPPLE_PLANT.get().defaultBlockState().setValue(BlueBerryBushBlock.AGE, 3))))));
        register(context, STRAWBERRY_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.STRAWBERRY_PLANT.get().defaultBlockState().setValue(BlueBerryBushBlock.AGE, 3))))));
        register(context, MOD_SWEET_BERRIE_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.SWEET_BERRY_BUSH.defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3))))));

        register(context, SMALL_CACTUS_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(10, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SMALL_CACTUS.get())))));
        register(context, FIRE_FERN_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(10, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FIRE_FERN.get())))));
        register(context, REEDS_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(50, 6, 2, PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.REEDS.get().defaultBlockState())))));

        register(context, ICICLE_KEY, Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(1),
                2).add(ConstantInt.of(0), 1).build()), BlockStateProvider.simple(ModBlocks.ICICLE.get().defaultBlockState().setValue(IcicleBlock.TIP_DIRECTION,
                Direction.DOWN).setValue(IcicleBlock.THICKNESS, DripstoneThickness.FRUSTUM))), BlockColumnConfiguration.layer(ConstantInt.of(1),
                BlockStateProvider.simple(ModBlocks.ICICLE.get().defaultBlockState().setValue(IcicleBlock.TIP_DIRECTION, Direction.DOWN)))), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, true));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(cinchcraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register
            (BootstapContext<ConfiguredFeature<?, ?>> context,
             ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

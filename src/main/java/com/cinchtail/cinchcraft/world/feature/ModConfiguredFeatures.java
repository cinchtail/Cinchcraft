package com.cinchtail.cinchcraft.world.feature;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.block.custom.BlueBerryBushBlock;
import com.cinchtail.cinchcraft.cinchcraft;
import com.google.common.base.Suppliers;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, cinchcraft.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_RUBY_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.RUBY_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_RUBY_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_RUBY_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_IRON_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_IRON_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_COPPER_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_COPPER_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_COAL_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_COAL_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_LAPIS_LAZULI_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_LAPIS_LAZULI_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_REDSTONE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_REDSTONE_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_DIAMOND_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_DIAMOND_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> NETHER_EMERALD_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_EMERALD_ORE.get().defaultBlockState())));
    public static final RegistryObject<ConfiguredFeature<?, ?>> RUBY_ORE = CONFIGURED_FEATURE.register("ruby_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_RUBY_ORES.get(),8)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_RUBY_ORE = CONFIGURED_FEATURE.register("nether_ruby_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_RUBY_ORES.get(), 3)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_IRON_ORE = CONFIGURED_FEATURE.register("nether_iron_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_IRON_ORES.get(), 5)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_COPPER_ORE = CONFIGURED_FEATURE.register("nether_copper_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_COPPER_ORES.get(), 5)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_COAL_ORE = CONFIGURED_FEATURE.register("nether_coal_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_COAL_ORES.get(), 4)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_LAPIS_LAZULI_ORE = CONFIGURED_FEATURE.register("nether_lapis_lazuli_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_LAPIS_LAZULI_ORES.get(), 3)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_REDSTONE_ORE = CONFIGURED_FEATURE.register("nether_redstone_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_REDSTONE_ORES.get(), 3)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_DIAMOND_ORE = CONFIGURED_FEATURE.register("nether_diamond_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_DIAMOND_ORES.get(), 3)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> NETHER_EMERALD_ORE = CONFIGURED_FEATURE.register("nether_emerald_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(NETHER_EMERALD_ORES.get(), 3)));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BUTTER_CUP = CONFIGURED_FEATURE.register("butter_cup",
            () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BUTTER_CUP.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> CROCUS = CONFIGURED_FEATURE.register("crocus",
            () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CROCUS.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BLUE_BERRIE = CONFIGURED_FEATURE.register("blue_berrie",
            () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUEBERRY_BUSH.get().defaultBlockState().setValue(BlueBerryBushBlock.AGE, 3)))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> BUBBLE_FLOWER = CONFIGURED_FEATURE.register("bubble_flower",
            () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(20, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BUBBLE_FLOWER.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SMALL_CACTUS = CONFIGURED_FEATURE.register("small_cactus",
            () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(10, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SMALL_CACTUS.get()))))));

    public static final RegistryObject<ConfiguredFeature<?, ?>> APPLE_TREE = CONFIGURED_FEATURE.register("apple_tree", () -> new ConfiguredFeature<>(
                    Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.APPLE_LOG.get()),
                    new StraightTrunkPlacer(2, 2, 3),
                    BlockStateProvider.simple(ModBlocks.APPLE_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                    new TwoLayersFeatureSize(1, 0, 2))
                    .dirt(BlockStateProvider.simple(Blocks.DIRT)).build()));

    public static final Holder<PlacedFeature> APPLE_CHECKED = PlacementUtils.register("apple_checked", APPLE_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.APPLE_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> APPLE_SPAWN =
            FeatureUtils.register("apple_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(APPLE_CHECKED,
                            0.5F)), APPLE_CHECKED));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PINEAPPLE_PLANT = CONFIGURED_FEATURE.register("pineapple_plant",
            () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(15, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINEAPPLE_PLANT.get().defaultBlockState().setValue(BlueBerryBushBlock.AGE, 3)))))));





    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURE.register(eventBus);

    }
}

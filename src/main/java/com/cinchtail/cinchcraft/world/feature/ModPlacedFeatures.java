package com.cinchtail.cinchcraft.world.feature;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.cinchcraft;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, cinchcraft.MOD_ID);

    public static final RegistryObject<PlacedFeature> RUBY_ORE_PLACED = PLACED_FEATURES.register("ruby_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.RUBY_ORE.getHolder().get(),
                    commonOrePlacement(14, // VeinsPerChunk
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(90)))));

    public static final RegistryObject<PlacedFeature> NETHER_RUBY_ORE_PLACED = PLACED_FEATURES.register("nether_ruby_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_RUBY_ORE.getHolder().get(), commonOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> NETHER_IRON_ORE_PLACED = PLACED_FEATURES.register("nether_iron_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_IRON_ORE.getHolder().get(), commonOrePlacement(4, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> NETHER_COPPER_ORE_PLACED = PLACED_FEATURES.register("nether_copper_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_COPPER_ORE.getHolder().get(), commonOrePlacement(4, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> NETHER_COAL_ORE_PLACED = PLACED_FEATURES.register("nether_coal_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_COAL_ORE.getHolder().get(), commonOrePlacement(3, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> NETHER_LAPIS_LAZULI_ORE_PLACED = PLACED_FEATURES.register("nether_lapis_lazuli_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_LAPIS_LAZULI_ORE.getHolder().get(), commonOrePlacement(2, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> NETHER_REDSTONE_ORE_PLACED = PLACED_FEATURES.register("nether_redstone_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_REDSTONE_ORE.getHolder().get(), commonOrePlacement(1, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> NETHER_DIAMOND_ORE_PLACED = PLACED_FEATURES.register("nether_diamond_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_DIAMOND_ORE.getHolder().get(), rareOrePlacement(1, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> NETHER_EMERALD_ORE_PLACED = PLACED_FEATURES.register("nether_emerald_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.NETHER_EMERALD_ORE.getHolder().get(), rareOrePlacement(1, // VeinsPerChunk
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));

    public static final RegistryObject<PlacedFeature> BUTTER_CUP_PLACED = PLACED_FEATURES.register("butter_cup_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BUTTER_CUP.getHolder().get(),
                     List.of(RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> CROCUS_PLACED = PLACED_FEATURES.register("crocus_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.CROCUS.getHolder().get(),
                    List.of(RarityFilter.onAverageOnceEvery(16),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> BLUE_BERRIE_PLACED = PLACED_FEATURES.register("blue_berrie_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BLUE_BERRIE.getHolder().get(),
                     List.of(RarityFilter.onAverageOnceEvery(18),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> BUBBLE_FLOWER_PLACED = PLACED_FEATURES.register("bubble_flower_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.BUBBLE_FLOWER.getHolder().get(),
                     List.of(RarityFilter.onAverageOnceEvery(42),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> SMALL_CACTUS_PLACED = PLACED_FEATURES.register("small_cactus_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SMALL_CACTUS.getHolder().get(),
                    List.of(RarityFilter.onAverageOnceEvery(42),
                            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> PINEAPPLE_PLACED = PLACED_FEATURES.register("pineapple_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.PINEAPPLE_PLANT.getHolder().get(),
                    List.of(RarityFilter.onAverageOnceEvery(24),
                            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> APPLE_TREE_CHECKED = PLACED_FEATURES.register("apple_tree_checked",
            () -> new PlacedFeature(ModConfiguredFeatures.APPLE_TREE.getHolder().get(),
                    List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.APPLE_SAPLING.get()))));

    public static final RegistryObject<PlacedFeature> APPLE_TREE_PLACED = PLACED_FEATURES.register("apple_tree_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.APPLE_TREE_SPAWN.getHolder().get(), VegetationPlacements.treePlacement(
                    RarityFilter.onAverageOnceEvery(48))));

    public static final RegistryObject<PlacedFeature> MOD_SWEET_BERRIE_PLACED = PLACED_FEATURES.register("mod_sweet_berrie_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.MOD_SWEET_BERRIE.getHolder().get(),
                    List.of(RarityFilter.onAverageOnceEvery(18),
                            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> STRAWBERRY_PLACED = PLACED_FEATURES.register("strawberry_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.STRAWBERRY.getHolder().get(),
                    List.of(RarityFilter.onAverageOnceEvery(50),
                            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> FIRE_FERN_PLACED = PLACED_FEATURES.register("fire_fern_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.FIRE_FERN.getHolder().get(),
                    List.of(RarityFilter.onAverageOnceEvery(5),
                            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));



    public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier1) {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier1, BiomeFilter.biome());
    }
    public static List<PlacementModifier> commonOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(i), placementModifier);
    }
    public static List<PlacementModifier> rareOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(i), placementModifier);
    }

    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }



}

package com.cinchtail.cinchcraft.world.biomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.*;


import java.util.List;
import java.util.function.Consumer;


public class CinchcraftRegion extends Region {
    public CinchcraftRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    public static void Region() {
        Regions.register(new CinchcraftRegion(new ResourceLocation("cinchcraft", "overworld"), 4));
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {

            List<Climate.ParameterPoint> mixedForestPoint = new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.COOL, ParameterUtils.Temperature.NEUTRAL))
                    .humidity(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET, ParameterUtils.Humidity.HUMID)
                    .continentalness(Climate.Parameter.span(-0.2F, 1.0F))
                    .erosion(ParameterUtils.Erosion.span(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_4))
                    .depth(ParameterUtils.Depth.SURFACE)
                    .weirdness(ParameterUtils.Weirdness.span(ParameterUtils.Weirdness.LOW_SLICE_NORMAL_DESCENDING, ParameterUtils.Weirdness.LOW_SLICE_VARIANT_ASCENDING))
                    .build();
            mixedForestPoint.forEach(point -> addBiome(mapper, point, CinchcraftBiomes.MIXED_FOREST));
        });
    }
}
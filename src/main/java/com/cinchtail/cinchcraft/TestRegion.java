package com.cinchtail.cinchcraft;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.*;


import java.util.List;
import java.util.function.Consumer;


public class TestRegion extends Region {
    public TestRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            List<Climate.ParameterPoint> iceCavesPoint = new ParameterUtils.ParameterPointListBuilder()
                    .temperature(ParameterUtils.Temperature.ICY)
                    .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.HUMID))
                    .continentalness(ParameterUtils.Continentalness.FULL_RANGE)
                    .erosion(ParameterUtils.Erosion.span(ParameterUtils.Erosion.EROSION_2, ParameterUtils.Erosion.EROSION_6))
                    .depth(ParameterUtils.Depth.UNDERGROUND)
                    .weirdness(ParameterUtils.Weirdness.FULL_RANGE)
                    .build();
            iceCavesPoint.forEach(point -> addBiome(mapper, point, CinchcraftBiomes.ICE_CAVE));
            builder.replaceBiome(Biomes.FOREST, CinchcraftBiomes.MIXED_FOREST);
        });
    }
}
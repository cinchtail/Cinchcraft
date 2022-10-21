package com.cinchtail.cinchcraft;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import org.checkerframework.checker.units.qual.Temperature;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.*;


import java.util.List;
import java.util.function.Consumer;


public class TestRegion extends Region
{
    public TestRegion(ResourceLocation name, int weight)
    {
        super(name, com.ibm.icu.util.Region.RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper)
    {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            // Simple example:
            // Replace the Vanilla desert with our hot_red biome
            builder.replaceBiome(Biomes.DESERT, TestBiomes.HOT_RED);

            // More complex example:
            // Replace specific parameter points for the frozen peaks with our cold_blue biome
            List<Climate.ParameterPoint> frozenPeaksPoints = new ParameterUtils.ParameterPointListBuilder()
                    .temperature(Temperature.ICY, Temperature.COOL, Temperature.NEUTRAL)
                    .humidity(ParameterUtils.Humidity.ARID, ParameterUtils.Humidity.DRY, ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.WET, ParameterUtils.Humidity.HUMID)
                    .continentalness(ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.COAST, ParameterUtils.Continentalness.FAR_INLAND), ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.MID_INLAND, ParameterUtils.Continentalness.FAR_INLAND))
                    .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_1)
                    .depth(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.FLOOR)
                    .weirdness(ParameterUtils.Weirdness.HIGH_SLICE_VARIANT_ASCENDING, ParameterUtils.Weirdness.PEAK_VARIANT, ParameterUtils.Weirdness.HIGH_SLICE_VARIANT_DESCENDING)
                    .build();

            frozenPeaksPoints.forEach(point -> builder.replaceBiome(point, TestBiomes.COLD_BLUE));
        });
    }
}

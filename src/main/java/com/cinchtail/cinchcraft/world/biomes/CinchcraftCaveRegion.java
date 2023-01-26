package com.cinchtail.cinchcraft.world.biomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.Regions;

import java.util.List;
import java.util.function.Consumer;

public class CinchcraftCaveRegion extends Region {
    public CinchcraftCaveRegion(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    public static void Region() {
        Regions.register(new CinchcraftCaveRegion(new ResourceLocation("cinchcraft", "cave"), 6));
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
            List<Climate.ParameterPoint> frozenCavesPoint = new ParameterUtils.ParameterPointListBuilder()
                    .temperature(Climate.Parameter.span(-1.0F, -0.8F))
                    .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.DRY, ParameterUtils.Humidity.HUMID))
                    .continentalness(ParameterUtils.Continentalness.FULL_RANGE)
                    .erosion(ParameterUtils.Erosion.FULL_RANGE)
                    .depth(ParameterUtils.Depth.UNDERGROUND)
                    .weirdness(ParameterUtils.Weirdness.FULL_RANGE)
                    .build();
            frozenCavesPoint.forEach(point -> addBiome(mapper, point, CinchcraftBiomes.ICE_CAVE));
        });
    }
}
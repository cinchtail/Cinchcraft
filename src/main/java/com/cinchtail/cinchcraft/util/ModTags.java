package com.cinchtail.cinchcraft.util;

import com.cinchtail.cinchcraft.Cinchcraft;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Biomes {
        //Geodes
        public static final TagKey<Biome> HAS_FIRE_FERN
                = biomeTag("has_fire_fern");
        private static TagKey<Biome> biomeTag(String name) {
            return TagKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(Cinchcraft.MOD_ID, name));
        }

    }

    public static class Blocks {
        public static final TagKey<Block> EXAMPLE_BLOCK_TAG
                = blockTag("example_block_tag");
        private static TagKey<Block> blockTag(String name) {
            return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Cinchcraft.MOD_ID, name));
        }
    }
}

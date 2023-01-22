package com.cinchtail.cinchcraft.util;

import com.cinchtail.cinchcraft.cinchcraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Biomes {

        public static final TagKey<Biome> HAS_FIRE_FERN
                = biomeTag("has_fire_fern");
        private static TagKey<Biome> biomeTag(String name) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(cinchcraft.MOD_ID, name));
        }
    }
    public static class Blocks {
        public static final TagKey<Block> EXAMPLE_BLOCK_TAG
                = blockTag("example_block_tag");
        private static TagKey<Block> blockTag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(cinchcraft.MOD_ID, name));
        }
    }
}

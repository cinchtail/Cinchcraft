package com.cinchtail.cinchcraft.util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {

    public static final TagKey<Block> REEDS_PLACEABLE = create("reeds_placeable");
    public static final TagKey<Block> APPLE_LOGS = create("apple_logs");

    private ModBlockTags() {
    }

    private static TagKey<Block> create(String s) {
        return TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(s));
    }

    public static TagKey<Block> create(ResourceLocation name) {
        return TagKey.create(Registry.BLOCK_REGISTRY, name);
    }
}

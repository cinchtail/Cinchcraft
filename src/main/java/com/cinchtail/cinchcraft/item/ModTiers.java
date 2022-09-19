package com.cinchtail.cinchcraft.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

import java.util.function.Supplier;

public class ModTiers {
    public static final ForgeTier RUBY = new ForgeTier(2,850,4,2f,10,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.RUBY.get()));
    public static final ForgeTier EMERALD = new ForgeTier(2,300,3,1f,6,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(Items.EMERALD));
    public static final ForgeTier BLACKSTONE = new ForgeTier(1,131,4,1f,5,
            BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(Items.BLACKSTONE));
    public static final ForgeTier DEEPSLATE = new ForgeTier(1,251,4,1f,5,
            BlockTags.NEEDS_STONE_TOOL,
            () -> Ingredient.of(Items.DEEPSLATE));
    }

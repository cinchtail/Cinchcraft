package com.cinchtail.cinchcraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabItems {
    public static final CreativeModeTab CINCHCRAFT_ITEMS_TAB = new CreativeModeTab("cinchcraft_items") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.RUBY.get());
        }
    };
}
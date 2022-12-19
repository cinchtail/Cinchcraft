package com.cinchtail.cinchcraft.item;

import com.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTabBlocks {
    public static final CreativeModeTab CINCHCRAFT_BLOCK_TAB = new CreativeModeTab("cinchcraft_blocks") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.RUBY_ORE.get());
        }
    };
}

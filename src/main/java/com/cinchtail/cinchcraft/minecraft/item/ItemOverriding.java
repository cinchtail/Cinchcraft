package com.cinchtail.cinchcraft.minecraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemOverriding {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            "minecraft");


    public static final RegistryObject<Item> MELON = ITEMS.register("melon",
            () -> new ItemNameBlockItem(Blocks.MELON, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}

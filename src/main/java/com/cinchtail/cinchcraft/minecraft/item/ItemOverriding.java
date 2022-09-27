package com.cinchtail.cinchcraft.minecraft.item;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.item.ModCreativeModeTab;
import com.cinchtail.cinchcraft.item.custom.ModWoodenSlabItem;
import com.cinchtail.cinchcraft.minecraft.item.custom.ReplacedCarrotItem;
import net.minecraft.world.food.FoodProperties;
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

    public static final RegistryObject<Item> CARROT = ITEMS.register("carrot",
            () -> new ReplacedCarrotItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(.6f).build())));

    public static final RegistryObject<Item> STONECUTTER = ITEMS.register("stonecutter",
            () -> new ItemNameBlockItem(Blocks.STONECUTTER,
                    new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}

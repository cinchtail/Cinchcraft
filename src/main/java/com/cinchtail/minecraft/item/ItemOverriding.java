package com.cinchtail.minecraft.item;

import com.cinchtail.minecraft.item.custom.ReplacedCarrotItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemOverriding {
    public static final DeferredRegister<Item> OVERRIDEN_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            "minecraft");

    public static final RegistryObject<Item> CARROT = OVERRIDEN_ITEMS.register("carrot",
            () -> new ReplacedCarrotItem(new Item.Properties().tab(CreativeModeTab.TAB_FOOD)
                    .food(new FoodProperties.Builder().nutrition(3).saturationMod(.6f).build())));

    public static void register(IEventBus modEventBus) {
    }
}

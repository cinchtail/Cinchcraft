package com.cinchtail.cinchcraft.minecraft.item;

import com.cinchtail.cinchcraft.item.ModCreativeModeTab;
import com.cinchtail.cinchcraft.minecraft.item.custom.ReplacedCarrotItem;
import com.cinchtail.cinchcraft.minecraft.item.custom.ReplacedItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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

    public static final RegistryObject<Item> SUNFLOWER = ITEMS.register("sunflower",
            () -> new ReplacedItem(new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB).craftRemainder(Items.YELLOW_DYE)));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}

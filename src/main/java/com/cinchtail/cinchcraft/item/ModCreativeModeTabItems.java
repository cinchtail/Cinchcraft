package com.cinchtail.cinchcraft.item;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.cinchcraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = cinchcraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabItems {
    public static CreativeModeTab CINCHCRAFT_ITEM_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        CINCHCRAFT_ITEM_TAB = event.registerCreativeModeTab(new ResourceLocation(cinchcraft.MOD_ID, "cinchcraft_item_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.RUBY.get())).title(Component.literal("Cinchcraft Item Tab")).build());
    }
}
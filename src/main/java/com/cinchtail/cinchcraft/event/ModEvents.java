package com.cinchtail.cinchcraft.event;

import com.cinchtail.cinchcraft.cinchcraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ModEvents {
    @Mod.EventBusSubscriber(modid = cinchcraft.MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void PlayerRightCLickedBlock(PlayerInteractEvent.RightClickBlock event) {
            ItemStack stack = event.getItemStack();
            if (stack.is(Items.CARROT)) {
                event.setCanceled(true);

            }
        }

    }
}
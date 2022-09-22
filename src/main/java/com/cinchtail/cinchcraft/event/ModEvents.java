package com.cinchtail.cinchcraft.event;

import com.cinchtail.cinchcraft.cinchcraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = cinchcraft.MOD_ID)
    public static class ForgeEvents {

        @SubscribeEvent
        public static void CarrotHandler(PlayerInteractEvent.RightClickBlock event)
        {
            Player player = event.getEntity();
            BlockPos pos = event.getPos();
            Level level = player.level;
            Block block = level.getBlockState(pos).getBlock();
            ItemStack handstack = player.getItemBySlot(EquipmentSlot.MAINHAND);
            if(!player.level.isClientSide() && handstack.getItem() == Items.CARROT) {
                if (block == Blocks.FARMLAND)
                {

                }
            }
        }
        @SubscribeEvent
        public static void MelonShearing(PlayerInteractEvent.RightClickBlock event)
        {
            Player player = event.getEntity();
            BlockPos pos = event.getPos();
            Level level = player.level;
            Block block = level.getBlockState(pos).getBlock();
            ItemStack handstack = player.getItemBySlot(EquipmentSlot.MAINHAND);
            if(!player.level.isClientSide() && handstack.getItem() == Items.SHEARS) {
                if (block == Blocks.MELON)
                {

                }
            }
        }

    }
}
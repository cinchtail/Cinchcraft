package com.cinchtail.cinchcraft.event;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class NoCarrotPlantingHandler {

    public void CarrotHandler(PlayerInteractEvent.RightClickBlock event)
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
    //public static void register(IEventBus eventBus){NoCarrotPlantingHandler.register(eventBus);
    //}
}

package com.cinchtail.cinchcraft.event;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.cinchcraft;
import com.cinchtail.cinchcraft.item.ModItems;
import com.cinchtail.cinchcraft.villager.ModVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = cinchcraft.MOD_ID)
public class WanderingTraderTrades {
    @SubscribeEvent
    public void WanderingTraderTrades(WandererTradesEvent event)
    {
        event.getGenericTrades().add(new BasicItemListing(8, new ItemStack(Items.BUNDLE, 1)
                , 1, 10));
        event.getGenericTrades().add(new BasicItemListing(5, new ItemStack(Items.TADPOLE_BUCKET, 1)
                , 5, 5));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModBlocks.CROCUS.get(), 1)
                , 7, 4));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.SWEET_BERRIES, 3)
                , 7, 3));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.GLOW_BERRIES, 3)
                , 7, 3));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.BLUEBERRIES.get(), 3)
                , 7, 3));
        event.getRareTrades().add(new BasicItemListing(6, new ItemStack(Items.SPYGLASS, 1)
                , 1, 10));
        event.getRareTrades().add(new BasicItemListing(9, new ItemStack(Items.SADDLE, 1)
                , 1, 10));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.GLOW_LICHEN, 2)
                , 5, 5));
        event.getRareTrades().add(new BasicItemListing(1, new ItemStack(ModItems.RUBY.get(), 1)
                , 5, 5));
        event.getRareTrades().add(new BasicItemListing(10, new ItemStack(Items.WITHER_ROSE, 1)
                , 1, 10));
        event.getGenericTrades().add(new BasicItemListing(2, new ItemStack(Items.POWDER_SNOW_BUCKET, 1)
                , 5, 10));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.PAINTING, 1)
                , 5, 10));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.CANDLE, 3)
                , 5, 10));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.SCAFFOLDING, 8)
                , 4, 10));
        event.getRareTrades().add(new BasicItemListing(2, new ItemStack(ModItems.PINEAPPLE.get(), 1)
                , 5, 3));
        event.getGenericTrades().add(new BasicItemListing(2, new ItemStack(ModBlocks.APPLE_SAPLING.get(), 1)
                , 5, 3));
    }
}

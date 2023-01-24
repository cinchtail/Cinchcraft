package com.cinchtail.cinchcraft.item.custom;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

public class SunflowerSeedItem extends Item {
    private final Block block;

    public SunflowerSeedItem(Block block, Item.Properties properties) {
        super(properties);
        this.block = block;
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        return block.asItem().useOn(context);
    }
}
package com.cinchtail.cinchcraft.item.custom;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CarrotSeedItem extends BlockItem {
    public CarrotSeedItem(Block block, Item.Properties properties) {
        super(block, properties);
    }

    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
}

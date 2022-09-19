package com.cinchtail.cinchcraft.block.custom;

import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

import java.util.function.Supplier;

public class ModChestBlock extends ChestBlock {
    public ModChestBlock(Properties properties, Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityTypeSupplier) {
        super(properties, blockEntityTypeSupplier);
    }
}

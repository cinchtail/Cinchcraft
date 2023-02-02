package com.cinchtail.cinchcraft.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class NetherBrickFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public NetherBrickFurnaceBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityType.FURNACE, pos, blockState, RecipeType.SMELTING);

    }

    protected Component getDefaultName() {
        return Component.translatable("container.nether_brick_furnace");
    }

    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        var recipe = level.getRecipeManager().getRecipeFor(RecipeType.SMELTING, inventory, level);
        return new FurnaceMenu(i, inventory, this, this.dataAccess);

    }
}

package com.cinchtail.cinchcraft.minecraft.block;

import com.cinchtail.cinchcraft.item.ModCreativeModeTab;
import com.cinchtail.cinchcraft.item.ModItems;
import com.cinchtail.cinchcraft.minecraft.block.custom.ReplacedCarrotsBlock;
import com.cinchtail.cinchcraft.minecraft.block.custom.ReplacedStonecutterBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlocksOverriding {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");

    public static final RegistryObject<Block> CARROTS = BLOCKS.register("carrots",
            () -> new ReplacedCarrotsBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    public static final RegistryObject<Block> STONECUTTER = BLOCKS.register("stonecutter",
            () -> new ReplacedStonecutterBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.5F)));

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block,
                                                            CreativeModeTab tab) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
}

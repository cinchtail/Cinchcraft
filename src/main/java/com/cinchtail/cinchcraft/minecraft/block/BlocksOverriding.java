package com.cinchtail.cinchcraft.minecraft.block;

import com.cinchtail.cinchcraft.minecraft.block.custom.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlocksOverriding {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");

    public static final RegistryObject<Block> CARROTS = BLOCKS.register("carrots",
            () -> new ReplacedCarrotsBlock(BlockBehaviour.Properties.of(Material.PLANT)
                    .noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    public static final RegistryObject<Block> STONECUTTER = BLOCKS.register("stonecutter",
            () -> new ReplacedStonecutterBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .requiresCorrectToolForDrops().strength(3.5F)));

    public static final RegistryObject<Block> MELON = BLOCKS.register("melon",
            () -> new ReplacedMelonBlock(BlockBehaviour.Properties.of(Material.VEGETABLE,
                    MaterialColor.COLOR_LIGHT_GREEN).strength(1.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> SUNFLOWER = BLOCKS.register("sunflower",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.of(Material.PLANT)
                    .noCollission().instabreak().sound(SoundType.CROP).offsetType(BlockBehaviour.OffsetType.XZ)));

    public static final RegistryObject<Block> SWEET_BERRY_BUSH = BLOCKS.register("sweet_berry_bush",
            () -> new ReplacedSweetBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).randomTicks()
                    .noCollission().sound(SoundType.SWEET_BERRY_BUSH)));

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}

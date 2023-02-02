package com.cinchtail.cinchcraft.block.entity;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.block.custom.NetherBrickFurnaceBlock;
import com.cinchtail.cinchcraft.block.entity.custom.ModSignBlockEntity;
import com.cinchtail.cinchcraft.block.entity.custom.NetherBrickFurnaceBlockEntity;
import com.cinchtail.cinchcraft.cinchcraft;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, cinchcraft.MOD_ID);

    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.APPLE_WALL_SIGN.get(),
                            ModBlocks.APPLE_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<NetherBrickFurnaceBlockEntity>> NETHER_BRICK_FURNACE =
            BLOCK_ENTITIES.register("nether_brick_furnace", () ->
                    BlockEntityType.Builder.of(NetherBrickFurnaceBlockEntity::new,
                            ModBlocks.NETHER_BRICK_FURNACE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
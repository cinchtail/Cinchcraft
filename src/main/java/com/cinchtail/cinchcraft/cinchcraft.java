package com.cinchtail.cinchcraft;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.block.entity.ModBlockEntities;
import com.cinchtail.cinchcraft.block.entity.ModWoodTypes;
import com.cinchtail.cinchcraft.effect.ModEffects;
import com.cinchtail.cinchcraft.event.ModEvents;
import com.cinchtail.cinchcraft.event.WanderingTraderTrades;
import com.cinchtail.cinchcraft.item.ModItems;
import com.cinchtail.cinchcraft.loot.ModLootModifiers;
import com.cinchtail.cinchcraft.minecraft.block.BlocksOverriding;
import com.cinchtail.cinchcraft.potion.ModPotions;
import com.cinchtail.cinchcraft.sound.ModSounds;
import com.cinchtail.cinchcraft.util.BetterBrewingRecipe;
import com.cinchtail.cinchcraft.villager.ModVillagers;
import com.cinchtail.cinchcraft.world.biomemods.ModBiomeModifiers;
import com.cinchtail.cinchcraft.world.feature.ModConfiguredFeatures;
import com.cinchtail.cinchcraft.world.feature.ModPlacedFeatures;
import com.cinchtail.cinchcraft.minecraft.item.ItemOverriding;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import terrablender.api.Regions;

@Mod(cinchcraft.MOD_ID)
public class cinchcraft
{

    public static final String MOD_ID = "cinchcraft";
    private static final Logger LOGGER = LogUtils.getLogger();
    public cinchcraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModBiomes.BIOME_REGISTER.register(modEventBus);
        ModBiomes.registerBiomes();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ItemOverriding.register(modEventBus);
        BlocksOverriding.register(modEventBus);

        ModSounds.register(modEventBus);

        ModPotions.register(modEventBus);
        ModEffects.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModBiomeModifiers.register(modEventBus);
        ModConfiguredFeatures.register(modEventBus);

        ModPlacedFeatures.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(new WanderingTraderTrades());
        MinecraftForge.EVENT_BUS.register(new ModEvents());

        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModVillagers::registerPOIs);

        // Given we only add two biomes, we should keep our weight relatively low.
        Regions.register(new TestRegion(new ResourceLocation(MOD_ID, "overworld"), 1));
    }

    {
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        WoodType.register(ModWoodTypes.APPLE);
        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }




    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = cinchcraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class commonSetup {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BUTTER_CUP.getId(), ModBlocks.POTTED_BUTTER_CUP);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SMALL_ROSE.getId(), ModBlocks.POTTED_SMALL_ROSE);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CROCUS.getId(), ModBlocks.POTTED_CROCUS);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SMALL_CACTUS.getId(), ModBlocks.POTTED_SMALL_CACTUS);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.APPLE_SAPLING.getId(), ModBlocks.POTTED_APPLE_SAPLING);

                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                        Items.GLOW_BERRIES, ModPotions.GLOWING_POTION.get()));
                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                        Items.INK_SAC, ModPotions.BLINDNESS_POTION.get()));
                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_POTION.get(),
                        Items.REDSTONE, ModPotions.GLOWING_POTION_.get()));
                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLINDNESS_POTION.get(),
                        Items.REDSTONE, ModPotions.BLINDNESS_POTION_.get()));

                Sheets.addWoodType(ModWoodTypes.APPLE);

                ModVillagers.registerPOIs();
            });
        }
    }
}

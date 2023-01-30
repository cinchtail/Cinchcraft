package com.cinchtail.cinchcraft;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.block.entity.ModBlockEntities;
import com.cinchtail.cinchcraft.block.entity.ModWoodTypes;
import com.cinchtail.cinchcraft.effect.ModEffects;
import com.cinchtail.cinchcraft.event.ModEvents;
import com.cinchtail.cinchcraft.event.WanderingTraderTrades;
import com.cinchtail.cinchcraft.item.ModCreativeModeTabBlocks;
import com.cinchtail.cinchcraft.item.ModCreativeModeTabItems;
import com.cinchtail.cinchcraft.item.ModItems;
import com.cinchtail.cinchcraft.loot.ModLootModifiers;
import com.cinchtail.cinchcraft.minecraft.block.BlocksOverriding;
import com.cinchtail.cinchcraft.potion.ModPotions;
import com.cinchtail.cinchcraft.sound.ModSounds;
import com.cinchtail.cinchcraft.util.BetterBrewingRecipe;
import com.cinchtail.cinchcraft.villager.ModVillagers;
import com.cinchtail.cinchcraft.world.biomemods.ModBiomeModifiers;
import com.cinchtail.cinchcraft.world.biomes.CinchcraftCaveRegion;
import com.cinchtail.cinchcraft.world.biomes.CinchcraftRegion;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

@Mod(cinchcraft.MOD_ID)
public class cinchcraft
{

    public static final String MOD_ID = "cinchcraft";
    private static final Logger LOGGER = LogUtils.getLogger();
    public cinchcraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        BlocksOverriding.register(modEventBus);

        ModSounds.register(modEventBus);

        ModPotions.register(modEventBus);
        ModEffects.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModBiomeModifiers.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(new WanderingTraderTrades());
        MinecraftForge.EVENT_BUS.register(new ModEvents());

        MinecraftForge.EVENT_BUS.register(this);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModVillagers::registerPOIs);

        CinchcraftCaveRegion.Region();
        CinchcraftRegion.Region();
    }
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
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ALYSSUM.getId(), ModBlocks.POTTED_ALYSSUM);

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
    public void clientSetup(final FMLClientSetupEvent event) {

        WoodType.register(ModWoodTypes.APPLE);
        BlockEntityRenderers.register(ModBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }
    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB) {
            event.accept(ModBlocks.BLOCK_OF_RUBY);
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
            event.accept(ModBlocks.NETHER_COAL_ORE);
            event.accept(ModBlocks.NETHER_COPPER_ORE);
            event.accept(ModBlocks.NETHER_IRON_ORE);
            event.accept(ModBlocks.NETHER_LAPIS_LAZULI_ORE);
            event.accept(ModBlocks.NETHER_EMERALD_ORE);
            event.accept(ModBlocks.NETHER_RUBY_ORE);
            event.accept(ModBlocks.NETHER_DIAMOND_ORE);
            event.accept(ModBlocks.TUFF_STAIRS);
            event.accept(ModBlocks.TUFF_SLAB);
            event.accept(ModBlocks.TUFF_WALL);
            event.accept(ModBlocks.CALCITE_STAIRS);
            event.accept(ModBlocks.CALCITE_SLAB);
            event.accept(ModBlocks.CALCITE_WALL);
            event.accept(ModBlocks.DRIPSTONE_STAIRS);
            event.accept(ModBlocks.DRIPSTONE_SLAB);
            event.accept(ModBlocks.DRIPSTONE_WALL);
            event.accept(ModBlocks.POLISHED_TUFF);
            event.accept(ModBlocks.POLISHED_TUFF_STAIRS);
            event.accept(ModBlocks.POLISHED_TUFF_SLAB);
            event.accept(ModBlocks.POLISHED_TUFF_WALL);
            event.accept(ModBlocks.POLISHED_CALCITE);
            event.accept(ModBlocks.POLISHED_CALCITE_STAIRS);
            event.accept(ModBlocks.POLISHED_CALCITE_SLAB);
            event.accept(ModBlocks.POLISHED_CALCITE_WALL);
            event.accept(ModBlocks.POLISHED_DRIPSTONE_BLOCK);
            event.accept(ModBlocks.POLISHED_DRIPSTONE_STAIRS);
            event.accept(ModBlocks.POLISHED_DRIPSTONE_SLAB);
            event.accept(ModBlocks.POLISHED_DRIPSTONE_WALL);
            event.accept(ModBlocks.CRACKED_STONE_BRICK_STAIRS);
            event.accept(ModBlocks.CRACKED_STONE_BRICK_SLAB);
            event.accept(ModBlocks.CRACKED_STONE_BRICK_WALL);
            event.accept(ModBlocks.QUARTZ_BRICK_STAIRS);
            event.accept(ModBlocks.QUARTZ_BRICK_SLAB);
            event.accept(ModBlocks.QUARTZ_BRICK_WALL);
            event.accept(ModBlocks.CHISELED_END_STONE_BRICKS);
            event.accept(ModBlocks.END_STONE_STAIRS);
            event.accept(ModBlocks.END_STONE_SLAB);
            event.accept(ModBlocks.END_STONE_WALL);
            event.accept(ModBlocks.MOSSY_COBBLED_DEEPSLATE);
            event.accept(ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS);
            event.accept(ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB);
            event.accept(ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_BRICKS);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_BRICK_SLAB);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_BRICK_WALL);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_TILES);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_TILE_STAIRS);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_TILE_SLAB);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_TILE_WALL);
            event.accept(ModBlocks.CHISELED_RED_NETHER_BRICKS);
            event.accept(ModBlocks.CRACKED_RED_NETHER_BRICKS);
            event.accept(ModBlocks.RED_NETHER_BRICK_FENCE);
            event.accept(ModBlocks.MOSSY_NETHER_BRICKS);
            event.accept(ModBlocks.MOSSY_NETHER_BRICK_STAIRS);
            event.accept(ModBlocks.MOSSY_NETHER_BRICK_SLAB);
            event.accept(ModBlocks.MOSSY_NETHER_BRICK_WALL);
            event.accept(ModBlocks.MOSSY_NETHER_BRICK_FENCE);
            event.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS);
            event.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_STAIRS);
            event.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_SLAB);
            event.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_WALL);
            event.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_FENCE);
            event.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICKS);
            event.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICK_STAIRS);
            event.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICK_SLAB);
            event.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICK_WALL);
            event.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICK_FENCE);
            event.accept(ModBlocks.CHISELED_MUD_BRICKS);
            event.accept(ModBlocks.CRACKED_MUD_BRICKS);
            event.accept(ModBlocks.MOSSY_MUD_BRICKS);
            event.accept(ModBlocks.MOSSY_MUD_BRICK_STAIRS);
            event.accept(ModBlocks.MOSSY_MUD_BRICK_SLAB);
            event.accept(ModBlocks.MOSSY_MUD_BRICK_WALL);
            event.accept(ModBlocks.SMOOTH_STONE_STAIRS);
            event.accept(ModBlocks.SMOOTH_STONE_WALL);
            event.accept(ModBlocks.CUT_SANDSTONE_STAIRS);
            event.accept(ModBlocks.CUT_SANDSTONE_WALL);
            event.accept(ModBlocks.CUT_RED_SANDSTONE_STAIRS);
            event.accept(ModBlocks.CUT_RED_SANDSTONE_WALL);
            event.accept(ModBlocks.STONE_WALL);
            event.accept(ModBlocks.POLISHED_GRANITE_WALL);
            event.accept(ModBlocks.POLISHED_ANDESITE_WALL);
            event.accept(ModBlocks.POLISHED_DIORITE_WALL);
            event.accept(ModBlocks.PRISMARINE_BRICK_WALL);
            event.accept(ModBlocks.DARK_PRISMARINE_WALL);
            event.accept(ModBlocks.SMOOTH_SANDSTONE_WALL);
            event.accept(ModBlocks.SMOOTH_RED_SANDSTONE_WALL);
            event.accept(ModBlocks.QUARTZ_WALL);
            event.accept(ModBlocks.SMOOTH_QUARTZ_WALL);
            event.accept(ModBlocks.PURPUR_WALL);
            event.accept(ModItems.APPLE_LOG);
            event.accept(ModItems.APPLE_WOOD);
            event.accept(ModItems.STRIPPED_APPLE_LOG);
            event.accept(ModItems.STRIPPED_APPLE_WOOD);
            event.accept(ModBlocks.APPLE_PLANKS);
            event.accept(ModItems.APPLE_STAIRS);
            event.accept(ModItems.APPLE_SLAB);
            event.accept(ModItems.APPLE_FENCE);
            event.accept(ModItems.APPLE_FENCE_GATE);
            event.accept(ModItems.APPLE_TRAPDOOR);
            event.accept(ModItems.APPLE_DOOR);
            event.accept(ModItems.APPLE_SIGN);
            event.accept(ModItems.APPLE_PRESSURE_PLATE);
            event.accept(ModItems.APPLE_BUTTON);
            event.accept(ModBlocks.OAK_BARREL);
            event.accept(ModBlocks.BIRCH_BARREL);
            event.accept(ModBlocks.APPLE_BARREL);
            event.accept(ModBlocks.DARK_OAK_BARREL);
            event.accept(ModBlocks.ACACIA_BARREL);
            event.accept(ModBlocks.JUNGLE_BARREL);
            event.accept(ModBlocks.MANGROVE_BARREL);
            event.accept(ModBlocks.CRIMSON_BARREL);
            event.accept(ModBlocks.WARPED_BARREL);
            event.accept(ModItems.GLOWSTONE_TORCH);
            event.accept(ModBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE);
            event.accept(ModBlocks.POLISHED_DEEPSLATE_BUTTON);
            event.accept(ModBlocks.IRON_BUTTON);
            event.accept(ModBlocks.GOLD_BUTTON);
            event.accept(ModBlocks.PERMAFROST);
            event.accept(ModBlocks.ICICLE);
            event.accept(ModItems.FIRE_FERN);
            event.accept(ModBlocks.BUBBLE_FLOWER);
            event.accept(ModBlocks.BUTTER_CUP);
            event.accept(ModBlocks.CROCUS);
            event.accept(ModBlocks.ALYSSUM);
            event.accept(ModBlocks.SMALL_ROSE);
            event.accept(ModBlocks.SMALL_CACTUS);
            //event.accept(ModBlocks.REEDS);
            //event.accept(ModItems.STALK);
            event.accept(ModBlocks.NETHER_BRICK_FURNACE);
        }
        if(event.getTab() == ModCreativeModeTabItems.CINCHCRAFT_ITEM_TAB) {
            event.accept(ModItems.RUBY_SWORD);
            event.accept(ModItems.RUBY_PICKAXE);
            event.accept(ModItems.RUBY_AXE);
            event.accept(ModItems.RUBY_SHOVEL);
            event.accept(ModItems.RUBY_HOE);
            event.accept(ModItems.RUBY_HELMET);
            event.accept(ModItems.RUBY_CHESTPLATE);
            event.accept(ModItems.RUBY_LEGGING);
            event.accept(ModItems.RUBY_BOOTS);
            event.accept(ModItems.EMERALD_SWORD);
            event.accept(ModItems.EMERALD_PICKAXE);
            event.accept(ModItems.EMERALD_AXE);
            event.accept(ModItems.EMERALD_SHOVEL);
            event.accept(ModItems.EMERALD_HOE);
            event.accept(ModItems.EMERALD_HELMET);
            event.accept(ModItems.EMERALD_CHESTPLATE);
            event.accept(ModItems.EMERALD_LEGGING);
            event.accept(ModItems.EMERALD_BOOTS);
            event.accept(ModItems.DEEPSLATE_SWORD);
            event.accept(ModItems.DEEPSLATE_PICKAXE);
            event.accept(ModItems.DEEPSLATE_AXE);
            event.accept(ModItems.DEEPSLATE_SHOVEL);
            event.accept(ModItems.DEEPSLATE_HOE);
            event.accept(ModItems.BLACKSTONE_SWORD);
            event.accept(ModItems.BLACKSTONE_PICKAXE);
            event.accept(ModItems.BLACKSTONE_AXE);
            event.accept(ModItems.BLACKSTONE_SHOVEL);
            event.accept(ModItems.BLACKSTONE_HOE);
            event.accept(ModItems.NETHERITE_HORSE_ARMOR);
            event.accept(ModItems.RUBY_HORSE_ARMOR);
            event.accept(ModItems.EMERALD_HORSE_ARMOR);
            event.accept(ModItems.RUBY);
            event.accept(ModItems.COPPER_NUGGET);
            //event.accept(ModItems.COMPOST);
            event.accept(ModItems.CARROT_SEEDS);
            //event.accept(ModItems.SUNFLOWER_SEEDS);
            event.accept(ModItems.CHAINMAIL);
            event.accept(ModItems.BLUEBERRIES);
            event.accept(ModItems.BLUEBERRY_PIE);
            event.accept(ModItems.STRAWBERRIES);
            event.accept(ModItems.PINEAPPLE);
            event.accept(ModItems.VEGETABLE_STEW);
            event.accept(ModItems.NETHER_SALAD);
        }
    }
}

package com.cinchtail.cinchcraft.item;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.cinchcraft;
import com.cinchtail.cinchcraft.item.custom.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, cinchcraft.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> COMPOST = ITEMS.register("compost",
            () -> new CompostItem(new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));


    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> VEGETABLE_STEW = ITEMS.register("vegetable_stew",
            () -> new BowlFoodItem(new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB).stacksTo(1).food(ModFoods.VEGETABLE_STEW)));

    public static final RegistryObject<Item> BLUEBERRIES = ITEMS.register("blueberries",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_BUSH.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)
                            .food(new FoodProperties.Builder().nutrition(8).saturationMod(.3f).build())));

    public static final RegistryObject<Item> BLUEBERRY_PIE = ITEMS.register("blueberry_pie",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)
                    .food(new FoodProperties.Builder().nutrition(8).saturationMod(.3f).build())));

    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModTiers.RUBY,4, -2.4f,
            new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModTiers.RUBY,2, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModTiers.RUBY,6, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModTiers.RUBY,2, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModTiers.RUBY,-2, -.5f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> RUBY_LEGGING = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> EMERALD_SWORD = ITEMS.register("emerald_sword",
            () -> new SwordItem(ModTiers.EMERALD,4, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe",
            () -> new PickaxeItem(ModTiers.EMERALD,2, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> EMERALD_AXE = ITEMS.register("emerald_axe",
            () -> new AxeItem(ModTiers.EMERALD,6, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> EMERALD_SHOVEL = ITEMS.register("emerald_shovel",
            () -> new ShovelItem(ModTiers.EMERALD,2, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> EMERALD_HOE = ITEMS.register("emerald_hoe",
            () -> new HoeItem(ModTiers.EMERALD,-1, -.5f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet",
            () -> new ModArmorItem(ModArmorMaterials.EMERALD, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> EMERALD_LEGGING = ITEMS.register("emerald_leggings",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots",
            () -> new ArmorItem(ModArmorMaterials.EMERALD, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> BLACKSTONE_SWORD = ITEMS.register("blackstone_sword",
            () -> new SwordItem(ModTiers.BLACKSTONE,3, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> BLACKSTONE_PICKAXE = ITEMS.register("blackstone_pickaxe",
            () -> new PickaxeItem(ModTiers.BLACKSTONE,1, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> BLACKSTONE_AXE = ITEMS.register("blackstone_axe",
            () -> new AxeItem(ModTiers.BLACKSTONE,7, -3.2f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> BLACKSTONE_SHOVEL = ITEMS.register("blackstone_shovel",
            () -> new ShovelItem(ModTiers.BLACKSTONE,1, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> BLACKSTONE_HOE = ITEMS.register("blackstone_hoe",
            () -> new HoeItem(ModTiers.BLACKSTONE,-1, -2f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> DEEPSLATE_SWORD = ITEMS.register("deepslate_sword",
            () -> new SwordItem(ModTiers.DEEPSLATE,3, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> DEEPSLATE_PICKAXE = ITEMS.register("deepslate_pickaxe",
            () -> new PickaxeItem(ModTiers.DEEPSLATE,1, -2.8f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> DEEPSLATE_AXE = ITEMS.register("deepslate_axe",
            () -> new AxeItem(ModTiers.DEEPSLATE,7, -3.2f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> DEEPSLATE_SHOVEL = ITEMS.register("deepslate_shovel",
            () -> new ShovelItem(ModTiers.DEEPSLATE,1, -3f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> DEEPSLATE_HOE = ITEMS.register("deepslate_hoe",
            () -> new HoeItem(ModTiers.DEEPSLATE,-1, -2f,
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> NETHERITE_HORSE_ARMOR = ITEMS.register("netherite_horse_armor",
            () -> new HorseArmorItem(14, "netherite",
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB).fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> RUBY_HORSE_ARMOR = ITEMS.register("ruby_horse_armor",
            () -> new HorseArmorItem(8, "ruby",
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB).stacksTo(1)));

    public static final RegistryObject<Item> EMERALD_HORSE_ARMOR = ITEMS.register("emerald_horse_armor",
            () -> new HorseArmorItem(6, "emerald",
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB).stacksTo(1)));

    public static final RegistryObject<Item> CARROT_SEEDS = ITEMS.register("carrot_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_BUSH.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> APPLE_SIGN = ITEMS.register("apple_sign",
            () -> new SignItem(new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB).stacksTo(16),
                    ModBlocks.APPLE_SIGN.get(), ModBlocks.APPLE_WALL_SIGN.get()));

    public static final RegistryObject<Item> CHAINMAIL = ITEMS.register("chainmail",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple",
            () -> new ItemNameBlockItem(ModBlocks.PINEAPPLE_PLANT.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)
                            .food(new FoodProperties.Builder().nutrition(6).saturationMod(0.5F).build())));

    public static final RegistryObject<Item> STALK = ITEMS.register("stalk",
            () -> new StalkItem(ModBlocks.STALK.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> APPLE_LOG = ITEMS.register("apple_log",
            () -> new ModWoodenFullBlockItem(ModBlocks.APPLE_LOG.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> APPLE_WOOD = ITEMS.register("apple_wood",
            () -> new ModWoodenFullBlockItem(ModBlocks.APPLE_WOOD.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> STRIPPED_APPLE_LOG = ITEMS.register("stripped_apple_log",
            () -> new ModWoodenFullBlockItem(ModBlocks.STRIPPED_APPLE_LOG.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> STRIPPED_APPLE_WOOD = ITEMS.register("stripped_apple_wood",
            () -> new ModWoodenFullBlockItem(ModBlocks.STRIPPED_APPLE_WOOD.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> APPLE_STAIRS = ITEMS.register("apple_stairs",
            () -> new ModWoodenFullBlockItem(ModBlocks.APPLE_STAIRS.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> APPLE_SLAB = ITEMS.register("apple_slab",
            () -> new ModWoodenSlabItem(ModBlocks.APPLE_SLAB.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> APPLE_FENCE = ITEMS.register("apple_fence",
            () -> new ModWoodenFullBlockItem(ModBlocks.APPLE_FENCE.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> APPLE_FENCE_GATE = ITEMS.register("apple_fence_gate",
            () -> new ModWoodenFullBlockItem(ModBlocks.APPLE_FENCE_GATE.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> APPLE_BUTTON = ITEMS.register("apple_button",
            () -> new ModWoodenButtonItem(ModBlocks.APPLE_BUTTON.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> APPLE_PRESSURE_PLATE = ITEMS.register("apple_pressure_plate",
            () -> new ModWoodenFullBlockItem(ModBlocks.APPLE_PRESSURE_PLATE.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> OAK_CHEST = ITEMS.register("oak_chest",
            () -> new ModWoodenFullBlockItem(ModBlocks.OAK_CHEST.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static final RegistryObject<Item> GLOWSTONE_TORCH = ITEMS.register("glowstone_torch",
            () -> new ModStandingAndWallBlockItem(ModBlocks.GLOWSTONE_TORCH.get(), ModBlocks.GLOWSTONE_WALL_TORCH.get(),
                    new Item.Properties().tab(ModCreativeModeTab.CINCHCRAFT_TAB)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}




package com.cinchtail.cinchcraft.block;

import com.cinchtail.cinchcraft.block.custom.*;
import com.cinchtail.cinchcraft.block.entity.ModWoodTypes;
import com.cinchtail.cinchcraft.cinchcraft;
import com.cinchtail.cinchcraft.item.ModCreativeModeTabBlocks;
import com.cinchtail.cinchcraft.item.ModItems;
import com.cinchtail.cinchcraft.world.feature.tree.AppleTreeGrower;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, cinchcraft.MOD_ID);

    public static final RegistryObject<Block> BLOCK_OF_RUBY = registerBlock("block_of_ruby",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).strength(5f).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(1, 5)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> NETHER_IRON_ORE = registerBlock("nether_iron_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(0, 3)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> NETHER_COPPER_ORE = registerBlock("nether_copper_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(0, 3)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> NETHER_COAL_ORE = registerBlock("nether_coal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(0, 2)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> NETHER_LAPIS_LAZULI_ORE = registerBlock("nether_lapis_lazuli_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(1, 5)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> NETHER_REDSTONE_ORE = registerBlock("nether_redstone_ore",
            () -> new NetherRedStoneOreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> NETHER_DIAMOND_ORE = registerBlock("nether_diamond_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(2, 5)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> NETHER_EMERALD_ORE = registerBlock("nether_emerald_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(2, 5)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE),
                    UniformInt.of(3, 7)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> SMOOTH_STONE_STAIRS = registerBlock("smooth_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_STONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> SMOOTH_STONE_WALL = registerBlock("smooth_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> STONE_WALL = registerBlock("stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_GRANITE_WALL = registerBlock("polished_granite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_ANDESITE_WALL = registerBlock("polished_andesite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_DIORITE_WALL = registerBlock("polished_diorite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> PRISMARINE_BRICK_WALL = registerBlock("prismarine_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> DARK_PRISMARINE_WALL = registerBlock("dark_prismarine_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CUT_SANDSTONE_WALL = registerBlock("cut_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CUT_SANDSTONE_STAIRS = registerBlock("cut_sandstone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(1f).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_WALL = registerBlock("smooth_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CUT_RED_SANDSTONE_WALL = registerBlock("cut_red_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CUT_RED_SANDSTONE_STAIRS = registerBlock("cut_red_sandstone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_WALL = registerBlock("smooth_red_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> QUARTZ_WALL = registerBlock("quartz_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> SMOOTH_QUARTZ_WALL = registerBlock("smooth_quartz_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> PURPUR_WALL = registerBlock("purpur_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> TUFF_STAIRS = registerBlock("tuff_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> TUFF_SLAB = registerBlock("tuff_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> TUFF_WALL = registerBlock("tuff_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CALCITE_STAIRS = registerBlock("calcite_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CALCITE_SLAB = registerBlock("calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CALCITE_WALL = registerBlock("calcite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> DRIPSTONE_STAIRS = registerBlock("dripstone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> DRIPSTONE_SLAB = registerBlock("dripstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> DRIPSTONE_WALL = registerBlock("dripstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> QUARTZ_BRICK_STAIRS = registerBlock("quartz_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(1f).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> QUARTZ_BRICK_SLAB = registerBlock("quartz_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> QUARTZ_BRICK_WALL = registerBlock("quartz_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> RED_NETHER_BRICK_FENCE = registerBlock("red_nether_brick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_NETHER_BRICKS = registerBlock("mossy_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_NETHER_BRICK_STAIRS = registerBlock("mossy_nether_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_NETHER_BRICK_SLAB = registerBlock("mossy_nether_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_NETHER_BRICK_WALL = registerBlock("mossy_nether_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_NETHER_BRICK_FENCE = registerBlock("mossy_nether_brick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> BUTTER_CUP = registerBlock("butter_cup",
            () -> new FlowerBlock(MobEffects.DARKNESS, 6, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<FlowerPotBlock> POTTED_BUTTER_CUP = BLOCKS.register("potted_butter_cup",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.BUTTER_CUP, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

    public static final RegistryObject<Block> SMALL_ROSE = registerBlock("small_rose",
            () -> new FlowerBlock(MobEffects.HEALTH_BOOST, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<FlowerPotBlock> POTTED_SMALL_ROSE = BLOCKS.register("potted_small_rose",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.SMALL_ROSE, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

    public static final RegistryObject<Block> CROCUS = registerBlock("crocus",
            () -> new FlowerBlock(MobEffects.INVISIBILITY, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<FlowerPotBlock> POTTED_CROCUS = BLOCKS.register("potted_crocus",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.CROCUS, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

    public static final RegistryObject<Block> BUBBLE_FLOWER = registerBlock("bubble_flower",
            () -> new BubbleFlowerBlock(MobEffects.LEVITATION, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> NETHER_BRICK_FURNACE = registerBlock("nether_brick_furnace",
            () -> new NetherBrickFurnaceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CARVED_MELON = registerBlock("carved_melon",
            () -> new CarvedMelonBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN).strength(1f).sound(SoundType.WOOD)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);
    public static final RegistryObject<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush",
            () -> new BlueBerryBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion().sound(SoundType.SWEET_BERRY_BUSH)));

    public static final RegistryObject<Block> REEDS = registerBlock("reeds",
            () -> new ReedsBlock(BlockBehaviour.Properties.copy(Blocks.LILAC).sound(SoundType.SMALL_DRIPLEAF)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> STALK = BLOCKS.register("stalk",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.LILAC)));

    public static final RegistryObject<Block> GOLD_BUTTON = registerBlock("gold_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).noCollission().sound(SoundType.METAL)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> IRON_BUTTON = registerBlock("iron_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).noCollission().sound(SoundType.METAL)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_DEEPSLATE_BUTTON = registerBlock("polished_deepslate_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).noCollission().sound(SoundType.POLISHED_DEEPSLATE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_DEEPLSATE_PRESSURE_PLATE = registerBlock("polished_deepslate_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.POLISHED_DEEPSLATE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> APPLE_LOG = BLOCKS.register("apple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> APPLE_WOOD = BLOCKS.register("apple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_APPLE_LOG = BLOCKS.register("stripped_apple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_APPLE_WOOD = BLOCKS.register("stripped_apple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> APPLE_PLANKS = registerBlock("apple_planks",
            () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> SMALL_CACTUS = registerBlock("small_cactus",
            () -> new SmallCactusBlock(MobEffects.DARKNESS, 0, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<FlowerPotBlock> POTTED_SMALL_CACTUS = BLOCKS.register("potted_small_cactus",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.SMALL_CACTUS, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

    public static final RegistryObject<Block> APPLE_LEAVES = registerBlock("apple_leaves",
            () -> new AppleLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> APPLE_SAPLING = registerBlock("apple_sapling",
            () -> new SaplingBlock(new AppleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<FlowerPotBlock> POTTED_APPLE_SAPLING = BLOCKS.register("potted_apple_sapling",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.SMALL_CACTUS, BlockBehaviour.Properties.copy(Blocks.POTTED_BIRCH_SAPLING)));

    public static final RegistryObject<Block> APPLE_STAIRS = BLOCKS.register("apple_stairs",
            () -> new ModFlammableStairBlock(() -> ModBlocks.APPLE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(1.5f)));

    public static final RegistryObject<Block> APPLE_SLAB = BLOCKS.register("apple_slab",
            () -> new ModFlammableSlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB)
                    .strength(1.5f)));

    public static final RegistryObject<Block> APPLE_FENCE = BLOCKS.register("apple_fence",
            () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.5f).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> APPLE_FENCE_GATE = BLOCKS.register("apple_fence_gate",
            () -> new ModFlammableFenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.5f).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> APPLE_BUTTON = BLOCKS.register("apple_button",
            () -> new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1f).noCollission().sound(SoundType.WOOD)));

    public static final RegistryObject<Block> APPLE_PRESSURE_PLATE = BLOCKS.register("apple_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(1.5f).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> APPLE_WALL_SIGN = BLOCKS.register("apple_wall_sign",
            () -> new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN), ModWoodTypes.APPLE));

    public static final RegistryObject<Block> APPLE_SIGN = BLOCKS.register("apple_sign",
            () -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN), ModWoodTypes.APPLE));

    public static final RegistryObject<Block> CRIMSON_MOSSY_NETHER_BRICKS = registerBlock("crimson_mossy_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> WARPED_MOSSY_NETHER_BRICKS = registerBlock("warped_mossy_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CRIMSON_MOSSY_NETHER_BRICK_STAIRS = registerBlock("crimson_mossy_nether_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CRIMSON_MOSSY_NETHER_BRICK_SLAB = registerBlock("crimson_mossy_nether_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CRIMSON_MOSSY_NETHER_BRICK_WALL = registerBlock("crimson_mossy_nether_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CRIMSON_MOSSY_NETHER_BRICK_FENCE = registerBlock("crimson_mossy_nether_brick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> WARPED_MOSSY_NETHER_BRICK_STAIRS = registerBlock("warped_mossy_nether_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> WARPED_MOSSY_NETHER_BRICK_SLAB = registerBlock("warped_mossy_nether_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> WARPED_MOSSY_NETHER_BRICK_WALL = registerBlock("warped_mossy_nether_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> WARPED_MOSSY_NETHER_BRICK_FENCE = registerBlock("warped_mossy_nether_brick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CRACKED_RED_NETHER_BRICKS = registerBlock("cracked_red_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CHISELED_RED_NETHER_BRICKS = registerBlock("chiseled_red_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> PINEAPPLE_PLANT = BLOCKS.register("pineapple_plant",
            () -> new PineapplePlantBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion().sound(SoundType.CROP)));

    public static final RegistryObject<Block> OAK_BARREL = registerBlock("oak_barrel",
            () -> new ModBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5f).sound(SoundType.WOOD)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> BIRCH_BARREL = registerBlock("birch_barrel",
            () -> new ModBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5f).sound(SoundType.WOOD)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> DARK_OAK_BARREL = registerBlock("dark_oak_barrel",
            () -> new ModBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5f).sound(SoundType.WOOD)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> JUNGLE_BARREL = registerBlock("jungle_barrel",
            () -> new ModBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5f).sound(SoundType.WOOD)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> ACACIA_BARREL = registerBlock("acacia_barrel",
            () -> new ModBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5f).sound(SoundType.WOOD)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MANGROVE_BARREL = registerBlock("mangrove_barrel",
            () -> new ModBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5f).sound(SoundType.WOOD)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> APPLE_BARREL = registerBlock("apple_barrel",
            () -> new ModBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5f).sound(SoundType.WOOD)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CRIMSON_BARREL = registerBlock("crimson_barrel",
            () -> new ModBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5f).sound(SoundType.WOOD)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> WARPED_BARREL = registerBlock("warped_barrel",
            () -> new ModBarrelBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.5f).sound(SoundType.WOOD)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> GLOWSTONE_TORCH = BLOCKS.register("glowstone_torch",
            () -> new GlowStoneTorchBlock(BlockBehaviour.Properties.copy(Blocks.TORCH)
                    .noOcclusion().sound(SoundType.WOOD).instabreak().lightLevel((blockState) -> 9).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> GLOWSTONE_WALL_TORCH = BLOCKS.register("glowstone_wall_torch",
            () -> new GlowStoneWallTorchBlock(BlockBehaviour.Properties.copy(Blocks.TORCH)
                    .noOcclusion().sound(SoundType.WOOD).instabreak().lightLevel((blockState) -> 9).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> POLISHED_TUFF = registerBlock("polished_tuff",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).sound(SoundType.TUFF).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_TUFF_STAIRS = registerBlock("polished_tuff_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_TUFF_SLAB = registerBlock("polished_tuff_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_TUFF_WALL = registerBlock("polished_tuff_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_CALCITE = registerBlock("polished_calcite",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1f).sound(SoundType.CALCITE).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_CALCITE_STAIRS = registerBlock("polished_calcite_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_CALCITE_SLAB = registerBlock("polished_calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_CALCITE_WALL = registerBlock("polished_calcite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_DRIPSTONE_BLOCK = registerBlock("polished_dripstone_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_DRIPSTONE_STAIRS = registerBlock("polished_dripstone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_DRIPSTONE_SLAB = registerBlock("polished_dripstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> POLISHED_DRIPSTONE_WALL = registerBlock("polished_dripstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> CHISELED_MUD_BRICKS = registerBlock("chiseled_mud_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f).sound(SoundType.MUD_BRICKS).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_COBBLED_DEEPSLATE = registerBlock("mossy_cobbled_deepslate",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.5f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_COBBLED_DEEPSLATE_STAIRS = registerBlock("mossy_cobbled_deepslate_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_COBBLED_DEEPSLATE_SLAB = registerBlock("mossy_cobbled_deepslate_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_COBBLED_DEEPSLATE_WALL = registerBlock("mossy_cobbled_deepslate_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_DEEPSLATE_BRICKS = registerBlock("mossy_deepslate_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.5f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_DEEPSLATE_BRICK_STAIRS = registerBlock("mossy_deepslate_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_DEEPSLATE_BRICK_SLAB = registerBlock("mossy_deepslate_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_DEEPSLATE_BRICK_WALL = registerBlock("mossy_deepslate_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_DEEPSLATE_TILES = registerBlock("mossy_deepslate_tiles",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.5f).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_DEEPSLATE_TILE_STAIRS = registerBlock("mossy_deepslate_tile_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_DEEPSLATE_TILE_SLAB = registerBlock("mossy_deepslate_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_DEEPSLATE_TILE_WALL = registerBlock("mossy_deepslate_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> APPLE_TRAPDOOR = BLOCKS.register("apple_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(3.0F)
                    .sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<Block> APPLE_DOOR = BLOCKS.register("apple_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(3.0F)
                    .sound(SoundType.WOOD).noOcclusion()));

    public static final RegistryObject<Block> COPPER_BUTTON = BLOCKS.register("copper_button",
            () -> new CopperButtonBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of(Material.METAL,
                    MaterialColor.COLOR_ORANGE).strength(1f).sound(SoundType.COPPER)));

    public static final RegistryObject<Block> EXPOSED_COPPER_BUTTON = BLOCKS.register("exposed_copper_button",
            () -> new CopperButtonBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of(Material.METAL,
                    MaterialColor.TERRACOTTA_LIGHT_GRAY).strength(1f).sound(SoundType.COPPER)));

    public static final RegistryObject<Block> WEATHERED_COPPER_BUTTON = BLOCKS.register("weathered_copper_button",
            () -> new CopperButtonBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of(Material.METAL,
                    MaterialColor.WARPED_STEM).strength(1f).sound(SoundType.COPPER)));

    public static final RegistryObject<Block> OXIDIZED_COPPER_BUTTON = BLOCKS.register("oxidized_copper_button",
            () -> new CopperButtonBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of(Material.METAL,
                    MaterialColor.WARPED_NYLIUM).strength(1f).sound(SoundType.COPPER)));

    public static final RegistryObject<Block> WAXED_COPPER_BUTTON = registerBlock("waxed_copper_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).noCollission().sound(SoundType.COPPER)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_BUTTON = registerBlock("waxed_exposed_copper_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).noCollission().sound(SoundType.COPPER)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> WAXED_WEATHERED_BUTTON = registerBlock("waxed_weathered_copper_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).noCollission().sound(SoundType.COPPER)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> WAXED_OXIDIZED_BUTTON = registerBlock("waxed_oxidized_copper_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).noCollission().sound(SoundType.COPPER)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> STRAWBERRY_PLANT = BLOCKS.register("strawberry_plant",
            () -> new StrawberryPlantBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion().sound(SoundType.CROP)));

    public static final RegistryObject<Block> FIRE_FERN = BLOCKS.register("fire_fern",
            () -> new FireFernBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak()
                    .sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));

    public static final RegistryObject<Block> CRACKED_MUD_BRICKS = registerBlock("cracked_mud_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f).sound(SoundType.MUD_BRICKS).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_MUD_BRICKS = registerBlock("mossy_mud_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f).sound(SoundType.MUD_BRICKS).requiresCorrectToolForDrops()),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_MUD_BRICK_STAIRS = registerBlock("mossy_mud_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_MUD_BRICK_SLAB = registerBlock("mossy_mud_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> MOSSY_MUD_BRICK_WALL = registerBlock("mossy_mud_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)), ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);

    public static final RegistryObject<Block> PERMAFROST = registerBlock("permafrost",
            () -> new Block(BlockBehaviour.Properties.of(Material.ICE).strength(.9f).sound(SoundType.GRAVEL)),
            ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block,
                                                            CreativeModeTab tab) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

   /* @Mod.EventBusSubscriber(value = Dist.CLIENT, modid = cinchcraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    private static class ClientHandler {

        private static final ColorResolver COLOR_RESOLVER = (biome, x, z) -> biome.getFoliageColor();

        @SubscribeEvent
        static void registerColorResolver(RegisterColorHandlersEvent.ColorResolvers event) {
            event.register(COLOR_RESOLVER);
        }

        @SubscribeEvent
        static void registerBlockColor(RegisterColorHandlersEvent.Block event) {
            event.register(((state, btGetter, pos, tintIndex) -> btGetter == null || pos == null ? 0 : btGetter.getBlockTint(pos, COLOR_RESOLVER)), APPLE_LEAVES.get());
        }
    }*/
    private static ToIntFunction<BlockState> litBlockEmission(int i) {
        return (blockState) -> {
            return blockState.getValue(BlockStateProperties.LIT) ? i : 0;
        };
    }
}

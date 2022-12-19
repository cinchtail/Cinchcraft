package com.cinchtail.cinchcraft.villager;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.cinchcraft;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;



public class ModVillagers {
    public static DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, cinchcraft.MOD_ID);
    public static DeferredRegister<VillagerProfession> VILLAGER_PROFFESIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, cinchcraft.MOD_ID);

    public static final RegistryObject<PoiType> SMALL_ROSE_POI = POI_TYPES.register("small_rose_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.SMALL_ROSE.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<VillagerProfession> BEE_KEEPER = VILLAGER_PROFFESIONS.register("bee_keeper",
            () -> new VillagerProfession("bee_keeper", x -> x.get() == SMALL_ROSE_POI.get(),
                    x -> x.get() == SMALL_ROSE_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.BEEHIVE_SHEAR));

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, SMALL_ROSE_POI);
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFFESIONS.register(eventBus);
    }
}

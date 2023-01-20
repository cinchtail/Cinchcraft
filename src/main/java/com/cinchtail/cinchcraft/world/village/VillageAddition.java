package com.cinchtail.cinchcraft.world.village;

import com.cinchtail.cinchcraft.cinchcraft;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = cinchcraft.MOD_ID)
public class VillageAddition {
    private static final ResourceKey<StructureProcessorList> EMPTY_PROCESSOR_LIST_KEY = ResourceKey.create(
            Registries.PROCESSOR_LIST, new ResourceLocation("minecraft", "empty"));

    /**
     * Adds the building to the targeted pool.
     * We will call this in addNewVillageBuilding method further down to add to every village.
     * <p>
     * Note: This is an additive operation which means multiple mods can do this and they stack with each other safely.
     */
    private static void addBuildingToPool(Registry<StructureTemplatePool> templatePoolRegistry,
                                          Registry<StructureProcessorList> processorListRegistry,
                                          ResourceLocation poolRL,
                                          String nbtPieceRL,
                                          int weight) {

        Holder<StructureProcessorList> emptyProcessorList = processorListRegistry.getHolderOrThrow(EMPTY_PROCESSOR_LIST_KEY);

        StructureTemplatePool pool = templatePoolRegistry.get(poolRL);
        if (pool == null) return;

        SinglePoolElement piece = SinglePoolElement.legacy(nbtPieceRL,
                emptyProcessorList).apply(StructureTemplatePool.Projection.RIGID);

        for (int i = 0; i < weight; i++) {
            pool.templates.add(piece);
        }

        List<Pair<StructurePoolElement, Integer>> listOfPieceEntries = new ArrayList<>(pool.rawTemplates);
        listOfPieceEntries.add(new Pair<>(piece, weight));
        pool.rawTemplates = listOfPieceEntries;
    }

    /**
     * We use FMLServerAboutToStartEvent as the dynamic registry exists now and all JSON worldgen files were parsed.
     * Mod compat is best done here.
     */
    @SubscribeEvent
    public static void addNewVillageBuilding(final ServerAboutToStartEvent event) {
        Registry<StructureTemplatePool> templatePoolRegistry = event.getServer().registryAccess().registry(Registries.TEMPLATE_POOL).orElseThrow();
        Registry<StructureProcessorList> processorListRegistry = event.getServer().registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();

        addBuildingToPool(templatePoolRegistry, processorListRegistry,
                new ResourceLocation("minecraft:village/plains/houses"),
                "cinchcraft:plains_bee_keeper_house", 15);

        addBuildingToPool(templatePoolRegistry, processorListRegistry,
                new ResourceLocation("minecraft:village/savanna/houses"),
                "cinchcraft:savanna_weaponsmith_is_to_rare", 20);

        addBuildingToPool(templatePoolRegistry, processorListRegistry,
                new ResourceLocation("minecraft:village/taiga/houses"),
                "cinchcraft:taiga_bee_keeper_house", 100);

    }
}

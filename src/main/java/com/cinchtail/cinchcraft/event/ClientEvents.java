package com.cinchtail.cinchcraft.event;

import com.cinchtail.cinchcraft.cinchcraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = cinchcraft.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

    }
}
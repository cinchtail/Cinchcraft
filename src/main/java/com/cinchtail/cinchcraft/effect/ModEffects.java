package com.cinchtail.cinchcraft.effect;

import com.cinchtail.cinchcraft.cinchcraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
    = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, cinchcraft.MOD_ID);

    public static final RegistryObject<MobEffect> SHINNY_AND_GREEN = MOB_EFFECTS.register("shinny_and_green",
            () -> new ShinnyAndGreenEffect(MobEffectCategory.BENEFICIAL, 3124687));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}

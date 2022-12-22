package com.cinchtail.cinchcraft.sound;

import com.cinchtail.cinchcraft.cinchcraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, cinchcraft.MOD_ID);


    //private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        //return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(cinchcraft.MOD_ID, name )));
    //}

    public  static  void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}

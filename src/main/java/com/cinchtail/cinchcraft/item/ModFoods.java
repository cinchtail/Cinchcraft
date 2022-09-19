package com.cinchtail.cinchcraft.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    static final FoodProperties VEGETABLE_STEW = stew(6).build();
    static final FoodProperties BLUEBERRIES = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
    static final FoodProperties BLUEBERRY_PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.3F).build();
    static final FoodProperties PINEAPPLE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.5F).build();

    private static FoodProperties.Builder stew(int i) {
        return (new FoodProperties.Builder()).nutrition(i).saturationMod(0.6F);
    }
}


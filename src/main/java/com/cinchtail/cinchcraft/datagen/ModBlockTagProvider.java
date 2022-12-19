package com.cinchtail.cinchcraft.datagen;

import com.cinchtail.cinchcraft.Cinchcraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Cinchcraft.MOD_ID, exFileHelper);
    }

    protected void addTags() {
        //this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add();
    }
}


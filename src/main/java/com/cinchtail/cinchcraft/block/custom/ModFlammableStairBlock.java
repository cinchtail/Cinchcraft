package com.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ModFlammableStairBlock extends StairBlock {
    private static boolean isFlammable;
    private static int flammability;
    private static int fireSpreadSpeed;

    /** Tip: If you expand the constructor you can hand over the <p>
     *  3 parameters as individual values for each block if you want <p>
     *  That's interesting if you have wood types with different hardness <p><p>
     *  OK, the boolean isFlammable is a bit sinn free. If the block isn't <p>
     *  flammable you don't need a FlammableBlock class... ;) </p>*/

    public ModFlammableStairBlock(Supplier<BlockState> state, Properties properties,
                                  boolean isFlammable, int flammability, int fireSpreadSpeed) {
        super(state, properties);

        ModFlammableStairBlock.isFlammable = isFlammable;
        ModFlammableStairBlock.flammability = flammability;
        ModFlammableStairBlock.fireSpreadSpeed = fireSpreadSpeed;
    }
    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return  isFlammable; // return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return flammability; // return 20;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return fireSpreadSpeed; //return 5;
    }
}

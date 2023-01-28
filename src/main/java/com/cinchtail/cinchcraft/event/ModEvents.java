package com.cinchtail.cinchcraft.event;

import com.cinchtail.cinchcraft.block.ModBlocks;
import com.cinchtail.cinchcraft.cinchcraft;
import com.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraft.world.level.block.SweetBerryBushBlock.AGE;


public class ModEvents {
    @Mod.EventBusSubscriber(modid = cinchcraft.MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void CancelCarrotPlanting(PlayerInteractEvent.RightClickBlock event) {
            ItemStack stack = event.getItemStack();
            if (stack.is(Items.CARROT)) {
                event.setCanceled(true);
            }
        }
        /*@SubscribeEvent
        public static void CancelSunflowerPlacing(PlayerInteractEvent.RightClickBlock event) {
            ItemStack stack = event.getItemStack();
            if (stack.is(Items.SUNFLOWER)) {
                event.setCanceled(true);
            }
        }*/
        /*@SubscribeEvent
        public static InteractionResult MelonShearing(PlayerInteractEvent.RightClickBlock event, BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
            ItemStack itemstack = player.getItemInHand(interactionHand);
            if (itemstack.canPerformAction(net.minecraftforge.common.ToolActions.SHEARS_CARVE)) {
                if (!level.isClientSide) {
                    Direction direction = blockHitResult.getDirection();
                    Direction direction1 = direction.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : direction;
                    level.playSound((Player) null, pos, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.setBlock(pos, ModBlocks.CARVED_MELON.get().defaultBlockState().setValue(CarvedPumpkinBlock.FACING, direction1), 11);
                    ItemEntity itementity = new ItemEntity(level, (double) pos.getX() + 0.5D + (double) direction1.getStepX() * 0.65D, (double) pos.getY() + 0.1D, (double) pos.getZ() + 0.5D + (double) direction1.getStepZ() * 0.65D, new ItemStack(Items.MELON_SEEDS, 4));
                    itementity.setDeltaMovement(0.05D * (double) direction1.getStepX() + level.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double) direction1.getStepZ() + level.random.nextDouble() * 0.02D);
                    level.addFreshEntity(itementity);
                    itemstack.hurtAndBreak(1, player, (p_55287_) -> {
                        p_55287_.broadcastBreakEvent(interactionHand);
                    });
                    level.gameEvent(player, GameEvent.SHEAR, pos);
                    player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
            return null;
        }*/
        /*@SubscribeEvent
        public static void CompostSweetBerryFix(PlayerInteractEvent.RightClickBlock event) {
            ItemStack stack = ((LivingEntity) eventEntity).getMainHandItem();
            int i = blockState.getValue(AGE);
            boolean flag = i == 3;
            if (stack.is(ModItems.COMPOST.get())) {
                if (flag && player.getItemInHand(interactionHand).is(ModItems.COMPOST.get())) {
                    event.setCanceled(true);
                }
            }
        }*/
    }
}
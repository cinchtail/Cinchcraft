package com.cinchtail.cinchcraft.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;

public class ShinnyAndGreenEffect extends MobEffect {
    public ShinnyAndGreenEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
    protected MerchantOffers offers;
    protected void updateTrades() {
    }
    public void applyEffectTick(Player b, LivingEntity pLivingEntity, int pAmplifier) {
        if (!pLivingEntity.level.isClientSide()) {
            MobEffectInstance mobeffectinstance = b.getEffect(ModEffects.SHINNY_AND_GREEN.get());
            assert mobeffectinstance != null;
            int k = mobeffectinstance.getAmplifier();
            for (MerchantOffer merchantoffer1 : this.getOffers()) {
                double d0 = 0.3D + 0.0625D * (double) k;
                int j = (int) Math.floor(d0 * (double) merchantoffer1.getBaseCostA().getCount());
                merchantoffer1.addToSpecialPriceDiff(-Math.max(j, 1));
            }
            super.applyEffectTick(pLivingEntity, pAmplifier);
        }
    }

    public MerchantOffers getOffers() {
        if (this.offers == null) {
            this.offers = new MerchantOffers();
            this.updateTrades();
        }

        return this.offers;
    }
    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}

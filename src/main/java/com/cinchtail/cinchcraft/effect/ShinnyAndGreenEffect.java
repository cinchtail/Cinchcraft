package com.cinchtail.cinchcraft.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;

public class ShinnyAndGreenEffect extends MobEffect {
    protected ShinnyAndGreenEffect(MobEffectCategory mobEffectCategory, int i) {
        super(mobEffectCategory, i);
    }
    protected MerchantOffers offers;

    protected void updateTrades() {

    }

    public MerchantOffers getOffers() {
        if (this.offers == null) {
            this.offers = new MerchantOffers();
            this.updateTrades();
        }

        return this.offers;
    }

    public void applyEffectTick(Player b) {
        if (b.hasEffect(ModEffects.SHINNY_AND_GREEN.get())) {
            MobEffectInstance mobeffectinstance = b.getEffect(ModEffects.SHINNY_AND_GREEN.get());
            assert mobeffectinstance != null;
            int k = mobeffectinstance.getAmplifier();

            for(MerchantOffer merchantoffer1 : this.getOffers()) {
                double d0 = 0.3D + 0.0625D * (double)k;
                int j = (int)Math.floor(d0 * (double)merchantoffer1.getBaseCostA().getCount());
                merchantoffer1.addToSpecialPriceDiff(-Math.max(j, 1));
            }
        }

    }
    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return true;
    }
}

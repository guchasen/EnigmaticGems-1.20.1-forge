package com.guchasen.enigmaticgems.items.gems;

import com.guchasen.enigmaticgems.items.BaseGemItem;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BigRedGeM extends BaseGemItem {
    public BigRedGeM(Properties pProperties) {
        super(pProperties);
    }

    public BigRedGeM(Properties pProperties, MobEffect effect) {
        super(pProperties, effect);
    }
    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        //super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if(!pLevel.isClientSide() && pEntity instanceof Player player){
            if(pSlotId >= 0 && pSlotId < 9){
                if (!player.hasEffect(MobEffects.REGENERATION) || player.getEffect(MobEffects.REGENERATION).getDuration() <= 200) {
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 2, false, false, true));
                }
            }
        }
    }
}

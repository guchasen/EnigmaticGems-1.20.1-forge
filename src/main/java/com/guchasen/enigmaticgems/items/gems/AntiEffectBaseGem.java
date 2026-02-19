package com.guchasen.enigmaticgems.items.gems;

import com.guchasen.enigmaticgems.items.BaseGemItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntiEffectBaseGem extends BaseGemItem {
    public AntiEffectBaseGem(Properties pProperties) {
        super(pProperties);
    }

    public AntiEffectBaseGem(Properties pProperties, MobEffect effect) {
        super(pProperties, effect);
    }
    public boolean isEffectApplicable = true;

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if(!pLevel.isClientSide() && pEntity instanceof Player player){
            if((pSlotId >= 0 && pSlotId < 9) && player.hasEffect( effect)){
                player.removeEffect(effect);
            }
        }
    }
}

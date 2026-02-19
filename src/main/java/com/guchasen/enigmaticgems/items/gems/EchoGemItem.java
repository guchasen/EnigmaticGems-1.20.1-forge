package com.guchasen.enigmaticgems.items.gems;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class EchoGemItem extends AntiEffectBaseGem {
    public EchoGemItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        tooltip.add(Component.translatable("item.enigmatic_gems.echo_gem.desc1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("item.enigmatic_gems.echo_gem.desc2").withStyle(ChatFormatting.GRAY));

    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        //super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if(!pLevel.isClientSide() && pEntity instanceof Player player){
            if(pSlotId >= 0 && pSlotId < 9){
                if (player.hasEffect(MobEffects.DARKNESS)) {
                    player.removeEffect(MobEffects.DARKNESS);
                }
                if (!player.hasEffect(MobEffects.DAMAGE_RESISTANCE) || (player.getEffect(MobEffects.DAMAGE_RESISTANCE).getDuration() <= 40)){
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200, 1, false, false, true));
                }
            }
        }
    }
}
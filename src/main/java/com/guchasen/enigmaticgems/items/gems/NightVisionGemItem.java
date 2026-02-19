package com.guchasen.enigmaticgems.items.gems;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class NightVisionGemItem extends Item {
    public NightVisionGemItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        tooltip.add(Component.translatable("item.enigmatic_gems.night_vision_gem.desc1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("item.enigmatic_gems.night_vision_gem.desc2").withStyle(ChatFormatting.GRAY));

    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if(!pLevel.isClientSide() && pEntity instanceof Player player){
            if(pSlotId >= 0 && pSlotId < 9){
                if (!player.hasEffect(MobEffects.NIGHT_VISION) || player.getEffect(MobEffects.NIGHT_VISION).getDuration() <= 300) {
                    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0, false, false, true));
                }
            }
        }
    }
}
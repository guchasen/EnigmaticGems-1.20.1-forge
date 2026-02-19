package com.guchasen.enigmaticgems.items.gems;


import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class AntiPoisonGemItem extends AntiEffectBaseGem {

    public AntiPoisonGemItem(Properties properties, MobEffect effect) {
        super(properties, effect);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        tooltip.add(Component.translatable("item.enigmatic_gems.anti_poison_gem.desc1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("item.enigmatic_gems.anti_poison_gem.desc2").withStyle(ChatFormatting.GRAY));

    }

}
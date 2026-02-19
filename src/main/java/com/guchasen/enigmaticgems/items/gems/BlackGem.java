package com.guchasen.enigmaticgems.items.gems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BlackGem extends AntiEffectBaseGem {


    public BlackGem(Properties pProperties, MobEffect effect) {
        super(pProperties, effect);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        tooltip.add(Component.translatable("tooltip.enigmatic_gems.black_gem.des1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("tooltip.enigmatic_gems.black_gem.des2").withStyle(ChatFormatting.GRAY));
    }

}

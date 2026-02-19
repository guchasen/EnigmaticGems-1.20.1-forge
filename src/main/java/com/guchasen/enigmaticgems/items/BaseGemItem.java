package com.guchasen.enigmaticgems.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BaseGemItem extends Item {
    public MobEffect effect;
    public BaseGemItem(Properties pProperties) {
        super(pProperties);
    }
    public BaseGemItem(Properties pProperties, MobEffect effect) {
        super(pProperties);
        this.effect = effect;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if(!pLevel.isClientSide() && pEntity instanceof Player player){
            if(pSlotId >= 0 && pSlotId < 9){
                //if(effect == null) return;
                if(!player.hasEffect(effect) || player.getEffect(effect).getDuration() <= 40){
                    player.addEffect(new MobEffectInstance(effect, 200, 0, false, false, true));
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @javax.annotation.Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        // 添加物品描述信息
        tooltip.add(Component.literal(""));

    }
}

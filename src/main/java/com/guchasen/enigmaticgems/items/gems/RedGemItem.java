package com.guchasen.enigmaticgems.items.gems;

import com.guchasen.enigmaticgems.items.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class RedGemItem extends Item {
    public RedGemItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        tooltip.add(Component.translatable("item.enigmatic_gems.red_gem.desc1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("item.enigmatic_gems.red_gem.desc2").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        //super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        Inventory inventory = ((Player) pEntity).getInventory();
        for(int i = 0; i < 9; i++){
            ItemStack stack = inventory.getItem(i);
            if(stack.is(ModItems.BIG_RED_GEM.get())){return;}
        }
        if(!pLevel.isClientSide() && pEntity instanceof Player player){
            if(pSlotId >= 0 && pSlotId < 9){
                if (!player.hasEffect(MobEffects.REGENERATION) || player.getEffect(MobEffects.REGENERATION).getDuration() <= 200) {
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 400, 0, false, false, true));
                }
            }
        }
    }
}
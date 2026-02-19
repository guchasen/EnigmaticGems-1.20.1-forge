package com.guchasen.enigmaticgems.items.gems;

import com.guchasen.enigmaticgems.items.BaseGemItem;
import com.guchasen.enigmaticgems.items.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import java.util.List;

public class StalwartGemItem extends BaseGemItem {
    public StalwartGemItem(Properties properties, MobEffect effect) {
        super(properties, effect);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);
        tooltip.add(Component.translatable("item.enigmatic_gems.stalwart_gem.desc1").withStyle(ChatFormatting.GRAY));
        tooltip.add(Component.translatable("item.enigmatic_gems.stalwart_gem.desc2").withStyle(ChatFormatting.GRAY));
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        Inventory inventory = ((Player) pEntity).getInventory();
        for (int i = 0; i < 9; i++){
            if (inventory.getItem(i).is(ModItems.ECHO_GEM.get()))
                return;
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }
}
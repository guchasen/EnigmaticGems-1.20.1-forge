package com.guchasen.enigmaticgems.events;

import com.guchasen.enigmaticgems.EnigmaticGems;
import com.guchasen.enigmaticgems.items.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;

import java.util.Random;

@Mod.EventBusSubscriber(modid = EnigmaticGems.MOD_ID)
public class ModEvents {

    private static final Random random = new Random();

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event.getEntity().getType() == EntityType.IRON_GOLEM) {
            if (random.nextInt(100) < 10) {
                // 在铁傀儡位置生成坚守宝石
                event.getEntity().spawnAtLocation(ModItems.STALWART_GEM.get());
            }
        }
        else if(event.getEntity().getType() == EntityType.BLAZE){
            if (random.nextInt(100) < 8) {
                event.getEntity().spawnAtLocation(ModItems.FIRE_GEM.get());
            }
        }
        else if(event.getEntity().getType() == EntityType.WITCH){
            if (random.nextInt(100) < 5) {
                event.getEntity().spawnAtLocation(ModItems.RED_GEM.get());
            }
        }
        else if(event.getEntity().getType() == EntityType.CAVE_SPIDER){
            if (random.nextInt(100) < 10) {
                event.getEntity().spawnAtLocation(ModItems.ANTI_POISON_GEM.get());
            }
        }
    }
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && !event.player.level().isClientSide()) {
            Player player = event.player;

            for (int i = 0; i < 9; i++) {
                ItemStack stack = player.getInventory().getItem(i);
                if (stack.getItem() == ModItems.STALWART_GEM.get()) {
                    if (!player.hasEffect(MobEffects.DAMAGE_RESISTANCE) || player.getEffect(MobEffects.DAMAGE_RESISTANCE).getDuration() <= 10) {
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0, false, false, true));
                    }
                }
                else if(stack.getItem() == ModItems.RED_GEM.get()){
                    if (!player.hasEffect(MobEffects.REGENERATION) || player.getEffect(MobEffects.REGENERATION).getDuration() <= 20) {
                        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 201, 1, false, false, true));
                    }

                }
                else if(stack.getItem() == ModItems.FIRE_GEM.get()){
                    if (!player.hasEffect(MobEffects.FIRE_RESISTANCE) || player.getEffect(MobEffects.FIRE_RESISTANCE).getDuration() <= 10) {
                        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 0, false, false, true));
                    }
                }
                else if(stack.getItem() == ModItems.ANTI_POISON_GEM.get()){
                    if (player.hasEffect(MobEffects.POISON)) {
                        player.removeEffect(MobEffects.POISON);
                    }
                }
                else if(stack.getItem() == ModItems.ECHO_GEM.get()){
                    if (!player.hasEffect(MobEffects.DAMAGE_RESISTANCE) || player.getEffect(MobEffects.DAMAGE_RESISTANCE).getDuration() <= 10) {
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1, false, false, true));
                    }
                    if(player.hasEffect(MobEffects.DARKNESS)){
                        player.removeEffect(MobEffects.DARKNESS);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onMobEffectApplicable(MobEffectEvent.Applicable event) {
        // 检查是否是玩家且获得的是中毒效果
        if (event.getEntity() instanceof Player player && event.getEffectInstance().getEffect() == MobEffects.POISON) {
            // 检查玩家的快捷栏是否有抗毒奇石
            for (int i = 0; i < 9; i++) {
                ItemStack stack = player.getInventory().getItem(i);
                if (stack.getItem() == ModItems.ANTI_POISON_GEM.get()) {
                    // 取消中毒效果
                    event.setResult(Event.Result.DENY);
                    return;
                }
            }
        }
        else if(event.getEntity() instanceof Player player&& event.getEffectInstance().getEffect() == MobEffects.DARKNESS){
            for(int i = 0; i < 9; i++){
                ItemStack stack = player.getInventory().getItem(i);
                if(stack.getItem() == ModItems.ECHO_GEM.get()){
                    event.setResult(Event.Result.DENY);
                    return;
                }
            }
        }
    }

}
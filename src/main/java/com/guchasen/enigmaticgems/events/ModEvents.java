package com.guchasen.enigmaticgems.events;

import com.guchasen.enigmaticgems.EnigmaticGems;
import com.guchasen.enigmaticgems.items.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Random;

@Mod.EventBusSubscriber(modid = EnigmaticGems.MOD_ID)
public class ModEvents {

    private static final Random random = new Random();

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event.getEntity().getType() == EntityType.IRON_GOLEM) {
            if (random.nextInt(100) < 10) {
                event.getEntity().spawnAtLocation(ModItems.STALWART_GEM.get());
            }
        }
        else if(event.getEntity().getType() == EntityType.BLAZE){
            if (random.nextInt(100) < 8) {
                event.getEntity().spawnAtLocation(ModItems.FIRE_GEM.get());
            }
        }
        else if(event.getEntity().getType() == EntityType.WITCH){
            if (random.nextInt(100) < 10) {
                event.getEntity().spawnAtLocation(ModItems.RED_GEM.get());
            }
        }
        else if(event.getEntity().getType() == EntityType.CAVE_SPIDER){
            if (random.nextInt(100) < 10) {
                event.getEntity().spawnAtLocation(ModItems.ANTI_POISON_GEM.get());
            }
        }
        else if(event.getEntity().getType() == EntityType.PHANTOM){
            if (random.nextInt(100) < 15) {
                event.getEntity().spawnAtLocation(ModItems.EYE_OF_PHANTOM.get());
            }
        }
        else if(event.getEntity().getType() == EntityType.WANDERING_TRADER){
            if (random.nextInt(100) < 5) {
                event.getEntity().spawnAtLocation(ModItems.GEM_OF_CONCEALMENT.get());
            }
        }
        else if(event.getEntity().getType() == EntityType.ELDER_GUARDIAN){
            if (random.nextInt(100) < 15) {
                event.getEntity().spawnAtLocation(ModItems.WATER_BREATHING_GEM.get());
            }
        }
        else if(event.getEntity().getType() == EntityType.WITHER_SKELETON){
            if (random.nextInt(100) < 5) {
                event.getEntity().spawnAtLocation(ModItems.BLACK_GEM.get());
            }
        }
    }

    @SubscribeEvent
    public static void onMobEffectApplicable(MobEffectEvent.Applicable event) {
        if(event.getEntity() instanceof Player player){
            for(int i = 0; i < 9; i++){
                ItemStack stack = player.getInventory().getItem(i);
                if(stack.getItem() == ModItems.ECHO_GEM.get() && event.getEffectInstance().getEffect() == MobEffects.DARKNESS){
                    event.setResult(Event.Result.DENY);
                    return;
                } else if (stack.getItem() == ModItems.ANTI_POISON_GEM.get() && event.getEffectInstance().getEffect() == MobEffects.POISON) {
                    event.setResult(Event.Result.DENY);
                    return;
                }else if(stack.getItem() == ModItems.BLACK_GEM.get() && event.getEffectInstance().getEffect() == MobEffects.WITHER){
                    event.setResult(Event.Result.DENY);
                    return;
                }
            }
        }
    }

}
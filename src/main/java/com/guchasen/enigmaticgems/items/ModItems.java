package com.guchasen.enigmaticgems.items;

import com.guchasen.enigmaticgems.EnigmaticGems;
import com.guchasen.enigmaticgems.items.gems.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EnigmaticGems.MOD_ID);

    public static final RegistryObject<Item> STALWART_GEM = ITEMS.register(
            "stalwart_gem",
            () -> new StalwartGemItem(
                    new Item.Properties()
                                     .stacksTo(1)
                                     .rarity(Rarity.RARE),
                    MobEffects.DAMAGE_RESISTANCE
            )
    );

    public static final RegistryObject<Item> RED_GEM = ITEMS.register(
            "red_gem",
            () -> new RedGemItem(
                    new Item.Properties()
                                     .stacksTo(1)
                                     .rarity(Rarity.UNCOMMON)
            )
    );

    public static final RegistryObject<Item> BIG_RED_GEM = ITEMS.register(
            "big_red_gem",
            () -> new BigRedGeM(
                    new Item.Properties()
                                     .stacksTo(1)
                                     .rarity(Rarity.RARE),
                    MobEffects.REGENERATION
            )
    );

    public static final RegistryObject<Item> FIRE_GEM = ITEMS.register(
            "fire_gem",
            () -> new FireGemItem(
                    new Item.Properties()
                                     .rarity(Rarity.RARE)
                                     .stacksTo(1),
                    MobEffects.FIRE_RESISTANCE
            )
    );

    public static final RegistryObject<Item> ANTI_POISON_GEM = ITEMS.register(
            "anti_poison_gem",
            () -> new AntiPoisonGemItem(
                    new Item.Properties()
                                     .stacksTo(1)
                                     .rarity(Rarity.RARE),
                    MobEffects.POISON
            )
    );
    public static final RegistryObject<Item> BLACK_GEM = ITEMS.register(
            "black_gem",
            () -> new BlackGem(
                    new Item.Properties()
                                     .stacksTo(1)
                                     .rarity(Rarity.RARE),
                    MobEffects.WITHER
            )
    );
    public static final RegistryObject<Item> ECHO_GEM = ITEMS.register(
            "echo_gem",
            () -> new EchoGemItem(
                    new Item.Properties()
                                    .stacksTo(1)
                                    .rarity(Rarity.EPIC)
            )
    );

    public static final RegistryObject<Item> GEM_OF_CONCEALMENT = ITEMS.register(
            "gem_of_concealment",
            () -> new GemOfConcealmentItem(
                    new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE),
                    MobEffects.INVISIBILITY
            )
    );

    public static final RegistryObject<Item> WATER_BREATHING_GEM = ITEMS.register(
            "water_breathing_gem",
            () -> new WaterBreathingGemItem(
                    new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE),
                    MobEffects.WATER_BREATHING
            )
    );

    public static final RegistryObject<Item> NIGHT_VISION_GEM = ITEMS.register(
            "night_vision_gem",
            () -> new NightVisionGemItem(
                    new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE)
            )
    );

    public static final RegistryObject<Item> EYE_OF_PHANTOM = ITEMS.register(
            "eye_of_phantom",
            () -> new Item(
                    new Item.Properties()
                            .stacksTo(64)
                            .rarity(Rarity.COMMON)
            )
    );

    //public static final RegistryObject<Item> BLACK_GEM = ITEMS.register("black_gem",
    //        () -> new BlackGem(new Item.Properties().stacksTo(1).rarity(Rarity.RARE), MobEffects.WITHER));
}
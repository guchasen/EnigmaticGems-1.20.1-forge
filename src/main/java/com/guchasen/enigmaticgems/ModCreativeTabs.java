package com.guchasen.enigmaticgems;

import com.guchasen.enigmaticgems.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EnigmaticGems.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ENIGMATIC_GEMS_TAB = CREATIVE_TABS.register("enigmatic_gems_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.enigmatic_gems"))
            .icon(() -> new ItemStack(ModItems.FIRE_GEM.get()))
            .displayItems((params, output) -> {
                output.accept(ModItems.STALWART_GEM.get());
                output.accept(ModItems.RED_GEM.get());
                output.accept(ModItems.FIRE_GEM.get());
                output.accept(ModItems.ANTI_POISON_GEM.get());
                output.accept(ModItems.ECHO_GEM.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
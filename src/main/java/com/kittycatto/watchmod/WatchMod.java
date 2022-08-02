package com.kittycatto.watchmod;

import com.kittycatto.watchmod.event.PlayerEventHandler;
import com.kittycatto.watchmod.item.Watches;
import com.mojang.logging.LogUtils;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("watchmod")
public class WatchMod
{
    public static final String MODID = "watchmod";
    private static final Logger LOGGER = LogUtils.getLogger();
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final RegistryObject<Watches> watches = ITEMS.register("watches", () -> new Watches(new Item.Properties()));

    public WatchMod()
    {	
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	ITEMS.register(bus);
    	MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
    }
}

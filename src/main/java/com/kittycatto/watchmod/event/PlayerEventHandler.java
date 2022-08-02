package com.kittycatto.watchmod.event;

import com.google.j2objc.annotations.ReflectionSupport.Level;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import com.kittycatto.watchmod.item.*;

public class PlayerEventHandler {

	@SubscribeEvent
	public void playerTick(TickEvent.PlayerTickEvent event) {
		Inventory inventory = event.player.getInventory();
		var world = event.player.level;
		if (world.isClientSide) {
			inventory.items.forEach((ItemStack stack) -> {
				var item = stack.getItem();
				if (item instanceof Watches) {
					System.out.println("watches tick");
				}
			});
		}
	}
}
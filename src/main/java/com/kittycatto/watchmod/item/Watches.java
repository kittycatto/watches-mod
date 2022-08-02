package com.kittycatto.watchmod.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Watches extends Item {
	public Watches(Properties p_41383_) {
		super(p_41383_);
	}
	@Override
	public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
		System.out.println("item tick");
		super.onUsingTick(stack, player, count);
	}
}

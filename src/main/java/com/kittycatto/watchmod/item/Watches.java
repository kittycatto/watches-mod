package com.kittycatto.watchmod.item;

import com.kittycatto.watchmod.misc.TickDivider;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class Watches extends Item {


	public Watches(Properties p_41383_) {
		super(p_41383_);
	}

	private static String nbtSelector = "TrigTime";
	TickDivider ticker = new TickDivider(20);

	@Override
	public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
		if (ticker.tick()) {
			System.out.println("ticking item from inventory...");
			
			if(p_41405_.getDayTime() > getTime(p_41404_)) {
				p_41406_.playSound(SoundEvents.COW_AMBIENT, 1f, 1f);
			}
		}
		super.inventoryTick(p_41404_, p_41405_, p_41406_, p_41407_, p_41408_);
	};

	@Override
	public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
		setTime(stack, 1100);
		return super.onItemUseFirst(stack, context);
	}
	
	public void setTime(ItemStack stack, int time) {
		var nbt = new CompoundTag();
        nbt.putInt(nbtSelector, time);
        stack.setTag(nbt);
	}

	public int getTime(ItemStack stack) {
		CompoundTag nbt = stack.getTag();
		if (nbt != null && nbt.contains(nbtSelector)) {
			return nbt.getInt(nbtSelector);
		}
		return 0;
	}
}

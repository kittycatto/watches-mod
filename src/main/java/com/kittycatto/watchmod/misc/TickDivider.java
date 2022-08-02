package com.kittycatto.watchmod.misc;

public class TickDivider {
	private int tick;
	private int fireTick;

	public TickDivider(int fireOnTick) {
		fireTick = fireOnTick;
	}

	public boolean tick() {
		if (tick < fireTick) {
			tick++;
			return false;
		}
		tick = 0;
		return true;
	}
}

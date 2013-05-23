package com.sudwood.mysticadditions;

import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public interface MysticEnergy {

	
	int connectTop = 0;
	int connectBottom = 5;
	int connectFront = 1;
	int connectLeft = 2;
	int connectBack = 3;
	int connectRight = 4;
	
	
	public abstract int[] checkConnect(WorldServer world, int x, int y, int z);
	public abstract void getEnergy();
	public abstract void sendEnergy();
	
	
}

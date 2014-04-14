package com.sudwood.mysticadditions.items.energy;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MysticModule extends Item
{
	public final static byte FIRE = 0;
	public final static byte WATER = 1;
	public final static byte AIR = 2;
	public final static byte EARTH = 3;
	
	public byte type;
	public MysticModule(int par1, byte type) 
	{
		super(par1);
		this.type = type;
	}
	
	public static byte getTypeForStack(ItemStack stack)
	{
		if(stack != null && stack.getItem() instanceof MysticModule)
		{
			switch(((MysticModule)stack.getItem()).type)
			{
			case FIRE:
				return FIRE;
			case WATER:
				return WATER;
			case AIR:
				return AIR;
			case EARTH:
				return EARTH;
			}
		}
		return -5;
	}

}

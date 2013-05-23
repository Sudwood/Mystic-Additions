package com.sudwood.mysticadditions.items.potions;

import net.minecraft.potion.Potion;

public class MysticModPotions {

	public static Potion freezePotion;
	
	
	public static void init()
	{
		freezePotion = (new PotionFreeze(31, false, 0)).setIconIndex(0, 0).setPotionName("FreezePotion");
	}
	
	
	
}

package com.sudwood.mysticadditions.items.potions;

import net.minecraft.potion.Potion;

public class MysticModPotions {

	public static Potion freezePotion;
	public static final int FREEZE_ID = 31;
	
	public static void init()
	{
		freezePotion = (new PotionFreeze(FREEZE_ID, false, 0)).setIconIndex(0, 0).setPotionName("FreezePotion");
	}
	
	
	
}

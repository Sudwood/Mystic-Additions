package com.sudwood.mysticadditions.enchantments;

import net.minecraft.enchantment.Enchantment;

public class EnchantmentRegister {
	
	public static Enchantment Flight;
	public void registerEnchantments()
	{
	Flight = new EnchantmentFlight(82, 500);
	Flight.setName("Flight");
	}
	
	
	
}

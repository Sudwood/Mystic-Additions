package com.sudwood.mysticadditions.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentFlight extends Enchantment {

	protected EnchantmentFlight(int par1, int par2) {
		super(par1, par2, EnumEnchantmentType.all);
		// TODO Auto-generated constructor stub
	}

	
	  /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return 20;
    }

    
    @Override
    public String getName()
    {
        return this.name;
    }
    
    
    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int par1)
    {
        return 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return 1;
    }
	
	
	
}

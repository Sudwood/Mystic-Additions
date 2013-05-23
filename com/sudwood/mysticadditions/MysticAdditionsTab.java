package com.sudwood.mysticadditions;

import com.sudwood.mysticadditions.items.MysticModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MysticAdditionsTab extends CreativeTabs {

	public MysticAdditionsTab(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}
	@Override
	public ItemStack getIconItemStack() {
	    return new ItemStack(MysticModItems.mysticIngot);
	}
	

}

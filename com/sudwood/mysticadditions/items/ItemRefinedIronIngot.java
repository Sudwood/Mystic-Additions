package com.sudwood.mysticadditions.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemRefinedIronIngot extends Item 
{
	
	public ItemRefinedIronIngot(int x)
	{
		super(x);
		maxStackSize = 64;		
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:refinedironingot");
	}
}

package com.sudwood.mysticadditions.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemCSteelDust extends Item 
{
	
	public ItemCSteelDust(int x)
	{
		super(x);
		maxStackSize = 64;	
		
		
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:steeldust");
	}


	
}

package com.sudwood.mysticadditions.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemEchantedBone extends Item 
{
	
	public ItemEchantedBone(int x)
	{
		super(x);
		maxStackSize = 1;	
		
		
	}
	@Override
	public void updateIcons(IconRegister iconRegister)
	{
	         this.iconIndex = iconRegister.registerIcon("MysticAdditions:enchantedbone");
	}


	
}

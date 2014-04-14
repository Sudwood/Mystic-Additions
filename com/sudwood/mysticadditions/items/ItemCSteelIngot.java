package com.sudwood.mysticadditions.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;


public class ItemCSteelIngot extends Item 
{

	public ItemCSteelIngot(int x)
	{
		super(x);
		maxStackSize = 64;		
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:steelingot");
	}
	
}

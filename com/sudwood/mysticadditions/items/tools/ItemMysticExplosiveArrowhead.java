package com.sudwood.mysticadditions.items.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.sudwood.mysticadditions.MysticCommonProxy;




public class ItemMysticExplosiveArrowhead extends Item 
{
	
	public ItemMysticExplosiveArrowhead(int x)
	{
		super(x);
		maxStackSize = 64;	
		
		
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("MysticAdditions:explosivearrowheads");
	}


	
}

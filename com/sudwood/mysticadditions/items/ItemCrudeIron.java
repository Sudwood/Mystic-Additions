package com.sudwood.mysticadditions.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemCrudeIron extends Item {
	
	public ItemCrudeIron(int x)
	{
		super(x);
		maxStackSize = 64;	
		
		
	}
	@Override
	public void updateIcons(IconRegister iconRegister)
	{
	         this.iconIndex = iconRegister.registerIcon("MysticAdditions:crudeiron");
	}


	
}

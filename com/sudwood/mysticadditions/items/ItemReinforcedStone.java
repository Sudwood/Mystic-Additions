package com.sudwood.mysticadditions.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemReinforcedStone extends Item {
	
	public ItemReinforcedStone(int x)
	{
		super(x);
		maxStackSize = 64;	
		
		
	}
	@Override
	public void updateIcons(IconRegister iconRegister)
	{
	         this.iconIndex = iconRegister.registerIcon("MysticAdditions:reinforcedstoneplating");
	}


	
}

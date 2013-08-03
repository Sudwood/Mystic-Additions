package com.sudwood.mysticadditions.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

import com.sudwood.mysticadditions.MysticCommonProxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemWoodenReinforcements extends Item 
{
	
	public ItemWoodenReinforcements(int x)
	{
		super(x);
		maxStackSize = 64;	
		
		
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
	         this.itemIcon = iconRegister.registerIcon("mysticadditions:woodenreinforcements");
	}

	

	
}

package com.sudwood.mysticadditions.items;

import com.sudwood.mysticadditions.MysticCommonProxy;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemRawWarp extends Item {

	public ItemRawWarp(int par1) {
		super(par1);
		setMaxStackSize(64);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:rawwarp");
	}

}

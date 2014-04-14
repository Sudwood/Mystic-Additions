package com.sudwood.mysticadditions.items.energy;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemAirToken extends MysticModule
{
	
	public ItemAirToken(int x)
	{
		super(x, MysticModule.AIR);
		maxStackSize = 64;	
		
		
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:airtoken");
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
	{
		String string = "The power of the air";
		String string2 = "flows through the Token";
		par3List.add(string);
		par3List.add(string2);
	}
	
}

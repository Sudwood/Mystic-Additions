package com.sudwood.mysticadditions.items.energy;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemFireToken extends MysticModule
{
	
	public ItemFireToken(int x)
	{
		super(x, MysticModule.FIRE);
		maxStackSize = 64;	
		
		
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:firetoken");
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
	{
		String string = "The power of fire";
		String string2 = "flows through the Token";
		par3List.add(string);
		par3List.add(string2);
	}
	
}

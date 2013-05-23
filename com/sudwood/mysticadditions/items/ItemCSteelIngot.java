package com.sudwood.mysticadditions.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.entity.EntityMysticKnight;
import com.sudwood.mysticadditions.entity.EntityWindMiniBoss;


public class ItemCSteelIngot extends Item 
{

	public ItemCSteelIngot(int x)
	{
		super(x);
		maxStackSize = 64;		
	}
	@Override
	public void updateIcons(IconRegister iconRegister)
	{
	         this.iconIndex = iconRegister.registerIcon("MysticAdditions:steelingot");
	}
	
}

package com.sudwood.mysticadditions.items;

import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.entity.EntityMysticKnight;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import net.minecraft.src.ModLoader;
import net.minecraft.world.World;


public class ItemMysticKnightEgg extends Item 
{
	//Minecraft mc = ModLoader.getMinecraftInstance();
//World world = mc.theWorld; //get the current world.
//EntityPlayer player = mc.thePlayer; //get the player entity.
	public ItemMysticKnightEgg(int x)
	{
		super(x);
		maxStackSize = 1;	
		
		
	}
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
   EntityMysticKnight mysticknight = new EntityMysticKnight(world);
       mysticknight.setPosition(entityplayer.posX, entityplayer.posY + 1, entityplayer.posZ);
       if(!world.isRemote)
      	world.spawnEntityInWorld(mysticknight);
       	return itemstack;
    }
	@Override
	public void updateIcons(IconRegister iconRegister)
	{
	         this.iconIndex = iconRegister.registerIcon("MysticAdditions:mysticknightspawnegg");
	}


	
}

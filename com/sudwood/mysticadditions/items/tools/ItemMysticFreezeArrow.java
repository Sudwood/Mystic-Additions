package com.sudwood.mysticadditions.items.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.mod_MysticAdditions;


public class ItemMysticFreezeArrow extends Item 
{

	public ItemMysticFreezeArrow(int i)
    {
        super(i);
        maxStackSize = 64;
    }
	@Override
	public void updateIcons(IconRegister iconRegister)
	{
		this.iconIndex = iconRegister.registerIcon("MysticAdditions:freezearrow");
	}
	 public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	    {
		 NBTTagCompound tag = entityplayer.getEntityData();
		 tag.setInteger("ArrowToBeFired", 5);
	    return itemstack;
	    }
}

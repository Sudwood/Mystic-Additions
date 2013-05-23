package com.sudwood.mysticadditions.items.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.MysticAdditions;


public class ItemRegularArrowChooser extends Item 
{
	
	public ItemRegularArrowChooser(int x)
	{
		super(x);
		maxStackSize = 64;	
		setCreativeTab(CreativeTabs.tabCombat);
		
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("MysticAdditions:regulararrowchooser");
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		NBTTagCompound tag = entityplayer.getEntityData();
		 tag.setInteger("ArrowToBeFired", 4);
    return itemstack;
    }
	
}

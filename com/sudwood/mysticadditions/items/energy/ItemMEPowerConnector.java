package com.sudwood.mysticadditions.items.energy;

import java.util.List;

import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGenerator;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorage;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemMEPowerConnector extends Item {

	public ItemMEPowerConnector(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
	{
		if(par1ItemStack.getTagCompound() == null) par1ItemStack.setTagCompound(new NBTTagCompound());
		NBTTagCompound tag = par1ItemStack.getTagCompound();
		tag.setInteger("xCoord", 0);
		tag.setInteger("yCoord", 0);
		tag.setInteger("zCoord", 0);
		tag.setBoolean("isSet", false);
	}
	Integer[] firstCoords = {0,0,0};
	boolean isSet =false;
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
		
		if(par1ItemStack.getTagCompound() == null) par1ItemStack.setTagCompound(new NBTTagCompound());
		 NBTTagCompound tag = par1ItemStack.getTagCompound();
		firstCoords[0]=tag.getInteger("xCoord");
		firstCoords[1]=tag.getInteger("yCoord");
		firstCoords[2]=tag.getInteger("zCoord");
		isSet = tag.getBoolean("isSet");
		if (firstCoords[0]!=null&&firstCoords[1]!=null&&firstCoords[2]!=null)
		{
			par3List.add("State :"+isSet);
			par3List.add("X :"+firstCoords[0]);
			par3List.add("Y :"+firstCoords[1]);
			par3List.add("Z :"+firstCoords[2]);
		}
    }
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("MysticAdditions:moderatlyefficientpowerconnector");
	}
	

}

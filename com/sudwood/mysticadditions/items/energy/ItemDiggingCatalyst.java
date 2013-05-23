package com.sudwood.mysticadditions.items.energy;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.sudwood.mysticadditions.mod_MysticAdditions;

import net.java.games.input.Component.Identifier.Key;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemDiggingCatalyst extends IItemMysticRechargeable {
	public Icon[] iconList = new Icon[10];
	public ItemDiggingCatalyst(int par1, int maxEnergy, int rechargeRate)
	{
		super(par1, maxEnergy, rechargeRate);
		this.setMaxDamage(8);
	}
	
	
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		 if(par1ItemStack.getTagCompound()==null)
		  {
			  par1ItemStack.setTagCompound(new NBTTagCompound());
		  }
		  NBTTagCompound tag = par1ItemStack.getTagCompound();
		  this.currentCharge = tag.getInteger("CurrentCharge");
		  tag.setInteger("MaxStorage", this.maxStorage);
		  this.maxStorage = tag.getInteger("MaxStorage");
		  tag.setInteger("RechargeRate", this.rechargeRatePerTick);
		  this.rechargeRatePerTick = tag.getInteger("RechargeRate");
		
			 par3List.add(this.currentCharge+"/"+this.maxStorage+" MyJ");
	 }
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		if(itemstack.getTagCompound()==null)
		  {
			  itemstack.setTagCompound(new NBTTagCompound());
		  }
		 NBTTagCompound tag = itemstack.getTagCompound();
		 this.currentCharge = tag.getInteger("CurrentCharge");
		if(this.currentCharge>4000)
		{
		ArrayList<Integer> ids = new ArrayList();
		int x = (int) entityplayer.posX;
		int y = (int)entityplayer.posY;
		int z = (int)entityplayer.posZ;
		int direction = MathHelper.floor_double((double)((entityplayer.rotationYaw * 4F) / 360F) + 0.5D) & 3;
		
		if(direction==0)
		{
			for(int i = 1 ; i<65 ; i++)
			{
			if(world.getBlockId(x+1, y+2, z+i)!=7)
			ids.add(world.getBlockId(x+1, y+2, z+i));
			if(world.getBlockId(x+1, y+2, z+i)!=7)
			world.setBlock(x+1, y+2, z+i, 0);
			if(world.getBlockId(x, y+2, z+i)!=7)
			ids.add(world.getBlockId(x, y+2, z+i));
			if(world.getBlockId(x, y+2, z+i)!=7)
			world.setBlock(x, y+2, z+i, 0);
			if(world.getBlockId(x-1, y+2, z+i)!=7)
			ids.add(world.getBlockId(x-1, y+2, z+i));
			if(world.getBlockId(x-1, y+2, z+i)!=7)
			world.setBlock(x-1, y+2, z+i, 0);
			if(world.getBlockId(x+1, y+1, z+i)!=7)
			ids.add(world.getBlockId(x+1, y+1, z+i));
			if(world.getBlockId(x+1, y+1, z+i)!=7)
			world.setBlock(x+1, y+1, z+i, 0);
			if(world.getBlockId(x, y+1, z+i)!=7)
			ids.add(world.getBlockId(x, y+1, z+i));
			if(world.getBlockId(x, y+1, z+i)!=7)
			world.setBlock(x, y+1, z+i, 0);
			if(world.getBlockId(x-1, y+1, z+i)!=7)
			ids.add(world.getBlockId(x-1, y+1, z+i));
			if(world.getBlockId(x-1, y+1, z+i)!=7)
			world.setBlock(x-1, y+1, z+i, 0);
			if(world.getBlockId(x+1, y, z+i)!=7)
			ids.add(world.getBlockId(x+1, y, z+i));
			if(world.getBlockId(x+1, y, z+i)!=7)
			world.setBlock(x+1, y, z+i, 0);
			if(world.getBlockId(x, y, z+i)!=7)
			ids.add(world.getBlockId(x, y, z+i));
			if(world.getBlockId(x, y, z+i)!=7)
			world.setBlock(x, y, z+i, 0);
			if(world.getBlockId(x-1, y, z+i)!=7)
			ids.add(world.getBlockId(x-1, y, z+i));
			if(world.getBlockId(x-1, y, z+i)!=7)
			world.setBlock(x-1, y, z+i, 0);
			}
			
		}
		if(direction==1)
		{
			for(int i = 1 ; i<65 ; i++)
			{
			if(world.getBlockId(x-i, y+2, z+1)!=7)
			ids.add(world.getBlockId(x-i, y+2, z+1));
			if(world.getBlockId(x-i, y+2, z+1)!=7)
			world.setBlock(x-i, y+2, z+1, 0);
			if(world.getBlockId(x-i, y+2, z)!=7)
			ids.add(world.getBlockId(x-i, y+2, z));
			if(world.getBlockId(x-i, y+2, z)!=7)
			world.setBlock(x-i, y+2, z, 0);
			if(world.getBlockId(x-i, y+2, z-1)!=7)
			ids.add(world.getBlockId(x-i, y+2, z-1));
			if(world.getBlockId(x-i, y+2, z-1)!=7)
			world.setBlock(x-i, y+2, z-1, 0);
			if(world.getBlockId(x-i, y+1, z+1)!=7)
			ids.add(world.getBlockId(x-i, y+1, z+1));
			if(world.getBlockId(x-i, y+1, z+1)!=7)
			world.setBlock(x-i, y+1, z+1, 0);
			if(world.getBlockId(x-i, y+1, z)!=7)
			ids.add(world.getBlockId(x-i, y+1, z));
			if(world.getBlockId(x-i, y+1, z)!=7)
			world.setBlock(x-i, y+1, z, 0);
			if(world.getBlockId(x-i, y+1, z-1)!=7)
			ids.add(world.getBlockId(x-i, y+1, z-1));
			if(world.getBlockId(x-i, y+1, z-1)!=7)
			world.setBlock(x-i, y+1, z-1, 0);
			if(world.getBlockId(x-i, y, z+1)!=7)
			ids.add(world.getBlockId(x-i, y, z+1));
			if(world.getBlockId(x-i, y, z+1)!=7)
			world.setBlock(x-i, y, z+1, 0);
			if(world.getBlockId(x-i, y, z)!=7)
			ids.add(world.getBlockId(x-i, y, z));
			if(world.getBlockId(x-i, y, z)!=7)
			world.setBlock(x-i, y, z, 0);
			if(world.getBlockId(x-i, y, z-1)!=7)
			ids.add(world.getBlockId(x-i, y, z-1));
			if(world.getBlockId(x-i, y, z-1)!=7)
			world.setBlock(x-i, y, z-1, 0);
			
			}
			
		}
		
		if(direction==2)
		{
			for(int i = 1 ; i<65 ; i++)
			{
				if(world.getBlockId(x+1, y+2, z-i)!=7)
					ids.add(world.getBlockId(x+1, y+2, z-i));
					if(world.getBlockId(x+1, y+2, z-i)!=7)
					world.setBlock(x+1, y+2, z-i, 0);
					if(world.getBlockId(x, y+2, z-i)!=7)
					ids.add(world.getBlockId(x, y+2, z-i));
					if(world.getBlockId(x, y+2, z-i)!=7)
					world.setBlock(x, y+2, z-i, 0);
					if(world.getBlockId(x-1, y+2, z-i)!=7)
					ids.add(world.getBlockId(x-1, y+2, z-i));
					if(world.getBlockId(x-1, y+2, z-i)!=7)
					world.setBlock(x-1, y+2, z-i, 0);
					if(world.getBlockId(x+1, y+1, z-i)!=7)
					ids.add(world.getBlockId(x+1, y+1, z-i));
					if(world.getBlockId(x+1, y+1, z-i)!=7)
					world.setBlock(x+1, y+1, z-i, 0);
					if(world.getBlockId(x, y+1, z-i)!=7)
					ids.add(world.getBlockId(x, y+1, z-i));
					if(world.getBlockId(x, y+1, z-i)!=7)
					world.setBlock(x, y+1, z-i, 0);
					if(world.getBlockId(x-1, y+1, z-i)!=7)
					ids.add(world.getBlockId(x-1, y+1, z-i));
					if(world.getBlockId(x-1, y+1, z-i)!=7)
					world.setBlock(x-1, y+1, z-i, 0);
					if(world.getBlockId(x+1, y, z-i)!=7)
					ids.add(world.getBlockId(x+1, y, z-i));
					if(world.getBlockId(x+1, y, z-i)!=7)
					world.setBlock(x+1, y, z-i, 0);
					if(world.getBlockId(x, y, z-i)!=7)
					ids.add(world.getBlockId(x, y, z-i));
					if(world.getBlockId(x, y, z-i)!=7)
					world.setBlock(x, y, z-i, 0);
					if(world.getBlockId(x-1, y, z-i)!=7)
					ids.add(world.getBlockId(x-1, y, z-i));
					if(world.getBlockId(x-1, y, z-i)!=7)
					world.setBlock(x-1, y, z-i, 0);
			}
			
		}
		if(direction==3)
		{
			for(int i = 1 ; i<65 ; i++)
			{
				if(world.getBlockId(x+i, y+2, z+1)!=7)
					ids.add(world.getBlockId(x+i, y+2, z+1));
					if(world.getBlockId(x+i, y+2, z+1)!=7)
					world.setBlock(x+i, y+2, z+1, 0);
					if(world.getBlockId(x+i, y+2, z)!=7)
					ids.add(world.getBlockId(x+i, y+2, z));
					if(world.getBlockId(x+i, y+2, z)!=7)
					world.setBlock(x+i, y+2, z, 0);
					if(world.getBlockId(x+i, y+2, z-1)!=7)
					ids.add(world.getBlockId(x+i, y+2, z-1));
					if(world.getBlockId(x+i, y+2, z-1)!=7)
					world.setBlock(x+i, y+2, z-1, 0);
					if(world.getBlockId(x+i, y+1, z+1)!=7)
					ids.add(world.getBlockId(x+i, y+1, z+1));
					if(world.getBlockId(x+i, y+1, z+1)!=7)
					world.setBlock(x+i, y+1, z+1, 0);
					if(world.getBlockId(x+i, y+1, z)!=7)
					ids.add(world.getBlockId(x+i, y+1, z));
					if(world.getBlockId(x+i, y+1, z)!=7)
					world.setBlock(x+i, y+1, z, 0);
					if(world.getBlockId(x+i, y+1, z-1)!=7)
					ids.add(world.getBlockId(x+i, y+1, z-1));
					if(world.getBlockId(x+i, y+1, z-1)!=7)
					world.setBlock(x+i, y+1, z-1, 0);
					if(world.getBlockId(x+i, y, z+1)!=7)
					ids.add(world.getBlockId(x+i, y, z+1));
					if(world.getBlockId(x+i, y, z+1)!=7)
					world.setBlock(x+i, y, z+1, 0);
					if(world.getBlockId(x+i, y, z)!=7)
					ids.add(world.getBlockId(x+i, y, z));
					if(world.getBlockId(x+i, y, z)!=7)
					world.setBlock(x+i, y, z, 0);
					if(world.getBlockId(x+i, y, z-1)!=7)
					ids.add(world.getBlockId(x+i, y, z-1));
					if(world.getBlockId(x+i, y, z-1)!=7)
					world.setBlock(x+i, y, z-1, 0);
			
			}
			
		}
		
			
		if(!world.isRemote)
		{
		for(int ix = 0; ix< ids.size(); ix++)
		{
			entityplayer.dropItem(ids.get(ix), 1);
		}
		}
		this.currentCharge-=4000;
		tag.setInteger("CurrentCharge", currentCharge);
		}
		return itemstack;
    }
	
	
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if(!getIsUsable(par1ItemStack))
		{
			this.hasCharged = false;
		}
		this.setItemDamageByCharge(par1ItemStack);
	}
	
	
	
	
	public void setItemDamageByCharge(ItemStack itemStack)
	{
		
		int oneTenth = this.maxStorage/7;
		  if(this.currentCharge==0)
		  {
			  itemStack.setItemDamage(8);
		  }
		  if(this.currentCharge<oneTenth)
		  {
			  itemStack.setItemDamage(7);
		  }
		  if(this.currentCharge>oneTenth&&this.currentCharge<(oneTenth*2))
		  {
			  itemStack.setItemDamage(6);
		  }
		  if(this.currentCharge>(oneTenth*2)&&this.currentCharge<(oneTenth*3))
		  {
			  itemStack.setItemDamage(5);
		  }
		  if(this.currentCharge>(oneTenth*3)&&this.currentCharge<(oneTenth*4))
		  {
			  itemStack.setItemDamage(4);
		  }
		  if(this.currentCharge>(oneTenth*4)&&this.currentCharge<(oneTenth*5))
		  {
			  itemStack.setItemDamage(3);
		  }
		  if(this.currentCharge>(oneTenth*5)&&this.currentCharge<(oneTenth*6))
		  {
			  itemStack.setItemDamage(2);
		  }
		  if(this.currentCharge>(oneTenth*6)&&this.currentCharge<(oneTenth*7))
		  {
			  itemStack.setItemDamage(1);
		  }
		  
		  
		  if(this.currentCharge==this.maxStorage||this.currentCharge>(oneTenth*7))
		  {
			  itemStack.setItemDamage(0);
		  }
	}
	@Override
	public void updateIcons(IconRegister iconRegister)
	{
	         this.iconIndex = iconRegister.registerIcon("MysticAdditions:diggingcatalyst");
	         
	         
	}
	
	
	
	
    }


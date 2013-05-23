package com.sudwood.mysticadditions.items.energy;

import java.util.List;

import com.sudwood.mysticadditions.MysticCommonProxy;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class IItemMysticRechargeable extends Item{
	
	public int rechargeRatePerTick;
	public boolean hasCharged = false;
	public int currentCharge = 0;
	public int maxStorage;
	public IItemMysticRechargeable(int par1, int maxEnergy, int rechargeRate) {
		super(par1);
		this.maxStorage = maxEnergy;
		this.setMaxStackSize(1);
		this.setMaxDamage(12);
		
		rechargeRatePerTick = rechargeRate;
		// TODO Auto-generated constructor stub
	}
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if(!getIsUsable(par1ItemStack))
		{
			this.hasCharged = false;
		}
	}
	
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
		  String tempString = this.currentCharge+"/"+this.maxStorage+" MyJ";
		  par3List.add(tempString);
	  }
	public boolean getIsUsable(ItemStack tempStack)
	{
		if (tempStack.getItemDamage()<=1)
				return false;
		else
			return true;
	}
	public void Charge(ItemStack itemStack)
	{
		if(itemStack.getTagCompound()==null)
		  {
			  itemStack.setTagCompound(new NBTTagCompound());
		  }
		  NBTTagCompound tag = itemStack.getTagCompound();
		  
		  this.currentCharge = tag.getInteger("CurrentCharge");
		  if(this.currentCharge<this.maxStorage)
		  {
			  
		  this.currentCharge+=this.rechargeRatePerTick;
		  tag.setInteger("CurrentCharge", this.currentCharge);
		  }
		  this.setItemDamageByCharge(itemStack);
		  
		  
	}
	public void disCharge(ItemStack itemStack)
	{
		if(itemStack.getTagCompound()==null)
		  {
			  itemStack.setTagCompound(new NBTTagCompound());
		  }
		  NBTTagCompound tag = itemStack.getTagCompound();
		  
		  this.currentCharge = tag.getInteger("CurrentCharge");
		  if(this.currentCharge>0)
		  {
			  
		  this.currentCharge-=this.rechargeRatePerTick;
		  tag.setInteger("CurrentCharge", this.currentCharge);
		  }
		  this.setItemDamageByCharge(itemStack);
	}
	
	public void setItemDamageByCharge(ItemStack itemStack)
	{
		int oneTenth = this.maxStorage/10;
		  if(this.currentCharge==0)
		  {
			  itemStack.setItemDamage(11);
		  }
		  if(this.currentCharge<oneTenth)
		  {
			  itemStack.setItemDamage(10);
		  }
		  if(this.currentCharge>oneTenth&&this.currentCharge<(oneTenth*2))
		  {
			  itemStack.setItemDamage(9);
		  }
		  if(this.currentCharge>(oneTenth*2)&&this.currentCharge<(oneTenth*3))
		  {
			  itemStack.setItemDamage(8);
		  }
		  if(this.currentCharge>(oneTenth*3)&&this.currentCharge<(oneTenth*4))
		  {
			  itemStack.setItemDamage(7);
		  }
		  if(this.currentCharge>(oneTenth*4)&&this.currentCharge<(oneTenth*5))
		  {
			  itemStack.setItemDamage(6);
		  }
		  if(this.currentCharge>(oneTenth*5)&&this.currentCharge<(oneTenth*6))
		  {
			  itemStack.setItemDamage(5);
		  }
		  if(this.currentCharge>(oneTenth*6)&&this.currentCharge<(oneTenth*7))
		  {
			  itemStack.setItemDamage(4);
		  }
		  if(this.currentCharge>(oneTenth*7)&&this.currentCharge<(oneTenth*8))
		  {
			  itemStack.setItemDamage(3);
		  }
		  if(this.currentCharge>(oneTenth*8)&&this.currentCharge<(oneTenth*9))
		  {
			  itemStack.setItemDamage(2);
		  }
		  if(this.currentCharge>(oneTenth*9)&&this.currentCharge<(oneTenth*10))
		  {
			  itemStack.setItemDamage(1);
		  }
		  if(this.currentCharge==this.maxStorage)
		  {
			  itemStack.setItemDamage(0);
		  }
	}
	
	
	
	
}

package com.sudwood.mysticadditions.items.energy;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class IItemMysticRechargeableArmor extends ItemArmor{
	protected EnumArmorMaterial material;
	protected int armorpiece;
	public int rechargeRatePerTick;
	public boolean hasCharged = false;
	public int currentCharge = 0;
	public int maxStorage;
	public IItemMysticRechargeableArmor(int id, EnumArmorMaterial material1, int renderid,int armor, int maxEnergy, int rechargeRate)
	{
		super(id, material1, renderid, armor);
		this.maxStorage = maxEnergy;
		this.rechargeRatePerTick = rechargeRate;
		this.setMaxStackSize(1);
		
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
		int modifiedDamage = 0;
		switch(armorpiece)
		{
		case 0: modifiedDamage = (220/11);
		case 1: modifiedDamage = (320/11);
		case 2: modifiedDamage = (300/11);
		case 3: modifiedDamage = (260/11);
		default: 
		}
		int oneTenth = this.maxStorage/10;
		  if(this.currentCharge==0)
		  {
			  itemStack.setItemDamage((modifiedDamage*11)+1);
		  }
		  if(this.currentCharge<oneTenth)
		  {
			  itemStack.setItemDamage((modifiedDamage*10));
		  }
		  if(this.currentCharge>oneTenth&&this.currentCharge<(oneTenth*2))
		  {
			  itemStack.setItemDamage((modifiedDamage*9));
		  }
		  if(this.currentCharge>(oneTenth*2)&&this.currentCharge<(oneTenth*3))
		  {
			  itemStack.setItemDamage((modifiedDamage*8));
		  }
		  if(this.currentCharge>(oneTenth*3)&&this.currentCharge<(oneTenth*4))
		  {
			  itemStack.setItemDamage((modifiedDamage*7));
		  }
		  if(this.currentCharge>(oneTenth*4)&&this.currentCharge<(oneTenth*5))
		  {
			  itemStack.setItemDamage((modifiedDamage*6));
		  }
		  if(this.currentCharge>(oneTenth*5)&&this.currentCharge<(oneTenth*6))
		  {
			  itemStack.setItemDamage((modifiedDamage*5));
		  }
		  if(this.currentCharge>(oneTenth*6)&&this.currentCharge<(oneTenth*7))
		  {
			  itemStack.setItemDamage((modifiedDamage*4));
		  }
		  if(this.currentCharge>(oneTenth*7)&&this.currentCharge<(oneTenth*8))
		  {
			  itemStack.setItemDamage((modifiedDamage*3));
		  }
		  if(this.currentCharge>(oneTenth*8)&&this.currentCharge<(oneTenth*9))
		  {
			  itemStack.setItemDamage((modifiedDamage*2));
		  }
		  if(this.currentCharge>(oneTenth*9)&&this.currentCharge<(oneTenth*10))
		  {
			  itemStack.setItemDamage((modifiedDamage));
		  }
		  if(this.currentCharge==this.maxStorage)
		  {
			  itemStack.setItemDamage(0);
		  }
	}
}

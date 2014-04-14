package com.sudwood.mysticadditions.items.energy;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

public class IItemMysticRechargeableArmor extends ItemArmor{
	protected EnumArmorMaterial material;
	protected int armorpiece;
	public int rechargeRatePerTick;
	public boolean hasCharged = false;
	public int currentCharge = 0;
	public int maxStorage;
	public ItemStack[] mods = new ItemStack[2]; 
	public IItemMysticRechargeableArmor(int id, EnumArmorMaterial material1, int renderid,int armor, int maxEnergy, int rechargeRate)
	{
		super(id, material1, renderid, armor);
		this.maxStorage = maxEnergy;
		this.rechargeRatePerTick = rechargeRate;
		this.setMaxStackSize(1);
		
	}
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) 
	{
		NBTTagCompound tag = par1ItemStack.getTagCompound();
		  if(tag.getInteger("RechargeRate")==0)
			  tag.setInteger("RechargeRate", this.rechargeRatePerTick);
		  if(mods[0] == null || mods[1] == null)
		  {
			  NBTTagList var2 = tag.getTagList("Items");
		        this.mods = new ItemStack[2];

		        for (int var8 = 0; var8 < var2.tagCount(); ++var8)
		        {
		            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var8);
		            byte var5 = var4.getByte("Slot");

		            if (var5 >= 0 && var5 < this.mods.length)
		            {
		                this.mods[var5] = ItemStack.loadItemStackFromNBT(var4);
		            }
		        }
			  
		  }
	}
	
	public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) 
	{
		if(par1ItemStack.getTagCompound()==null)
		  {
			  par1ItemStack.setTagCompound(new NBTTagCompound());
		  }
		NBTTagCompound tag = par1ItemStack.getTagCompound();
		tag.setInteger("CurrentCharge", 0);
		tag.setInteger("MaxStorage", this.maxStorage);
		tag.setInteger("OriginalMaxStorage", this.maxStorage);
		tag.setInteger("RechargeRate", this.rechargeRatePerTick);
		NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.mods.length; ++var3)
        {
            if (this.mods[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.mods[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }
        tag.setTag("Items", var2);
	}
	
	public ItemStack getMods(int slot, ItemStack stack)
	{
		ItemStack result = null;
		
		if(stack.getItem() instanceof IItemMysticRechargeableArmor)
		{
			NBTTagCompound tag = stack.getTagCompound();
			if(tag!= null)
			{
				
			}
		}
		
		return result;
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	  {
		  if(par1ItemStack.getTagCompound()==null)
		  {
			  par1ItemStack.setTagCompound(new NBTTagCompound());
		  }
		  NBTTagCompound tag = par1ItemStack.getTagCompound();
		  this.currentCharge = tag.getInteger("CurrentCharge");
		  if(tag.getInteger("MaxStorage")==0)
			  tag.setInteger("MaxStorage", this.maxStorage);
		  if(tag.getInteger("RechargeRate")==0)
			  tag.setInteger("RechargeRate", this.rechargeRatePerTick);
		  this.rechargeRatePerTick = tag.getInteger("RechargeRate");
		  String tempString = this.currentCharge+"/"+tag.getInteger("MaxStorage")+" MyJ";
		  par3List.add(tempString);
		  NBTTagList var2 = tag.getTagList("Items");
	        this.mods = new ItemStack[2];

	        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
	        {
	            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
	            byte var5 = var4.getByte("Slot");

	            if (var5 >= 0 && var5 < this.mods.length)
	            {
	                this.mods[var5] = ItemStack.loadItemStackFromNBT(var4);
	            }
	        }
		  String temp2 = "";
		  String temp3 = "";
		  if(mods[0] != null)
		  {
			if(mods[0].getItem() instanceof MysticModule)
			{
			switch(((MysticModule)	mods[0].getItem()).type)
			{
			case MysticModule.FIRE:
				temp2 = "Fire - " + mods[0].stackSize;
				break;
			case MysticModule.WATER:
				temp2 = "Water - " + mods[0].stackSize;
				break;
			case MysticModule.AIR:
				temp2 = "Air - " + mods[0].stackSize;
				break;
			case MysticModule.EARTH:
				temp2 = "Earth - " + mods[0].stackSize;
				break;
			}
			}
			
		  }
		  if(mods[1]!=null)
		  {
			  
			  if(mods[1].getItem() instanceof MysticModule)
				{
				switch(((MysticModule)	mods[1].getItem()).type)
				{
				case MysticModule.FIRE:
					temp3 = "Fire - " + mods[1].stackSize;
					break;
				case MysticModule.WATER:
					temp3 = "Water - " + mods[1].stackSize;
					break;
				case MysticModule.AIR:
					temp3 = "Air - " + mods[1].stackSize;
					break;
				case MysticModule.EARTH:
					temp3 = "Earth - " + mods[1].stackSize;
					break;
				}
				}
			  
		  }
		  par3List.add(temp2);
		  par3List.add(temp3);
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
	 public void readNBT(ItemStack stack)
	    {
	    	if(stack.getTagCompound()==null)
			  {
				  stack.setTagCompound(new NBTTagCompound());
			  }
			  NBTTagCompound tag = stack.getTagCompound();
			  NBTTagList var2 = tag.getTagList("Items");
		        this.mods = new ItemStack[2];

		        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
		        {
		            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
		            byte var5 = var4.getByte("Slot");

		            if (var5 >= 0 && var5 < this.mods.length)
		            {
		                this.mods[var5] = ItemStack.loadItemStackFromNBT(var4);
		            }
		        }
	    }
}

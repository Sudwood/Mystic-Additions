package com.sudwood.mysticadditions.items.energy;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.items.potions.MysticModPotions;

public class IItemMysticRechargeable extends Item{
	
	public int rechargeRatePerTick;
	public boolean hasCharged = false;
	public int currentCharge = 0;
	public int maxStorage;
	private boolean didCheckMods;
	public ItemStack[] mods = new ItemStack[2]; 
	public IItemMysticRechargeable(int par1, int maxEnergy, int rechargeRate) {
		super(par1);
		this.maxStorage = maxEnergy;
		this.setMaxStackSize(1);
		this.setMaxDamage(12);
		didCheckMods = false;
		rechargeRatePerTick = rechargeRate;
		// TODO Auto-generated constructor stub
	}
	 /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 0;
    }
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {

		if(par1ItemStack.getTagCompound()==null)
		  {
			  par1ItemStack.setTagCompound(new NBTTagCompound());
		  }
		  NBTTagCompound tag = par1ItemStack.getTagCompound();
		  if(tag.getInteger("MaxStorage")!= 0)
		  if(tag.getInteger("RechargeRate")==0)
			  tag.setInteger("RechargeRate", this.rechargeRatePerTick);
		  if(mods[0] == null || mods[1] == null)
		  {
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
    
	/**
	 * 
	 * @param par2EntityLivingBase - creature
	 * @param par3EntityLivingBase - player
	 * @return returns extra damage to do if there is any
	 */
	public int doModuleHitAdditions(EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase) // attacked creature, player
	{
		if(par3EntityLivingBase instanceof EntityPlayer)
		{
			 NBTTagCompound tag = ((EntityPlayer)par3EntityLivingBase).getCurrentEquippedItem().getTagCompound();
			 if(tag!=null)
			 {
				 NBTTagList var2 = tag.getTagList("Items");
				 if(var2!=null&&var2.tagCount()>0)
				 {
					 if(var2.tagAt(0)!=null)
					 {
						 NBTTagCompound tag2 = (NBTTagCompound) var2.tagAt(0);
						 mods[0].readFromNBT(tag2);
						 if(tag2==null)
							 mods[0]=null;
					 }
					 if(var2.tagAt(1)!=null)
					 {
						 NBTTagCompound tag3 = (NBTTagCompound) var2.tagAt(1);
						 mods[1].readFromNBT(tag3);
						 if(tag3==null)
							 mods[1]=null;
					 }
					 if(mods[0]!=null && MysticModule.getTypeForStack(mods[0]) == MysticModule.FIRE)
			      	 {
			      		 par2EntityLivingBase.setFire(mods[0].stackSize * 20);
			      		 return 0;
			      	 }
			      	if(mods[1]!=null && MysticModule.getTypeForStack(mods[1]) == MysticModule.FIRE)
			     	 {
			     		 par2EntityLivingBase.setFire(mods[1].stackSize * 20);
			     		 return 0;
			     	 }
			      	if(mods[0]!=null && ((MysticModule.getTypeForStack(mods[0]) == MysticModule.WATER && MysticModule.getTypeForStack(mods[1]) == MysticModule.AIR) || (MysticModule.getTypeForStack(mods[0]) == MysticModule.AIR && MysticModule.getTypeForStack(mods[1]) == MysticModule.WATER)))
			     	 {
			     		 par2EntityLivingBase.addPotionEffect(new PotionEffect(MysticModPotions.FREEZE_ID, 10*mods[0].stackSize+ 10*mods[1].stackSize, 0));
			     		 return 2;
			     		 
			     	 }
			      	if(mods[0]!=null && (MysticModule.getTypeForStack(mods[0]) == MysticModule.AIR)) // knockback determined by 0.4*mods[0].stackSize
			      	{
			      		par2EntityLivingBase.addVelocity((double)(-MathHelper.sin(par3EntityLivingBase.rotationYaw * (float)Math.PI / 180.0F) * (float)0.4*mods[0].stackSize * 0.5F), 0.1D, (double)(MathHelper.cos(par3EntityLivingBase.rotationYaw * (float)Math.PI / 180.0F) * (float)0.4*mods[0].stackSize * 0.5F));
			      		return 0;
			      	}
			      	if(mods[1]!=null && (MysticModule.getTypeForStack(mods[1]) == MysticModule.AIR))
			      	{
			      		par2EntityLivingBase.addVelocity((double)(-MathHelper.sin(par3EntityLivingBase.rotationYaw * (float)Math.PI / 180.0F) * (float)0.4*mods[1].stackSize * 0.5F), 0.1D, (double)(MathHelper.cos(par3EntityLivingBase.rotationYaw * (float)Math.PI / 180.0F) * (float)0.4*mods[1].stackSize * 0.5F));
			      		return 0;
			      	}
			      	if(mods[0]!=null && mods[1]!=null && (MysticModule.getTypeForStack(mods[0]) == MysticModule.EARTH) && (MysticModule.getTypeForStack(mods[1]) == MysticModule.EARTH))
			      	{
			      		System.out.println(0.5F*mods[0].stackSize);
			      		return (int) (mods[0].stackSize+mods[1].stackSize);
			      	}
			      	if(mods[0]!=null && (MysticModule.getTypeForStack(mods[0]) == MysticModule.EARTH))
			      	{
			      		System.out.println(0.5F*mods[0].stackSize);
			      		return (int) (1F*mods[0].stackSize);
			      	}
			      	if(mods[1]!=null && (MysticModule.getTypeForStack(mods[1]) == MysticModule.EARTH))
			      	{
			      		System.out.println(0.5F*mods[1].stackSize);
			      		return (int) (1*mods[1].stackSize);
			      	}
				}
			}
		}
      	return 0;
	}
	/**
	 * 
	 * @param drops the drops of the block being mined
	 * @return the modified itemstack after applying modifiers
	 */
	public ItemStack doModuleMineAdditions(ArrayList<ItemStack> drops, ItemStack heldItem)
	{
		if(drops!=null && drops.size() !=0 && drops.get(0).getItem()!=null)
		{
		ItemStack temp = new ItemStack(drops.get(0).getItem(), 1, drops.get(0).getItemDamage());
		if(EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, heldItem) > 0)
		{
			temp.stackSize--;
			return temp;
		}
		if(mods[0]!=null && MysticModule.getTypeForStack(mods[0]) == MysticModule.WATER && MysticModule.getTypeForStack(mods[1])!= MysticModule.FIRE && MysticModule.getTypeForStack(mods[1])!= MysticModule.WATER && EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, heldItem) <=0)
     	 {
			
			for(int i = 1; i < drops.size(); i++)
			{
				if(temp.getItem() == drops.get(i).getItem())
				{
					temp.stackSize++;
				}
			}
			if(!(temp.getItem() instanceof ItemBlock))
				temp.stackSize+=(0.08*mods[0].stackSize*4.5*( Math.random()+0.5));
			return temp;
     	 }
		else if(mods[1]!=null && MysticModule.getTypeForStack(mods[1]) == MysticModule.WATER && MysticModule.getTypeForStack(mods[0])!= MysticModule.FIRE && MysticModule.getTypeForStack(mods[0])!= MysticModule.WATER  && EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, heldItem) <=0)
		{
			for(int i = 1; i < drops.size(); i++)
			{
				if(temp.getItem() == drops.get(i).getItem())
				{
					temp.stackSize++;
				}
			}
			if(!(temp.getItem() instanceof ItemBlock))
			temp.stackSize+=(0.08*mods[0].stackSize*( Math.random()+0.5));
			return temp;
		}
		else if(MysticModule.getTypeForStack(mods[0]) == MysticModule.WATER && MysticModule.getTypeForStack(mods[0]) == MysticModule.WATER  && EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, heldItem) <=0)
		{
			for(int i = 1; i < drops.size(); i++)
			{
				if(temp.getItem() == drops.get(i).getItem())
				{
					temp.stackSize++;
				}
			}
			if(!(temp.getItem() instanceof ItemBlock))
			temp.stackSize+=(0.08*mods[0].stackSize*mods[1].stackSize*( Math.random()+0.5));
			return temp;
		}
		else if(((MysticModule.getTypeForStack(mods[0]) == MysticModule.FIRE && MysticModule.getTypeForStack(mods[1])== MysticModule.WATER) || (MysticModule.getTypeForStack(mods[1]) == MysticModule.FIRE && MysticModule.getTypeForStack(mods[0])== MysticModule.WATER))  && EnchantmentHelper.getEnchantmentLevel(Enchantment.silkTouch.effectId, heldItem) <=0)
		{
			for(int i = 1; i < drops.size(); i++)
			{
				if(temp.getItem() == drops.get(i).getItem())
				{
					temp.stackSize++;
				}
			}
			if(FurnaceRecipes.smelting().getSmeltingResult(temp)!=null)
			{
				if(MysticModule.getTypeForStack(mods[0]) == MysticModule.FIRE && this.calcSmeltChance((byte)mods[0].stackSize))
					temp = FurnaceRecipes.smelting().getSmeltingResult(temp);
				else if(MysticModule.getTypeForStack(mods[1]) == MysticModule.FIRE && this.calcSmeltChance((byte)mods[1].stackSize))
					temp = FurnaceRecipes.smelting().getSmeltingResult(temp);
			}
			if(!(temp.getItem() instanceof ItemBlock))
			temp.stackSize+=(0.08*mods[0].stackSize*mods[1].stackSize*( Math.random()+0.1));
			return temp;
		}
		else if((MysticModule.getTypeForStack(mods[0]) == MysticModule.FIRE && MysticModule.getTypeForStack(mods[1]) != MysticModule.FIRE) || (MysticModule.getTypeForStack(mods[1]) == MysticModule.FIRE && MysticModule.getTypeForStack(mods[0]) != MysticModule.FIRE))
		{
			for(int i = 1; i < drops.size(); i++)
			{
				if(temp.getItem() == drops.get(i).getItem())
				{
					temp.stackSize++;
				}
			}
			if(FurnaceRecipes.smelting().getSmeltingResult(temp)!=null)
			{
				if(MysticModule.getTypeForStack(mods[0]) == MysticModule.FIRE && this.calcSmeltChance((byte)mods[0].stackSize))
					temp = FurnaceRecipes.smelting().getSmeltingResult(temp);
				else if(MysticModule.getTypeForStack(mods[1]) == MysticModule.FIRE && this.calcSmeltChance((byte)mods[1].stackSize))
					temp = FurnaceRecipes.smelting().getSmeltingResult(temp);
			}
			return temp;
		}
		else if(MysticModule.getTypeForStack(mods[0]) == MysticModule.FIRE && MysticModule.getTypeForStack(mods[1]) == MysticModule.FIRE)
		{
			for(int i = 1; i < drops.size(); i++)
			{
				if(temp.getItem() == drops.get(i).getItem())
				{
					temp.stackSize++;
				}
			}
			if(FurnaceRecipes.smelting().getSmeltingResult(temp)!=null)
			{
				if(MysticModule.getTypeForStack(mods[0]) == MysticModule.FIRE && this.calcSmeltChance((byte)mods[0].stackSize))
					temp = FurnaceRecipes.smelting().getSmeltingResult(temp);
			}
			
			return temp;
		}
		
		return temp;
		}
		else return null;
	}
	/**
	 * @param stackSize - size of the module stack - >=8 is always true
	 * @return if by chance the item smelted, increased chance for increased stack size 
	 */
	public boolean calcSmeltChance(byte stackSize)
	{
		if(stackSize >= 8)
			return true;
		if((Math.random() + 0.2)*stackSize >= 1)
			return true;
		return false;
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
			MysticModule mod = (MysticModule) mods[0].getItem();
			switch(mod.type)
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
				  MysticModule mod = (MysticModule) mods[1].getItem();
				switch(mod.type)
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
		 
		  if(this.currentCharge<tag.getInteger("MaxStorage"))
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

package com.sudwood.mysticadditions;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

import com.sudwood.mysticadditions.enchantments.EnchantmentRegister;
import com.sudwood.mysticadditions.items.MysticModItems;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeable;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeableArmor;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class PlayerTickHandler implements ITickHandler {
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		if(type.contains(TickType.PLAYER)&&tickData[0] instanceof EntityPlayerMP)
		{
			this.flightTick((EntityPlayer)tickData[0]);
			
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	public void flightTick(EntityPlayer player)
	{
		ItemStack heldStack = player.inventory.getCurrentItem();
		boolean ison = false;
		/*
		for(int i = 0; i<4;i++)
		{
			
			if(player.inventory.armorItemInSlot(i)!=null)
			{
			
			ItemStack tempStack = player.inventory.armorItemInSlot(i);
			if(tempStack.getTagCompound()==null)
			  {
				tempStack.setTagCompound(new NBTTagCompound());
			  }
			NBTTagCompound tag = tempStack.getTagCompound();
			
			if(EnchantmentHelper.getEnchantmentLevel(EnchantmentRegister.Flight.effectId,tempStack )>0)
			{
				
			if(tempStack.getItem() instanceof IItemMysticRechargeableArmor)
			{
				int charge = tag.getInteger("CurrentCharge");
				
				if(charge>=5)
			 	{				
				 ison = true;
			 	 player.capabilities.allowFlying = true;
				 
				 player.sendPlayerAbilities();
				
					if(player.capabilities.isFlying)
					{
						charge-=5;
						tag.setInteger("CurrentCharge", charge);
					}
			 	}
			 else if(charge<5&&!ison)
			 	{
				 player.capabilities.allowFlying = false;
				 player.capabilities.isFlying = false;
				
				 
				 player.sendPlayerAbilities();
			 	}
			}
			else if(tempStack.getItemDamage()<tempStack.getMaxDamage()-1)
			{
			player.capabilities.allowFlying = true;
			ison = true;
			
			player.sendPlayerAbilities();
				if(player.capabilities.isFlying)
				{
					if(!(tempStack.getItem() instanceof IItemMysticRechargeableArmor))
					{
					tempStack.setItemDamage(tempStack.getItemDamage()+1);
					}
			
			
				}
		
			}
			else if(tempStack.getItemDamage()>=tempStack.getMaxDamage()-1)
			{
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
				
				player.sendPlayerAbilities();
			}
			
			}
				if(!tempStack.isItemEnchanted()&&!player.capabilities.isCreativeMode&&!ison)
				{
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;			
				
				player.sendPlayerAbilities();			
				}
			}
			

			
		 	
		}
		if((player.inventory.armorItemInSlot(0) == null||player.inventory.armorItemInSlot(1) == null||player.inventory.armorItemInSlot(2) == null||player.inventory.armorItemInSlot(3) == null)&&!player.capabilities.isCreativeMode&&!ison)
		{
			player.capabilities.allowFlying = false;
			player.capabilities.isFlying = false;
		
			if(player.inventory.armorItemInSlot(0)==null)
			{
				player.stepHeight = 0.5F;
			}
			if(player.inventory.armorItemInSlot(1)==null)
			{
				player.landMovementFactor = 0;
				player.jumpMovementFactor = 0;
			}
			
			player.sendPlayerAbilities();
			
			
		}
		
		
		*/
		
		
		
		
		
		
		
		
		
		if(player.inventory.getCurrentItem() != null&&player.inventory.getCurrentItem().isItemEnchanted()&&!player.capabilities.isCreativeMode)
		{
			if(player.inventory.getCurrentItem().getTagCompound()==null)
			  {
				player.inventory.getCurrentItem().setTagCompound(new NBTTagCompound());
			  }
			 NBTTagCompound tag = player.inventory.getCurrentItem().getTagCompound();
			if(EnchantmentHelper.getEnchantmentLevel(EnchantmentRegister.Flight.effectId, player.inventory.getCurrentItem())>0)
			{
			
				
			if(heldStack.getItem() instanceof IItemMysticRechargeable)
				{
				
				 int charge = tag.getInteger("CurrentCharge");
				 	if(charge>=5)
				 	{
				 	 player.capabilities.allowFlying = true;
					 
					 player.sendPlayerAbilities();
					 ison = true;
						if(player.capabilities.isFlying)
						{
							charge-=5;
							tag.setInteger("CurrentCharge", charge);
						}
				 	}
				 else if(!ison)
				 	{
					 player.capabilities.allowFlying = false;
					 player.capabilities.isFlying = false;
				
					 
					 player.sendPlayerAbilities();
				 	}
				 
				}
			else if(player.inventory.getCurrentItem().getItemDamage()<player.inventory.getCurrentItem().getMaxDamage()-1)
			{
			player.capabilities.allowFlying = true;
			ison = true;
			
			player.sendPlayerAbilities();
				if(player.capabilities.isFlying)
				{
					if(!(heldStack.getItem() instanceof IItemMysticRechargeable))
					{
					player.inventory.getCurrentItem().setItemDamage(player.inventory.getCurrentItem().getItemDamage()+1);
					}
			
			
				}
		
			}
			else if(!ison)
			{
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
		
				
				player.sendPlayerAbilities();
				
			}
			}
			else if(!ison)
			{
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
				
				
				player.sendPlayerAbilities();
			}
			
	    }
		
		if(player.inventory.getCurrentItem() != null&&!player.inventory.getCurrentItem().isItemEnchanted()&&!player.capabilities.isCreativeMode&&!ison)
		{
			player.capabilities.allowFlying = false;
			player.capabilities.isFlying = false;
			
			
			player.sendPlayerAbilities();
			
		}
		if(player.inventory.getCurrentItem() == null&&!player.capabilities.isCreativeMode&&!ison)
		{
			player.capabilities.allowFlying = false;
			player.capabilities.isFlying = false;
	
			
			player.sendPlayerAbilities();
			
		}
		
		
	}

}

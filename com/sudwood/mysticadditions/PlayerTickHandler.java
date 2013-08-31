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
			this.flightTick((EntityPlayerMP)tickData[0]);
			
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
		
		
			//need to check for flight before checking null fields
		
		
		for(int i = 0; i<4;i++)
		{
			if(player.inventory.armorItemInSlot(i)!=null&&EnchantmentHelper.getEnchantmentLevel(EnchantmentRegister.Flight.effectId,player.inventory.armorItemInSlot(i) )>0)
			{
				if(player.inventory.armorItemInSlot(i).getItem() instanceof IItemMysticRechargeableArmor)
				{
					NBTTagCompound tag = player.inventory.armorItemInSlot(i).getTagCompound();
					int charge = tag.getInteger("CurrentCharge");
					if(charge >=5)
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
					
				}
				else if (player.inventory.armorItemInSlot(i).getItemDamage()<player.inventory.armorItemInSlot(i).getMaxDamage()-1)
				{
					ison = true;
				 	 player.capabilities.allowFlying = true;
					 
					 player.sendPlayerAbilities();
					
						if(player.capabilities.isFlying)
						{
							player.inventory.armorItemInSlot(i).setItemDamage(player.inventory.armorItemInSlot(i).getItemDamage()+1);
						}
				}
				
				
				
				
			}
			
		 	
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
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
							((IItemMysticRechargeable) heldStack.getItem()).setItemDamageByCharge(heldStack);
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
			else if(heldStack.getItemDamage()>=heldStack.getMaxDamage()-1&&!ison)
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
				
				//player.capabilities.setPlayerWalkSpeed(0.05F);
				player.jumpMovementFactor = 0;
			}
			
			player.sendPlayerAbilities();
			
			
		}
		
		for (int ix =0; ix<4; ix++)
		{
			if(player.inventory.armorItemInSlot(ix)!=null&&player.inventory.armorItemInSlot(ix).getItem() instanceof IItemMysticRechargeable&&!player.capabilities.isCreativeMode&&!ison)
			{
				NBTTagCompound tag = player.inventory.armorItemInSlot(ix).getTagCompound();
				if(tag.getInteger("CurrentCharge")<5&&!ison)
				{
					 
					 player.capabilities.allowFlying = false;
					 player.capabilities.isFlying = false;
					
					 
					 player.sendPlayerAbilities();
				}
			}
			else if(player.inventory.armorItemInSlot(ix)!=null&&player.inventory.armorItemInSlot(ix).getItemDamage()>=player.inventory.armorItemInSlot(ix).getMaxDamage()-1&&!player.capabilities.isCreativeMode&&!ison)
			{
				
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
				
				player.sendPlayerAbilities();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}

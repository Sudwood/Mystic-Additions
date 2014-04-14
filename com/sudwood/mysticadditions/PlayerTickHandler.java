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
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class PlayerTickHandler implements ITickHandler {
	boolean flightItems[] = {false, false, false, false, false };
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {

		if(type.contains(TickType.PLAYER)&&tickData[0] instanceof EntityPlayerMP)
		{
			this.flightTick((EntityPlayerMP)tickData[0]);
			
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Used for flight enchantments";
	}
	
	
	
	
	
	
		public void flightTick(EntityPlayer player)
		{
			
			if(!player.worldObj.isRemote)
			{
				
				if(player.inventory.armorItemInSlot(2)==null)
				{
					player.capabilities.setFlySpeed(0.05F);
				}
				if(player.inventory.armorItemInSlot(1)==null)
				{
					player.capabilities.setPlayerWalkSpeed(0.1F);
					player.jumpMovementFactor = 0.02F;
				}
				if(player.inventory.armorItemInSlot(0)==null)
				{
					
					player.stepHeight = 0.5F;
				}

				
				
			ItemStack heldStack = player.inventory.getCurrentItem();
			
			//need to check for flight before checking null fields
			
			
			for(int i = 0; i<4;i++)
			{
				if(player.inventory.armorItemInSlot(i) == null)
					flightItems[i] = false;
				if(player.inventory.armorItemInSlot(i)!=null&&EnchantmentHelper.getEnchantmentLevel(EnchantmentRegister.Flight.effectId,player.inventory.armorItemInSlot(i) )>0)
				{
					if(player.inventory.armorItemInSlot(i).getItem() instanceof IItemMysticRechargeableArmor)
					{
						NBTTagCompound tag = player.inventory.armorItemInSlot(i).getTagCompound();
						int charge = tag.getInteger("CurrentCharge");
						if(charge >=5)
						{
							flightItems[i] = true;
								if(player.capabilities.isFlying)
								{
									charge-=5;
									tag.setInteger("CurrentCharge", charge);
								}
						}
						else if(charge<5)
						{
							flightItems[i] = false;
						}
						
					}
					else if (player.inventory.armorItemInSlot(i).getItemDamage()<player.inventory.armorItemInSlot(i).getMaxDamage()-1)
					{
						flightItems[i] = true;					
							if(player.capabilities.isFlying)
							{
								player.inventory.armorItemInSlot(i).setItemDamage(player.inventory.armorItemInSlot(i).getItemDamage()+1);
							}
					}
					else if (!(player.inventory.armorItemInSlot(i).getItemDamage()<player.inventory.armorItemInSlot(i).getMaxDamage()-1))
					{
						flightItems[i] = false;
					}
				}
				if(player.inventory.armorItemInSlot(i)!=null&&EnchantmentHelper.getEnchantmentLevel(EnchantmentRegister.Flight.effectId,player.inventory.armorItemInSlot(i) )<=0)
				{
					flightItems[i] = false;
				}
				
			}
			if(player.inventory.getCurrentItem() == null)
				flightItems[4] = false;
			if(player.inventory.getCurrentItem() != null&&EnchantmentHelper.getEnchantmentLevel(EnchantmentRegister.Flight.effectId,player.getCurrentEquippedItem() )>0&&!player.capabilities.isCreativeMode)
			{
				if(heldStack.getItem() instanceof IItemMysticRechargeable)
					{
					if(player.inventory.getCurrentItem().getTagCompound()==null)
					  {
						player.inventory.getCurrentItem().setTagCompound(new NBTTagCompound());
					  }
					 NBTTagCompound tag = player.inventory.getCurrentItem().getTagCompound();
					 int charge = tag.getInteger("CurrentCharge");
					 	if(charge>=5)
					 	{
					 	flightItems[4] = true;
							if(player.capabilities.isFlying)
							{
								charge-=5;
								tag.setInteger("CurrentCharge", charge);
								((IItemMysticRechargeable) heldStack.getItem()).setItemDamageByCharge(heldStack);
							}
					 	}
					 	else if(charge<5)
					 	{
					 		flightItems[4] = false;
					 	}
					 
					}
				else if(player.inventory.getCurrentItem().getItemDamage()<player.inventory.getCurrentItem().getMaxDamage()-1)
				{
					
					flightItems[4] = true;
					
					if(player.capabilities.isFlying)
					{
						if(!(heldStack.getItem() instanceof IItemMysticRechargeable))
						{
						player.inventory.getCurrentItem().setItemDamage(player.inventory.getCurrentItem().getItemDamage()+1);
						}
				
				
					}
			
				}
				else if(heldStack.getItemDamage()>=heldStack.getMaxDamage()-1)
				{			 
					flightItems[4] = false;				
				}
		    }
			if(player.inventory.getCurrentItem() != null&&EnchantmentHelper.getEnchantmentLevel(EnchantmentRegister.Flight.effectId,player.getCurrentEquippedItem() )<=0&&!player.capabilities.isCreativeMode)
			{
				flightItems[4] = false;
			}
			if(flightItems[0] || flightItems[1] || flightItems[2] || flightItems[3] || flightItems[4])
			{
				player.capabilities.allowFlying = true;
				player.sendPlayerAbilities();
			}
			else if(!player.capabilities.isCreativeMode)
			{
				player.capabilities.allowFlying = false;
				if(player.capabilities.isFlying)
					player.capabilities.isFlying = false;
				player.sendPlayerAbilities();
			}
		}
			
	}
				
		
}


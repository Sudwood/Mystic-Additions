package com.sudwood.mysticadditions;

import java.util.EnumSet;

import com.sudwood.mysticadditions.items.MysticModItems;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeableArmor;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.server.FMLServerHandler;

public class ArmorTickHandler {
	
	
	
	
	
	
	
	
	
	
	@ForgeSubscribe
	public void entityAttacked(LivingAttackEvent event)
	{
		EntityLiving attackedEnt = event.entityLiving;
		DamageSource attackSource = event.source;
		if(attackedEnt instanceof EntityPlayer)
		{
			ItemStack helmStack = ((EntityPlayer) attackedEnt).inventory.armorItemInSlot(3);
			ItemStack chestStack = ((EntityPlayer) attackedEnt).inventory.armorItemInSlot(2);
			ItemStack legsStack = ((EntityPlayer) attackedEnt).inventory.armorItemInSlot(1);
			ItemStack bootsStack = ((EntityPlayer) attackedEnt).inventory.armorItemInSlot(0);
			
			
			
			
			if(attackSource == DamageSource.fall)
			{
				
				if(bootsStack!=null&&bootsStack.getItem() instanceof IItemMysticRechargeableArmor)
				{
					
					if(bootsStack.getTagCompound()==null)
					  {
						((EntityPlayer) attackedEnt).inventory.armorItemInSlot(0).setTagCompound(new NBTTagCompound());
					  }
					 NBTTagCompound tag = ((EntityPlayer) attackedEnt).inventory.armorItemInSlot(0).getTagCompound();
					 
					 int charge = tag.getInteger("CurrentCharge");
					 if(charge<event.ammount*48)
					 {
						
						 int damageDone = event.ammount-charge/48;
						 charge = 0;
						 tag.setInteger("CurrentCharge", charge);
						 attackedEnt.attackEntityFrom(DamageSource.magic, damageDone);
						 event.setCanceled(true);
					 }
					 if(charge>event.ammount*48)
					 {
						
						 charge -= event.ammount*48;
						 tag.setInteger("CurrentCharge", charge);
						 if(charge< tag.getInteger("MaxStorage")/25)
						 ((EntityPlayer) attackedEnt).sendChatToPlayer("Boots Below 25% charge!");
						 event.setCanceled(true);
						 
					 }
					 
					 
				}
			}
			
			if(attackSource == DamageSource.drown)
			{
				
				if(helmStack!=null&&helmStack.getItem() instanceof IItemMysticRechargeableArmor)
				{
					if(helmStack.getTagCompound()==null)
					  {
						  helmStack.setTagCompound(new NBTTagCompound());
					  }
					 NBTTagCompound tag = helmStack.getTagCompound();
					 
					 int charge = tag.getInteger("CurrentCharge");
					 if(charge<event.ammount*48)
					 {
						 int damageDone = event.ammount-charge/48;
						 charge = 0;
						 tag.setInteger("CurrentCharge", charge);
						 attackedEnt.attackEntityFrom(DamageSource.magic, damageDone);
						 event.setCanceled(true);
					 }
					 if(charge>event.ammount*48)
					 {
						 charge -= event.ammount*48;
						 tag.setInteger("CurrentCharge", charge);
						 if(charge< tag.getInteger("MaxStorage")/25)
							 ((EntityPlayer) attackedEnt).sendChatToPlayer("Helm Below 25% charge!");
						 event.setCanceled(true);
						 
					 }
					 
					 
				}
			}
			
			if(attackSource!= DamageSource.magic&&attackSource!=DamageSource.fall&&attackSource!= DamageSource.drown)
			{
			
			if((helmStack!=null&&helmStack.getItem() instanceof IItemMysticRechargeableArmor)||(chestStack!=null&&chestStack.getItem() instanceof IItemMysticRechargeableArmor)||(legsStack!=null&&legsStack.getItem() instanceof IItemMysticRechargeableArmor)||(bootsStack!=null&&bootsStack.getItem() instanceof IItemMysticRechargeableArmor))
			{
				boolean[] peices = new boolean[4];
				int number = 0;
				if(helmStack!=null&&helmStack.getItem() instanceof IItemMysticRechargeableArmor)
				{
					peices[0] = true;
					number++;
				}
				if(chestStack!=null&&chestStack.getItem() instanceof IItemMysticRechargeableArmor)
				{
					peices[1] = true;
					number++;
				}
				if(legsStack!=null&&legsStack.getItem() instanceof IItemMysticRechargeableArmor)
				{
					peices[2] = true;
					number++;
				}
				if(bootsStack!=null&&bootsStack.getItem() instanceof IItemMysticRechargeableArmor)
				{
					peices[3] = true;
					number++;
				}
				
				if(peices[0])
				{
					if(helmStack.getTagCompound()==null)
					  {
						  helmStack.setTagCompound(new NBTTagCompound());
					  }
					NBTTagCompound tag = helmStack.getTagCompound();
					int helmCharge = tag.getInteger("CurrentCharge");
					if(helmCharge>(event.ammount*48)/number)
					{
						helmCharge-=((event.ammount*48)/number);
						if(helmCharge< tag.getInteger("MaxStorage")/25)
							 ((EntityPlayer) attackedEnt).sendChatToPlayer("helm Below 25% charge!");
						event.setCanceled(true);
					}
					if(helmCharge<(event.ammount*48)/number)
					{
						int damageDone = (((event.ammount*48)/number) - helmCharge)/4;
						attackedEnt.attackEntityFrom(DamageSource.magic, damageDone);
						helmCharge =0;
						event.setCanceled(true);
					}
					tag.setInteger("CurrentCharge", helmCharge);
					
				}
				if(peices[1])
				{
					if(chestStack.getTagCompound()==null)
					  {
						  chestStack.setTagCompound(new NBTTagCompound());
					  }
					NBTTagCompound tag = chestStack.getTagCompound();
					int chestCharge = tag.getInteger("CurrentCharge");
					if(chestCharge>(event.ammount*48)/number)
					{
						chestCharge-=((event.ammount*48)/number);
						if(chestCharge< tag.getInteger("MaxStorage")/25)
							 ((EntityPlayer) attackedEnt).sendChatToPlayer("Chest Below 25% charge!");
						event.setCanceled(true);
					}
					if(chestCharge<(event.ammount*48)/number)
					{
						int damageDone = (((event.ammount*48)/number) - chestCharge)/4;
						attackedEnt.attackEntityFrom(DamageSource.magic, damageDone);
						chestCharge =0;
						event.setCanceled(true);
					}
					tag.setInteger("CurrentCharge", chestCharge);
					
				}
				if(peices[2])
				{
					if(legsStack.getTagCompound()==null)
					  {
						  legsStack.setTagCompound(new NBTTagCompound());
					  }
					NBTTagCompound tag = legsStack.getTagCompound();
					int legsCharge = tag.getInteger("CurrentCharge");
					if(legsCharge>(event.ammount*48)/number)
					{
						legsCharge-=((event.ammount*48)/number);
						if(legsCharge< tag.getInteger("MaxStorage")/25)
							 ((EntityPlayer) attackedEnt).sendChatToPlayer("Legs Below 25% charge!");
						event.setCanceled(true);
					}
					if(legsCharge<(event.ammount*48)/number)
					{
						int damageDone = (((event.ammount*48)/number) - legsCharge)/4;
						attackedEnt.attackEntityFrom(DamageSource.magic, damageDone);
						legsCharge =0;
						event.setCanceled(true);
					}
					tag.setInteger("CurrentCharge", legsCharge);
					
				}
				if(peices[3])
				{
					if(bootsStack.getTagCompound()==null)
					  {
						  bootsStack.setTagCompound(new NBTTagCompound());
					  }
					NBTTagCompound tag = bootsStack.getTagCompound();
					int bootsCharge = tag.getInteger("CurrentCharge");
					if(bootsCharge>(event.ammount*48)/number)
					{
						bootsCharge-=((event.ammount*48)/number);
						if(bootsCharge< tag.getInteger("MaxStorage")/25)
							 ((EntityPlayer) attackedEnt).sendChatToPlayer("Boots Below 25% charge!");
						event.setCanceled(true);
					}
					if(bootsCharge<(event.ammount*48)/number)
					{
						int damageDone = (((event.ammount*48)/number) - bootsCharge)/4;
						attackedEnt.attackEntityFrom(DamageSource.magic, damageDone);
						bootsCharge =0;
						event.setCanceled(true);
					}
					tag.setInteger("CurrentCharge", bootsCharge);
					
				}
			}
				
				
				
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
		}
	}
	
	

}

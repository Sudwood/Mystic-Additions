package com.sudwood.mysticadditions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeableArmor;

public class ArmorTickHandler {
	
	
	
	
	
	
	
	
	
	
	@ForgeSubscribe
	public void entityAttacked(LivingAttackEvent event)
	{
		EntityLivingBase attackedEnt = event.entityLiving;
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
						
						 float damageDone = (int) (event.ammount-charge/48);
						 charge = 0;
						 tag.setInteger("CurrentCharge", charge);
						 attackedEnt.attackEntityFrom(DamageSource.magic, damageDone);
						 event.setCanceled(true);
					 }
					 if(charge>event.ammount*48)
					 {
						
						 charge -= event.ammount*48;
						 tag.setInteger("CurrentCharge", charge);
						 if(charge< tag.getInteger("MaxStorage")/4)
						 ((EntityPlayer) attackedEnt).addChatMessage("Boots Below 25% charge!");
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
						 float damageDone = event.ammount-charge/48;
						 charge = 0;
						 tag.setInteger("CurrentCharge", charge);
						 attackedEnt.attackEntityFrom(DamageSource.magic, damageDone);
						 event.setCanceled(true);
					 }
					 if(charge>event.ammount*48)
					 {
						 charge -= event.ammount*48;
						 tag.setInteger("CurrentCharge", charge);
						 if(charge< tag.getInteger("MaxStorage")/4)
							 ((EntityPlayer) attackedEnt).addChatMessage("Helm Below 25% charge!");
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
						if(helmCharge< tag.getInteger("MaxStorage")/4)
							 ((EntityPlayer) attackedEnt).addChatMessage("helm Below 25% charge!");
						event.setCanceled(true);
					}
					if(helmCharge<(event.ammount*48)/number)
					{
						float damageDone = (((event.ammount*48)/number) - helmCharge)/4;
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
						if(chestCharge< tag.getInteger("MaxStorage")/4)
							 ((EntityPlayer) attackedEnt).addChatMessage("Chest Below 25% charge!");
						event.setCanceled(true);
					}
					if(chestCharge<(event.ammount*48)/number)
					{
						float damageDone = (((event.ammount*48)/number) - chestCharge)/4;
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
						if(legsCharge< tag.getInteger("MaxStorage")/4)
							 ((EntityPlayer) attackedEnt).addChatMessage("Legs Below 25% charge!");
						event.setCanceled(true);
					}
					if(legsCharge<(event.ammount*48)/number)
					{
						float damageDone = (((event.ammount*48)/number) - legsCharge)/4;
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
						if(bootsCharge< tag.getInteger("MaxStorage")/4)
							 ((EntityPlayer) attackedEnt).addChatMessage("Boots Below 25% charge!");
						event.setCanceled(true);
					}
					if(bootsCharge<(event.ammount*48)/number)
					{
						float damageDone = (((event.ammount*48)/number) - bootsCharge)/4;
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

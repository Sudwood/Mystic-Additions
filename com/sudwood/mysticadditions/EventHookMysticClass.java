package com.sudwood.mysticadditions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

import com.sudwood.mysticadditions.items.energy.ItemCaptureReceptacle;
import com.sudwood.mysticadditions.items.potions.MysticModPotions;

public class EventHookMysticClass {

	
	
	@ForgeSubscribe
	public void onLivingDrops(LivingDropsEvent event)
	{
		
	}
	
	@ForgeSubscribe
	public void EntityInteract(EntityInteractEvent event)
	{
		if(event.target instanceof EntityCreature&& !event.entityPlayer.worldObj.isRemote)
		{
			if(event.entityPlayer.getCurrentEquippedItem()!=null&&event.entityPlayer.getCurrentEquippedItem().getItem() instanceof ItemCaptureReceptacle)
			{
				NBTTagCompound tag = event.entityPlayer.getCurrentEquippedItem().getTagCompound();
				System.out.println("doingstuff");
				if(!tag.getBoolean("hasEntity"))
				{
					event.target.writeToNBT(tag);
					tag.setString("className", event.target.getClass().getName());
					tag.setString("EntityName", event.target.getEntityName());
					tag.setString("EntityLife", ((EntityCreature)event.target).getMaxHealth()/2+"");
					tag.setBoolean("hasEntity", true);
				}
			}
		}
	}
	
	
	@ForgeSubscribe
	public void onEntityUpdate(LivingUpdateEvent event) 
	{
	
	if (event.entityLiving.isPotionActive(MysticModPotions.freezePotion)) 
	{
		World world = event.entityLiving.worldObj;
	if(!world.isRemote)
	{
	event.entityLiving.motionX = 0;
	event.entityLiving.motionY = 0;
	event.entityLiving.motionZ = 0;
	}
	if(world.isRemote)
	{
		world.spawnParticle("splash", event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, 200, 200, 200);
	}
	}
	}
	@ForgeSubscribe
	public void onEntityConstructing(EntityConstructing event)
	{
		/*
		Be sure to check if the entity being constructed is the correct type for the extended properties you're about to add! The null check may not be necessary - I only use it to make sure properties are only registered once per entity
		*/
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null)
		// This is how extended properties are registered using our convenient method from earlier
			ExtendedPlayer.register((EntityPlayer) event.entity);
		
	}
	
	@ForgeSubscribe
	public void onLivingDeathEvent(LivingDeathEvent event)
	{
	// we only want to save data for players (most likely, anyway)
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			// NOTE: See step 6 for a way to do this all in one line!!!
			// create a new NBT Tag Compound to store the IExtendedEntityProperties data
			NBTTagCompound playerData = new NBTTagCompound();
			// write the data to the new compound
			((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).saveNBTData(playerData);
			// and store it in our proxy
			MysticCommonProxy.storeEntityData(((EntityPlayer) event.entity).username, playerData);
			
		}
	}

	// we already have this event, but we need to modify it some
	@ForgeSubscribe
	public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			// NOTE: See step 6 for a way to do this all in one line!!!
			// before syncing the properties, we must first check if the player has some saved in the proxy
			// recall that 'getEntityData' also removes it from the map, so be sure to store it locally
			NBTTagCompound playerData = MysticCommonProxy.getEntityData(((EntityPlayer) event.entity).username);
			// make sure the compound isn't null
			if (playerData != null) {
			// then load the data back into the player's IExtendedEntityProperties
			((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).loadNBTData(playerData);
			}
		}
	}
	
	
}
	
	
	


package com.sudwood.mysticadditions;

import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import com.sudwood.mysticadditions.items.potions.MysticModPotions;

public class EventHookMysticClass {

	
	@ForgeSubscribe
	public void onEntityUpdate(LivingUpdateEvent event) 
	{
	
	if (event.entityLiving.isPotionActive(MysticModPotions.freezePotion)) 
	{
	event.entityLiving.motionX = 0;
	event.entityLiving.motionY = 0;
	event.entityLiving.motionZ = 0;
	World world = event.entityLiving.worldObj;
	if(world.isRemote)
	{
		world.spawnParticle("splash", event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, 200, 200, 200);
	}
	}
	}
}
	
	
	


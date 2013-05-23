package com.sudwood.mysticadditions;

import com.sudwood.mysticadditions.blocks.MysticModBlocks;
import com.sudwood.mysticadditions.items.MysticModItems;
import com.sudwood.mysticadditions.items.potions.MysticModPotions;

import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.FillBucketEvent;

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
	
	
	


package com.sudwood.mysticadditions;

import java.util.EnumSet;

import com.sudwood.mysticadditions.items.MysticModItems;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.server.FMLServerHandler;

public class ArmorTickHandler {

	

	public void OnPlayerTick() {
		MinecraftServer minecraft = FMLClientHandler.instance().getServer();
		   String allNames[] = minecraft.getAllUsernames().clone();
		   for(int i = 0; i < allNames.length; i++) {
		    EntityPlayerMP player = minecraft.getConfigurationManager().getPlayerForUsername(allNames[i]);
		   ItemStack helmStack = player.inventory.armorItemInSlot(0);
		   ItemStack chestStack = player.inventory.armorItemInSlot(1);
		   ItemStack legsStack = player.inventory.armorItemInSlot(2);
		   ItemStack bootsStack = player.inventory.armorItemInSlot(3);
		   if (helmStack!=null&&chestStack!=null&&legsStack!=null&&bootsStack!=null)
		   {
		   if (helmStack.itemID==mod_MysticAdditions.mystichelmid&&chestStack.itemID==mod_MysticAdditions.mysticchestid&&legsStack.itemID==mod_MysticAdditions.mysticlegsid&&bootsStack.itemID==mod_MysticAdditions.mysticbootsid)
		   {
			   player.addExperience(20);
			   player.landMovementFactor=1F;
		   }
		  
		   }
		   }
	}
	

}

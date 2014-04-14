package com.sudwood.mysticadditions;


import java.util.HashMap;
import java.util.Map;

import client.sudwood.mysticadditions.ClientTickHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class MysticCommonProxy implements IGuiHandler{

	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	public void registerRenderInformation() 
	  {
	  //unused server side. -- see ClientProxy for implementation
	  }

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	  {
	  // TODO Auto-generated method stub
	  return null;
	  }

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	  {
	  // TODO Auto-generated method stub
	  return null;
	  }
	
	
	public int addArmor(String armor)
	{
	    return 0;  //server doesn't care what the number is
	}
	
	public void registerServerTickHandlers()
	{

		
	}
	public static void storeEntityData(String name, NBTTagCompound compound)
	{
		extendedEntityData.put(name, compound);
	}

	/**
	* Removes the compound from the map and returns the NBT tag stored for name or null if none exists
	*/
	public static NBTTagCompound getEntityData(String name)
	{
		return extendedEntityData.remove(name);
	}
	
	
}

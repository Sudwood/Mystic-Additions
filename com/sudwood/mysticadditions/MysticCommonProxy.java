package com.sudwood.mysticadditions;


import client.sudwood.mysticadditions.ClientTickHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class MysticCommonProxy implements IGuiHandler{

	
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
		TickRegistry.registerTickHandler(new PlayerTickHandler(), Side.SERVER);
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}
	
	
	
}

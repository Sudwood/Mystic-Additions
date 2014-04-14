package com.sudwood.mysticadditions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

import com.sudwood.mysticadditions.tileentity.TileEntityLiquidStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityModuleTable;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticEnergy;
import com.sudwood.mysticadditions.tileentity.TileEntityRecallPortal;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class MysticPacketHandler implements IPacketHandler {

        @Override
        public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player playerEntity) 
        {
        	
        	if(packet.channel.equals("MysticER"))
        	{
        		handleEnergyReset(packet);
        	}
        	if(packet.channel.equals("MMOD"))
        	{
        		handleModules(packet);
        	}
        	if(packet.channel.equals("MysticLR"))
        	{
        		handleLiquidReset(packet);
        	}
        	if(packet.channel.equals("MYAD"))
        	{
        		
        		handlePacket(packet);
        	}
        }
        
        private void handlePacket(Packet250CustomPayload packet)
        {
        	DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
        	 int packetid = 0;
	       	 int worldid = 0;
	       	 int x = 0;
	       	 int y = 0;
	       	 int z = 0;
	       	 String playerName = "";
	       	 TileEntityRecallPortal tile;
	       	 
	       	 try
	       	 {
	       		 packetid = inputStream.readInt();
	       		 worldid = inputStream.readInt();
	       		 x = inputStream.readInt();
	       		 y = inputStream.readInt();
	       		 z = inputStream.readInt();
	       		 playerName = inputStream.readUTF();
	       		
	       		 
	       	 }
	       	 catch(Exception e)
	       	 {
	       		 e.printStackTrace();
	       	 }
	       	 try
	       	 {
	       		
	         if(packetid == 0)
	         {
	        	
		       	 WorldServer world = MinecraftServer.getServer().worldServerForDimension(worldid);
		       	 tile = (TileEntityRecallPortal)world.getBlockTileEntity(x , y, z);
		       	 
		       	 if(tile.getStackInSlot(0)!=null && tile.getStackInSlot(0).getTagCompound()!=null)
		       	 {
		       		
			       	 NBTTagCompound tag = tile.getStackInSlot(0).getTagCompound();
			       	System.out.println("PlayerName: "+playerName);
		       		System.out.println("creator: "+tag.getString("Creator"));
		       		System.out.println(tag.getString("Creator").equalsIgnoreCase(playerName));
			       	 if(tag.getString("Creator").equalsIgnoreCase(playerName))
			       	 {
			       		 
			       		 tile.setRestrictTravel(!tile.getRestrictTravel());
			       	 }
		       	 }
	         }
	       
	       	 }
	       	 catch(Exception e)
	       	 {
	       		 e.printStackTrace();
	       	 }
        }
        
        private void handleModules(Packet250CustomPayload packet) 
        {
        	
        	DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
	       	 int worldid = 0;
	       	 int x = 0;
	       	 int y = 0;
	       	 int z = 0;
	       	 int frequency = 0;
	       	 
	       	 try
	       	 {
	       		 worldid = inputStream.readInt();
	       		 x = inputStream.readInt();
	       		 y = inputStream.readInt();
	       		 z = inputStream.readInt();
	       		 frequency = inputStream.readInt();
	       		 
	       		 
	       	 }
	       	 catch(Exception e)
	       	 {
	       		 e.printStackTrace();
	       	 }
	       	 try
	       	 {
	       	 WorldServer world = MinecraftServer.getServer().worldServerForDimension(worldid);
	       	 TileEntityModuleTable tile = (TileEntityModuleTable) world.getBlockTileEntity(x, y, z);
	       	 tile.bindModules();
	       	 
	       
	       	 }
	       	 catch(Exception e)
	       	 {
	       		 e.printStackTrace();
	       	 }
	       	
	        	
		}



		public void handleRedCapacitor(Packet250CustomPayload packet)
        {
        	//sends world#, x, y, z, buttonid, buttonchange
        	 DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
        	 int worldid = 0;
        	 int x = 0;
        	 int y = 0;
        	 int z = 0;
        	 int buttonid = 0;
        	 int buttonchange = 0;
        	 try
        	 {
        		 worldid = inputStream.readInt();
        		 x = inputStream.readInt();
        		 y = inputStream.readInt();
        		 z = inputStream.readInt();
        		 buttonid = inputStream.readInt();
        		 buttonchange = inputStream.readInt();
        		 
        	 }
        	 catch(Exception e)
        	 {
        		 e.printStackTrace();
        	 }
        	 WorldServer world = MinecraftServer.getServer().worldServerForDimension(worldid);
        	 TileEntityMysticEnergy tile = (TileEntityMysticEnergy) world.getBlockTileEntity(x, y, z);
        	 
        	
        }
        public void handleEnergyReset(Packet250CustomPayload packet)
        {
        	//sends world#, x, y, z, frequency
        	 DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
        	 int worldid = 0;
        	 int x = 0;
        	 int y = 0;
        	 int z = 0;
        	 int frequency = 0;
        	 
        	 try
        	 {
        		 worldid = inputStream.readInt();
        		 x = inputStream.readInt();
        		 y = inputStream.readInt();
        		 z = inputStream.readInt();
        		 frequency = inputStream.readInt();
        		 
        		 
        	 }
        	 catch(Exception e)
        	 {
        		 e.printStackTrace();
        	 }
        	 try
        	 {
        	 WorldServer world = MinecraftServer.getServer().worldServerForDimension(worldid);
        	 TileEntityMysticEnergy tile = (TileEntityMysticEnergy) world.getBlockTileEntity(x, y, z);
        	 tile.resetFrequency(frequency);
        
        	 }
        	 catch(Exception e)
        	 {
        		 e.printStackTrace();
        	 }
        	
        }
        public void handleLiquidReset(Packet250CustomPayload packet)
        {
        	//sends world#, x, y, z, frequency
        	 DataInputStream inputStream = new DataInputStream(new ByteArrayInputStream(packet.data));
        	 int worldid = 0;
        	 int x = 0;
        	 int y = 0;
        	 int z = 0;
        	 int frequency = 0;
        	 
        	 try
        	 {
        		 worldid = inputStream.readInt();
        		 x = inputStream.readInt();
        		 y = inputStream.readInt();
        		 z = inputStream.readInt();
        		 frequency = inputStream.readInt();
        		 
        		 
        	 }
        	 catch(Exception e)
        	 {
        		 e.printStackTrace();
        	 }
        	 try
        	 {
        	 WorldServer world = MinecraftServer.getServer().worldServerForDimension(worldid);
        	 TileEntityLiquidStorage tile = (TileEntityLiquidStorage) world.getBlockTileEntity(x, y, z);
        	 tile.resetFluidFrequency(frequency);
        
        	 }
        	 catch(Exception e)
        	 {
        		 e.printStackTrace();
        	 }
        	
        }

}
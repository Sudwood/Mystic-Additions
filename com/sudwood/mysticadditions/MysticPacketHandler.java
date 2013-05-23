package com.sudwood.mysticadditions;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import com.sudwood.mysticadditions.tileentity.TileEntityMysticEnergy;

import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class MysticPacketHandler implements IPacketHandler {

        @Override
        public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player playerEntity) 
        {
        	if(packet.channel.equals("MysticCapacitor"))
        	{
        		handleRedCapacitor(packet);
        	}
        	if(packet.channel.equals("MysticER"))
        	{
        		handleEnergyReset(packet);
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

}
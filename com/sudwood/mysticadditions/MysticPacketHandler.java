package com.sudwood.mysticadditions;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class MysticPacketHandler implements IPacketHandler {

        @Override
        public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player playerEntity) 
        {
        	if(packet.channel.equals("MysticRedGenerator"))
        	{
        		handleRedGenerator(packet);
        	}
        }
        
        public void handleRedGenerator(Packet packet)
        {
        	
        }

}
package client.sudwood.mysticadditions;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.server.MinecraftServer;

import org.lwjgl.input.Keyboard;

import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.MysticPacketHandler;
import com.sudwood.mysticadditions.container.ContainerMysticModules;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;

public class MysticKeyHandler extends KeyHandler {
	
	private EnumSet tickTypes = EnumSet.of(TickType.PLAYER);
	public MysticKeyHandler(KeyBinding[] keyBindings, boolean[] repeatings) {
		super(keyBindings, repeatings);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Module Inventory";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb,
			boolean tickEnd, boolean isRepeat) 
	{
		if(tickEnd && kb.keyCode == Keyboard.KEY_U)
		{
		/*	EntityPlayer player = Minecraft.getMinecraft().thePlayer;
			ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
	    	DataOutputStream outputStream = new DataOutputStream(bos);
	    	try {
	    	        outputStream.writeInt(player.worldObj.provider.dimensionId);
	    	        outputStream.writeInt((int)player.posX);
	    	        outputStream.writeInt((int)player.posY);
	    	        outputStream.writeInt((int)player.posZ);
	    	        outputStream.writeUTF(player.username);
	    	} catch (Exception ex) {
	    	        ex.printStackTrace();
	    	}
	    	
	    	Packet250CustomPayload packet = new Packet250CustomPayload();
	    	packet.channel="MCK";
	    	packet.data = bos.toByteArray();
	    	packet.length = bos.size();
	    	PacketDispatcher.sendPacketToServer(packet);*/
		}

	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return tickTypes;
	}

}

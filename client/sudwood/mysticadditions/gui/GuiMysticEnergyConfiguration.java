package client.sudwood.mysticadditions.gui;


import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.sudwood.mysticadditions.tileentity.TileEntityMysticEnergy;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiMysticEnergyConfiguration extends GuiScreen
{
    private TileEntityMysticEnergy furnaceInventory;

    public GuiMysticEnergyConfiguration(TileEntityMysticEnergy tileEntity)
    {
        super();
        this.furnaceInventory = tileEntity;
        
    }
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    public void initGui()
    {
    this.buttonList.clear();

    int posX = (this.width - 256) / 2;
    int posY = (this.height - 180) / 2;

    this.buttonList.add(new GuiButton(0, posX+ 50, posY + 100, 50, 15, "Top"));
    this.buttonList.add(new GuiButton(1, posX+ 150, posY + 100, 50, 15, "Front"));
    this.buttonList.add(new GuiButton(2, posX+ 50, posY + 140, 50, 15, "Bottom"));
    this.buttonList.add(new GuiButton(3, posX+ 5, posY + 120, 50, 15, "Left"));
    this.buttonList.add(new GuiButton(4, posX+ 95, posY + 120, 50, 15, "Right"));
    this.buttonList.add(new GuiButton(5, posX+ 150, posY + 130, 50, 15, "Back"));
    //frequencies
    this.buttonList.add(new GuiButton(6, posX+ 10, posY + 9, 40, 12, "Reset"));
    this.buttonList.add(new GuiButton(7, posX+ 10, posY + 24, 40, 12, "Reset"));
    this.buttonList.add(new GuiButton(8, posX+ 10, posY + 39, 40, 12, "Reset"));
    this.buttonList.add(new GuiButton(9, posX+ 10, posY + 54, 40, 12, "Reset"));
    this.buttonList.add(new GuiButton(10, posX+ 10, posY + 69, 40, 12, "Reset"));
    }
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    public void actionPerformed(GuiButton button)
    {
    switch(button.id)
    {
    case 0: break;
    case 1: break;
    case 2: break;
    case 3: break;
    case 4: break;
    case 5: break;
    case 6: 
    {
    	ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
    	DataOutputStream outputStream = new DataOutputStream(bos);
    	try {
    	        outputStream.writeInt(this.furnaceInventory.worldObj.provider.dimensionId);
    	        outputStream.writeInt(this.furnaceInventory.xCoord);
    	        outputStream.writeInt(this.furnaceInventory.yCoord);
    	        outputStream.writeInt(this.furnaceInventory.zCoord);
    	        outputStream.writeInt(0);
    	} catch (Exception ex) {
    	        ex.printStackTrace();
    	}
    	Packet250CustomPayload packet = new Packet250CustomPayload();
    	packet.channel="MysticER";
    	packet.data = bos.toByteArray();
    	packet.length = bos.size();
    	PacketDispatcher.sendPacketToServer(packet);
    	this.furnaceInventory.resetFrequency(0);
    }
    	break;
    case 7:
    {
    	ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
    	DataOutputStream outputStream = new DataOutputStream(bos);
    	try {
    	        outputStream.writeInt(this.furnaceInventory.worldObj.provider.dimensionId);
    	        outputStream.writeInt(this.furnaceInventory.xCoord);
    	        outputStream.writeInt(this.furnaceInventory.yCoord);
    	        outputStream.writeInt(this.furnaceInventory.zCoord);
    	        outputStream.writeInt(0);
    	} catch (Exception ex) {
    	        ex.printStackTrace();
    	}
    	Packet250CustomPayload packet = new Packet250CustomPayload();
    	packet.channel="MysticER";
    	packet.data = bos.toByteArray();
    	packet.length = bos.size();
    	PacketDispatcher.sendPacketToServer(packet);
    	this.furnaceInventory.resetFrequency(1);
    }
    	break;
    case 8:
    {
    	ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
    	DataOutputStream outputStream = new DataOutputStream(bos);
    	try {
    	        outputStream.writeInt(this.furnaceInventory.worldObj.provider.dimensionId);
    	        outputStream.writeInt(this.furnaceInventory.xCoord);
    	        outputStream.writeInt(this.furnaceInventory.yCoord);
    	        outputStream.writeInt(this.furnaceInventory.zCoord);
    	        outputStream.writeInt(0);
    	} catch (Exception ex) {
    	        ex.printStackTrace();
    	}
    	Packet250CustomPayload packet = new Packet250CustomPayload();
    	packet.channel="MysticER";
    	packet.data = bos.toByteArray();
    	packet.length = bos.size();
    	PacketDispatcher.sendPacketToServer(packet);
    	this.furnaceInventory.resetFrequency(2);
    }
    break;
    case 9:
    {
    	ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
    	DataOutputStream outputStream = new DataOutputStream(bos);
    	try {
    	        outputStream.writeInt(this.furnaceInventory.worldObj.provider.dimensionId);
    	        outputStream.writeInt(this.furnaceInventory.xCoord);
    	        outputStream.writeInt(this.furnaceInventory.yCoord);
    	        outputStream.writeInt(this.furnaceInventory.zCoord);
    	        outputStream.writeInt(0);
    	} catch (Exception ex) {
    	        ex.printStackTrace();
    	}
    	Packet250CustomPayload packet = new Packet250CustomPayload();
    	packet.channel="MysticER";
    	packet.data = bos.toByteArray();
    	packet.length = bos.size();
    	PacketDispatcher.sendPacketToServer(packet);
    	this.furnaceInventory.resetFrequency(3);
    }
    break;
    case 10: 
    {
    	ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
    	DataOutputStream outputStream = new DataOutputStream(bos);
    	try {
    	        outputStream.writeInt(this.furnaceInventory.worldObj.provider.dimensionId);
    	        outputStream.writeInt(this.furnaceInventory.xCoord);
    	        outputStream.writeInt(this.furnaceInventory.yCoord);
    	        outputStream.writeInt(this.furnaceInventory.zCoord);
    	        outputStream.writeInt(0);
    	} catch (Exception ex) {
    	        ex.printStackTrace();
    	}
    	Packet250CustomPayload packet = new Packet250CustomPayload();
    	packet.channel="MysticER";
    	packet.data = bos.toByteArray();
    	packet.length = bos.size();
    	PacketDispatcher.sendPacketToServer(packet);
    	this.furnaceInventory.resetFrequency(4);
    	
    }
    break;
    default: return;
    }
    }
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
    	int posX = (this.width - 256) / 2;
        int posY = (this.height - 180) / 2;
        
        this.fontRenderer.drawString("Top",posX+65,posY+90,4210752 ); 
        this.fontRenderer.drawString("Bottom",posX+60,posY+130,4210752 ); 
        this.fontRenderer.drawString("Left",posX+20,posY+110,4210752 ); 
        this.fontRenderer.drawString("Right",posX+107,posY+110,4210752 ); 
        this.fontRenderer.drawString("Back",posX+162,posY+120,4210752 ); 
        this.fontRenderer.drawString("Front",posX+162,posY+90,4210752 ); 
        //frequency coords
        String coord0 = "X:"+this.furnaceInventory.coords0[0]+" Y:"+this.furnaceInventory.coords0[1]+" Z:"+this.furnaceInventory.coords0[2];
        String coord1 = "X:"+this.furnaceInventory.coords1[0]+" Y:"+this.furnaceInventory.coords1[1]+" Z:"+this.furnaceInventory.coords1[2];
        String coord2 = "X:"+this.furnaceInventory.coords2[0]+" Y:"+this.furnaceInventory.coords2[1]+" Z:"+this.furnaceInventory.coords2[2];
        String coord3 = "X:"+this.furnaceInventory.coords3[0]+" Y:"+this.furnaceInventory.coords3[1]+" Z:"+this.furnaceInventory.coords3[2];
        String coord4 = "X:"+this.furnaceInventory.coords4[0]+" Y:"+this.furnaceInventory.coords4[1]+" Z:"+this.furnaceInventory.coords4[2];
        this.fontRenderer.drawString(coord0,posX+135,posY+10,4210752 ); 
        this.fontRenderer.drawString(coord1,posX+135,posY+25,4210752 ); 
        this.fontRenderer.drawString(coord2,posX+135,posY+40,4210752 ); 
        this.fontRenderer.drawString(coord3,posX+135,posY+55,4210752 ); 
        this.fontRenderer.drawString(coord4,posX+135,posY+70,4210752 );
        
        //frequency names
        this.fontRenderer.drawString("Frequency 1:",posX+60,posY+10,4210752 ); 
        this.fontRenderer.drawString("Frequency 2:",posX+60,posY+25,4210752 ); 
        this.fontRenderer.drawString("Frequency 3:",posX+60,posY+40,4210752 ); 
        this.fontRenderer.drawString("Frequency 4:",posX+60,posY+55,4210752 ); 
        this.fontRenderer.drawString("Frequency 5:",posX+60,posY+70,4210752 ); 
        
       
        
        
  
        
    }//125 34
    @Override
    public void drawScreen(int x, int y, float f)
    {
    drawDefaultBackground();
    
    ResourceLocation var4 = new ResourceLocation("mysticadditions","/textures/mysticenergygui.png");
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.mc.func_110434_K().func_110577_a(var4);

    int posX = (this.width - 256) / 2;
    int posY = (this.height - 180) / 2;

    drawTexturedModalRect(posX, posY, 0, 0,256,256);
    this.drawGuiContainerForegroundLayer(x, y);
    super.drawScreen(x, y, f);
    }

  
}

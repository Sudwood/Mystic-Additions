package client.sudwood.mysticadditions.gui;


import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.sudwood.mysticadditions.container.ContainerMysticModules;
import com.sudwood.mysticadditions.tileentity.TileEntityModuleTable;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiModuleInventory extends GuiContainer
{
    
	TileEntityModuleTable tileE;
    public GuiModuleInventory(EntityPlayer player, InventoryPlayer par1InventoryPlayer, TileEntityModuleTable tile)
    {
        super(new ContainerMysticModules(player, par1InventoryPlayer, tile));
        tileE = tile;
        
    }

    public void initGui()
    {
    super.initGui();
    this.buttonList.clear();

    this.buttonList.add(new GuiButton(0, 194,103, 50, 15, "Bind!"));
    
    }
    
    public void actionPerformed(GuiButton button)
    {
    	ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
    	DataOutputStream outputStream = new DataOutputStream(bos);
    	try {
    	        outputStream.writeInt(this.tileE.worldObj.provider.dimensionId);
    	        outputStream.writeInt(this.tileE.xCoord);
    	        outputStream.writeInt(this.tileE.yCoord);
    	        outputStream.writeInt(this.tileE.zCoord);
    	        outputStream.writeInt(0);
    	} catch (Exception ex) {
    	        ex.printStackTrace();
    	}
    	Packet250CustomPayload packet = new Packet250CustomPayload();
    	packet.channel="MMOD";
    	packet.data = bos.toByteArray();
    	packet.length = bos.size();
    	PacketDispatcher.sendPacketToServer(packet);
    }
    
    
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
    	 this.fontRenderer.drawString(tileE.getEnergyLevel()+"/"+tileE.getMaxEnergy(), 100, 50, 4210752);
    	 this.fontRenderer.drawString(StatCollector.translateToLocal("MyJ"), 155, 58, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("Mod Inv"), 124, 70, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        
    }//125 34

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
    	ResourceLocation var4 = new ResourceLocation("mysticadditions","textures/moduleinventory.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        if(tileE.getStackInSlot(0) != null)
        {
        	this.drawTexturedModalRect(var5+29, var6+6, 176, 0, 39, 18);
        }
        if(tileE.getStackInSlot(3) != null)
        {
        	this.drawTexturedModalRect(var5+29, var6+28, 176, 0, 39, 18);
        }
        if(tileE.getStackInSlot(6) != null)
        {
        	this.drawTexturedModalRect(var5+29, var6+50, 176, 0, 39, 18);
        }
        if(tileE.getStackInSlot(9) != null)
        {
        	this.drawTexturedModalRect(var5+109, var6+6, 176, 0, 39, 18);
        }
        if(tileE.getStackInSlot(12) != null)
        {
        	this.drawTexturedModalRect(var5+109, var6+28, 176, 0, 39, 18);
        }
       
    }
    
    
}

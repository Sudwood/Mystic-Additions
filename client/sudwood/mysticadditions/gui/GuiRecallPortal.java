package client.sudwood.mysticadditions.gui;


import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.FluidRegistry;

import org.lwjgl.opengl.GL11;

import com.sudwood.mysticadditions.container.ContainerMysticRedStorage;
import com.sudwood.mysticadditions.container.ContainerRecallPortal;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityRecallPortal;

import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiRecallPortal extends GuiContainer
{
    private TileEntityRecallPortal furnaceInventory;
    private EntityPlayer player;
    public GuiRecallPortal(EntityPlayer player, InventoryPlayer par1InventoryPlayer, TileEntityRecallPortal par2TileEntityFurnace)
    {
        super(new ContainerRecallPortal(par1InventoryPlayer, par2TileEntityFurnace));
        this.furnaceInventory = par2TileEntityFurnace;
        this.player = player;
    }
    public void initGui()
    {
    super.initGui();
    this.buttonList.clear();

    int posX = (this.width - this.xSize) / 2;
    int posY = (this.height - this.ySize) / 2;

    this.buttonList.add(new GuiButton(0, posX+ 25, posY + 15, 30, 15, furnaceInventory.getRestrictTravel()+""));
    
    }
 
    public void actionPerformed(GuiButton button)
    {
    	ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
    	DataOutputStream outputStream = new DataOutputStream(bos);
    	try {
    			outputStream.writeInt(0);// recall portal packet id
    	        outputStream.writeInt(this.furnaceInventory.worldObj.provider.dimensionId);
    	        outputStream.writeInt(this.furnaceInventory.xCoord);
    	        outputStream.writeInt(this.furnaceInventory.yCoord);
    	        outputStream.writeInt(this.furnaceInventory.zCoord);
    	        outputStream.writeUTF(player.username);
    	} catch (Exception ex) {
    	        ex.printStackTrace();
    	}
    	Packet250CustomPayload packet = new Packet250CustomPayload();
    	packet.channel="MYAD";
    	packet.data = bos.toByteArray();
    	packet.length = bos.size();
    	PacketDispatcher.sendPacketToServer(packet);
    	System.out.println("Sent");
    }
    
    
    
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal("Recall Portal"), 60, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);

        
    }//125 34

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
    	ResourceLocation var4 = new ResourceLocation("mysticadditions","textures/recallportalgui.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;
        
        var7 = this.furnaceInventory.getCookProgressScaled(22);
        this.drawTexturedModalRect(var5 + 77, var6 + 51, 176, 31, var7 + 1, 16);
       
    }
    
    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
    	super.drawScreen(par1, par2, par3);
    	int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        if(par1 >= 77+var5 && par2 >= 51+var6 && par1 <= 100+var5 && par2 <= 67+var6)
		{
			String[] text = {furnaceInventory.getEnergyLevel()+" / "+this.furnaceInventory.getMaxEnergy()};
			List temp = Arrays.asList(text);
			drawHoveringText(temp, par1, par2, fontRenderer);
		}
        if(par1 >= 25+var5 && par2 >= 15+var6 && par1 <= 55+var5 && par2 <= 30+var6)
		{
			String[] text = {"Restrict travel based on ", "creator of Mark Recall Item."};
			List temp = Arrays.asList(text);
			drawHoveringText(temp, par1, par2, fontRenderer);
		}
    }
    
  /* @Override
    protected void mouseClicked(int par1, int par2, int par3)
    {	if(furnaceInventory.getStackInSlot(0)!=null)
	    {
	    	NBTTagCompound tag = furnaceInventory.getStackInSlot(0).getTagCompound();
	    	if(player.username != tag.getString("Creator"))
	    	{
	    		return;
	    	}
	    }
    else
    	super.mouseClicked(par1, par2, par3);
    }*/
}

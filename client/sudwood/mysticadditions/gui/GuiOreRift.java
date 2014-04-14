package client.sudwood.mysticadditions.gui;


import java.util.Arrays;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.sudwood.mysticadditions.container.ContainerOreRift;
import com.sudwood.mysticadditions.tileentity.TileEntityOreRift;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiOreRift extends GuiContainer
{
    private TileEntityOreRift furnaceInventory;
    private EntityPlayer player;
    public GuiOreRift(EntityPlayer player, InventoryPlayer par1InventoryPlayer, TileEntityOreRift par2TileEntityFurnace)
    {
        super(new ContainerOreRift(par1InventoryPlayer, par2TileEntityFurnace));
        this.furnaceInventory = par2TileEntityFurnace;
        this.player = player;
        
    }
    
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal("Ore Rift"), 60, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.fontRenderer.drawString("Time Remaining: "+furnaceInventory.timeTillComplete/20+" seconds", 20, -10, 16777215);
        

        
    }//125 34

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
    	ResourceLocation var4 = new ResourceLocation("mysticadditions","textures/oreriftgui.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;
        var7 = this.furnaceInventory.getCookProgressScaled(22);
        this.drawTexturedModalRect(var5 + 71, var6 + 51, 176, 31, var7 + 1, 16);
        if(furnaceInventory.isRunning)
        {
        	this.drawTexturedModalRect(var5 + 71, var6 + 21, 177, 49+(furnaceInventory.spinCount*16), 16, 16);
        	
        }
    }
    
    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
    	super.drawScreen(par1, par2, par3);
    	int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        if(par1 >= 7+var5 && par2 >= 29+var6 && par1 <= 24+var5 && par2 <= 46+var6)
		{
			String[] text = {"Place a stack of items here to,", "increase the x distance of the ore rift.", "Distance is equal to stack size."};
			List temp = Arrays.asList(text);
			drawHoveringText(temp, par1, par2, fontRenderer);
		}
        if(par1 >= 45+var5 && par2 >= 29+var6 && par1 <= 62+var5 && par2 <= 46+var6)
		{
			String[] text = {"Place a stack of items here to,", "increase the z distance of the ore rift.", "Distance is equal to stack size."};
			List temp = Arrays.asList(text);
			drawHoveringText(temp, par1, par2, fontRenderer);
		}
        if(par1 >= 71+var5 && par2 >= 51+var6 && par1 <= 94+var5 && par2 <= 67+var6)
		{
			String[] text = {furnaceInventory.getEnergyLevel()+" / "+this.furnaceInventory.getMaxEnergy()+" MyJ"};
			List temp = Arrays.asList(text);
			drawHoveringText(temp, par1, par2, fontRenderer);
		}
        if(par1 >= 100+var5 && par2 >= 4+var6 && par1 <= 171+var5 && par2 <= 75+var6)
		{
			String[] text = {"Any blocks here will,", "not be mined by the ore rift.", "Automatically ignores stone and dirt.", "Reads left to right, top down,", "until an empty slot is found"};
			List temp = Arrays.asList(text);
			drawHoveringText(temp, par1, par2, fontRenderer);
		}
        if(par1 >= 7+var5 && par2 >= 50+var6 && par1 <= 24+var5 && par2 <= 67+var6)
		{
			String[] text = {"Place redstone here to,", "mine in the -x direction."};
			List temp = Arrays.asList(text);
			drawHoveringText(temp, par1, par2, fontRenderer);
		}
        if(par1 >= 45+var5 && par2 >= 50+var6 && par1 <= 62+var5 && par2 <= 67+var6)
		{
			String[] text = {"Place redstone here to,", "mine in the -z direction."};
			List temp = Arrays.asList(text);
			drawHoveringText(temp, par1, par2, fontRenderer);
		}
        if(this.furnaceInventory.isRunning)
        {
        	if(par1 >= 71+var5 && par2 >= 21+var6 && par1 <= 87+var5 && par2 <= 37+var6)
    		{
    			String[] text = {"Rift is working."};
    			List temp = Arrays.asList(text);
    			drawHoveringText(temp, par1, par2, fontRenderer);
    		}
        }
        

    }
    @Override
    protected void mouseClicked(int par1, int par2, int par3)
    {	if(furnaceInventory.isRunning)
	    {
	    	return;
	    }
    else
    	super.mouseClicked(par1, par2, par3);
    }
    
  
}

package client.sudwood.mysticadditions.gui;


import java.util.Arrays;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.sudwood.mysticadditions.container.ContainerNaturalRift;
import com.sudwood.mysticadditions.tileentity.TileEntityNaturalRift;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiNaturalRift extends GuiContainer
{
    private TileEntityNaturalRift tile;

    public GuiNaturalRift(InventoryPlayer par1InventoryPlayer, TileEntityNaturalRift par2TileEntityFurnace)
    {
        super(new ContainerNaturalRift(par1InventoryPlayer, par2TileEntityFurnace));
        this.tile = par2TileEntityFurnace;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal(tile.getInvName()), 60, 7, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
    	ResourceLocation var4 = new ResourceLocation("mysticadditions","textures/naturalriftgui.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;

        
        int var8 =  tile.getEnergyScaled(22);
        var7 = this.tile.getCookProgressScaled(24);
        this.drawTexturedModalRect(var5 + 71, var6 + 18, 176, 14, var7 + 1, 16);
        this.drawTexturedModalRect(var5+71, var6+51, 176, 31, var8+1, 16);
    }
    
    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
    	super.drawScreen(par1, par2, par3);
    	int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        if(par1 >= 71+var5 && par2 >= 51+var6 && par1 <= 94+var5 && par2 <= 67+var6)
		{
        	String[] text = {tile.getEnergyLevel()+" / "+tile.getMaxEnergy()+" MyJ"};
			List temp = Arrays.asList(text);
			drawHoveringText(temp, par1, par2, fontRenderer);
		}
        if(par1 >= 71+var5 && par2 >= 17+var6 && par1 <= 94+var5 && par2 <= 33+var6)
		{
        	String[] text = {tile.furnaceCookTime+" / 100 progress."};
			List temp = Arrays.asList(text);
			drawHoveringText(temp, par1, par2, fontRenderer);
		}
    }
}

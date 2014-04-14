package client.sudwood.mysticadditions.gui;


import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.sudwood.mysticadditions.container.ContainerPoweredFurnace;
import com.sudwood.mysticadditions.tileentity.TileEntityPoweredFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiPoweredFurnace extends GuiContainer
{
    private TileEntityPoweredFurnace furnaceInventory;

    public GuiPoweredFurnace(InventoryPlayer par1InventoryPlayer, TileEntityPoweredFurnace par2TileEntityFurnace)
    {
        super(new ContainerPoweredFurnace(par1InventoryPlayer, par2TileEntityFurnace));
        this.furnaceInventory = par2TileEntityFurnace;
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal("Powered Furnace"), 60, 7, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        this.fontRenderer.drawString(furnaceInventory.getEnergyLevel()+"/4000", 110, 20, 16711680);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
    	ResourceLocation var4 = new ResourceLocation("mysticadditions","textures/mysticredgrinder.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;

        
        int var8 =  furnaceInventory.getEnergyScaled(22);
        var7 = this.furnaceInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(var5 + 71, var6 + 18, 176, 14, var7 + 1, 16);
        this.drawTexturedModalRect(var5+71, var6+51, 176, 31, var8+1, 16);
    }
}

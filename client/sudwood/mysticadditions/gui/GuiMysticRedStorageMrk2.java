package client.sudwood.mysticadditions.gui;


import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.sudwood.mysticadditions.container.ContainerMysticRedStorageMrk2;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorageMrk2;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiMysticRedStorageMrk2 extends GuiContainer
{
    private TileEntityMysticRedStorageMrk2 furnaceInventory;

    public GuiMysticRedStorageMrk2(InventoryPlayer par1InventoryPlayer, TileEntityMysticRedStorageMrk2 par2TileEntityFurnace)
    {
        super(new ContainerMysticRedStorageMrk2(par1InventoryPlayer, par2TileEntityFurnace));
        this.furnaceInventory = par2TileEntityFurnace;
        
    }

 
    
    
    
    
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal("Mystical Condensator"), 60, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
        this.fontRenderer.drawString(furnaceInventory.getEnergyLevel()+" / "+this.furnaceInventory.getMaxEnergy(), 85, 24, 16711680);
        
    }//125 34

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
    	ResourceLocation var4 = new ResourceLocation("mysticadditions","/textures/mysticstoragered.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.func_110434_K().func_110577_a(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;
        
        var7 = this.furnaceInventory.getCookProgressScaled(22);
        this.drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
       
    }
}

package client.sudwood.mysticadditions.gui;


import java.util.Arrays;
import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.FluidRegistry;

import org.lwjgl.opengl.GL11;

import com.sudwood.mysticadditions.container.ContainerLiquidStorage;
import com.sudwood.mysticadditions.container.ContainerMysticRedStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityLiquidStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiLiquidStorage extends GuiContainer
{
    private TileEntityLiquidStorage furnaceInventory;

    public GuiLiquidStorage(InventoryPlayer par1InventoryPlayer, TileEntityLiquidStorage par2TileEntityFurnace)
    {
        super(new ContainerLiquidStorage(par1InventoryPlayer, par2TileEntityFurnace));
        this.furnaceInventory = par2TileEntityFurnace;
        
    }

 
    
    
    
    
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRenderer.drawString(StatCollector.translateToLocal(furnaceInventory.getInvName()), 60, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
       
        
    }//125 34

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
    	ResourceLocation var4 = new ResourceLocation("mysticadditions","textures/mysticliquidstorage.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(var4);
        int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
        int var7;
        
        var7 = this.furnaceInventory.getCookProgressScaled(44);
        this.drawTexturedModalRect(var5 + 119, var6 + 52, 176, 90, var7 + 1, 45);
       
        int var8 = (int)(58 - 58*(float)this.furnaceInventory.tank.getFluidAmount() / this.furnaceInventory.tank.getCapacity());
     
        this.drawTexturedModalRect(var5 + 66, var6 + 15, 176, 31, 38, var8+1);
        
        
        
    }
    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
    	super.drawScreen(par1, par2, par3);
    	int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
    		if(par1 >= 66+var5 && par2 >= 15+var6 && par1 <= 104+var5 && par2 <= 73+var6)
    		{
    			String[] text = {"Empty"};
    			if(this.furnaceInventory.tank.getFluidAmount() > 0)
    				text[0] = this.furnaceInventory.tank.getFluidAmount() + " mB / "+this.furnaceInventory.tank.getCapacity()+" mB "+ FluidRegistry.getFluidName(this.furnaceInventory.tank.getFluid());
    			System.out.println(text[0]);
    			List temp = Arrays.asList(text);
    			drawHoveringText(temp, par1, par2, fontRenderer);
    			
    		}
    		if(par1 >= 119+var5 && par2 >= 52+var6 && par1 <= 164+var5 && par2 <= 77+var6)
    		{
    			String[] text = {this.furnaceInventory.energyLevel+" MyJ / "+ this.furnaceInventory.getMaxEnergy()+" MyJ"};
    			List temp = Arrays.asList(text);
    			drawHoveringText(temp, par1, par2, fontRenderer);
    		}
    }
    
    
    
}

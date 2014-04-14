package client.sudwood.mysticadditions.renderers;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import client.sudwood.mysticadditions.models.ModelEnergyBall;

import com.sudwood.mysticadditions.tileentity.TileEntityLiquidStorage;

public class RenderLiquidStorage extends TileEntitySpecialRenderer {

	private ModelEnergyBall model = new ModelEnergyBall();
	@Override
	public void renderTileEntityAt(TileEntity tile1, double d0, double d1,
			double d2, float f) {
		  GL11.glPushMatrix();
		  GL11.glTranslatef((float)d0 + 0.5F, (float)d1 - 0.5F, (float)d2 + 0.5F);
		  GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		  GL11.glTranslatef(0.0F, -2.0F, 0.0F);        
		  bindTexture(new ResourceLocation("mysticadditions","textures/liquidrift.png"));   
		  TileEntityLiquidStorage tile = (TileEntityLiquidStorage) tile1;
		  model.spinCenter(tile.spinAngleX, tile.spinAngleY, tile.spinAngleZ);
		  model.render(0.0625F);  
		  GL11.glPopMatrix();

	}

}

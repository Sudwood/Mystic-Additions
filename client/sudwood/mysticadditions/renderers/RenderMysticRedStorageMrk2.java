package client.sudwood.mysticadditions.renderers;

import org.lwjgl.opengl.GL11;

import client.sudwood.mysticadditions.models.ModelMysticStorage2;

import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorageMrk2;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderMysticRedStorageMrk2 extends TileEntitySpecialRenderer
{
	private ModelMysticStorage2 model = new ModelMysticStorage2();
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4,
			double var6, float var8) {
		  GL11.glPushMatrix();
		  GL11.glTranslatef((float)var2 + 0.5F, (float)var4 - 0.5F, (float)var6 + 0.5F);
		  GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		  GL11.glTranslatef(0.0F, -2.0F, 0.0F);        
		  bindTextureByName("/mods/MysticAdditions/textures/mark2capacitor.png");   
		  TileEntityMysticRedStorageMrk2 tile = (TileEntityMysticRedStorageMrk2) var1;
		  model.setAnglesForCubes(tile.rotationAngle);
		  model.render(0.0625F);  
		  GL11.glPopMatrix();
		
	}

}

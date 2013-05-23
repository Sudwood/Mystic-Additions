package client.sudwood.mysticadditions.renderers;

import org.lwjgl.opengl.GL11;

import client.sudwood.mysticadditions.models.ModelMysticCrystalGenerator;
import client.sudwood.mysticadditions.models.ModelMysticGeneratorTesting;
import client.sudwood.mysticadditions.models.ModelMysticRedGrinder;

import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGenerator;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGrinder;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderMysticCrystalGenerator extends TileEntitySpecialRenderer
{
	private ModelMysticCrystalGenerator model = new ModelMysticCrystalGenerator();
	boolean upDown = false;
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		  GL11.glPushMatrix();
		  GL11.glTranslatef((float)var2 + 0.5F, (float)var4 - 0.5F, (float)var6 + 0.5F);
		  GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		  GL11.glTranslatef(0.0F, -2.0F, 0.0F);        
		  bindTextureByName("/mods/MysticAdditions/textures/blockMysticCapacitor.png");   
		
		  
		  model.render(0.0625F);  
		  GL11.glPopMatrix();
		
	}

}
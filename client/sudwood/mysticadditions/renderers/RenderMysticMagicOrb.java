package client.sudwood.mysticadditions.renderers;

import org.lwjgl.opengl.GL11;

import client.sudwood.mysticadditions.models.ModelEnergyBall;

import com.sudwood.mysticadditions.entity.EntityMysticWindOrb;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGrinder;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;

public class RenderMysticMagicOrb extends Render{
	ModelEnergyBall model = new ModelEnergyBall();
	@Override
	public void doRender(Entity var1, double var2, double var4, double var6,
			float var8, float var9) {
		GL11.glPushMatrix();
		  GL11.glTranslatef((float)var2 + 0.5F, (float)var4 - 0.5F, (float)var6 + 0.5F);
		  GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		  GL11.glTranslatef(0.0F, -2.0F, 0.0F);        
		  
		if(var1 instanceof EntityMysticWindOrb)
		 model.spinCenter(((EntityMysticWindOrb) var1).spinAngleX, ((EntityMysticWindOrb) var1).spinAngleY, ((EntityMysticWindOrb) var1).spinAngleZ);
		  
		  model.render(0.0625F);  
		  GL11.glPopMatrix();
		
	}

}

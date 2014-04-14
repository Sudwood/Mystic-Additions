package client.sudwood.mysticadditions.renderers;

import org.lwjgl.opengl.GL11;

import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorage;

import client.sudwood.mysticadditions.models.ModelMysticStorage2;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class RenderTileEntityBase implements IItemRenderer{

	TileEntity dummyTile;
	
	float rotationAngle;
	ResourceLocation texture;
	public RenderTileEntityBase(TileEntity mod)
	{
		rotationAngle = 0F;
		dummyTile = mod;
		
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		// TODO Auto-generated method stub
		switch(type)
		{
		case EQUIPPED: return true;
		
		case EQUIPPED_FIRST_PERSON: return true;
		
		default: return true;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		// TODO Auto-generated method stub
		
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) 
	{
	/*	
		switch(type)
		{
		case INVENTORY:
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float)0.5F, (float) 0.5F, (float)0.5F);
			  GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			  GL11.glTranslatef(0.6F, -1.2F, -0.0F);      
			  
			  Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			  if (MysticAdditions.areAnimations)
				 {
					 rotationAngle+=0.01F;
					 if(rotationAngle>=6.28)
						 rotationAngle=0F;
					 
				 }
			  model.setAnglesForCubes(rotationAngle);
			  model.render(0.0625F);  
			  GL11.glPopMatrix();
			  break;
		}
		case EQUIPPED: 
		{
			GL11.glPushMatrix();
			GL11.glTranslatef((float)0.5F, (float) 0.5F, (float)0.5F);
			  GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			  GL11.glTranslatef(0.6F, -1.2F, -0.0F);      
			  
			  Minecraft.getMinecraft().renderEngine.bindTexture(texture);
			  if (MysticAdditions.areAnimations)
				 {
					 rotationAngle+=0.01F;
					 if(rotationAngle>=6.28)
						 rotationAngle=0F;
					 
				 }
			  model.setAnglesForCubes(rotationAngle);
			  model.render(0.0625F);  
			  GL11.glPopMatrix();
			  break;
		}
		
		case EQUIPPED_FIRST_PERSON:
		{
			GL11.glPushMatrix();
			  GL11.glScalef(1.2F, 1.2F, 1.2F);
			  GL11.glRotatef(180, 2F, -0F, 0F);
			  GL11.glTranslatef(2.5F, -1.2F, 0.12F);   
			  
			  
			  Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("mysticadditions","textures/mysticcapacitor.png"));
			  if (MysticAdditions.areAnimations)
				 {
					 rotationAngle+=0.01F;
					 if(rotationAngle>=6.28)
						 rotationAngle=0F;
					 
				 }
			  model.setAnglesForCubes(rotationAngle);
			  model.render(0.0625F);  
			  GL11.glPopMatrix();
			  break;
		}
		
		default: 
		{
			  GL11.glPushMatrix();
			  GL11.glScalef(1F, 2F, 1F);
			  GL11.glRotatef(0, 0.0F, 0.0F, 1F);
			  GL11.glTranslatef(0.0F, 0F, 0.0F);    
			  
			  Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("mysticadditions","textures/mysticcapacitor.png"));
			  if (MysticAdditions.areAnimations)
				 {
					 rotationAngle+=0.01F;
					 if(rotationAngle>=6.28)
						 rotationAngle=0F;
					 
				 }
			  model.setAnglesForCubes(rotationAngle);
			  model.render(0.0625F);  
			  GL11.glPopMatrix();
			  break;
		}
		}
		  */
		TileEntityRenderer.instance.renderTileEntityAt(dummyTile, 0.0D,0.0D,0.0D,0F);
	}

}

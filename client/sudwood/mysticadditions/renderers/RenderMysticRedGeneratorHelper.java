package client.sudwood.mysticadditions.renderers;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import client.sudwood.mysticadditions.MysticClientProxy;
import client.sudwood.mysticadditions.MysticRedGeneratorItemRendererHelper;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderMysticRedGeneratorHelper implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		
		if(modelID == this.getRenderId())
		{
			GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            MysticRedGeneratorItemRendererHelper.instance.renderChest(block, metadata, 0.0F);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		}
		
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return MysticClientProxy.MysticGeneratorRenderId;
	}

}

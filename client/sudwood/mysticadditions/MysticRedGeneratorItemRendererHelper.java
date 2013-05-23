package client.sudwood.mysticadditions;

import com.sudwood.mysticadditions.blocks.MysticModBlocks;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGenerator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;


@SideOnly(Side.CLIENT)
public class MysticRedGeneratorItemRendererHelper
{
    /** The static instance of ChestItemRenderHelper. */
    public static MysticRedGeneratorItemRendererHelper instance = new MysticRedGeneratorItemRendererHelper();

    /** Instance of Chest's Tile Entity. */
    private TileEntityMysticRedGenerator theGenerator = new TileEntityMysticRedGenerator(4000);

 

    /**
     * Renders a chest at 0,0,0 - used for item rendering
     */
    public void renderChest(Block par1Block, int par2, float par3)
    {
        if (par1Block.blockID == MysticModBlocks.mysticRedGenerator.blockID)
        {
            TileEntityRenderer.instance.renderTileEntityAt(this.theGenerator, 0.0D, 0.0D, 0.0D, 0.0F);
        }
       
    }
}

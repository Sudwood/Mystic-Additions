package com.sudwood.mysticadditions.blocks.energy;



import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockCrystalGeneratorBase extends Block 
{

	public BlockCrystalGeneratorBase(int par1, Material par2Material) {
		super(par1, par2Material);
		
	}
	
	
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("mysticadditions:crystalgenbase");
    }
	
	public Icon getIcon(int i, int j)
    {
		return this.blockIcon;
    }
	
	
	
	
}

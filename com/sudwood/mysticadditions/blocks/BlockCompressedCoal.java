package com.sudwood.mysticadditions.blocks;

import java.awt.Dimension;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.sudwood.mysticadditions.MysticCommonProxy;


import cpw.mods.fml.client.ITextureFX;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;




public class BlockCompressedCoal extends Block {
	protected BlockCompressedCoal(int x)
	{
		super(x,Material.rock);
	}
	
	public int idDropped(int x, Random rand, int y)
	{
		
		return MysticModBlocks.compressedCoal.blockID;            //drops the block id
	}
	
	public int quantityDropped(Random rand)
	{
		return 1;          //quantity of that item dropped
	}

	 @Override
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.blockIcon = par1IconRegister.registerIcon("MysticAdditions:compressedcoal");
	    }
	

	
	
	
}

package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.sudwood.mysticadditions.MysticCommonProxy;




public class BlockCSteelBlock extends Block  {

	protected BlockCSteelBlock(int x)
	{
		super(x,Material.rock);
	}
	
	public int idDropped(int x, Random rand, int y)
	{
		//return mod_blockium.blockiumCrossbow.shiftedIndex;  //drops blockium Crossbow
		return MysticModBlocks.cSteelBlock.blockID;            //drops blockium Block
	}
	
	public int quantityDropped(Random rand)
	{
		return 1;          //quantity of that item dropped
	}
	
	@Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("MysticAdditions:steelblock");
    }
	
}

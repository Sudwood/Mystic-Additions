package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;




public class BlockMysticInertgenStone extends Block 
{
    public BlockMysticInertgenStone(int i)
    {
        super(i, Material.rock);
        setCreativeTab(CreativeTabs.tabBlock);
        
    }

    
    
    public int idDropped(int i, Random random, int j)
    {
        return MysticModBlocks.mysticCobblestone.blockID;
    }
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("MysticAdditions:mysticstone");
    }
	
}

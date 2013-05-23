package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;



public class BlockMysticPortalSpawner extends Block 
{
    public BlockMysticPortalSpawner(int i)
    {
        super(i, Material.rock);
    }

    public int idDropped(int i, Random random, int j)
    {
        return MysticModBlocks.mysticportalSpawner.blockID;
    }
    
    public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
        	if(par5EntityPlayer.isSneaking()){
        		
        		return false;
        	}
           /* world.setBlock(i + 0, j, k + 3, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j, k + 2, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j, k + 1, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j, k + 0, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j + 1, k + 3, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j + 1, k + 2, MysticModBlocks.mysticPortal.blockID);
            world.setBlock(i + 0, j + 1, k + 1, MysticModBlocks.mysticPortal.blockID);
            world.setBlock(i + 0, j + 1, k + 0, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j + 2, k + 3, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j + 2, k + 2, MysticModBlocks.mysticPortal.blockID);
            world.setBlock(i + 0, j + 2, k + 1, MysticModBlocks.mysticPortal.blockID);
            world.setBlock(i + 0, j + 2, k + 0, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j + 3, k + 3, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j + 3, k + 2, MysticModBlocks.mysticPortal.blockID);
            world.setBlock(i + 0, j + 3, k + 1, MysticModBlocks.mysticPortal.blockID);
            world.setBlock(i + 0, j + 3, k + 0, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j + 4, k + 3, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j + 4, k + 2, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j + 4, k + 1, MysticModBlocks.mysticportalBlock.blockID);
            world.setBlock(i + 0, j + 4, k + 0, MysticModBlocks.mysticportalBlock.blockID);*/
        	world.setBlock(i+0, j+0, k+0, MysticModBlocks.mysticportalBlock.blockID);
        	world.setBlock(i+0, j+0, k+1, MysticModBlocks.mysticportalBlock.blockID);
        	world.setBlock(i-0, j+0, k-1, MysticModBlocks.mysticportalBlock.blockID);  
        	world.setBlock(i+0, j+1, k+1, MysticModBlocks.mysticportalBlock.blockID);
        	world.setBlock(i-0, j+1, k-1, MysticModBlocks.mysticportalBlock.blockID);  
        	world.setBlock(i+0, j+1, k+0, MysticModBlocks.mysticPortal.blockID);
        	return true;
    		}
    }
    
    
    
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("MysticAdditions:mysticportalplacer");
    }
}

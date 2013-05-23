package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import com.sudwood.mysticadditions.MysticCommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockMarkBlock extends Block {

	public BlockMarkBlock(int par1) {
		super(par1, Material.circuits);
		
	}
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
	public boolean isOpaqueCube()
    {
        return false;
    }
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	public int getRenderType()
    {
        return 5;
    }
	 public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	    {
	        

	        
	            double var7 = (double)par2 + 0.5D + ((double)par5Random.nextFloat() - 0.5D) * 0.2D;
	            double var9 = (double)((float)par3 + 0.0625F);
	            double var11 = (double)par4 + 0.5D + ((double)par5Random.nextFloat() - 0.5D) * 0.2D;
	            float var13 =  15.0F;
	            float var14 = var13 * 0.6F + 0.4F;

	           

	            float var15 = var13 * var13 * 0.7F - 0.5F;
	            float var16 = var13 * var13 * 0.6F - 0.7F;

	            if (var15 < 0.0F)
	            {
	                var15 = 0.0F;
	            }

	            if (var16 < 0.0F)
	            {
	                var16 = 0.0F;
	            }

	            par1World.spawnParticle("reddust", var7, var9, var11, (double)var14, (double)var15, (double)var16);
	            par1World.spawnParticle("magicCrit", var7+10, var9, var11-10, (double)var14, (double)var15, (double)var16);

	        }
	 
	    }



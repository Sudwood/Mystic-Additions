package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class BlockStopper extends BlockBreakable 
{
	public BlockStopper(int i, Material material, boolean flag)
    {
        super(i, "MysticAdditions:stopper", material, flag);
    }


public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return MysticModBlocks.Stopper.blockID;
    }
    
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        entity.fallDistance=0;
        
    }
   
}

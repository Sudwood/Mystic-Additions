package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class BlockElevator extends BlockBreakable 
{
	public BlockElevator(int i, Material material, boolean flag)
    {
        super(i, "MysticAdditions:elevator", material, flag);
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
        return MysticModBlocks.Elevator.blockID;
    }
    
    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        entity.motionY = 1.5;
        
    }
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("MysticAdditions:elevator");
    }
}

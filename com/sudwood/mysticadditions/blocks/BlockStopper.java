package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class BlockStopper extends BlockBreakable 
{
	public BlockStopper(int i, Material material, boolean flag)
    {
        super(i, "MysticAdditions:stopper", material, flag);
    }
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
	    	if(!par1World.isRemote)
	    	{
	    		if(par5EntityPlayer.getHeldItem()!=null&&par5EntityPlayer.getHeldItem().getItem() instanceof ItemBlock)
	    		{
	    			ItemBlock block = (ItemBlock) par5EntityPlayer.getHeldItem().getItem();
	    			if(block.getBlockID()==Block.rail.blockID||block.getBlockID()==Block.railActivator.blockID||block.getBlockID()==Block.railDetector.blockID||block.getBlockID()==Block.railPowered.blockID)
	    			{
	    				if(par1World.getBlockId(par2, par3+1, par4)==0)
	    				{
	    					
	    					par1World.setBlock(par2, par3+1, par4, block.getBlockID());
	    					if(!par5EntityPlayer.capabilities.isCreativeMode)
	    					{
	    					ItemStack tempStack = par5EntityPlayer.getHeldItem();
	    					tempStack.stackSize--;
	    					par5EntityPlayer.inventory.setInventorySlotContents(0, tempStack);
	    					}
	    					return true;
	    				}
	    			}
	    			
	    		}
	    	}
	       return false;
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

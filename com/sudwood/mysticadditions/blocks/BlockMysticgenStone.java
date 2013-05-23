package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;




public class BlockMysticgenStone extends Block 
{
    public BlockMysticgenStone(int i)
    {
        super(i, Material.rock);
       
        setTickRandomly(true);
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	if (!par1World.isRemote)
        {
    		
    	for (int var6 = 0; var6 < 100; ++var6)
        {
            int var7 = par2 + par5Random.nextInt(3) - 1;
            int var8 = par3 + par5Random.nextInt(5) - 3;
            int var9 = par4 + par5Random.nextInt(3) - 1;
            int var10 = par1World.getBlockId(var7, var8 + 1, var9);

            if (par1World.getBlockId(var7, var8, var9) == Block.dirt.blockID ||par1World.getBlockId(var7, var8, var9) == Block.sand.blockID )
            {
                par1World.notifyBlockChange(var7, var8, var9, MysticModBlocks.mysticDirt.blockID);
            }
           
            if (par1World.getBlockId(var7,  var8,  var9) == Block.grass.blockID){
            	
            	par1World.notifyBlockChange(var7, var8, var9, MysticModBlocks.mysticGrass.blockID);
            	
            }
            if (par1World.getBlockId(var7, var8, var9) == Block.stone.blockID  || par1World.getBlockId(var7, var8, var9) == Block.wood.blockID)
            {
            	par1World.notifyBlockChange(var7, var8, var9, MysticModBlocks.mysticgenStone.blockID);            	
            	
            }
            if (par1World.getBlockId(var7, var8, var9) == Block.cobblestone.blockID || par1World.getBlockId(var7, var8, var9) == Block.planks.blockID || par1World.getBlockId(var7, var8, var9) == Block.leaves.blockID)
            {
            	par1World.notifyBlockChange(var7, var8, var9, MysticModBlocks.mysticCobblestone.blockID);
            }
            
            
            
            
        }
        }
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

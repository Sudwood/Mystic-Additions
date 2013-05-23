package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;



public class BlockMysticGrass extends Block 
{
	public Icon[] iconList = new Icon[3];
    public BlockMysticGrass(int i)
    {
        super(i, Material.ground);
        
       
        setTickRandomly(true);
    }


    public Icon getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if (i == 1)
        {
            return this.iconList[0];
        }
        if (i == 0)
        {
            return this.iconList[2];
        }
        if (i == 2)
        {
            return this.iconList[1];
        }
        if (i == 3)
        {
            return this.iconList[1];
        }
        if (i == 4)
        {
            return this.iconList[1];
        }
        if (i == 5)
        {
            return this.iconList[1];
        }
   
        return this.iconList[0];
    }
    public int idDropped(int i, Random random, int j)
    {
        return MysticModBlocks.mysticDirt.blockID;
    }
    
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	if (!par1World.isRemote)
        {
    		if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
            {
                par1World.setBlock(par2, par3, par4, MysticModBlocks.mysticDirt.blockID);
            }
    	for (int var6 = 0; var6 < 100; ++var6)
        {
            int var7 = par2 + par5Random.nextInt(3) - 1;
            int var8 = par3 + par5Random.nextInt(5) - 3;
            int var9 = par4 + par5Random.nextInt(3) - 1;
            int var10 = par1World.getBlockId(var7, var8 + 1, var9);

            if (par1World.getBlockId(var7, var8, var9) == Block.dirt.blockID  && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2)
            {
                par1World.setBlock(var7, var8, var9, this.blockID,0,2);
            }
            if (par1World.getBlockId(var7, var8, var9) == MysticModBlocks.mysticDirt.blockID  && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2)
            {
                par1World.setBlock(var7, var8, var9, this.blockID,0,2);
            }
            if (par1World.getBlockId(var7, var8, var9) == Block.dirt.blockID  && par1World.getBlockLightValue(var7, var8 + 1, var9) <= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2)
            {
            	 par1World.setBlock(var7, var8, var9, MysticModBlocks.mysticDirt.blockID,0,2);
            }
            if (par1World.getBlockId(var7, var8, var9) == Block.sand.blockID  && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2)
            {
                par1World.setBlock(var7, var8, var9, this.blockID);
            }
            if (par1World.getBlockId(var7, var8, var9) == Block.sand.blockID  && par1World.getBlockLightValue(var7, var8 + 1, var9) <= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2)
            {
            	 par1World.setBlock(var7, var8, var9, MysticModBlocks.mysticDirt.blockID,0,2);
            }
            if (par1World.getBlockId(var7,  var8,  var9) == Block.grass.blockID){
            	
            	par1World.setBlock(var7, var8, var9, this.blockID,0,2);
            	
            }
            if (par1World.getBlockId(var7, var8, var9) == Block.stone.blockID  || par1World.getBlockId(var7, var8, var9) == Block.wood.blockID)
            {
            	par1World.setBlock(var7, var8, var9, MysticModBlocks.mysticgenStone.blockID,0,2);            	
            	
            }
            if (par1World.getBlockId(var7, var8, var9) == Block.cobblestone.blockID || par1World.getBlockId(var7, var8, var9) == Block.planks.blockID || par1World.getBlockId(var7, var8, var9) == Block.leaves.blockID)
            {
            	par1World.setBlock(var7, var8, var9, MysticModBlocks.mysticCobblestone.blockID,0,2);
            }
            
        }
        }
    }
    
    
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconList[0] = par1IconRegister.registerIcon("MysticAdditions:mysticgrasstop");
        this.iconList[1] = par1IconRegister.registerIcon("MysticAdditions:mysticgrassside");
        this.iconList[2] = par1IconRegister.registerIcon("MysticAdditions:mysticdirt");
    	
    }
}

package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.worldgen.WorldGenRedTree;



public class BlockRedSapling extends BlockFlower 
{
    protected BlockRedSapling(int i)
    {
        super(i);
        float f = 0.4F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        
    }
    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        
        if (i == MysticModBlocks.mysticDirt.blockID) return true;
        else if (i == MysticModBlocks.inertDirt.blockID) return true;
        else return false;
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            super.updateTick(par1World, par2, par3, par4, par5Random);

            if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0)
            {
                int var6 = par1World.getBlockMetadata(par2, par3, par4);

                if ((var6 & 8) == 0)
                {
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 | 8,2);
                }
                else
                {
                    this.growTree(par1World, par2, par3, par4, par5Random);
                }
            }
        }
    }

   

    public void growTree(World world, int i, int j, int k, Random random)
    {
        int l = world.getBlockMetadata(i, j, k) & 3;
        world.setBlock(i, j, k, 0);
        Object obj = null;
        obj = new WorldGenRedTree(true);
        if (!((WorldGenerator) (obj)).generate(world, random, i, j, k))
        {
            world.setBlock(i, j, k, blockID, l,2);
        }
    }

    public int damageDropped(int i)
    {
        return i & 3;
    }
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("MysticAdditions:redsapling");
    }
}


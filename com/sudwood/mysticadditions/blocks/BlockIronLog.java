package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;



public class BlockIronLog extends Block 
{
	public Icon[] iconList = new Icon[3];
    protected BlockIronLog(int i)
    {
        super(i, Material.wood);
        
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int idDropped(int i, Random random, int j)
    {
        return MysticModBlocks.ironLog.blockID;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        super.harvestBlock(world, entityplayer, i, j, k, l);
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        byte byte0 = 4;
        int l = byte0 + 1;
        if (world.checkChunksExist(i - l, j - l, k - l, i + l, j + l, k + l))
        {
            for (int i1 = -byte0; i1 <= byte0; i1++)
            {
                for (int j1 = -byte0; j1 <= byte0; j1++)
                {
                    for (int k1 = -byte0; k1 <= byte0; k1++)
                    {
                        int l1 = world.getBlockId(i + i1, j + j1, k + k1);
                        if (l1 != MysticModBlocks.ironLeaves.blockID)
                        {
                            continue;
                        }
                        int i2 = world.getBlockMetadata(i + i1, j + j1, k + k1);
                        if ((i2 & 8) == 0)
                        {
                            world.setBlockMetadataWithNotify(i + i1, j + j1, k + k1, i2 | 8,2);
                        }
                    }
                }
            }
        }
    }

    public Icon getBlockTextureFromSideAndMetadata(int i, int j)
    {
        if (i == 1)
        {
            return this.iconList[1];
        }
        if (i == 0)
        {
            return this.iconList[1];
        }
        if (i == 2)
        {
            return this.iconList[0];
        }
        if (i == 3)
        {
            return this.iconList[0];
        }
        if (i == 4)
        {
            return this.iconList[0];
        }
        if (i == 5)
        {
            return this.iconList[0];
        }
   
        return this.iconList[0];
    }
    public int damageDropped(int i)
    {
        return i;
    }
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconList[0] = par1IconRegister.registerIcon("MysticAdditions:ironlogside");
        this.iconList[1] = par1IconRegister.registerIcon("MysticAdditions:ironlogtop");
    }
}

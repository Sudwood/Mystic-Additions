package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class BlockIronPlanks extends Block 
{
    public BlockIronPlanks(int i)
    {
        super(i, Material.wood);
    }

    public int idDropped(int i, Random random, int j)
    {
        return MysticModBlocks.ironPlanks.blockID;
    }
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("MysticAdditions:ironplanks");
    }
}

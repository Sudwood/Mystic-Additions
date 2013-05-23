package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

import com.sudwood.mysticadditions.MysticCommonProxy;




public class BlockMysticBricks extends Block 
{
    public BlockMysticBricks(int i)
    {
        super(i, Material.rock);
    }

    public int idDropped(int i, Random random, int j)
    {
        return MysticModBlocks.mysticBricks.blockID;
    }
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("MysticAdditions:mysticbricks");
    }
}

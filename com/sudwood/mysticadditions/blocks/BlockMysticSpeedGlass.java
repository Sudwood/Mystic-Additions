// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import com.sudwood.mysticadditions.MysticCommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;



// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockMysticSpeedGlass extends Block 
{

    public BlockMysticSpeedGlass(int i)
    {
        super(i, Material.rock);
    }

    public int idDropped(int i, Random random, int j)
    {
        return MysticModBlocks.mysticspeedGlass.blockID;
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox(i, j, k, i + 1, (float)(j + 1) - f, k + 1);
    }

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {
        entity.motionX *= 2D;
        entity.motionZ *= 2D;
        
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("MysticAdditions:mysticspeedglass");
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

import com.sudwood.mysticadditions.MysticCommonProxy;




// Referenced classes of package net.minecraft.src:
//            Block, Material

public class BlockMysticFireGlass extends BlockBreakable 
{

	 public BlockMysticFireGlass(int i, Material material, boolean flag)
	    {
	        super(i,"MysticAdditions:mysticfireglass" ,material, flag);
	    }

    public int idDropped(int i, Random random, int j)
    {
        return MysticModBlocks.mysticfireGlass.blockID;
    }
    
    public int getRenderBlockPass()
    {
        return 0;
    }
    public boolean isFireSource(World world, int x, int y, int z, int metadata, ForgeDirection side)
    {
    	return true;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox(i, j, k, i + 1, (float)(j + 1) - f, k + 1);
    }

    public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
    {  	
    	if(entity instanceof EntityItem )
    	{
    		entity.setDead();
    	}
    	entity.setFire(10);
    	
    }
  
 
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;



// Referenced classes of package net.minecraft.src:
//            BlockBreakable, Material

public class BlockMysticGlass extends BlockBreakable 
{
	public boolean[] connectors = new boolean[6];
    public BlockMysticGlass(int i, Material material, boolean flag)
    {
        super(i, "MysticAdditions:mysticglass", material, flag);
        
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }

    public int getRenderBlockPass()
    {
        return 0;
    }
    
    
	
}

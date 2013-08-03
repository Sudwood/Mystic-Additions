package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;



public class BlockMysticInertGrass extends Block 
{
	public Icon[] iconList = new Icon[3];
    public BlockMysticInertGrass(int i)
    {
        super(i, Material.ground);
        
        setCreativeTab(CreativeTabs.tabBlock);
      
    }

    public Icon getIcon(int i, int j)
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
    
   
 
    
    
    
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconList[0] = par1IconRegister.registerIcon("MysticAdditions:mysticgrasstop");
        this.iconList[1] = par1IconRegister.registerIcon("MysticAdditions:mysticgrassside");
        this.iconList[2] = par1IconRegister.registerIcon("MysticAdditions:mysticdirt");
    	
    }
	
}

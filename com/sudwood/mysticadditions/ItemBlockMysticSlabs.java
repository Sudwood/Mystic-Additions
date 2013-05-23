package com.sudwood.mysticadditions;

import java.util.List;

import com.sudwood.mysticadditions.blocks.MysticModBlocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMysticSlabs extends ItemBlock {
	
	private final static String[] subNames = {
		"MysticCobblestone","MysticStone","MysticBricks","RedPlanks","IronPlanks"
	};

	public ItemBlockMysticSlabs(int id) {
		super(id);
		setHasSubtypes(true);
		
	}
	
	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}
	
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        MysticModBlocks.mysticSlabSingle.getSubBlocks(par1, par2CreativeTabs, par3List);
    }
	public String getUnlocalizedName(ItemStack par1ItemStack)
    {
		int var1 = par1ItemStack.getItemDamage();
		switch(var1)
		{
			case 0: return "Mystic Cobblestone Slab";
			case 1: return "Mystic Stone Slab";
			case 2: return "Mystic Brick Slab";
			case 3: return "Red Plank Slab";
			case 4: return "Iron Plank Slab";
			default: return "Mystic Slabs";
		}
				
				
    }

}
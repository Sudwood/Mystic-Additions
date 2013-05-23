package com.sudwood.mysticadditions.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.blocks.BlockIronSapling;
import com.sudwood.mysticadditions.blocks.BlockRedSapling;
import com.sudwood.mysticadditions.blocks.MysticModBlocks;


public class ItemEnchantedBonemeal extends Item 
{
	
	public ItemEnchantedBonemeal(int x)
	{
		super(x);
		maxStackSize = 64;	
		
		
	}
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int i, int j, int k, int l)
    {
	int i1 = world.getBlockId(i, j, k);
	if (i1 == MysticModBlocks.redSapling.blockID){
	((BlockRedSapling)MysticModBlocks.redSapling).growTree(world, i, j, k, world.rand);
    itemstack.stackSize--;
	}
	if (i1 == MysticModBlocks.ironSapling.blockID){
		((BlockIronSapling)MysticModBlocks.ironSapling).growTree(world, i, j, k, world.rand);
	    itemstack.stackSize--;
		}
	return true;
    
    }
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:enchantedbonemeal");
	}


	
}

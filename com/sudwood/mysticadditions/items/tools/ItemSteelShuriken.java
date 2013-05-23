package com.sudwood.mysticadditions.items.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.entity.EntitySteelShuriken;
import com.sudwood.mysticadditions.items.MysticModItems;


public class ItemSteelShuriken extends Item 
{
	
	public ItemSteelShuriken(int x)
	{
		super(x);
		maxStackSize = 64;	
		
		
	}
	public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 0x11940;
    }

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
		boolean var5 = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemstack) > 0;
		if (var5 || entityplayer.inventory.hasItem(MysticModItems.steelShuriken.itemID))
        {
	            int j = getMaxItemUseDuration(itemstack) - 1;
	            float f = (float)j / 20F;
	            f = (f * f + f * 2.0F) / 3F;
	            if((double)f < 0.10000000000000001D)
	            {
	                return itemstack;
	            }
	            if(f > 1.0F)
	            {
	                f = 1.0F;
	            }
	            EntitySteelShuriken entityarrow = new EntitySteelShuriken(world, entityplayer, 2F);
	          
	            if(f == 1.0F)
	            {
	                entityarrow.arrowCritical = true;
	            }
	            itemstack.damageItem(1, entityplayer);
	            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
	            entityplayer.inventory.consumeInventoryItem(MysticModItems.steelShuriken.itemID);
	            if(!world.isRemote)
	            {
	                world.spawnEntityInWorld(entityarrow);
	            }}
	    	return itemstack;
    }
	@Override
	public void updateIcons(IconRegister iconRegister)
	{
		this.iconIndex = iconRegister.registerIcon("MysticAdditions:steelshuriken");
	}


	
}

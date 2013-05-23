package com.sudwood.mysticadditions.items;

import com.sudwood.mysticadditions.MysticCommonProxy;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemRawWarpFood extends ItemFood {

	public ItemRawWarpFood(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		maxStackSize = 64;
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:rawwarpfood");
	}
	@Override
	protected void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
           if (!par2World.isRemote)
            {
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.blindness.id, 600, 3));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 600, 1));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 2000, 1));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 3000, 6));
            }
        }
       
    }



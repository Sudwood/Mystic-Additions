package com.sudwood.mysticadditions.items;

import com.sudwood.mysticadditions.MysticCommonProxy;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemCookedWarpFood extends ItemFood {

	public ItemCookedWarpFood(int par1, int par2, float par3, boolean par4) {
		super(par1, par2, par3, par4);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateIcons(IconRegister iconRegister)
	{
	         this.iconIndex = iconRegister.registerIcon("MysticAdditions:cookedwarpfood");
	}
	protected void func_77849_c(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
           if (!par2World.isRemote)
            {
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 400, 3));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 400, 1));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.invisibility.id, 900, 1));
                par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.nightVision.id, 900, 1));
            }
        }
       
    }
	


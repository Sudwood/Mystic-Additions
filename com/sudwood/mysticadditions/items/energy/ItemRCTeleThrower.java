package com.sudwood.mysticadditions.items.energy;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemRCTeleThrower extends IItemMysticRechargeable{

	public ItemRCTeleThrower(int par1, int maxEnergy, int rechargeRate) {
		super(par1, maxEnergy, rechargeRate);
		
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon("MysticAdditions:rctelethrower");
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(this.currentCharge>=250)
		{
        if (par3EntityPlayer.capabilities.isCreativeMode)
        {
            return par1ItemStack;
        }
        else if (par3EntityPlayer.ridingEntity != null)
        {
            return par1ItemStack;
        }
        else
        {
        	if(par1ItemStack.getTagCompound()==null)
  		  {
  			  par1ItemStack.setTagCompound(new NBTTagCompound());
  		  }
  		  NBTTagCompound tag = par1ItemStack.getTagCompound();
  		  this.currentCharge = tag.getInteger("CurrentCharge");
  		  this.currentCharge-=250;
  		  tag.setInteger("CurrentCharge", this.currentCharge);
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!par2World.isRemote)
            {
                par2World.spawnEntityInWorld(new EntityEnderPearl(par2World, par3EntityPlayer));
            }
            
            return par1ItemStack;
        }
		}
		return par1ItemStack;
    }
	
	

}

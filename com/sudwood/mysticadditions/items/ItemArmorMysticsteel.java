package com.sudwood.mysticadditions.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemArmorMysticsteel extends ItemArmor 
{
	private int armorpiece;
    public ItemArmorMysticsteel(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, enumarmormaterial, j, k);
        armorpiece = k;
    }
    
    @Override
	public void registerIcons(IconRegister iconRegister)
	{
    		 if(armorpiece==0)
    		 {
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:CSteel Helm");
    		 }
    		 if(armorpiece==1)
    		 {
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:CSteel Chest");
    		 }
    		 if(armorpiece==2)
    		 {
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:CSteel Legs");
    		 }
    		 if(armorpiece==3)
    		 {
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:CSteel Boots");
    		 }
	}

    @Override
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type)
    {
        if(itemstack.itemID == MysticModItems.helmCSteel.itemID || itemstack.itemID == MysticModItems.chestCSteel.itemID || itemstack.itemID == MysticModItems.bootsCSteel.itemID)
        {
                return "MysticAdditions:textures/csteel_1.png";
        }
        if(itemstack.itemID == MysticModItems.legsCSteel.itemID)
        {
                return "MysticAdditions:textures/csteel_2.png";
        }
        return  "MysticAdditions:textures/csteel_1.png";
    }
  
    /**
     * Return the color for the specified armor ItemStack.
     */
    public int getColor(ItemStack par1ItemStack)
    {
        
            NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

            if (nbttagcompound == null)
            {
                return 15066597;
            }
            else
            {
                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
                return nbttagcompound1 == null ? 15066597 : (nbttagcompound1.hasKey("color") ? nbttagcompound1.getInteger("color") : 15066597);
            }
        
    }
}
package com.sudwood.mysticadditions.items;

import com.sudwood.mysticadditions.MysticCommonProxy;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.IArmorTextureProvider;

public class ItemArmorMysticstone extends ItemArmor 
{
	private int armorpiece;
    public ItemArmorMysticstone(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, enumarmormaterial, j, k);
        armorpiece = k;
    }
    
 
    @Override
   	public void registerIcons(IconRegister iconRegister)
   	{
       		 if(armorpiece==0)
       		 {
   	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:Stone Helm");
       		 }
       		 if(armorpiece==1)
       		 {
   	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:Stone Chest");
       		 }
       		 if(armorpiece==2)
       		 {
   	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:Stone Legs");
       		 }
       		 if(armorpiece==3)
       		 {
   	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:Stone Boots");
       		 }
   	}

    public String getArmorTextureFile(ItemStack itemstack)
    {
        if(itemstack.itemID == MysticModItems.helmStone.itemID || itemstack.itemID == MysticModItems.chestStone.itemID || itemstack.itemID == MysticModItems.bootsStone.itemID)
        {
                return "/mods/MysticAdditions/textures/stone_1.png";
        }
        if(itemstack.itemID == MysticModItems.legsStone.itemID)
        {
                return "/mods/MysticAdditions/textures/stone_2.png";
        }
        return  "/mods/MysticAdditions/textures/stone_1.png";
    }
    /**
     * Return the color for the specified armor ItemStack.
     */
    public int getColor(ItemStack par1ItemStack)
    {
        
            NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

            if (nbttagcompound == null)
            {
                return 8355711;
            }
            else
            {
                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
                return nbttagcompound1 == null ? 8355711 : (nbttagcompound1.hasKey("color") ? nbttagcompound1.getInteger("color") : 8355711);
            }
        
    }
}
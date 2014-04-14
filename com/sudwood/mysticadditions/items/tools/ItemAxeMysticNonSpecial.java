package com.sudwood.mysticadditions.items.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemAxeMysticNonSpecial extends ItemAxe 
{
        String icon;
    public ItemAxeMysticNonSpecial(int i, EnumToolMaterial enumtoolmaterial, String icon)
    {
        super(i, enumtoolmaterial);
        this.icon = icon;
    }
    
    @Override
   	public void registerIcons(IconRegister iconRegister)
   	{
   		this.itemIcon = iconRegister.registerIcon(icon);
   	}

}
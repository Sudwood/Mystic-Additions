package com.sudwood.mysticadditions.items.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemSpadeMysticNonSpecial extends ItemSpade 
{
        String icon;
    public ItemSpadeMysticNonSpecial(int i, EnumToolMaterial enumtoolmaterial, String icon)
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
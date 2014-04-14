package com.sudwood.mysticadditions.items.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemPickaxeMysticNonSpecial extends ItemPickaxe 
{
        String icon;
    public ItemPickaxeMysticNonSpecial(int i, EnumToolMaterial enumtoolmaterial, String icon)
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
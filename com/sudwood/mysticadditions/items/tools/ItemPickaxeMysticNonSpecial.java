package com.sudwood.mysticadditions.items.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemPickaxeMysticNonSpecial extends ItemPickaxe 
{
        
    public ItemPickaxeMysticNonSpecial(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }
   
    @Override
   	public void updateIcons(IconRegister iconRegister)
   	{
   		this.iconIndex = iconRegister.registerIcon("MysticAdditions:CSteel Pick");
   	}

}
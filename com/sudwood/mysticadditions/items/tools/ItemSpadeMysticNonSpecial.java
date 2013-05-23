package com.sudwood.mysticadditions.items.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemSpadeMysticNonSpecial extends ItemSpade 
{
        
    public ItemSpadeMysticNonSpecial(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }
    
    @Override
   	public void updateIcons(IconRegister iconRegister)
   	{
   		this.iconIndex = iconRegister.registerIcon("MysticAdditions:CSteel Shovel");
   	}

}
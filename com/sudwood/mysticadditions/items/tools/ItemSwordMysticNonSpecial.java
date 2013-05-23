package com.sudwood.mysticadditions.items.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSword;

import com.sudwood.mysticadditions.MysticCommonProxy;


public class ItemSwordMysticNonSpecial extends ItemSword 
{
        
    public ItemSwordMysticNonSpecial(int i, EnumToolMaterial enumtoolmaterial)
    {
        super(i, enumtoolmaterial);
    }
   
    @Override
   	public void registerIcons(IconRegister iconRegister)
   	{
   		this.itemIcon = iconRegister.registerIcon("MysticAdditions:CSteel Sword");
   	}
    

}
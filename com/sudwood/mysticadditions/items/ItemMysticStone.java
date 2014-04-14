package com.sudwood.mysticadditions.items;

import com.sudwood.mysticadditions.MysticCommonProxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import net.minecraft.src.ModLoader;
import net.minecraft.world.World;



public class ItemMysticStone extends Item 
{
	//Minecraft mc = ModLoader.getMinecraftInstance();
	
	
//World world = mc.theWorld; //get the current world.

//EntityPlayer player = mc.thePlayer; //get the player entity.

	public ItemMysticStone(int x)
	{
		super(x);
		maxStackSize = 1;	
		this.setContainerItem(this);
		
		
	}
	@Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack){
    	return EnumRarity.rare;
    }
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:mysticstone");
	}
	  @Override 
	  public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
	   
	      return false;
	      
	     }
	

	
}

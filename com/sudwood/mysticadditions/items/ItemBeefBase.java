package com.sudwood.mysticadditions.items;

import java.util.List;

import com.sudwood.mysticadditions.MysticCommonProxy;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBeefBase  extends Item{

	public ItemBeefBase(int par1) {
		super(par1);
		this.setMaxStackSize(1);
		this.setContainerItem(this);
		// TODO Auto-generated constructor stub
	}
	 public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		 par3List.add("Target(Beef)");
		 
	 }
	 @Override
		public void updateIcons(IconRegister iconRegister)
		{
		         this.iconIndex = iconRegister.registerIcon("MysticAdditions:warptargetbeef");
		}
	  @Override 
	  public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack) {
	   
	      return false;
	      
	     }
}

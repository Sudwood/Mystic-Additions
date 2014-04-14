package com.sudwood.mysticadditions;

import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeable;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeableArmor;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class SlotMysticRechargeableArmor extends Slot
{
	int piece;
	public SlotMysticRechargeableArmor(IInventory par1iInventory, int par2, int par3, int par4, int armorPiece) 
	{
		super(par1iInventory, par2, par3, par4);
		piece = armorPiece;
	}

	/**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack par1ItemStack)
    {
    	if(par1ItemStack.getItem() instanceof IItemMysticRechargeableArmor && ((ItemArmor)par1ItemStack.getItem()).armorType == piece)
    		return true;
    	else return false;
    }
}

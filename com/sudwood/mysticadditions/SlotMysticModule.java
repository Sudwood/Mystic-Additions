package com.sudwood.mysticadditions;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeable;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeableArmor;
import com.sudwood.mysticadditions.items.energy.MysticModule;

public class SlotMysticModule extends Slot
{

	public SlotMysticModule(IInventory par1iInventory, int par2, int par3, int par4) 
	{
		super(par1iInventory, par2, par3, par4);
		
	}

	/**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack par1ItemStack)
    {
    	if(par1ItemStack.getItem() instanceof MysticModule)
    		return true;
    	else return false;
    }
}

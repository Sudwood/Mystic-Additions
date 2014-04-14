package com.sudwood.mysticadditions.container;

import com.sudwood.mysticadditions.tileentity.TileEntityMysticFurnace;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGrinder;
import com.sudwood.mysticadditions.tileentity.TileEntityOreRift;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerOreRift extends Container
{
    private TileEntityOreRift tile;
    private int lastEnergyLevel = 0;
    private boolean lastRunning = false;
    private int lastSpin = 0;
    private int lastTime = 0;
    public ContainerOreRift(InventoryPlayer par1InventoryPlayer, TileEntityOreRift par2TileEntity)
    {
        this.tile = par2TileEntity;

	        this.addSlotToContainer(new Slot(par2TileEntity, 0, 8, 30));
	        this.addSlotToContainer(new Slot(par2TileEntity, 1, 46, 30));
	        this.addSlotToContainer(new Slot(par2TileEntity, 2, 8, 51));
	        this.addSlotToContainer(new Slot(par2TileEntity, 3, 46, 51));

        for( int i = 0; i< 4; i++)
        {
        	this.addSlotToContainer(new Slot(par2TileEntity, i+4, 101+18*i, 5));
        }
        for( int i = 0; i< 4; i++)
        {
        	this.addSlotToContainer(new Slot(par2TileEntity, i+8, 101+18*i, 23));
        }
        for( int i = 0; i< 4; i++)
        {
        	this.addSlotToContainer(new Slot(par2TileEntity, i+12, 101+18*i, 41));
        }
        for( int i = 0; i< 4; i++)
        {
        	this.addSlotToContainer(new Slot(par2TileEntity, i+16, 101+18*i, 59));
        }
        int var3;

        for (var3 = 0; var3 < 3; ++var3)
        {
            for (int var4 = 0; var4 < 9; ++var4)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
            }
        }

        for (var3 = 0; var3 < 9; ++var3)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, var3, 8 + var3 * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.tile.energyLevel);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int var1 = 0; var1 < this.crafters.size(); ++var1)
        {
            ICrafting var2 = (ICrafting)this.crafters.get(var1);

            
            if (this.lastEnergyLevel != this.tile.energyLevel)
            {
            	var2.sendProgressBarUpdate(this, 0, this.tile.energyLevel);
            }
            if (this.lastRunning != this.tile.isRunning)
            {
            	var2.sendProgressBarUpdate(this, 1, (this.tile.isRunning ? 1 : 0));
            }
           
            if(this.lastSpin != this.tile.spinCount)
            {
            	var2.sendProgressBarUpdate(this, 2, this.tile.spinCount);
            }
            if(this.lastTime != this.tile.timeTillComplete)
            {
            	var2.sendProgressBarUpdate(this, 3, this.tile.timeTillComplete);
            }
        }
        this.lastEnergyLevel = this.tile.energyLevel;
        this.lastRunning = this.tile.isRunning;
        this.lastSpin = this.tile.spinCount;
        this.lastTime = this.tile.timeTillComplete;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {

        if (par1 == 0)
        {
            this.tile.energyLevel = par2;
        }
       
        if( par1 == 1)
        {
        	this.tile.isRunning = (par2 != 0);
        }
        if(par1==2)
        {
        	this.tile.spinCount = par2;
        }
        if(par1==3)
        {
        	this.tile.timeTillComplete = par2;
        }
       
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.tile.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack var3 = null;
        Slot var4 = (Slot)this.inventorySlots.get(par2);

        if (var4 != null && var4.getHasStack())
        {
            ItemStack var5 = var4.getStack();
            var3 = var5.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(var5, 3, 39, true))
                {
                    return null;
                }

                var4.onSlotChange(var5, var3);
            }
            else if (par2 != 1 && par2 != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(var5) != null)
                {
                    if (!this.mergeItemStack(var5, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(var5))
                {
                    if (!this.mergeItemStack(var5, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(var5, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(var5, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(var5, 3, 39, false))
            {
                return null;
            }

            if (var5.stackSize == 0)
            {
                var4.putStack((ItemStack)null);
            }
            else
            {
                var4.onSlotChanged();
            }

            if (var5.stackSize == var3.stackSize)
            {
                return null;
            }

            var4.onPickupFromSlot(par1EntityPlayer, var5);
        }

        return var3;
    }
}

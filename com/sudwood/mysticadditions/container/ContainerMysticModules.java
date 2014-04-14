package com.sudwood.mysticadditions.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.sudwood.mysticadditions.SlotMysticModule;
import com.sudwood.mysticadditions.SlotMysticRechargeable;
import com.sudwood.mysticadditions.SlotMysticRechargeableArmor;
import com.sudwood.mysticadditions.tileentity.TileEntityModuleTable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerMysticModules extends Container
{
    private int lastEnergyLevel = 0;
    TileEntityModuleTable inventory;
    
	public ContainerMysticModules(EntityPlayer player, InventoryPlayer inventoryPlayer, TileEntityModuleTable tile)
			{
			int i;
			inventory = tile;
			//head
			this.addSlotToContainer(new SlotMysticRechargeableArmor(tile, 0, 10, 8, 0));
			
				this.addSlotToContainer(new SlotMysticModule(tile, 1, 30, 7));
				this.addSlotToContainer(new SlotMysticModule(tile, 2, 51, 7));
			
			//Chest
			this.addSlotToContainer(new SlotMysticRechargeableArmor(tile, 3, 10, 29, 1));
			
				this.addSlotToContainer(new SlotMysticModule(tile, 4, 30, 29));
				this.addSlotToContainer(new SlotMysticModule(tile, 5, 51, 29));
			
			//Legs
			this.addSlotToContainer(new SlotMysticRechargeableArmor(tile, 6, 10, 50, 2));
			
				this.addSlotToContainer(new SlotMysticModule(tile, 7, 30, 51));
				this.addSlotToContainer(new SlotMysticModule(tile, 8, 51, 51));
			
			//Boots
			this.addSlotToContainer(new SlotMysticRechargeableArmor(tile, 9, 88, 8, 3));
			
				this.addSlotToContainer(new SlotMysticModule(tile, 10, 110, 7));
				this.addSlotToContainer(new SlotMysticModule(tile, 11, 131, 7));
			
			//Tool
			this.addSlotToContainer(new SlotMysticRechargeable(tile, 12, 88, 29));
			
				this.addSlotToContainer(new SlotMysticModule(tile, 13, 110, 29));
				this.addSlotToContainer(new SlotMysticModule(tile, 14, 131, 29));
			
			
			for (i = 0; i < 3; ++i)
			{
				for (int j = 0; j < 9; ++j)
				{
					this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
				}
			}
			for (i = 0; i < 9; ++i)
			{
				this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
			}
			}
	@SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
        	 this.inventory.energyLevel = par2;
        }

       

       
    }
			
	public ItemStack transferStackInSlot(EntityPlayer player, int par2)
	{
		return null;
	}		
	public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int var1 = 0; var1 < this.crafters.size(); ++var1)
        {
            ICrafting var2 = (ICrafting)this.crafters.get(var1);

    
            if (this.lastEnergyLevel != this.inventory.energyLevel)
            {
            	var2.sendProgressBarUpdate(this, 0, this.inventory.energyLevel);
            }

           

           
        }

        this.lastEnergyLevel = this.inventory.energyLevel;
        
    }
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return true;
	}

}
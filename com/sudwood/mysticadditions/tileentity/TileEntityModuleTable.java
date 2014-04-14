package com.sudwood.mysticadditions.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeable;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeableArmor;
import com.sudwood.mysticadditions.items.energy.MysticModule;

public class TileEntityModuleTable extends TileEntityMysticEnergy implements IInventory
{
	private ItemStack[] inventory = new ItemStack[15];
	public TileEntityModuleTable(int maxEnergy) 
	{
		super(maxEnergy);
		
	}
	public TileEntityModuleTable() 
	{
		super(32000);
		
	}

	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		// TODO Auto-generated method stub
		return inventory[i];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		  if (this.inventory[par1] != null)
	        {
	            ItemStack var3;

	            if (this.inventory[par1].stackSize <= par2)
	            {
	                var3 = this.inventory[par1];
	                this.inventory[par1] = null;
	                return var3;
	            }
	            else
	            {
	                var3 = this.inventory[par1].splitStack(par2);

	                if (this.inventory[par1].stackSize == 0)
	                {
	                    this.inventory[par1] = null;
	                }

	                return var3;
	            }
	        }
	        else
	        {
	            return null;
	        }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		if (this.inventory[par1] != null)
        {
            ItemStack var2 = this.inventory[par1];
            this.inventory[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		 this.inventory[i] = itemstack;

	        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
	        {
	            itemstack.stackSize = this.getInventoryStackLimit();
	        }
	}
	/**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
    	this.getEnergyTeleported();
    }

	@Override
	public boolean canUpdate()
	{
		   return true;
	}
	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return "Module Table";
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		// TODO Auto-generated method stub
		 return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openChest() {}

	@Override
	public void closeChest() {}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		if((i == 0 || i == 3 || i == 6 || i == 9) && itemstack.getItem() instanceof IItemMysticRechargeableArmor)
			return true;
		if(i == 12 && itemstack.getItem() instanceof IItemMysticRechargeable)
			return true;
		else return false;
	}
	public void readFromNBT(NBTTagCompound tag)
    {
		
        super.readFromNBT(tag);
        efficiencyLevel = tag.getDouble("EfficiencyLevel");
        energyLevel = tag.getInteger("energyLevel");
        isFull = tag.getBoolean("isFull");
        this.coords0 = tag.getIntArray("coordinates0");
        this.coords1 = tag.getIntArray("coordinates1");
        this.coords2 = tag.getIntArray("coordinates2");
        this.coords3 = tag.getIntArray("coordinates3");
        this.coords4 = tag.getIntArray("coordinated4");
        this.activeConnections = tag.getIntArray("activeconnections");
        isGettingTeleportedPower = tag.getBoolean("isGettingTeleportedPower");
        numberDrawing = tag.getInteger("numberDrawing");
        NBTTagList var2 = tag.getTagList("Items");
        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.inventory.length)
            {
                this.inventory[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
    }
	public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setDouble("EfficiencyLevel", efficiencyLevel);
        tag.setInteger("energyLevel", energyLevel);
        tag.setIntArray("coordinates0", coords0);
        tag.setIntArray("coordinates1", coords1);
        tag.setIntArray("coordinates2", coords2);
        tag.setIntArray("coordinates3", coords3);
        tag.setIntArray("coordinates4", coords4);
        tag.setIntArray("activeconnections", activeConnections);
        tag.setBoolean("isFull", isFull);
        tag.setBoolean("isGettingTeleportedPower", isGettingTeleportedPower);
        tag.setInteger("numberDrawing", numberDrawing);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.inventory.length; ++var3)
        {
            if (this.inventory[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.inventory[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }
       tag.setTag("Items", var2);
       
    }
	public void bindModules() 
	{
		if(this.energyLevel >= 30000)
		{
			if(inventory[0]!=null)
			{
				NBTTagCompound tag = inventory[0].getTagCompound();
				NBTTagList var2 = new NBTTagList();
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)0);
                this.inventory[1].writeToNBT(var4);
                var2.appendTag(var4);
                NBTTagCompound var5 = new NBTTagCompound();
                var5.setByte("Slot", (byte)1);
                this.inventory[2].writeToNBT(var5);
                var2.appendTag(var5);
		        tag.setTag("Items", var2);
		        if(MysticModule.getTypeForStack(inventory[1]) == MysticModule.EARTH)
		        {
		        	if(MysticModule.getTypeForStack(inventory[2]) == MysticModule.EARTH)
		        	{
		        		tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(8000*inventory[1].stackSize*inventory[2].stackSize));
		        	}
		        	else
		        	{
		        		tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(4000*inventory[1].stackSize));
		        	}
		        }
		        if(MysticModule.getTypeForStack(inventory[2]) == MysticModule.EARTH && MysticModule.getTypeForStack(inventory[1]) != MysticModule.EARTH)
		        {
		        	tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(4000*inventory[2].stackSize));
		        }
				//helm
				((IItemMysticRechargeableArmor)inventory[0].getItem()).mods[0] = inventory[1];
				((IItemMysticRechargeableArmor)inventory[0].getItem()).mods[1] = inventory[2];
				this.inventory[1] = null;
				this.inventory[2] = null;
			}
			if(inventory[3]!=null)
			{
				NBTTagCompound tag = inventory[3].getTagCompound();
				NBTTagList var2 = new NBTTagList();
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)0);
                this.inventory[4].writeToNBT(var4);
                var2.appendTag(var4);
                NBTTagCompound var5 = new NBTTagCompound();
                var5.setByte("Slot", (byte)1);
                this.inventory[5].writeToNBT(var5);
                var2.appendTag(var5);
		        tag.setTag("Items", var2);
		        if(MysticModule.getTypeForStack(inventory[4]) == MysticModule.EARTH)
		        {
		        	if(MysticModule.getTypeForStack(inventory[5]) == MysticModule.EARTH)
		        	{
		        		tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(8000*inventory[4].stackSize*inventory[5].stackSize));
		        	}
		        	else
		        	{
		        		tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(4000*inventory[4].stackSize));
		        	}
		        }
		        if(MysticModule.getTypeForStack(inventory[5]) == MysticModule.EARTH && MysticModule.getTypeForStack(inventory[4]) != MysticModule.EARTH)
		        {
		        	tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(4000*inventory[5].stackSize));
		        }
				//chest
				((IItemMysticRechargeableArmor)inventory[3].getItem()).mods[0] = inventory[4];
				((IItemMysticRechargeableArmor)inventory[3].getItem()).mods[1] = inventory[5];
				this.inventory[4] = null;
				this.inventory[5] = null;
			}
			if(inventory[6]!=null)
			{
				NBTTagCompound tag = inventory[6].getTagCompound();
				NBTTagList var2 = new NBTTagList();
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)0);
                this.inventory[7].writeToNBT(var4);
                var2.appendTag(var4);
                NBTTagCompound var5 = new NBTTagCompound();
                var5.setByte("Slot", (byte)1);
                this.inventory[8].writeToNBT(var5);
                var2.appendTag(var5);
		        tag.setTag("Items", var2);
		        if(MysticModule.getTypeForStack(inventory[7]) == MysticModule.EARTH)
		        {
		        	if(MysticModule.getTypeForStack(inventory[8]) == MysticModule.EARTH)
		        	{
		        		tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(8000*inventory[7].stackSize*inventory[8].stackSize));
		        	}
		        	else
		        	{
		        		tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(4000*inventory[7].stackSize));
		        	}
		        }
		        if(MysticModule.getTypeForStack(inventory[8]) == MysticModule.EARTH && MysticModule.getTypeForStack(inventory[7]) != MysticModule.EARTH)
		        {
		        	tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(4000*inventory[8].stackSize));
		        }
				//legs
				((IItemMysticRechargeableArmor)inventory[6].getItem()).mods[0] = inventory[7];
				((IItemMysticRechargeableArmor)inventory[6].getItem()).mods[0] = inventory[8];
				this.inventory[7] = null;
				this.inventory[8] = null;
			}
			if(inventory[9]!=null)
			{
				NBTTagCompound tag = inventory[9].getTagCompound();
				NBTTagList var2 = new NBTTagList();
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)0);
                this.inventory[10].writeToNBT(var4);
                var2.appendTag(var4);
                NBTTagCompound var5 = new NBTTagCompound();
                var5.setByte("Slot", (byte)1);
                this.inventory[11].writeToNBT(var5);
                var2.appendTag(var5);
		        tag.setTag("Items", var2);
		        if(MysticModule.getTypeForStack(inventory[10]) == MysticModule.EARTH)
		        {
		        	if(MysticModule.getTypeForStack(inventory[11]) == MysticModule.EARTH)
		        	{
		        		tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(8000*inventory[10].stackSize*inventory[11].stackSize));
		        	}
		        	else
		        	{
		        		tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(4000*inventory[10].stackSize));
		        	}
		        }
		        if(MysticModule.getTypeForStack(inventory[11]) == MysticModule.EARTH && MysticModule.getTypeForStack(inventory[10]) != MysticModule.EARTH)
		        {
		        	tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(4000*inventory[11].stackSize));
		        }
				//boots
				((IItemMysticRechargeableArmor)inventory[9].getItem()).mods[0] = inventory[10];
				((IItemMysticRechargeableArmor)inventory[9].getItem()).mods[0] = inventory[11];
				this.inventory[10] = null;
				this.inventory[11] = null;
			}
			if(inventory[12]!=null)
			{
				NBTTagCompound tag = inventory[12].getTagCompound();
				NBTTagList var2 = new NBTTagList();
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)0);
                this.inventory[13].writeToNBT(var4);
                var2.appendTag(var4);
                NBTTagCompound var5 = new NBTTagCompound();
                var5.setByte("Slot", (byte)1);
                this.inventory[14].writeToNBT(var5);
                var2.appendTag(var5);
		        tag.setTag("Items", var2);
		        if(MysticModule.getTypeForStack(inventory[13]) == MysticModule.EARTH)
		        {
		        	if(MysticModule.getTypeForStack(inventory[14]) == MysticModule.EARTH)
		        	{
		        		tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(8000*inventory[13].stackSize*inventory[14].stackSize));
		        	}
		        	else
		        	{
		        		tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(4000*inventory[13].stackSize));
		        	}
		        }
		        if(MysticModule.getTypeForStack(inventory[14]) == MysticModule.EARTH && MysticModule.getTypeForStack(inventory[13]) != MysticModule.EARTH)
		        {
		        	tag.setInteger("MaxStorage", tag.getInteger("OriginalMaxStorage")+(4000*inventory[14].stackSize));
		        }
				//item
				((IItemMysticRechargeable)inventory[12].getItem()).mods[0] = inventory[13];
				((IItemMysticRechargeable)inventory[12].getItem()).mods[0] = inventory[14];
				this.inventory[13] = null;
				this.inventory[14] = null;
			}
			this.energyLevel-=30000;
			
		}
	}

}

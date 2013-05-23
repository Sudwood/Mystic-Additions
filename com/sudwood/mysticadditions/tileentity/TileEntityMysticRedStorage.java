package com.sudwood.mysticadditions.tileentity;

import com.sudwood.mysticadditions.MysticEnergy;
import com.sudwood.mysticadditions.mod_MysticAdditions;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class TileEntityMysticRedStorage extends TileEntity implements MysticEnergy, IInventory{
	private int[] coords = {42,42,42};
	private int[] connectors = {42,42,42,42,42,42};
	private final int maxEnergyLevel = 40000;
	public int energyLevel = 0;
	private boolean isFull = false;
	public static int numberDrawing = 0;
	private int[] wireConnectors = {0,0,0,0,0,0};
	private int[] teleportedPowerCoords={0,0,0};
	private boolean isGettingTeleportedPower = false;
	public float rotationAngle =0F;
	public double efficiencyLevel = 4;
	private ItemStack[] furnaceItemStacks = new ItemStack[2];
	public TileEntityMysticRedStorage()
	{
		
	}
	public boolean canUpdate(){
		   return true;
	   }
	@Override
	public int[] checkConnect(WorldServer world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}
	public void readFromNBT(NBTTagCompound tag)
    {
		
        super.readFromNBT(tag);
        efficiencyLevel = tag.getDouble("EfficiencyLevel");
        energyLevel = tag.getInteger("energyLevel");
        connectors = tag.getIntArray("connectors");
        coords = tag.getIntArray("coordinates");
        isFull = tag.getBoolean("isFull");
        teleportedPowerCoords = tag.getIntArray("teleportedPowerCoords");
        isGettingTeleportedPower = tag.getBoolean("isGettingTeleportedPower");
        numberDrawing = tag.getInteger("numberDrawing");
        NBTTagList var2 = tag.getTagList("Items");
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.furnaceItemStacks.length)
            {
                this.furnaceItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
    }

	public String setTeleportPowerCoords(int[] coords)
	{
		if(Math.abs(Math.abs(coords[0])-Math.abs(this.xCoord))>20||Math.abs(Math.abs(coords[1])-Math.abs(this.yCoord))>20||Math.abs(Math.abs(coords[2])-Math.abs(this.zCoord))>20)
		{
			return "Distance too far, Coordinates not set.";
		}
		this.teleportedPowerCoords = coords;
		return "Coordinates set.";
	}
	public void setIsGettingTeleportedPower(boolean bool)
	{
		isGettingTeleportedPower = bool;
	}

	
	public void setCoords()
	{
		coords[0]=this.xCoord;
		coords[1]=this.yCoord;
		coords[2]=this.zCoord;
	}
	public void setConnectors(int[] connector)
	{
		connectors = connector;
	}
	public void setEnergyLevel(double d){
		
		energyLevel = (int) d;
	}
	public int getEnergyLevel()
	{
		return energyLevel;
	}
	public void getEnergy()
	{
		
		
		
	}
	public void getEnergyTeleported()
	{
		if(this.energyLevel<this.maxEnergyLevel-32)
		{
		TileEntity tile = worldObj.getBlockTileEntity(teleportedPowerCoords[0], teleportedPowerCoords[1], teleportedPowerCoords[2]);
		if(tile instanceof TileEntityMysticRedStorage)
		{
			if(((TileEntityMysticRedStorage) tile).getEnergyLevel()>32){
				
			((TileEntityMysticRedStorage) tile).setEnergyLevel(((TileEntityMysticRedStorage) tile).getEnergyLevel()-32);
			this.setEnergyLevel(this.energyLevel+32/(this.efficiencyLevel+((TileEntityMysticRedStorage) tile).numberDrawing-1));
			}
		}
		if(tile instanceof TileEntityMysticRedGenerator)
		{
			if(((TileEntityMysticRedGenerator) tile).getEnergyLevel()>32){
				
				
			((TileEntityMysticRedGenerator) tile).setEnergyLevel(((TileEntityMysticRedGenerator) tile).getEnergyLevel()-32);
			this.setEnergyLevel(this.energyLevel+32/(this.efficiencyLevel+((TileEntityMysticRedGenerator) tile).numberDrawing-1));
			}
		}
		}
		
	}
	  @SideOnly(Side.CLIENT)
		 public int getCookProgressScaled(int par1)
		    {
		        return this.energyLevel * par1 / this.maxEnergyLevel;
		    }
	
	public void setWireConnectors(int[] connect)
	{
		
	}
	public void getNetwork()
	{
		
	}
	public void sendEnergy()
	{
		
	}
	 public void writeToNBT(NBTTagCompound tag)
	    {
	        super.writeToNBT(tag);
	        tag.setDouble("EfficiencyLevel", efficiencyLevel);
	        tag.setInteger("energyLevel", energyLevel);
	        tag.setIntArray("connectors", connectors);
	        tag.setIntArray("coordinates", coords);
	        tag.setBoolean("isFull", isFull);
	        tag.setIntArray("teleportedPowerCoords", teleportedPowerCoords);
	        tag.setBoolean("isGettingTeleportedPower", isGettingTeleportedPower);
	        tag.setInteger("numberDrawing", numberDrawing);
	        NBTTagList var2 = new NBTTagList();

	        for (int var3 = 0; var3 < this.furnaceItemStacks.length; ++var3)
	        {
	            if (this.furnaceItemStacks[var3] != null)
	            {
	                NBTTagCompound var4 = new NBTTagCompound();
	                var4.setByte("Slot", (byte)var3);
	                this.furnaceItemStacks[var3].writeToNBT(var4);
	                var2.appendTag(var4);
	            }
	        }
	       tag.setTag("Items", var2);
	       
	    }
	 public void rechargeItem()
	 {
		 /*if(this.furnaceItemStacks[0].getItem() instanceof ItemBlock)
		 {
			 
		 }*/
		 if(this.furnaceItemStacks[0]!=null&&this.furnaceItemStacks[0].getItem() instanceof IItemMysticRechargeable&&this.energyLevel>20)
		 {
			 IItemMysticRechargeable item = (IItemMysticRechargeable) furnaceItemStacks[0].getItem();
			 
			 item.Charge(furnaceItemStacks[0]);
			 if(furnaceItemStacks[0].getItemDamage()!=0)
			 {
			 this.energyLevel-=item.rechargeRatePerTick;
			 }
			
		 }
	 }
	 public void dischargeItem()
	 {
		 /*if(this.furnaceItemStacks[0].getItem() instanceof ItemBlock)
		 {
			 
		 }*/
		 if(this.furnaceItemStacks[1]!=null&&this.furnaceItemStacks[1].getItem() instanceof IItemMysticRechargeable&&this.energyLevel<this.maxEnergyLevel)
		 {
			 IItemMysticRechargeable item = (IItemMysticRechargeable) furnaceItemStacks[1].getItem();
			 
			 item.disCharge(furnaceItemStacks[1]);
			 if(furnaceItemStacks[1].getItemDamage()!=11)
			 {
			 this.energyLevel+=item.rechargeRatePerTick;
			 }
			
		 }
	 }
	 public void updateEntity()
	    {
		 if (mod_MysticAdditions.areAnimations&&this.energyLevel<this.maxEnergyLevel)
		 {
			 rotationAngle+=0.05F;
			 if(rotationAngle>=6.28)
				 rotationAngle=0F;
			 
		 }
		 if (!this.worldObj.isRemote)
		 {
			 if (this.isGettingTeleportedPower)
			 {
				 this.getEnergyTeleported();
			 }
			
		 }
		 rechargeItem();
		 dischargeItem();
		
	    }
	 
		@Override
		 public int getSizeInventory()
	    {
	        return this.furnaceItemStacks.length;
	    }
		@Override
		public ItemStack getStackInSlot(int var1) {
			// TODO Auto-generated method stub
			return this.furnaceItemStacks[var1];
		}
		@Override
		public ItemStack decrStackSize(int par1, int par2) {
			 if (this.furnaceItemStacks[par1] != null)
		        {
		            ItemStack var3;

		            if (this.furnaceItemStacks[par1].stackSize <= par2)
		            {
		                var3 = this.furnaceItemStacks[par1];
		                this.furnaceItemStacks[par1] = null;
		                return var3;
		            }
		            else
		            {
		                var3 = this.furnaceItemStacks[par1].splitStack(par2);

		                if (this.furnaceItemStacks[par1].stackSize == 0)
		                {
		                    this.furnaceItemStacks[par1] = null;
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
		public ItemStack getStackInSlotOnClosing(int var1) {
			if (this.furnaceItemStacks[var1] != null)
	        {
	            ItemStack var2 = this.furnaceItemStacks[var1];
	            this.furnaceItemStacks[var1] = null;
	            return var2;
	        }
	        else
	        {
	            return null;
	        }
		}
		@Override
		public void setInventorySlotContents(int var1, ItemStack var2) {
			this.furnaceItemStacks[var1] = var2;

	        if (var2 != null && var2.stackSize > this.getInventoryStackLimit())
	        {
	            var2.stackSize = this.getInventoryStackLimit();
	        }
			
		}
		@Override
		public String getInvName() {
			// TODO Auto-generated method stub
			return "Mystic Generator";
		}
		@Override
		public int getInventoryStackLimit() {
			// TODO Auto-generated method stub
			return 64;
		}
		@Override
		public boolean isUseableByPlayer(EntityPlayer var1) {
			// TODO Auto-generated method stub
			return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
		}
		@Override
		public void openChest() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void closeChest() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean isInvNameLocalized() {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean isStackValidForSlot(int i, ItemStack itemstack) {
			// TODO Auto-generated method stub
			if(i==0||i==1)
				return true;
			else
				return false;
		}

}

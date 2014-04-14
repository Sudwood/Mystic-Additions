package com.sudwood.mysticadditions.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.WorldServer;

import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.MysticEnergy;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeable;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeableArmor;
import com.sudwood.mysticadditions.items.energy.ItemMarkRecallMRK2;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityRecallPortal extends TileEntityMysticEnergy implements IInventory{
	private int[] coords = {42,42,42};
	private int[] connectors = {42,42,42,42,42,42};

	private boolean restrictTravel = false;
	private boolean isFull = false;
	public static int numberDrawing = 0;
	private int[] wireConnectors = {0,0,0,0,0,0};
	private int[] teleportedPowerCoords={0,0,0};
	private boolean isGettingTeleportedPower = false;
	public float rotationAngle =0F;
	public double efficiencyLevel = 4;
	private ItemStack[] inventory = new ItemStack[1];
	public TileEntityRecallPortal(int maxEnergy)
	{
		super(maxEnergy);
	}
	public TileEntityRecallPortal()
	{
		super(32000);
	}
	public boolean canUpdate(){
		   return true;
	   }
	
	public int getMaxEnergy()
	{
		return this.maxEnergyLevel;
	}
	
	public boolean getRestrictTravel()
	{
		return restrictTravel;
	}
	
	public void setRestrictTravel(boolean set)
	{
		restrictTravel = set;
	}
	
	public void readFromNBT(NBTTagCompound tag)
    {
		
        super.readFromNBT(tag);
        efficiencyLevel = tag.getDouble("EfficiencyLevel");
        energyLevel = tag.getInteger("energyLevel");
        connectors = tag.getIntArray("connectors");
        coords = tag.getIntArray("coordinates");
        isFull = tag.getBoolean("isFull");
        this.coords0 = tag.getIntArray("coordinates0");
        this.coords1 = tag.getIntArray("coordinates1");
        this.coords2 = tag.getIntArray("coordinates2");
        this.coords3 = tag.getIntArray("coordinates3");
        this.coords4 = tag.getIntArray("coordinated4");
        this.activeConnections = tag.getIntArray("activeconnections");
        teleportedPowerCoords = tag.getIntArray("teleportedPowerCoords");
        isGettingTeleportedPower = tag.getBoolean("isGettingTeleportedPower");
        numberDrawing = tag.getInteger("numberDrawing");
        restrictTravel = tag.getBoolean("restrictTravel");
        NBTTagList var2 = tag.getTagList("Items");
        this.inventory = new ItemStack[this.getSizeInventory()];

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
	
	  @SideOnly(Side.CLIENT)
		 public int getCookProgressScaled(int par1)
		    {
		        return this.energyLevel * par1 / this.maxEnergyLevel;
		    }

	 public void writeToNBT(NBTTagCompound tag)
	    {
	        super.writeToNBT(tag);
	        tag.setDouble("EfficiencyLevel", efficiencyLevel);
	        tag.setInteger("energyLevel", energyLevel);
	        tag.setIntArray("connectors", connectors);
	        tag.setIntArray("coordinates", coords);
	        tag.setIntArray("coordinates0", coords0);
	        tag.setIntArray("coordinates1", coords1);
	        tag.setIntArray("coordinates2", coords2);
	        tag.setIntArray("coordinates3", coords3);
	        tag.setIntArray("coordinates4", coords4);
	        tag.setIntArray("activeconnections", activeConnections);
	        tag.setBoolean("isFull", isFull);
	        tag.setIntArray("teleportedPowerCoords", teleportedPowerCoords);
	        tag.setBoolean("isGettingTeleportedPower", isGettingTeleportedPower); 
	        tag.setInteger("numberDrawing", numberDrawing);
	        tag.setBoolean("restrictTravel", restrictTravel);
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

	 public void updateEntity()
	    {

		
			 if(!worldObj.isRemote)
				 this.getEnergyTeleported();

		
	    }
	 
	 public void telePlayer(EntityPlayer player)
	 {
		 if(!worldObj.isRemote)
		 {
			 if(inventory[0]!=null)
			 {
				 if(inventory[0].getItem() instanceof ItemMarkRecallMRK2)
				 {
					 NBTTagCompound tag = inventory[0].getTagCompound();
					 int x = tag.getInteger("posX");
					 int y = tag.getInteger("posY");
					 int z = tag.getInteger("posZ");
					 int dimension = tag.getInteger("Dimension");
					 if(x!=0&&y!=0&z!=0 && this.energyLevel > 8000)
					 {
						/* if(restrictTravel && player.username == tag.getString("Creator"))
						 {
							 player.travelToDimension(dimension);
							 player.setPositionAndUpdate(x, y, z);
							 player.fallDistance = 0;
							 this.energyLevel-=8000;
						 }
						 else if(!restrictTravel)
						 {
							 player.travelToDimension(dimension);
							 player.setPositionAndUpdate(x, y, z);
							 player.fallDistance = 0;
							 this.energyLevel-=8000;
						 }
						 else
						 {
							 player.addChatMessage("Restricted Travel is on. Get the Creator of the Mark Recall to change it!");
						 }*/
						 player.travelToDimension(dimension);
						 player.setPositionAndUpdate(x, y+1, z);
						 player.fallDistance = 0;
						 this.energyLevel-=8000;
					 }
					 else
					 {
						 player.addChatMessage("Error! Check energy or coordinates");
					 }
				 }
			 }
			 else
			 {
				 player.addChatMessage("Please Insert a Mark Recall MRK2.");
			 }
			// player.setPositionAndUpdate(x, y, z);
    		// player.fallDistance = 0;
		 }
	 }
	 
	 
		@Override
		 public int getSizeInventory()
	    {
	        return this.inventory.length;
	    }
		@Override
		public ItemStack getStackInSlot(int var1) {
			// TODO Auto-generated method stub
			return this.inventory[var1];
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
		public ItemStack getStackInSlotOnClosing(int var1) {
			if (this.inventory[var1] != null)
	        {
	            ItemStack var2 = this.inventory[var1];
	            this.inventory[var1] = null;
	            return var2;
	        }
	        else
	        {
	            return null;
	        }
		}
		@Override
		public void setInventorySlotContents(int var1, ItemStack var2) {
			this.inventory[var1] = var2;

	        if (var2 != null && var2.stackSize > this.getInventoryStackLimit())
	        {
	            var2.stackSize = this.getInventoryStackLimit();
	        }
			
		}
		@Override
		public String getInvName() {
			// TODO Auto-generated method stub
			return "Recall Portal";
		}
		@Override
		public int getInventoryStackLimit() {
			// TODO Auto-generated method stub
			return 1;
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
		public boolean isItemValidForSlot(int i, ItemStack itemstack) {
			// TODO Auto-generated method stub
			if (i==0||i==1)
				return true;
			else 
				return false;
		}
		
		

}

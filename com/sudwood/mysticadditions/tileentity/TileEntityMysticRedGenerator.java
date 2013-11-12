package com.sudwood.mysticadditions.tileentity;


import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.WorldServer;

import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.MysticEnergy;
import com.sudwood.mysticadditions.blocks.BlockMysticFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityMysticRedGenerator extends TileEntityMysticEnergy implements MysticEnergy, IInventory{
	private int[] coords = {42,42,42};
	private int[] connectors = {42,42,42,42,42,42};
	
	public static int numberDrawing = 0;
	private boolean isFull = false;
	private ItemStack[] furnaceItemStacks = new ItemStack[1];
	private static List<Integer> fuelItems = new ArrayList();
	private static List<Integer> fuelOutput = new ArrayList();
    public int furnaceBurnTime = 0;
    public int currentItemBurnTime = 0;
    public float spinRate = 0.05F;
    public float upDownRate = 0.2F;
    public float spinAngle = 0F;
    public float upDownLocation = 2F;
    private boolean upDown = false;
	public TileEntityMysticRedGenerator(int maxEnergy)
	{
		super(maxEnergy);
	}
	public TileEntityMysticRedGenerator()
	{
		super(4000);
	}
	public boolean canUpdate(){
		   return true;
	   }
	@Override
	public int[] checkConnect(WorldServer worldObj, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}
	public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        energyLevel = tag.getInteger("energyLevel");
        connectors = tag.getIntArray("connectors");
        coords = tag.getIntArray("coordinates");
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
        this.furnaceBurnTime = tag.getShort("BurnTime");
        
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[0]);
        
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
	
	public int getEnergyLevel()
	{
		return energyLevel;
	}
	public void getEnergy()
	{
		
		
		
	}
	public void sendEnergy()
	{
		
	}
	public void generateEnergy() // generates the energy
	{
		if (this.energyLevel<this.maxEnergyLevel)
		{
			if (this.furnaceBurnTime==0)
			{
			this.furnaceBurnTime = this.getItemBurnTime(this.getStackInSlot(0))	;
		//	this.decrStackSize(0, 1);
			
			}
			if (this.furnaceBurnTime>0)
			{
				this.furnaceBurnTime--;
				this.energyLevel++;
			}
		}
	}
	 public void writeToNBT(NBTTagCompound tag)
	    {
	        super.writeToNBT(tag);
	        
	        tag.setInteger("energyLevel", energyLevel);
	        tag.setIntArray("connectors", connectors);
	        tag.setIntArray("coordinates", coords);
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
	        tag.setShort("BurnTime", (short)this.furnaceBurnTime);
	        
	        tag.setTag("Items", var2);
	        
	        
	       
	    }
	  @SideOnly(Side.CLIENT)
	 public int getCookProgressScaled(int par1)
	    {
	        return this.energyLevel * par1 / this.maxEnergyLevel;
	    }
	  @SideOnly(Side.CLIENT)
	 public int getBurnTimeRemainingScaled(int par1)
	    {
	        if (this.currentItemBurnTime == 0)
	        {
	            this.currentItemBurnTime = 100;
	        }

	        return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
	    }
	 public boolean isBurning()
	    {
	        return this.furnaceBurnTime > 0;
	    }
	 private boolean canSmelt()
	    {
		 return (this.energyLevel<this.maxEnergyLevel);
	    }
	 public static void addItemToFuelList(int id, int energyOutput) // custom fuel list - can be called anywhere
	 {
		fuelItems.add(id);
		fuelOutput.add(energyOutput);
	 }
	 
	 public static int getItemBurnTime(ItemStack par0ItemStack) // gets the burn time for the fuel items list
	    {
		 if (par0ItemStack == null)
	        {
	            return 0;
	        }
	        else
	        {
	            int var1 = par0ItemStack.getItem().itemID;
	            Item var2 = par0ItemStack.getItem();

	            if (par0ItemStack.getItem() instanceof ItemBlock && Block.blocksList[var1] != null)
	            {
	                Block var3 = Block.blocksList[var1];
	               int blockId = var3.blockID;
	                for(int i = 0; i<fuelItems.size();i++)
	                {
	                	if (blockId==fuelItems.get(i))
	                	{
	                		return fuelOutput.get(i);
	                	}
	                }
	                
	            }
	            if(par0ItemStack.getItem() instanceof Item)
	            {
	            	int itemId = par0ItemStack.getItem().itemID;
	                for(int i = 0; i<fuelItems.size();i++)
	                {
	                	if (itemId==fuelItems.get(i))
	                	{
	                		return fuelOutput.get(i);
	                	}
	                }
	            }
	            return 0;
	        }
		 
		 
	    }
	 public int getStackSizeInSlot(int slot)
	 {
		 if (this.furnaceItemStacks[slot]!=null)
		 {
			 return this.furnaceItemStacks[slot].stackSize;
		 }
		 else return 42;
	 }
	 public String getStackNameInSlot(int slot)
	 {
		 if (this.furnaceItemStacks[slot]!=null)
		 {
			 return this.furnaceItemStacks[slot].getDisplayName();
		 }
		 else return "blarg";
	 }
	 public void updateEntity() // update method - this is where it all comes together
	    {
		 
		 boolean var1 = this.furnaceBurnTime > 0;
	        boolean var2 = false;  // used to determine if an item was used from the stacks in the inventory
	        if(this.canSmelt()){
	        if (this.furnaceBurnTime > 0) // reduces the remaining burn time of the item
	        {
	            this.furnaceBurnTime-=10;
	        }
	        }
	        if (!this.worldObj.isRemote) // makes sure to only do the logic on the server side
	        {
	            if (this.furnaceBurnTime == 0 && this.canSmelt()) // is called if there is something that can be turned into energy
	            {
	                this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[0]); // sets the burn time to the item in slot 0 ie the bottom slot

	                if (this.furnaceBurnTime > 0)
	                {
	                    var2 = true;

	                    if (this.furnaceItemStacks[0] != null)
	                    {
	                        --this.furnaceItemStacks[0].stackSize;

	                        if (this.furnaceItemStacks[0].stackSize == 0)
	                        {
	                            this.furnaceItemStacks[0] = this.furnaceItemStacks[0].getItem().getContainerItemStack(furnaceItemStacks[0]);
	                        }
	                    }
	                }
	            }

	            if (this.isBurning() && this.canSmelt())
	            {
	                this.energyLevel+=10;

	                
	            }
	            else
	            {
	               
	            }

	            if (var1 != this.furnaceBurnTime > 0)
	            {
	                var2 = true;
	                BlockMysticFurnace.updateFurnaceBlockState(this.furnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord); // this is not particularly needed
	            }
	        }

	        if (var2)
	        {
	            this.onInventoryChanged();
	        }
	        if (MysticAdditions.areAnimations&&this.currentItemBurnTime>0&&this.energyLevel<this.maxEnergyLevel) // this is solely for my animated models - ignore
			 {
			 if (this.upDownLocation<12&&!upDown)
			  {
			  this.upDownLocation+= upDownRate;
			  }
			  
			  if(this.upDownLocation>=12)
			  {
				  upDown=true;
			  }
			  
			  if(this.upDownLocation>2&&upDown)
			  {
				  this.upDownLocation-=upDownRate;
				  
			  }
			  if(this.upDownLocation<=2)
			  {
				  upDown=false;
			  } 
			 this.spinAngle+=0.05F;
			 if(this.spinAngle>=6.28)
			 {
				 this.spinAngle=0;
			 }
			 }
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
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		if (i==0||i==1)
			return true;
		else 
			return false;
	}

}

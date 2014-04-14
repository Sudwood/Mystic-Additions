package com.sudwood.mysticadditions.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.sudwood.mysticadditions.GrinderRecipesMystic;
import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.blocks.MysticModBlocks;
import com.sudwood.mysticadditions.items.MysticModItems;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeable;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeableArmor;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityMysticRedGrinder extends TileEntityMysticEnergy implements ISidedInventory
{
	private int[] coords = {42,42,42};

	 public TileEntityMysticRedGrinder(int maxEnergy)
	 {
		 super(maxEnergy);
	 }
	 public TileEntityMysticRedGrinder()
	 {
		 super(4000);
	 }
	 public float spinAngleX = 0F;
	 public float spinAngleY = 0F;
	 public float spinAngleZ = 0F;
	 private int checkTime = 0;
	 public boolean isFull = false;
	 public double efficiencyLevel = 4;
	 private int[] teleportedPowerCoords={0,0,0};
		private boolean isGettingTeleportedPower = false;
    private ItemStack[] furnaceItemStacks = new ItemStack[3];

   
    public int furnaceCookTime = 0;

    public boolean canUpdate(){
		   return true;
	   }
    public int getSizeInventory()
    {
        return this.furnaceItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.furnaceItemStacks[par1];
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
    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
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

 
	
		
		
    
    
    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.furnaceItemStacks[par1] != null)
        {
            ItemStack var2 = this.furnaceItemStacks[par1];
            this.furnaceItemStacks[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.furnaceItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "Mystic Grinda";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.efficiencyLevel = par1NBTTagCompound.getDouble("EfficiencyLevel");
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];
        energyLevel = par1NBTTagCompound.getInteger("energyLevel");
        coords = par1NBTTagCompound.getIntArray("coordinates");
        this.coords0 = par1NBTTagCompound.getIntArray("coordinates0");
        this.coords1 = par1NBTTagCompound.getIntArray("coordinates1");
        this.coords2 = par1NBTTagCompound.getIntArray("coordinates2");
        this.coords3 = par1NBTTagCompound.getIntArray("coordinates3");
        this.coords4 = par1NBTTagCompound.getIntArray("coordinated4");
        this.activeConnections = par1NBTTagCompound.getIntArray("activeconnections");
        this.checkTime = par1NBTTagCompound.getInteger("checkTime");
        isFull = par1NBTTagCompound.getBoolean("isFull");
        teleportedPowerCoords = par1NBTTagCompound.getIntArray("teleportedPowerCoords");
        isGettingTeleportedPower = par1NBTTagCompound.getBoolean("isGettingTeleportedPower");
        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.furnaceItemStacks.length)
            {
                this.furnaceItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        
        this.furnaceCookTime = par1NBTTagCompound.getShort("CookTime");
        
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("energyLevel", energyLevel);
        par1NBTTagCompound.setIntArray("coordinates", coords);
        par1NBTTagCompound.setBoolean("isFull", isFull);
        par1NBTTagCompound.setDouble("EfficiencyLevel", efficiencyLevel);
        par1NBTTagCompound.setIntArray("coordinates0", coords0);
        par1NBTTagCompound.setIntArray("coordinates1", coords1);
        par1NBTTagCompound.setIntArray("coordinates2", coords2);
        par1NBTTagCompound.setIntArray("coordinates3", coords3);
        par1NBTTagCompound.setIntArray("coordinates4", coords4);
        par1NBTTagCompound.setIntArray("activeconnections", this.activeConnections);
        par1NBTTagCompound.setInteger("checkTime", checkTime);
        par1NBTTagCompound.setIntArray("teleportedPowerCoords", teleportedPowerCoords);
        par1NBTTagCompound.setBoolean("isGettingTeleportedPower", isGettingTeleportedPower);
        par1NBTTagCompound.setShort("CookTime", (short)this.furnaceCookTime);
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

        par1NBTTagCompound.setTag("Items", var2);
    }

    public int getInventoryStackLimit()
    {
        return 64;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled(int par1)
    {
        return this.furnaceCookTime * par1 / 100;
    }
    @Override
    public void checkDischargeable()
	 {
		 if(true)
		 {
			 TileEntity tile0 = worldObj.getBlockTileEntity(this.xCoord, this.yCoord+1,this.zCoord);
			 TileEntity tile1 = worldObj.getBlockTileEntity(this.xCoord, this.yCoord,this.zCoord+1);
			 TileEntity tile2 = worldObj.getBlockTileEntity(this.xCoord-1, this.yCoord,this.zCoord);
			 TileEntity tile3 = worldObj.getBlockTileEntity(this.xCoord, this.yCoord,this.zCoord-1);
			 TileEntity tile4 = worldObj.getBlockTileEntity(this.xCoord+1, this.yCoord,this.zCoord);
			 TileEntity tile5 = worldObj.getBlockTileEntity(this.xCoord, this.yCoord-1,this.zCoord);
			 if(furnaceItemStacks[1]==null)
			 {
				 if(tile0!=null&&tile0 instanceof IInventory)
				 {
					 
					
						int i =0;
						int num = 0;
						boolean didFail = false;
						while(!didFail)
						{
							try
							{
								if(((IInventory) tile0).getStackInSlot(i).getItem() instanceof IItemMysticRechargeable)
								{
									furnaceItemStacks[1]=((IInventory) tile0).getStackInSlot(i);
								}
								
								
							}
							catch(Exception e)
							{
								didFail = true;
								
							}
						}
						
					
					
				 }
			 }
		 }
	 }
    public void dischargeItem()
    {
    	if(this.furnaceItemStacks[1]!=null&&this.furnaceItemStacks[1].getItem() instanceof IItemMysticRechargeable&&this.energyLevel<this.maxEnergyLevel)
		 {
			 IItemMysticRechargeable item = (IItemMysticRechargeable) furnaceItemStacks[1].getItem();
			 
			 item.disCharge(furnaceItemStacks[1]);
			 if(!(item.currentCharge<1+item.rechargeRatePerTick))
			 {
			 this.energyLevel+=item.rechargeRatePerTick;
			 }
			
		 }
    	if(this.furnaceItemStacks[1]!=null&&this.furnaceItemStacks[1].getItem() instanceof IItemMysticRechargeableArmor&&this.energyLevel<this.maxEnergyLevel)
		 {
			 IItemMysticRechargeableArmor item = (IItemMysticRechargeableArmor) furnaceItemStacks[1].getItem();
			 
			 item.disCharge(furnaceItemStacks[1]);
			 if(!(item.currentCharge<1+item.rechargeRatePerTick))
			 {
			 this.energyLevel+=item.rechargeRatePerTick;
			 }
			
		 }
    }
 
    

    /**
     * Returns true if the furnace is currently burning
     */
    public boolean isBurning()
    {
        return (this.furnaceCookTime>0&&this.furnaceCookTime<100);
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
       
        boolean var2 = false;

        
        

        
        	dischargeItem();
        	
            this.getEnergyTeleported();  

            if (this.canSmelt() && this.energyLevel > 4)
            {
                ++this.furnaceCookTime;
                this.energyLevel-=4;
                if (this.furnaceCookTime == 100)
                {
                    this.furnaceCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else if(!this.canSmelt())
            {
                this.furnaceCookTime = 0;
            }

           
        

        if (var2)
        {
            this.onInventoryChanged();
        }
        if(MysticAdditions.areAnimations)
        {
        	this.spinAngleX+=0.1F;
        	this.spinAngleY+=0.1F;
        	this.spinAngleZ+=0.1F;
        	if(this.spinAngleX>=6.28)
        	{
        		this.spinAngleX=0;
        	}
        	if(this.spinAngleY>=6.28)
        	{
        		this.spinAngleY=0;
        	}
        	if(this.spinAngleZ>=6.28)
        	{
        		this.spinAngleZ=0;
        	}
        }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.furnaceItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = GrinderRecipesMystic.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
            if (var1 == null) return false;
            if (this.furnaceItemStacks[2] == null) return true;
            if (!this.furnaceItemStacks[2].isItemEqual(var1)) return false;
            int result = furnaceItemStacks[2].stackSize + var1.stackSize;
            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = GrinderRecipesMystic.smelting().getSmeltingResult(this.furnaceItemStacks[0]);

            if (this.furnaceItemStacks[2] == null)
            {
                this.furnaceItemStacks[2] = var1.copy();
            }
            else if (this.furnaceItemStacks[2].isItemEqual(var1))
            {
                furnaceItemStacks[2].stackSize += var1.stackSize;
            }

            --this.furnaceItemStacks[0].stackSize;

            if (this.furnaceItemStacks[0].stackSize <= 0)
            {
                this.furnaceItemStacks[0] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack par0ItemStack)
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

                if (var3 == Block.blockRedstone)
                {
                    return 14400;
                }
                if (var3 == MysticModBlocks.refinedRedstone)
                {
                    return 15000;
                }
                if (var3 == Block.blockLapis)
                {
                    return 9000;
                }
                
            }
            if (var1 == Item.redstone.itemID) return 800;
            if (var1 == Item.glowstone.itemID) return 1600;
            if (var1 == Item.blazeRod.itemID) return 1200;
            if (var1 == Item.magmaCream.itemID) return 500;
            if (var1 == Item.diamond.itemID) return 1250;
            if (var1 == Item.ingotIron.itemID) return 250;
            if (var1 == Item.ingotGold.itemID) return 500;
            if (var1 == MysticModItems.mysticIngot.itemID) return 50000;
            return GameRegistry.getFuelValue(par0ItemStack);
        }
    }

    /**
     * Return true if item is a fuel source (getItemBurnTime() > 0).
     */
    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openChest() {}

    public void closeChest() {}

   
	public int getEnergyLevel() {
		// TODO Auto-generated method stub
		return this.energyLevel;
	}
	 @SideOnly(Side.CLIENT)
	public int getEnergyScaled(int i) {
		
		return this.energyLevel*i/this.maxEnergyLevel;
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
	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {
		// TODO Auto-generated method stub
		if( var1 == 1)
		{
			int[] temp = {0};
			return temp;
		}
		if( var1 == 0)
		{
			int[] temp = {2};
			return temp;
		}
		if( var1 == 2 || var1 == 3 || var1 == 4)
		{
			int[] temp = {1};
			return temp;
		}
		return null;
	}
	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		if( i == 2 )
			return false;
		if( i == 0 && j == 1)
			return true;
		if( i == 1 && j == 0)
			return true;
		return false;
	}
	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		if( i == 2 )
			return true;
		return false;
	}
}

package com.sudwood.mysticadditions.tileentity;

import java.util.ArrayList;
import java.util.List;

import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeable;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeableArmor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;

public class TileEntityMysticEnergy extends TileEntity{
	protected int[] coord = {0,0,0};
	public int[] coords0 = {0,0,0};
	public int[] coords1 = {0,0,0};
	public int[] coords2 = {0,0,0};
	public int[] coords3 = {0,0,0};
	public int[] coords4 = {0,0,0};
	public int[] buttonStates = new int[6];
	public int[] activeConnections = {0,0,0,0,0};
	protected final int maxEnergyLevel;
	public int energyLevel = 0;
	protected boolean isFull = false;
	public static int numberDrawing = 0;
	protected boolean isGettingTeleportedPower = false;
	protected ItemStack[] furnaceItemStacks = new ItemStack[2];
	public double efficiencyLevel = 4;
	
	
	
	public TileEntityMysticEnergy(int maxEnergy)
	{
		maxEnergyLevel = maxEnergy;
	}
	
	
	
	@Override
	public boolean canUpdate()
	{
		   return true;
	}
	
	/**
	 * 
	 * 
	 * @param int array of x,y,z coordinates of block
	 * @param efficiency level, 1 is 1 to 1 transfers
	 * @return
	 */
	
	public String setTeleportPowerCoords(int[] coords, double efL)
	{
		
		if(Math.abs(Math.abs(coords[0])-Math.abs(xCoord))>20||Math.abs(Math.abs(coords[1])-Math.abs(yCoord))>20||Math.abs(Math.abs(coords[2])-Math.abs(zCoord))>20)
		{
			return "Distance too far, Coordinates not set.";
		}
		else 
		{
		efficiencyLevel = efL;	
		}
		if(activeConnections[0]==0)
		{
			coords0=coords;
			activeConnections[0]=1;
			return "Link Created on Freq 0";
		}
		if(activeConnections[1]==0)
		{
			coords1=coords;
			activeConnections[1]=1;
			return "Link Created on Freq 1";
		}if(activeConnections[2]==0)
		{
			coords2=coords;
			activeConnections[2]=1;
			return "Link Created on Freq 2";
		}if(activeConnections[3]==0)
		{
			coords3=coords;
			activeConnections[3]=1;
			return "Link Created on Freq 3";
		}if(activeConnections[4]==0)
		{
			coords4=coords;
			activeConnections[4]=1;
			return "Link Created on Freq 4";
		}
		else
		{
			return "No Open Frequency";
		}
		
		
	}
	
	public void getEnergyTeleported()
	{
		if(activeConnections.length>0)
		{
		if(activeConnections[0]==1)
		{
			if(energyLevel<maxEnergyLevel-32)
			{
				if(coords0.length>0)
				{
				TileEntity tile = worldObj.getBlockTileEntity(coords0[0], coords0[1], coords0[2]);
				if(tile instanceof TileEntityMysticEnergy)
				{
					if(((TileEntityMysticEnergy) tile).getEnergyLevel()>32)
					{
						TileEntityMysticEnergy tile2 = (TileEntityMysticEnergy) worldObj.getBlockTileEntity(coords0[0], coords0[1], coords0[2]);
						if(tile2!=null)
						{
							tile2.setEnergyLevel(tile2.energyLevel-32);
							setEnergyLevel(energyLevel+32/(efficiencyLevel));
							
						}
					}
				}
				}
			}
		}
		if(activeConnections[1]==1)
		{
			if(energyLevel<maxEnergyLevel-32)
			{
				if(coords1.length>0)
				{
				TileEntity tile = worldObj.getBlockTileEntity(coords1[0], coords1[1], coords1[2]);
				if(tile instanceof TileEntityMysticEnergy)
				{
					if(((TileEntityMysticEnergy) tile).getEnergyLevel()>32)
					{
						
						TileEntityMysticEnergy tile2 = (TileEntityMysticEnergy) worldObj.getBlockTileEntity(coords1[0], coords1[1], coords1[2]);
						if(tile2!=null)
						{
							tile2.setEnergyLevel(tile2.energyLevel-32);
							setEnergyLevel(energyLevel+32/(efficiencyLevel));
						}
					}
				}
				}
			}
		}
		if(activeConnections[2]==1)
		{
			if(energyLevel<maxEnergyLevel-32)
			{
				if(coords2.length>0)
				{
				TileEntity tile = worldObj.getBlockTileEntity(coords2[0], coords2[1], coords2[2]);
				if(tile instanceof TileEntityMysticEnergy)
				{
					if(((TileEntityMysticEnergy) tile).getEnergyLevel()>32)
					{
						TileEntityMysticEnergy tile2 = (TileEntityMysticEnergy) worldObj.getBlockTileEntity(coords2[0], coords2[1], coords2[2]);
						if(tile2!=null)
						{
							tile2.setEnergyLevel(tile2.energyLevel-32);
							setEnergyLevel(energyLevel+32/(efficiencyLevel));
				
						}
					}
				}
				}
			}
		}
		if(activeConnections[3]==1)
		{
			if(energyLevel<maxEnergyLevel-32)
			{
				if(coords3.length>0)
				{
				TileEntity tile = worldObj.getBlockTileEntity(coords3[0], coords3[1], coords3[2]);
				if(tile instanceof TileEntityMysticEnergy)
				{
					if(((TileEntityMysticEnergy) tile).getEnergyLevel()>32)
					{
						TileEntityMysticEnergy tile2 = (TileEntityMysticEnergy) worldObj.getBlockTileEntity(coords3[0], coords3[1], coords3[2]);
						if(tile2!=null)
						{
							tile2.setEnergyLevel(tile2.energyLevel-32);
							setEnergyLevel(energyLevel+32/(efficiencyLevel));
						}
					}
				}
				}
			}
		}
		if(activeConnections[4]==1)
		{
			if(energyLevel<maxEnergyLevel-32)
			{
				if(coords4.length>0)
				{
				TileEntity tile = worldObj.getBlockTileEntity(coords4[0], coords4[1], coords4[2]);
				if(tile instanceof TileEntityMysticEnergy)
				{
					if(((TileEntityMysticEnergy) tile).getEnergyLevel()>32)
					{
						TileEntityMysticEnergy tile2 = (TileEntityMysticEnergy) worldObj.getBlockTileEntity(coords4[0], coords4[1], coords4[2]);
						if(tile2!=null)
						{
							tile2.setEnergyLevel(tile2.energyLevel-32);
							setEnergyLevel(energyLevel+32/(efficiencyLevel));
						}
					}
				}
				}
			}
		}
		
		}
		
	}
	
	
	
	/**
	 * 
	 * @param frequency to be reset
	 * resets frequencies, used by gui config
	 */

	public void resetFrequency(int freq)
	{
		int[] replaced = {0,0,0};
		if(freq == 0)
		{
			
			coords0=replaced;
			activeConnections[0]=0;
		}
		if(freq == 1)
		{
			
			coords1=replaced;
			activeConnections[1]=0;
		}
		if(freq == 2)
		{
		
			coords2=replaced;
			activeConnections[2]=0;
		}
		if(freq == 3)
		{
			
			coords3=replaced;
			activeConnections[3]=0;
		}
		if(freq == 4)
		{
			
			coords4=replaced;
			activeConnections[4]=0;
		}
		
	}
	
	/**
	 * 
	 * @param sets energy level, converts double to int
	 */
	public void setEnergyLevel(double d){
		
		energyLevel = (int) d;
	}
	/**
	 * @return
	 */
	public int getEnergyLevel()
	{
		return energyLevel;
	}
	
	
	/**
	 * charges item in top slot, used in capacitors
	 */
	
	 public void rechargeItem()
	 {
		 /*if(furnaceItemStacks[0].getItem() instanceof ItemBlock)
		 {
			 
		 }*/
		 if(furnaceItemStacks[0]!=null)
		 {
		 if(furnaceItemStacks[0].getItem() instanceof IItemMysticRechargeable&&energyLevel>20)
		 {
			 IItemMysticRechargeable item = (IItemMysticRechargeable) furnaceItemStacks[0].getItem();
			 
			 item.Charge(furnaceItemStacks[0]);
			 if(!(item.currentCharge>item.maxStorage-item.rechargeRatePerTick))
			 {
			 energyLevel-=item.rechargeRatePerTick;
			 }
			return;
		 }
		 if(furnaceItemStacks[0].getItem() instanceof IItemMysticRechargeableArmor&&energyLevel>20)
		 {
			 IItemMysticRechargeableArmor item = (IItemMysticRechargeableArmor) furnaceItemStacks[0].getItem();
			 
			
			 item.Charge(furnaceItemStacks[0]);
			 
			 if(!(item.currentCharge>item.maxStorage-item.rechargeRatePerTick))
			 {
			 energyLevel-=item.rechargeRatePerTick;
			 }
			return;
		 }
		 }
	 }
	 
	 /**
	  * discharges item in bottom slot, used in most energy blocks
	  */
	 
	 public void dischargeItem()
	 {
		 /*if(furnaceItemStacks[0].getItem() instanceof ItemBlock)
		 {
			 
		 }*/
		 if(furnaceItemStacks[1]!=null&&furnaceItemStacks[1].getItem() instanceof IItemMysticRechargeable&&energyLevel<maxEnergyLevel)
		 {
			 IItemMysticRechargeable item = (IItemMysticRechargeable) furnaceItemStacks[1].getItem();
			 
			 item.disCharge(furnaceItemStacks[1]);
			 if(!(item.currentCharge<1+item.rechargeRatePerTick))
			 {
			 energyLevel+=item.rechargeRatePerTick;
			 }
			
		 }
		 if(furnaceItemStacks[1]!=null&&furnaceItemStacks[1].getItem() instanceof IItemMysticRechargeableArmor&&energyLevel<maxEnergyLevel)
		 {
			 IItemMysticRechargeableArmor item = (IItemMysticRechargeableArmor) furnaceItemStacks[1].getItem();
			 
			 item.disCharge(furnaceItemStacks[1]);
			 if(!(item.currentCharge<1+item.rechargeRatePerTick))
			 {
			 energyLevel+=item.rechargeRatePerTick;
			 }
			
		 }
	 }
	 
	 
	 /**
	  * checks nearby inventories for an item that can be discharged and puts it in bottom slot
	  */
	 public void checkDischargeable()
	 {
		 if(true)
		 {
			 TileEntity tile0 = worldObj.getBlockTileEntity(xCoord, yCoord+1,zCoord);
			 TileEntity tile1 = worldObj.getBlockTileEntity(xCoord, yCoord,zCoord+1);
			 TileEntity tile2 = worldObj.getBlockTileEntity(xCoord-1, yCoord,zCoord);
			 TileEntity tile3 = worldObj.getBlockTileEntity(xCoord, yCoord,zCoord-1);
			 TileEntity tile4 = worldObj.getBlockTileEntity(xCoord+1, yCoord,zCoord);
			 TileEntity tile5 = worldObj.getBlockTileEntity(xCoord, yCoord-1,zCoord);
			 if(furnaceItemStacks[1]==null)
			 {
				 if(tile0!=null&&tile0 instanceof TileEntityChest)
				 {
					 
					
						int i =0;
						int num = 0;
						boolean didFail = false;
						while(!didFail)
						{
							try
							{
								((IInventory) tile0).getStackInSlot(i);
								i++;
								num++;
								
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
	 
	 
	 /**
	  * 
	  * @param x of block
	  * @param y of block
	  * @param z of block
	  * @return returns arraylist of empty slots
	  */
	 public List<Integer> checkSpace(int x, int y, int z)
	 {
		 List<Integer> freeSpaces = new ArrayList();
		 try
		 {
		 TileEntity tempTile = worldObj.getBlockTileEntity(x, y, z);
		 
		 if(tempTile!=null&&tempTile instanceof IInventory)
		 {
			 int i =0;
				int num = 0;
				boolean didFail = false;
				while(!didFail)
				{
					try
					{
						((IInventory) tempTile).getStackInSlot(i);
						i++;
						num++;
						
					}
					catch(Exception e)
					{
						didFail = true;
					}
				}
				for(int ix = 0; ix<num; ix++)
				{
					if(((IInventory) tempTile).getStackInSlot(ix)==null)
					{
						freeSpaces.add(ix);
					}
				}
		 }
		 
		 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 
		 return freeSpaces;
		 
		 
	 }
	 
	 /**
	  * 
	  * @param x of block
	  * @param y of block
	  * @param z of block
	  * @param stack itemstack to check for space in
	  * @return arraylist of either empty spaces or spaces that can take the given stack
	  */
	 public List<Integer> checkSpace(int x, int y, int z, ItemStack stack)
	 {
		 List<Integer> freeSpaces = new ArrayList();
		 
		 try
		 {
		 TileEntity tempTile = worldObj.getBlockTileEntity(x, y, z);
		 
		 if(tempTile!=null&&tempTile instanceof IInventory)
		 {
			 int i =0;
				int num = 0;
				boolean didFail = false;
				while(!didFail)
				{
					try
					{
						((IInventory) tempTile).getStackInSlot(i);
						i++;
						num++;
						
					}
					catch(Exception e)
					{
						didFail = true;
					}
				}
				for(int ix = 0; ix<num; ix++)
				{
					if(((IInventory) tempTile).getStackInSlot(ix)==null)
					{
						freeSpaces.add(ix);
					}
					
					else if (((IInventory) tempTile).getStackInSlot(ix).itemID == stack.itemID)
					{
						if(stack.stackSize+((IInventory) tempTile).getStackInSlot(ix).stackSize<stack.getItem().getItemStackLimit())
						{
							freeSpaces.add(ix);
						}
					}
				}
		 }
		 
		 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 
		 return freeSpaces;
	 }
	 
	 
	 
	 public void disConnect()
	 {
		 
	 }



	 @SideOnly(Side.CLIENT)
	 public int getCookProgressScaled(int par1)
	    {
	        return this.energyLevel * par1 / this.maxEnergyLevel;
	    }



	public int getMaxEnergy() {
		// TODO Auto-generated method stub
		return maxEnergyLevel;
	}
	 
	
}

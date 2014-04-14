package com.sudwood.mysticadditions.tileentity;

import java.util.Arrays;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;

import com.sudwood.mysticadditions.MysticAdditions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityLiquidStorage extends TileEntityMysticEnergy implements IFluidHandler, ISidedInventory{

	public final FluidTank tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME *65536);
	
	private ItemStack[] inventory = new ItemStack[this.getSizeInventory()];
	private int[] coords = {42,42,42};
	 public boolean isFull = false;
	 public double efficiencyLevel = 4;
	 private int chargeRate = 32;
	protected int fillRate = 100;
	 private int[] teleportedPowerCoords={0,0,0};
		private boolean isGettingTeleportedPower = false;
		public float spinAngleX = 0F;
		 public float spinAngleY = 0F;
		 public float spinAngleZ = 0F;
		 public int[] lcoords0 = {0,0,0};
		 public int[] lcoords1 = {0,0,0};
		 public int[] lcoords2 = {0,0,0};
		 public int[] lcoords3 = {0,0,0};
		 public int[] lcoords4 = {0,0,0};
		 public int[] activeConnectionsL = {0,0,0,0,0}; // liquid connections
	 public TileEntityLiquidStorage(int maxEnergy)
	 {
		 super(maxEnergy);
	 }
	 public TileEntityLiquidStorage()
	 {
		 super(64000);
	 }
	 public boolean canUpdate(){
		   return true;
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
		
		 @SideOnly(Side.CLIENT)
		 public int getCookProgressScaled(int par1)
		 {
		        return this.energyLevel * par1 / this.maxEnergyLevel;
		 }
		 
		 @SideOnly(Side.CLIENT)
		 public double getLiquidAmountScaled()
		 {
		        return this.tank.getFluidAmount() / this.tank.getCapacity();
		 }
		 
		 public ItemStack getEmptyContainer(ItemStack filledContainer)
		 {
			 FluidContainerData[] data = FluidContainerRegistry.getRegisteredFluidContainerData();
				for(int i = 0; i < data.length; i++)
				{
					if(data[i].filledContainer.itemID == filledContainer.itemID && data[i].filledContainer.getItemDamage() == filledContainer.getItemDamage())
					{
						return data[i].emptyContainer;
					}
				}
				return null;
		 }
		 
		public void updateEntity()
	    {
			if(this.energyLevel > 0 && this.energyLevel - this.getEnergyUseRate() > 0)
				this.energyLevel -= this.getEnergyUseRate();
			if(this.energyLevel > 0 && this.energyLevel - this.getEnergyUseRate() > 0 )
			{
				if(FluidContainerRegistry.isBucket(inventory[0]))
				{
					
					FluidStack tempFluid = FluidContainerRegistry.getFluidForFilledItem(inventory[0]);
					if(tempFluid != null)
					{
						if(tank.getFluidAmount() == 0)
						{
							tank.fill(tempFluid, true);
							this.decrStackSize(0, 1);
							if(!worldObj.isRemote)
								worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord , zCoord , new ItemStack(Item.bucketEmpty, 1)));
						}
						else
						{
							if(tempFluid.isFluidEqual(tank.getFluid()))
							{
								tank.fill(tempFluid, true);
								this.decrStackSize(0, 1);
								if(!worldObj.isRemote)
									worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord , zCoord , new ItemStack(Item.bucketEmpty, 1)));
							}
						}
					}
					
				}
				
				
				
				if(FluidContainerRegistry.isFilledContainer(inventory[0]))
				{
					FluidStack tempFluid = FluidContainerRegistry.getFluidForFilledItem(inventory[0]);
					if(tempFluid != null)
					{
						if(tank.getFluidAmount() == 0)
						{
							tank.fill(tempFluid, true);
							if(!worldObj.isRemote)
								worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord , zCoord , this.getEmptyContainer(inventory[0])));
							this.decrStackSize(0, 1);
							
						}
						else
						{
							if(tempFluid.isFluidEqual(tank.getFluid()))
							{
								tank.fill(tempFluid, true);
								if(!worldObj.isRemote)
									worldObj.spawnEntityInWorld(new EntityItem(worldObj, xCoord, yCoord , zCoord , this.getEmptyContainer(inventory[0])));
								this.decrStackSize(0, 1);
							}
						}
					}
				}
				
				
				if(worldObj.getBlockId(xCoord, yCoord-1, zCoord) == Block.waterStill.blockID)
				{
					if(tank.getFluidAmount() == 0)
					{
						
						tank.fill(new FluidStack(FluidRegistry.WATER, 1000), true);
						worldObj.setBlock(xCoord, yCoord-1, zCoord, 0);
					}
					else if(tank.getFluid().isFluidEqual(new FluidStack(FluidRegistry.WATER, 1000)))
					{
					
						tank.fill(new FluidStack(FluidRegistry.WATER, 1000), true);
						worldObj.setBlock(xCoord, yCoord-1, zCoord, 0);
					}
				}
			}
			if(!worldObj.isRemote)
				 this.getEnergyTeleported();
					
			
			
			
			
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
		
		public void getEnergyTeleported()
		{
			if(activeConnections.length>0 && !worldObj.isRemote)
			{
				if(activeConnections[0] == 0 && activeConnections[1] == 0 && activeConnections[2] == 0 && activeConnections[3] == 0 && activeConnections[4] == 0)
					return;
			if(activeConnections[0]==1)
			{
				if(energyLevel<maxEnergyLevel-chargeRate)
				{
					if(coords0.length>0)
					{
					TileEntity tile = worldObj.getBlockTileEntity(coords0[0], coords0[1], coords0[2]);
					if(tile instanceof TileEntityMysticEnergy)
					{
						if(((TileEntityMysticEnergy) tile).getEnergyLevel()>chargeRate)
						{
							TileEntityMysticEnergy tile2 = (TileEntityMysticEnergy) worldObj.getBlockTileEntity(coords0[0], coords0[1], coords0[2]);
							if(tile2!=null)
							{
								tile2.setEnergyLevel(tile2.energyLevel-chargeRate);
								setEnergyLevel(energyLevel+chargeRate/(efficiencyLevel));
								
							}
						}
					}
					}
				}
			}
			if(activeConnections[1]==1)
			{
				if(energyLevel<maxEnergyLevel-chargeRate)
				{
					if(coords1.length>0)
					{
					TileEntity tile = worldObj.getBlockTileEntity(coords1[0], coords1[1], coords1[2]);
					if(tile instanceof TileEntityMysticEnergy)
					{
						if(((TileEntityMysticEnergy) tile).getEnergyLevel()>chargeRate)
						{
							
							TileEntityMysticEnergy tile2 = (TileEntityMysticEnergy) worldObj.getBlockTileEntity(coords1[0], coords1[1], coords1[2]);
							if(tile2!=null)
							{
								tile2.setEnergyLevel(tile2.energyLevel-chargeRate);
								setEnergyLevel(energyLevel+chargeRate/(efficiencyLevel));
							}
						}
					}
					}
				}
			}
			if(activeConnections[2]==1)
			{
				if(energyLevel<maxEnergyLevel-chargeRate)
				{
					if(coords2.length>0)
					{
					TileEntity tile = worldObj.getBlockTileEntity(coords2[0], coords2[1], coords2[2]);
					if(tile instanceof TileEntityMysticEnergy)
					{
						if(((TileEntityMysticEnergy) tile).getEnergyLevel()>chargeRate)
						{
							TileEntityMysticEnergy tile2 = (TileEntityMysticEnergy) worldObj.getBlockTileEntity(coords2[0], coords2[1], coords2[2]);
							if(tile2!=null)
							{
								tile2.setEnergyLevel(tile2.energyLevel-chargeRate);
								setEnergyLevel(energyLevel+chargeRate/(efficiencyLevel));
					
							}
						}
					}
					}
				}
			}
			if(activeConnections[3]==1)
			{
				if(energyLevel<maxEnergyLevel-chargeRate)
				{
					if(coords3.length>0)
					{
					TileEntity tile = worldObj.getBlockTileEntity(coords3[0], coords3[1], coords3[2]);
					if(tile instanceof TileEntityMysticEnergy)
					{
						if(((TileEntityMysticEnergy) tile).getEnergyLevel()>chargeRate)
						{
							TileEntityMysticEnergy tile2 = (TileEntityMysticEnergy) worldObj.getBlockTileEntity(coords3[0], coords3[1], coords3[2]);
							if(tile2!=null)
							{
								tile2.setEnergyLevel(tile2.energyLevel-chargeRate);
								setEnergyLevel(energyLevel+chargeRate/(efficiencyLevel));
							}
						}
					}
					}
				}
			}
			if(activeConnections[4]==1)
			{
				if(energyLevel<maxEnergyLevel-chargeRate)
				{
					if(coords4.length>0)
					{
					TileEntity tile = worldObj.getBlockTileEntity(coords4[0], coords4[1], coords4[2]);
					if(tile instanceof TileEntityMysticEnergy)
					{
						if(((TileEntityMysticEnergy) tile).getEnergyLevel()>chargeRate)
						{
							TileEntityMysticEnergy tile2 = (TileEntityMysticEnergy) worldObj.getBlockTileEntity(coords4[0], coords4[1], coords4[2]);
							if(tile2!=null)
							{
								tile2.setEnergyLevel(tile2.energyLevel-chargeRate);
								setEnergyLevel(energyLevel+chargeRate/(efficiencyLevel));
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
		 * 
		 * @param int array of x,y,z coordinates of block
		 *
		 * @return
		 */
		
		public String setTeleportLiquidCoords(int[] coords)
		{
			
			if(Math.abs(Math.abs(coords[0])-Math.abs(xCoord))>20||Math.abs(Math.abs(coords[1])-Math.abs(yCoord))>20||Math.abs(Math.abs(coords[2])-Math.abs(zCoord))>20)
			{
				return "Distance too far, Coordinates not set.";
			}
			
			if(activeConnectionsL[0]==0)
			{
				lcoords0=coords;
				activeConnectionsL[0]=1;
				return "Link Created on Freq 0";
			}
			if(activeConnectionsL[1]==0)
			{
				lcoords1=coords;
				activeConnectionsL[1]=1;
				return "Link Created on Freq 1";
			}if(activeConnectionsL[2]==0)
			{
				lcoords2=coords;
				activeConnectionsL[2]=1;
				return "Link Created on Freq 2";
			}if(activeConnectionsL[3]==0)
			{
				lcoords3=coords;
				activeConnectionsL[3]=1;
				return "Link Created on Freq 3";
			}if(activeConnectionsL[4]==0)
			{
				lcoords4=coords;
				activeConnectionsL[4]=1;
				return "Link Created on Freq 4";
			}
			else
			{
				return "No Open Frequency";
			}
			
			
		}
		
		/**
		 * @param Whitelisted Fluid - only able to allow all or one liquid
		 * Gets Liquid from the connected active connections 
		 * 
		 */
		public void getLiquidTeleported(FluidStack fluid)
		{
			if(activeConnectionsL.length>0 && !worldObj.isRemote)
			{
				if(activeConnectionsL[0] == 0 && activeConnectionsL[1] == 0 && activeConnectionsL[2] == 0 && activeConnectionsL[3] == 0 && activeConnectionsL[4] == 0)
					return;
			if(activeConnectionsL[0]==1)
			{
				if(tank.getFluidAmount() < tank.getCapacity() + fillRate)
				{
					if(lcoords0.length>0)
					{
					TileEntity tile = worldObj.getBlockTileEntity(lcoords0[0], lcoords0[1], lcoords0[2]);
					if(tile instanceof TileEntityLiquidStorage)
					{
						if(tank.getFluidAmount() > 0)
						{
							if(fluid == null)
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluid().isFluidEqual(tank.getFluid())&&((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords0[0], lcoords0[1], lcoords0[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
							else
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluid().isFluidEqual(fluid)&&((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords0[0], lcoords0[1], lcoords0[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(fluid.fluidID), fillRate), true);
										
									}
								}
							}
						}
						else
						{
							if(fluid == null)
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords0[0], lcoords0[1], lcoords0[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tile2.tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
							else
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords0[0], lcoords0[1], lcoords0[2]);
									if(tile2!=null && tile2.tank.getFluid().isFluidEqual(fluid))
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tile2.tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
						}
					}
						
					}
				}
			}
			if(activeConnectionsL[1]==1)
			{
				if(tank.getFluidAmount() < tank.getCapacity() + fillRate)
				{
					if(lcoords1.length>0)
					{
					TileEntity tile = worldObj.getBlockTileEntity(lcoords1[0], lcoords1[1], lcoords1[2]);
					if(tile instanceof TileEntityLiquidStorage)
					{
						if(tank.getFluidAmount() > 0)
						{
							if(fluid == null)
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluid().isFluidEqual(tank.getFluid())&&((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords1[0], lcoords1[1], lcoords1[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
							else
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluid().isFluidEqual(fluid)&&((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords1[0], lcoords1[1], lcoords1[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(fluid.fluidID), fillRate), true);
										
									}
								}
							}
						}
						else
						{
							if(fluid == null)
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords1[0], lcoords1[1], lcoords1[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tile2.tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
							else
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords1[0], lcoords1[1], lcoords1[2]);
									if(tile2!=null && tile2.tank.getFluid().isFluidEqual(fluid))
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tile2.tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
						}
					}
						
					}
				}
				
			}
			if(activeConnectionsL[2]==1)
			{
				if(tank.getFluidAmount() < tank.getCapacity() + fillRate)
				{
					if(lcoords2.length>0)
					{
					TileEntity tile = worldObj.getBlockTileEntity(lcoords2[0], lcoords2[1], lcoords2[2]);
					if(tile instanceof TileEntityLiquidStorage)
					{
						if(tank.getFluidAmount() > 0)
						{
							if(fluid == null)
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluid().isFluidEqual(tank.getFluid())&&((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords2[0], lcoords2[1], lcoords2[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
							else
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluid().isFluidEqual(fluid)&&((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords2[0], lcoords2[1], lcoords2[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(fluid.fluidID), fillRate), true);
										
									}
								}
							}
						}
						else
						{
							if(fluid == null)
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords2[0], lcoords2[1], lcoords2[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tile2.tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
							else
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords2[0], lcoords2[1], lcoords2[2]);
									if(tile2!=null && tile2.tank.getFluid().isFluidEqual(fluid))
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tile2.tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
						}
					}
						
					}
				}
			}
			if(activeConnectionsL[3]==1)
			{
				if(tank.getFluidAmount() < tank.getCapacity() + fillRate)
				{
					if(lcoords3.length>0)
					{
					TileEntity tile = worldObj.getBlockTileEntity(lcoords3[0], lcoords3[1], lcoords3[2]);
					if(tile instanceof TileEntityLiquidStorage)
					{
						if(tank.getFluidAmount() > 0)
						{
							if(fluid == null)
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluid().isFluidEqual(tank.getFluid())&&((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords3[0], lcoords3[1], lcoords3[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
							else
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluid().isFluidEqual(fluid)&&((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords3[0], lcoords3[1], lcoords3[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(fluid.fluidID), fillRate), true);
										
									}
								}
							}
						}
						else
						{
							if(fluid == null)
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords3[0], lcoords3[1], lcoords3[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tile2.tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
							else
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords3[0], lcoords3[1], lcoords3[2]);
									if(tile2!=null && tile2.tank.getFluid().isFluidEqual(fluid))
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tile2.tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
						}
					}
						
					}
				}
			}
			if(activeConnectionsL[4]==1)
			{
				if(tank.getFluidAmount() < tank.getCapacity() + fillRate)
				{
					if(lcoords4.length>0)
					{
					TileEntity tile = worldObj.getBlockTileEntity(lcoords4[0], lcoords4[1], lcoords4[2]);
					if(tile instanceof TileEntityLiquidStorage)
					{
						if(tank.getFluidAmount() > 0)
						{
							if(fluid == null)
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluid().isFluidEqual(tank.getFluid())&&((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords4[0], lcoords4[1], lcoords4[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
							else
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluid().isFluidEqual(fluid)&&((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords4[0], lcoords4[1], lcoords4[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(fluid.fluidID), fillRate), true);
										
									}
								}
							}
						}
						else
						{
							if(fluid == null)
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords4[0], lcoords4[1], lcoords4[2]);
									if(tile2!=null)
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tile2.tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
							else
							{
								if(((TileEntityLiquidStorage) tile).tank.getFluidAmount()>chargeRate)
								{
									TileEntityLiquidStorage tile2 = (TileEntityLiquidStorage) worldObj.getBlockTileEntity(lcoords4[0], lcoords4[1], lcoords4[2]);
									if(tile2!=null && tile2.tank.getFluid().isFluidEqual(fluid))
									{
										tile2.tank.drain(fillRate, true);
										tank.fill(new FluidStack(FluidRegistry.getFluid(tile2.tank.getFluid().fluidID), fillRate), true);
										
									}
								}
							}
						}
					}
						
					}
				}
			}
			
			}
			
		}
		
	@Override
	public void readFromNBT(NBTTagCompound data) {
		super.readFromNBT(data);
		this.efficiencyLevel = data.getDouble("EfficiencyLevel");
        NBTTagList var2 = data.getTagList("Items");
       
        energyLevel = data.getInteger("energyLevel");
        coords = data.getIntArray("coordinates");
        this.coords0 = data.getIntArray("coordinates0");
        this.coords1 = data.getIntArray("coordinates1");
        this.coords2 = data.getIntArray("coordinates2");
        this.coords3 = data.getIntArray("coordinates3");
        this.coords4 = data.getIntArray("coordinated4");
        this.activeConnections = data.getIntArray("activeconnections");
        
        this.lcoords0 = data.getIntArray("lcoordinates0");
        this.lcoords1 = data.getIntArray("lcoordinates1");
        this.lcoords2 = data.getIntArray("lcoordinates2");
        this.lcoords3 = data.getIntArray("lcoordinates3");
        this.lcoords4 = data.getIntArray("lcoordinated4");
        this.activeConnectionsL = data.getIntArray("activeConnectionsL");
        
        isFull = data.getBoolean("isFull");
        teleportedPowerCoords = data.getIntArray("teleportedPowerCoords");
        isGettingTeleportedPower = data.getBoolean("isGettingTeleportedPower");
		tank.readFromNBT(data);
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

	
	/**
	 * 
	 * @param frequency to be reset
	 * resets frequencies, used by Fluid gui config
	 */

	public void resetFluidFrequency(int freq)
	{
		int[] replaced = {0,0,0};
		if(freq == 0)
		{
			
			lcoords0=replaced;
			activeConnections[0]=0;
		}
		if(freq == 1)
		{
			
			lcoords1=replaced;
			activeConnections[1]=0;
		}
		if(freq == 2)
		{
		
			lcoords2=replaced;
			activeConnections[2]=0;
		}
		if(freq == 3)
		{
			
			lcoords3=replaced;
			activeConnections[3]=0;
		}
		if(freq == 4)
		{
			
			lcoords4=replaced;
			activeConnections[4]=0;
		}
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound data) {
		super.writeToNBT(data);
		
		 	data.setInteger("energyLevel", energyLevel);
	        data.setIntArray("coordinates", coords);
	        data.setBoolean("isFull", isFull);
	        data.setDouble("EfficiencyLevel", efficiencyLevel);
	        data.setIntArray("coordinates0", coords0);
	        data.setIntArray("coordinates1", coords1);
	        data.setIntArray("coordinates2", coords2);
	        data.setIntArray("coordinates3", coords3);
	        data.setIntArray("coordinates4", coords4);
	        data.setIntArray("activeconnections", this.activeConnections);
	       
	        data.setIntArray("lcoordinates0", lcoords0);
	        data.setIntArray("lcoordinates1", lcoords1);
	        data.setIntArray("lcoordinates2", lcoords2);
	        data.setIntArray("lcoordinates3", lcoords3);
	        data.setIntArray("lcoordinates4", lcoords4);
	        data.setIntArray("activeConnectionsL", this.activeConnectionsL);
	        
	        data.setIntArray("teleportedPowerCoords", teleportedPowerCoords);
	        data.setBoolean("isGettingTeleportedPower", isGettingTeleportedPower);
			tank.writeToNBT(data);
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
	       data.setTag("Items", var2);
	}
	
	public int getEnergyUseRate()
	{
		int rate = 1 + tank.getFluidAmount() / (tank.getCapacity() / (chargeRate * 5)); // amount devided by capacity devided by the max power input
		if(rate > 160)
			rate = 160; 
		return rate;
	}
	
	@Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill)
    {
        return tank.fill(resource, doFill);
    }

    @Override
    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain)
    {
        if (resource == null || !resource.isFluidEqual(tank.getFluid()))
        {
            return null;
        }
        return tank.drain(resource.amount, doDrain);
    }

    @Override
    public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain)
    {
        return tank.drain(maxDrain, doDrain);
    }

    @Override
    public boolean canFill(ForgeDirection from, Fluid fluid)
    {
    	if(this.energyLevel - this.getEnergyUseRate() > 0)
    		return true;
    	else
    		return false;
    }

    @Override
    public boolean canDrain(ForgeDirection from, Fluid fluid)
    {
    	if(this.energyLevel - this.getEnergyUseRate() > 0)
    		return true;
    	else
    		return false;
    }

    @Override
    public FluidTankInfo[] getTankInfo(ForgeDirection from)
    {
        return new FluidTankInfo[] { tank.getInfo() };
    }
	@Override
	public int getSizeInventory() {
		// TODO Auto-generated method stub
		return 2;
	}
	@Override
	public ItemStack getStackInSlot(int i) {
		// TODO Auto-generated method stub
		return inventory[i];
	}
	@Override
	public ItemStack decrStackSize(int i, int j) {
		// TODO Auto-generated method stub
		if (this.inventory[i] != null)
        {
            ItemStack var3;

            if (this.inventory[i].stackSize <= j)
            {
                var3 = this.inventory[i];
                this.inventory[i] = null;
                return var3;
            }
            else
            {
                var3 = this.inventory[i].splitStack(j);

                if (this.inventory[i].stackSize == 0)
                {
                    this.inventory[i] = null;
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
	public ItemStack getStackInSlotOnClosing(int i) {
		// TODO Auto-generated method stub
		if (this.inventory[i] != null)
        {
            ItemStack var2 = this.inventory[i];
            this.inventory[i] = null;
            return var2;
        }
        else
        {
            return null;
        }
	}
	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		this.inventory[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
        {
            itemstack.stackSize = this.getInventoryStackLimit();
        }
	}
	@Override
	public String getInvName() {
		// TODO Auto-generated method stub
		return "Liquid Rift";
	}
	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int getInventoryStackLimit() {
		// TODO Auto-generated method stub
		return 64;
	}
	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		// TODO Auto-generated method stub
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
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
		if((i == 0 && j == 1) || (i == 1 && j == 0))
			return true;
		else
			return false;
	}
	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		// TODO Auto-generated method stub
		if((i == 0 && j == 1) || (i == 1 && j == 0))
			return true;
		else
			return false;
	}
	
	

}

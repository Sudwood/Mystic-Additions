package com.sudwood.mysticadditions.tileentity;

import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySpawnerBlock extends TileEntityMysticEnergy
{
	private boolean isFull = false;
	public static int numberDrawing = 0;
	private int[] wireConnectors = {0,0,0,0,0,0};
	private int[] teleportedPowerCoords={0,0,0};
	private boolean isGettingTeleportedPower = false;
	public float rotationAngle =0F;
	public double efficiencyLevel = 4;
	private int coolDownTime = 0;
	private boolean isGettingPowered = false;
	
	public TileEntitySpawnerBlock(int maxEnergy)
	{
		super(maxEnergy);
	}
	
	public void setIsGettingPowered(boolean bool)
	{
		this.isGettingPowered = bool;
	}
	
	public TileEntitySpawnerBlock()
	{
		super(524288);
	}
	
	@Override
	public boolean canUpdate()
	{
		   return true;
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
        teleportedPowerCoords = tag.getIntArray("teleportedPowerCoords");
        isGettingTeleportedPower = tag.getBoolean("isGettingTeleportedPower");
        numberDrawing = tag.getInteger("numberDrawing");
        coolDownTime = tag.getInteger("coolDownTime");
        isGettingPowered = tag.getBoolean("isGettingPowered");
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
        tag.setIntArray("teleportedPowerCoords", teleportedPowerCoords);
        tag.setBoolean("isGettingTeleportedPower", isGettingTeleportedPower);
        tag.setInteger("numberDrawing", numberDrawing);
        tag.setInteger("coolDownTime", coolDownTime);
        tag.setBoolean("isGettingPowered", isGettingPowered);
       
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
	
	public void setIsGettingTeleportedPower(boolean bool)
	{
		isGettingTeleportedPower = bool;
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
	public void updateEntity()
    {
		if(!worldObj.isRemote)
			 this.getEnergyTeleported();
		coolDownTime--;
		if(this.coolDownTime <= 0 && this.energyLevel> 640)
		{
			if(!worldObj.isRemote&&!this.isGettingPowered)
			{
			EntityPigZombie entity = new EntityPigZombie(worldObj);
			entity.setPosition(this.xCoord, this.yCoord, this.zCoord-2);
			worldObj.spawnEntityInWorld(entity);
			
			EntityPigZombie entity2 = new EntityPigZombie(worldObj);
			entity2.setPosition(this.xCoord, this.yCoord, this.zCoord+2);
			worldObj.spawnEntityInWorld(entity2);
			
			EntityPigZombie entity3 = new EntityPigZombie(worldObj);
			entity3.setPosition(this.xCoord-2, this.yCoord, this.zCoord);
			worldObj.spawnEntityInWorld(entity3);
			
			EntityPigZombie entity4 = new EntityPigZombie(worldObj);
			entity4.setPosition(this.xCoord+2, this.yCoord, this.zCoord);
			worldObj.spawnEntityInWorld(entity4);
			
			this.energyLevel -= 640;
			}
			this.coolDownTime = 40;
		}
		
    
    }
}

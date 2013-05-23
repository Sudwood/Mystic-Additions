package com.sudwood.mysticadditions.tileentity;

import com.sudwood.mysticadditions.MysticAdditions;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.liquids.ILiquidTank;
import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidContainerRegistry;
import net.minecraftforge.liquids.LiquidStack;
import net.minecraftforge.liquids.LiquidTank;

public class TileEntityLiquidStorage extends TileEntityMysticEnergy implements ITankContainer{

	public final LiquidTank tank = new LiquidTank(LiquidContainerRegistry.BUCKET_VOLUME *65536);
	
	
	private int[] coords = {42,42,42};
	 public boolean isFull = false;
	 public double efficiencyLevel = 4;
	 private int[] teleportedPowerCoords={0,0,0};
		private boolean isGettingTeleportedPower = false;
		public float spinAngleX = 0F;
		 public float spinAngleY = 0F;
		 public float spinAngleZ = 0F;
	 public TileEntityLiquidStorage(int maxEnergy)
	 {
		 super(maxEnergy);
	 }
	 public TileEntityLiquidStorage()
	 {
		 super(4000);
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
		
		
		public void updateEntity()
	    {
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
        
        isFull = data.getBoolean("isFull");
        teleportedPowerCoords = data.getIntArray("teleportedPowerCoords");
        isGettingTeleportedPower = data.getBoolean("isGettingTeleportedPower");
		if (data.hasKey("stored") && data.hasKey("liquidId")) {
			LiquidStack liquid = new LiquidStack(data.getInteger("liquidId"), data.getInteger("stored"), 0);
			tank.setLiquid(liquid);
		} else {
			LiquidStack liquid = LiquidStack.loadLiquidStackFromNBT(data.getCompoundTag("tank"));
			if (liquid != null) {
				tank.setLiquid(liquid);
			}
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
	       
	        data.setIntArray("teleportedPowerCoords", teleportedPowerCoords);
	        data.setBoolean("isGettingTeleportedPower", isGettingTeleportedPower);
		
		if (tank.containsValidLiquid()) {
			data.setTag("tank", tank.getLiquid().writeToNBT(new NBTTagCompound()));
		}
	}
	
	
	@Override
	public int fill(ForgeDirection from, LiquidStack resource, boolean doFill) {
		
		return fill(0, resource, doFill);
	}

	@Override
	public int fill(int tankIndex, LiquidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LiquidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		
		return drain(0, maxDrain, doDrain);
	}

	@Override
	public LiquidStack drain(int tankIndex, int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ILiquidTank[] getTanks(ForgeDirection direction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ILiquidTank getTank(ForgeDirection direction, LiquidStack type) {
		// TODO Auto-generated method stub
		return null;
	}

}

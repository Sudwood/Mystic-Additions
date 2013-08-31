package com.sudwood.mysticadditions.tileentity;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

import com.sudwood.mysticadditions.MysticAdditions;

public class TileEntityLiquidStorage extends TileEntityMysticEnergy implements IFluidTank{

	public final FluidTank tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME *65536);
	
	
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
			
			if(worldObj.getBlockId(this.xCoord, this.yCoord-1, this.zCoord)==Block.waterStill.blockID)
			{
				tank.fill(new FluidStack(FluidRegistry.WATER, 1000), true);
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
			FluidStack liquid = new FluidStack(data.getInteger("liquidId"), data.getInteger("stored"));
			tank.setFluid(liquid);
		} else {
			FluidStack liquid = FluidStack.loadFluidStackFromNBT(data.getCompoundTag("tank"));
			if (liquid != null) {
				tank.setFluid(liquid);
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
	        
			data.setTag("tank", tank.getFluid().writeToNBT(new NBTTagCompound()));
		
	}
	@Override
	public FluidStack getFluid() {
		// TODO Auto-generated method stub
		return tank.getFluid();
	}
	@Override
	public int getFluidAmount() {
		// TODO Auto-generated method stub
		return tank.getFluidAmount();
	}
	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return tank.getCapacity();
	}
	@Override
	public FluidTankInfo getInfo() {
		// TODO Auto-generated method stub
		return tank.getInfo();
	}
	@Override
	public int fill(FluidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		
		return tank.fill(resource, doFill);
	}
	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		return tank.drain(maxDrain, doDrain);
	}
	
	

}

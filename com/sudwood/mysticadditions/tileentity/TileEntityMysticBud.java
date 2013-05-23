 package com.sudwood.mysticadditions.tileentity;
 
 import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityMysticBud extends TileEntity {

	int BlockID =0;
	int BlockMeta=0;
	boolean EmittingPower = false;
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
       BlockID = par1NBTTagCompound.getInteger("BlockID");
       BlockMeta = par1NBTTagCompound.getInteger("BlockMeta");
       EmittingPower = par1NBTTagCompound.getBoolean("EmittingPower");
       
    }
	 public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	    {
	        super.writeToNBT(par1NBTTagCompound);
	        par1NBTTagCompound.setInteger("BlockID", BlockID);
	        par1NBTTagCompound.setInteger("BlockMeta", BlockMeta);
	        par1NBTTagCompound.setBoolean("EmittingPower", EmittingPower);
	       
	    }
	 
	
	 public int getBlockID()
	 {
		 return BlockID;
	 }
	 public boolean getPower(){
		 return EmittingPower;
		 
	 }
	 
	 public void setPower(boolean yes){
		 EmittingPower = yes;
		 
	 }
	 
	 public void setBlockID(int id)
	 {
		 BlockID = id;
	 }
	 public int getBlockMeta()
	 {
		 return BlockMeta;
	 }
	 public void setBlockMeta(int id)
	 {
		 BlockMeta = id;
	 }
	
	
	
	
	
	
	
}

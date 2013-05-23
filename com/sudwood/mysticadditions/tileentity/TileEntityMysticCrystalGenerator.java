package com.sudwood.mysticadditions.tileentity;


import java.util.ArrayList;
import java.util.List;

import com.sudwood.mysticadditions.MysticEnergy;
import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.blocks.BlockMysticFurnace;
import com.sudwood.mysticadditions.blocks.MysticModBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;

import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeDirection;


public class TileEntityMysticCrystalGenerator extends TileEntityMysticEnergy implements MysticEnergy{
	private int[] coords = {42,42,42};
	private int[] connectors = {42,42,42,42,42,42};


	public static int numberDrawing = 0;
	private boolean isFull = false;
	
	private static List<Integer> fuelItems = new ArrayList();
	private static List<Integer> fuelOutput = new ArrayList();
	private int[] iMB = new int[260];
	private int energyMultiplier;
    private boolean isMulti = false;
    private boolean isMulti2 = false;
    private boolean isMulti3 = false;
    private boolean isMulti4 = false;
    private int cooldownTime = 0;
    public float upDownLocation = 2F;
    private boolean upDown = false;
	public TileEntityMysticCrystalGenerator(int maxEnergy)
	{
		super(maxEnergy);
	}
	public TileEntityMysticCrystalGenerator()
	{
		super(8000);
	}
	public boolean canUpdate(){
		   return true;
	   }
	@Override
	public int[] checkConnect(WorldServer worldObj, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public int getEnergyMultiplier()
	{
		return energyMultiplier;
	}
	
	
	public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        this.energyLevel = tag.getInteger("energyLevel");
        this.connectors = tag.getIntArray("connectors");
        this.coords = tag.getIntArray("coordinates");
        this.numberDrawing = tag.getInteger("numberDrawing");
        this.isMulti = tag.getBoolean("isMulti");
        this.isMulti2 = tag.getBoolean("isMulti2");
        this.isMulti3 = tag.getBoolean("isMulti3");
        this.isMulti4 = tag.getBoolean("isMulti4");
        NBTTagList var2 = tag.getTagList("Items");
        this.iMB = tag.getIntArray("iMB");
        this.energyMultiplier = tag.getInteger("energyMultiplier");
    
        
    }



	
	public void setCoords()
	{
		coords[0]=xCoord;
		coords[1]=yCoord;
		coords[2]=zCoord;
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
	public void generateEnergy()
	{
		if(energyMultiplier ==0)
		{
			energyLevel++;
		}
		if(energyMultiplier>0)
		{
			energyLevel += (8*energyMultiplier);
		}
	
	}
	 public void writeToNBT(NBTTagCompound tag)
	    {
	        super.writeToNBT(tag);
	        
	        tag.setInteger("energyLevel", this.energyLevel);
	        tag.setIntArray("connectors", this.connectors);
	        tag.setIntArray("coordinates", this.coords);
	        tag.setInteger("numberDrawing", this.numberDrawing);
	        tag.setBoolean("isMulti", this.isMulti);
	        tag.setBoolean("isMulti2", this.isMulti2);
	        tag.setBoolean("isMulti3", this.isMulti3);
	        tag.setBoolean("isMulti4", this.isMulti4);
	       
	        tag.setIntArray("iMB", this.iMB);
	        tag.setInteger("energyMultiplier", this.energyMultiplier);
	        
	    }
	
	 public void checkMulti()
	 {
		 
		 boolean yep = true;
		 int i = 0;
		 while(yep)
		 {
			 if(worldObj.getBlockId(xCoord, yCoord-(i+1), zCoord)==MysticModBlocks.crystalGeneratorBase.blockID)
			 {
				 i++;
			 }
			 else
			 {
				 yep = false;
			 }
		 }
		
		 for(int ix = 0; ix<=i; ix++)
		 {
			 
			 boolean one = worldObj.getBlockId(xCoord, yCoord-(1+ix), zCoord)==MysticModBlocks.crystalGeneratorBase.blockID;
			 boolean two = worldObj.getBlockId(xCoord+1, yCoord-(1+ix), zCoord+1)==MysticModBlocks.crystalGeneratorBase.blockID;
			 boolean three = worldObj.getBlockId(xCoord, yCoord-(1+ix), zCoord+1)==MysticModBlocks.crystalGeneratorBase.blockID;
			 boolean four = worldObj.getBlockId(xCoord-1, yCoord-(1+ix), zCoord+1)==MysticModBlocks.crystalGeneratorBase.blockID;
			 boolean five = worldObj.getBlockId(xCoord+1, yCoord-(1+ix), zCoord)==MysticModBlocks.crystalGeneratorBase.blockID;
			 boolean six = worldObj.getBlockId(xCoord -1, yCoord-(1+ix), zCoord)==MysticModBlocks.crystalGeneratorBase.blockID;
			 boolean seven = worldObj.getBlockId(xCoord+1, yCoord-(1+ix), zCoord-1)==MysticModBlocks.crystalGeneratorBase.blockID;
			 boolean eight = worldObj.getBlockId(xCoord, yCoord-(1+ix), zCoord-1)==MysticModBlocks.crystalGeneratorBase.blockID;
			 boolean nine = worldObj.getBlockId(xCoord-1, yCoord-(1+ix), zCoord-1)==MysticModBlocks.crystalGeneratorBase.blockID;
			 if(!one)
			 {
				 
				iMB[ix]=0;
			 }
			 
			 if(one)
			 {
				 if(!two||!three||!four||!five||!six||!seven||!eight)
				 {
					 iMB[ix]=0;
					 
				 }
			 }
			 if(one&&two&&three&&four&&five&&six&&seven&&eight&&nine)
			 {
				 
				 iMB[ix]=1;
			
				
				 
				 
			 }
		 }
		 energyMultiplier=0;
		 int tempint = iMB.length;
		 for(int iz = 0; iz<tempint; iz++)
		 {
			 
			 if(iMB[iz]==1)
			 {
				 energyMultiplier++;
			 }
			 
			 
			 
		 }
		 
		 
		 
	 }
	 public void checkTwo()
	 {
		 boolean one = worldObj.getBlockId(xCoord, yCoord-2, zCoord)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean two = worldObj.getBlockId(xCoord+1, yCoord-2, zCoord+1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean three = worldObj.getBlockId(xCoord, yCoord-2, zCoord+1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean four = worldObj.getBlockId(xCoord-1, yCoord-2, zCoord+1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean five = worldObj.getBlockId(xCoord+1, yCoord-2, zCoord)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean six = worldObj.getBlockId(xCoord -1, yCoord-2, zCoord)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean seven = worldObj.getBlockId(xCoord+1, yCoord-2, zCoord-1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean eight = worldObj.getBlockId(xCoord, yCoord-2, zCoord-1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean nine = worldObj.getBlockId(xCoord-1, yCoord-2, zCoord-1)==MysticModBlocks.crystalGeneratorBase.blockID;
		
		 if(!one)
		 {
			 isMulti2=false;
		 }
		 if(one)
		 {
			 if(!two||!three||!four||!five||!six||!seven||!eight)
			 {
				 isMulti2 = false;
				
				 checkThree();
				 return;
			 }
		 }
		 if(one&&two&&three&&four&&five&&six&&seven&&eight&&nine)
		 {
			 isMulti2 = true;
			 return;
		 }
	 }
	 
	 public void checkThree()
	 {
		 boolean one = worldObj.getBlockId(xCoord, yCoord-3, zCoord)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean two = worldObj.getBlockId(xCoord+1, yCoord-3, zCoord+1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean three = worldObj.getBlockId(xCoord, yCoord-3, zCoord+1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean four = worldObj.getBlockId(xCoord-1, yCoord-3, zCoord+1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean five = worldObj.getBlockId(xCoord+1, yCoord-3, zCoord)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean six = worldObj.getBlockId(xCoord -1, yCoord-3, zCoord)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean seven = worldObj.getBlockId(xCoord+1, yCoord-3, zCoord-1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean eight = worldObj.getBlockId(xCoord, yCoord-3, zCoord-1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean nine = worldObj.getBlockId(xCoord-1, yCoord-3, zCoord-1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 if(!one)
		 {
			 isMulti3=false;
		 }
		 
		 if(one)
		 {
			 if(!two||!three||!four||!five||!six||!seven||!eight)
			 {
				 isMulti3 = false;
				 
				 return;
			 }
		 }
		 if(one&&two&&three&&four&&five&&six&&seven&&eight&&nine)
		 {
			 isMulti3 = true;
		
			 checkFour();
			 return;
		 }
	 }
	 public void checkFour()
	 {
		 boolean one = worldObj.getBlockId(xCoord, yCoord-4, zCoord)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean two = worldObj.getBlockId(xCoord+1, yCoord-4, zCoord+1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean three = worldObj.getBlockId(xCoord, yCoord-4, zCoord+1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean four = worldObj.getBlockId(xCoord-1, yCoord-4, zCoord+1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean five = worldObj.getBlockId(xCoord+1, yCoord-4, zCoord)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean six = worldObj.getBlockId(xCoord -1, yCoord-4, zCoord)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean seven = worldObj.getBlockId(xCoord+1, yCoord-4, zCoord-1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean eight = worldObj.getBlockId(xCoord, yCoord-4, zCoord-1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 boolean nine = worldObj.getBlockId(xCoord-1, yCoord-4, zCoord-1)==MysticModBlocks.crystalGeneratorBase.blockID;
		 if(!one)
		 {
			 isMulti4=false;
		 }
		 
		 if(one)
		 {
			 if(!two||!three||!four||!five||!six||!seven||!eight)
			 {
				 isMulti4 = false;
				 return;
			 }
		 }
		 if(one&&two&&three&&four&&five&&six&&seven&&eight&&nine)
		 {
			 isMulti4 = true;
			
			 return;
		 }
	 }
	 
	
	
	 public void updateEntity()
	    {
		 if(energyLevel<maxEnergyLevel)
		 {
		 generateEnergy();
		 cooldownTime++;
		 }
		 if(cooldownTime>32)
		 {
			 checkMulti();
			 cooldownTime = 0;
		 }
		 
		 
		 
		 
	    }
	 
	 
	 
	 
	
	
	

}

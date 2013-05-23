package com.sudwood.mysticadditions.blocks.energy;

import client.sudwood.mysticadditions.MysticClientProxy;

import com.sudwood.mysticadditions.MysticERegistration;
import com.sudwood.mysticadditions.MysticEnergy;

import com.sudwood.mysticadditions.mod_MysticAdditions;
import com.sudwood.mysticadditions.items.MysticModItems;
import com.sudwood.mysticadditions.items.energy.ItemWarpedPowerConnector;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGenerator;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockMysticRedStorage extends BlockContainer implements MysticEnergy {
int[] coords = {42,42,42};
protected int[] wireConnectors = {0,0,0,0,0,0};
int[] generatorCoords = {0,0,0};

	public BlockMysticRedStorage(int par1,Material par2Material) {
		super(par1, par2Material);
		
		// TODO Auto-generated constructor stub
	}
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		coords[0]=x;
		coords[1]=y;
		coords[2]=z;
		TileEntityMysticRedStorage tile = (TileEntityMysticRedStorage)world.getBlockTileEntity(x, y, z);
		tile.setCoords();
		
	}
	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	@SideOnly(Side.CLIENT)
	public int getRenderType()
    {
		return MysticClientProxy.MysticCapacitorRenderId;
    }
	@Override
	public int[] checkConnect(WorldServer world, int x, int y, int z){
		
			int[] newint = {0};
			return newint;
		}
	
	@Override
	public void getEnergy()
	{
		// TODO Auto-generated method stub
		
	}
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        float f = 0.25F;
        return AxisAlignedBB.getBoundingBox(i, j, k, i+1, (float)(j + 1) - f, k+1);
    }
	 @SideOnly(Side.CLIENT)

	    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int i, int j, int k)
	    {
		 float f = 0.25F;
	        return AxisAlignedBB.getBoundingBox(i, j, k, i+1, (float)(j + 1) - f, k+1);
	    }

	@Override
	public void sendEnergy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return new TileEntityMysticRedStorage();
	}
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		if (par1World.isRemote)
		return true;
		TileEntityMysticRedStorage tile =(TileEntityMysticRedStorage) par1World.getBlockTileEntity(par2, par3, par4);
		if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.warpedPowerConnector.itemID)
		{
			ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
			NBTTagCompound tag = tempStack.getTagCompound();
			if(tag.getBoolean("isSet"))
			{
				int[] tempArray = {tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")};
				tile.setTeleportPowerCoords(tempArray);
				tile.efficiencyLevel = 4;
				tile.setIsGettingTeleportedPower(true);
				TileEntity tile2 = par1World.getBlockTileEntity(tempArray[0], tempArray[1], tempArray[2]);
				if(tile2 instanceof TileEntityMysticRedGenerator)
				{
					((TileEntityMysticRedGenerator) tile2).numberDrawing++;
				}
				if(tile2 instanceof TileEntityMysticRedStorage)
				{
					((TileEntityMysticRedStorage) tile2).numberDrawing++;
				}
				tag.setInteger("xCoord", 0);
				tag.setInteger("yCoord", 0);
				tag.setInteger("zCoord", 0);
				tag.setBoolean("isSet", false);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				return true;
			}
			if(!tag.getBoolean("isSet"))
			{
				tag.setInteger("xCoord", par2);
				tag.setInteger("yCoord", par3);
				tag.setInteger("zCoord", par4);
				tag.setBoolean("isSet", true);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				return true;
			}
			
			
		}
		if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.mePowerConnector.itemID)
		{
			ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
			NBTTagCompound tag = tempStack.getTagCompound();
			if(tag.getBoolean("isSet"))
			{
				int[] tempArray = {tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")};
				tile.setTeleportPowerCoords(tempArray);
				tile.efficiencyLevel = 2;
				tile.setIsGettingTeleportedPower(true);
				TileEntity tile2 = par1World.getBlockTileEntity(tempArray[0], tempArray[1], tempArray[2]);
				if(tile2 instanceof TileEntityMysticRedGenerator)
				{
					((TileEntityMysticRedGenerator) tile2).numberDrawing++;
				}
				if(tile2 instanceof TileEntityMysticRedStorage)
				{
					((TileEntityMysticRedStorage) tile2).numberDrawing++;
				}
				tag.setInteger("xCoord", 0);
				tag.setInteger("yCoord", 0);
				tag.setInteger("zCoord", 0);
				tag.setBoolean("isSet", false);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				return true;
			}
			if(!tag.getBoolean("isSet"))
			{
				tag.setInteger("xCoord", par2);
				tag.setInteger("yCoord", par3);
				tag.setInteger("zCoord", par4);
				tag.setBoolean("isSet", true);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				return true;
			}
			
			
		}
		if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.ePowerConnector.itemID)
		{
			ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
			NBTTagCompound tag = tempStack.getTagCompound();
			if(tag.getBoolean("isSet"))
			{
				int[] tempArray = {tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")};
				tile.setTeleportPowerCoords(tempArray);
				tile.efficiencyLevel = 1.33;
				tile.setIsGettingTeleportedPower(true);
				TileEntity tile2 = par1World.getBlockTileEntity(tempArray[0], tempArray[1], tempArray[2]);
				if(tile2 instanceof TileEntityMysticRedGenerator)
				{
					((TileEntityMysticRedGenerator) tile2).numberDrawing++;
				}
				if(tile2 instanceof TileEntityMysticRedStorage)
				{
					((TileEntityMysticRedStorage) tile2).numberDrawing++;
				}
				tag.setInteger("xCoord", 0);
				tag.setInteger("yCoord", 0);
				tag.setInteger("zCoord", 0);
				tag.setBoolean("isSet", false);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				return true;
			}
			if(!tag.getBoolean("isSet"))
			{
				tag.setInteger("xCoord", par2);
				tag.setInteger("yCoord", par3);
				tag.setInteger("zCoord", par4);
				tag.setBoolean("isSet", true);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				return true;
			}
			
			
		}
		if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.tPowerConnector.itemID)
		{
			ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
			NBTTagCompound tag = tempStack.getTagCompound();
			if(tag.getBoolean("isSet"))
			{
				int[] tempArray = {tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")};
				tile.setTeleportPowerCoords(tempArray);
				tile.efficiencyLevel = 1;
				tile.setIsGettingTeleportedPower(true);
				TileEntity tile2 = par1World.getBlockTileEntity(tempArray[0], tempArray[1], tempArray[2]);
				if(tile2 instanceof TileEntityMysticRedGenerator)
				{
					((TileEntityMysticRedGenerator) tile2).numberDrawing++;
				}
				if(tile2 instanceof TileEntityMysticRedStorage)
				{
					((TileEntityMysticRedStorage) tile2).numberDrawing++;
				}
				tag.setInteger("xCoord", 0);
				tag.setInteger("yCoord", 0);
				tag.setInteger("zCoord", 0);
				tag.setBoolean("isSet", false);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				return true;
			}
			if(!tag.getBoolean("isSet"))
			{
				tag.setInteger("xCoord", par2);
				tag.setInteger("yCoord", par3);
				tag.setInteger("zCoord", par4);
				tag.setBoolean("isSet", true);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				return true;
			}
			
			
		}
		
		
			
			par5EntityPlayer.openGui(mod_MysticAdditions.instance, 4, par1World, par2, par3, par4);
			return true;
	
    }
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) 
	{
		
		
	}
	@Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        
        this.blockIcon = par1IconRegister.registerIcon("MysticAdditions:mysticspeedglass");
    	
    }

}

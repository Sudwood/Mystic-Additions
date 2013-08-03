package com.sudwood.mysticadditions.blocks.energy;

import java.util.List;

import client.sudwood.mysticadditions.MysticClientProxy;

import com.sudwood.mysticadditions.MysticERegistration;
import com.sudwood.mysticadditions.MysticEnergy;


import com.sudwood.mysticadditions.MysticAdditions;
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
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockMysticRedGenerator extends BlockContainer implements MysticEnergy {
int[] coords = {42,42,42};

	public BlockMysticRedGenerator(int par1, Material par2Material) {
		super(par1, par2Material);
		
		// TODO Auto-generated constructor stub
	}
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		super.onBlockAdded(world, x, y, z);
		coords[0]=x;
		coords[1]=y;
		coords[2]=z;
		TileEntityMysticRedGenerator tile = (TileEntityMysticRedGenerator)world.getBlockTileEntity(x, y, z);
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
	@Override
	public int[] checkConnect(WorldServer world, int x, int y, int z){
		int[] connectors = {42,42,42,42,42,42};
		
		return connectors;
	}
	
	@Override
	public void getEnergy()
	{
		// TODO Auto-generated method stub
		
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        float f = 0.362F;
        return AxisAlignedBB.getBoundingBox((float)(i + 0.25F), j, (float)(k + 0.25F), (float)(i + 0.75F), (float)(j + 1) + f, (float)(k + 0.75F));
    }
	 @SideOnly(Side.CLIENT)

	    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int i, int j, int k)
	    {
		 float f = 0.362F;
	        return AxisAlignedBB.getAABBPool().getAABB((float)(i + 0.25F), j, (float)(k + 0.25F), (float)(i + 0.75F), (float)(j + 1) + f, (float)(k + 0.75F));
	    }
	 public void addCollidingBlockToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity par7Entity)
	    {
	        AxisAlignedBB var8 = this.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);

	        if (var8 != null && par5AxisAlignedBB.intersectsWith(var8))
	        {
	            par6List.add(var8);
	        }
	    }
	
	@Override
	public void sendEnergy() {
		// TODO Auto-generated method stub
		
	}
	@SideOnly(Side.CLIENT)
	public int getRenderType()
    {
		return MysticClientProxy.MysticCapacitorRenderId;
    }

	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return new TileEntityMysticRedGenerator(4000);
	}
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		if(!par1World.isRemote)
		{
			if(par5EntityPlayer.isSneaking())
			{
				return false;
				
			}
			
			
				
			if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.warpedPowerConnector.itemID)
			{
				ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
				NBTTagCompound tag = tempStack.getTagCompound();
				tag.setInteger("xCoord", par2);
				tag.setInteger("yCoord", par3);
				tag.setInteger("zCoord", par4);
				tag.setBoolean("isSet", true);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				par5EntityPlayer.addChatMessage("Link Started");
				return true;
				
			}
			if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.mePowerConnector.itemID)
			{
				ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
				NBTTagCompound tag = tempStack.getTagCompound();
				tag.setInteger("xCoord", par2);
				tag.setInteger("yCoord", par3);
				tag.setInteger("zCoord", par4);
				tag.setBoolean("isSet", true);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				par5EntityPlayer.addChatMessage("Link Started");
				return true;
				
			}
			if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.ePowerConnector.itemID)
			{
				ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
				NBTTagCompound tag = tempStack.getTagCompound();
				tag.setInteger("xCoord", par2);
				tag.setInteger("yCoord", par3);
				tag.setInteger("zCoord", par4);
				tag.setBoolean("isSet", true);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				par5EntityPlayer.addChatMessage("Link Started");
				return true;
				
			}
			if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.tPowerConnector.itemID)
			{
				ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
				NBTTagCompound tag = tempStack.getTagCompound();
				tag.setInteger("xCoord", par2);
				tag.setInteger("yCoord", par3);
				tag.setInteger("zCoord", par4);
				tag.setBoolean("isSet", true);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				par5EntityPlayer.addChatMessage("Link Started");
				return true;
				
			}
			
			par5EntityPlayer.openGui(MysticAdditions.instance, 3, par1World, par2, par3, par4);
		}
	
			
		
			return true;
		}
    
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) 
	{
		
		
	}
	@Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("MysticAdditions:mysticcobblestone");
        
    	
    }

}

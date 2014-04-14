package com.sudwood.mysticadditions.blocks.energy;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import client.sudwood.mysticadditions.MysticClientProxy;

import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.MysticEnergy;
import com.sudwood.mysticadditions.items.MysticModItems;
import com.sudwood.mysticadditions.tileentity.TileEntityLiquidStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGenerator;
import com.sudwood.mysticadditions.tileentity.TileEntityThermalGenerator;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockThermalGenerator extends BlockContainer {
int[] coords = {42,42,42};

	public BlockThermalGenerator(int par1, Material par2Material) {
		super(par1, par2Material);
		
		// TODO Auto-generated constructor stub
	}
	@SideOnly(Side.CLIENT)
	public int getRenderType()
    {
		return MysticClientProxy.MysticLiquidStorageRenderid;
    }
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		super.onBlockAdded(world, x, y, z);
		
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
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return new TileEntityThermalGenerator(128000);
	}
	public boolean onBlockActivated(World world, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		if(!world.isRemote)
		{
			if(par5EntityPlayer.isSneaking())
			{
				return false;
				
			}
			if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.moltenRedstone.itemID)
			{
				par5EntityPlayer.openGui(MysticAdditions.instance, 11, world, par2, par3, par4);
				return true;
			}
			
				
			if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.warpedPowerConnector.itemID)
			{
				ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
				NBTTagCompound tag = tempStack.getTagCompound();
				if(!tag.getBoolean("isSet"))
				{
					tag.setInteger("xCoord", par2);
					tag.setInteger("yCoord", par3);
					tag.setInteger("zCoord", par4);
					tag.setBoolean("isSet", true);
					par5EntityPlayer.addChatMessage("Link Started");
				}
				else if(world.getBlockTileEntity(tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")) instanceof TileEntityLiquidStorage)
				{
					TileEntityLiquidStorage tile = (TileEntityLiquidStorage) world.getBlockTileEntity(par2, par3, par4);
					tile.setTeleportLiquidCoords(new int[] {tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")});
					tag.setInteger("xCoord", 0);
					tag.setInteger("yCoord", 0);
					tag.setInteger("zCoord", 0);
					tag.setBoolean("isSet", false);
					par5EntityPlayer.addChatMessage("Liquid Link Set");
				}
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				
				return true;
				
			}
			if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.mePowerConnector.itemID)
			{
				ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
				NBTTagCompound tag = tempStack.getTagCompound();
				if(!tag.getBoolean("isSet"))
				{
					tag.setInteger("xCoord", par2);
					tag.setInteger("yCoord", par3);
					tag.setInteger("zCoord", par4);
					tag.setBoolean("isSet", true);
					par5EntityPlayer.addChatMessage("Link Started");
				}
				else if(world.getBlockTileEntity(tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")) instanceof TileEntityLiquidStorage)
				{
					TileEntityLiquidStorage tile = (TileEntityLiquidStorage) world.getBlockTileEntity(par2, par3, par4);
					tile.setTeleportLiquidCoords(new int[] {tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")});
					tag.setInteger("xCoord", 0);
					tag.setInteger("yCoord", 0);
					tag.setInteger("zCoord", 0);
					tag.setBoolean("isSet", false);
					par5EntityPlayer.addChatMessage("Liquid Link Set");
				}
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				
				return true;
				
			}
			if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.ePowerConnector.itemID)
			{
				ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
				NBTTagCompound tag = tempStack.getTagCompound();
				if(!tag.getBoolean("isSet"))
				{
					tag.setInteger("xCoord", par2);
					tag.setInteger("yCoord", par3);
					tag.setInteger("zCoord", par4);
					tag.setBoolean("isSet", true);
					par5EntityPlayer.addChatMessage("Link Started");
				}
				else if(world.getBlockTileEntity(tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")) instanceof TileEntityLiquidStorage)
				{
					TileEntityLiquidStorage tile = (TileEntityLiquidStorage) world.getBlockTileEntity(par2, par3, par4);
					tile.setTeleportLiquidCoords(new int[] {tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")});
					tag.setInteger("xCoord", 0);
					tag.setInteger("yCoord", 0);
					tag.setInteger("zCoord", 0);
					tag.setBoolean("isSet", false);
					par5EntityPlayer.addChatMessage("Liquid Link Set");
				}
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				
				return true;
				
			}
			if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.tPowerConnector.itemID)
			{
				ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
				NBTTagCompound tag = tempStack.getTagCompound();
				if(!tag.getBoolean("isSet"))
				{
					tag.setInteger("xCoord", par2);
					tag.setInteger("yCoord", par3);
					tag.setInteger("zCoord", par4);
					tag.setBoolean("isSet", true);
					par5EntityPlayer.addChatMessage("Link Started");
				}
				else if(world.getBlockTileEntity(tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")) instanceof TileEntityLiquidStorage)
				{
					TileEntityLiquidStorage tile = (TileEntityLiquidStorage) world.getBlockTileEntity(par2, par3, par4);
					tile.setTeleportLiquidCoords(new int[] {tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")});
					tag.setInteger("xCoord", 0);
					tag.setInteger("yCoord", 0);
					tag.setInteger("zCoord", 0);
					tag.setBoolean("isSet", false);
					par5EntityPlayer.addChatMessage("Liquid Link Set");
				}
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				
				return true;
				
			}
			
			par5EntityPlayer.openGui(MysticAdditions.instance, 1, world, par2, par3, par4);
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

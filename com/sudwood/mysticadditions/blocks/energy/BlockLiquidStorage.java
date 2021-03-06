package com.sudwood.mysticadditions.blocks.energy;

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
import client.sudwood.mysticadditions.MysticClientProxy;

import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.MysticEnergy;
import com.sudwood.mysticadditions.items.MysticModItems;
import com.sudwood.mysticadditions.tileentity.TileEntityLiquidStorage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLiquidStorage extends BlockContainer {


	public BlockLiquidStorage(int par1,Material par2Material) {
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
        float f = 0.31F;
        return AxisAlignedBB.getBoundingBox(i, j, k, i+1, (float)(j + 1) - f, k+1);
    }
	 @SideOnly(Side.CLIENT)

	    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int i, int j, int k)
	    {
		 float f = 0.31F;
	        return AxisAlignedBB.getBoundingBox(i+.9, j, k+0.1, i+0.1, (float)(j + 1) - f, k+0.9);
	    }

	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return new TileEntityLiquidStorage(64000);
	}
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		
		if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.csteelDust.itemID)
		{
			par5EntityPlayer.openGui(MysticAdditions.instance, 8, par1World, par2, par3, par4);
			return true;
		}
		if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.moltenRedstone.itemID)
		{
			par5EntityPlayer.openGui(MysticAdditions.instance, 11, par1World, par2, par3, par4);
			return true;
		}
		TileEntityLiquidStorage tile =(TileEntityLiquidStorage) par1World.getBlockTileEntity(par2, par3, par4);
		if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.warpedPowerConnector.itemID)
		{
			ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
			NBTTagCompound tag = tempStack.getTagCompound();
			if(tag.getBoolean("isSet"))
			{
				int[] tempArray = {tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")};
				par5EntityPlayer.addChatMessage(tile.setTeleportPowerCoords(tempArray,4));
				
				tile.setIsGettingTeleportedPower(true);
				
				
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
				par5EntityPlayer.addChatMessage("Link Started");
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
				par5EntityPlayer.addChatMessage(tile.setTeleportPowerCoords(tempArray,2));
			
				tile.setIsGettingTeleportedPower(true);
				
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
				par5EntityPlayer.addChatMessage("Link Started");
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
				par5EntityPlayer.addChatMessage(tile.setTeleportPowerCoords(tempArray, 1.33));
				
				tile.setIsGettingTeleportedPower(true);
				
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
				par5EntityPlayer.addChatMessage("Link Started");
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
				
				
				tile.setIsGettingTeleportedPower(true);
				
				tag.setInteger("xCoord", 0);
				tag.setInteger("yCoord", 0);
				tag.setInteger("zCoord", 0);
				tag.setBoolean("isSet", false);
				tile.setTeleportPowerCoords(tempArray,1);
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
				par5EntityPlayer.addChatMessage("Link Started");
				return true;
			}
			
			
		}
		
		
			
			par5EntityPlayer.openGui(MysticAdditions.instance, 1, par1World, par2, par3, par4);
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

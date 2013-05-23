package com.sudwood.mysticadditions.blocks.energy;

import java.util.Random;

import client.sudwood.mysticadditions.MysticClientProxy;

import com.sudwood.mysticadditions.MysticERegistration;
import com.sudwood.mysticadditions.MysticEnergy;

import com.sudwood.mysticadditions.mod_MysticAdditions;
import com.sudwood.mysticadditions.items.MysticModItems;
import com.sudwood.mysticadditions.items.energy.ItemWarpedPowerConnector;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticFurnace;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGenerator;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGrinder;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityPoweredFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockPoweredFurnace extends BlockContainer {
	public int[] coords = {42,42,42};
	public Icon[] iconList = new Icon[3];
	private Random furnaceRand = new Random();
	public BlockPoweredFurnace(int par1) {
		super(par1, Material.rock);
		
		// TODO Auto-generated constructor stub
	}
	public void onBlockAdded(World world, int x, int y, int z) 
	{
		super.onBlockAdded(world, x, y, z);
		coords[0]=x;
		coords[1]=y;
		coords[2]=z;
		TileEntityPoweredFurnace tile = (TileEntityPoweredFurnace)world.getBlockTileEntity(x, y, z);
		tile.setCoords();
        
        this.setDefaultDirection(world, x, y, z);
		
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
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return new TileEntityPoweredFurnace();
	}
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if (true)
        {
            TileEntityPoweredFurnace var7 = (TileEntityPoweredFurnace)par1World.getBlockTileEntity(par2, par3, par4);

            if (var7 != null)
            {
                for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
                {
                    ItemStack var9 = var7.getStackInSlot(var8);

                    if (var9 != null)
                    {
                        float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float var11 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float var12 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                        while (var9.stackSize > 0)
                        {
                            int var13 = this.furnaceRand.nextInt(21) + 10;

                            if (var13 > var9.stackSize)
                            {
                                var13 = var9.stackSize;
                            }

                            var9.stackSize -= var13;
                            EntityItem var14 = new EntityItem(par1World, (double)((float)par2 + var10), (double)((float)par3 + var11), (double)((float)par4 + var12), new ItemStack(var9.itemID, var13, var9.getItemDamage()));

                            if (var9.hasTagCompound())
                            {
                            	var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
                            }

                            float var15 = 0.05F;
                            var14.motionX = (double)((float)this.furnaceRand.nextGaussian() * var15);
                            var14.motionY = (double)((float)this.furnaceRand.nextGaussian() * var15 + 0.2F);
                            var14.motionZ = (double)((float)this.furnaceRand.nextGaussian() * var15);
                            par1World.spawnEntityInWorld(var14);
                        }
                    }
                }
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		if (par1World.isRemote)
		return true;
		TileEntityPoweredFurnace tile =(TileEntityPoweredFurnace) par1World.getBlockTileEntity(par2, par3, par4);
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
				
				return true;
			}
			
			
		}
		
		
			
			par5EntityPlayer.openGui(mod_MysticAdditions.instance, 6, par1World, par2, par3, par4);
			return true;
	
    }
	@Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        
        this.iconList[0] = par1IconRegister.registerIcon("MysticAdditions:poweredfurnacefront");
        this.iconList[1] = par1IconRegister.registerIcon("MysticAdditions:poweredfurnaceside");
        this.iconList[2] = par1IconRegister.registerIcon("MysticAdditions:mysticblocksiding");
    	
    }


    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            int var5 = par1World.getBlockId(par2, par3, par4 - 1);
            int var6 = par1World.getBlockId(par2, par3, par4 + 1);
            int var7 = par1World.getBlockId(par2 - 1, par3, par4);
            int var8 = par1World.getBlockId(par2 + 1, par3, par4);
            byte var9 = 3;

            if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6])
            {
                var9 = 3;
            }

            if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5])
            {
                var9 = 2;
            }

            if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8])
            {
                var9 = 5;
            }

            if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7])
            {
                var9 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, var9,2);
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
    	if (par5 == 1)
        {
            return this.iconList[2];
        }
        else if (par5 == 0)
        {
            return this.iconList[2];
        }
        else
        {
            int var6 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
            return par5 != var6 ? this.iconList[1] :  this.iconList[0];
        }
    }
    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */

    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
    	
            return par1 == 1 ? this.iconList[2] : (par1 == 0 ? this.iconList[1] : (par1 == 3 ? this.iconList[0] : this.iconList[1]));
       
    }


}

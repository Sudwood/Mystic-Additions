package com.sudwood.mysticadditions.blocks.energy;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import client.sudwood.mysticadditions.MysticClientProxy;

import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.items.MysticModItems;
import com.sudwood.mysticadditions.tileentity.TileEntityOreRift;
import com.sudwood.mysticadditions.tileentity.TileEntityRecallPortal;
import com.sudwood.mysticadditions.tileentity.TileEntityRecallPortal;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockRecallPortal extends BlockContainer {
	private Random furnaceRand = new Random();
int[] coords = {0,0,0};
public Icon[] iconList = new Icon[3];

	public BlockRecallPortal(int par1) {
		super(par1, Material.rock);
		
		// TODO Auto-generated constructor stub
	}

	public void onBlockAdded(World world, int x, int y, int z) 
	{
		coords[0] = x;
		coords[1] = y;
		coords[2] = z;
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
		return new TileEntityRecallPortal(32000);
	}
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.csteelDust.itemID)
		{
			par5EntityPlayer.openGui(MysticAdditions.instance, 8, par1World, par2, par3, par4);
			return true;
		}
		
		TileEntityRecallPortal tile =(TileEntityRecallPortal) par1World.getBlockTileEntity(par2, par3, par4);
		if(par5EntityPlayer.getCurrentEquippedItem()!=null&&par5EntityPlayer.getCurrentEquippedItem().itemID==MysticModItems.warpedPowerConnector.itemID)
		{
			ItemStack tempStack = par5EntityPlayer.getCurrentEquippedItem();
			NBTTagCompound tag = tempStack.getTagCompound();
			if(tag.getBoolean("isSet"))
			{
				int[] tempArray = {tag.getInteger("xCoord"), tag.getInteger("yCoord"), tag.getInteger("zCoord")};
				tile.setTeleportPowerCoords(tempArray, 4);
				
				tile.setIsGettingTeleportedPower(true);

				tag.setInteger("xCoord", 0);
				tag.setInteger("yCoord", 0);
				tag.setInteger("zCoord", 0);
				tag.setBoolean("isSet", false);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				par5EntityPlayer.addChatMessage("Link Created");
				return true;
			}
			if(!tag.getBoolean("isSet"))
			{
				par5EntityPlayer.addChatMessage("No Current Link");
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
				tile.setTeleportPowerCoords(tempArray, 2);
				
				tile.setIsGettingTeleportedPower(true);
			
				tag.setInteger("xCoord", 0);
				tag.setInteger("yCoord", 0);
				tag.setInteger("zCoord", 0);
				tag.setBoolean("isSet", false);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				par5EntityPlayer.addChatMessage("Link Created");
				return true;
			}
			if(!tag.getBoolean("isSet"))
			{
				par5EntityPlayer.addChatMessage("No Current Link");
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
				tile.setTeleportPowerCoords(tempArray, 1.33);
				
				tile.setIsGettingTeleportedPower(true);
			
				tag.setInteger("xCoord", 0);
				tag.setInteger("yCoord", 0);
				tag.setInteger("zCoord", 0);
				tag.setBoolean("isSet", false);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				par5EntityPlayer.addChatMessage("Link Created");
				return true;
			}
			if(!tag.getBoolean("isSet"))
			{
				par5EntityPlayer.addChatMessage("No Current Link");
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
				tile.setTeleportPowerCoords(tempArray, 1);
				
				tile.setIsGettingTeleportedPower(true);
				
				tag.setInteger("xCoord", 0);
				tag.setInteger("yCoord", 0);
				tag.setInteger("zCoord", 0);
				tag.setBoolean("isSet", false);
				par5EntityPlayer.setCurrentItemOrArmor(0, tempStack);
				par5EntityPlayer.addChatMessage("Link Created");
				return true;
			}
			if(!tag.getBoolean("isSet"))
			{
				par5EntityPlayer.addChatMessage("No Current Link");
				return true;
			}
			
			
		}
		
		/*if(tile.getStackInSlot(0)!=null)
		{
			NBTTagCompound tag = tile.getStackInSlot(0).getTagCompound();
			if(tag!=null)
			{
				if(tag.getString("Creator").equalsIgnoreCase(par5EntityPlayer.username))
				{
					par5EntityPlayer.openGui(MysticAdditions.instance, 12, par1World, par2, par3, par4);
					return true;
				}
				else
				{
					par5EntityPlayer.addChatMessage("You are not the owner of this portal. Please get the owner if you would like to change settings");
					return false;
				}
			}
		}
			
		else
		{*/
			par5EntityPlayer.openGui(MysticAdditions.instance, 12, par1World, par2, par3, par4);
			return true;
		
		
	
    }
	
	/*public boolean canHarvestBlock(EntityPlayer player, int meta)
    {
        World world = player.worldObj;
        TileEntityRecallPortal tile = (TileEntityRecallPortal) world.getBlockTileEntity(coords[0], coords[1], coords[2]);
        if(tile!=null&& tile.getStackInSlot(0)!=null)
        {
        	if(tile.getStackInSlot(0).getTagCompound()!=null)
        	{
        		NBTTagCompound tag = tile.getStackInSlot(0).getTagCompound();
        		if(tag.getString("Creator").equalsIgnoreCase(player.username))
        		{
        			return true;
        		}
        		else
        		{
        			return false;
        		}
        	}
        }
        return true;
    }*/
	
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
		if (true)
        {
            TileEntityOreRift var7 = (TileEntityOreRift)par1World.getBlockTileEntity(par2, par3, par4);

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
            return this.iconList[1];
        }
        else
        {
            return iconList[0];
        }
    }
	@Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        
        iconList[0] = par1IconRegister.registerIcon("MysticAdditions:recallportalside");
        iconList[1] = par1IconRegister.registerIcon("MysticAdditions:recallportalbottom");
        iconList[2] = par1IconRegister.registerIcon("MysticAdditions:recallportaltop");
        
    }
	 @SideOnly(Side.CLIENT)

	    /**
	     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	     */
	    public Icon getIcon(int par1, int par2)
	    {
		 if (par1 == 1)
	        {
	            return this.iconList[2];
	        }
	        else if (par1 == 0)
	        {
	            return this.iconList[1];
	        }
	        else
	        {
	            return iconList[0];
	        }
	    }

	@Override
	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) 
	{
		if(!par1World.isRemote)
		{
			if(par5Entity instanceof EntityPlayer)
			{
				TileEntityRecallPortal tile = (TileEntityRecallPortal)par1World.getBlockTileEntity(par2, par3, par4);
				tile.telePlayer((EntityPlayer)par5Entity);
			}
		}
	}
}

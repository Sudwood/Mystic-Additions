package com.sudwood.mysticadditions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.tileentity.TileEntityCamoBlock;

public class BlockCamoBlock extends BlockContainer
{

	public boolean isBlockNormalCube(World world, int x, int y, int z)
	{
		return false;
	}
	public boolean isOpaqueCube()
	{
	    return false;
	}
	protected BlockCamoBlock(int par1, Material par2Material)
	{
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
	}
	public void onBlockAdded(World par1World, int par2, int par3, int par4) 
	{
		
	}
	public float getPlayerRelativeBlockHardness(EntityPlayer par1EntityPlayer, World par2World, int par3, int par4, int par5)
	{
		
		TileEntityCamoBlock tile = (TileEntityCamoBlock) par2World.getBlockTileEntity(par3, par4, par5);
		String[] temp = tile.getPlayers();
		 for (int i=0; i<temp.length; i++)
		 {
			 if(par1EntityPlayer.username.equals(temp[i]))
			 {
				 return 0;
			 }
		 }
	    return 10000;
	}
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity) 
	 {
		
		 TileEntityCamoBlock tile = (TileEntityCamoBlock) par1World.getBlockTileEntity(par2, par3, par4);
		 if(par5Entity instanceof EntityPlayer)
		 {
			 System.out.println("ISPLAYER");
			 EntityPlayer player = (EntityPlayer) par5Entity;
			 String[] temp = tile.getPlayers();
			 System.out.println(player.username);
			 for (int i=0; i<temp.length; i++)
			 {
				 System.out.println(temp[i]);
				 if(player.username.equals(temp[i]))
				 {
					 return;
				 }
			 }
			checkAndSetEntity(player);
			return;
		 }
		 else
		 {
			 System.out.println("NOTPLAYER");
			 checkAndSetEntity(par5Entity);
		 }
		 
	 }

	public void checkAndSetEntity(Entity player)
	 {
		 
		 if(player.motionX!=0)
		 {
			 if(player.motionX>0)
			 {
				 player.setPosition(player.posX-1, player.posY, player.posZ);
				 System.out.println("X");
			 }
			 if(player.motionX<0)
			 {
				 player.setPosition(player.posX+1, player.posY, player.posZ);
				 System.out.println("X");
			 }
		 }
		 if(player.motionY!=0)
		 {
			 if(player.motionY>0)
			 {
				 player.setPosition(player.posX, player.posY-1, player.posZ);
				 System.out.println("Y");
			 }
			 if(player.motionY<0)
			 {
				 player.setPosition(player.posX, player.posY+1, player.posZ);
				 System.out.println("Y");
			 } 
		 }
		 if(player.motionZ!=0)
		 {
			 if(player.motionZ>0)
			 {
				 player.setPosition(player.posX, player.posY, player.posZ-1);
				 System.out.println("Z");
			 }
			 if(player.motionZ<0)
			 {
				 player.setPosition(player.posX, player.posY, player.posZ+1);
				 System.out.println("Z");
			 }
		 }
	 }
	 
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack) 
	 {
		 
		 TileEntityCamoBlock tile = (TileEntityCamoBlock) par1World.getBlockTileEntity(par2, par3, par4);
		 tile.populatePlayers();
		 if(par5EntityLivingBase instanceof EntityPlayer)
		 {
			 EntityPlayer player = (EntityPlayer) par5EntityLivingBase;
			 tile.addToPlayers(player.username);
		 }
		 
	 }
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	    {
	        return null;
	    }
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		// TODO Auto-generated method stub
		return new TileEntityCamoBlock();
	}
	public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("mysticadditions:camoblock");
    }

	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
		TileEntityCamoBlock tile = (TileEntityCamoBlock) par1World.getBlockTileEntity(par2, par3, par4);
		String[] temp = tile.getPlayers();
		for(int i =0; i<temp.length;i++)
		{
		if(par5EntityPlayer.username.equals(temp[i]))
		{
			if(par5EntityPlayer.getCurrentEquippedItem().getItem() instanceof ItemBlock)
			{
				ItemBlock iblock = (ItemBlock) par5EntityPlayer.getCurrentEquippedItem().getItem();
				int id = iblock.getBlockID();
				int meta = iblock.getDamage(par5EntityPlayer.getCurrentEquippedItem());
				tile.setShowid(id);
				tile.setShowmeta(meta);
				tile.sendData(id, meta);
				
			}
		}
		}
        return false;
    }

	public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
		
		TileEntityCamoBlock tile = (TileEntityCamoBlock) par1IBlockAccess.getBlockTileEntity(par2, par3, par4);
		if(tile.getShowid()!=0)
		{
		Block block = Block.blocksList[tile.getShowid()];
		
        return block.getIcon(2, tile.getShowmeta());
		}
		return this.blockIcon;
		
    }
}

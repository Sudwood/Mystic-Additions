package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import com.sudwood.mysticadditions.MysticCommonProxy;

import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticBud;

import cpw.mods.fml.common.LoaderException;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeDirection;

public class BlockMysticBudSwitch extends BlockContainer {
private boolean pwrlvl = false;
	public BlockMysticBudSwitch(int i)
    {
        super(i, Material.rock);
        
    }
	public Icon[] iconList = new Icon[3];
	   public int idDropped(int par1, Random par2Random, int par3)
	    {
	        return MysticModBlocks.mysticBUD.blockID;
	    }
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
	
	 public void onBlockAdded(World par1World, int par2, int par3, int par4)
	    {
	        super.onBlockAdded(par1World, par2, par3, par4);
	        this.setDefaultDirection(par1World, par2, par3, par4);
	        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
	    }
	 public int tickRate()
		{
			return 10;
		}
	 public boolean isBlockNormalCube(World world, int x, int y, int z)
	    {
		 return false;
	    }
	 public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
	    {
	        int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
	        TileEntityMysticBud tile = (TileEntityMysticBud) par1World.getBlockTileEntity(par2, par3, par4);
	        if (var6 == 0)
	        {
	        	//facing z positive south
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2,2);
	            tile.setBlockID(par1World.getBlockId(par2, par3, par4-1));
	            tile.setBlockMeta(par1World.getBlockMetadata(par2, par3, par4-1));
	        }

	        if (var6 == 1)
	        {
	        	//facing x negative west
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5,2);
	            tile.setBlockID(par1World.getBlockId(par2+1, par3, par4));
	            tile.setBlockMeta(par1World.getBlockMetadata(par2+1, par3, par4));
	            
	        }

	        if (var6 == 2)
	        {
	        	//facing z negative north
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3,2);
	            
	            tile.setBlockID(par1World.getBlockId(par2, par3, par4+1));
	            tile.setBlockMeta(par1World.getBlockMetadata(par2, par3, par4+1));
	        }

	        if (var6 == 3)
	        {
	        	//facing x positive east
	            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4,2);
	            
	            tile.setBlockID(par1World.getBlockId(par2-1, par3, par4));
	            tile.setBlockMeta(par1World.getBlockMetadata(par2-1, par3, par4));
	        }
	    }
	 @SideOnly(Side.CLIENT)
	 public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	    {
	    	if (par5 == 1)
	        {
	            return this.iconList[1];
	        }
	        else if (par5 == 0)
	        {
	            return this.iconList[1];
	        }
	        else
	        {
	            int var6 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
	            return par5 != var6 ? iconList[1] :  iconList[0];
	        }
	    }
	 public boolean canConnectRedstone(IBlockAccess world, int x, int y, int z, int side)
	    {
		 if (world.getBlockMetadata(x, y, z)==3&&side!=2){
	        return true;
		 }
		 if (world.getBlockMetadata(x, y, z)==2&&side!=0){
		        return true;
			 }
		 if (world.getBlockMetadata(x, y, z)==5&&side!=1){
		        return true;
			 }
		 if (world.getBlockMetadata(x, y, z)==4&&side!=3){
		        return true;
			 }
		 return false;
	    }

	 public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	    {
	    	
	            return par1 == 1 ? iconList[1]: (par1 == 0 ? iconList[1] : (par1 == 3 ? this.iconList[0] : iconList[1]));
	       
	    }
	
	 public TileEntity createNewTileEntity(World par1World)
	    {
	        return new TileEntityMysticBud();
	    }
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	    {
	        if (par1World.isRemote)
	        {
	            return true;
	        }
	        else
	        {
	           
	            if(par5EntityPlayer.isSneaking()){
	            	
	            	return false;
	            	}

	            if(!par5EntityPlayer.isSneaking()){
	            	TileEntityMysticBud tile = (TileEntityMysticBud)par1World.getBlockTileEntity(par2, par3, par4);
	            	par5EntityPlayer.sendChatToPlayer(tile.getBlockID()+"");
	            	par5EntityPlayer.sendChatToPlayer(tile.getBlockMeta()+"");
	              	par5EntityPlayer.openGui(MysticAdditions.instance, 2, par1World, par2, par3, par4);
	            }

	            return true;
	        }
	    }
	 public int isProvidingWeakPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	    {
		 int x = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		 TileEntityMysticBud tile = (TileEntityMysticBud) par1IBlockAccess.getBlockTileEntity(par2, par3, par4);
		 
		if (x==3){
			if(par5!=2){
				
				if(tile.getPower())
				{
					return 15;
				}
			}
				 }
		if (x==2){
			 if(par5!=3){
				 
				 if(tile.getPower())
					{
						return 15;
					}
			 }
		}
		if (x==5){
			if(par5!=4){
				
				if(tile.getPower())
				{
					return 15;
				}
			}
		}
		if (x==4){
			if(par5!=5){
				
				if(tile.getPower())
				{
					return 15;
				}
			}
		}
		
			
			
					
		 return 0;
		 
	    }
	 public int isProvidingStrongPower(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	    {
		 int x = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
		 TileEntityMysticBud tile = (TileEntityMysticBud) par1IBlockAccess.getBlockTileEntity(par2, par3, par4);
		 if (x==2){
				if(par5!=2){
					if(tile.getPower())
					{
						return 15;
					}
				}
					 }
			if (x==3){
				 if(par5!=3){
					 if(tile.getPower())
						{
							return 15;
						}
				 }
			}
			if (x==4){
				if(par5!=4){
					if(tile.getPower())
					{
						return 15;
					}
				}
			}
			if (x==5){
				if(par5!=5){
					if(tile.getPower())
					{
						return 15;
					}
				}
			}
			
	        return 0;
	    }
	 
	
	 public boolean canProvidePower()
	 {
	          return true;
	 }
	 private int getSide(World world, int x, int y, int z){
		 int m = world.getBlockMetadata(x, y, z);
		 return m;
	 }
	 private int OBlockID;
	 private void setOrigBlockID(int id){
		 OBlockID=id;
	 }
	 private int getOrigBlockID(){
		 return OBlockID;
	 }
	 
	
	 public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
		if (par1World.isRemote)
		{
			
		}
		
		 if (!par1World.isRemote){
			 par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, tickRate());
		 TileEntityMysticBud tile = (TileEntityMysticBud) par1World.getBlockTileEntity(par2, par3, par4);
		 if (getSide(par1World, par2, par3, par4)==2)
		 {
			int currentBlockID = par1World.getBlockId(par2, par3, par4-1);
			int currentBlockMeta = par1World.getBlockMetadata(par2, par3, par4-1);
			if (tile.getBlockID() == currentBlockID && tile.getBlockMeta() == currentBlockMeta){
				tile.setPower(false);
				par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
				return;
			}
			if (tile.getBlockID() != currentBlockID || tile.getBlockMeta() != currentBlockMeta){
				System.out.println("there is a change");
				tile.setPower(true);
				this.pwrlvl = true;
				System.out.println(tile.getPower()+"");
				tile.setBlockID(currentBlockID);
				tile.setBlockMeta(currentBlockMeta);
				
				 par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2 - 1, par3, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2 + 1, par3, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.blockID);
				par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
			}
		 }
		 if (getSide(par1World, par2, par3, par4)==3)
		 {
			int currentBlockID = par1World.getBlockId(par2, par3, par4+1);
			int currentBlockMeta = par1World.getBlockMetadata(par2, par3, par4+1);
			if (tile.getBlockID() == currentBlockID && tile.getBlockMeta() == currentBlockMeta){
				tile.setPower(false);
				par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
				return;
			}
			if (tile.getBlockID() != currentBlockID || tile.getBlockMeta() != currentBlockMeta){
				System.out.println("there is a change");
				System.out.println(tile.getPower()+"");
				tile.setBlockID(currentBlockID);
				tile.setBlockMeta(currentBlockMeta);
				tile.setPower(true);
				 par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2 - 1, par3, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2 + 1, par3, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.blockID);
				par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
			}
		 }
		 if (getSide(par1World, par2, par3, par4)==4)
		 {
			int currentBlockID = par1World.getBlockId(par2+1, par3, par4);
			int currentBlockMeta = par1World.getBlockMetadata(par2+1, par3, par4);
			if (tile.getBlockID() == currentBlockID && tile.getBlockMeta() == currentBlockMeta){
				tile.setPower(false);
				par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
				return;
			}
			if (tile.getBlockID() != currentBlockID || tile.getBlockMeta() != currentBlockMeta){
				System.out.println("there is a change");
				System.out.println(tile.getPower()+"");
				tile.setBlockID(currentBlockID);
				tile.setBlockMeta(currentBlockMeta);
				tile.setPower(true);
				 par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2 - 1, par3, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2 + 1, par3, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.blockID);
				par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
			}
		 }
		 if (getSide(par1World, par2, par3, par4)==5)
		 {
			int currentBlockID = par1World.getBlockId(par2-1, par3, par4);
			int currentBlockMeta = par1World.getBlockMetadata(par2-1, par3, par4);
			if (tile.getBlockID() == currentBlockID && tile.getBlockMeta() == currentBlockMeta){
				tile.setPower(false);
				par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
				return;
			}
			if (tile.getBlockID() != currentBlockID || tile.getBlockMeta() != currentBlockMeta){
				System.out.println("there is a change");
				System.out.println(tile.getPower()+"");
				
				tile.setBlockID(currentBlockID);
				tile.setBlockMeta(currentBlockMeta);
				tile.setPower(true);
				 par1World.notifyBlocksOfNeighborChange(par2, par3, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2 - 1, par3, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2 + 1, par3, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
		            par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.blockID);
				par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
				
			}
		 }
		 
		} 
		
		
	 }
	 public void updateTick(World par1World, int par2, int par3, int par4, Random random)
	    {
			
		 par1World.notifyBlocksOfNeighborChange(par2 - 1, par3, par4, this.blockID);
         par1World.notifyBlocksOfNeighborChange(par2 + 1, par3, par4, this.blockID);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 - 1, this.blockID);
         par1World.notifyBlocksOfNeighborChange(par2, par3, par4 + 1, this.blockID);
         par1World.notifyBlocksOfNeighborChange(par2, par3 - 1, par4, this.blockID);
         par1World.notifyBlocksOfNeighborChange(par2, par3 + 1, par4, this.blockID);
			par1World.scheduleBlockUpdate(par2, par3, par4, blockID, tickRate());
			
	    }

	 
	 
	 @Override
	    public void registerIcons(IconRegister par1IconRegister)
	    {
	        this.iconList[0] = par1IconRegister.registerIcon("MysticAdditions:mysticbudfront");
	        this.iconList[1] = par1IconRegister.registerIcon("MysticAdditions:mysticblocksiding");
	    }
	
}

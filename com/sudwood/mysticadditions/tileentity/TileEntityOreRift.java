package com.sudwood.mysticadditions.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.Ticket;
import net.minecraftforge.common.ForgeChunkManager.Type;

import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.MysticEnergy;
import com.sudwood.mysticadditions.TransferHelper;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeable;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeableArmor;
import com.sudwood.mysticadditions.items.energy.ItemMarkRecallMRK2;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityOreRift extends TileEntityMysticEnergy implements IInventory{
	private int[] coords = {42,42,42};
	private Ticket chunkTicket;
	private Ticket miningTicket;
	private int[] connectors = {42,42,42,42,42,42};
	private boolean isFull = false;
	public static int numberDrawing = 0;
	public int spinCount = 0;
	private int[] teleportedPowerCoords={0,0,0};
	private boolean hasStarted = false;
	public float rotationAngle = 0F;
	public double efficiencyLevel = 4;
	private ItemStack[] inventory = new ItemStack[20];
	public boolean isRunning = false;
	private boolean isGettingPowered = false;
	private int xSize = 0;
	private int zSize = 0;
	private boolean hasChest = false;
	private boolean hasRun = false;
	private int currentChunkX = 0;
	private int currentChunkZ = 0;
	private int mining[] = new int[3];
	private boolean isLoadingMining = false;
	private boolean negX = false;
	private boolean negZ = false;
	public int timeTillComplete = 0;
	private int ignoredBlocks[] = {Block.bedrock.blockID, Block.waterMoving.blockID, Block.waterStill.blockID, Block.lavaMoving.blockID, Block.lavaStill.blockID, Block.dirt.blockID, Block.cobblestone.blockID, Block.stone.blockID, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	public TileEntityOreRift(int maxEnergy)
	{
		super(maxEnergy);
	}
	public TileEntityOreRift()
	{
		super(524288);
	}
	
	public void setIsGettingPowered(boolean bool)
	{
		isGettingPowered = bool;
	}
	
	public boolean canUpdate(){
		   return true;
	   }
	
	public int getMaxEnergy()
	{
		return this.maxEnergyLevel;
	}
	
	
	public void readFromNBT(NBTTagCompound tag)
    {
		
        super.readFromNBT(tag);
        efficiencyLevel = tag.getDouble("EfficiencyLevel");
        energyLevel = tag.getInteger("energyLevel");
        connectors = tag.getIntArray("connectors");
        coords = tag.getIntArray("coordinates");
        isFull = tag.getBoolean("isFull");
        this.coords0 = tag.getIntArray("coordinates0");
        this.coords1 = tag.getIntArray("coordinates1");
        this.coords2 = tag.getIntArray("coordinates2");
        this.coords3 = tag.getIntArray("coordinates3");
        this.coords4 = tag.getIntArray("coordinated4");
        this.activeConnections = tag.getIntArray("activeconnections");
        teleportedPowerCoords = tag.getIntArray("teleportedPowerCoords");
        isGettingTeleportedPower = tag.getBoolean("isGettingTeleportedPower");
        numberDrawing = tag.getInteger("numberDrawing");
        isRunning = tag.getBoolean("isRunning");
        isGettingPowered = tag.getBoolean("isGettingPowered");
        xSize = tag.getInteger("xSize");
        zSize = tag.getInteger("zSize");
        hasChest = tag.getBoolean("hasChest");
        hasRun = tag.getBoolean("hasRun");
        currentChunkX = tag.getInteger("currentChunkX");
        currentChunkZ = tag.getInteger("currentChunkZ");
        mining = tag.getIntArray("miningCoords");
        isLoadingMining = tag.getBoolean("isLoadingMining");
        ignoredBlocks = tag.getIntArray("ignoredBlocks");
        negX = tag.getBoolean("negX");
        negZ = tag.getBoolean("negZ");
        timeTillComplete = tag.getInteger("timeTillComplete");
        NBTTagList var2 = tag.getTagList("Items");
        this.inventory = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.inventory.length)
            {
                this.inventory[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
    }


	
	public void setIsGettingTeleportedPower(boolean bool)
	{
		isGettingTeleportedPower = bool;
	}

	
	public void setCoords()
	{
		coords[0]=this.xCoord;
		coords[1]=this.yCoord;
		coords[2]=this.zCoord;
	}
	public void setConnectors(int[] connector)
	{
		connectors = connector;
	}
	public void setEnergyLevel(double d){
		
		energyLevel = (int) d;
	}
	public int getEnergyLevel()
	{
		return energyLevel;
	}
	
	  @SideOnly(Side.CLIENT)
		 public int getCookProgressScaled(int par1)
		    {
		        return this.energyLevel * par1 / this.maxEnergyLevel;
		    }

	 public void writeToNBT(NBTTagCompound tag)
	    {
	        super.writeToNBT(tag);
	        tag.setDouble("EfficiencyLevel", efficiencyLevel);
	        tag.setInteger("energyLevel", energyLevel);
	        tag.setIntArray("connectors", connectors);
	        tag.setIntArray("coordinates", coords);
	        tag.setIntArray("coordinates0", coords0);
	        tag.setIntArray("coordinates1", coords1);
	        tag.setIntArray("coordinates2", coords2);
	        tag.setIntArray("coordinates3", coords3);
	        tag.setIntArray("coordinates4", coords4);
	        tag.setIntArray("activeconnections", activeConnections);
	        tag.setBoolean("isFull", isFull);
	        tag.setIntArray("teleportedPowerCoords", teleportedPowerCoords);
	        tag.setBoolean("isGettingTeleportedPower", isGettingTeleportedPower); 
	        tag.setInteger("numberDrawing", numberDrawing);
	        tag.setBoolean("isRunning", isRunning);
	        tag.setBoolean("isGettingPowered", isGettingPowered);
	        tag.setInteger("xSize", xSize);
	        tag.setInteger("zSize", zSize);
	        tag.setBoolean("hasChest", hasChest);
	        tag.setBoolean("hasRun", hasRun);
	        tag.setInteger("xSize", xSize);
	        tag.setInteger("zSize", zSize);
	        tag.setIntArray("miningCoords", mining);
	        tag.setBoolean("isLoadingMining", isLoadingMining);
	        tag.setIntArray("ignoredBlocks", ignoredBlocks);
	        tag.setBoolean("negX", negX);
	        tag.setBoolean("negZ", negZ);
	        tag.setInteger("timeTillComplete", timeTillComplete);
	        NBTTagList var2 = new NBTTagList();

	        for (int var3 = 0; var3 < this.inventory.length; ++var3)
	        {
	            if (this.inventory[var3] != null)
	            {
	                NBTTagCompound var4 = new NBTTagCompound();
	                var4.setByte("Slot", (byte)var3);
	                this.inventory[var3].writeToNBT(var4);
	                var2.appendTag(var4);
	            }
	        }
	       tag.setTag("Items", var2);
	       
	    }

	 public void updateEntity()
	    {
			 if(!worldObj.isRemote)
				 this.getEnergyTeleported();
			 
			 if(MysticAdditions.areAnimations)
			 {
				 rotationAngle+=0.25F;
				 if(rotationAngle>=6.28)
					 rotationAngle=0F;
			 }
			 if(energyLevel > 64 && !isRunning && isGettingPowered && worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord) instanceof IInventory)
			 {
				 isRunning = true;
			 }
			 if(!isGettingPowered || energyLevel<= 64 || !(worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord) instanceof IInventory))
			 {
				 isRunning = false;
			 }
			 if(isRunning)
			 {
				 this.energyLevel-=64;
				 if(!hasRun&& inventory[0]!=null && inventory[1]!=null)
				 {
					 xSize = inventory[0].stackSize;
					 zSize = inventory[1].stackSize;
					 hasRun = true;
					 mining[0] = xCoord;
					 mining[1] = yCoord;
					 mining[2] = zCoord;
					 if(inventory[2]!=null&&inventory[2].itemID == Item.redstone.itemID)
					 {
						 negX = true;
						 xSize = -xSize;
						 System.out.println(xSize);
					 }
					 if(inventory[3]!=null&&inventory[3].itemID == Item.redstone.itemID)
					 {
						 negZ = true;
						 zSize = -zSize;
						 System.out.println(zSize);
					 }
					 
					 timeTillComplete = (Math.abs(xSize)+1)*(Math.abs(zSize)+1)*yCoord+yCoord;
					 for(int i = 4; i < 20; i++)
					 {
						 if(inventory[i] == null)
							 break;
						 else if(inventory[i].getItem() instanceof ItemBlock)
						 {
							 ignoredBlocks[(i-2)+8] = ((ItemBlock)inventory[i].getItem()).getBlockID();
						 }
					 }
				 }
				 spinCount++;
				 if(spinCount > 7)
					 spinCount = 0;
				 
				 if(!worldObj.isRemote)
				 {
					 if(mining[2] == zCoord+zSize)
					 {
						 isRunning=false;
						 return;
					 }
					 timeTillComplete--;
					 //check the chunks that need to be mined -- add a way to keep the ones that have been mined
					 //mine the current chunk that needs mining, keep it loaded. 
					 //unload the minign chunk move to next chunk
					 //never have more then 2 chunks loaded to reduce lag
					 //no 4*4 chunk loading like with buildcraft quarries
					mining[1]--;
					int id = worldObj.getBlockId(mining[0], mining[1], mining[2]);
					{
						ItemStack stack = null;
						for(int i = 0; i < 24; i++)
						{
							if(id==ignoredBlocks[i])
							{
								break;
							}
							else if( i == 23)
							{
								stack = new ItemStack(id, 1, worldObj.getBlockMetadata(mining[0], mining[1], mining[2]));
							}
						}
						if(stack!=null)
						{
							pushItem(stack);
							worldObj.setBlock(mining[0], mining[1], mining[2], 3, 0, 2);
						}
					}
					if(mining[1]<= 0 && xSize != 0 && zSize != 0)
					{
						if(!negZ)
						{
							if(mining[0] == xCoord+xSize)
							{
								if(!negX)
									mining[0] = xCoord -1;
								if(negX)
									mining[0] = xCoord+1;
								mining[2] += 1;
							}
						}
						if(negZ)
						{
							if(mining[0] == xCoord+xSize)
							{
								if(!negX)
									mining[0] = xCoord -1;
								if(negX)
									mining[0] = xCoord+1;
								mining[2] -= 1;
							}
						}
						mining[1] = yCoord;
						if(!negX)
						{
							if(mining[0] < xCoord+xSize)
							{
								mining[0]+=1;
							}
						}
						if(negX)
						{
							if(mining[0] > xCoord+xSize)
							{
								mining[0]-=1;
							}
						}
					}
					if((xCoord>>4) != (mining[0] >> 4) || (zCoord >>4) != (mining[2] >>4) && !isLoadingMining)
					{
						currentChunkX = mining[0] >> 4;
						currentChunkZ = mining[2] >> 4;
						loadMining();
					}
					if((currentChunkX != mining[0] >> 4 || currentChunkZ != mining[2] >>4) && isLoadingMining)
					{
						unloadMining();
						currentChunkX = mining[0] >> 4;
						currentChunkZ = mining[2] >> 4;
						loadMining();
					}
					 
				 }
			 }
		
	    }
	 
	 
		@Override
		 public int getSizeInventory()
	    {
	        return this.inventory.length;
	    }
		@Override
		public ItemStack getStackInSlot(int var1) {
			// TODO Auto-generated method stub
			return this.inventory[var1];
		}
		
		public void checkChest()
		{
			if(worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) instanceof IInventory)
			{
				hasChest = true;
			}
			else
			{
				hasChest = false;
			}
		}
		
		
		@Override
		public ItemStack decrStackSize(int par1, int par2) {
			 if (this.inventory[par1] != null)
		        {
		            ItemStack var3;

		            if (this.inventory[par1].stackSize <= par2)
		            {
		                var3 = this.inventory[par1];
		                this.inventory[par1] = null;
		                return var3;
		            }
		            else
		            {
		                var3 = this.inventory[par1].splitStack(par2);

		                if (this.inventory[par1].stackSize == 0)
		                {
		                    this.inventory[par1] = null;
		                }

		                return var3;
		            }
		        }
		        else
		        {
		            return null;
		        }
		}
		@Override
		public ItemStack getStackInSlotOnClosing(int var1) {
			if (this.inventory[var1] != null)
	        {
	            ItemStack var2 = this.inventory[var1];
	            this.inventory[var1] = null;
	            return var2;
	        }
	        else
	        {
	            return null;
	        }
		}
		@Override
		public void setInventorySlotContents(int var1, ItemStack var2) {
			this.inventory[var1] = var2;

	        if (var2 != null && var2.stackSize > this.getInventoryStackLimit())
	        {
	            var2.stackSize = this.getInventoryStackLimit();
	        }
			
		}
		@Override
		public String getInvName() {
			// TODO Auto-generated method stub
			return "Ore Rift";
		}
		@Override
		public int getInventoryStackLimit() {
			// TODO Auto-generated method stub
			return 64;
		}
		@Override
		public boolean isUseableByPlayer(EntityPlayer var1) {
			// TODO Auto-generated method stub
			return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : var1.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
		}
		@Override
		public void openChest() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void closeChest() {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean isInvNameLocalized() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean isItemValidForSlot(int i, ItemStack itemstack) {
			// TODO Auto-generated method stub
			if (i==0||i==1)
				return true;
			else 
				return false;
		}
		
		public void loadChunks()
		{
			 if(chunkTicket == null)
			 {
				 chunkTicket = ForgeChunkManager.requestTicket(MysticAdditions.instance, worldObj, Type.NORMAL);
			 }
			 chunkTicket.getModData().setInteger("blockX", xCoord);
			 chunkTicket.getModData().setInteger("blocky", yCoord);
			 chunkTicket.getModData().setInteger("blockz", zCoord);
			 chunkTicket.getModData().setInteger("type", 0);
			
			 ForgeChunkManager.forceChunk(chunkTicket, new ChunkCoordIntPair(xCoord>>4, zCoord >>4));
		 }
		 
		 public void unloadChunks()
		 {
			 ForgeChunkManager.unforceChunk(chunkTicket, new ChunkCoordIntPair(xCoord>>4, zCoord >>4));
		 }
		 public void loadTicket(Ticket ticket)
		 {
			 if (chunkTicket == null) {
					chunkTicket = ticket;
				}
			 ChunkCoordIntPair loadChunk = new ChunkCoordIntPair(xCoord >> 4, zCoord >> 4);
			 ForgeChunkManager.forceChunk(ticket, loadChunk);
		 }
		 
		 public void loadMining()
		 {
			 if(miningTicket == null)
			 {
				 miningTicket = ForgeChunkManager.requestTicket(MysticAdditions.instance, worldObj, Type.NORMAL);
			 }
			 miningTicket.getModData().setInteger("blockX", xCoord);
			 miningTicket.getModData().setInteger("blocky", yCoord);
			 miningTicket.getModData().setInteger("blockz", zCoord);
			 miningTicket.getModData().setInteger("type", 1);
			 isLoadingMining = true;
			 ForgeChunkManager.forceChunk(miningTicket, new ChunkCoordIntPair(currentChunkX, currentChunkZ));
		 }
		 public void loadMining(Ticket ticket)
		 {
			 if (miningTicket == null) {
					miningTicket = ticket;
				}
			 ChunkCoordIntPair loadChunk = new ChunkCoordIntPair(currentChunkX, currentChunkZ);
			 isLoadingMining = true;
			 ForgeChunkManager.forceChunk(ticket, loadChunk);
		 }
		 public void unloadMining()
		 {
			 ForgeChunkManager.unforceChunk(miningTicket, new ChunkCoordIntPair(currentChunkX, currentChunkZ));
			 isLoadingMining = false;
		 }
		
		 public void pushItem(ItemStack item)
		 {
	    	int[] slot = null;
	    		IInventory transfer = null;
	    			slot = TransferHelper.checkSpace(xCoord, yCoord+1, zCoord, new ItemStack(item.getItem(), 1, item.getItemDamage()), worldObj, 0);
	    			try
	    			{
	    				transfer = (IInventory) worldObj.getBlockTileEntity(xCoord, yCoord+1, zCoord);
	    			}
	    			catch(Exception e)
	    			{
	    				
	    			}
	  
	    		if(slot!=null && transfer!= null)
	    		{	
	    			if(slot[1] == 0)
	    			{
	    				transfer.setInventorySlotContents(slot[0], new ItemStack(item.getItem(), 1, item.getItemDamage()));
	    				transfer.onInventoryChanged();
	    				return;
	    			}
	    			if(slot[1] == 1 && transfer.getStackInSlot(slot[0]).stackSize < transfer.getInventoryStackLimit())
	    			{
		    				transfer.setInventorySlotContents(slot[0], new ItemStack(item.getItem(), transfer.getStackInSlot(slot[0]).stackSize+1, item.getItemDamage()));
		    				transfer.onInventoryChanged();
		    				return;
	    				
	    			}
	    			
	    		}
		    		
		  }
		    	
		    
}



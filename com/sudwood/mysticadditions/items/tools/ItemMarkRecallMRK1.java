package com.sudwood.mysticadditions.items.tools;

import java.util.List;

import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.mod_MysticAdditions;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemMarkRecallMRK1 extends Item {

	Integer x = 0;
	Integer y = 0;
	Integer z = 0;
	
	boolean state = false; // false for mark true for recall
	boolean isSet = false;
	int dimension = 0;
	public ItemMarkRecallMRK1(int par1) {
		super(par1);
		setMaxStackSize(1);
		setMaxDamage(150);
		// TODO Auto-generated constructor stub
	}
	
	 public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	    {
		 if(par1ItemStack.getTagCompound() == null) par1ItemStack.setTagCompound(new NBTTagCompound());
		 NBTTagCompound tag = par1ItemStack.getTagCompound();
		x = tag.getInteger("posX");
		y = tag.getInteger("posY");
		z = tag.getInteger("posZ");
		 if (x!=null&&y!=null&&z!=null){
		 par3List.add("X: "+x.toString());
		 par3List.add("Y: "+y.toString());
		 par3List.add("Z: "+z.toString());
		 par3List.add("Uses :"+(150-par1ItemStack.getItemDamage())+"/150");
		 }
	    }

	 public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
		 if (!par2World.isRemote)
		 {
			 if(par1ItemStack.getTagCompound() == null) par1ItemStack.setTagCompound(new NBTTagCompound());
		 dimension = par2World.getWorldInfo().getDimension();
	     NBTTagCompound tag = par1ItemStack.getTagCompound();
	     state = tag.getBoolean("state");
	     isSet = tag.getBoolean("isSet");
	     x = tag.getInteger("posX");
		 y = tag.getInteger("posY");
		 z = tag.getInteger("posZ");
	        
	      if (par3EntityPlayer.isSneaking()&&!par2World.isRemote)
	      {
	    	  if (state == false)
	    	  {
	    		  
	    		  par3EntityPlayer.sendChatToPlayer("Recall Mode Activated");
	    		  state = true;
	    		  tag.setBoolean("state", state);
	    		  return par1ItemStack;
	    	  }
	    	  if (state==true)
	    	  {
	    		  par3EntityPlayer.sendChatToPlayer("Mark Mode Activated");
	    		  state = false;
	    		  tag.setBoolean("state", state);
	    		  return par1ItemStack;
	    	  }
	    	  
	      }
	      if (!par3EntityPlayer.isSneaking())
	      {
	    	  if(par3EntityPlayer.inventory.hasItem(Item.redstone.itemID))
	    	  {
	    	  if (state == false)
	    	  {
	    		  if (isSet==false)
	    		  {
	    		
	    			
	    		  this.x = (int)par3EntityPlayer.posX;
	    		  this.y = (int)par3EntityPlayer.posY;
	    		  this.z = (int)par3EntityPlayer.posZ;
	    		  par2World.setBlock(x, y, z, mod_MysticAdditions.markblockid);
	    		  par3EntityPlayer.inventory.consumeInventoryItem(Item.redstone.itemID);
	    		  if (par2World.isRemote)
	    		  {
	    		  this.spawnParticle(par2World, "portal", par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, 9.4, 157, 134.3);
	    		  }
	    		  par1ItemStack.damageItem(1, par3EntityPlayer);
	    		  isSet=true;
	    		  tag.setBoolean("isSet", isSet);
	    		  }
	    		  if (isSet==true)
	    		  {
	    			  par2World.setBlock(tag.getInteger("posX"), tag.getInteger("posY"), tag.getInteger("posZ"), 0);
	    			  this.x = (int)par3EntityPlayer.posX;
		    		  this.y = (int)par3EntityPlayer.posY;
		    		  this.z = (int)par3EntityPlayer.posZ;
		    		  par2World.setBlock(x, y, z, mod_MysticAdditions.markblockid);
		    		  par1ItemStack.damageItem(1, par3EntityPlayer);
		    		  par3EntityPlayer.inventory.consumeInventoryItem(Item.redstone.itemID);
		    		  if (par2World.isRemote)
		    		  {
		    		  this.spawnParticle(par2World, "portal", par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, 9.4, 157, 134.3);
		    		  }
	    		  }
	    		  tag.setInteger("posX", x);
	    		  tag.setInteger("posY", y);
	    		  tag.setInteger("posZ", z);
	    	  }
	    	 if (state == true)
	    	 {
	    		 if (x==0&&y==0&&z==0)
	    		 {
	    			 return par1ItemStack;
	    		 }
	    		 par3EntityPlayer.setPositionAndUpdate(x, y, z);
	    		 par3EntityPlayer.fallDistance = 0;
	    		 par3EntityPlayer.inventory.consumeInventoryItem(Item.redstone.itemID);
	    		 par1ItemStack.damageItem(1, par3EntityPlayer);
	    		 if (par2World.isRemote)
	    		  {
	    		  this.spawnParticle(par2World, "portal", par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, 9.4, 157, 134.3);
	    		  }
	    	 }
	      }
	      }
		 }
	        return par1ItemStack;
	    }
	 
	 @SideOnly(Side.CLIENT)
	 public void spawnParticle(World world, String string, double posX, double posY, double posZ, double velx, double vely, double velz)
	 {
		 world.spawnParticle(string, posX, posY, posZ, velx, vely, velz);
	 }
	 @Override
		public void updateIcons(IconRegister iconRegister)
		{
			this.iconIndex = iconRegister.registerIcon("MysticAdditions:markrecallmrk1");
		}
	 
}

package com.sudwood.mysticadditions.items.energy;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.sudwood.mysticadditions.mod_MysticAdditions;

import net.java.games.input.Component.Identifier.Key;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemMarkRecallMRK2 extends IItemMysticRechargeable {
	public Icon[] iconList = new Icon[10];
	public ItemMarkRecallMRK2(int par1, int maxEnergy, int rechargeRate)
	{
		super(par1, maxEnergy, rechargeRate);
		this.setMaxDamage(8);
	}
	
	Integer x = 0;
	Integer y = 0;
	Integer z = 0;
	boolean state = false; // false for mark true for recall
	

	boolean isSet = false;

	Integer dimensionTravel = 0;
	int dimensionIn = 0;
	
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		 if(par1ItemStack.getTagCompound()==null)
		  {
			  par1ItemStack.setTagCompound(new NBTTagCompound());
		  }
		  NBTTagCompound tag = par1ItemStack.getTagCompound();
		  this.currentCharge = tag.getInteger("CurrentCharge");
		  tag.setInteger("MaxStorage", this.maxStorage);
		  this.maxStorage = tag.getInteger("MaxStorage");
		  tag.setInteger("RechargeRate", this.rechargeRatePerTick);
		  this.rechargeRatePerTick = tag.getInteger("RechargeRate");
		  dimensionTravel = tag.getInteger("Dimension");
		  x = tag.getInteger("posX");
			y = tag.getInteger("posY");
			z = tag.getInteger("posZ");
			 if (x!=null&&y!=null&&z!=null){
			 par3List.add("X: "+x.toString());
			 par3List.add("Y: "+y.toString());
			 par3List.add("Z: "+z.toString());
			 par3List.add(this.currentCharge+"/"+this.maxStorage+" MyJ");
			 }
	}
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if (!par2World.isRemote)
		 {
		 if(par1ItemStack.getTagCompound() == null) par1ItemStack.setTagCompound(new NBTTagCompound());
	 dimensionIn = par2World.getWorldInfo().getDimension();
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
    	  if(this.currentCharge<100)
    	  {
    		  par3EntityPlayer.sendChatToPlayer("Not enough charge.");
    		  
    		  return par1ItemStack;
    	  }
    	  if(this.currentCharge>=100)
    	  {
    		  
    	  if (state == false)
    	  {
    		  
    		  if (isSet==true)
    		  {
    			  par2World.setBlock(tag.getInteger("posX"), tag.getInteger("posY"), tag.getInteger("posZ"), 0);
    			  this.x = (int)par3EntityPlayer.posX;
	    		  this.y = (int)par3EntityPlayer.posY;
	    		  this.z = (int)par3EntityPlayer.posZ;
	    		  par2World.setBlock(x, y, z, mod_MysticAdditions.markblockid);
	    		  this.currentCharge-=100;
	    		  
	    		  tag.setInteger("CurrentCharge", this.currentCharge);
	    		
    		  }
    		  if (isSet==false)
    		  {
    		
    			
    		  this.x = (int)par3EntityPlayer.posX;
    		  this.y = (int)par3EntityPlayer.posY;
    		  this.z = (int)par3EntityPlayer.posZ;
    		  par2World.setBlock(x, y, z, mod_MysticAdditions.markblockid);
    		  this.currentCharge-=100;
    		  
    		  tag.setInteger("CurrentCharge", this.currentCharge);
    		  
    		  isSet=true;
    		  tag.setBoolean("isSet", isSet);
    		  
    		  }
    		  
    		  tag.setInteger("posX", x);
    		  tag.setInteger("posY", y);
    		  tag.setInteger("posZ", z);
    		  return par1ItemStack;
    		  
    	  }
    	  if (state == true)
	    	 {
	    		 if (x==0&&y==0&&z==0)
	    		 {
	    			 return par1ItemStack;
	    		 }
	    		 par3EntityPlayer.setPositionAndUpdate(x, y, z);
	    		 par3EntityPlayer.fallDistance = 0;
	    		 this.currentCharge-=100;
	    		 
	   		  tag.setInteger("CurrentCharge", this.currentCharge);
	   		return par1ItemStack;
	    	 }
    	 
      }
      }
	 
	 
	 
		 }
        return par1ItemStack;
    }
	
	
	
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if(!getIsUsable(par1ItemStack))
		{
			this.hasCharged = false;
		}
		this.setItemDamageByCharge(par1ItemStack);
	}
	
	
	@Override
	  public Icon getIconFromDamage(int par1)
	    {
			switch(par1)
			{
			
			case 7: return this.iconList[0];
			case 6: return this.iconList[1];
			case 5: return this.iconList[2];
			case 4: return this.iconList[3];
			case 3: return this.iconList[4];
			case 2: return this.iconList[5];
			case 1: return this.iconList[6];
			case 0: return this.iconList[7];
			default: return this.iconList[0];
			
			}
			
	    }
	
	public void setItemDamageByCharge(ItemStack itemStack)
	{
		
		int oneTenth = this.maxStorage/7;
		  if(this.currentCharge==0)
		  {
			  itemStack.setItemDamage(8);
		  }
		  if(this.currentCharge<oneTenth)
		  {
			  itemStack.setItemDamage(7);
		  }
		  if(this.currentCharge>oneTenth&&this.currentCharge<(oneTenth*2))
		  {
			  itemStack.setItemDamage(6);
		  }
		  if(this.currentCharge>(oneTenth*2)&&this.currentCharge<(oneTenth*3))
		  {
			  itemStack.setItemDamage(5);
		  }
		  if(this.currentCharge>(oneTenth*3)&&this.currentCharge<(oneTenth*4))
		  {
			  itemStack.setItemDamage(4);
		  }
		  if(this.currentCharge>(oneTenth*4)&&this.currentCharge<(oneTenth*5))
		  {
			  itemStack.setItemDamage(3);
		  }
		  if(this.currentCharge>(oneTenth*5)&&this.currentCharge<(oneTenth*6))
		  {
			  itemStack.setItemDamage(2);
		  }
		  if(this.currentCharge>(oneTenth*6)&&this.currentCharge<(oneTenth*7))
		  {
			  itemStack.setItemDamage(1);
		  }
		  
		  
		  if(this.currentCharge==this.maxStorage||this.currentCharge>(oneTenth*7))
		  {
			  itemStack.setItemDamage(0);
		  }
	}
	@Override
	public void updateIcons(IconRegister iconRegister)
	{
	         this.iconList[0] = iconRegister.registerIcon("MysticAdditions:markrecallmrk2-0");
	         this.iconList[1] = iconRegister.registerIcon("MysticAdditions:markrecallmrk2-1");
	         this.iconList[2] = iconRegister.registerIcon("MysticAdditions:markrecallmrk2-2");
	         this.iconList[3] = iconRegister.registerIcon("MysticAdditions:markrecallmrk2-3");
	         this.iconList[4] = iconRegister.registerIcon("MysticAdditions:markrecallmrk2-4");
	         this.iconList[5] = iconRegister.registerIcon("MysticAdditions:markrecallmrk2-5");
	         this.iconList[6] = iconRegister.registerIcon("MysticAdditions:markrecallmrk2-6");
	         this.iconList[7] = iconRegister.registerIcon("MysticAdditions:markrecallmrk2-7");
	         
	}
	
	
	
	
    }


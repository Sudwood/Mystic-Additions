package com.sudwood.mysticadditions.items.energy;

import java.lang.reflect.Constructor;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemCaptureReceptacle extends Item
{
	Icon icons[] = new Icon[2];
	public ItemCaptureReceptacle(int x)
	{
		super(x);
		maxStackSize = 1;	
		this.setMaxDamage(2);
		
		
	}
	@Override
	public void registerIcons(IconRegister iconRegister)
	{
	         icons[0] = iconRegister.registerIcon("MysticAdditions:capturerreceptacleempty");
	         icons[1] = iconRegister.registerIcon("MysticAdditions:capturerreceptaclefull");
	         itemIcon = icons[0];
	}
	public Icon getIconFromDamage(int par1)
    {
		switch(par1)
		{
		case 0:
			return icons[1];
		default:
			return icons[0];
		}
    }
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) 
	{
		boolean hasEntity = false;
		String name = "";
		String health = "";
		if(stack!=null)
		{
			if(stack.getTagCompound() == null)
			{
				stack.setTagCompound(new NBTTagCompound());
			}
			NBTTagCompound tag = stack.getTagCompound();
			hasEntity = tag.getBoolean("hasEntity");
			name = tag.getString("EntityName");
			health = tag.getString("EntityLife");
		}
		String string = "Has Entity: "+hasEntity;
		String string2 = name+" : "+health+" Hearts";
		par3List.add(string);
		par3List.add(string2);

	}
	
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer par2EntityPlayer, EntityLivingBase target)
	{
			if(target!=null&&stack!=null&&target instanceof EntityCreature&&!par2EntityPlayer.worldObj.isRemote)
			{
				return true;
			}
	        return false;
	}
	public void onCreated(ItemStack stack, World par2World, EntityPlayer par3EntityPlayer) 
	{
		if(stack!=null)
		{
			if(stack.getTagCompound() == null)
			{
				stack.setTagCompound(new NBTTagCompound());
			}
			NBTTagCompound tag = stack.getTagCompound();
			tag.setBoolean("hasEntity", false);
			tag.setString("EntityName", "");
			tag.setString("EntityLife", "");
			stack.setItemDamage(1);
		}
	}
	public ItemStack onItemRightClick(ItemStack stack, World par2World, EntityPlayer player)
    {
		if(stack!=null&&!par2World.isRemote)
		{
			System.out.println(par2World.isRemote);
			NBTTagCompound tag = stack.getTagCompound();
			if(tag.getBoolean("hasEntity"))
			{
				try
				{
				Class<?> temp = Class.forName(tag.getString("className"));
				Constructor<?> ctor = temp.getConstructor(World.class);
				EntityCreature ent = (EntityCreature) ctor.newInstance(player.worldObj);
				ent.readEntityFromNBT(tag);
				ent.posX = player.posX;
				ent.posY = player.posY +2;
				ent.posZ = player.posZ;
				par2World.spawnEntityInWorld(ent);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				stack.setItemDamage(0);
			}
		}
		return stack;
    }
}

package com.sudwood.mysticadditions.items.energy;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class ItemCrudeMysticBattery extends IItemMysticRechargeable{
	public Icon[] iconList = new Icon[12];
	public ItemCrudeMysticBattery(int par1, int maxEnergy, int rechargeRate)
	{
		super(par1, maxEnergy, rechargeRate);
	}
	 
	  public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
			if(!getIsUsable(par1ItemStack))
			{
				this.hasCharged = false;
			}
			
		}
	  @Override
	  public Icon getIconFromDamage(int par1)
	    {
			switch(par1)
			{
			case 0: return this.iconList[10];
			case 1: return this.iconList[9];
			case 2: return this.iconList[8];
			case 3: return this.iconList[7];
			case 4: return this.iconList[6];
			case 5: return this.iconList[5];
			case 6: return this.iconList[4];
			case 7: return this.iconList[3];
			case 8: return this.iconList[2];
			case 9: return this.iconList[1];
			case 10: return this.iconList[0];
			case 11: return this.iconList[0];
			default: return this.iconList[0];
			}
			
	    }
	  @Override
		public void updateIcons(IconRegister iconRegister)
		{
		         this.iconList[0] = iconRegister.registerIcon("MysticAdditions:crudebattery0");
		         this.iconList[1] = iconRegister.registerIcon("MysticAdditions:crudebattery1");
		         this.iconList[2] = iconRegister.registerIcon("MysticAdditions:crudebattery2");
		         this.iconList[3] = iconRegister.registerIcon("MysticAdditions:crudebattery3");
		         this.iconList[4] = iconRegister.registerIcon("MysticAdditions:crudebattery4");
		         this.iconList[5] = iconRegister.registerIcon("MysticAdditions:crudebattery5");
		         this.iconList[6] = iconRegister.registerIcon("MysticAdditions:crudebattery6");
		         this.iconList[7] = iconRegister.registerIcon("MysticAdditions:crudebattery7");
		         this.iconList[8] = iconRegister.registerIcon("MysticAdditions:crudebattery8");
		         this.iconList[9] = iconRegister.registerIcon("MysticAdditions:crudebattery9");
		         this.iconList[10] = iconRegister.registerIcon("MysticAdditions:crudebattery10");
		}
}

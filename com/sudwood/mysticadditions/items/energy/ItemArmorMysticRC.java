package com.sudwood.mysticadditions.items.energy;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

import com.sudwood.mysticadditions.items.MysticModItems;

public class ItemArmorMysticRC extends IItemMysticRechargeableArmor{
	protected EnumArmorMaterial material;
	protected int armorpiece;
	
	public ItemArmorMysticRC(int id, EnumArmorMaterial material1, int renderid,int armor, int maxEnergy, int rechargeRate) {
		super(id, material1,renderid,armor, maxEnergy, rechargeRate);
		armorpiece = armor;
		material = material1;
	}

	@Override
	public void registerIcons(IconRegister iconRegister)
	{
    		 if(armorpiece==0)
    		 {
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:rcmystichelm");
    		 }
    		 if(armorpiece==1)
    		 {
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:rcmysticchest");
    		 }
    		 if(armorpiece==2)
    		 {
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:rcmysticlegs");
    		 }
    		 if(armorpiece==3)
    		 {
	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:rcmysticboots");
    		 }
	}
	 @Override
		public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type)
	    {
	        if(itemstack.itemID == MysticModItems.helmMystic.itemID || itemstack.itemID == MysticModItems.chestMystic.itemID || itemstack.itemID == MysticModItems.bootsMystic.itemID)
	        {
	                return "MysticAdditions:textures/mystic_1.png";
	        }
	        if(itemstack.itemID == MysticModItems.legsMystic.itemID)
	        {
	                return "MysticAdditions:textures/mystic_2.png";
	        }
	        return  "MysticAdditions:textures/mystic_1.png";
	    }
  
	
    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.material.getEnchantability();
    }

    /**
     * Return the armor material for this armor item.
     */
    public EnumArmorMaterial getArmorMaterial()
    {
        return this.material;
    }
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        int i = EntityLiving.getArmorPosition(par1ItemStack) - 1;
        ItemStack itemstack1 = par3EntityPlayer.getCurrentArmor(i);

        if (itemstack1 == null)
        {
            par3EntityPlayer.setCurrentItemOrArmor(i + 1, par1ItemStack.copy()); //Forge: Vanilla bug fix associated with fixed setCurrentItemOrArmor indexs for players.
            par1ItemStack.stackSize = 0;
        }

        return par1ItemStack;
    }

    @Override
    public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
    {
    	ItemStack helmet = player.getCurrentItemOrArmor(4);
    	   ItemStack chest = player.getCurrentItemOrArmor(3);
    	   ItemStack legs = player.getCurrentItemOrArmor(2);
    	   ItemStack boots = player.getCurrentItemOrArmor(1);
		if(boots!=null&&boots.getItem()==MysticModItems.bootsMysticRC)
		{
			player.fallDistance = 0;
			player.stepHeight = 1;
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 200,2));
		}
	    if(legs!=null&&legs.getItem()==MysticModItems.legsMysticRC&&player.isSprinting())
	    {
	    	IItemMysticRechargeableArmor item = (IItemMysticRechargeableArmor) legs.getItem();
	    	item.readNBT(legs);
	    	if(MysticModule.getTypeForStack(item.mods[0]) == MysticModule.AIR || MysticModule.getTypeForStack(item.mods[1]) == MysticModule.AIR)
	    	{
	    		if(MysticModule.getTypeForStack(item.mods[0]) == MysticModule.AIR && MysticModule.getTypeForStack(item.mods[1]) == MysticModule.AIR)
	    		{
	    			player.capabilities.setPlayerWalkSpeed(0.0675F*(1+(item.mods[0].stackSize/4))*(1+(item.mods[1].stackSize/4)));
			    	player.jumpMovementFactor = 0.0675F*(1+(item.mods[0].stackSize/4))*(1+(item.mods[1].stackSize/4));
	    		}
	    		else
	    		{
	    			if(MysticModule.getTypeForStack(item.mods[0]) == MysticModule.AIR)
	    			{
	    				player.capabilities.setPlayerWalkSpeed(0.0675F*(1+(item.mods[0].stackSize/2)));
				    	player.jumpMovementFactor = 0.0675F*(1+(item.mods[0].stackSize/4));
	    			}
	    			else if(MysticModule.getTypeForStack(item.mods[1]) == MysticModule.AIR)
	    			{
	    				player.capabilities.setPlayerWalkSpeed(0.0675F*(1+(item.mods[0].stackSize/2)));
				    	player.jumpMovementFactor = 0.0675F*(1+(item.mods[0].stackSize/4));
	    			}
	    		}
	    	}
	    	else
	    	{
		    	player.capabilities.setPlayerWalkSpeed(0.45F);
		    	player.jumpMovementFactor = 0.15F;
	    	}
	    	player.sendPlayerAbilities();
	    	
	    }
	    if(chest!=null&&chest.getItem()==MysticModItems.chestMysticRC)
	    {
	    	player.extinguish();
	    	IItemMysticRechargeableArmor item = (IItemMysticRechargeableArmor) chest.getItem();
	    	item.readNBT(chest);
	    	if(MysticModule.getTypeForStack(item.mods[0]) == MysticModule.AIR || MysticModule.getTypeForStack(item.mods[1]) == MysticModule.AIR)
	    	{
	    		if(MysticModule.getTypeForStack(item.mods[0]) == MysticModule.AIR && MysticModule.getTypeForStack(item.mods[1]) == MysticModule.AIR)
	    		{
	    			player.capabilities.setFlySpeed(0.03F*(1+(item.mods[0].stackSize/2))*(1+(item.mods[1].stackSize/2)));
	    		}
	    		else
	    		{
	    			if(MysticModule.getTypeForStack(item.mods[0]) == MysticModule.AIR)
	    			{
	    				player.capabilities.setFlySpeed(0.03F*(1+(item.mods[0].stackSize/2)));
				    
	    			}
	    			else if(MysticModule.getTypeForStack(item.mods[1]) == MysticModule.AIR)
	    			{
	    				player.capabilities.setFlySpeed(0.03F*(1+(item.mods[0].stackSize/2)));
				    	
	    			}
	    		}
	    	}
	    	else
	    	{

	    	}
	    }
	    if(helmet!=null&&helmet.getItem()==MysticModItems.helmMysticRC)
	    {
	    	
	    	if(player.isInWater()&&player.getActivePotionEffect(Potion.nightVision)==null)
	    	{
	    		
	    		player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 2000,0));
	    	}
	    	if(!player.isInWater())
	    	{
	    		player.removePotionEffect(Potion.nightVision.id);
	    	}
	    	
	    }
    }

	
	
}

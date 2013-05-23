// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package com.sudwood.mysticadditions.items.tools;

import java.util.Random;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;



import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.mod_MysticAdditions;
import com.sudwood.mysticadditions.entity.EntityMysticArrow;
import com.sudwood.mysticadditions.entity.EntityMysticExplosiveArrow;
import com.sudwood.mysticadditions.entity.EntityMysticFireArrow;
import com.sudwood.mysticadditions.entity.EntityMysticFreezeArrow;
import com.sudwood.mysticadditions.entity.EntityMysticLightningArrow;
import com.sudwood.mysticadditions.entity.EntityMysticTeleArrow;
import com.sudwood.mysticadditions.items.MysticModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



// Referenced classes of package net.minecraft.src:
//            Item, EntityPlayer, PlayerCapabilities, InventoryPlayer, 
//            EntityArrow, ItemStack, World, EnumAction

public class ItemMysticBow extends ItemBow 
{

    public ItemMysticBow(int i)
    {
        super(i);
        maxStackSize = 1;
        setMaxDamage(1500);
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack){
    	return true;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack){
    	return EnumRarity.epic;
    }

    public ItemStack onFoodEaten(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        return itemstack;
    }

    public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 0x11940;
    }

    public EnumAction getItemUseAction(ItemStack itemstack)
    {
        return EnumAction.bow;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
    	if(!world.isRemote){
    	NBTTagCompound tag = entityplayer.getEntityData();
		int arrowtypegoingtobefired = tag.getInteger("ArrowToBeFired");
    	boolean var5 = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemstack) > 0;
    	if (arrowtypegoingtobefired == 0){
    		if (var5 || entityplayer.inventory.hasItem(MysticModItems.mysticArrow.itemID))
            {
            int j = getMaxItemUseDuration(itemstack) - 1;
            float f = (float)j / 20F;
            f = (f * f + f * 2.0F) / 3F;
            if((double)f < 0.10000000000000001D)
            {
                return itemstack;
            }
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            EntityMysticArrow entityarrow = new EntityMysticArrow(world, entityplayer, 7F);
            if(f == 1.0F)
            {
                entityarrow.arrowCritical = true;
            }
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            entityplayer.inventory.consumeInventoryItem(MysticModItems.mysticArrow.itemID);
            if(!world.isRemote)
            {
                world.spawnEntityInWorld(entityarrow);
            }}}
    	if (arrowtypegoingtobefired == 1){
    		if (var5 || entityplayer.inventory.hasItem(MysticModItems.mysticTeleArrow.itemID))
            {
            int j = getMaxItemUseDuration(itemstack) - 1;
            float f = (float)j / 20F;
            f = (f * f + f * 2.0F) / 3F;
            if((double)f < 0.10000000000000001D)
            {
                return itemstack;
            }
            if(f > 1.0F)
            {
                f = 1.0F;
            }
           
            if(f == 1.0F)
            {
               
            }
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            entityplayer.inventory.consumeInventoryItem(MysticModItems.mysticTeleArrow.itemID);
            if(!world.isRemote)
            {
                world.spawnEntityInWorld( new EntityMysticTeleArrow(world, entityplayer, 3F));
            }}}
    	if (arrowtypegoingtobefired == 2){
    		if (var5 || entityplayer.inventory.hasItem(MysticModItems.mysticExplosiveArrow.itemID))
            {
            int j = getMaxItemUseDuration(itemstack) - 1;
            float f = (float)j / 20F;
            f = (f * f + f * 2.0F) / 3F;
            if((double)f < 0.10000000000000001D)
            {
                return itemstack;
            }
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            EntityMysticExplosiveArrow entityarrow = new EntityMysticExplosiveArrow(world, entityplayer, 2F);
            if(f == 1.0F)
            {
                entityarrow.arrowCritical = true;
            }
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            entityplayer.inventory.consumeInventoryItem(MysticModItems.mysticExplosiveArrow.itemID);
            if(!world.isRemote)
            {
                world.spawnEntityInWorld(entityarrow);
            }}}
    	if (arrowtypegoingtobefired == 3){
    		if (var5 || entityplayer.inventory.hasItem(MysticModItems.mysticFireArrow.itemID))
            {
            int j = getMaxItemUseDuration(itemstack) - 1;
            float f = (float)j / 20F;
            f = (f * f + f * 2.0F) / 3F;
            if((double)f < 0.10000000000000001D)
            {
                return itemstack;
            }
            if(f > 1.0F)
            {
                f = 1.0F;
            }
            EntityMysticFireArrow entityarrow = new EntityMysticFireArrow(world, entityplayer, 3F);
            if(f == 1.0F)
            {
                entityarrow.arrowCritical = true;
            }
            itemstack.damageItem(1, entityplayer);
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            entityplayer.inventory.consumeInventoryItem(MysticModItems.mysticFireArrow.itemID);
            if(!world.isRemote)
            {
                world.spawnEntityInWorld(entityarrow);
            }}}
    	if (arrowtypegoingtobefired == 4){
    		if (var5 || entityplayer.inventory.hasItem(Item.arrow.itemID))
            {
                int j = getMaxItemUseDuration(itemstack) - 1;
                float f = (float)j / 20F;
                f = (f * f + f * 2.0F) / 3F;
                if((double)f < 0.10000000000000001D)
                {
                    return itemstack;
                }
                if(f > 1.0F)
                {
                    f = 1.0F;
                }
                EntityArrow entityarrow = new EntityArrow(world, entityplayer, 4F);
                if(f == 1.0F)
                {
                   // entityarrow.arrowCritical = true;
                }
                itemstack.damageItem(1, entityplayer);
                world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                entityplayer.inventory.consumeInventoryItem(Item.arrow.itemID);
                if(!world.isRemote)
                {
                    world.spawnEntityInWorld(entityarrow);
                }}}
    	if (arrowtypegoingtobefired == 5){
    		if (var5 || entityplayer.inventory.hasItem(MysticModItems.mysticFreezeArrow.itemID))
            {
                int j = getMaxItemUseDuration(itemstack) - 1;
                float f = (float)j / 20F;
                f = (f * f + f * 2.0F) / 3F;
                if((double)f < 0.10000000000000001D)
                {
                    return itemstack;
                }
                if(f > 1.0F)
                {
                    f = 1.0F;
                }
                EntityMysticFreezeArrow entityarrow = new EntityMysticFreezeArrow(world, entityplayer, 1F);
                if(f == 1.0F)
                {
                   // entityarrow.arrowCritical = true;
                }
                itemstack.damageItem(1, entityplayer);
                world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                entityplayer.inventory.consumeInventoryItem(MysticModItems.mysticFreezeArrow.itemID);
                if(!world.isRemote)
                {
                    world.spawnEntityInWorld(entityarrow);
                }}}
    	if (arrowtypegoingtobefired == 6){
    		if (var5 || entityplayer.inventory.hasItem(MysticModItems.mysticLightningArrow.itemID))
            {
                int j = getMaxItemUseDuration(itemstack) - 1;
                float f = (float)j / 20F;
                f = (f * f + f * 2.0F) / 3F;
                if((double)f < 0.10000000000000001D)
                {
                    return itemstack;
                }
                if(f > 1.0F)
                {
                    f = 1.0F;
                }
                EntityMysticLightningArrow entityarrow = new EntityMysticLightningArrow(world, entityplayer, 1.5F);
                if(f == 1.0F)
                {
                   // entityarrow.arrowCritical = true;
                }
                itemstack.damageItem(1, entityplayer);
                world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                entityplayer.inventory.consumeInventoryItem(MysticModItems.mysticLightningArrow.itemID);
                if(!world.isRemote)
                {
                    world.spawnEntityInWorld(entityarrow);
                }}}
		return itemstack;
    	}
		return itemstack;
           }
    	


    	
    @Override
	public void updateIcons(IconRegister iconRegister)
	{
		this.iconIndex = iconRegister.registerIcon("MysticAdditions:mysticbow");
	}
}

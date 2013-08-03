package com.sudwood.mysticadditions.entity;

import java.util.Calendar;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.blocks.MysticModBlocks;
import com.sudwood.mysticadditions.items.MysticModItems;


public class EntityMysticKnight extends EntityMob
{
    public EntityMysticKnight(World par1World)
    {
        super(par1World);
       // this.texture = "/mods/MysticAdditions/mysticknight.png";
        this.setAIMoveSpeed(0.5F);
      
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIBreakDoor(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.5F, false));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, 0.5F, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 0.5F));
        this.tasks.addTask(5, new EntityAIMoveThroughVillage(this, 0.5F, false));
        this.tasks.addTask(6, new EntityAIWander(this, 0.5F));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
    }

    public int getMaxHealth()
    {
        return 40;
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue()
    {
        return 4;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote)
        {
            float var1 = this.getBrightness(1.0F);

            /*if (var1 > 0.5F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) && this.rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F)
            {
                this.setFire(8);
            }*/
        }

        super.onLivingUpdate();
    }

 
    
    public int getAttackStrength(Entity par1Entity)
    {
    return 50;
    }
    
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.redeadmoan";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.redeadhit";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.redeaddie";
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return MysticModItems.swordCSteel.itemID;
    }

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    protected void dropRareDrop(int par1)
    {
        switch (this.rand.nextInt(50))
        {
            case 0:
                this.dropItem(MysticModBlocks.cSteelBlock.blockID, 1);
                break;

            case 1:
                this.dropItem(MysticModItems.helmCSteel.itemID, 1);
                break;

            case 2:
                this.dropItem(MysticModItems.cSteelIngot.itemID, 1);
                break;

            case 3:
                this.dropItem(MysticModItems.shovelCSteel.itemID, 1);
        }
    }
    public ItemStack getHeldItem()
        {
                return defaultHeldItem;
        }
                
                static
        {
                defaultHeldItem = new ItemStack(MysticModItems.swordCSteel, 1);
        }
                
        private static final ItemStack defaultHeldItem;

public void initCreature()
{
	 this.setCanPickUpLoot(this.rand.nextFloat() < 20);
     this.addRandomArmor();
   // this.func_82162_bC();

    if (this.getCurrentItemOrArmor(4) == null)
    {
        Calendar var1 = this.worldObj.getCurrentDate();

        if (var1.get(2) + 1 == 10 && var1.get(5) == 31 && this.rand.nextFloat() < 0.25F)
        {
            this.setCurrentItemOrArmor(4, new ItemStack(this.rand.nextFloat() < 0.1F ? Block.pumpkinLantern : Block.pumpkin));
            this.equipmentDropChances[4] = 0.0F;
        }
    }
}
}

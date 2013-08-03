package com.sudwood.mysticadditions.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Calendar;
import java.util.Random;

import com.sudwood.mysticadditions.items.MysticModItems;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;

public class EntityMysticArcher extends EntityMob implements IRangedAttackMob
{
    private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 0.25F, 60, 10.0F);
    private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.31F, false);

    public EntityMysticArcher(World par1World)
    {
        super(par1World);
       // this.texture = "/mods/MysticAdditions/mysticknight.png";
        this.setAIMoveSpeed(0.35F);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIRestrictSun(this));
        this.tasks.addTask(3, new EntityAIFleeSun(this, 0.35F));
        this.tasks.addTask(5, new EntityAIWander(this, 0.35F));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));

        if (par1World != null && !par1World.isRemote)
        {
            this.func_85036_m();
        }
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(13, new Byte((byte)0));
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    public int getMaxHealth()
    {
        return 30;
    }

    public int getTotalArmorValue()
    {
        return 4;
    }
    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.skeleton.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.skeleton.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.skeleton.death";
    }

  

    

 
    public ItemStack getHeldItem()
    {
    	return new ItemStack(MysticModItems.mysticBow, 1);
    }
    

    /**
     * Get this Entity's EnumCreatureAttribute
     */
    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
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

            if (var1 > 0.5F && this.rand.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
            {
                boolean var2 = true;
                ItemStack var3 = this.getCurrentItemOrArmor(4);

                if (var3 != null)
                {
                    if (var3.isItemStackDamageable())
                    {
                        var3.setItemDamage(var3.getItemDamageForDisplay() + this.rand.nextInt(2));

                        if (var3.getItemDamageForDisplay() >= var3.getMaxDamage())
                        {
                            this.renderBrokenItemStack(var3);
                            this.setCurrentItemOrArmor(4, (ItemStack)null);
                        }
                    }

                    var2 = false;
                }

                if (var2)
                {
                  //  this.setFire(8);
                }
            }
        }

        super.onLivingUpdate();
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource par1DamageSource)
    {
        super.onDeath(par1DamageSource);

        if (par1DamageSource.getSourceOfDamage() instanceof EntityArrow && par1DamageSource.getEntity() instanceof EntityPlayer)
        {
            EntityPlayer var2 = (EntityPlayer)par1DamageSource.getEntity();
            double var3 = var2.posX - this.posX;
            double var5 = var2.posZ - this.posZ;

            if (var3 * var3 + var5 * var5 >= 2500.0D)
            {
                var2.triggerAchievement(AchievementList.snipeSkeleton);
            }
        }
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return MysticModItems.mysticArrow.itemID;
    }

    /**
     * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
     * par2 - Level of Looting used to kill this mob.
     */
    protected void dropFewItems(boolean par1, int par2)
    {
        int var3;
        int var4;

        
        
            var3 = this.rand.nextInt(3 + par2);

            for (var4 = 0; var4 < var3; ++var4)
            {
                this.dropItem(MysticModItems.mysticArrow.itemID, 1);
            }
        

        var3 = this.rand.nextInt(3 + par2);

        for (var4 = 0; var4 < var3; ++var4)
        {
            this.dropItem(MysticModItems.mysticFireArrow.itemID, 1);
        }
}

    protected void dropRareDrop(int par1)
    {
        
            this.entityDropItem(new ItemStack(MysticModItems.mysticBow, 800, 1), 0.0F);
        
    }

    protected void func_82164_bB()
    {
        super.addRandomArmor();
        this.setCurrentItemOrArmor(0, new ItemStack(Item.bow));
    }

 

  
   

    /**
     * Initialize this creature.
     */
    public void initCreature()
    {
       
            this.tasks.addTask(4, this.aiArrowAttack);
            this.func_82164_bB();
           // this.func_82162_bC();
        

            this.setCanPickUpLoot(this.rand.nextFloat() < 20);
        	this.addRandomArmor();
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

    public void func_85036_m()
    {
      
        this.tasks.removeTask(this.aiArrowAttack);
        ItemStack var1 = this.getHeldItem();

        if (var1 != null && var1.itemID == MysticModItems.mysticBow.itemID)
        {
            this.tasks.addTask(4, this.aiArrowAttack);
        }
       
    }

    /**
     * Attack the specified entity using a ranged attack.
     */
    public void attackEntityWithRangedAttack(EntityLiving par1EntityLiving, float f)
    {
    	Random rand = new Random();
    	if(rand.nextInt(3)==0){
        EntityMysticFireArrow var2 = new EntityMysticFireArrow(this.worldObj, this,par1EntityLiving, (float)5F, (float)12.0F);
       
        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(var2);
    	}
    	if(rand.nextInt(3)==1){
            EntityMysticFreezeArrow var2 = new EntityMysticFreezeArrow(this.worldObj,this, par1EntityLiving, 2.5F, 12.0F);
            

            this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
            this.worldObj.spawnEntityInWorld(var2);
        	}
    	if(rand.nextInt(3)==2){
            EntityMysticLightningArrow var2 = new EntityMysticLightningArrow(this.worldObj,this, par1EntityLiving, 3F, 12.0F);
            

            this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
            this.worldObj.spawnEntityInWorld(var2);
        	}
    }

   

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);

        if (par1NBTTagCompound.hasKey("SkeletonType"))
        {
            byte var2 = par1NBTTagCompound.getByte("SkeletonType");
            
        }

        this.func_85036_m();
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        
    }

    /**
     * Sets the held item, or an armor slot. Slot 0 is held item. Slot 1-4 is armor. Params: Item, slot
     */
    public void setCurrentItemOrArmor(int par1, ItemStack par2ItemStack)
    {
        super.setCurrentItemOrArmor(par1, par2ItemStack);

        if (!this.worldObj.isRemote && par1 == 0)
        {
            this.func_85036_m();
        }
    }

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase entitylivingbase,
			float f) {
		// TODO Auto-generated method stub
		
	}

	
}

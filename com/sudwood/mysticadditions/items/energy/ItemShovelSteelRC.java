package com.sudwood.mysticadditions.items.energy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ItemShovelSteelRC extends IItemMysticRechargeable {

	  public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};
	 private EnumToolMaterial toolMaterial;
	 private float efficiencyOnProperMaterial;
	 public final float KNOCKBACK = 1.4F;
	 
	 public ItemShovelSteelRC(int i, EnumToolMaterial enumtoolmaterial, int maxStorage, int rechargeRate)
    {
       super(i, maxStorage, rechargeRate) ;
       toolMaterial = enumtoolmaterial;
       this.efficiencyOnProperMaterial = enumtoolmaterial.getEfficiencyOnProperMaterial();
    }
	 
    @Override
   	public void registerIcons(IconRegister iconRegister)
   	{
   		this.itemIcon = iconRegister.registerIcon("MysticAdditions:steelshovelrc");
   	}
    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block == Block.snow ? true : par1Block == Block.blockSnow;
    }

    
    /** FORGE: Overridden to allow custom tool effectiveness */
    @Override
    public float getStrVsBlock(ItemStack stack, Block block, int meta) 
    {
        if (ForgeHooks.isToolEffective(stack, block, meta))
        {
        	double temp = efficiencyOnProperMaterial;
        	if(MysticModule.getTypeForStack(mods[0])== MysticModule.AIR)
        		temp *=(1.1*mods[0].stackSize);
        	if(MysticModule.getTypeForStack(mods[1])== MysticModule.AIR)
        		temp *=(1.1*mods[0].stackSize);
            return (float) temp;
        }
        return getStrVsBlock(stack, block);
    }
    
    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	 NBTTagCompound tag = par1ItemStack.getTagCompound();
      	 this.currentCharge = tag.getInteger("CurrentCharge");
      	 if(this.currentCharge>=48)
      	 {
      	 this.currentCharge-=48;
      	 tag.setInteger("CurrentCharge", this.currentCharge);
      	 this.doModuleHitAdditions(par2EntityLivingBase, par3EntityLivingBase);
      	 par2EntityLivingBase.addVelocity((double)(-MathHelper.sin(par3EntityLivingBase.rotationYaw * (float)Math.PI / 180.0F) * (float)KNOCKBACK * 0.5F), 0.1D, (double)(MathHelper.cos(par3EntityLivingBase.rotationYaw * (float)Math.PI / 180.0F) * (float)KNOCKBACK * 0.5F));
      	 par2EntityLivingBase.attackEntityFrom(DamageSource.anvil, 3);
      	 return false;
      	 }
        return false;
    }
    
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
    	if(par1ItemStack.getTagCompound()==null)
		  {
			  par1ItemStack.setTagCompound(new NBTTagCompound());
		  }
    	 NBTTagCompound tag = par1ItemStack.getTagCompound();
    	 this.currentCharge = tag.getInteger("CurrentCharge");
    	 
    	 if(this.currentCharge>=20)
    	 {
	      	 this.currentCharge -= 20;
	      	 tag.setInteger("CurrentCharge", this.currentCharge);
	      	 return true;
    	 }
    	 else return false;

    }
	
    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }
    
    
    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return this.toolMaterial.getEnchantability();
    }

    /**
     * Return the name for this tool's material.
     */
    public String getToolMaterialName()
    {
        return this.toolMaterial.toString();
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return this.toolMaterial.getToolCraftingMaterial() == par2ItemStack.itemID ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
    
    
    public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player)
    {
    	if(itemstack.getTagCompound()==null)
		  {
			  itemstack.setTagCompound(new NBTTagCompound());
		  }
	  	NBTTagCompound tag = itemstack.getTagCompound();
	   	 this.currentCharge = tag.getInteger("CurrentCharge");
	   	 if(this.currentCharge<20)
	   	 {
		      	 return true;
	   	 }
	  	 else return false;
    }
	
	
}

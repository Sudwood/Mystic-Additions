package com.sudwood.mysticadditions.items.energy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ItemShovelSteelRC extends IItemMysticRechargeable {

	  public static final Block[] blocksEffectiveAgainst = new Block[] {Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium};
	 private EnumToolMaterial toolMaterial;
	 private float efficiencyOnProperMaterial;
	 
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
            return efficiencyOnProperMaterial;
        }
        return getStrVsBlock(stack, block);
    }
    
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
    	
    	if(stack.getTagCompound()==null)
		  {
			  stack.setTagCompound(new NBTTagCompound());
		  }
  	 NBTTagCompound tag = stack.getTagCompound();
  	 this.currentCharge = tag.getInteger("CurrentCharge");
  	 if(this.currentCharge>=48)
  	 {
  	
  	 return false;
  	 }
  	 else
  	 {
  		 
  		 return true;
  	 }
    }
    
    
    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
    	 if(par1ItemStack.getTagCompound()==null)
		  {
			  par1ItemStack.setTagCompound(new NBTTagCompound());
		  }
    	 NBTTagCompound tag = par1ItemStack.getTagCompound();
    	 this.currentCharge = tag.getInteger("CurrentCharge");
    	 if(this.currentCharge>=48)
    	 {
    	 this.currentCharge-=48;
    	 tag.setInteger("CurrentCharge", this.currentCharge);
    	 return true;
    	 }
    	 else return false;
       
    }
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving)
    {
        if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
        {
        	if(par1ItemStack.getTagCompound()==null)
  		  {
  			  par1ItemStack.setTagCompound(new NBTTagCompound());
  		  }
      	 NBTTagCompound tag = par1ItemStack.getTagCompound();
      	 this.currentCharge = tag.getInteger("CurrentCharge");
      	 if(this.currentCharge>=10)
      	 {
      	 this.currentCharge-=10;
      	 tag.setInteger("CurrentCharge", this.currentCharge);
      	 return true;
      	 }
      	 else return false;
      	 
        }

        return true;
    }
    /**
     * Returns the damage against a given entity.
     */
    public int getDamageVsEntity(Entity par1Entity)
    {
        return 2;
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
    	 if(this.currentCharge>=10)
        return false;
    	 else return true;
    }
	
	
}

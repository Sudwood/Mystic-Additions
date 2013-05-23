package com.sudwood.mysticadditions.items.energy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemSwordSteelRC extends IItemMysticRechargeable {

	
	 private EnumToolMaterial toolMaterial;
	 private float efficiencyOnProperMaterial;
	 
	 public ItemSwordSteelRC(int i, EnumToolMaterial enumtoolmaterial, int maxStorage, int rechargeRate)
    {
       super(i, maxStorage, rechargeRate) ;
       toolMaterial = enumtoolmaterial;
       this.efficiencyOnProperMaterial = enumtoolmaterial.getEfficiencyOnProperMaterial();
    }
	 
    @Override
   	public void registerIcons(IconRegister iconRegister)
   	{
   		this.itemIcon = iconRegister.registerIcon("MysticAdditions:steelswordrc");
   	}
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
    	
    	if(stack.getTagCompound()==null)
		  {
			  stack.setTagCompound(new NBTTagCompound());
		  }
  	 NBTTagCompound tag = stack.getTagCompound();
  	 this.currentCharge = tag.getInteger("CurrentCharge");
  	 if(this.currentCharge>10)
  	 {
  	
  	 return false;
  	 }
  	 else
  	 {
  		 
  		 return true;
  	 }
    }
    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        return par1Block.blockID == Block.web.blockID;
    }
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.block;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 74800;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }

    /**
     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
     * sword
     */
    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block)
    {
        if (par2Block.blockID == Block.web.blockID)
        {
            return 15.0F;
        }
        else
        {
            Material material = par2Block.blockMaterial;
            return material != Material.plants && material != Material.vine && material != Material.coral && material != Material.leaves && material != Material.pumpkin ? 1.0F : 1.5F;
        }
    }
    public int func_82803_g()
    {
        return this.toolMaterial.getDamageVsEntity();
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
    	 if(this.currentCharge>=10)
    	 {
    	 this.currentCharge-=10;
    	 tag.setInteger("CurrentCharge", this.currentCharge);
    	 return true;
    	 }
    	 else
    	 {
    		 
    		 return false;
    	 }
       
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
      	 if(this.currentCharge>=48)
      	 {
      	 this.currentCharge-=48;
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
        return 4+this.toolMaterial.getDamageVsEntity();
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

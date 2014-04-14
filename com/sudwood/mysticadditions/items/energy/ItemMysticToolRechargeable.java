package com.sudwood.mysticadditions.items.energy;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMysticToolRechargeable extends IItemMysticRechargeable {

	
	 private EnumToolMaterial toolMaterial;
	 private float efficiencyOnProperMaterial;
	 private int tool;
	 public ItemMysticToolRechargeable(int i, EnumToolMaterial enumtoolmaterial, int maxStorage, int rechargeRate, int type)
    {
       super(i, maxStorage, rechargeRate) ;
       toolMaterial = enumtoolmaterial;
       this.efficiencyOnProperMaterial = enumtoolmaterial.getEfficiencyOnProperMaterial();
       tool = type;
    }
	 
    @Override
   	public void registerIcons(IconRegister iconRegister)
   	{
    	switch(tool)
    	{
    	case 0:
    		this.itemIcon = iconRegister.registerIcon("MysticAdditions:rcmysticaxe");
    		break;
    	case 1:
    		this.itemIcon = iconRegister.registerIcon("MysticAdditions:rcmystichoe");
    		break;
    	case 2:
    		this.itemIcon = iconRegister.registerIcon("MysticAdditions:rcmysticpick");
    		break;
    	case 3:
    		this.itemIcon = iconRegister.registerIcon("MysticAdditions:rcmysticshovel");
    		break;
    	case 4:
    		this.itemIcon = iconRegister.registerIcon("MysticAdditions:rcmysticsword");
    		break;
    	case 5:
    		this.itemIcon = iconRegister.registerIcon("MysticAdditions:rcmysticpick");
    		break;
    	}
   	}
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
    	if(tool == 4 || tool == 5)
    	{
	    	if(stack.getTagCompound()==null)
			  {
				  stack.setTagCompound(new NBTTagCompound());
			  }
		  	 NBTTagCompound tag = stack.getTagCompound();
		  	 this.currentCharge = tag.getInteger("CurrentCharge");
		  	 if(this.currentCharge>24)
		  	 {
		  	
		  	 return false;
		  	 }
		  	 else
		  	 {
		  		 
		  		 return true;
		  	 }
    	}
    	else
    	{
    		if(stack.getTagCompound()==null)
			  {
				  stack.setTagCompound(new NBTTagCompound());
			  }
		  	 NBTTagCompound tag = stack.getTagCompound();
		  	 this.currentCharge = tag.getInteger("CurrentCharge");
		  	 if(this.currentCharge>48)
		  	 {
		  	
		  	 return false;
		  	 }
		  	 else
		  	 {
		  		 
		  		 return true;
		  	 }
    	}
    }
    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
        
        switch(tool)
    	{
    	case 0:
    		if(par1Block.blockMaterial == Material.wood || par1Block.blockMaterial == Material.cactus || par1Block.blockMaterial == Material.glass || par1Block.blockMaterial == Material.cactus || par1Block.blockMaterial == Material.circuits || par1Block.blockMaterial ==  Material.leaves || par1Block.blockMaterial == Material.pumpkin || par1Block.blockMaterial == Material.vine || par1Block.blockMaterial == Material.plants)
    			return true;
    		break;
    	case 1:
    		return false;
    	case 2:
    		if(par1Block.blockMaterial == Material.rock || par1Block.blockMaterial == Material.anvil || par1Block.blockMaterial == Material.glass || par1Block.blockMaterial == Material.ice || par1Block.blockMaterial == Material.circuits || par1Block.blockMaterial ==  Material.iron || par1Block.blockMaterial == Material.tnt || par1Block.blockMaterial == Material.piston || par1Block.blockMaterial == Material.redstoneLight)
    			return true;
    		break;
    	case 3:
    		if(par1Block.blockMaterial == Material.clay || par1Block.blockMaterial == Material.ground || par1Block.blockMaterial == Material.craftedSnow || par1Block.blockMaterial == Material.grass || par1Block.blockMaterial == Material.sand || par1Block.blockMaterial == Material.snow)
    			return true;
    		break;
    	case 4:
    		if(par1Block.blockMaterial == Material.cactus || par1Block.blockMaterial == Material.leaves || par1Block.blockMaterial == Material.cloth || par1Block.blockMaterial == Material.web)
    			return true;
    		break;
    	case 5:
    		return true;
    	default:
    		return false;
    	}
		return false;
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
    public float getStrVsBlock(ItemStack par1ItemStack, Block par1Block)
    {
    	switch(tool)
    	{
    	case 0:
    		if(par1Block.blockMaterial == Material.wood || par1Block.blockMaterial == Material.cactus || par1Block.blockMaterial == Material.glass || par1Block.blockMaterial == Material.cactus || par1Block.blockMaterial == Material.circuits || par1Block.blockMaterial ==  Material.leaves || par1Block.blockMaterial == Material.pumpkin || par1Block.blockMaterial == Material.vine || par1Block.blockMaterial == Material.plants)
    			return 30F;
    		break;
    	case 1:
    		return 0.5F;
    	case 2:
    		if(par1Block.blockMaterial == Material.rock || par1Block.blockMaterial == Material.anvil || par1Block.blockMaterial == Material.glass || par1Block.blockMaterial == Material.ice || par1Block.blockMaterial == Material.circuits || par1Block.blockMaterial ==  Material.iron || par1Block.blockMaterial == Material.tnt || par1Block.blockMaterial == Material.piston || par1Block.blockMaterial == Material.redstoneLight)
    			return 30F;
    		break;
    	case 3:
    		if(par1Block.blockMaterial == Material.clay || par1Block.blockMaterial == Material.ground || par1Block.blockMaterial == Material.craftedSnow || par1Block.blockMaterial == Material.grass || par1Block.blockMaterial == Material.sand || par1Block.blockMaterial == Material.snow)
    			return 30F;
    		break;
    	case 4:
    		if(par1Block.blockMaterial == Material.cactus || par1Block.blockMaterial == Material.leaves || par1Block.blockMaterial == Material.cloth || par1Block.blockMaterial == Material.web)
    			return 30F;
    		break;
    	case 5:
    		return 30F;
    	default:
    		return 3F;
    	}
    	return 1.5F;
    }
    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	if(tool == 4 || tool == 5)
    	{
	    	 NBTTagCompound tag = par1ItemStack.getTagCompound();
	      	 this.currentCharge = tag.getInteger("CurrentCharge");
	      	 if(this.currentCharge>=24)
	      	 {
		      	 this.currentCharge-=24;
		      	 tag.setInteger("CurrentCharge", this.currentCharge);
		      	int extra = this.doModuleHitAdditions(par2EntityLivingBase, par3EntityLivingBase);
		      	 par2EntityLivingBase.attackEntityFrom(DamageSource.magic, 20+extra);// /2 because its steel not the best material
		      	 return false;
	      	 }
	        return false;
    	}
    	else
    	{
    		NBTTagCompound tag = par1ItemStack.getTagCompound();
	      	 this.currentCharge = tag.getInteger("CurrentCharge");
	      	 if(this.currentCharge>=48)
	      	 {
		      	 this.currentCharge-=48;
		      	 tag.setInteger("CurrentCharge", this.currentCharge);
		      	int extra = this.doModuleHitAdditions(par2EntityLivingBase, par3EntityLivingBase);
		      	 par2EntityLivingBase.attackEntityFrom(DamageSource.magic, 12+extra/2);// /2 because its steel not the best material
		      	 return false;
	      	 }
	        return false;
    	}
    }
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
    {
        if(tool == 4)
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
        else
        {
        	if(par1ItemStack.getTagCompound()==null)
	  		  {
	  			  par1ItemStack.setTagCompound(new NBTTagCompound());
	  		  }
	      	 NBTTagCompound tag = par1ItemStack.getTagCompound();
	      	 this.currentCharge = tag.getInteger("CurrentCharge");
	      	 if(this.currentCharge>=24)
	      	 {
	      	 this.currentCharge-=24;
	      	 tag.setInteger("CurrentCharge", this.currentCharge);
	      	 return true;
	      	 }
	      	 else return false;
        }

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
    	if(tool == 4)
    	{
	    	if(itemstack.getTagCompound()==null)
			  {
				  itemstack.setTagCompound(new NBTTagCompound());
			  }
	    	NBTTagCompound tag = itemstack.getTagCompound();
	     	 this.currentCharge = tag.getInteger("CurrentCharge");
	     	 if(this.currentCharge<48)
	     	 {
		      	 return true;
	     	 }
	    	 else return false;
    	}
    	else
    	{
    		if(itemstack.getTagCompound()==null)
			  {
				  itemstack.setTagCompound(new NBTTagCompound());
			  }
	    	NBTTagCompound tag = itemstack.getTagCompound();
	     	 this.currentCharge = tag.getInteger("CurrentCharge");
	     	 if(this.currentCharge<24)
	     	 {
		      	 return true;
	     	 }
	    	 else return false;
    	}
    }
}

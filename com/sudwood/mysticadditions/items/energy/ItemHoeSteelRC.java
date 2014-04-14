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
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemHoeSteelRC extends IItemMysticRechargeable {

	 public static final Block[] blocksEffectiveAgainst = new Block[] {Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.stoneDoubleSlab, Block.stoneSingleSlab, Block.pumpkin, Block.pumpkinLantern};
	 private EnumToolMaterial toolMaterial;
	 private float efficiencyOnProperMaterial;
	 
	 public ItemHoeSteelRC(int i, EnumToolMaterial enumtoolmaterial, int maxStorage, int rechargeRate)
    {
       super(i, maxStorage, rechargeRate) ;
       toolMaterial = enumtoolmaterial;
       this.efficiencyOnProperMaterial = enumtoolmaterial.getEfficiencyOnProperMaterial();
    }
	 
    @Override
   	public void registerIcons(IconRegister iconRegister)
   	{
   		this.itemIcon = iconRegister.registerIcon("MysticAdditions:steelhoerc");
   	}
    /**
     * Returns if the item (tool) can harvest results from the block type.
     */
    public boolean canHarvestBlock(Block par1Block)
    {
    	if(par1Block.blockMaterial == Material.clay||par1Block.blockMaterial == Material.ground)
        return true;
    	else return false;
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
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	 NBTTagCompound tag = par1ItemStack.getTagCompound();
      	 this.currentCharge = tag.getInteger("CurrentCharge");
      	 if(this.currentCharge>=48)
      	 {
      	 this.currentCharge-=48;
      	 tag.setInteger("CurrentCharge", this.currentCharge);
      	this.doModuleHitAdditions(par2EntityLivingBase, par3EntityLivingBase);
      	 par2EntityLivingBase.attackEntityFrom(DamageSource.anvil, 2);
      	 return false;
      	 }
        return false;
    }
    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving)
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
     	 System.out.println(this.currentCharge);
     	 if(this.currentCharge<48)
     	 {
	      	 return true;
     	 }
    	 else return false;
    }
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else
        {
            UseHoeEvent event = new UseHoeEvent(par2EntityPlayer, par1ItemStack, par3World, par4, par5, par6);
            if (MinecraftForge.EVENT_BUS.post(event))
            {
                return false;
            }

            if (event.getResult() == Result.ALLOW)
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

            int i1 = par3World.getBlockId(par4, par5, par6);
            int j1 = par3World.getBlockId(par4, par5 + 1, par6);

            if ((par7 == 0 || j1 != 0 || i1 != Block.grass.blockID) && i1 != Block.dirt.blockID)
            {
                return false;
            }
            else
            {
                Block block = Block.tilledField;
                par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getStepSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);

                if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    par3World.setBlock(par4, par5, par6, block.blockID);

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
            }
        }
    }
	
	
}

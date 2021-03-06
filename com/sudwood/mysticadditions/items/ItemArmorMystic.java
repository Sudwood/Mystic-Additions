package com.sudwood.mysticadditions.items;


import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorMystic extends ItemArmor 
{
	private int armorpiece;
    public ItemArmorMystic(int i, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
        super(i, enumarmormaterial, j, k);
        this.material = enumarmormaterial;
        armorpiece = k;
    }
    
    private EnumArmorMaterial material;

    @Override
    public boolean hasEffect(ItemStack par1ItemStack){
    	return true;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par1ItemStack){
    	return EnumRarity.epic;
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
    
    
    @Override
   	public void registerIcons(IconRegister iconRegister)
   	{
       		 if(armorpiece==0)
       		 {
   	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:mystic Helm");
       		 }
       		 if(armorpiece==1)
       		 {
   	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:mystic Chest");
       		 }
       		 if(armorpiece==2)
       		 {
   	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:mysticlegs");
       		 }
       		 if(armorpiece==3)
       		 {
   	         this.itemIcon = iconRegister.registerIcon("MysticAdditions:mystic Boots");
       		 }
   	}

    /**
     * Return the color for the specified armor ItemStack.
     */
    public int getColor(ItemStack par1ItemStack)
    {
        
            NBTTagCompound nbttagcompound = par1ItemStack.getTagCompound();

            if (nbttagcompound == null)
            {
                return 4984077;
            }
            else
            {
                NBTTagCompound nbttagcompound1 = nbttagcompound.getCompoundTag("display");
                return nbttagcompound1 == null ? 4984077 : (nbttagcompound1.hasKey("color") ? nbttagcompound1.getInteger("color") : 4984077);
            }
        
    }
    
    
    
    
    
    
    
    
    @Override
    public void onArmorTickUpdate(World world, EntityPlayer player, ItemStack itemStack)
    {
    	ItemStack helmet = player.getCurrentItemOrArmor(4);
    	   ItemStack chest = player.getCurrentItemOrArmor(3);
    	   ItemStack legs = player.getCurrentItemOrArmor(2);
    	   ItemStack boots = player.getCurrentItemOrArmor(1);
		if(boots!=null&&boots.getItem()==MysticModItems.bootsMystic)
		   {
			player.fallDistance = 0;
			player.stepHeight = 1;
		
		player.addPotionEffect(new PotionEffect(Potion.jump.id, 200,5));
		   }
		
	    if(legs!=null&&legs.getItem()==MysticModItems.legsMystic&&player.isSprinting())
	    {
	    	player.capabilities.setPlayerWalkSpeed(0.45F);
	    	player.jumpMovementFactor = 0.15F;
	    	
	    	
	    }
	    if(chest!=null&&chest.getItem()==MysticModItems.chestMystic)
	    {
	    	player.extinguish();
	    }
	    if(helmet!=null&&helmet.getItem()==MysticModItems.helmMystic)
	    {
	    	player.setAir(100);
	    	if(player.isInWater())
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
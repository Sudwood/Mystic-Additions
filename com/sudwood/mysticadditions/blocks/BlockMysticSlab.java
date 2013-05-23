package com.sudwood.mysticadditions.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;

import com.sudwood.mysticadditions.MysticCommonProxy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class BlockMysticSlab extends BlockHalfSlab
{
	public Icon[] iconList = new Icon[9];
    /** The type of tree this slab came from. */
    public static final String[] slabType = new String[] {"mysticCobble", "mysticStone", "mysticBricks", "redPlanks", "ironPlanks"};

    public BlockMysticSlab(int par1, boolean par2)
    {
        super(par1, par2, Material.rock);
        
        
        
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        switch (par2)
        {
            case 0:
                return this.iconList[0];
            case 1:
                return this.iconList[1];
            case 2:
                return this.iconList[2];
            case 3:
                return this.iconList[3];
            case 4:
                return this.iconList[4];
            default:
                return this.iconList[0];
        }
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public Icon getBlockTextureFromSideAndMetadata(int par1)
    {
        return this.getBlockTextureFromSideAndMetadata(par1, 0);
    }
    @Override
	public int damageDropped (int metadata) {
		return metadata;
	}
	
    /**
     * Returns the ID of the items to drop on destruction.
     */
    

    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(this.blockID, 2, par1 & 5);
    }

    /**
     * Returns the slab block name with step type.
     */
    public String getFullSlabName(int par1)
    {
        if (par1 < 0 || par1 >= slabType.length)
        {
            par1 = 0;
        }

        return super.getBlockColor() + "." + slabType[par1];
    }

   

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems) {
		for (int ix = 0; ix < 5; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconList[0] = par1IconRegister.registerIcon("MysticAdditions:mysticcobblestone");
        this.iconList[1] = par1IconRegister.registerIcon("MysticAdditions:mysticstone");
        this.iconList[2] = par1IconRegister.registerIcon("MysticAdditions:mysticbricks");
        this.iconList[3] = par1IconRegister.registerIcon("MysticAdditions:redplanks");
        this.iconList[4] = par1IconRegister.registerIcon("MysticAdditions:ironplanks");
        
    }
}

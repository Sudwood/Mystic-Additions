package com.sudwood.mysticadditions.blocks;

import java.util.Random;

import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

import com.sudwood.mysticadditions.MysticCommonProxy;



public class BlockIronLeaves extends BlockLeavesBase 
{
    private int baseIndexInPNG;
    int adjacentTreeBlocks[];

    protected BlockIronLeaves(int i)
    {
        super(i, Material.leaves, false);
       
        this.setTickRandomly(true);
    }
    public int getRenderBlockPass()
    {
        return 0;
    }

    public int getBlockColor()
    {
        double d = 0.5D;
        double d1 = 1.0D;
       return 0;
    }
    public boolean isLeaves(World world, int x, int y, int z)
    {
        return true;
    }

  /*  public int getRenderColor(int i)
    {
        if ((i & 1) == 1)
        {
            return ColorizerFoliage.getFoliageColorPine();
        }
        if ((i & 2) == 2)
        {
            return ColorizerFoliage.getFoliageColorBirch();
        }
        else
        {
            return ColorizerFoliage.getFoliageColorBasic();
        }
    }

    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockMetadata(i, j, k);
        if ((l & 1) == 1)
        {
            return ColorizerFoliage.getFoliageColorPine();
        }
        if ((l & 2) == 2)
        {
            return ColorizerFoliage.getFoliageColorBirch();
        }
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        for (int l1 = -1; l1 <= 1; l1++)
        {
            for (int i2 = -1; i2 <= 1; i2++)
            {
                int j2 = iblockaccess.getWorldChunkManager().getBiomeGenAt(i + i2, k + l1).getFoliageColorAtCoords(iblockaccess, i + i2, j, k + l1);
                i1 += (j2 & 0xff0000) >> 16;
                j1 += (j2 & 0xff00) >> 8;
                k1 += j2 & 0xff;
            }
        }*/

    //    return (i1 / 9 & 0xff) << 16 | (j1 / 9 & 0xff) << 8 | k1 / 9 & 0xff;
 //   }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        int l = 1;
        int i1 = l + 1;
        if (world.checkChunksExist(i - i1, j - i1, k - i1, i + i1, j + i1, k + i1))
        {
            for (int j1 = -l; j1 <= l; j1++)
            {
                for (int k1 = -l; k1 <= l; k1++)
                {
                    for (int l1 = -l; l1 <= l; l1++)
                    {
                        int i2 = world.getBlockId(i + j1, j + k1, k + l1);
                        if (i2 == MysticModBlocks.ironLeaves.blockID)
                        {
                            int j2 = world.getBlockMetadata(i + j1, j + k1, k + l1);
                            world.setBlockMetadataWithNotify(i + j1, j + k1, k + l1, j2 | 8,2);
                        }
                    }
                }
            }
        }
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            int var6 = par1World.getBlockMetadata(par2, par3, par4);

            if ((var6 & 8) != 0 && (var6 & 4) == 0)
            {
                byte var7 = 4;
                int var8 = var7 + 1;
                byte var9 = 32;
                int var10 = var9 * var9;
                int var11 = var9 / 2;

                if (this.adjacentTreeBlocks == null)
                {
                    this.adjacentTreeBlocks = new int[var9 * var9 * var9];
                }

                int var12;

                if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
                {
                    int var13;
                    int var14;
                    int var15;

                    for (var12 = -var7; var12 <= var7; ++var12)
                    {
                        for (var13 = -var7; var13 <= var7; ++var13)
                        {
                            for (var14 = -var7; var14 <= var7; ++var14)
                            {
                                var15 = par1World.getBlockId(par2 + var12, par3 + var13, par4 + var14);

                                if (var15 == MysticModBlocks.ironLog.blockID)
                                {
                                    this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
                                }
                                else if (var15 == MysticModBlocks.ironLeaves.blockID)
                                {
                                    this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
                                }
                                else
                                {
                                    this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
                                }
                            }
                        }
                    }

                    for (var12 = 1; var12 <= 4; ++var12)
                    {
                        for (var13 = -var7; var13 <= var7; ++var13)
                        {
                            for (var14 = -var7; var14 <= var7; ++var14)
                            {
                                for (var15 = -var7; var15 <= var7; ++var15)
                                {
                                    if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11] == var12 - 1)
                                    {
                                        if (this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] = var12;
                                        }

                                        if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] == -2)
                                        {
                                            this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] = var12;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                var12 = this.adjacentTreeBlocks[var11 * var10 + var11 * var9 + var11];

                if (var12 >= 0)
                {
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 & -9,2);
                }
                else
                {
                    this.removeLeaves(par1World, par2, par3, par4);
                }
            }
        }
    }

    private void removeLeaves(World world, int i, int j, int k)
    {
        dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
        world.notifyBlockChange(i, j, k, 0);
    }

    public int quantityDropped(Random random)
    {
        return random.nextInt(20) != 0 ? 0 : 1;
    }

    public int idDropped(int i, Random random, int j)
    {
        return MysticModBlocks.ironSapling.blockID;
    }

    public void dropBlockAsItemWithChance(World par1World, int i, int j, int k, int l, float f, int i1)
    {
        super.dropBlockAsItemWithChance(par1World, i, j, k, l, f, i1);
        if (!par1World.isRemote && (l & 3) == 0 && par1World.rand.nextInt(200) == 0)
        {
            dropBlockAsItem_do(par1World, i, j, k, new ItemStack(Item.appleRed, 1, 0));
        }
    }

    public void harvestBlock(World par1World, EntityPlayer entityplayer, int i, int j, int k, int l)
    {
        if (!par1World.isRemote && entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.shears.itemID)
        {
            entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
            dropBlockAsItem_do(par1World, i, j, k, new ItemStack(MysticModBlocks.ironLeaves.blockID, 1, l & 3));
        }
        else
        {
            super.harvestBlock(par1World, entityplayer, i, j, k, l);
        }
    }

    public int damageDropped(int i)
    {
        return i & 3;
    }

    public boolean isOpaqueCube()
    {
        return !graphicsLevel;
    }

   

    public void setGraphicsLevel(boolean flag)
    {
        graphicsLevel = flag;
        
    }

    public void onEntityWalking(World world, int i, int j, int k, Entity entity)
    {
        super.onEntityWalking(world, i, j, k, entity);
    }
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("MysticAdditions:ironleaves");
    }
}

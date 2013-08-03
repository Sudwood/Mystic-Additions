/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package com.sudwood.mysticadditions.worldgen;
import java.util.Random;

import com.sudwood.mysticadditions.blocks.MysticModBlocks;
import com.sudwood.mysticadditions.items.MysticModItems;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWarpedEarthShrine extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
			MysticModBlocks.inertGrass.blockID
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		if(!world.isRemote)
		{
		int distanceToAir = 0;
		int checkID = world.getBlockId(i, j, k);

		while (checkID != 0){
			distanceToAir++;
			checkID = world.getBlockId(i, j + distanceToAir, k);
		}

		if (distanceToAir > 3){
			return false;
		}
		j += distanceToAir - 1;

		int blockID = world.getBlockId(i, j, k);
		int blockIDAbove = world.getBlockId(i, j+1, k);
		int blockIDBelow = world.getBlockId(i, j-1, k);
		for (int x : GetValidSpawnBlocks()){
			if (blockIDAbove != 0){
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Block.snow.blockID && blockIDBelow == x){
				return true;
			}
		}
		}
		return false;
	}

	public WorldGenWarpedEarthShrine() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(world.getBlockId(i, j, k)!=MysticModBlocks.inertGrass.blockID)
		{
			return false;
		}

		
		world.setBlock(i + 0, j + 1, k + 2, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 0, j + 1, k + 3, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 0, j + 1, k + 4, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 0, j + 1, k + 5, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 0, j + 1, k + 6, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 0, j + 1, k + 7, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 0, j + 1, k + 8, MysticModBlocks.inertDirt.blockID);
		
		world.setBlock(i + 1, j + 0, k + 2, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 1, j + 0, k + 3, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 1, j + 0, k + 4, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 1, j + 0, k + 5, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 1, j + 0, k + 6, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 1, j + 0, k + 7, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 1, j + 0, k + 8, MysticModBlocks.Dropper.blockID);
		
		world.setBlock(i + 1, j + 1, k + 1, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 1, j + 1, k + 9, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 1, j + 2, k + 2, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 1, j + 2, k + 3, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 1, j + 2, k + 4, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 1, j + 2, k + 5, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 1, j + 2, k + 6, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 1, j + 2, k + 7, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 1, j + 2, k + 8, MysticModBlocks.inertDirt.blockID);
		
		world.setBlock(i + 2, j + 0, k + 1, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 2, j + 0, k + 2, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 2, j + 0, k + 3, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 2, j + 0, k + 4, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 2, j + 0, k + 5, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 2, j + 0, k + 6, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 2, j + 0, k + 7, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 2, j + 0, k + 8, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 2, j + 0, k + 9, MysticModBlocks.Dropper.blockID);
		
		world.setBlock(i + 2, j + 1, k + 0, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 2, j + 1, k + 10, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 2, j + 2, k + 1, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 2, j + 2, k + 2, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 2, j + 2, k + 8, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 2, j + 2, k + 9, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 2, j + 3, k + 3, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 2, j + 3, k + 4, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 2, j + 3, k + 5, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 2, j + 3, k + 6, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 2, j + 3, k + 7, MysticModBlocks.inertDirt.blockID);
		
		world.setBlock(i + 3, j + 0, k + 1, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 3, j + 0, k + 2, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 3, j + 0, k + 3, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 3, j + 0, k + 4, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 3, j + 0, k + 5, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 3, j + 0, k + 6, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 3, j + 0, k + 7, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 3, j + 0, k + 8, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 3, j + 0, k + 9, MysticModBlocks.Dropper.blockID);
		
		world.setBlock(i + 3, j + 1, k + 0, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 3, j + 1, k + 10, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 3, j + 2, k + 1, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 3, j + 2, k + 9, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 3, j + 3, k + 2, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 3, j + 3, k + 3, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 3, j + 3, k + 7, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 3, j + 3, k + 8, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 3, j + 4, k + 4, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 3, j + 4, k + 5, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 3, j + 4, k + 6, MysticModBlocks.inertDirt.blockID);
		
		world.setBlock(i + 4, j + 0, k + 1, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 4, j + 0, k + 2, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 4, j + 0, k + 3, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 4, j + 0, k + 4, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 4, j + 0, k + 5, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 4, j + 0, k + 6, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 4, j + 0, k + 7, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 4, j + 0, k + 8, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 4, j + 0, k + 9, MysticModBlocks.Dropper.blockID);
		
		world.setBlock(i + 4, j + 1, k + 0, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 4, j + 1, k + 10, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 4, j + 2, k + 1, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 4, j + 2, k + 9, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 4, j + 3, k + 2, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 4, j + 3, k + 8, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 4, j + 4, k + 3, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 4, j + 4, k + 4, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 4, j + 4, k + 5, MysticModBlocks.mysticGlass.blockID);
		world.setBlock(i + 4, j + 4, k + 6, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 4, j + 4, k + 7, MysticModBlocks.inertDirt.blockID);
		
		world.setBlock(i + 5, j + 0, k + 1, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 5, j + 0, k + 2, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 5, j + 0, k + 3, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 5, j + 0, k + 4, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 5, j + 0, k + 5, Block.chest.blockID);
		TileEntityChest tile = (TileEntityChest) world.getBlockTileEntity(i+5,j+0, k+5);
		tile.setInventorySlotContents(0, new ItemStack(MysticModItems.earthToken, 1));
		world.setBlock(i + 5, j + 0, k + 6, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 5, j + 0, k + 7, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 5, j + 0, k + 8, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 5, j + 0, k + 9, MysticModBlocks.Dropper.blockID);
		
		world.setBlock(i + 5, j + 1, k + 0, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 5, j + 1, k + 5, Block.mobSpawner.blockID);
		TileEntityMobSpawner tile2 = (TileEntityMobSpawner) world.getBlockTileEntity(i+5, j+1, k+5);
		tile2.getSpawnerLogic().setMobID("MysticAdditions.EarthMiniBoss");
		world.setBlock(i + 5, j + 2, k + 1, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 5, j + 3, k + 2, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 5, j + 3, k + 8, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 5, j + 4, k + 3, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 5, j + 4, k + 4, MysticModBlocks.mysticGlass.blockID);
		world.setBlock(i + 5, j + 4, k + 5, MysticModBlocks.mysticGlass.blockID);
		world.setBlock(i + 5, j + 4, k + 6, MysticModBlocks.mysticGlass.blockID);
		world.setBlock(i + 5, j + 4, k + 7, MysticModBlocks.inertDirt.blockID);
		
		world.setBlock(i + 6, j + 0, k + 1, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 6, j + 0, k + 2, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 6, j + 0, k + 3, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 6, j + 0, k + 4, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 6, j + 0, k + 5, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 6, j + 0, k + 6, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 6, j + 0, k + 7, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 6, j + 0, k + 8, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 6, j + 0, k + 9, MysticModBlocks.Dropper.blockID);
		
		world.setBlock(i + 6, j + 1, k + 0, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 6, j + 1, k + 10, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 6, j + 2, k + 1, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 6, j + 2, k + 9, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 6, j + 3, k + 2, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 6, j + 3, k + 8, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 6, j + 4, k + 3, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 6, j + 4, k + 4, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 6, j + 4, k + 5, MysticModBlocks.mysticGlass.blockID);
		world.setBlock(i + 6, j + 4, k + 6, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 6, j + 4, k + 7, MysticModBlocks.inertDirt.blockID);
		
		world.setBlock(i + 7, j + 0, k + 1, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 7, j + 0, k + 2, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 7, j + 0, k + 3, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 7, j + 0, k + 4, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 7, j + 0, k + 5, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 7, j + 0, k + 6, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 7, j + 0, k + 7, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 7, j + 0, k + 8, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 7, j + 0, k + 9, MysticModBlocks.Dropper.blockID);
		
		world.setBlock(i + 7, j + 1, k + 0, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 7, j + 1, k + 10, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 7, j + 2, k + 1, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 7, j + 2, k + 9, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 7, j + 3, k + 2, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 7, j + 3, k + 3, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 7, j + 3, k + 7, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 7, j + 3, k + 8, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 7, j + 4, k + 4, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 7, j + 4, k + 5, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 7, j + 4, k + 6, MysticModBlocks.inertDirt.blockID);
		
		world.setBlock(i + 8, j + 0, k + 1, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 8, j + 0, k + 2, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 8, j + 0, k + 3, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 8, j + 0, k + 4, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 8, j + 0, k + 5, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 8, j + 0, k + 6, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 8, j + 0, k + 7, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 8, j + 0, k + 8, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 8, j + 0, k + 9, MysticModBlocks.Dropper.blockID);
		
		world.setBlock(i + 8, j + 1, k + 0, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 8, j + 1, k + 10, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 8, j + 2, k + 1, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 8, j + 2, k + 2, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 8, j + 2, k + 8, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 8, j + 2, k + 9, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 8, j + 3, k + 3, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 8, j + 3, k + 4, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 8, j + 3, k + 5, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 8, j + 3, k + 6, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 8, j + 3, k + 7, MysticModBlocks.inertDirt.blockID);
	
		world.setBlock(i + 9, j + 0, k + 2, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 9, j + 0, k + 3, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 9, j + 0, k + 4, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 9, j + 0, k + 5, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 9, j + 0, k + 6, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 9, j + 0, k + 7, MysticModBlocks.Dropper.blockID);
		world.setBlock(i + 9, j + 0, k + 8, MysticModBlocks.Dropper.blockID);

		world.setBlock(i + 9, j + 1, k + 1, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 9, j + 1, k + 9, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 9, j + 2, k + 2, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 9, j + 2, k + 3, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 9, j + 2, k + 4, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 9, j + 2, k + 5, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 9, j + 2, k + 6, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 9, j + 2, k + 7, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 9, j + 2, k + 8, MysticModBlocks.inertDirt.blockID);
		
		world.setBlock(i + 10, j + 1, k + 2, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 10, j + 1, k + 3, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 10, j + 1, k + 4, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 10, j + 1, k + 5, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 10, j + 1, k + 6, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 10, j + 1, k + 7, MysticModBlocks.inertDirt.blockID);
		world.setBlock(i + 10, j + 1, k + 8, MysticModBlocks.inertDirt.blockID);

		return true;
	}
}
/*
*** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 ***
*/

package com.sudwood.mysticadditions.worldgen;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.sudwood.mysticadditions.blocks.MysticModBlocks;
import com.sudwood.mysticadditions.items.MysticModItems;

public class WorldGenWarpedAirShrine extends WorldGenerator
{
	protected int[] GetValidSpawnBlocks() {
		return new int[] {
			MysticModBlocks.inertGrass.blockID
		};
	}

	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		if (!world.isRemote){
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

	public WorldGenWarpedAirShrine() { }

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(world.getBlockId(i, j, k)!=MysticModBlocks.inertGrass.blockID)
		{
			return false;
		}

		
		world.setBlock(i + 0, j + 1, k + 6, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 0, j + 1, k + 7, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 0, j + 1, k + 8, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 0, j + 1, k + 12, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 0, j + 1, k + 13, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 0, j + 1, k + 14, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 1, j + 1, k + 6, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 1, j + 1, k + 7, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 1, j + 1, k + 8, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 1, j + 1, k + 12, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 1, j + 1, k + 13, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 1, j + 1, k + 14, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 1, j + 2, k + 7, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 1, j + 2, k + 13, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 1, j + 3, k + 7, Block.jukebox.blockID);
		world.setBlock(i + 1, j + 3, k + 13, Block.jukebox.blockID);
		world.setBlock(i + 1, j + 4, k + 7, Block.jukebox.blockID);
		world.setBlock(i + 1, j + 4, k + 13, Block.jukebox.blockID);
		world.setBlock(i + 1, j + 5, k + 7, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 1, j + 5, k + 13, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 2, j + 1, k + 6, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 2, j + 1, k + 7, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 2, j + 1, k + 8, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 2, j + 1, k + 12, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 2, j + 1, k + 13, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 2, j + 1, k + 14, Block.stoneSingleSlab.blockID, 2,2);
	
		world.setBlock(i + 5, j + 1, k + 0, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 1, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 2, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 6, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 7, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 8, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 9, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 11, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 12, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 13, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 14, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 18, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 19, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 5, j + 1, k + 20, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 6, j + 0, k + 6, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 6, j + 0, k + 7, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 6, j + 0, k + 8, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 6, j + 0, k + 9, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 6, j + 0, k + 11, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 6, j + 0, k + 12, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 6, j + 0, k + 13, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 6, j + 0, k + 14, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 6, j + 1, k + 0, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 6, j + 1, k + 1, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 6, j + 1, k + 2, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 6, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 6, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 6, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 6, j + 1, k + 18, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 6, j + 1, k + 19, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 6, j + 1, k + 20, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 6, j + 2, k + 1, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 6, j + 2, k + 19, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 6, j + 3, k + 1, Block.jukebox.blockID);
		world.setBlock(i + 6, j + 3, k + 19, Block.jukebox.blockID);
		world.setBlock(i + 6, j + 4, k + 1, Block.jukebox.blockID);
		world.setBlock(i + 6, j + 4, k + 19, Block.jukebox.blockID);
		world.setBlock(i + 6, j + 5, k + 1, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 6, j + 5, k + 19, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 7, j + 0, k + 6, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 7, j + 0, k + 7, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 7, j + 0, k + 8, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 7, j + 0, k + 9, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 7, j + 0, k + 11, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 7, j + 0, k + 12, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 7, j + 0, k + 13, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 7, j + 0, k + 14, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 7, j + 1, k + 0, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 7, j + 1, k + 1, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 7, j + 1, k + 2, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 7, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 7, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 7, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 7, j + 1, k + 18, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 7, j + 1, k + 19, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 7, j + 1, k + 20, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 8, j + 0, k + 6, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 8, j + 0, k + 7, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 8, j + 0, k + 8, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 8, j + 0, k + 9, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 8, j + 0, k + 11, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 8, j + 0, k + 12, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 8, j + 0, k + 13, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 8, j + 0, k + 14, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 8, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 8, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 8, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 9, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 9, j + 1, k + 6, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 9, j + 1, k + 7, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 9, j + 1, k + 8, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 9, j + 1, k + 9, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 9, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 9, j + 1, k + 11, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 9, j + 1, k + 12, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 9, j + 1, k + 13, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 9, j + 1, k + 14, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 9, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
	
		world.setBlock(i + 10, j + 0, k + 6, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 10, j + 0, k + 7, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 10, j + 0, k + 8, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 10, j + 0, k + 9, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 10, j + 0, k + 11, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 10, j + 0, k + 12, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 10, j + 0, k + 13, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 10, j + 0, k + 14, MysticModBlocks.mysticBricks.blockID);

		world.setBlock(i + 10, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 10, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 10, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 11, j + 0, k + 6, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 11, j + 0, k + 7, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 11, j + 0, k + 8, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 11, j + 0, k + 9, MysticModBlocks.mysticBricks.blockID);
	
		world.setBlock(i + 11, j + 0, k + 11, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 11, j + 0, k + 12, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 11, j + 0, k + 13, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 11, j + 0, k + 14, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 11, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 11, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 11, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 11, j + 2, k + 10, Block.chest.blockID);
		TileEntityChest tile = (TileEntityChest) world.getBlockTileEntity(i+11, j+2, k+10);
		tile.setInventorySlotContents(0, new ItemStack(MysticModItems.airToken, 1));
		world.setBlock(i + 11, j + 3, k + 10, Block.mobSpawner.blockID);
		TileEntityMobSpawner tile2 = (TileEntityMobSpawner) world.getBlockTileEntity(i+11, j+3, k+10);
		tile2.getSpawnerLogic().setMobID("MysticAdditions.WindMiniBoss");
		
		world.setBlock(i + 12, j + 0, k + 6, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 12, j + 0, k + 7, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 12, j + 0, k + 8, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 12, j + 0, k + 9, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 12, j + 0, k + 11, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 12, j + 0, k + 12, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 12, j + 0, k + 13, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 12, j + 0, k + 14, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 12, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 12, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 12, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 13, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 13, j + 1, k + 6, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 13, j + 1, k + 7, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 13, j + 1, k + 8, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 13, j + 1, k + 9, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 13, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 13, j + 1, k + 11, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 13, j + 1, k + 12, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 13, j + 1, k + 13, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 13, j + 1, k + 14, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 13, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 14, j + 0, k + 6, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 14, j + 0, k + 7, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 14, j + 0, k + 8, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 14, j + 0, k + 9, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 14, j + 0, k + 11, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 14, j + 0, k + 12, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 14, j + 0, k + 13, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 14, j + 0, k + 14, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 14, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 14, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 14, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
	
		world.setBlock(i + 15, j + 0, k + 6, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 15, j + 0, k + 7, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 15, j + 0, k + 8, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 15, j + 0, k + 9, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 15, j + 0, k + 11, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 15, j + 0, k + 12, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 15, j + 0, k + 13, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 15, j + 0, k + 14, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 15, j + 1, k + 0, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 15, j + 1, k + 1, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 15, j + 1, k + 2, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 15, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 15, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 15, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 15, j + 1, k + 18, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 15, j + 1, k + 19, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 15, j + 1, k + 20, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 16, j + 0, k + 6, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 16, j + 0, k + 7, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 16, j + 0, k + 8, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 16, j + 0, k + 9, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 16, j + 0, k + 11, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 16, j + 0, k + 12, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 16, j + 0, k + 13, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 16, j + 0, k + 14, MysticModBlocks.mysticBricks.blockID);
		
		world.setBlock(i + 16, j + 1, k + 0, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 16, j + 1, k + 1, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 16, j + 1, k + 2, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 16, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 16, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 16, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 16, j + 1, k + 18, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 16, j + 1, k + 19, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 16, j + 1, k + 20, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 16, j + 2, k + 1, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 16, j + 2, k + 19, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 16, j + 3, k + 1, Block.jukebox.blockID);
		world.setBlock(i + 16, j + 3, k + 19, Block.jukebox.blockID);
		world.setBlock(i + 16, j + 4, k + 1, Block.jukebox.blockID);
		world.setBlock(i + 16, j + 4, k + 19, Block.jukebox.blockID);
		world.setBlock(i + 16, j + 5, k + 1, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 16, j + 5, k + 19, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 17, j + 1, k + 0, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 1, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 2, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 5, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 6, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 7, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 8, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 9, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 10, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 11, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 12, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 13, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 14, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 15, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 18, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 19, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 17, j + 1, k + 20, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 20, j + 1, k + 6, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 20, j + 1, k + 7, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 20, j + 1, k + 8, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 20, j + 1, k + 12, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 20, j + 1, k + 13, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 20, j + 1, k + 14, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 21, j + 1, k + 6, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 21, j + 1, k + 7, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 21, j + 1, k + 8, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 21, j + 1, k + 12, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 21, j + 1, k + 13, MysticModBlocks.mysticBricks.blockID);
		world.setBlock(i + 21, j + 1, k + 14, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 21, j + 2, k + 7, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 21, j + 2, k + 13, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 21, j + 3, k + 7, Block.jukebox.blockID);
		world.setBlock(i + 21, j + 3, k + 13, Block.jukebox.blockID);
		world.setBlock(i + 21, j + 4, k + 7, Block.jukebox.blockID);
		world.setBlock(i + 21, j + 4, k + 13, Block.jukebox.blockID);
		world.setBlock(i + 21, j + 5, k + 7, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 21, j + 5, k + 13, Block.stoneSingleSlab.blockID, 2,2);
		
		world.setBlock(i + 22, j + 1, k + 6, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 22, j + 1, k + 7, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 22, j + 1, k + 8, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 22, j + 1, k + 12, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 22, j + 1, k + 13, Block.stoneSingleSlab.blockID, 2,2);
		world.setBlock(i + 22, j + 1, k + 14, Block.stoneSingleSlab.blockID, 2,2);

		return true;
	}
}
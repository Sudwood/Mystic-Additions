package com.sudwood.mysticadditions.worldgen;

import java.util.Random;

import com.sudwood.mysticadditions.mod_MysticAdditions;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.common.IWorldGenerator;

public class MysticWorldGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.dimensionId==mod_MysticAdditions.DimID)
		{
			this.generateWarped(world, random, chunkX, chunkZ);
		}
		
	}
	
	public void generateNether() {
	//we're not doing ore ore in the nether
	}
	
	public void generateWarped(World world, Random rand, int chunkX, int chunkZ) {
		
        WorldGenRedTree tree = new WorldGenRedTree(true); 
      
        	for(int x = 0; x < 15; x++)
        	{
        		int Xcoord = chunkX + rand.nextInt(16); 
        		int Zcoord = chunkZ + rand.nextInt(16); 
        		int i = world.getHeightValue(Xcoord, Zcoord); 
        		tree.generate(world, rand, Xcoord, i, Zcoord); 
        	}
        		
        
        WorldGenIronTree tree1 = new WorldGenIronTree(true); 
         
        	for(int x = 0; x < 15; x++)
        	{
        		int Xcoord = chunkX + rand.nextInt(16); 
        		int Zcoord = chunkZ + rand.nextInt(16); 
        		int i = world.getHeightValue(Xcoord, Zcoord); 
        		tree1.generate(world, rand, Xcoord, i, Zcoord); 
        	}
}
	

	public void generateEnd() {
	//we're not going to generate in the end either
	}
}
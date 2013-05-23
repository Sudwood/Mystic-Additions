package com.sudwood.mysticadditions.dimensions;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenDesertWells;

import com.sudwood.mysticadditions.blocks.MysticModBlocks;
import com.sudwood.mysticadditions.entity.EntityMysticArcher;
import com.sudwood.mysticadditions.entity.EntityMysticKnight;
import com.sudwood.mysticadditions.worldgen.WorldGenIronTree;
import com.sudwood.mysticadditions.worldgen.WorldGenRedTree;
import com.sudwood.mysticadditions.worldgen.WorldGenWarpedAirShrine;
import com.sudwood.mysticadditions.worldgen.WorldGenWarpedEarthShrine;
import com.sudwood.mysticadditions.worldgen.WorldGenWarpedFireShrine;
import com.sudwood.mysticadditions.worldgen.WorldGenWarpedWaterShrine;


public class BiomeGenMystic extends BiomeGenBase
{

	public BiomeGenMystic(int par1)
    {
        super(par1);
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.topBlock = (byte)MysticModBlocks.inertGrass.blockID;
        this.fillerBlock = (byte)MysticModBlocks.inertStone.blockID;
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.deadBushPerChunk = 0;
        this.theBiomeDecorator.reedsPerChunk = 0;
        this.theBiomeDecorator.cactiPerChunk = 0;
        this.waterColorMultiplier = 0xFF0000;
        this.spawnableMonsterList.add(new SpawnListEntry(EntityMysticKnight.class,18, 12, 16 ));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityMysticArcher.class,18, 12, 16 ));
    }

    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        super.decorate(par1World, par2Random, par3, par4);
        WorldGenRedTree tree = new WorldGenRedTree(true); 
        
    	for(int x = 0; x < 2; x++)
    	{
    		int Xcoord = par3 + par2Random.nextInt(16); 
    		int Zcoord = par4 + par2Random.nextInt(16); 
    		int i = par1World.getHeightValue(Xcoord, Zcoord); 
    		tree.generate(par1World, par2Random, Xcoord, i, Zcoord); 
    	}
    		
    
    WorldGenIronTree tree1 = new WorldGenIronTree(true); 
     
    	for(int x = 0; x < 2; x++)
    	{
    		int Xcoord = par3 + par2Random.nextInt(16); 
    		int Zcoord = par4 + par2Random.nextInt(16); 
    		int i = par1World.getHeightValue(Xcoord, Zcoord); 
    		tree1.generate(par1World, par2Random, Xcoord, i, Zcoord);  
    	}
    WorldGenWarpedAirShrine air = new WorldGenWarpedAirShrine();
  
  
        
    
    WorldGenWarpedFireShrine fire = new WorldGenWarpedFireShrine();
    
    WorldGenWarpedWaterShrine water = new WorldGenWarpedWaterShrine();
    
    WorldGenWarpedEarthShrine earth = new WorldGenWarpedEarthShrine();
    Random firstRandom = new Random();
  //  if(firstRandom.nextInt(20)==0){
    for(int i2 = 0; i2<200; i2++)
    {
		int Xcoord = par3 + par2Random.nextInt(16); 
		int Zcoord = par4 + par2Random.nextInt(16); 
		
		int i = par1World.getHeightValue(Xcoord, Zcoord); 
		Random newRandom = new Random();
		switch(newRandom.nextInt(4))
		{
		case 0: air.generate(par1World, par2Random, Xcoord, i, Zcoord);  
			break;
		case 1: fire.generate(par1World, par2Random, Xcoord, i, Zcoord);  
			break;
		case 2: water.generate(par1World, par2Random, Xcoord, i, Zcoord);  
			break;
		case 3: earth.generate(par1World, par2Random, Xcoord, i, Zcoord);  
			break;
		}
    }	
		
	
    }
        
     /*   public int func_48415_j()
        {
                double d = func_48411_i();
                double d1 = func_48414_h();
                return ((ColorizerGrass.getGrassColor(d, d1) & 0xFFC2C2) + 0xFFC2C2) / 2;
        }

        public int func_48412_k()
        {
                double d = func_48411_i();
                double d1 = func_48414_h();
                return ((ColorizerFoliage.getFoliageColor(d, d1) & 0xFFC2C2) + 0xFFC2C2) / 2;
        }*/
}

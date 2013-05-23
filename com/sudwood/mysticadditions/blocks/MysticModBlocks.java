package com.sudwood.mysticadditions.blocks;

import com.sudwood.mysticadditions.CraftingManagerMystic;
import com.sudwood.mysticadditions.FurnaceRecipesMystic;
import com.sudwood.mysticadditions.GrinderRecipesMystic;
import com.sudwood.mysticadditions.ItemBlockMysticSlabs;
import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.blocks.energy.BlockCrystalGeneratorBase;
import com.sudwood.mysticadditions.blocks.energy.BlockMysticCrystalGenerator;
import com.sudwood.mysticadditions.blocks.energy.BlockMysticRedGenerator;
import com.sudwood.mysticadditions.blocks.energy.BlockMysticRedGrinder;
import com.sudwood.mysticadditions.blocks.energy.BlockMysticRedStorage;
import com.sudwood.mysticadditions.blocks.energy.BlockMysticRedStoragemrk2;
import com.sudwood.mysticadditions.blocks.energy.BlockPoweredFurnace;
import com.sudwood.mysticadditions.blocks.energy.BlockPoweredMysticFurnace;
import com.sudwood.mysticadditions.items.MysticModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.block.BlockMobSpawner;

import net.minecraft.block.StepSound;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.src.ModLoader;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



public class MysticModBlocks {
	public static  Block compressedCoal;
	public static  Block refinedCarbon;
	public static  Block refinedRedstone;
	public static Block refinedIronBlock;
	public static  Block cSteelBlock;
	public static  Block mysticGlass;
	public static  Block mysticglowGlass;
	public static  Block mysticspeedGlass;
	public static  Block mysticlandmineGlass;
	public static  Block mysticfireGlass;
	public static  Block redLog;
	public static  Block redPlanks;
	public static  Block ironLog;
	public static  Block ironPlanks;
	public static  Block redSapling;
	public static  Block ironSapling;
	public static  Block redLeaves;
	public static  Block ironLeaves;
	public static  Block mysticDirt;
	public static  Block mysticGrass;
	public static  Block mysticgenStone;
	public static  Block mysticCobblestone;
	public static  Block mysticPortal;
	public static  Block Elevator;
	public static  Block Stopper;
	public static  Block Dropper;
	public static  Block mysticBricks;
	public static  Block mysticportalBlock;
	public static  Block mysticportalSpawner;
	public static  Block mysticingotBlock;
	public static  Block mysticFurnace;
	public static  Block mysticCraftingTable;
	public static  Block inertGrass;
	public static  Block inertDirt;
	public static  Block inertStone;
	public static  Block inertCobble;
	public static  Block mysticBUD;
	public static  Block mysticRedStorage;
	public static  Block mysticRedGenerator;
	public static  Block mysticCobbleStairs;
	public static  BlockHalfSlab mysticSlabSingle;
	public static  BlockHalfSlab mysticSlabDouble;
	public static  Block mysticStoneStairs;
	public static  Block mysticBrickStairs;
	public static  Block mysticRedPlankStairs;
	public static  Block mysticIronPlankStairs;
	public static  Block markBlock;
	public static  Block mysticRedGrinder;
	public static  Block poweredFurnace;
	public static  Block poweredMysticFurnace;
	public static  Block crystalGenerator;
	public static  Block crystalGeneratorBase;
	public static  Block mysticRedStorageMrk2;
	//blocksounds
	public static final StepSound soundPowderFootstep = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound soundWoodFootstep = new StepSound("wood", 1.0F, 1.0F);
    public static final StepSound soundGravelFootstep = new StepSound("gravel", 1.0F, 1.0F);
    public static final StepSound soundGrassFootstep = new StepSound("grass", 1.0F, 1.0F);
    public static final StepSound soundStoneFootstep = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound soundMetalFootstep = new StepSound("stone", 1.0F, 1.5F);
    public static final StepSound soundGlassFootstep = new StepSound("stone", 1.0F, 1.0F);
    public static final StepSound soundClothFootstep = new StepSound("cloth", 1.0F, 1.0F);
    public static final StepSound soundSandFootstep = new StepSound("sand", 1.0F, 1.0F);
	
    //multiblock names
    private static final String[] mysticSlabNames = {"Mystic Cobblestone","Mystic Stone","Mystic Bricks","Red Planks","Iron Planks"};
    
    
    public static void init() {
		
		//blocks =
		compressedCoal = new BlockCompressedCoal(MysticAdditions.compressedcoalid).setHardness(1F).setUnlocalizedName("CompressedCoal").setCreativeTab(MysticAdditions.mysticTab);
		refinedCarbon = new BlockRefinedCarbon(MysticAdditions.refinedcarbonid).setHardness(1F).setUnlocalizedName("RefinedCarbon").setCreativeTab(MysticAdditions.mysticTab);
		refinedRedstone = new BlockRefinedRedstone(MysticAdditions.refinedredstoneid).setHardness(1F).setUnlocalizedName("RefinedRedstone").setLightValue(0.7F).setCreativeTab(MysticAdditions.mysticTab);
		refinedIronBlock = new BlockFixedIronBlock(MysticAdditions.refinedironblockid).setHardness(1F).setUnlocalizedName("RefinedIronBlock").setCreativeTab(MysticAdditions.mysticTab);
		cSteelBlock = new BlockCSteelBlock(MysticAdditions.csteelblockid).setHardness(1F).setUnlocalizedName("cSteelBlock").setCreativeTab(MysticAdditions.mysticTab);
		mysticGlass = new BlockMysticGlass(MysticAdditions.mysticglassid, Material.glass, false).setHardness(0.2F).setUnlocalizedName("MysticGlass").setCreativeTab(MysticAdditions.mysticTab);
		mysticglowGlass = new BlockMysticGlowGlass(MysticAdditions.mysticglowglassid, Material.glass, false).setHardness(0.2F).setUnlocalizedName("MysticGlowGlass").setLightValue(0.8F).setCreativeTab(MysticAdditions.mysticTab);
		mysticspeedGlass = new BlockMysticSpeedGlass(MysticAdditions.mysticspeedglassid).setHardness(0.2F).setUnlocalizedName("MysticSpeedGlass").setCreativeTab(MysticAdditions.mysticTab);
		mysticlandmineGlass = new BlockMysticLandmineGlass(MysticAdditions.mysticlandmineglassid, Material.glass, false).setHardness(0.2F).setUnlocalizedName("MysticLandmineGlass").setCreativeTab(MysticAdditions.mysticTab);
		mysticfireGlass = new BlockMysticFireGlass(MysticAdditions.mysticfireglassid, Material.glass, false).setHardness(0.2F).setUnlocalizedName("MysticFireGlass").setCreativeTab(MysticAdditions.mysticTab);
		redLog = new BlockRedLog(MysticAdditions.redlogid).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("redlog").setCreativeTab(MysticAdditions.mysticTab);
		redPlanks = new BlockRedPlanks(MysticAdditions.redplanksid).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("redplanks").setCreativeTab(MysticAdditions.mysticTab);
		ironLog = new BlockIronLog(MysticAdditions.ironlogid).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("ironlog").setCreativeTab(MysticAdditions.mysticTab);
		ironPlanks = new BlockIronPlanks(MysticAdditions.ironplanksid).setHardness(2.0F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("ironplanks").setCreativeTab(MysticAdditions.mysticTab);
		redSapling = new BlockRedSapling(MysticAdditions.redsaplingid).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("redsapling");
		ironSapling = new BlockIronSapling(MysticAdditions.ironsaplingid).setHardness(0.0F).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("ironsapling");
		redLeaves = new BlockRedLeaves(MysticAdditions.redleavesid).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("redleaves").setCreativeTab(MysticAdditions.mysticTab);
		ironLeaves = new BlockIronLeaves(MysticAdditions.ironleavesid).setHardness(0.2F).setLightOpacity(1).setStepSound(Block.soundGrassFootstep).setUnlocalizedName("lironleaves").setCreativeTab(MysticAdditions.mysticTab);
		mysticDirt = (new BlockMysticDirt(MysticAdditions.mysticdirtid)).setHardness(0.5F).setStepSound(soundGravelFootstep).setUnlocalizedName("mysticdirt").setCreativeTab(MysticAdditions.mysticTab);
		mysticGrass = (new BlockMysticGrass(MysticAdditions.mysticgrassid)).setHardness(0.6F).setStepSound(soundGravelFootstep).setUnlocalizedName("mysticgrass").setCreativeTab(MysticAdditions.mysticTab);
		mysticgenStone = (new BlockMysticgenStone(MysticAdditions.mysticgenstoneid)).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("mysticgenstone").setCreativeTab(MysticAdditions.mysticTab);
		mysticCobblestone = (new BlockMysticCobblestone(MysticAdditions.mysticcobblestoneid).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("mysticcobble").setCreativeTab(CreativeTabs.tabBlock));
		mysticPortal = (new BlockMysticPortal(MysticAdditions.mysticportalid)).setHardness(-1F).setStepSound(soundGlassFootstep).setUnlocalizedName("mysticPortal");
		Elevator = (new BlockElevator(MysticAdditions.elevatorid, Material.glass, false)).setHardness(0.1F).setUnlocalizedName("elevator").setCreativeTab(MysticAdditions.mysticTab);
		Stopper = (new BlockStopper(MysticAdditions.stopperid, Material.glass, false)).setHardness(0.1F).setUnlocalizedName("stopper").setCreativeTab(MysticAdditions.mysticTab);
		Dropper = (new BlockDropper(MysticAdditions.dropperid, Material.glass, false)).setHardness(0.1F).setUnlocalizedName("dropper").setCreativeTab(MysticAdditions.mysticTab);
		mysticBricks = (new BlockMysticBricks(MysticAdditions.mysticbricksid)).setHardness(9.5F).setUnlocalizedName("mysticBricks").setCreativeTab(MysticAdditions.mysticTab);
		mysticportalBlock = (new BlockMysticPortalBlock(MysticAdditions.mysticportalblockid)).setHardness(10.5F).setUnlocalizedName("mysticportalblock").setCreativeTab(MysticAdditions.mysticTab);
		mysticportalSpawner = (new BlockMysticPortalSpawner(MysticAdditions.mysticportalspawnerid)).setHardness(2.5F).setUnlocalizedName("mysticportalspawner").setCreativeTab(MysticAdditions.mysticTab);
		mysticingotBlock = new BlockMysticIngotBlock(MysticAdditions.mysticingotblockid).setHardness(10F).setUnlocalizedName("mysticingotblock").setResistance(20F).setCreativeTab(MysticAdditions.mysticTab);
		mysticFurnace = new BlockMysticFurnace(MysticAdditions.mysticfurnaceid, false).setHardness(10F).setUnlocalizedName("MysticFurnace").setResistance(20F).setCreativeTab(MysticAdditions.mysticTab);
	//	mysticCraftingTable = new BlockMysticCraftingTable(mod_MysticAdditions.mysticcraftingtableid).setHardness(10F).setUnlocalizedName("MysticCraftingTable").setResistance(20F).setCreativeTabs(mod_MysticAdditions.mysticTab);
		inertGrass = new BlockMysticInertGrass(MysticAdditions.inertmysticgrassid).setHardness(0.6F).setStepSound(soundGravelFootstep).setUnlocalizedName("inertmysticgrass");
		inertDirt = (new BlockMysticInertDirt(MysticAdditions.inertmysticdirtid)).setHardness(0.5F).setStepSound(soundGravelFootstep).setUnlocalizedName("inertmysticdirt");
		inertStone = (new BlockMysticInertgenStone(MysticAdditions.inertmysticgenstoneid)).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("inertmysticgenstone");
		inertCobble = (new BlockMysticInertCobblestone(MysticAdditions.inertmysticcobblestoneid).setHardness(2.0F).setResistance(10.0F).setUnlocalizedName("inertmysticcobble"));
		mysticBUD = new BlockMysticBudSwitch(MysticAdditions.mysticbudswitchid).setHardness(10F).setStepSound(soundStoneFootstep).setUnlocalizedName("mysticbudswitch").setCreativeTab(MysticAdditions.mysticTab);
		mysticRedStorage = new BlockMysticRedStorage(MysticAdditions.mysticredstorageid, Material.circuits).setHardness(1.5F).setResistance(100F).setStepSound(soundStoneFootstep).setUnlocalizedName("mysticredstorage").setCreativeTab(MysticAdditions.mysticTab);
		mysticRedGenerator = new BlockMysticRedGenerator(MysticAdditions.mysticredgeneratorid, Material.circuits).setHardness(1.5F).setResistance(100F).setStepSound(soundStoneFootstep).setUnlocalizedName("mysticredgenerator").setCreativeTab(MysticAdditions.mysticTab);
		mysticCobbleStairs = new BlockMysticStairs(MysticAdditions.mysticcobblestairsid, mysticCobblestone, 0).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("mysticcobblestairs").setCreativeTab(MysticAdditions.mysticTab);
		mysticSlabSingle = (BlockHalfSlab) new BlockMysticSlab(MysticAdditions.mysticslabssingleid, false).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("mysticSlabs").setCreativeTab(MysticAdditions.mysticTab);
		mysticSlabDouble = (BlockHalfSlab) new BlockMysticSlab(MysticAdditions.mysticslabsdoubleid, true).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("mysticSlabs");
		mysticStoneStairs = new BlockMysticStairs(MysticAdditions.mysticstonestairsid, mysticgenStone, 0).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("mysticstonestairs").setCreativeTab(MysticAdditions.mysticTab);
		mysticBrickStairs = new BlockMysticStairs(MysticAdditions.mysticbrickstairsid, mysticBricks, 0).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("mysticbrickstairs").setCreativeTab(MysticAdditions.mysticTab);
		mysticRedPlankStairs = new BlockMysticStairs(MysticAdditions.mysticredplankstairsid, redPlanks, 0).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("mysticredplankstairs").setCreativeTab(MysticAdditions.mysticTab);
		mysticIronPlankStairs = new BlockMysticStairs(MysticAdditions.mysticironplankstairsid, ironPlanks, 0).setHardness(1.5F).setResistance(10.0F).setUnlocalizedName("mysticironplankstairs").setCreativeTab(MysticAdditions.mysticTab);
		markBlock = new BlockMarkBlock(MysticAdditions.markblockid).setHardness(200F).setResistance(200F);
		mysticRedGrinder = new BlockMysticRedGrinder(MysticAdditions.mysticredgrinderid).setHardness(1.5F).setResistance(100F).setUnlocalizedName("mysticredgrinder").setCreativeTab(MysticAdditions.mysticTab);
		poweredFurnace = new BlockPoweredFurnace(MysticAdditions.poweredfurnaceid).setHardness(1.5F).setResistance(100F).setUnlocalizedName("poweredfurnace").setCreativeTab(MysticAdditions.mysticTab);
		poweredMysticFurnace = new BlockPoweredMysticFurnace(MysticAdditions.poweredmysticfurnaceid).setHardness(1.5F).setResistance(100F).setUnlocalizedName("poweredmysticfurnace").setCreativeTab(MysticAdditions.mysticTab);
		crystalGenerator = new BlockMysticCrystalGenerator(MysticAdditions.crystalgeneratorid, Material.ice).setHardness(1.5F).setResistance(100F).setUnlocalizedName("crystalgenerator").setCreativeTab(MysticAdditions.mysticTab);
		crystalGeneratorBase = new BlockCrystalGeneratorBase(MysticAdditions.crystalgeneratorbaseid, Material.ice).setHardness(1.5F).setResistance(100F).setUnlocalizedName("MysticAdditions:crystalgenbase").setCreativeTab(MysticAdditions.mysticTab);
		mysticRedStorageMrk2 = new BlockMysticRedStoragemrk2(MysticAdditions.mrk2mysticredstorageid, Material.circuits).setHardness(1.5F).setResistance(100F).setUnlocalizedName("MysticAdditions:mysticredstoragemrk2").setCreativeTab(MysticAdditions.mysticTab);
		//block registration
		//dimension stuff
		
		
		
		GameRegistry.registerBlock(mysticPortal, "? ? ? ?");
		GameRegistry.registerBlock(mysticportalBlock, "Mystical Stabilizer");
		GameRegistry.registerBlock(mysticportalSpawner, "Mystical Rift Creator");
		LanguageRegistry.addName(mysticportalSpawner, "Mystical Rift Creator");
		LanguageRegistry.addName(mysticportalBlock, "Mystical Stabilizer");
		LanguageRegistry.addName(mysticPortal, "? ? ? ?");
	
		
		//compressed coal
		GameRegistry.registerBlock(compressedCoal, "Compressed Coal");
		LanguageRegistry.addName(compressedCoal, "Compressed Coal");
		
		
		
	
		
		
		
		
		//refined carbon
		GameRegistry.registerBlock(refinedCarbon, "Refined Carbon");
		LanguageRegistry.addName(refinedCarbon, "Refined Carbon");
	
		
		
		//refined Redstone
		GameRegistry.registerBlock(refinedRedstone, "Refined Redstone");
		LanguageRegistry.addName(refinedRedstone, "Refined redstone");

	
	
		//refined iron block
		GameRegistry.registerBlock(refinedIronBlock, "Refined Iron Block");
		LanguageRegistry.addName(refinedIronBlock, "Refined Iron Block");

	
	
		//cSteelBlock
		GameRegistry.registerBlock(cSteelBlock, "Steel Block");
		LanguageRegistry.addName(cSteelBlock, "Steel Block");

	
	
	//mystic glass
	
		GameRegistry.registerBlock(mysticGlass, "Mystic Glass");
		LanguageRegistry.addName(mysticGlass, "Mystic Glass");
	
	
	
	
	//mystic glow glass
	
		GameRegistry.registerBlock(mysticglowGlass, "Mystic Glow Glass");
		LanguageRegistry.addName(mysticglowGlass, "Mystic Glow Glass");
	
	
	//mystic speed glass
	
		GameRegistry.registerBlock(mysticspeedGlass, "Mystic Speed Strip");
		LanguageRegistry.addName(mysticspeedGlass, "Mystic Speed Strip");
	
	
	//mystic landmine glass
	
		GameRegistry.registerBlock(mysticlandmineGlass, "Mystic Landmine");
		LanguageRegistry.addName(mysticlandmineGlass, "Mystic Landmine");
	
	
	//mystic fire glass
	
		GameRegistry.registerBlock(mysticfireGlass, "Mystic Fire Trap");
		LanguageRegistry.addName(mysticfireGlass, "Mystic Fire Trap");
	
	
	//red tree stuff
		GameRegistry.registerBlock(redLog, "Mystic Log");
		LanguageRegistry.addName(redLog, "Mystic Log");
		GameRegistry.registerBlock(redLeaves, "Mystic Leaves");
		LanguageRegistry.addName(redLeaves, "Mystic Leaves");
		GameRegistry.registerBlock(redSapling, "Mystic Sapling");
		LanguageRegistry.addName(redSapling, "Mystic Sapling");
		GameRegistry.registerBlock(redPlanks, "Mystic Planks");
		LanguageRegistry.addName(redPlanks, "Mystic Planks");
	
	//iron tree stuff
	GameRegistry.registerBlock(ironLog, "Ironwood Log");
	LanguageRegistry.addName(ironLog, "Ironwood Log");
	GameRegistry.registerBlock(ironLeaves, "Iron Leaves");
	LanguageRegistry.addName(ironLeaves, "Iron Leaves");
	GameRegistry.registerBlock(ironSapling, "Iron Sapling");
	LanguageRegistry.addName(ironSapling, "Iron Sapling");
	GameRegistry.registerBlock(ironPlanks, "Ironwood Planks");
	LanguageRegistry.addName(ironPlanks, "Ironwood Planks");
	
	
	//Dimension Blocks
	GameRegistry.registerBlock(mysticDirt, "Warped Dirt");
LanguageRegistry.addName(mysticDirt, "Warped Dirt");

	GameRegistry.registerBlock(mysticGrass, "Warped Grass");
LanguageRegistry.addName(mysticGrass, "Warped Grass");
	GameRegistry.registerBlock(mysticgenStone, "Warped Stone");
	
	LanguageRegistry.addName(mysticgenStone, "Warped Stone");
	GameRegistry.registerBlock(mysticCobblestone, "Warped Cobblestone");
LanguageRegistry.addName(mysticCobblestone, "Warped Cobblestone");
	GameRegistry.registerBlock(mysticBricks, "Warped Bricks");
	LanguageRegistry.addName(mysticBricks, "Warped Bricks");
	
	GameRegistry.registerBlock(inertGrass, "Inert Grass");
	LanguageRegistry.addName(inertGrass, "Inert Grass");	
	
	GameRegistry.registerBlock(inertDirt, "Inert Dirt");
	LanguageRegistry.addName(inertDirt, "Inert Dirt");
	
	GameRegistry.registerBlock(inertStone, "Inert Stone");
	LanguageRegistry.addName(inertStone, "Inert Stone");
	
	GameRegistry.registerBlock(inertCobble, "Inert Cobblestone");
	LanguageRegistry.addName(inertCobble, "Inert Cobblestone");
	
	//Elevator block
	
	GameRegistry.registerBlock(Elevator, "Elevator");
	GameRegistry.registerBlock(Stopper, "Stopper");
	GameRegistry.registerBlock(Dropper, "Dropper");
	LanguageRegistry.addName(Elevator, "Elevator");
	LanguageRegistry.addName(Stopper, "Stopper");
	LanguageRegistry.addName(Dropper, "Dropper");
	
	
	//mystic ingot block
	GameRegistry.registerBlock(mysticingotBlock, "Mystic Block");
	LanguageRegistry.addName(mysticingotBlock, "Mystic Block");
	
	// mystic furnace
	GameRegistry.registerBlock(mysticFurnace, "Mystic Imbuer");
	LanguageRegistry.addName(mysticFurnace, "Mystic Imbuer");
	
	//mystic crafting table
	//GameRegistry.registerBlock(mysticCraftingTable, "Distortion Integrator");
	//LanguageRegistry.addName(mysticCraftingTable, "Distortion Integrator");
	
	//mystic bud switch
	GameRegistry.registerBlock(mysticBUD, "Mystical Detector");
	LanguageRegistry.addName(mysticBUD, "Mystical Detector");
	
	//Energy
	GameRegistry.registerBlock(mysticRedStorage, "Mystic Red Capacitor");
	LanguageRegistry.addName(mysticRedStorage, "Mystic Red Capacitor");
	GameRegistry.registerBlock(mysticRedGenerator, "Mystic Red Generator");
	LanguageRegistry.addName(mysticRedGenerator, "Mystic Red Generator");
	GameRegistry.registerBlock(mysticRedGrinder, "Mystic red Grinder");
	LanguageRegistry.addName(mysticRedGrinder, "Contero Essence");
	GameRegistry.registerBlock(poweredFurnace, "Powered Furnace");
	LanguageRegistry.addName(poweredFurnace, "Powered Furnace");
	GameRegistry.registerBlock(poweredMysticFurnace, "Powered Mystic Furnace");
	LanguageRegistry.addName(poweredMysticFurnace, "Powered Mystic Furnace");
	GameRegistry.registerBlock(crystalGenerator, "Crystal Generator");
	LanguageRegistry.addName(crystalGenerator, "Crystal Generator");
	GameRegistry.registerBlock(crystalGeneratorBase, "Crytal Amplifier");
	LanguageRegistry.addName(crystalGeneratorBase, "Crystal Amplifier");
	GameRegistry.registerBlock(mysticRedStorageMrk2 ,"Mrk 2 Red Capacitor");
	LanguageRegistry.addName(mysticRedStorageMrk2 ,"Mrk 2 Red Capacitor");
	//stairs
	GameRegistry.registerBlock(mysticCobbleStairs, "mysticcobbleStairs");
	GameRegistry.registerBlock(mysticStoneStairs, "mysticstoneStairs");
	GameRegistry.registerBlock(mysticBrickStairs, "mysticbrickStairs");
	GameRegistry.registerBlock(mysticRedPlankStairs, "mysticredplanksStairs");
	GameRegistry.registerBlock(mysticIronPlankStairs, "mysticironplanksStairs");
	LanguageRegistry.addName(mysticCobbleStairs, "Mystic Cobblestone Stair");
	LanguageRegistry.addName(mysticStoneStairs, "Mystic Stone Stair");
	LanguageRegistry.addName(mysticBrickStairs, "Mystic Brick Stair");
	LanguageRegistry.addName(mysticRedPlankStairs, "Red Plank Stair");
	LanguageRegistry.addName(mysticIronPlankStairs, "Iron Plank Stair");
	
	
	//slabs
	GameRegistry.registerBlock(mysticSlabSingle, ItemBlockMysticSlabs.class, "MysticSlabs");
	
	//teleportation
	GameRegistry.registerBlock(markBlock, "markBlock");
	LanguageRegistry.addName(markBlock, "Warp Locator");
	
	
	
	
	}
	
    public static void initBlockRecipes() {
    	FurnaceRecipesMystic frm = new FurnaceRecipesMystic();
    	CraftingManagerMystic cmm = new CraftingManagerMystic();
    	GrinderRecipesMystic grm = new GrinderRecipesMystic();
    	//grinderRecipes
    	grm.smelting().addSmelting(Block.oreCoal.blockID, new ItemStack(Item.coal, 4), 0.5F);
    	grm.smelting().addSmelting(Block.oreLapis.blockID, new ItemStack(Item.dyePowder, 8,4), 0.5F);
    	grm.smelting().addSmelting(Block.oreEmerald.blockID, new ItemStack(Item.emerald, 8), 0.5F);
    	grm.smelting().addSmelting(Block.oreRedstone.blockID, new ItemStack(Item.redstone, 12), 0.9999999F);
    	grm.smelting().addSmelting(MysticModItems.cSteelIngot.itemID, new ItemStack(MysticModItems.csteelDust, 1), 0.5F);
    	grm.smelting().addSmelting(refinedRedstone.blockID, new ItemStack(MysticModItems.redstoneShards, 1), 0.5F);
    	grm.smelting().addSmelting(Block.oreIron.blockID, new ItemStack(MysticModItems.essenceIron, 2), 0.5F);
    	grm.smelting().addSmelting(Block.oreGold.blockID, new ItemStack(MysticModItems.essenceGold, 2), 0.5F);
    	grm.smelting().addSmelting(Block.oreDiamond.blockID, new ItemStack(MysticModItems.essenceDiamond, 2), 0.5F);
    	grm.smelting().addSmelting(MysticModItems.swordCSteel.itemID, new ItemStack(MysticModItems.cSteelIngot, 1), 0.5F);
    	
    	//smelting recipes
    	frm.smelting().addSmelting(MysticModItems.essenceIron.itemID, new ItemStack(Item.ingotIron, 1), 0.5F);
    	frm.smelting().addSmelting(MysticModItems.essenceGold.itemID, new ItemStack(Item.ingotGold, 1), 0.5F);
    	frm.smelting().addSmelting(MysticModItems.essenceDiamond.itemID, new ItemStack(Item.diamond, 1), 0.5F);
    	//coal blocks
    	frm.smelting().addSmelting(compressedCoal.blockID, new ItemStack(refinedCarbon , 1), 1);
    	GameRegistry.addRecipe(new ItemStack(compressedCoal, 1) , new Object[]{
			"XXX","XXX","XXX", 'X', Item.coal});
    	GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 9), new Object[]{compressedCoal});
		GameRegistry.addRecipe(new ItemStack(compressedCoal, 1) , new Object[]{
			"XXX","XXX","XXX", 'X', new ItemStack(Item.coal, 1, 1)});
    	//redstone blocks
    	frm.smelting().addSmelting(Block.blockRedstone.blockID, new ItemStack(refinedRedstone , 1), 1);
    	
    	
    	//metal blocks
    	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(cSteelBlock, 1) , new Object[]{
    		"XXX","XXX","XXX", 'X', "ingotSteel"}));
    	GameRegistry.addShapelessRecipe(new ItemStack(MysticModItems.cSteelIngot, 9), cSteelBlock);
    	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(refinedIronBlock, 1) , new Object[]{
    		"XXX","XXX","XXX", 'X', "ingotRefinedIron"}));
    	GameRegistry.addShapelessRecipe(new ItemStack(MysticModItems.refinedIronIngot, 9), refinedIronBlock);
    	//mystic glasses
    	GameRegistry.addRecipe(new ItemStack(mysticGlass, 1) , new Object[]{
    		"XY", 'X', MysticModItems.moltenRedstone, Character.valueOf('Y'), Block.sand});
    	GameRegistry.addRecipe(new ItemStack(mysticglowGlass, 1) , new Object[]{
    		"XY", 'X', mysticGlass, Character.valueOf('Y'), MysticModItems.redstoneShards});
    	GameRegistry.addRecipe(new ItemStack(mysticspeedGlass, 1) , new Object[]{
    		"XY", 'X', mysticGlass, Character.valueOf('Y'), Item.sugar});
    	GameRegistry.addRecipe(new ItemStack(mysticlandmineGlass, 1) , new Object[]{
    		"XYZ", 'X', mysticGlass, Character.valueOf('Y'), Block.dirt, Character.valueOf('Z'), Item.gunpowder});
    	GameRegistry.addRecipe(new ItemStack(mysticfireGlass, 1) , new Object[]{
    		"XY", 'X', mysticGlass, Character.valueOf('Y'), Item.flint});
    	//redstone tree blocks
    	GameRegistry.addRecipe(new ItemStack(redPlanks, 4) , new Object[]{
    		"X", 'X', redLog});
    	GameRegistry.addRecipe(new ItemStack(redSapling, 1) , new Object[]{
    		"XY", 'X', Item.redstone, Character.valueOf('Y'), refinedRedstone});
    	//iron tree blocks
    	GameRegistry.addRecipe(new ItemStack(ironPlanks, 4) , new Object[]{
    		"X", 'X', ironLog});
    	GameRegistry.addRecipe(new ItemStack(ironSapling, 1) , new Object[]{
    		"XY", 'X', Item.ingotIron, Character.valueOf('Y'), refinedIronBlock});
    	//dimension blocks
    	GameRegistry.addRecipe(new ItemStack(mysticDirt, 1) , new Object[]{
    		"XY", 'X', MysticModItems.moltenRedstone, Character.valueOf('Y'), Block.dirt});
    		GameRegistry.addRecipe(new ItemStack(mysticDirt, 1) , new Object[]{
    		"XY", 'X', MysticModItems.moltencSteel, Character.valueOf('Y'), Block.dirt});
    		GameRegistry.addRecipe(new ItemStack(mysticportalBlock, 1), new Object[] {
    			"DX", Character.valueOf('D'), Block.obsidian, 'X', MysticModItems.moltenmysticAlloy});
    		GameRegistry.addRecipe(new ItemStack(mysticportalSpawner, 1), new Object[]{
    				"XXX","XXX","XXX", 'X', mysticportalBlock});
    	//mystic brick uses
    	GameRegistry.addRecipe(new ItemStack(Item.ingotIron, 4) , new Object[]{
    		"XXX","X X","X X", 'X', mysticBricks});
    	GameRegistry.addRecipe(new ItemStack(Block.blockRedstone, 1) , new Object[]{
    		"X X","X X","XXX", 'X', mysticBricks});
    	//elevator blocks
    	GameRegistry.addRecipe(new ItemStack(Elevator, 8) , new Object[]{
    		"XXX", "XYX", "XXX", 'X', mysticGlass, Character.valueOf('Y'), Item.feather});
    	GameRegistry.addRecipe(new ItemStack(Stopper, 8) , new Object[]{
    		"XXX", "XYX", "XXX", 'X', mysticGlass, Character.valueOf('Y'), Block.ladder});
    	GameRegistry.addRecipe(new ItemStack(Dropper, 8) , new Object[]{
    		"XXX", "XYX", "XXX", 'X', mysticGlass, Character.valueOf('Y'), Block.stone});    	
    	//mystic ingot
    	GameRegistry.addRecipe(new ItemStack(mysticingotBlock, 1) , new Object[]{
    		"XXX", "XXX", "XXX", 'X', MysticModItems.mysticIngot});
    	GameRegistry.addRecipe(new ItemStack(MysticModItems.mysticIngot, 9) , new Object[]{
    		"X", 'X', mysticingotBlock});
    	
    	//infrastructure
    	GameRegistry.addRecipe(new ItemStack(mysticFurnace, 1) , new Object[]{
    		"RRR", "IFI", "RRR", Character.valueOf('R'), Item.redstone, Character.valueOf('I'), Item.ingotIron, Character.valueOf('F'), Block.furnaceIdle});
    	GameRegistry.addRecipe(new ItemStack(mysticRedGenerator, 1) , new Object[]{
    		"RTR", "IFI", "RRR", Character.valueOf('R'), Item.redstone, Character.valueOf('I'), new ItemStack(MysticModItems.crudeMysticBattery,1, OreDictionary.WILDCARD_VALUE), Character.valueOf('F'), MysticModBlocks.mysticFurnace, Character.valueOf('T'), MysticModItems.warpedPowerConnector});
    	GameRegistry.addRecipe(new ItemStack(mysticRedStorage, 1) , new Object[]{
    		"RTR", "IFI", "RRR", Character.valueOf('R'), new ItemStack(MysticModItems.crudeMysticBattery,1, OreDictionary.WILDCARD_VALUE), Character.valueOf('I'), new ItemStack(MysticModItems.crudeMysticBattery,1, OreDictionary.WILDCARD_VALUE), Character.valueOf('F'), MysticModBlocks.mysticFurnace, Character.valueOf('T'), MysticModItems.warpedPowerConnector});
    	GameRegistry.addRecipe(new ItemStack(mysticRedGrinder, 1) , new Object[]{
    		"RTR", "IFR", "RRR", Character.valueOf('R'), Item.redstone, Character.valueOf('I'), new ItemStack(MysticModItems.crudeMysticBattery,1, OreDictionary.WILDCARD_VALUE), Character.valueOf('F'), MysticModBlocks.mysticFurnace, Character.valueOf('T'), MysticModItems.warpedPowerConnector});
    	GameRegistry.addRecipe(new ItemStack(poweredFurnace, 1) , new Object[]{
    		"PTP", "IFR", "RRR", Character.valueOf('R'), Item.redstone, Character.valueOf('I'), new ItemStack(MysticModItems.crudeMysticBattery,1, OreDictionary.WILDCARD_VALUE), Character.valueOf('F'), MysticModBlocks.mysticFurnace, Character.valueOf('T'), MysticModItems.warpedPowerConnector, 'P', MysticModItems.refinedIronIngot});
    	GameRegistry.addRecipe(new ItemStack(poweredMysticFurnace, 1) , new Object[]{
    		"PTP", "IFR", "RRR", Character.valueOf('R'), Item.redstone, Character.valueOf('I'), new ItemStack(MysticModItems.crudeMysticBattery,1, OreDictionary.WILDCARD_VALUE), Character.valueOf('F'), MysticModBlocks.mysticFurnace, Character.valueOf('T'), MysticModItems.warpedPowerConnector,'P', MysticModItems.cSteelIngot});
    	GameRegistry.addRecipe(new ItemStack(crystalGenerator, 1) , new Object[]{
    		"BSB", "SRS", "MSP", Character.valueOf('S'), MysticModItems.redstoneShards, Character.valueOf('B'), new ItemStack(MysticModItems.crudeMysticBattery,1, OreDictionary.WILDCARD_VALUE), Character.valueOf('R'), MysticModBlocks.refinedRedstone, Character.valueOf('M'), MysticModItems.warpedPowerConnector,'P', MysticModItems.moltenRedstone});
    	GameRegistry.addRecipe(new ItemStack(crystalGeneratorBase, 1), new Object[]{
    		"BSB","SRS","BSB", 'B', new ItemStack(MysticModItems.crudeMysticBattery,1, OreDictionary.WILDCARD_VALUE), 'S', MysticModItems.moltencSteel, 'R', refinedRedstone
    	});
    	GameRegistry.addRecipe(new ItemStack(mysticRedStorageMrk2, 1) , new Object[]{
    		"RTR", "IFI", "RRR", Character.valueOf('R'), new ItemStack(MysticModItems.crudeMysticBattery,1, OreDictionary.WILDCARD_VALUE), Character.valueOf('I'), new ItemStack(MysticModItems.mrk3Battery,1, OreDictionary.WILDCARD_VALUE), Character.valueOf('F'), MysticModBlocks.mysticRedStorage, Character.valueOf('T'), MysticModItems.ePowerConnector});
    	//inert blocks
    	frm.smelting().addSmelting(mysticGrass.blockID, new ItemStack(inertGrass , 1), 1);
    	frm.smelting().addSmelting(mysticDirt.blockID, new ItemStack(inertDirt , 1), 1);
    	frm.smelting().addSmelting(mysticgenStone.blockID, new ItemStack(inertStone , 1), 1);
    	frm.smelting().addSmelting(mysticCobblestone.blockID, new ItemStack(inertCobble , 1), 1);
    	GameRegistry.addRecipe(new ItemStack(mysticBricks, 4) , new Object[]{
    		"XX","XX", 'X', inertStone});
    	GameRegistry.addRecipe(new ItemStack(mysticBricks, 4) , new Object[]{
    		"XX","XX", 'X', inertCobble});
    //stairs
    	GameRegistry.addRecipe(new ItemStack(mysticCobbleStairs, 6) , new Object[]{
    		"X  ","XX ","XXX", 'X', mysticCobblestone});
    	GameRegistry.addRecipe(new ItemStack(mysticStoneStairs, 6) , new Object[]{
    		"X  ","XX ","XXX", 'X', mysticgenStone});
    	GameRegistry.addRecipe(new ItemStack(mysticBrickStairs, 6) , new Object[]{
    		"X  ","XX ","XXX", 'X', mysticBricks});
    	GameRegistry.addRecipe(new ItemStack(mysticRedPlankStairs, 6) , new Object[]{
    		"X  ","XX ","XXX", 'X', redPlanks});
    	GameRegistry.addRecipe(new ItemStack(mysticIronPlankStairs, 6) , new Object[]{
    		"X  ","XX ","XXX", 'X', ironPlanks});
    	
    //slabs
    	for (int ix = 0; ix < 5; ix++) {
    		
    		ItemStack mysticSlabs = new ItemStack(mysticSlabSingle, 1, ix);
    		switch(ix){
    		case 0:
    			GameRegistry.addShapelessRecipe(new ItemStack(mysticCobblestone, 3),  new Object[]{new ItemStack(mysticSlabSingle,6,0)});
    			LanguageRegistry.addName(mysticSlabSingle, mysticSlabNames[0]);
    			
    		case 1:
    			GameRegistry.addShapelessRecipe(new ItemStack(mysticgenStone, 3),  new Object[]{new ItemStack(mysticSlabSingle,6,1)});
    			LanguageRegistry.addName(mysticSlabSingle, mysticSlabNames[1]);
    			
    		case 2:
    			GameRegistry.addShapelessRecipe(new ItemStack(mysticBricks, 3),  new Object[]{new ItemStack(mysticSlabSingle,6,2)});
    			LanguageRegistry.addName(mysticSlabSingle, mysticSlabNames[2]);
    			
    		case 3:
    			GameRegistry.addShapelessRecipe(new ItemStack(redPlanks, 3),  new Object[]{new ItemStack(mysticSlabSingle,6,3)});
    			LanguageRegistry.addName(mysticSlabSingle, mysticSlabNames[3]);
    			
    		case 4:
    			GameRegistry.addShapelessRecipe(new ItemStack(ironPlanks, 3),  new Object[]{new ItemStack(mysticSlabSingle,6,4)});
    			LanguageRegistry.addName(mysticSlabSingle, mysticSlabNames[4]);
    		
    		}
    		
    		
    	}
    	
    }
	
	
	
	
}

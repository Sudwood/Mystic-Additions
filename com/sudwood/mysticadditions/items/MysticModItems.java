package com.sudwood.mysticadditions.items;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import com.sudwood.mysticadditions.FurnaceRecipesMystic;
import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.mod_MysticAdditions;
import com.sudwood.mysticadditions.blocks.MysticModBlocks;
import com.sudwood.mysticadditions.entity.EntityMysticArrow;
import com.sudwood.mysticadditions.entity.EntityMysticExplosiveArrow;
import com.sudwood.mysticadditions.entity.EntityMysticFireArrow;
import com.sudwood.mysticadditions.entity.EntityMysticTeleArrow;
import com.sudwood.mysticadditions.entity.EntitySteelShuriken;
import com.sudwood.mysticadditions.items.energy.ItemCrudeMysticBattery;
import com.sudwood.mysticadditions.items.energy.ItemDiggingCatalyst;
import com.sudwood.mysticadditions.items.energy.ItemEPowerConnector;
import com.sudwood.mysticadditions.items.energy.ItemMEPowerConnector;
import com.sudwood.mysticadditions.items.energy.ItemMarkRecallMRK2;
import com.sudwood.mysticadditions.items.energy.ItemTPowerConnector;
import com.sudwood.mysticadditions.items.energy.ItemWarpedPowerConnector;
import com.sudwood.mysticadditions.items.tools.ItemAxeMystic;
import com.sudwood.mysticadditions.items.tools.ItemAxeMysticNonSpecial;
import com.sudwood.mysticadditions.items.tools.ItemHoeMystic;
import com.sudwood.mysticadditions.items.tools.ItemHoeMysticNonSpecial;
import com.sudwood.mysticadditions.items.tools.ItemMarkRecallMRK1;
import com.sudwood.mysticadditions.items.tools.ItemMysticArrow;
import com.sudwood.mysticadditions.items.tools.ItemMysticBow;
import com.sudwood.mysticadditions.items.tools.ItemMysticExplosiveArrow;
import com.sudwood.mysticadditions.items.tools.ItemMysticExplosiveArrowhead;
import com.sudwood.mysticadditions.items.tools.ItemMysticFireArrow;
import com.sudwood.mysticadditions.items.tools.ItemMysticFireArrowhead;
import com.sudwood.mysticadditions.items.tools.ItemMysticFreezeArrow;
import com.sudwood.mysticadditions.items.tools.ItemMysticFreezeArrowHead;
import com.sudwood.mysticadditions.items.tools.ItemMysticLightningArrow;
import com.sudwood.mysticadditions.items.tools.ItemMysticLightningArrowHead;
import com.sudwood.mysticadditions.items.tools.ItemMysticTeleArrow;
import com.sudwood.mysticadditions.items.tools.ItemMysticTeleArrowhead;
import com.sudwood.mysticadditions.items.tools.ItemPickaxeMystic;
import com.sudwood.mysticadditions.items.tools.ItemPickaxeMysticNonSpecial;
import com.sudwood.mysticadditions.items.tools.ItemRegularArrowChooser;
import com.sudwood.mysticadditions.items.tools.ItemSpadeMystic;
import com.sudwood.mysticadditions.items.tools.ItemSpadeMysticNonSpecial;
import com.sudwood.mysticadditions.items.tools.ItemSteelShuriken;
import com.sudwood.mysticadditions.items.tools.ItemSwordMystic;
import com.sudwood.mysticadditions.items.tools.ItemSwordMysticNonSpecial;


import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.src.ModLoader;

import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.ShapedOreRecipe;
public class MysticModItems {
	public static   Item refinedIronIngot;
	public static   Item cSteelIngot;
	public static   Item redstoneShards;
	public static   Item moltenRedstone;
	public static   Item mysticPlating;
	public static   Item mysticStone;
	public static   Item mysticBow;
	public static   Item mysticArrow;
	public static   Item mysticTeleArrowhead;
	public static   Item mysticExplosiveArrowhead;
	public static   Item mysticFireArrowhead;
	public static   Item mysticTeleArrow;
	public static   Item mysticExplosiveArrow;
	public static   Item mysticFireArrow;
	public static   Item woodenReinforcements;
	public static   Item regularArrowChooser;
	public static   Item stonePlating;
	public static   Item reinforcedStone;
	public static   Item crudeRedOre;
	public static   Item crudeIron;
	public static   Item crudeRedstone;
	public static   Item crudeIronChunk;
	public static   Item steelShuriken;
	public static   Item enchantedBone;
	public static   Item enchantedBonemeal;
	public static   Item csteelDust;
	public static   Item moltencSteel;
	public static   Item mysticIngot;
	public static   Item moltenmysticAlloy;
	public static   Item markrecallMRK1;
	public static   Item warpShard;
	public static   Item rawWarp;
	public static   Item rawWarpFood;
	public static   Item cookedWarpFood;
	public static   Item warpTarget;
	public static   Item beefBase;
	public static   Item warpedPowerConnector;
	public static   Item crudeMysticBattery;
	public static   Item markRecallMrk2;
	public static   Item mePowerConnector;
	public static   Item ePowerConnector;
	public static   Item tPowerConnector;
	public static   Item airToken;
	public static   Item fireToken;
	public static   Item waterToken;
	public static   Item earthToken;
	public static   Item mysticFreezeArrowhead;
	public static   Item mysticFreezeArrow;
	public static   Item mysticLightningArrowhead;
	public static   Item mysticLightningArrow;
	public static   Item essenceIron;
	public static   Item essenceGold;
	public static   Item essenceDiamond;
	public static   Item diggingCatalyst;
	//steel armor
	static EnumArmorMaterial armorCSTEEL;
	public static   Item helmCSteel;
	public static   Item chestCSteel;
	public static   Item legsCSteel;
	public static   Item bootsCSteel;
	//stone armor
	static EnumArmorMaterial armorStone;
	public static   Item helmStone;
	public static   Item chestStone;
	public static   Item legsStone;
	public static   Item bootsStone;
	//mystic armor
	static EnumArmorMaterial armorMystic;
	public static   Item helmMystic;
	public static   Item chestMystic;
	public static   Item legsMystic;
	public static   Item bootsMystic;
	//tools
	//steel
	static EnumToolMaterial toolCSTEEL;
	public static   Item pickaxeCSteel;
	public static   Item axeCSteel;
	public static   Item swordCSteel;
	public static   Item hoeCSteel;
	public static   Item shovelCSteel;
	//mystic
	static EnumToolMaterial toolMystic;
	public static   Item pickaxeMystic;
	public static   Item axeMystic;
	public static   Item swordMystic;
	public static   Item hoeMystic;
	public static   Item shovelMystic;
	public static   Item mysticknightEgg;
	
	
	public static void init() {
	refinedIronIngot = new ItemRefinedIronIngot(mod_MysticAdditions.refinedironingotid).setUnlocalizedName("RefinedIron").setCreativeTab(mod_MysticAdditions.mysticTab);
	cSteelIngot = new ItemCSteelIngot(mod_MysticAdditions.csteelingotid).setUnlocalizedName("Steel Ingot").setCreativeTab(mod_MysticAdditions.mysticTab);
	redstoneShards = new ItemRedstoneShards(mod_MysticAdditions.redstoneshardsid).setUnlocalizedName("RedstoneShards").setCreativeTab(mod_MysticAdditions.mysticTab);
	moltenRedstone = new ItemMoltenRedstone(mod_MysticAdditions.moltenredstoneid).setUnlocalizedName("MoltenRedstone").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticPlating = new ItemMysticPlating(mod_MysticAdditions.mysticplatingid).setUnlocalizedName("MysticPlating").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticStone = new ItemMysticStone(mod_MysticAdditions.mysticstoneid).setUnlocalizedName("Mysticstone").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticBow = new ItemMysticBow(mod_MysticAdditions.mysticbowid).setUnlocalizedName("MysticBow").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticArrow = new ItemMysticArrow(mod_MysticAdditions.mysticarrowid).setUnlocalizedName("MysticArrow").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticTeleArrowhead = new ItemMysticTeleArrowhead(mod_MysticAdditions.mystictelearrowheadid).setUnlocalizedName("MysticteleArrowhead").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticExplosiveArrowhead = new ItemMysticExplosiveArrowhead(mod_MysticAdditions.mysticexplosivearrowheadid).setUnlocalizedName("MysticexplosiveArrowhead").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticFireArrowhead = new ItemMysticFireArrowhead(mod_MysticAdditions.mysticfirearrowheadid).setUnlocalizedName("MysticfireArrowhead").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticTeleArrow = new ItemMysticTeleArrow(mod_MysticAdditions.mystictelearrowid).setUnlocalizedName("MysticteleArrow").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticExplosiveArrow = new ItemMysticExplosiveArrow(mod_MysticAdditions.mysticexplosivearrowid).setUnlocalizedName("MysticexplosiveArrow").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticFireArrow = new ItemMysticFireArrow(mod_MysticAdditions.mysticfirearrowid).setUnlocalizedName("MysticfireArrow").setCreativeTab(mod_MysticAdditions.mysticTab);
	woodenReinforcements = new ItemWoodenReinforcements(mod_MysticAdditions.woodenreinforcementsid).setUnlocalizedName("WoodenReinforcements").setCreativeTab(mod_MysticAdditions.mysticTab);
	regularArrowChooser = new ItemRegularArrowChooser(mod_MysticAdditions.regulararrowchooserid).setUnlocalizedName("RegularArrowChooser").setCreativeTab(mod_MysticAdditions.mysticTab);
	stonePlating = new ItemStonePlating(mod_MysticAdditions.stoneplatingid).setUnlocalizedName("StonePlating").setCreativeTab(mod_MysticAdditions.mysticTab);
	reinforcedStone = new ItemReinforcedStone(mod_MysticAdditions.reinforcedstoneid).setUnlocalizedName("Reinforced Stone").setCreativeTab(mod_MysticAdditions.mysticTab);
	crudeRedOre = new ItemCrudeRedOre(mod_MysticAdditions.cruderedoreid).setUnlocalizedName("cruderedoreid").setCreativeTab(mod_MysticAdditions.mysticTab);
	crudeIron = new ItemCrudeIron(mod_MysticAdditions.crudeironid).setUnlocalizedName("crudeironid").setCreativeTab(mod_MysticAdditions.mysticTab);
	crudeRedstone = new ItemCrudeRedstone(mod_MysticAdditions.cruderedstoneid).setUnlocalizedName("cruderedstoneid").setCreativeTab(mod_MysticAdditions.mysticTab);
	crudeIronChunk = new ItemCrudeIronChunk(mod_MysticAdditions.crudeironchunkid).setUnlocalizedName("crudeironchunkid").setCreativeTab(mod_MysticAdditions.mysticTab);
	steelShuriken = new ItemSteelShuriken(mod_MysticAdditions.steelshurikenid).setUnlocalizedName("steelshurikenid").setCreativeTab(mod_MysticAdditions.mysticTab);
	//public static   Item mysticShuriken = new ItemMysticShuriken(mysticshurikenid).setUnlocalizedName("mysticshurikenid").setIconCoord(10, 1);
	enchantedBone = new ItemEchantedBone(mod_MysticAdditions.enchantedboneid).setUnlocalizedName("enchantedboneid").setCreativeTab(mod_MysticAdditions.mysticTab);
	enchantedBonemeal = new ItemEnchantedBonemeal(mod_MysticAdditions.enchantedbonemealid).setUnlocalizedName("enchantedbonemealid").setCreativeTab(mod_MysticAdditions.mysticTab);
	csteelDust = new ItemCSteelDust(mod_MysticAdditions.csteeldustid).setUnlocalizedName("csteeldust").setCreativeTab(mod_MysticAdditions.mysticTab);
	moltencSteel = new ItemMoltenCSteel(mod_MysticAdditions.moltencsteelid).setUnlocalizedName("csteelmolten").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticIngot = new ItemMysticIngot(mod_MysticAdditions.mysticingotid).setUnlocalizedName("mysticingot").setCreativeTab(mod_MysticAdditions.mysticTab);
	moltenmysticAlloy = new ItemMoltenMysticAlloy(mod_MysticAdditions.moltenmysticalloyid).setUnlocalizedName("moltenmysticalloy").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticknightEgg = new ItemMysticKnightEgg(mod_MysticAdditions.mysticknighteggid).setUnlocalizedName("mysticknightegg").setCreativeTab(mod_MysticAdditions.mysticTab);
	markrecallMRK1 = new ItemMarkRecallMRK1(mod_MysticAdditions.markrecallmrk1id).setUnlocalizedName("MRMRK1").setCreativeTab(mod_MysticAdditions.mysticTab);
	warpShard = new ItemWarpShard(mod_MysticAdditions.warpshardid).setUnlocalizedName("warpshard").setCreativeTab(mod_MysticAdditions.mysticTab);
	rawWarp = new ItemRawWarp(mod_MysticAdditions.rawwarpid).setUnlocalizedName("rawwarp").setCreativeTab(mod_MysticAdditions.mysticTab);
	rawWarpFood = new ItemRawWarpFood(mod_MysticAdditions.rawwarpfoodid, 3, 1F, false).setAlwaysEdible().setUnlocalizedName("rawwarpfood").setCreativeTab(mod_MysticAdditions.mysticTab);
	cookedWarpFood = new ItemCookedWarpFood(mod_MysticAdditions.cookedwarpfoodid, 8, 10F, false).setAlwaysEdible().setUnlocalizedName("cookedwarpfood").setCreativeTab(mod_MysticAdditions.mysticTab);
	//warpTarget = new ItemWarpTarget(mod_MysticAdditions.warptargetid).setUnlocalizedName("WarpTarget").setIconCoord(0,0);
	beefBase = new ItemBeefBase(mod_MysticAdditions.beefbaseid).setUnlocalizedName("beefbase").setCreativeTab(mod_MysticAdditions.mysticTab);
	warpedPowerConnector = new ItemWarpedPowerConnector(mod_MysticAdditions.powerwarpconnectorid).setUnlocalizedName("WarpPowerConnector").setCreativeTab(mod_MysticAdditions.mysticTab);
	crudeMysticBattery = new ItemCrudeMysticBattery(mod_MysticAdditions.crudemysticbatteryid, 4000, 1).setUnlocalizedName("crudeBattery").setCreativeTab(mod_MysticAdditions.mysticTab);
	markRecallMrk2 = new ItemMarkRecallMRK2(mod_MysticAdditions.markrecallmrk2id, 4000, 10).setUnlocalizedName("MarkRecallMRK2").setCreativeTab(mod_MysticAdditions.mysticTab);
	mePowerConnector = new ItemMEPowerConnector(mod_MysticAdditions.warppowerconnector2id).setUnlocalizedName("MEPowerConnector").setCreativeTab(mod_MysticAdditions.mysticTab);
	ePowerConnector = new ItemEPowerConnector(mod_MysticAdditions.warppowerconnector3id).setUnlocalizedName("EPowerConnector").setCreativeTab(mod_MysticAdditions.mysticTab);
	tPowerConnector = new ItemTPowerConnector(mod_MysticAdditions.warppowerconnector4id).setUnlocalizedName("TPowerConnector").setCreativeTab(mod_MysticAdditions.mysticTab);
	airToken = new ItemAirToken(mod_MysticAdditions.airtokenid).setUnlocalizedName("AirToken").setCreativeTab(mod_MysticAdditions.mysticTab);
	fireToken = new ItemFireToken(mod_MysticAdditions.firetokenid).setUnlocalizedName("FireToken").setCreativeTab(mod_MysticAdditions.mysticTab);
	waterToken = new ItemWaterToken(mod_MysticAdditions.watertokenid).setUnlocalizedName("WaterToken").setCreativeTab(mod_MysticAdditions.mysticTab);
	earthToken = new ItemEarthToken(mod_MysticAdditions.earthtokenid).setUnlocalizedName("EarthToken").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticFreezeArrowhead = new ItemMysticFreezeArrowHead(mod_MysticAdditions.mysticfreezearrowheadid).setUnlocalizedName("FreezeArrowHead").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticLightningArrowhead = new ItemMysticLightningArrowHead(mod_MysticAdditions.mysticlightningarrowheadid).setUnlocalizedName("LightningArrowHead").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticFreezeArrow = new ItemMysticFreezeArrow(mod_MysticAdditions.mysticfreezearrowid).setUnlocalizedName("FreezeArrow").setCreativeTab(mod_MysticAdditions.mysticTab);
	mysticLightningArrow = new ItemMysticLightningArrow(mod_MysticAdditions.mysticlightningarrowid).setUnlocalizedName("LightningArrow").setCreativeTab(mod_MysticAdditions.mysticTab);
	essenceIron = new ItemIronEssence(mod_MysticAdditions.ironessenceid).setUnlocalizedName("IronEssence").setCreativeTab(mod_MysticAdditions.mysticTab);
	essenceGold = new ItemGoldEssence(mod_MysticAdditions.goldessenceid).setUnlocalizedName("goldEssence").setCreativeTab(mod_MysticAdditions.mysticTab);
	essenceDiamond = new ItemDiamondEssence(mod_MysticAdditions.diamondessenceid).setUnlocalizedName("diamondEssence").setCreativeTab(mod_MysticAdditions.mysticTab);
	diggingCatalyst = new ItemDiggingCatalyst(mod_MysticAdditions.diggingcatalystid, 16000, 30).setUnlocalizedName("diggingCatalyst").setCreativeTab(mod_MysticAdditions.mysticTab);
	
	
	
	
	FurnaceRecipesMystic frm = new FurnaceRecipesMystic();
	//MysticClientProxy mcp = new MysticClientProxy();
	MysticCommonProxy mcp = new MysticCommonProxy();
		//armor
	armorCSTEEL = EnumHelper.addArmorMaterial("CSTEEL", 23, new int[] {2, 7, 5, 2}, 13);
	int renderSteelArmor = mcp.addArmor("CSTEEL");
	
	helmCSteel = (new ItemArmorMysticsteel(mod_MysticAdditions.csteelhelmid, armorCSTEEL, renderSteelArmor, 0)).setUnlocalizedName("CSteel Helm").setCreativeTab(mod_MysticAdditions.mysticTab);
	chestCSteel = (new ItemArmorMysticsteel(mod_MysticAdditions.csteelchestid, armorCSTEEL, renderSteelArmor, 1)).setUnlocalizedName("CSteel Chest").setCreativeTab(mod_MysticAdditions.mysticTab);
	legsCSteel = (new ItemArmorMysticsteel(mod_MysticAdditions.csteellegsid, armorCSTEEL, renderSteelArmor, 2)).setUnlocalizedName("CSteel Legs").setCreativeTab(mod_MysticAdditions.mysticTab);
	bootsCSteel = (new ItemArmorMysticsteel(mod_MysticAdditions.csteelbootsid, armorCSTEEL, renderSteelArmor, 3)).setUnlocalizedName("CSteel Boots").setCreativeTab(mod_MysticAdditions.mysticTab);
			//stone
	int renderStoneArmor = mcp.addArmor("STONE");
	armorStone = EnumHelper.addArmorMaterial("STONE", 13, new int[] { 2, 4, 3, 3}, 7);
	helmStone = (new ItemArmorMysticstone(mod_MysticAdditions.stonehelmid, armorStone, renderStoneArmor, 0)).setUnlocalizedName("Stone Helm").setCreativeTab(mod_MysticAdditions.mysticTab);
	chestStone = (new ItemArmorMysticstone(mod_MysticAdditions.stonechestid, armorStone, renderStoneArmor, 1)).setUnlocalizedName("Stone Chest").setCreativeTab(mod_MysticAdditions.mysticTab);
	legsStone = (new ItemArmorMysticstone(mod_MysticAdditions.stonelegsid, armorStone, renderStoneArmor, 2)).setUnlocalizedName("Stone Legs").setCreativeTab(mod_MysticAdditions.mysticTab);
	bootsStone = (new ItemArmorMysticstone(mod_MysticAdditions.stonebootsid, armorStone, renderStoneArmor, 3)).setUnlocalizedName("Stone Boots").setCreativeTab(mod_MysticAdditions.mysticTab);
			//mystic
	int renderMysticArmor = mcp.addArmor("Mystic");
	armorMystic = EnumHelper.addArmorMaterial("Mystic", 66, new int[] { 6, 11, 9, 6}, 25);
	helmMystic = (new ItemArmorMystic(mod_MysticAdditions.mystichelmid, armorMystic, renderMysticArmor, 0)).setUnlocalizedName("mystic Helm").setCreativeTab(mod_MysticAdditions.mysticTab);
	chestMystic = (new ItemArmorMystic(mod_MysticAdditions.mysticchestid, armorMystic, renderMysticArmor, 1)).setUnlocalizedName("mystic Chest").setCreativeTab(mod_MysticAdditions.mysticTab);
	legsMystic = (new ItemArmorMystic(mod_MysticAdditions.mysticlegsid, armorMystic, renderMysticArmor, 2)).setUnlocalizedName("mystic Legs").setCreativeTab(mod_MysticAdditions.mysticTab);
	bootsMystic = (new ItemArmorMystic(mod_MysticAdditions.mysticbootsid, armorMystic, renderMysticArmor, 3)).setUnlocalizedName("mystic Boots").setCreativeTab(mod_MysticAdditions.mysticTab);
	
	//tools
		//csteel
	toolCSTEEL = EnumHelper.addToolMaterial("CSTEEL", 2, 900, 8F, 3, 12);
	pickaxeCSteel = (new ItemPickaxeMysticNonSpecial(mod_MysticAdditions.csteelpickid, toolCSTEEL)).setUnlocalizedName("CSteel Pick").setCreativeTab(mod_MysticAdditions.mysticTab);
	axeCSteel = (new ItemAxeMysticNonSpecial(mod_MysticAdditions.csteelaxeid, toolCSTEEL)).setUnlocalizedName("CSteel Axe").setCreativeTab(mod_MysticAdditions.mysticTab);
	swordCSteel = (new ItemSwordMysticNonSpecial(mod_MysticAdditions.csteelswordid, toolCSTEEL)).setUnlocalizedName("CSteel Sword").setCreativeTab(mod_MysticAdditions.mysticTab);
	hoeCSteel = (new ItemHoeMysticNonSpecial(mod_MysticAdditions.csteelhoeid, toolCSTEEL)).setUnlocalizedName("CSteel Hoe").setCreativeTab(mod_MysticAdditions.mysticTab);
	shovelCSteel = (new ItemSpadeMysticNonSpecial(mod_MysticAdditions.csteelspadeid, toolCSTEEL)).setUnlocalizedName("CSteel Shovel").setCreativeTab(mod_MysticAdditions.mysticTab);
	
		//mystic
	toolMystic = EnumHelper.addToolMaterial("MYSTIC", 3, 6000, 30F, 20, 25);
	pickaxeMystic = (new ItemPickaxeMystic(mod_MysticAdditions.mysticpickid, toolMystic)).setUnlocalizedName("Mystic Pick").setCreativeTab(mod_MysticAdditions.mysticTab);
	axeMystic = (new ItemAxeMystic(mod_MysticAdditions.mysticaxeid, toolMystic)).setUnlocalizedName("Mystic Axe").setCreativeTab(mod_MysticAdditions.mysticTab);
	swordMystic = (new ItemSwordMystic(mod_MysticAdditions.mysticswordid, toolMystic)).setUnlocalizedName("Mystic Sword").setCreativeTab(mod_MysticAdditions.mysticTab);
	hoeMystic = (new ItemHoeMystic(mod_MysticAdditions.mystichoeid, toolMystic)).setUnlocalizedName("Mystic Hoe").setCreativeTab(mod_MysticAdditions.mysticTab);
	shovelMystic = (new ItemSpadeMystic(mod_MysticAdditions.mysticspadeid, toolMystic)).setUnlocalizedName("Mystic Shovel").setCreativeTab(mod_MysticAdditions.mysticTab);
	
	MinecraftForge.setToolClass(pickaxeCSteel, "pickaxe", 2);
    MinecraftForge.setToolClass(shovelCSteel, "shovel", 2);
    MinecraftForge.setToolClass(axeCSteel, "axe", 2);
    MinecraftForge.setToolClass(pickaxeMystic, "pickaxe", 2);
    MinecraftForge.setToolClass(shovelMystic, "shovel", 2);
    MinecraftForge.setToolClass(axeMystic, "axe", 2);
	
	//refined iron ingot
	LanguageRegistry.addName(refinedIronIngot, "Refined Iron Ingot");
	frm.smelting().addSmelting(Item.ingotIron.itemID, new ItemStack(refinedIronIngot , 1), 0);
	
	
		//CSteelIngot
	LanguageRegistry.addName(cSteelIngot, "Steel Ingot");
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(cSteelIngot, 1) , new Object[]{
		"XY", Character.valueOf('X'), "ingotRefinedIron", Character.valueOf('Y'), MysticModBlocks.refinedCarbon}));
	GameRegistry.addRecipe(new ItemStack(Item.bucketEmpty, 1) , new Object[]{
		"X X"," X ", Character.valueOf('X'), cSteelIngot});
        
   //redstone shards     
	LanguageRegistry.addName(redstoneShards, "Redstone Shards");
	GameRegistry.addRecipe(new ItemStack(redstoneShards, 1) , new Object[]{
		"XYX", Character.valueOf('Y'), MysticModBlocks.refinedRedstone, Character.valueOf('X'), Block.cobblestone});
        
        
	//molten redstone
	LanguageRegistry.addName(moltenRedstone, "Molten Redstone");
	frm.smelting().addSmelting(redstoneShards.itemID, new ItemStack(moltenRedstone , 1), 0);
	
	//mystic plating
	LanguageRegistry.addName(mysticPlating, "Mystic Plating");
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mysticPlating, 1) , new Object[]{
		"XXX", "YYY", "ZZZ", Character.valueOf('X'), MysticModBlocks.refinedRedstone, Character.valueOf('Y'), "ingotSteel", Character.valueOf('Z'), moltenRedstone}));
	
	
	//Mystic stone
	
	LanguageRegistry.addName(mysticStone, "Mystic Stone");
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mysticStone, 1) , new Object[]{
		"YYY","ZZZ","XXX", Character.valueOf('X'), moltenRedstone,Character.valueOf('Y'), MysticModBlocks.mysticGlass,Character.valueOf('Z'), "ingotSteel"}));
	
	
	//Mystic Bow
	LanguageRegistry.addName(mysticBow, "Mystic Bow");
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(mysticBow, 1) , new Object[]{
		"XY ","XZY","XY ", Character.valueOf('Z'), mysticStone, Character.valueOf('Y'), mysticPlating, Character.valueOf('X'), "ingotSteel"}));
	frm.smelting().addSmelting(mysticBow.itemID, new ItemStack(mysticPlating , 3), 0);
	
	
	//Mystic Arrow
	LanguageRegistry.addName(mysticArrow, "Mystic Arrow");
	GameRegistry.addRecipe(new ItemStack(mysticArrow, 6) , new Object[]{
		"XYZ", Character.valueOf('X'), mysticStone, Character.valueOf('Y'), Item.arrow,Character.valueOf('Z'), mysticPlating});
	 ModLoader.registerEntityID(EntityMysticArrow.class, "Mystic Arrow", ModLoader.getUniqueEntityId());
	 
	
	 //tele arrow head
	 LanguageRegistry.addName(mysticTeleArrowhead, "Dimensional Arrowhead");
		GameRegistry.addRecipe(new ItemStack(mysticTeleArrowhead, 3) , new Object[]{
			"XY", Character.valueOf('X'), mysticStone, Character.valueOf('Y'), Item.enderPearl,});
		
		 
	//explosive arrow head
		 
		 LanguageRegistry.addName(mysticExplosiveArrowhead, "Explosive  Arrowhead");
			GameRegistry.addRecipe(new ItemStack(mysticExplosiveArrowhead, 3) , new Object[]{
			"XY", Character.valueOf('X'), mysticStone, Character.valueOf('Y'), Item.gunpowder, });

			 
	//fire arrow head
			 
			 LanguageRegistry.addName(mysticFireArrowhead, "Flaming Arrowhead");
				GameRegistry.addRecipe(new ItemStack(mysticFireArrowhead, 3) , new Object[]{
					"XY", Character.valueOf('X'), mysticStone, Character.valueOf('Y'), Block.netherrack,});
	//tele arrow
				
				LanguageRegistry.addName(mysticTeleArrow, "Dimensional Arrow");
				GameRegistry.addRecipe(new ItemStack(mysticTeleArrow, 1) , new Object[]{
					"XYZ", Character.valueOf('X'), mysticStone, Character.valueOf('Y'), mysticArrow, Character.valueOf('Z'), mysticTeleArrowhead});	
				
				
	//explosive arrow
			LanguageRegistry.addName(mysticExplosiveArrow, "Explosive Arrow");
				GameRegistry.addRecipe(new ItemStack(mysticExplosiveArrow, 1) , new Object[]{
					"XYZ", Character.valueOf('X'), mysticStone, Character.valueOf('Y'), mysticArrow, Character.valueOf('Z'), mysticExplosiveArrowhead});
			
				
	//fire arrow
				LanguageRegistry.addName(mysticFireArrow, "Flaming Arrow");
				GameRegistry.addRecipe(new ItemStack(mysticFireArrow, 1) , new Object[]{
					"XYZ", Character.valueOf('X'), mysticStone, Character.valueOf('Y'), mysticArrow, Character.valueOf('Z'), mysticFireArrowhead});
	//freeze arrows
				LanguageRegistry.addName(mysticFreezeArrowhead, "Freezing Arrowhead");
				LanguageRegistry.addName(mysticFreezeArrow, "Freezing Arrow");
				GameRegistry.addRecipe(new ItemStack(mysticFreezeArrowhead, 3) , new Object[]{
					"XY", Character.valueOf('X'), mysticStone, Character.valueOf('Y'), Block.ice});
				GameRegistry.addRecipe(new ItemStack(mysticFreezeArrow, 1) , new Object[]{
					"XYZ", Character.valueOf('X'), mysticStone, Character.valueOf('Y'), mysticArrow, Character.valueOf('Z'), mysticFreezeArrowhead});
				
	//Lightning arrows
				LanguageRegistry.addName(mysticLightningArrowhead, "Lightning Arrowhead");
				LanguageRegistry.addName(mysticLightningArrow, "Lightning Arrow");
				GameRegistry.addRecipe(new ItemStack(mysticLightningArrowhead, 3) , new Object[]{
					"XY", Character.valueOf('X'), mysticStone, Character.valueOf('Y'), refinedIronIngot});
				GameRegistry.addRecipe(new ItemStack(mysticLightningArrow, 1) , new Object[]{
					"XYZ", Character.valueOf('X'), mysticStone, Character.valueOf('Y'), mysticArrow, Character.valueOf('Z'), mysticLightningArrowhead});
				
	//WoodenReinforcements
				
				LanguageRegistry.addName(woodenReinforcements, "Wooden Reinforcements");
				GameRegistry.addRecipe(new ItemStack(woodenReinforcements, 1) , new Object[]{
					"XXX","XXX","XXX", Character.valueOf('X'), Item.stick});
				
				
	//RegularArrowChooser
	
				LanguageRegistry.addName(regularArrowChooser, "Regular Arrow Chooser");
				GameRegistry.addRecipe(new ItemStack(regularArrowChooser, 1) , new Object[]{
					"XY", Character.valueOf('X'), mysticStone, Character.valueOf('Y'), Item.arrow});
	
	//stone plating
				
				LanguageRegistry.addName(stonePlating, "Stone Plating");
				GameRegistry.addRecipe(new ItemStack(stonePlating, 1) , new Object[]{
					"XXX","XXX","XXX", Character.valueOf('X'), Block.cobblestone});		
	
	//reinforced stone
				LanguageRegistry.addName(reinforcedStone, "Reinforced Stone Plating");
				GameRegistry.addRecipe(new ItemStack(reinforcedStone, 1) , new Object[]{
					"XY", Character.valueOf('X'), stonePlating,Character.valueOf('Y'), woodenReinforcements });	
	
	//steel dust
	LanguageRegistry.addName(csteelDust, "Steel Dust");
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(csteelDust, 1) , new Object[]{
					"YXY", Character.valueOf('X'), "ingotSteel",Character.valueOf('Y'), Block.cobblestone }));
	//molten steel
	LanguageRegistry.addName(moltencSteel, "Molten Steel");
	frm.smelting().addSmelting(csteelDust.itemID, new ItemStack(moltencSteel , 1), 0);
	
	//mystic ingot
	LanguageRegistry.addName(mysticIngot, "Mystic Ingot");
	GameRegistry.addRecipe(new ItemStack(mysticIngot, 1) , new Object[]{
					"XXX","XXX","XXX", Character.valueOf('X'), mysticPlating });
	
	
	
					
	//molten mystic alloy
	LanguageRegistry.addName(moltenmysticAlloy, "Molten Mystic Alloy");
	frm.smelting().addSmelting(mysticIngot.itemID, new ItemStack(moltenmysticAlloy , 1), 0);
	
	//stufffromtrees
				LanguageRegistry.addName(crudeRedOre, "Crude Red Ore");
				GameRegistry.addRecipe(new ItemStack(crudeRedOre, 4) , new Object[]{
					"XX","XX", Character.valueOf('X'), MysticModBlocks.redLog });	
				LanguageRegistry.addName(crudeIron, "Crude Iron");
				GameRegistry.addRecipe(new ItemStack(crudeIron, 4) , new Object[]{
					"XX","XX", Character.valueOf('X'), MysticModBlocks.ironLog });	
				LanguageRegistry.addName(crudeRedstone, "Crude Redstone");
				GameRegistry.addRecipe(new ItemStack(crudeRedstone, 1) , new Object[]{
					"XXX","XXX","XXX", Character.valueOf('X'), crudeRedOre });	
				LanguageRegistry.addName(crudeIronChunk, "Crude Iron Chunk");
				GameRegistry.addRecipe(new ItemStack(crudeIronChunk, 1) , new Object[]{
					"XXX","XXX","XXX", Character.valueOf('X'), crudeIron });
				enchantedBone.setContainerItem(enchantedBone);
				LanguageRegistry.addName(enchantedBone, "Enchanted Bone");
				GameRegistry.addRecipe(new ItemStack(enchantedBone, 1) , new Object[]{
					"XXX","XYX","XXX", Character.valueOf('X'), Item.bone, Character.valueOf('Y'), Item.redstone });	
				LanguageRegistry.addName(enchantedBonemeal, "Enchanted Bonemeal");
				GameRegistry.addRecipe(new ItemStack(enchantedBonemeal, 1) , new Object[]{
					"XY", Character.valueOf('X'), enchantedBone, Character.valueOf('Y'), new ItemStack (Item.dyePowder, 1, 15) });
				frm.smelting().addSmelting(crudeRedstone.itemID, new ItemStack(Item.redstone, 1), 0);
				frm.smelting().addSmelting(crudeIronChunk.itemID, new ItemStack(Item.ingotIron, 1), 0);
				/*GameRegistry.addRecipe(new ItemStack(enchantedBonemeal, 64) , new Object[]{
					"X", Character.valueOf('X'), Item.stick, });
				GameRegistry.addRecipe(new ItemStack(refinedIronBlock, 64) , new Object[]{
					"XX", Character.valueOf('X'), Item.stick, });*/
	//shuriken			
				LanguageRegistry.addName(steelShuriken, "Steel Shuriken");
				CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(steelShuriken, 16) , new Object[]{
					"X", Character.valueOf('X'), "ingotSteel" }));
				
		//mystic knight egg		
				
				LanguageRegistry.addName(mysticknightEgg, "Mystic Knight Spawner");
				
				//mystic feather
				

	
	//cSteel armor
	LanguageRegistry.addName(helmCSteel, "Steel Helmet");
	LanguageRegistry.addName(chestCSteel, "Steel Breastplate");
	LanguageRegistry.addName(legsCSteel, "Steel Legguards");
	LanguageRegistry.addName(bootsCSteel, "Steel Greaves");
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(helmCSteel, 1) , new Object[]{
		"XXX", "XYX", Character.valueOf('X'),  "ingotSteel", Character.valueOf('Y'), woodenReinforcements}));
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(chestCSteel, 1) , new Object[]{
		"XYX","XXX", "XXX", Character.valueOf('X'),  "ingotSteel", Character.valueOf('Y'), woodenReinforcements}));
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(legsCSteel, 1) , new Object[]{
		"XXX","XYX", "X X", Character.valueOf('X'),  "ingotSteel", Character.valueOf('Y'), woodenReinforcements}));
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(bootsCSteel, 1) , new Object[]{
		"XYX", "X X", Character.valueOf('X'),  "ingotSteel", Character.valueOf('Y'), woodenReinforcements}));
	frm.smelting().addSmelting(helmCSteel.itemID, new ItemStack(cSteelIngot , 4), 0);
	frm.smelting().addSmelting(chestCSteel.itemID, new ItemStack(cSteelIngot , 7), 0);
	frm.smelting().addSmelting(legsCSteel.itemID, new ItemStack(cSteelIngot , 6), 0);
	frm.smelting().addSmelting(bootsCSteel.itemID, new ItemStack(cSteelIngot , 3), 0);
	//mystic armor
	LanguageRegistry.addName(helmMystic, "Mystic Helmet");
	LanguageRegistry.addName(chestMystic, "Mystic Breastplate");
	LanguageRegistry.addName(legsMystic, "Mystic Legguards");
	LanguageRegistry.addName(bootsMystic, "Mystic Greaves");
	GameRegistry.addRecipe(new ItemStack(helmMystic, 1) , new Object[]{
		"XXX", "X X", Character.valueOf('X'),  mysticIngot});
	GameRegistry.addRecipe(new ItemStack(chestMystic, 1) , new Object[]{
		"X X","XXX", "XXX", Character.valueOf('X'),  mysticIngot});
	GameRegistry.addRecipe(new ItemStack(legsMystic, 1) , new Object[]{
		"XXX","X X", "X X", Character.valueOf('X'),  mysticIngot});
	GameRegistry.addRecipe(new ItemStack(bootsMystic, 1) , new Object[]{
		"X X", "X X", Character.valueOf('X'),  mysticIngot});
	frm.smelting().addSmelting(helmMystic.itemID, new ItemStack(mysticIngot , 4), 0);
	frm.smelting().addSmelting(chestMystic.itemID, new ItemStack(mysticIngot , 7), 0);
	frm.smelting().addSmelting(legsMystic.itemID, new ItemStack(mysticIngot , 6), 0);
	frm.smelting().addSmelting(bootsMystic.itemID, new ItemStack(mysticIngot , 3), 0);
	
	//stone armor
	
	LanguageRegistry.addName(helmStone, "Stone Helmet");
	LanguageRegistry.addName(chestStone, "Stone Breastplate");
	LanguageRegistry.addName(legsStone, "Stone Legguards");
	LanguageRegistry.addName(bootsStone, "Stone Greaves");
	GameRegistry.addRecipe(new ItemStack(helmStone, 1) , new Object[]{
		"XXX", "X X", Character.valueOf('X'),  reinforcedStone});
	GameRegistry.addRecipe(new ItemStack(chestStone, 1) , new Object[]{
		"X X","XXX", "XXX", Character.valueOf('X'),  reinforcedStone});
	GameRegistry.addRecipe(new ItemStack(legsStone, 1) , new Object[]{
		"XXX","X X", "X X", Character.valueOf('X'),  reinforcedStone});
	GameRegistry.addRecipe(new ItemStack(bootsStone, 1) , new Object[]{
		"X X", "X X", Character.valueOf('X'),  reinforcedStone});
	
	
	//csteel tools
	LanguageRegistry.addName(pickaxeCSteel, "Steel Pickaxe");
	LanguageRegistry.addName(axeCSteel, "Steel Axe");
	LanguageRegistry.addName(swordCSteel, "Steel Sword");
	LanguageRegistry.addName(hoeCSteel, "Steel Hoe");
	LanguageRegistry.addName(shovelCSteel, "Steel Shovel");
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(pickaxeCSteel, 1) , new Object[]{
		"XXX"," Y ", " Y ", Character.valueOf('X'),  "ingotSteel", Character.valueOf('Y'), woodenReinforcements}));
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(axeCSteel, 1) , new Object[]{
		"XX ","XY ", " Y ", Character.valueOf('X'),  "ingotSteel", Character.valueOf('Y'), woodenReinforcements}));
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(axeCSteel, 1) , new Object[]{
		" XX"," YX", " Y ", Character.valueOf('X'),  "ingotSteel", Character.valueOf('Y'), woodenReinforcements}));
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(swordCSteel, 1) , new Object[]{
		" X "," X ", " Y ", Character.valueOf('X'),  "ingotSteel", Character.valueOf('Y'), woodenReinforcements}));
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(hoeCSteel, 1) , new Object[]{
		" XX"," Y ", " Y ", Character.valueOf('X'),  "ingotSteel", Character.valueOf('Y'), woodenReinforcements}));
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(hoeCSteel, 1) , new Object[]{
		"XX "," Y ", " Y ", Character.valueOf('X'),  "ingotSteel", Character.valueOf('Y'), woodenReinforcements}));
	CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe(new ItemStack(shovelCSteel, 1) , new Object[]{
		" X "," Y ", " Y ", Character.valueOf('X'),  "ingotSteel", Character.valueOf('Y'), woodenReinforcements}));
	
	//mystic tools
	LanguageRegistry.addName(pickaxeMystic, "Mystic Pickaxe");
	LanguageRegistry.addName(axeMystic, "Mystic Axe");
	LanguageRegistry.addName(swordMystic, "Mystic Sword");
	LanguageRegistry.addName(hoeMystic, "Mystic Hoe");
	LanguageRegistry.addName(shovelMystic, "Mystic Shovel");
	GameRegistry.addRecipe(new ItemStack(pickaxeMystic, 1) , new Object[]{
		"XXX"," Y ", " Y ", Character.valueOf('X'), mysticIngot, Character.valueOf('Y'), cSteelIngot});
	GameRegistry.addRecipe(new ItemStack(axeMystic, 1) , new Object[]{
		"XX ","XY ", " Y ", Character.valueOf('X'), mysticIngot, Character.valueOf('Y'), cSteelIngot});
	GameRegistry.addRecipe(new ItemStack(axeMystic, 1) , new Object[]{
		" XX"," YX", " Y ", Character.valueOf('X'), mysticIngot, Character.valueOf('Y'), cSteelIngot});
	GameRegistry.addRecipe(new ItemStack(swordMystic, 1) , new Object[]{
		" X "," X ", " Y ", Character.valueOf('X'), mysticIngot, Character.valueOf('Y'), cSteelIngot});
	GameRegistry.addRecipe(new ItemStack(hoeMystic, 1) , new Object[]{
		" XX"," Y ", " Y ", Character.valueOf('X'), mysticIngot, Character.valueOf('Y'), cSteelIngot});
	GameRegistry.addRecipe(new ItemStack(hoeMystic, 1) , new Object[]{
		"XX "," Y ", " Y ", Character.valueOf('X'), mysticIngot, Character.valueOf('Y'), cSteelIngot});
	GameRegistry.addRecipe(new ItemStack(shovelMystic, 1) , new Object[]{
		" X "," Y ", " Y ", Character.valueOf('X'), mysticIngot, Character.valueOf('Y'), cSteelIngot});

    // teleportation
    LanguageRegistry.addName(markrecallMRK1, "Mark Recall MRK1");
    GameRegistry.addRecipe(new ItemStack(markrecallMRK1, 1), new Object[]{
    	"XYX","ZBF","XYX", 'X', moltenRedstone, 'Y', cSteelIngot, 'Z', Item.pocketSundial, 'B', mysticStone, 'F', Item.compass
    });
    LanguageRegistry.addName(markRecallMrk2, "Mark Recall MRK2");
    frm.smelting().addSmelting(markrecallMRK1.itemID, new ItemStack(markrecallMRK1 , 1 , 0), 0);
    //Warp items
    LanguageRegistry.addName(rawWarp, "Raw Warp");
    LanguageRegistry.addName(warpShard, "Warp Shard");
    frm.smelting().addSmelting(mod_MysticAdditions.inertmysticdirtid, new ItemStack(rawWarp, 1), 0);
    frm.smelting().addSmelting(mod_MysticAdditions.inertmysticgrassid, new ItemStack(rawWarp, 1), 0);
    frm.smelting().addSmelting(mod_MysticAdditions.inertmysticgenstoneid, new ItemStack(rawWarp, 1), 0);
    frm.smelting().addSmelting(mod_MysticAdditions.inertmysticcobblestoneid, new ItemStack(rawWarp, 1), 0);
    frm.smelting().addSmelting(mod_MysticAdditions.mysticbricksid, new ItemStack(rawWarp, 1), 0);
    GameRegistry.addRecipe(new ItemStack(warpShard, 1), new Object[]{
    	"XXX","XYX","XXX", 'X', rawWarp, 'Y', redstoneShards
    });
    LanguageRegistry.addName(rawWarpFood, "Unrefined Edible Warp");
    LanguageRegistry.addName(cookedWarpFood, "Edible Warp");
    LanguageRegistry.addName(beefBase, "Warp Solidifier");
    GameRegistry.addRecipe(new ItemStack(beefBase, 1), new Object[]{
    	"X","Y", 'X', Item.beefRaw, 'Y', Item.paper
    });
    GameRegistry.addRecipe(new ItemStack(rawWarpFood, 8), new Object[]{
    	"XXX","XYX","XXX", 'X', warpShard, 'Y', beefBase
    });
    frm.smelting().addSmelting(rawWarpFood.itemID, new ItemStack(cookedWarpFood, 1), 12F);
    
    //tokens
    LanguageRegistry.addName(airToken, "Air Token");
    LanguageRegistry.addName(fireToken, "Fire Token");
    LanguageRegistry.addName(waterToken, "Water Token");
    LanguageRegistry.addName(earthToken, "Earth Token");
    
  //power stuff
    LanguageRegistry.addName(warpedPowerConnector, "Inefficient Power Connector");
    LanguageRegistry.addName(crudeMysticBattery, "Crude Mystic Battery");
    LanguageRegistry.addName(mePowerConnector, "Moderately Efficient Power Connector");
    LanguageRegistry.addName(ePowerConnector, "Efficient Power Connector");
    LanguageRegistry.addName(tPowerConnector, "True Power Connector");
    LanguageRegistry.addName(diggingCatalyst, "Digging Catalyst");
    
    
    
    GameRegistry.addRecipe(new ItemStack(crudeMysticBattery, 1, 10), new Object[]{
    	" X ","XZX","XZX", 'X', Block.stone, 'Z', Item.redstone
    });
    GameRegistry.addRecipe(new ItemStack(warpedPowerConnector, 1), new Object[]{
    	"X","XYX","X", 'X', Item.ingotIron, 'Y', new ItemStack(MysticModItems.crudeMysticBattery,1,10)
    });
    GameRegistry.addRecipe(new ItemStack(warpedPowerConnector, 1), new Object[]{
    	"X","XYX","X", 'X', MysticModItems.refinedIronIngot, 'Y', new ItemStack(MysticModItems.crudeMysticBattery,1,10)
    });
    GameRegistry.addRecipe(new ItemStack(warpedPowerConnector, 1), new Object[]{
    	"X","XYX","X", 'X', MysticModItems.cSteelIngot, 'Y', new ItemStack(MysticModItems.crudeMysticBattery,1,10)
    });
    GameRegistry.addRecipe(new ItemStack(warpedPowerConnector, 1), new Object[]{
    	"X","XYX","X", 'X', MysticModItems.mysticIngot, 'Y', new ItemStack(MysticModItems.crudeMysticBattery,1,10)
    });
    GameRegistry.addRecipe(new ItemStack(markRecallMrk2, 1), new Object[]{
    	"ZXZ","XYX","ZXZ", 'Y', MysticModItems.markrecallMRK1, 'X', new ItemStack(MysticModItems.crudeMysticBattery,1,10), 'Z', MysticModItems.moltenRedstone
    });
    GameRegistry.addRecipe(new ItemStack(diggingCatalyst, 1), new Object[]{
    	"ZXZ","XYX","ZXZ", 'Y', MysticModItems.pickaxeCSteel, 'X', new ItemStack(MysticModItems.crudeMysticBattery,1,10), 'Z', MysticModItems.moltenRedstone
    });
    
    
    
    //dusts
    LanguageRegistry.addName(essenceIron, "Iron Essence");
    LanguageRegistry.addName(essenceGold, "Gold Essence");
    LanguageRegistry.addName(essenceDiamond, "Diamond Essence");
    
	}
	
	
	
	
}

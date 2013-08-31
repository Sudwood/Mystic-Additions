package com.sudwood.mysticadditions.items;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import com.sudwood.mysticadditions.FurnaceRecipesMystic;
import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.MysticAdditions;
import com.sudwood.mysticadditions.blocks.MysticModBlocks;
import com.sudwood.mysticadditions.entity.EntityMysticArrow;
import com.sudwood.mysticadditions.entity.EntityMysticExplosiveArrow;
import com.sudwood.mysticadditions.entity.EntityMysticFireArrow;
import com.sudwood.mysticadditions.entity.EntityMysticTeleArrow;
import com.sudwood.mysticadditions.entity.EntitySteelShuriken;
import com.sudwood.mysticadditions.items.energy.ItemArmorSteelRC;
import com.sudwood.mysticadditions.items.energy.ItemAxeSteelRC;
import com.sudwood.mysticadditions.items.energy.ItemCrudeMysticBattery;
import com.sudwood.mysticadditions.items.energy.ItemDiggingCatalyst;
import com.sudwood.mysticadditions.items.energy.ItemEPowerConnector;
import com.sudwood.mysticadditions.items.energy.ItemHoeSteelRC;
import com.sudwood.mysticadditions.items.energy.ItemMEPowerConnector;
import com.sudwood.mysticadditions.items.energy.ItemMarkRecallMRK2;
import com.sudwood.mysticadditions.items.energy.ItemPickaxeSteelRC;
import com.sudwood.mysticadditions.items.energy.ItemRCTeleThrower;
import com.sudwood.mysticadditions.items.energy.ItemShovelSteelRC;
import com.sudwood.mysticadditions.items.energy.ItemSwordSteelRC;
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
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
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
	public static   Item mrk2Battery;
	public static   Item rcTeleThrower;
	public static   Item mrk3Battery;
	//steel armor
	static EnumArmorMaterial armorCSTEEL;
	public static   Item helmCSteel;
	public static   Item chestCSteel;
	public static   Item legsCSteel;
	public static   Item bootsCSteel;
	//Rechargeable steel armor
	public static   Item helmSteelRC;
	public static   Item chestSteelRC;
	public static   Item legsSteelRC;
	public static   Item bootsSteelRC;
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
	public static   Item pickaxeSteelRC;
	public static   Item axeSteelRC;
	public static   Item swordSteelRC;
	public static   Item hoeSteelRC;
	public static   Item shovelSteelRC;
	public static   Item mutliSteelRC;
	//mystic 
	static EnumToolMaterial toolMystic;
	public static   Item pickaxeMystic;
	public static   Item axeMystic;
	public static   Item swordMystic;
	public static   Item hoeMystic;
	public static   Item shovelMystic;
	public static   Item mysticknightEgg;
	
	
	public static void init() {
	refinedIronIngot = new ItemRefinedIronIngot(MysticAdditions.refinedironingotid).setUnlocalizedName("RefinedIron").setCreativeTab(MysticAdditions.mysticTab);
	cSteelIngot = new ItemCSteelIngot(MysticAdditions.csteelingotid).setUnlocalizedName("Steel Ingot").setCreativeTab(MysticAdditions.mysticTab);
	redstoneShards = new ItemRedstoneShards(MysticAdditions.redstoneshardsid).setUnlocalizedName("RedstoneShards").setCreativeTab(MysticAdditions.mysticTab);
	moltenRedstone = new ItemMoltenRedstone(MysticAdditions.moltenredstoneid).setUnlocalizedName("MoltenRedstone").setCreativeTab(MysticAdditions.mysticTab);
	mysticPlating = new ItemMysticPlating(MysticAdditions.mysticplatingid).setUnlocalizedName("MysticPlating").setCreativeTab(MysticAdditions.mysticTab);
	mysticStone = new ItemMysticStone(MysticAdditions.mysticstoneid).setUnlocalizedName("Mysticstone").setCreativeTab(MysticAdditions.mysticTab);
	mysticBow = new ItemMysticBow(MysticAdditions.mysticbowid).setUnlocalizedName("MysticBow").setCreativeTab(MysticAdditions.mysticTab);
	mysticArrow = new ItemMysticArrow(MysticAdditions.mysticarrowid).setUnlocalizedName("MysticArrow").setCreativeTab(MysticAdditions.mysticTab);
	mysticTeleArrowhead = new ItemMysticTeleArrowhead(MysticAdditions.mystictelearrowheadid).setUnlocalizedName("MysticteleArrowhead").setCreativeTab(MysticAdditions.mysticTab);
	mysticExplosiveArrowhead = new ItemMysticExplosiveArrowhead(MysticAdditions.mysticexplosivearrowheadid).setUnlocalizedName("MysticexplosiveArrowhead").setCreativeTab(MysticAdditions.mysticTab);
	mysticFireArrowhead = new ItemMysticFireArrowhead(MysticAdditions.mysticfirearrowheadid).setUnlocalizedName("MysticfireArrowhead").setCreativeTab(MysticAdditions.mysticTab);
	mysticTeleArrow = new ItemMysticTeleArrow(MysticAdditions.mystictelearrowid).setUnlocalizedName("MysticteleArrow").setCreativeTab(MysticAdditions.mysticTab);
	mysticExplosiveArrow = new ItemMysticExplosiveArrow(MysticAdditions.mysticexplosivearrowid).setUnlocalizedName("MysticexplosiveArrow").setCreativeTab(MysticAdditions.mysticTab);
	mysticFireArrow = new ItemMysticFireArrow(MysticAdditions.mysticfirearrowid).setUnlocalizedName("MysticfireArrow").setCreativeTab(MysticAdditions.mysticTab);
	woodenReinforcements = new ItemWoodenReinforcements(MysticAdditions.woodenreinforcementsid).setUnlocalizedName("WoodenReinforcements").setCreativeTab(MysticAdditions.mysticTab);
	regularArrowChooser = new ItemRegularArrowChooser(MysticAdditions.regulararrowchooserid).setUnlocalizedName("RegularArrowChooser").setCreativeTab(MysticAdditions.mysticTab);
	stonePlating = new ItemStonePlating(MysticAdditions.stoneplatingid).setUnlocalizedName("StonePlating").setCreativeTab(MysticAdditions.mysticTab);
	reinforcedStone = new ItemReinforcedStone(MysticAdditions.reinforcedstoneid).setUnlocalizedName("Reinforced Stone").setCreativeTab(MysticAdditions.mysticTab);
	crudeRedOre = new ItemCrudeRedOre(MysticAdditions.cruderedoreid).setUnlocalizedName("cruderedoreid").setCreativeTab(MysticAdditions.mysticTab);
	crudeIron = new ItemCrudeIron(MysticAdditions.crudeironid).setUnlocalizedName("crudeironid").setCreativeTab(MysticAdditions.mysticTab);
	crudeRedstone = new ItemCrudeRedstone(MysticAdditions.cruderedstoneid).setUnlocalizedName("cruderedstoneid").setCreativeTab(MysticAdditions.mysticTab);
	crudeIronChunk = new ItemCrudeIronChunk(MysticAdditions.crudeironchunkid).setUnlocalizedName("crudeironchunkid").setCreativeTab(MysticAdditions.mysticTab);
	steelShuriken = new ItemSteelShuriken(MysticAdditions.steelshurikenid).setUnlocalizedName("steelshurikenid").setCreativeTab(MysticAdditions.mysticTab);
	//public static   Item mysticShuriken = new ItemMysticShuriken(mysticshurikenid).setUnlocalizedName("mysticshurikenid").setIconCoord(10, 1);
	enchantedBone = new ItemEchantedBone(MysticAdditions.enchantedboneid).setUnlocalizedName("enchantedboneid").setCreativeTab(MysticAdditions.mysticTab);
	enchantedBonemeal = new ItemEnchantedBonemeal(MysticAdditions.enchantedbonemealid).setUnlocalizedName("enchantedbonemealid").setCreativeTab(MysticAdditions.mysticTab);
	csteelDust = new ItemCSteelDust(MysticAdditions.csteeldustid).setUnlocalizedName("csteeldust").setCreativeTab(MysticAdditions.mysticTab);
	moltencSteel = new ItemMoltenCSteel(MysticAdditions.moltencsteelid).setUnlocalizedName("csteelmolten").setCreativeTab(MysticAdditions.mysticTab);
	mysticIngot = new ItemMysticIngot(MysticAdditions.mysticingotid).setUnlocalizedName("mysticingot").setCreativeTab(MysticAdditions.mysticTab);
	moltenmysticAlloy = new ItemMoltenMysticAlloy(MysticAdditions.moltenmysticalloyid).setUnlocalizedName("moltenmysticalloy").setCreativeTab(MysticAdditions.mysticTab);
	mysticknightEgg = new ItemMysticKnightEgg(MysticAdditions.mysticknighteggid).setUnlocalizedName("mysticknightegg").setCreativeTab(MysticAdditions.mysticTab);
	markrecallMRK1 = new ItemMarkRecallMRK1(MysticAdditions.markrecallmrk1id).setUnlocalizedName("MRMRK1").setCreativeTab(MysticAdditions.mysticTab);
	warpShard = new ItemWarpShard(MysticAdditions.warpshardid).setUnlocalizedName("warpshard").setCreativeTab(MysticAdditions.mysticTab);
	rawWarp = new ItemRawWarp(MysticAdditions.rawwarpid).setUnlocalizedName("rawwarp").setCreativeTab(MysticAdditions.mysticTab);
	rawWarpFood = new ItemRawWarpFood(MysticAdditions.rawwarpfoodid, 3, 1F, false).setAlwaysEdible().setUnlocalizedName("rawwarpfood").setCreativeTab(MysticAdditions.mysticTab);
	cookedWarpFood = new ItemCookedWarpFood(MysticAdditions.cookedwarpfoodid, 8, 10F, false).setAlwaysEdible().setUnlocalizedName("cookedwarpfood").setCreativeTab(MysticAdditions.mysticTab);
	//warpTarget = new ItemWarpTarget(mod_MysticAdditions.warptargetid).setUnlocalizedName("WarpTarget").setIconCoord(0,0);
	beefBase = new ItemBeefBase(MysticAdditions.beefbaseid).setUnlocalizedName("beefbase").setCreativeTab(MysticAdditions.mysticTab);
	warpedPowerConnector = new ItemWarpedPowerConnector(MysticAdditions.powerwarpconnectorid).setUnlocalizedName("WarpPowerConnector").setCreativeTab(MysticAdditions.mysticTab);
	crudeMysticBattery = new ItemCrudeMysticBattery(MysticAdditions.crudemysticbatteryid, 4000, 1).setUnlocalizedName("crudeBattery").setCreativeTab(MysticAdditions.mysticTab);
	markRecallMrk2 = new ItemMarkRecallMRK2(MysticAdditions.markrecallmrk2id, 4000, 10).setUnlocalizedName("MarkRecallMRK2").setCreativeTab(MysticAdditions.mysticTab);
	mePowerConnector = new ItemMEPowerConnector(MysticAdditions.warppowerconnector2id).setUnlocalizedName("MEPowerConnector").setCreativeTab(MysticAdditions.mysticTab);
	ePowerConnector = new ItemEPowerConnector(MysticAdditions.warppowerconnector3id).setUnlocalizedName("EPowerConnector").setCreativeTab(MysticAdditions.mysticTab);
	tPowerConnector = new ItemTPowerConnector(MysticAdditions.warppowerconnector4id).setUnlocalizedName("TPowerConnector").setCreativeTab(MysticAdditions.mysticTab);
	airToken = new ItemAirToken(MysticAdditions.airtokenid).setUnlocalizedName("AirToken").setCreativeTab(MysticAdditions.mysticTab);
	fireToken = new ItemFireToken(MysticAdditions.firetokenid).setUnlocalizedName("FireToken").setCreativeTab(MysticAdditions.mysticTab);
	waterToken = new ItemWaterToken(MysticAdditions.watertokenid).setUnlocalizedName("WaterToken").setCreativeTab(MysticAdditions.mysticTab);
	earthToken = new ItemEarthToken(MysticAdditions.earthtokenid).setUnlocalizedName("EarthToken").setCreativeTab(MysticAdditions.mysticTab);
	mysticFreezeArrowhead = new ItemMysticFreezeArrowHead(MysticAdditions.mysticfreezearrowheadid).setUnlocalizedName("FreezeArrowHead").setCreativeTab(MysticAdditions.mysticTab);
	mysticLightningArrowhead = new ItemMysticLightningArrowHead(MysticAdditions.mysticlightningarrowheadid).setUnlocalizedName("LightningArrowHead").setCreativeTab(MysticAdditions.mysticTab);
	mysticFreezeArrow = new ItemMysticFreezeArrow(MysticAdditions.mysticfreezearrowid).setUnlocalizedName("FreezeArrow").setCreativeTab(MysticAdditions.mysticTab);
	mysticLightningArrow = new ItemMysticLightningArrow(MysticAdditions.mysticlightningarrowid).setUnlocalizedName("LightningArrow").setCreativeTab(MysticAdditions.mysticTab);
	essenceIron = new ItemIronEssence(MysticAdditions.ironessenceid).setUnlocalizedName("IronEssence").setCreativeTab(MysticAdditions.mysticTab);
	essenceGold = new ItemGoldEssence(MysticAdditions.goldessenceid).setUnlocalizedName("goldEssence").setCreativeTab(MysticAdditions.mysticTab);
	essenceDiamond = new ItemDiamondEssence(MysticAdditions.diamondessenceid).setUnlocalizedName("diamondEssence").setCreativeTab(MysticAdditions.mysticTab);
	diggingCatalyst = new ItemDiggingCatalyst(MysticAdditions.diggingcatalystid, 16000, 32).setUnlocalizedName("diggingCatalyst").setCreativeTab(MysticAdditions.mysticTab);
	mrk2Battery = new ItemCrudeMysticBattery(MysticAdditions.mrk2batteryid, 16000, 32).setUnlocalizedName("mrk2Battery").setCreativeTab(MysticAdditions.mysticTab);
	rcTeleThrower = new ItemRCTeleThrower(MysticAdditions.rctelethrowerid, 8000, 16).setUnlocalizedName("rctelethrower").setCreativeTab(MysticAdditions.mysticTab);
	mrk3Battery = new ItemCrudeMysticBattery(MysticAdditions.mrk3batteryid, 64000, 128).setUnlocalizedName("mrk3Battery").setCreativeTab(MysticAdditions.mysticTab);
	
	FurnaceRecipesMystic frm = new FurnaceRecipesMystic();
	//MysticClientProxy mcp = new MysticClientProxy();
	MysticCommonProxy mcp = new MysticCommonProxy();
		//armor
	armorCSTEEL = EnumHelper.addArmorMaterial("CSTEEL", 23, new int[] {2, 7, 5, 2}, 13);
	int renderSteelArmor = mcp.addArmor("CSTEEL");
	
	helmCSteel = (new ItemArmorMysticsteel(MysticAdditions.csteelhelmid, armorCSTEEL, renderSteelArmor, 0)).setUnlocalizedName("CSteel Helm").setCreativeTab(MysticAdditions.mysticTab);
	chestCSteel = (new ItemArmorMysticsteel(MysticAdditions.csteelchestid, armorCSTEEL, renderSteelArmor, 1)).setUnlocalizedName("CSteel Chest").setCreativeTab(MysticAdditions.mysticTab);
	legsCSteel = (new ItemArmorMysticsteel(MysticAdditions.csteellegsid, armorCSTEEL, renderSteelArmor, 2)).setUnlocalizedName("CSteel Legs").setCreativeTab(MysticAdditions.mysticTab);
	bootsCSteel = (new ItemArmorMysticsteel(MysticAdditions.csteelbootsid, armorCSTEEL, renderSteelArmor, 3)).setUnlocalizedName("CSteel Boots").setCreativeTab(MysticAdditions.mysticTab);
	
	//rechargeable steel
	EnumArmorMaterial armorSTEELRC;
	armorSTEELRC = EnumHelper.addArmorMaterial("STEELRC", 20, new int[] {5, 5,5,5}, 13);
	helmSteelRC = (new ItemArmorSteelRC(MysticAdditions.steelhelmrcid, armorSTEELRC, renderSteelArmor, 0, 32000,32)).setUnlocalizedName("Steel Helm RC").setCreativeTab(MysticAdditions.mysticTab);
	chestSteelRC = (new ItemArmorSteelRC(MysticAdditions.steelchestrcid, armorSTEELRC, renderSteelArmor, 1, 32000,32)).setUnlocalizedName("Steel Chest RC").setCreativeTab(MysticAdditions.mysticTab);
	legsSteelRC = (new ItemArmorSteelRC(MysticAdditions.steellegsrcid, armorSTEELRC, renderSteelArmor, 2, 32000,32)).setUnlocalizedName("Steel Legs RC").setCreativeTab(MysticAdditions.mysticTab);
	bootsSteelRC = (new ItemArmorSteelRC(MysticAdditions.steelbootsrcid, armorSTEELRC, renderSteelArmor, 3, 32000,32)).setUnlocalizedName("Steel Boots RC").setCreativeTab(MysticAdditions.mysticTab);
	
			//stone
	int renderStoneArmor = mcp.addArmor("STONE");
	armorStone = EnumHelper.addArmorMaterial("STONE", 13, new int[] { 2, 4, 3, 3}, 7);
	helmStone = (new ItemArmorMysticstone(MysticAdditions.stonehelmid, armorStone, renderStoneArmor, 0)).setUnlocalizedName("Stone Helm").setCreativeTab(MysticAdditions.mysticTab);
	chestStone = (new ItemArmorMysticstone(MysticAdditions.stonechestid, armorStone, renderStoneArmor, 1)).setUnlocalizedName("Stone Chest").setCreativeTab(MysticAdditions.mysticTab);
	legsStone = (new ItemArmorMysticstone(MysticAdditions.stonelegsid, armorStone, renderStoneArmor, 2)).setUnlocalizedName("Stone Legs").setCreativeTab(MysticAdditions.mysticTab);
	bootsStone = (new ItemArmorMysticstone(MysticAdditions.stonebootsid, armorStone, renderStoneArmor, 3)).setUnlocalizedName("Stone Boots").setCreativeTab(MysticAdditions.mysticTab);
			//mystic
	int renderMysticArmor = mcp.addArmor("Mystic");
	armorMystic = EnumHelper.addArmorMaterial("Mystic", 66, new int[] { 6, 11, 9, 6}, 25);
	helmMystic = (new ItemArmorMystic(MysticAdditions.mystichelmid, armorMystic, renderMysticArmor, 0)).setUnlocalizedName("mystic Helm").setCreativeTab(MysticAdditions.mysticTab);
	chestMystic = (new ItemArmorMystic(MysticAdditions.mysticchestid, armorMystic, renderMysticArmor, 1)).setUnlocalizedName("mystic Chest").setCreativeTab(MysticAdditions.mysticTab);
	legsMystic = (new ItemArmorMystic(MysticAdditions.mysticlegsid, armorMystic, renderMysticArmor, 2)).setUnlocalizedName("mystic Legs").setCreativeTab(MysticAdditions.mysticTab);
	bootsMystic = (new ItemArmorMystic(MysticAdditions.mysticbootsid, armorMystic, renderMysticArmor, 3)).setUnlocalizedName("mystic Boots").setCreativeTab(MysticAdditions.mysticTab);
	
	//tools
		//csteel
	toolCSTEEL = EnumHelper.addToolMaterial("CSTEEL", 2, 900, 8F, 3, 12);
	pickaxeCSteel = (new ItemPickaxeMysticNonSpecial(MysticAdditions.csteelpickid, toolCSTEEL)).setUnlocalizedName("CSteel Pick").setCreativeTab(MysticAdditions.mysticTab);
	axeCSteel = (new ItemAxeMysticNonSpecial(MysticAdditions.csteelaxeid, toolCSTEEL)).setUnlocalizedName("CSteel Axe").setCreativeTab(MysticAdditions.mysticTab);
	swordCSteel = (new ItemSwordMysticNonSpecial(MysticAdditions.csteelswordid, toolCSTEEL)).setUnlocalizedName("CSteel Sword").setCreativeTab(MysticAdditions.mysticTab);
	hoeCSteel = (new ItemHoeMysticNonSpecial(MysticAdditions.csteelhoeid, toolCSTEEL)).setUnlocalizedName("CSteel Hoe").setCreativeTab(MysticAdditions.mysticTab);
	shovelCSteel = (new ItemSpadeMysticNonSpecial(MysticAdditions.csteelspadeid, toolCSTEEL)).setUnlocalizedName("CSteel Shovel").setCreativeTab(MysticAdditions.mysticTab);
	
		//rechargeable steel
	pickaxeSteelRC = (new ItemPickaxeSteelRC(MysticAdditions.steelpickrcid, toolCSTEEL, 32000, 32)).setUnlocalizedName("Steel Pick RC").setCreativeTab(MysticAdditions.mysticTab);
	axeSteelRC = (new ItemAxeSteelRC(MysticAdditions.steelaxercid, toolCSTEEL, 32000, 32)).setUnlocalizedName("Steel Axe RC").setCreativeTab(MysticAdditions.mysticTab);
	swordSteelRC = (new ItemSwordSteelRC(MysticAdditions.steelswordrcid, toolCSTEEL, 32000, 32)).setUnlocalizedName("Steel Sword RC").setCreativeTab(MysticAdditions.mysticTab);
	hoeSteelRC = (new ItemHoeSteelRC(MysticAdditions.steelhoercid, toolCSTEEL, 32000, 32)).setUnlocalizedName("Steel Hoe RC").setCreativeTab(MysticAdditions.mysticTab);
	shovelSteelRC = (new ItemShovelSteelRC(MysticAdditions.steelshovelrcid, toolCSTEEL, 32000, 32)).setUnlocalizedName("Steel Shovel RC").setCreativeTab(MysticAdditions.mysticTab);
	 MinecraftForge.setToolClass(shovelSteelRC, "shovel", 2);
	 MinecraftForge.setToolClass(pickaxeSteelRC, "pickaxe", 2);
	 MinecraftForge.setToolClass(axeSteelRC, "axe", 2);
	LanguageRegistry.addName(pickaxeSteelRC, "Steel Pickaxe RC");
	LanguageRegistry.addName(axeSteelRC, "Steel Axe RC");
	LanguageRegistry.addName(swordSteelRC, "Steel Sword RC");
	LanguageRegistry.addName(hoeSteelRC, "Steel Hoe RC");
	LanguageRegistry.addName(shovelSteelRC, "Steel Shovel RC");
	
	
		//mystic
	toolMystic = EnumHelper.addToolMaterial("MYSTIC", 3, 6000, 30F, 20, 25);
	pickaxeMystic = (new ItemPickaxeMystic(MysticAdditions.mysticpickid, toolMystic)).setUnlocalizedName("Mystic Pick").setCreativeTab(MysticAdditions.mysticTab);
	axeMystic = (new ItemAxeMystic(MysticAdditions.mysticaxeid, toolMystic)).setUnlocalizedName("Mystic Axe").setCreativeTab(MysticAdditions.mysticTab);
	swordMystic = (new ItemSwordMystic(MysticAdditions.mysticswordid, toolMystic)).setUnlocalizedName("Mystic Sword").setCreativeTab(MysticAdditions.mysticTab);
	hoeMystic = (new ItemHoeMystic(MysticAdditions.mystichoeid, toolMystic)).setUnlocalizedName("Mystic Hoe").setCreativeTab(MysticAdditions.mysticTab);
	shovelMystic = (new ItemSpadeMystic(MysticAdditions.mysticspadeid, toolMystic)).setUnlocalizedName("Mystic Shovel").setCreativeTab(MysticAdditions.mysticTab);
	
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
    frm.smelting().addSmelting(MysticAdditions.inertmysticdirtid, new ItemStack(rawWarp, 1), 0);
    frm.smelting().addSmelting(MysticAdditions.inertmysticgrassid, new ItemStack(rawWarp, 1), 0);
    frm.smelting().addSmelting(MysticAdditions.inertmysticgenstoneid, new ItemStack(rawWarp, 1), 0);
    frm.smelting().addSmelting(MysticAdditions.inertmysticcobblestoneid, new ItemStack(rawWarp, 1), 0);
    frm.smelting().addSmelting(MysticAdditions.mysticbricksid, new ItemStack(rawWarp, 1), 0);
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
    LanguageRegistry.addName(mrk2Battery, "Mark 2 Battery");
    LanguageRegistry.addName(rcTeleThrower, "RC Tele Thrower");
    LanguageRegistry.addName(mrk3Battery, "Mark 3 Battery");
    	//armor
    		LanguageRegistry.addName(helmSteelRC, "Steel Helm RC");
    		LanguageRegistry.addName(chestSteelRC, "Steel Chest RC");
    		LanguageRegistry.addName(legsSteelRC, "Steel Legs RC");
    		LanguageRegistry.addName(bootsSteelRC, "Steel Boots RC");
    		GameRegistry.addShapelessRecipe(new ItemStack(helmSteelRC, 1), new Object[] {
    			helmCSteel, new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), moltenRedstone,moltenRedstone,moltenRedstone,moltenRedstone});
    		GameRegistry.addShapelessRecipe(new ItemStack(chestSteelRC, 1), new Object[] {
    			chestCSteel, new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), moltenRedstone,moltenRedstone,moltenRedstone,moltenRedstone});
    		GameRegistry.addShapelessRecipe(new ItemStack(legsSteelRC, 1), new Object[] {
    			legsCSteel, new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), moltenRedstone,moltenRedstone,moltenRedstone,moltenRedstone});
    		GameRegistry.addShapelessRecipe(new ItemStack(bootsSteelRC, 1), new Object[] {
    			bootsCSteel, new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), moltenRedstone,moltenRedstone,moltenRedstone,moltenRedstone});
    	//tools	
    		GameRegistry.addShapelessRecipe(new ItemStack(pickaxeSteelRC, 1), new Object[] {
    			pickaxeCSteel, new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), moltenRedstone,moltenRedstone,moltenRedstone,moltenRedstone});
    		GameRegistry.addShapelessRecipe(new ItemStack(swordSteelRC, 1), new Object[] {
    			swordCSteel, new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), moltenRedstone,moltenRedstone,moltenRedstone,moltenRedstone});
    		GameRegistry.addShapelessRecipe(new ItemStack(axeSteelRC, 1), new Object[] {
    			axeCSteel, new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), moltenRedstone,moltenRedstone,moltenRedstone,moltenRedstone});
    		GameRegistry.addShapelessRecipe(new ItemStack(hoeSteelRC, 1), new Object[] {
    			hoeCSteel, new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), moltenRedstone,moltenRedstone,moltenRedstone,moltenRedstone});
    		GameRegistry.addShapelessRecipe(new ItemStack(shovelSteelRC, 1), new Object[] {
    			shovelCSteel, new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE), moltenRedstone,moltenRedstone,moltenRedstone,moltenRedstone});
    		
    		
    		
    		
    GameRegistry.addRecipe(new ItemStack(crudeMysticBattery, 1, 10), new Object[]{
    	" X ","XZX","XZX", 'X', Block.stone, 'Z', Item.redstone
    });
    GameRegistry.addShapelessRecipe(new ItemStack(warpedPowerConnector, 1), new Object[]{
    	Item.ingotIron,Item.ingotIron,Item.ingotIron,Item.ingotIron, new ItemStack(MysticModItems.crudeMysticBattery,1,OreDictionary.WILDCARD_VALUE)
    });
    GameRegistry.addRecipe(new ShapelessOreRecipe (new ItemStack(MysticModItems.mePowerConnector, 1), new Object[]{
    	"ingotRefinedIron","ingotRefinedIron","ingotRefinedIron","ingotRefinedIron", new ItemStack(MysticModItems.crudeMysticBattery,1,OreDictionary.WILDCARD_VALUE)
    }));
    GameRegistry.addRecipe(new ShapelessOreRecipe (new ItemStack(MysticModItems.ePowerConnector, 1), new Object[]{
    	"ingotSteel","ingotSteel","ingotSteel","ingotSteel",  new ItemStack(MysticModItems.mrk2Battery,1,OreDictionary.WILDCARD_VALUE)
    }));
    GameRegistry.addRecipe(new ShapelessOreRecipe (new ItemStack(MysticModItems.tPowerConnector, 1), new Object[]{
    	MysticModItems.mysticIngot,MysticModItems.mysticIngot,MysticModItems.mysticIngot,MysticModItems.mysticIngot, new ItemStack(MysticModItems.mrk3Battery,1,OreDictionary.WILDCARD_VALUE)
    }));
    GameRegistry.addRecipe(new ItemStack(markRecallMrk2, 1), new Object[]{
    	"ZXZ","XYX","ZXZ", 'Y', MysticModItems.markrecallMRK1, 'X', new ItemStack(MysticModItems.crudeMysticBattery,1,OreDictionary.WILDCARD_VALUE), 'Z', MysticModItems.moltenRedstone
    });
    GameRegistry.addRecipe(new ItemStack(diggingCatalyst, 1), new Object[]{
    	"ZXZ","XYX","ZXZ", 'Y', MysticModItems.pickaxeCSteel, 'X', new ItemStack(MysticModItems.crudeMysticBattery,1,OreDictionary.WILDCARD_VALUE), 'Z', MysticModItems.moltenRedstone
    });
    GameRegistry.addRecipe(new ItemStack(mrk2Battery, 1), new Object[]{
    	"ZXZ","XYX","ZXZ", 'Y', MysticModBlocks.refinedRedstone, 'X', new ItemStack(MysticModItems.crudeMysticBattery,1,OreDictionary.WILDCARD_VALUE), 'Z', MysticModItems.moltencSteel
    });
    GameRegistry.addRecipe(new ItemStack(rcTeleThrower, 1), new Object[]{
    	"ZXZ","XYX","VXV", 'Y', MysticModBlocks.refinedRedstone, 'X', Item.enderPearl, 'Z', MysticModItems.moltenRedstone, 'V', new ItemStack( mrk2Battery,1, OreDictionary.WILDCARD_VALUE)
    });
    
    GameRegistry.addRecipe(new ItemStack(mrk3Battery, 1), new Object[]{
    	"ZXZ","XYX","ZXZ", 'Y', MysticModBlocks.refinedRedstone, 'X', new ItemStack(MysticModItems.mrk2Battery,1, OreDictionary.WILDCARD_VALUE), 'Z', MysticModItems.moltencSteel
    });
    
    //dusts
    LanguageRegistry.addName(essenceIron, "Iron Essence");
    LanguageRegistry.addName(essenceGold, "Gold Essence");
    LanguageRegistry.addName(essenceDiamond, "Diamond Essence");
    
	}
	
	
	
	
}

package com.sudwood.mysticadditions;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.sudwood.mysticadditions.blocks.MysticModBlocks;
import com.sudwood.mysticadditions.dimensions.BiomeGenMystic;
import com.sudwood.mysticadditions.dimensions.WorldProviderMystic;
import com.sudwood.mysticadditions.enchantments.EnchantmentRegister;
import com.sudwood.mysticadditions.entity.EntityEarthMiniBoss;
import com.sudwood.mysticadditions.entity.EntityFireMiniBoss;
import com.sudwood.mysticadditions.entity.EntityMysticArcher;
import com.sudwood.mysticadditions.entity.EntityMysticArrow;
import com.sudwood.mysticadditions.entity.EntityMysticExplosiveArrow;
import com.sudwood.mysticadditions.entity.EntityMysticFireArrow;
import com.sudwood.mysticadditions.entity.EntityMysticFreezeArrow;
import com.sudwood.mysticadditions.entity.EntityMysticKnight;
import com.sudwood.mysticadditions.entity.EntityMysticLightningArrow;
import com.sudwood.mysticadditions.entity.EntityMysticTeleArrow;
import com.sudwood.mysticadditions.entity.EntityMysticWaterOrb;
import com.sudwood.mysticadditions.entity.EntityMysticWindOrb;
import com.sudwood.mysticadditions.entity.EntityWaterMiniBoss;
import com.sudwood.mysticadditions.entity.EntityWindMiniBoss;
import com.sudwood.mysticadditions.items.MysticModItems;
import com.sudwood.mysticadditions.items.potions.MysticModPotions;
import com.sudwood.mysticadditions.tileentity.TileEntityCamoBlock;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticBud;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticCrystalGenerator;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticEnergy;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticFurnace;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGenerator;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGrinder;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorageMrk2;
import com.sudwood.mysticadditions.tileentity.TileEntityPoweredFurnace;
import com.sudwood.mysticadditions.tileentity.TileEntityPoweredMysticFurnace;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;




@Mod( modid = "mysticadditions", name="Mystic Additions", version="1.6.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels={"MysticER", "MysticIMS"}, packetHandler = MysticPacketHandler.class)
public class MysticAdditions 
{
	
	public static BiomeGenBase Mysticbiome;
	@Instance("mysticadditions")
	public static MysticAdditions instance;
	
	@SidedProxy(clientSide="client.sudwood.mysticadditions.MysticClientProxy", serverSide="com.sudwood.mysticadditions.MysticCommonProxy" )
	public static MysticCommonProxy proxy;
	
	public static int DimID;
	private GuiHandlerMystic guiHandler = new GuiHandlerMystic();

	
	//block ids
		
		 public static int compressedcoalid;
		 public static int compressedredstoneid;
		 public static int refinedcarbonid;
		 public static int refinedredstoneid;
		 public static int refinedironblockid;
		 public static int csteelblockid;
		 public static int mysticglassid;
		 public static int mysticglowglassid;
		 public static int mysticspeedglassid;
		 public static int mysticlandmineglassid;
		 public static int mysticfireglassid;
		 public static int redlogid;
		 public static int redplanksid;
		 public static int ironlogid;
		 public static int ironplanksid;
		 public static int redsaplingid;
		 public static int ironsaplingid;
		 public static int redleavesid;
		 public static int ironleavesid;
		 public static int mysticdirtid;
		 public static int mysticgrassid;
		 public static int mysticgenstoneid;
		 public static int mysticcobblestoneid;
		 public static int mysticportalid;
		 public static int elevatorid;
		 public static int stopperid;
		 public static int dropperid;
		 public static int mysticbricksid;
		 public static int mysticportalblockid;
		 public static int mysticportalspawnerid;
		 public static int mysticingotblockid;
		 public static int mysticfurnaceid;
		 public static int mysticcraftingtableid;
		 public static int inertmysticgrassid;
		 public static int inertmysticdirtid;
		 public static int inertmysticgenstoneid;
		 public static int inertmysticcobblestoneid;
		 public static int mysticbudswitchid;
		 public static int mysticredstorageid;
		 public static int mysticredgeneratorid;
		 public static int mysticslabssingleid;
		 public static int mysticslabsdoubleid;
		 public static int mysticcobblestairsid;
		 public static int mysticstonestairsid;
		 public static int mysticbrickstairsid;
		 public static int mysticredplankstairsid;
		 public static int mysticironplankstairsid;
		 public static int markblockid;
		 public static int warpcrystalid;
		 public static int mysticmobspawnerid;
		 public static int mysticredgrinderid;
		 public static int poweredfurnaceid;
		 public static int poweredmysticfurnaceid;
		 public static int crystalgeneratorid;
		 public static int crystalgeneratorbaseid;
		 public static int mrk2mysticredstorageid;
		 public static int liquidstorageblockid;
		 public static int camoblockid;
		//item ids
		 public static int refinedironingotid;
		 public static int csteelingotid;
		 public static int redstoneshardsid;
		 public static int moltenredstoneid;
		 public static int mysticplatingid;
		 public static int mysticstoneid;
		 public static int mysticbowid;
		 public static int mysticarrowid;
		 public static int mystictelearrowheadid;
		 public static int mysticexplosivearrowheadid;
		 public static int mysticfirearrowheadid;
		 public static int mystictelearrowid;
		 public static int mysticexplosivearrowid;
		 public static int mysticfirearrowid;
		 public static int woodenreinforcementsid;
		 public static int regulararrowchooserid;
		 public static int stoneplatingid;
		 public static int reinforcedstoneid;
		 public static int cruderedoreid;
		 public static int crudeironid;
		 public static int cruderedstoneid;
		 public static int crudeironchunkid;
		 public static int steelshurikenid;
		 public static int mysticshurikenid;
		 public static int enchantedboneid;
		 public static int enchantedbonemealid;
		 public static int csteeldustid;
		 public static int moltencsteelid;
		 public static int mysticingotid;
		 public static int moltenmysticalloyid;
		 public static int mysticknighteggid;
		 public static int mysticfeatherid;
		 public static int markrecallmrk1id;
		 public static int warpshardid;
		 public static int rawwarpid;
		 public static int rawwarpfoodid;
		 public static int cookedwarpfoodid;
		 public static int warptargetid;
		 public static int beefbaseid;
		 public static int powerwarpconnectorid;
		 public static int crudemysticbatteryid;
		 public static int mysticfreezearrowheadid;
		 public static int mysticlightningarrowheadid;
		 public static int mysticfreezearrowid;
		 public static int mysticlightningarrowid;
		 public static int markrecallmrk2id;
		 public static int ironessenceid;
		 public static int goldessenceid;
		 public static int diamondessenceid;
		 public static int warppowerconnector2id;
		 public static int warppowerconnector3id;
		 public static int warppowerconnector4id;
		 public static int airtokenid;
		 public static int firetokenid;
		 public static int earthtokenid;
		 public static int watertokenid;
		 public static int diggingcatalystid;
		 public static int mrk2batteryid;
		 public static int rctelethrowerid;
		 public static int mrk3batteryid;

			//tool ids
		 public static int csteelpickid;
		 public static int csteelaxeid;
		 public static int csteelswordid;
		 public static int csteelhoeid;
		 public static int csteelspadeid;
		 public static int steelpickrcid;
		 public static int steelaxercid;
		 public static int steelswordrcid;
		 public static int steelshovelrcid;
		 public static int steelhoercid;
		 public static int smtrcid;
		//mystic tool ids
		 public static int mysticpickid;
		 public static int mysticaxeid;
		 public static int mysticswordid;
		 public static int mystichoeid;
		 public static int mysticspadeid;
			//armor ids
		 public static int csteelchestid;
		 public static int csteelhelmid;
		 public static int csteellegsid;
		 public static int csteelbootsid;
		 public static int stonechestid;
		 public static int stonehelmid;
		 public static int stonelegsid;
		 public static int stonebootsid;
		 public static int mysticchestid;
		 public static int mystichelmid;
		 public static int mysticlegsid;
		 public static int mysticbootsid;
		 public static int steelhelmrcid;
		 public static int steelchestrcid;
		 public static int steellegsrcid;
		 public static int steelbootsrcid;
		
	//creative tab
		 public static CreativeTabs mysticTab = new MysticAdditionsTab("mysticTab");
		 
		 
		 //options
		 public static boolean areAnimations;
		//potion
		
	
	
@EventHandler
public void preInit(FMLPreInitializationEvent event){
	System.out.println("Loading Version 1.1.0 of Mystic Additions");

		Potion[] potionTypes = null;

		for (Field f : Potion.class.getDeclaredFields()) {
		f.setAccessible(true);
		try {
		if (f.getName().equals("potionTypes")) {
		Field modfield = Field.class.getDeclaredField("modifiers");
		modfield.setAccessible(true);
		modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

		potionTypes = (Potion[])f.get(null);
		final Potion[] newPotionTypes = new Potion[256];
		System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
		f.set(null, newPotionTypes);
		}
		}
		catch (Exception e) {
		System.err.println("Severe error, please report this to the mod author:");
		System.err.println(e);
		}
		}

		MinecraftForge.EVENT_BUS.register(new EventHookMysticClass());
		
		
	Configuration config = new Configuration(event.getSuggestedConfigurationFile());

	config.load();
	//block ids
	     compressedcoalid = config.getBlock("CompressedCoal", 2171).getInt();
	     compressedredstoneid = config.getBlock("CompressedRedstone", 2172).getInt();
	     refinedcarbonid = config.getBlock("RefinedCarbon", 2173).getInt();
	     refinedredstoneid = config.getBlock("RefinedRedstone", 2174).getInt();
	     refinedironblockid = config.getBlock("RefinedIronBlock", 2175).getInt();
	     csteelblockid = config.getBlock("SteelBlock", 2176).getInt();
	     mysticglassid = config.getBlock("MysticGlass", 2177).getInt();
	     mysticglowglassid = config.getBlock("MysticGlowGlass", 2178).getInt();
	     mysticspeedglassid = config.getBlock("MysticSpeedGlass", 2179).getInt();
	     mysticlandmineglassid = config.getBlock("MysticLandMineGlass", 2180).getInt();
	     mysticfireglassid = config.getBlock("MysticFireGlass", 2181).getInt();
	     redlogid = config.getBlock("RedstoneLog", 2182).getInt();
	     redplanksid = config.getBlock("RedstonePlanks", 2183).getInt();
	     ironlogid = config.getBlock("IronLog", 2184).getInt();
	     ironplanksid = config.getBlock("IronPlanks", 2185).getInt();
	     redsaplingid = config.getBlock("RedstoneSapling", 2186).getInt();
	     ironsaplingid = config.getBlock("IronSapling", 2187).getInt();
	     redleavesid = config.getBlock("RedstoneLeaves", 2188).getInt();
	     ironleavesid = config.getBlock("IronLeaves", 2189).getInt();
	     mysticdirtid = config.getBlock("MysticDirt", 2190).getInt();
	     mysticgrassid = config.getBlock("MysticGrass", 2191).getInt();
	     mysticgenstoneid = config.getBlock("MysticGenStone", 2192).getInt();
	     mysticcobblestoneid = config.getBlock("MysticCobbleStone", 2193).getInt();
	     mysticportalid = config.getBlock("MysticPortal", 2194).getInt();
	     elevatorid = config.getBlock("Elevator", 2195).getInt();
	     stopperid = config.getBlock("Stopper", 2196).getInt();
	     dropperid = config.getBlock("Dropper", 2197).getInt();
	     mysticbricksid = config.getBlock("MysticBricks", 2198).getInt();
	     mysticportalblockid = config.getBlock("MysticPortalFrame", 2199).getInt();
	     mysticportalspawnerid = config.getBlock("MysticPortalSpawner", 2200).getInt();
	     mysticingotblockid = config.getBlock("MysticIngotBlock", 2201).getInt();
	     mysticfurnaceid = config.getBlock("MysticFurnace", 2202).getInt();
	     mysticcraftingtableid = config.getBlock("MysticCraftingTable", 2203).getInt();
	     inertmysticgrassid = config.getTerrainBlock("mysticAdditions", "innertmysticgrass", 149, "MysticGrass").getInt();
	     inertmysticdirtid = config.getBlock("InertMysticDirt", 2204).getInt();
	     inertmysticgenstoneid = config.getTerrainBlock("mysticAdditions", "innertmysticgenstone", 150, "MysticGenStone").getInt();
	     inertmysticcobblestoneid = config.getBlock("InertMysticCobblestone", 2205).getInt();
	     mysticbudswitchid = config.getBlock("MysticBudSwitch", 2206).getInt();
	     mysticredstorageid = config.getBlock("MysticRedStorage", 2207).getInt();
	     mysticredgeneratorid = config.getBlock("MysticRedGenerator", 2208).getInt();
	     mysticslabssingleid = config.getBlock("MysticSlabsSingle", 2209).getInt();
	     mysticslabsdoubleid = config.getBlock("MysticSlabsDouble", 2210).getInt();
	     mysticcobblestairsid = config.getBlock("MysticCobbleStairs", 2211).getInt();
	     mysticstonestairsid = config.getBlock("MysticStoneStairs", 2212).getInt();
	     mysticbrickstairsid = config.getBlock("MysticBrickStairs", 2213).getInt();
	     mysticredplankstairsid = config.getBlock("RedPlankStairs", 2214).getInt();
	     mysticironplankstairsid = config.getBlock("IronPlankStairs", 2215).getInt();
	     markblockid = config.getBlock("MarkBlock", 2216).getInt();
	     warpcrystalid = config.getBlock("WarpCrystal", 2217).getInt();
	     mysticmobspawnerid = config.getBlock("MysticMobSpawner", 2218).getInt();
	     mysticredgrinderid = config.getBlock("ConteroEssence", 2219).getInt();
	     poweredfurnaceid = config.getBlock("PoweredFurnace", 2220).getInt();
	     poweredmysticfurnaceid = config.getBlock("PoweredMysticFurnace", 2221).getInt();
	     crystalgeneratorid = config.getBlock("Crystal Generator", 2222).getInt();
	     crystalgeneratorbaseid = config.getBlock("CrystalGeneratorBase", 2223).getInt();
	     mrk2mysticredstorageid = config.getBlock("Mrk2RedCapacitor", 2224).getInt();
	     liquidstorageblockid = config.getBlock("LiquidStorage", 2225).getInt();
	     camoblockid = config.getBlock("CamoBlock", 2226).getInt();
	//item ids
	     refinedironingotid = config.getItem("RefinedIronIngot", 31000).getInt();
	     csteelingotid = config.getItem("SteelIngot", 31001).getInt();
	     redstoneshardsid = config.getItem("RedstoneShards", 31002).getInt();
	     moltenredstoneid = config.getItem("MoltenRedstone", 31003).getInt();
	     mysticplatingid = config.getItem("MysticPlating", 31004).getInt();
	     mysticstoneid = config.getItem("MysticStone", 31005).getInt();
	     mysticbowid = config.getItem("MysticBow", 31006).getInt();
	     mysticarrowid = config.getItem("MysticArrow", 31007).getInt();
	     mystictelearrowheadid = config.getItem("MysticTeleArrowHead", 31008).getInt();
	     mysticexplosivearrowheadid = config.getItem("MysticExplosiveArrowHead", 31009).getInt();
	     mysticfirearrowheadid = config.getItem("MysticFireArrowHead", 31010).getInt();
	     mystictelearrowid = config.getItem("MysticTeleArrow", 31011).getInt();
	     mysticexplosivearrowid = config.getItem("MysticExplosiveArrow", 31012).getInt();
	     mysticfirearrowid = config.getItem("MysticFireArrow", 31013).getInt();
	     woodenreinforcementsid = config.getItem("WoodenReinforcements", 31014).getInt();
	     regulararrowchooserid = config.getItem("RegularArrowChooser", 31015).getInt();
	     stoneplatingid = config.getItem("StonePlating", 31016).getInt();
	     reinforcedstoneid = config.getItem("ReinforcedStone", 31017).getInt();
	     cruderedoreid = config.getItem("CrudeRedOre", 31018).getInt();
	     crudeironid = config.getItem("CrudeIron", 31019).getInt();
	     cruderedstoneid = config.getItem("CrudeRedstone", 31020).getInt();
	     crudeironchunkid = config.getItem("CrudeIronChunk", 31021).getInt();
	     steelshurikenid = config.getItem("SteelShuriken", 31022).getInt();
	     mysticshurikenid = config.getItem("MysticShuriken", 31023).getInt();
	     enchantedboneid = config.getItem("EnchantedBone", 31024).getInt();
	     enchantedbonemealid = config.getItem("EnchantedBonemeal", 31025).getInt();
	     csteeldustid = config.getItem("SteelDust", 31026).getInt();
	     moltencsteelid = config.getItem("MoltenSteel", 31027).getInt();
	     mysticingotid = config.getItem("MysticIngot", 31028).getInt();
	     moltenmysticalloyid = config.getItem("MoltenMysticAlloy", 31029).getInt();
	     mysticknighteggid = config.getItem("MysticKnightEgg", 31053).getInt();
	     ironessenceid = config.getItem("IronEssence", 31030).getInt();
	     markrecallmrk1id = config.getItem("MysticEnergyBucket", 31053).getInt();
	     warpshardid = config.getItem("WarpShard", 31054).getInt();
	     rawwarpid = config.getItem("RawWarp", 31055).getInt();
	     rawwarpfoodid = config.getItem("RawWarpFood", 31056).getInt();
	     cookedwarpfoodid = config.getItem("CookedWarpFood", 31057).getInt();
	     goldessenceid = config.getItem("GoldEssence", 31058).getInt();
	     beefbaseid = config.getItem("BeefBase", 31059).getInt();
	     powerwarpconnectorid = config.getItem("InefficientPowerConnector", 31060).getInt();
	     crudemysticbatteryid = config.getItem("CrudeMysticBattery", 31061).getInt();
	     mysticfreezearrowheadid = config.getItem("FreezeArrowHead", 31062).getInt();
	     mysticlightningarrowheadid = config.getItem("LightningArrowHead", 31063).getInt();
	     mysticfreezearrowid = config.getItem("FreezeArrow", 31064).getInt();
	     mysticlightningarrowid = config.getItem("LightningArrow", 31065).getInt();
	     markrecallmrk2id = config.getItem("MarkRecallMrk2", 31066).getInt();
	     warppowerconnector2id = config.getItem("ModeratlyEfficientPowerConnector", 31067).getInt();
	     warppowerconnector3id = config.getItem("EfficientPowerConnector", 31068).getInt();
	     warppowerconnector4id = config.getItem("TruePowerConnector", 31069).getInt();
	     airtokenid = config.getItem("AirToken", 31070).getInt();
	     firetokenid = config.getItem("FireToken", 31071).getInt();
	     watertokenid = config.getItem("WaterToken", 31072).getInt();
	     earthtokenid = config.getItem("EarthToken", 31073).getInt();
	     diamondessenceid = config.getItem("DiamondEssence", 31074).getInt();
	     diggingcatalystid = config.getItem("DiggingCatalyst", 31075).getInt();
	     mrk2batteryid = config.getItem("Mark2Battery", 31076).getInt();
	     rctelethrowerid = config.getItem("RC Tele Thrower", 31087).getInt();
	     mrk3batteryid = config.getItem("Mark3Battery", 31088).getInt();
	     //last item id 31087
		//tool ids
	     csteelpickid = config.getItem("SteelPickaxe", 31031).getInt();
	     csteelaxeid = config.getItem("SteelAxe", 31032).getInt();
	     csteelswordid = config.getItem("SteelSword", 31033).getInt();
	     csteelhoeid = config.getItem("SteelHoe", 31034).getInt();
	     csteelspadeid = config.getItem("SteelShovel", 31035).getInt();
	     steelpickrcid = config.getItem("SteelPickRC", 31077).getInt();
	     steelaxercid = config.getItem("SteelAxeRC", 31078).getInt();
	     steelswordrcid = config.getItem("SteelSwordRC", 31079).getInt();
	     steelshovelrcid = config.getItem("SteelShovelRC", 31080).getInt();
	     steelhoercid = config.getItem("SteelHoeRC", 31081).getInt();
	     smtrcid = config.getItem("SteelMultiToolRC", 31082).getInt();
	//mystic tool ids
	     mysticpickid = config.getItem("MysticPickaxe", 31036).getInt();
	     mysticaxeid = config.getItem("MysticAxe", 31037).getInt();
	     mysticswordid = config.getItem("MysticSword", 31038).getInt();
	     mystichoeid = config.getItem("MysticHoe", 31039).getInt();
	     mysticspadeid = config.getItem("MysticShovel", 31040).getInt();
		//armor ids
	     csteelchestid = config.getItem("SteelChestplate", 31041).getInt();
	     csteelhelmid = config.getItem("SteelHelm", 31042).getInt();
	     csteellegsid = config.getItem("SteelLegs", 31043).getInt();
	     csteelbootsid = config.getItem("SteelBoots", 31044).getInt();
	     stonechestid = config.getItem("StoneChestplate", 31045).getInt();
	     stonehelmid = config.getItem("StoneHelm", 31046).getInt();
	     stonelegsid = config.getItem("StoneLegs", 31047).getInt();
	     stonebootsid = config.getItem("StoneBoots", 31048).getInt();
	     mysticchestid = config.getItem("MysticChestplate", 31049).getInt();
	     mystichelmid = config.getItem("MysticHelm", 31050).getInt();
	     mysticlegsid = config.getItem("MysticLegs", 31051).getInt();
	     mysticbootsid = config.getItem("MysticBoots", 31052).getInt();
	     steelhelmrcid = config.getItem("Steel Helm RC", 31083).getInt();
	     steelchestrcid = config.getItem("Steel Chest RC", 31084).getInt();
	     steellegsrcid = config.getItem("Steel Legs RC", 31085).getInt();
	     steelbootsrcid = config.getItem("Steel Boots RC", 31086).getInt();
	     
	     //options
	     areAnimations = config.get(config.CATEGORY_GENERAL, "Are animations enabled", true).getBoolean(true);
	config.save();
	MysticERegistration.registerMysticEnergyID(mysticredstorageid);
	MysticERegistration.registerMysticEnergyTile("TileEntityMysticRedStorage");
	MysticERegistration.registerMysticEnergyID(mysticredgeneratorid);
	MysticERegistration.registerMysticEnergyTile("TileEntityMysticRedGenerator");
	TileEntityMysticRedGenerator.addItemToFuelList(Item.redstone.itemID, 400);
	TileEntityMysticRedGenerator.addItemToFuelList(this.compressedredstoneid, 3600);
	TileEntityMysticRedGenerator.addItemToFuelList(this.refinedredstoneid, 4000);
	TileEntityMysticRedGenerator.addItemToFuelList(Item.blazeRod.itemID, 300);
	TileEntityMysticRedGenerator.addItemToFuelList(Item.enderPearl.itemID, 600);
	TileEntityMysticRedGenerator.addItemToFuelList(Item.ingotIron.itemID, 120);
	TileEntityMysticRedGenerator.addItemToFuelList(Item.ingotGold.itemID, 240);
	TileEntityMysticRedGenerator.addItemToFuelList(Item.diamond.itemID, 480);
}



@EventHandler
public void load(FMLInitializationEvent event) 
{
	
	MysticModBlocks.init();
	MysticModItems.init();
	MysticModBlocks.initBlockRecipes();
	
	//enchantments
	EnchantmentRegister reg = new EnchantmentRegister();
	reg.registerEnchantments();
	
	
	OreDictionary.registerOre("ingotRefinedIron", new ItemStack(MysticModItems.refinedIronIngot));
	OreDictionary.registerOre("ingotSteel", new ItemStack(MysticModItems.cSteelIngot));
	OreDictionary.registerOre("ingotMystic", new ItemStack(MysticModItems.mysticIngot));
	proxy.registerServerTickHandlers();
	
		
	//potion
	MysticModPotions.init();
	//creative tab
	LanguageRegistry.instance().addStringLocalization("itemGroup.mysticTab", "en_US", "Mystic Additions");
	
	
	 proxy.registerRenderInformation();
//	 Parameters are: entClass, entName, ID, mod, trackingRange, updateFrequency, sendVelocityUpdates
	 EntityRegistry.registerModEntity(EntityMysticArrow.class, "Mystic Arrow", 1, this, 250, 20, true);
	 EntityRegistry.registerModEntity(EntityMysticTeleArrow.class, "Mystic Teleport Arrow", 2, this, 250, 20, true);
	 EntityRegistry.registerModEntity(EntityMysticExplosiveArrow.class, "Mystic Explosive Arrow", 3, this, 250, 20, true);
	 EntityRegistry.registerModEntity(EntityMysticFireArrow.class, "Mystic Fire Arrow", 4, this, 250, 20, true);
	 EntityRegistry.registerModEntity(EntityMysticKnight.class, "Mystic Knight", 5, this, 30, 1, true);
	 EntityRegistry.registerModEntity(EntityMysticArcher.class, "MysticArcher", 6, this, 30, 1, true);
	 EntityRegistry.registerModEntity(EntityMysticWindOrb.class, "WindOrb", 7, this, 250, 20, true);
	 EntityRegistry.registerModEntity(EntityWindMiniBoss.class, "WindMiniBoss", 8, this, 30, 1, true);
	 EntityRegistry.registerModEntity(EntityMysticWaterOrb.class, "WaterOrb", 9, this, 250, 20, true);
	 EntityRegistry.registerModEntity(EntityWaterMiniBoss.class, "WaterMiniBoss", 10, this, 30, 1, true);
	 EntityRegistry.registerModEntity(EntityFireMiniBoss.class, "FireMiniBoss", 11, this, 30, 1, true);
	 EntityRegistry.registerModEntity(EntityEarthMiniBoss.class, "EarthMiniBoss", 12, this, 30, 1, true);
	 EntityRegistry.registerModEntity(EntityMysticFreezeArrow.class, "MysticFreezeArrow", 1, this, 250, 20, true);
	 EntityRegistry.registerModEntity(EntityMysticLightningArrow.class, "MysticLightningArrow", 1, this, 250, 20, true);
	
	 MinecraftForge.EVENT_BUS.register(new ArmorTickHandler());
	//biome stuff
			Mysticbiome = new BiomeGenMystic(50);
			
	 DimensionManager.registerProviderType(14, WorldProviderMystic.class, false);
	 DimID = DimensionManager.getNextFreeDimId();

	 DimensionManager.registerDimension(DimID, 14);
	
		
		
			//mob stuff
		
			 LanguageRegistry.instance().addStringLocalization("entity.MysticAdditions.Mystic Knight.name", "Mystic Knight");
	//furnace stuff
			 GameRegistry.registerTileEntity(TileEntityMysticFurnace.class, "MysticInfuser");

			 GameRegistry.registerTileEntity(TileEntityMysticBud.class, "Mystic Detector");
			 GameRegistry.registerTileEntity(TileEntityMysticRedStorage.class, "Mystic Red Storage");
			 GameRegistry.registerTileEntity(TileEntityMysticRedGenerator.class, "Mystic Red Generator");
			 GameRegistry.registerTileEntity(TileEntityMysticRedGrinder.class, "MysticRedGrinder");
			 GameRegistry.registerTileEntity(TileEntityPoweredFurnace.class, "PoweredFurnace");
			 GameRegistry.registerTileEntity(TileEntityPoweredMysticFurnace.class, "Powered Mystic Furnace");
			 GameRegistry.registerTileEntity(TileEntityMysticCrystalGenerator.class, "Mystic crystal gernator");
			 GameRegistry.registerTileEntity(TileEntityMysticEnergy.class, "Mystic Energy");
			 GameRegistry.registerTileEntity(TileEntityMysticRedStorageMrk2.class, "MysticRedStorageMrk2");
			 GameRegistry.registerTileEntity(TileEntityCamoBlock.class, "CamoBlock");
			 NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
			

			 
			 
			 
}
		
		
		
		

		
		
	
	public String getVersion()
	{
		return "1.0.5";
	}
}


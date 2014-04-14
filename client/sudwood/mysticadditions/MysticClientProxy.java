package client.sudwood.mysticadditions;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.MinecraftForgeClient;

import org.lwjgl.input.Keyboard;

import client.sudwood.mysticadditions.renderers.RenderLiquidStorage;
import client.sudwood.mysticadditions.renderers.RenderMysticArrow;
import client.sudwood.mysticadditions.renderers.RenderMysticCrystalGenerator;
import client.sudwood.mysticadditions.renderers.RenderMysticECapacitorBase;
import client.sudwood.mysticadditions.renderers.RenderMysticExplosiveArrow;
import client.sudwood.mysticadditions.renderers.RenderMysticFireArrow;
import client.sudwood.mysticadditions.renderers.RenderMysticFreezeArrow;
import client.sudwood.mysticadditions.renderers.RenderMysticGenerator;
import client.sudwood.mysticadditions.renderers.RenderMysticLightningArrow;
import client.sudwood.mysticadditions.renderers.RenderMysticMagicOrb;
import client.sudwood.mysticadditions.renderers.RenderMysticRedGrinder;
import client.sudwood.mysticadditions.renderers.RenderMysticRedStorageMrk2;
import client.sudwood.mysticadditions.renderers.RenderMysticTeleArrow;
import client.sudwood.mysticadditions.renderers.RenderOreRift;
import client.sudwood.mysticadditions.renderers.RenderSteelShuriken;
import client.sudwood.mysticadditions.renderers.RenderTileEntityBase;

import com.sudwood.mysticadditions.blocks.MysticModBlocks;
import com.sudwood.mysticadditions.entity.EntityMysticWaterOrb;
import com.sudwood.mysticadditions.entity.EntityMysticWindOrb;
import com.sudwood.mysticadditions.tileentity.TileEntityLiquidStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticCrystalGenerator;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGenerator;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGrinder;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorageMrk2;
import com.sudwood.mysticadditions.tileentity.TileEntityOreRift;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
public class MysticClientProxy extends com.sudwood.mysticadditions.MysticCommonProxy {

	public static int MysticCapacitorRenderId;
	public static int MysticGeneratorRenderId;
	public static int MysticRedGrinderid;
	public static int MysticCrystalGeneratorRenderId;
	public static int MysticCapacitormrk2RenderID;
	public static int MysticLiquidStorageRenderid;
	public static int MysticOreRiftRenderid;
	@Override
	public void registerRenderInformation() 
	  {  
		//textures
		KeyBinding[] key = {new KeyBinding("Crafting Gui", Keyboard.KEY_U)};
        boolean[] repeat = {false};
        KeyBindingRegistry.registerKeyBinding(new MysticKeyHandler(key, repeat));
		
    	
		
		//rendering
		//RenderingRegistry.instance().registerEntityRenderingHandler(EntityTest.class, new RenderCatTest());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticArrow.class, new RenderMysticArrow());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticTeleArrow.class, new RenderMysticTeleArrow());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticExplosiveArrow.class, new RenderMysticExplosiveArrow());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticFireArrow.class, new RenderMysticFireArrow());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntitySteelShuriken.class, new RenderSteelShuriken());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticFreezeArrow.class, new RenderMysticFreezeArrow());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticLightningArrow.class, new RenderMysticLightningArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityMysticWindOrb.class, new RenderMysticMagicOrb());
		RenderingRegistry.registerEntityRenderingHandler(EntityMysticWaterOrb.class, new RenderMysticMagicOrb());
		MysticCapacitorRenderId = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMysticRedStorage.class, new RenderMysticECapacitorBase());
		
		
		
		MysticGeneratorRenderId = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMysticRedGenerator.class, new RenderMysticGenerator());
		
		MysticCrystalGeneratorRenderId = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMysticCrystalGenerator.class, new RenderMysticCrystalGenerator());
		
		MysticRedGrinderid = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMysticRedGrinder.class, new RenderMysticRedGrinder());
		
		MysticCapacitormrk2RenderID = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMysticRedStorageMrk2.class, new RenderMysticRedStorageMrk2());
		
		MysticLiquidStorageRenderid = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLiquidStorage.class, new RenderLiquidStorage());
		
		MysticOreRiftRenderid = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityOreRift.class, new RenderOreRift());
		
		MinecraftForgeClient.registerItemRenderer(MysticModBlocks.mysticRedStorage.blockID, new RenderTileEntityBase(new TileEntityMysticRedStorage()));
		MinecraftForgeClient.registerItemRenderer(MysticModBlocks.mysticRedStorageMrk2.blockID, new RenderTileEntityBase(new TileEntityMysticRedStorageMrk2()));
		MinecraftForgeClient.registerItemRenderer(MysticModBlocks.mysticRedGenerator.blockID, new RenderTileEntityBase(new TileEntityMysticRedGenerator()));
		MinecraftForgeClient.registerItemRenderer(MysticModBlocks.mysticRedGrinder.blockID, new RenderTileEntityBase(new TileEntityMysticRedGrinder()));
		MinecraftForgeClient.registerItemRenderer(MysticModBlocks.crystalGenerator.blockID, new RenderTileEntityBase(new TileEntityMysticCrystalGenerator()));
		MinecraftForgeClient.registerItemRenderer(MysticModBlocks.liquidStorage.blockID, new RenderTileEntityBase(new TileEntityLiquidStorage()));
		MinecraftForgeClient.registerItemRenderer(MysticModBlocks.oreRift.blockID, new RenderTileEntityBase(new TileEntityOreRift()));
}
	@Override
	public int addArmor(String armor)
	{
	    return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	public void registerServerTickHandlers()
	{
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}
}

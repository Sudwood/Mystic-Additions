package client.sudwood.mysticadditions;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraftforge.client.MinecraftForgeClient;

import client.sudwood.mysticadditions.renderers.RenderMysticArrow;
import client.sudwood.mysticadditions.renderers.RenderMysticECapacitorBase;
import client.sudwood.mysticadditions.renderers.RenderMysticExplosiveArrow;
import client.sudwood.mysticadditions.renderers.RenderMysticFireArrow;
import client.sudwood.mysticadditions.renderers.RenderMysticFreezeArrow;
import client.sudwood.mysticadditions.renderers.RenderMysticGenerator;
import client.sudwood.mysticadditions.renderers.RenderMysticLightningArrow;
import client.sudwood.mysticadditions.renderers.RenderMysticMagicOrb;
import client.sudwood.mysticadditions.renderers.RenderMysticRedGeneratorHelper;
import client.sudwood.mysticadditions.renderers.RenderMysticRedGrinder;
import client.sudwood.mysticadditions.renderers.RenderMysticTeleArrow;
import client.sudwood.mysticadditions.renderers.RenderSteelShuriken;

import com.sudwood.mysticadditions.MysticCommonProxy;
import com.sudwood.mysticadditions.entity.EntityEarthMiniBoss;
import com.sudwood.mysticadditions.entity.EntityFireMiniBoss;
import com.sudwood.mysticadditions.entity.EntityMysticWaterOrb;
import com.sudwood.mysticadditions.entity.EntityMysticWindOrb;
import com.sudwood.mysticadditions.entity.EntityWaterMiniBoss;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGenerator;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGrinder;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorage;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
public class MysticClientProxy extends com.sudwood.mysticadditions.MysticCommonProxy {

	public static int MysticCapacitorRenderId;
	public static int MysticGeneratorRenderId;
	public static int MysticRedGrinderid;
	@Override
	public void registerRenderInformation() 
	  {  
		//textures
		
		
		
		
		//rendering
		//RenderingRegistry.instance().registerEntityRenderingHandler(EntityTest.class, new RenderCatTest());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticArrow.class, new RenderMysticArrow());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticTeleArrow.class, new RenderMysticTeleArrow());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticExplosiveArrow.class, new RenderMysticExplosiveArrow());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticFireArrow.class, new RenderMysticFireArrow());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntitySteelShuriken.class, new RenderSteelShuriken());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticFreezeArrow.class, new RenderMysticFreezeArrow());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticLightningArrow.class, new RenderMysticLightningArrow());
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticKnight.class, new RenderBiped(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityMysticArcher.class, new RenderBiped(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(com.sudwood.mysticadditions.entity.EntityWindMiniBoss.class, new RenderBiped(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMysticWindOrb.class, new RenderMysticMagicOrb());
		RenderingRegistry.registerEntityRenderingHandler(EntityMysticWaterOrb.class, new RenderMysticMagicOrb());
		RenderingRegistry.registerEntityRenderingHandler(EntityFireMiniBoss.class, new RenderBiped(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityWaterMiniBoss.class, new RenderBiped(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEarthMiniBoss.class, new RenderBiped(new ModelBiped(), 0.5F));
		MysticCapacitorRenderId = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMysticRedStorage.class, new RenderMysticECapacitorBase());
		
		MysticGeneratorRenderId = RenderingRegistry.getNextAvailableRenderId();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMysticRedGenerator.class, new RenderMysticGenerator());
		RenderingRegistry.registerBlockHandler(MysticGeneratorRenderId, new RenderMysticRedGeneratorHelper());
		MysticRedGrinderid = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMysticRedGrinder.class, new RenderMysticRedGrinder());
}
	@Override
	public int addArmor(String armor)
	{
	    return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}

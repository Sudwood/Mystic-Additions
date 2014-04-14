package com.sudwood.mysticadditions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import client.sudwood.mysticadditions.gui.GuiFluidConfiguration;
import client.sudwood.mysticadditions.gui.GuiLiquidStorage;
import client.sudwood.mysticadditions.gui.GuiModuleInventory;
import client.sudwood.mysticadditions.gui.GuiMysticBud;
import client.sudwood.mysticadditions.gui.GuiMysticEnergyConfiguration;
import client.sudwood.mysticadditions.gui.GuiMysticFurnace;
import client.sudwood.mysticadditions.gui.GuiMysticRedGenerator;
import client.sudwood.mysticadditions.gui.GuiMysticRedGrinder;
import client.sudwood.mysticadditions.gui.GuiMysticRedStorage;
import client.sudwood.mysticadditions.gui.GuiMysticRedStorageMrk2;
import client.sudwood.mysticadditions.gui.GuiNaturalRift;
import client.sudwood.mysticadditions.gui.GuiOreRift;
import client.sudwood.mysticadditions.gui.GuiPoweredFurnace;
import client.sudwood.mysticadditions.gui.GuiPoweredMysticFurnace;
import client.sudwood.mysticadditions.gui.GuiRecallPortal;

import com.sudwood.mysticadditions.container.ContainerLiquidStorage;
import com.sudwood.mysticadditions.container.ContainerMysticFurnace;
import com.sudwood.mysticadditions.container.ContainerMysticModules;
import com.sudwood.mysticadditions.container.ContainerMysticRedGenerator;
import com.sudwood.mysticadditions.container.ContainerMysticRedGrinder;
import com.sudwood.mysticadditions.container.ContainerMysticRedStorage;
import com.sudwood.mysticadditions.container.ContainerMysticRedStorageMrk2;
import com.sudwood.mysticadditions.container.ContainerNaturalRift;
import com.sudwood.mysticadditions.container.ContainerOreRift;
import com.sudwood.mysticadditions.container.ContainerPoweredFurnace;
import com.sudwood.mysticadditions.container.ContainerPoweredMysticFurnace;
import com.sudwood.mysticadditions.container.ContainerRecallPortal;
import com.sudwood.mysticadditions.tileentity.TileEntityLiquidStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityModuleTable;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticEnergy;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticFurnace;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGenerator;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGrinder;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorageMrk2;
import com.sudwood.mysticadditions.tileentity.TileEntityNaturalRift;
import com.sudwood.mysticadditions.tileentity.TileEntityOreRift;
import com.sudwood.mysticadditions.tileentity.TileEntityPoweredFurnace;
import com.sudwood.mysticadditions.tileentity.TileEntityPoweredMysticFurnace;
import com.sudwood.mysticadditions.tileentity.TileEntityRecallPortal;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandlerMystic implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
		if(id==0)
		{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity instanceof TileEntityMysticFurnace)
        	{
                return new ContainerMysticFurnace(player.inventory, (TileEntityMysticFurnace) tileEntity);
        	}        
		}
		
		if(id==1)
		{
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityLiquidStorage){
			return new ContainerLiquidStorage(player.inventory, (TileEntityLiquidStorage)tileEntity);
			}
		}
		
		
		if (id==2)
		{
			return null;
		}
		if (id==3){
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityMysticRedGenerator){
			return new ContainerMysticRedGenerator(player.inventory, (TileEntityMysticRedGenerator)tileEntity);
			}
		}
		if (id==4){
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityMysticRedStorage){
			return new ContainerMysticRedStorage(player.inventory, (TileEntityMysticRedStorage)tileEntity);
			}
		}
		if (id==5){
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityMysticRedGrinder){
			return new ContainerMysticRedGrinder(player.inventory, (TileEntityMysticRedGrinder)tileEntity);
			}
		}
		if (id==6){
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityPoweredFurnace){
			return new ContainerPoweredFurnace(player.inventory, (TileEntityPoweredFurnace)tileEntity);
			}
		}
		if (id==7){
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityPoweredMysticFurnace){
			return new ContainerPoweredMysticFurnace(player.inventory, (TileEntityPoweredMysticFurnace)tileEntity);
			}
		}
		if (id==8)
		{
			
		}
		if (id==9){
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityMysticRedStorageMrk2){
			return new ContainerMysticRedStorageMrk2(player.inventory, (TileEntityMysticRedStorageMrk2)tileEntity);
			}
		}
		if (id==MysticAdditions.MODULE_INVENTORY_GUI)
		{
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityModuleTable)
			{
				return new ContainerMysticModules(player, player.inventory, (TileEntityModuleTable)tileEntity);
			}
		}
		
		if(id == 11)
		{
			
		}
		if(id == 12)
		{
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityRecallPortal)
			{
				return new ContainerRecallPortal(player.inventory, (TileEntityRecallPortal)tileEntity);
			}
		}
		if(id == 13)
		{
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityOreRift)
			{
				return new ContainerOreRift(player.inventory, (TileEntityOreRift)tileEntity);
			}
		}
		if(id == 14)
		{
			TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
			if(tileEntity instanceof TileEntityNaturalRift)
			{
				return new ContainerNaturalRift(player.inventory, (TileEntityNaturalRift)tileEntity);
			}
		}
	
		return null;
	}
@Override	
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z)
{
	if(id==0){
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity instanceof TileEntityMysticFurnace)
        	{
                return new GuiMysticFurnace(player.inventory, (TileEntityMysticFurnace) tileEntity);
        	}        
		}
		
	if(id==1)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityLiquidStorage){
		return new GuiLiquidStorage(player.inventory, (TileEntityLiquidStorage)tileEntity);
		}
	}
	
	if (id==2){
		
		return new GuiMysticBud(world, player, x, y, z);
	}
	
	if (id==3)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityMysticRedGenerator){
		return new GuiMysticRedGenerator(player.inventory, (TileEntityMysticRedGenerator)tileEntity);
		}
	}	
	if (id==4)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityMysticRedStorage){
		return new GuiMysticRedStorage(player.inventory, (TileEntityMysticRedStorage)tileEntity);
		}
	}	
	if (id==5)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityMysticRedGrinder){
		return new GuiMysticRedGrinder(player.inventory, (TileEntityMysticRedGrinder)tileEntity);
		}
	}
	if (id==6)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityPoweredFurnace){
		return new GuiPoweredFurnace(player.inventory, (TileEntityPoweredFurnace)tileEntity);
		}
	}
	if (id==7)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityPoweredMysticFurnace){
		return new GuiPoweredMysticFurnace(player.inventory, (TileEntityPoweredMysticFurnace)tileEntity);
		}
	}
	if (id==8)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityMysticEnergy){
		return new GuiMysticEnergyConfiguration((TileEntityMysticEnergy)tileEntity);
		}
	}
	if (id==9)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityMysticRedStorageMrk2){
		return new GuiMysticRedStorageMrk2(player.inventory, (TileEntityMysticRedStorageMrk2)tileEntity);
		}
	}
	if (id==MysticAdditions.MODULE_INVENTORY_GUI)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityModuleTable)
		{
			return new GuiModuleInventory(player, player.inventory, (TileEntityModuleTable)tileEntity);
		}
	}
	if(id == 11)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityLiquidStorage)
		{
			return new GuiFluidConfiguration((TileEntityLiquidStorage) tileEntity);
		}
	}
	if( id == 12)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityRecallPortal)
		{
			return new GuiRecallPortal(player, player.inventory, (TileEntityRecallPortal)tileEntity);
		}
	}
	if( id == 13)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityOreRift)
		{
			return new GuiOreRift(player, player.inventory, (TileEntityOreRift)tileEntity);
		}
	}
	if( id == 14)
	{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityNaturalRift)
		{
			return new GuiNaturalRift(player.inventory, (TileEntityNaturalRift)tileEntity);
		}
	}
    return null;
}
	

}

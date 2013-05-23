package com.sudwood.mysticadditions;

import com.sudwood.mysticadditions.container.ContainerMysticFurnace;
import com.sudwood.mysticadditions.container.ContainerMysticRedGenerator;
import com.sudwood.mysticadditions.container.ContainerMysticRedGrinder;
import com.sudwood.mysticadditions.container.ContainerMysticRedStorage;
import com.sudwood.mysticadditions.container.ContainerMysticRedStorageMrk2;
import com.sudwood.mysticadditions.container.ContainerPoweredFurnace;
import com.sudwood.mysticadditions.container.ContainerPoweredMysticFurnace;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticEnergy;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticFurnace;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGenerator;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedGrinder;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorage;
import com.sudwood.mysticadditions.tileentity.TileEntityMysticRedStorageMrk2;
import com.sudwood.mysticadditions.tileentity.TileEntityPoweredFurnace;
import com.sudwood.mysticadditions.tileentity.TileEntityPoweredMysticFurnace;

import client.sudwood.mysticadditions.gui.GuiMysticBud;
import client.sudwood.mysticadditions.gui.GuiMysticEnergyConfiguration;
import client.sudwood.mysticadditions.gui.GuiMysticFurnace;
import client.sudwood.mysticadditions.gui.GuiMysticRedGenerator;
import client.sudwood.mysticadditions.gui.GuiMysticRedGrinder;
import client.sudwood.mysticadditions.gui.GuiMysticRedStorage;
import client.sudwood.mysticadditions.gui.GuiMysticRedStorageMrk2;

import client.sudwood.mysticadditions.gui.GuiPoweredFurnace;
import client.sudwood.mysticadditions.gui.GuiPoweredMysticFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandlerMystic implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z){
		if(id==0)
		{
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity instanceof TileEntityMysticFurnace){
                return new ContainerMysticFurnace(player.inventory, (TileEntityMysticFurnace) tileEntity);
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
	
		return null;
	}
@Override	
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
            int x, int y, int z)
{
	if(id==0){
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity instanceof TileEntityMysticFurnace){
                return new GuiMysticFurnace(player.inventory, (TileEntityMysticFurnace) tileEntity);
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
	
    return null;
}
	

}

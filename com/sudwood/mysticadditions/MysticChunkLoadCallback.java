package com.sudwood.mysticadditions;
import java.util.List;

import net.minecraft.world.World;
import net.minecraftforge.common.ForgeChunkManager;
import net.minecraftforge.common.ForgeChunkManager.Ticket;

import com.google.common.collect.Lists;
import com.sudwood.mysticadditions.blocks.MysticModBlocks;
import com.sudwood.mysticadditions.tileentity.TileEntityOreRift;

public class MysticChunkLoadCallback implements ForgeChunkManager.OrderedLoadingCallback {

	@Override
	public void ticketsLoaded(List<Ticket> tickets, World world) {
		for (Ticket ticket : tickets) {
			int blockX = ticket.getModData().getInteger("blockX");
			int blockY = ticket.getModData().getInteger("blockY");
			int blockZ = ticket.getModData().getInteger("blockZ");
			int type = ticket.getModData().getInteger("type");
			TileEntityOreRift tor = (TileEntityOreRift) world.getBlockTileEntity(blockX, blockY, blockZ);
			if(type == 0)
			tor.loadTicket(ticket);
			else if(type == 1)
				tor.loadMining(ticket);

		}
	}

	@Override
	public List<Ticket> ticketsLoaded(List<Ticket> tickets, World world,
			int maxTicketCount) 
	{
		List<Ticket> validTickets = Lists.newArrayList();
		for (Ticket ticket : tickets) {
			int blockX = ticket.getModData().getInteger("blockX");
			int blockY = ticket.getModData().getInteger("blockY");
			int blockZ = ticket.getModData().getInteger("blockZ");

			int block = world.getBlockId(blockX, blockY, blockZ);
			if(block == MysticModBlocks.oreRift.blockID)
			{
				validTickets.add(ticket);
			}
		}
		return validTickets;
	}
	

}

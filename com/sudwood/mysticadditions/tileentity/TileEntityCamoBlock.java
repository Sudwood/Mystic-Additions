package com.sudwood.mysticadditions.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCamoBlock extends TileEntity
{
	
	private String[] players = new String[2];
	private boolean playerListFull;
	private int showid =2226;
	private int showmeta =0;
	public int getShowid()
	{
		return showid;
	}
	public void setShowid(int showid)
	{
		this.showid = showid;
	}
	public int getShowmeta()
	{
		return showmeta;
	}
	public void setShowmeta(int showmeta)
	{
		this.showmeta = showmeta;
	}
	public void populatePlayers()
	{
		for (int i=0;i<players.length;i++)
		{
			if(players[i]==null)
				players[i]="null";
		}
	}
	public boolean isPlayerListFull()
	{
		return playerListFull;
	}
	public void setPlayerListFull(boolean playerListFull)
	{
		this.playerListFull = playerListFull;
	}
	public String[] getPlayers()
	{
		return players;
	}
	public void setPlayers(String[] players)
	{
		this.players = players;
	}
	public void addToPlayers(String player)
	{
		if(this.playerListFull)
		{
			return;
		}
		for(int i =0; i<players.length; i++)
		{
			if(players[i].equals("null"))
				players[i]=player;
			return;
		}
		checkPlayerListFull();
	}
	public void checkPlayerListFull()
	{
		for (int i = 0; i<players.length; i++)
		{
			if(players[i].equals("null"))
				this.playerListFull = false;
			return;
		}
		this.playerListFull = true;
	}
	
	public void readFromNBT(NBTTagCompound tag)
    {
	super.readFromNBT(tag);
	this.playerListFull = tag.getBoolean("playersfull");
	this.showid = tag.getInteger("idblock");
	this.showmeta = tag.getInteger("metablock");
	NBTTagCompound tag2 = (NBTTagCompound) tag.getTag("tag2");
	for (int i=0;i<players.length;i++)
	{
		players[i] = tag2.getString("players"+i);
	}
    }
	public void writeToNBT(NBTTagCompound tag)
    {
		
		super.writeToNBT(tag);
		this.populatePlayers();
		tag.setBoolean("playersfull", this.playerListFull);
		tag.setInteger("idblock", showid);
		tag.setInteger("metablock", showmeta);
		NBTTagCompound tag2 = new NBTTagCompound();
		tag2.setName("tag2");
		for(int i=0;i<players.length;i++)
		{
			tag2.setString("players"+i, players[i]);
		}
		tag.setTag("tag2", tag2);
		
    }
	
	
}

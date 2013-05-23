package com.sudwood.mysticadditions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MysticERegistration {

 public static List ids = new ArrayList(); 
 public static List tiles = new ArrayList();
	/**
	 * Registers the block id as part of the mystic energy network
	 * 
	 * @param x
	 */
	public static void registerMysticEnergyID(int x)
	{
		ids.add(x);
	}
	public static void registerMysticEnergyTile(String tile)
	{
		tiles.add(tile);
	}
	public static int[] convertIntegers(List<Integer> ids)
	{
	    int[] blocks = new int[ids.size()];
	    Iterator<Integer> iterator = ids.iterator();
	    for (int i = 0; i < blocks.length; i++)
	    {
	       blocks[i] = iterator.next().intValue();
	    }
	    return blocks;
	}
	public static int[] getMysticEnergyIDs()
	{
		return convertIntegers(ids);
	}
	
	
	
	
}

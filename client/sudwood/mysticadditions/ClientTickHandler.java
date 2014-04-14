package client.sudwood.mysticadditions;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeable;
import com.sudwood.mysticadditions.items.energy.IItemMysticRechargeableArmor;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ITickHandler {

	private final Minecraft mc;
	public ClientTickHandler()
	{
		mc = Minecraft.getMinecraft();
	}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		
		if(type.contains(TickType.RENDER))
		{
			
			overlayTick(Minecraft.getMinecraft().thePlayer);
			
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return EnumSet.of(TickType.RENDER);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void overlayTick(EntityPlayer player)
	{
		
		if(player!=null)
		{
			if(player.inventory.armorItemInSlot(3) == null)
			{
				player.capabilities.setPlayerWalkSpeed(0.1F);
				player.jumpMovementFactor = 0.02F;
				player.sendPlayerAbilities();
			}
		
		boolean doesNeedCharge = false;
		int nump = 0;
		int charge =0;
		for(int i = 0; i<4; i++ )
		{
			if(player!=null&&player.inventory.armorItemInSlot(i)!=null)
			{
			
			ItemStack tempStack = player.inventory.armorItemInSlot(i);
			if(player.inventory.armorItemInSlot(i).getTagCompound()==null)
			  {
				player.inventory.armorItemInSlot(i).setTagCompound(new NBTTagCompound());
			  }
			NBTTagCompound tag = player.inventory.armorItemInSlot(i).getTagCompound();
			if(tempStack.getItem() instanceof IItemMysticRechargeableArmor)
			{
			doesNeedCharge = true;
			charge += tag.getInteger("CurrentCharge");
			nump+= tag.getInteger("MaxStorage");
			}
			}
		}
		if(player!=null&&player.inventory.getCurrentItem()!=null)
		{
			ItemStack tempStack = player.inventory.getCurrentItem();
			if(tempStack.getItem() instanceof IItemMysticRechargeable)
			{
			if(player.inventory.getCurrentItem().getTagCompound()==null)
			  {
				player.inventory.getCurrentItem().setTagCompound(new NBTTagCompound());
			  }
			NBTTagCompound tag = player.inventory.getCurrentItem().getTagCompound();
			doesNeedCharge = true;
			charge += tag.getInteger("CurrentCharge");
			nump+= tag.getInteger("MaxStorage");
			
			}
		}
		
		if(player!=null&&doesNeedCharge)
		{
			//Minecraft.getMinecraft().fontRenderer.drawString(charge+"/"+nump+" MyJ", 1, 1, 16777215);
			ScaledResolution res = new ScaledResolution(this.mc.gameSettings,
			this.mc.displayWidth, this.mc.displayHeight);
			FontRenderer fontRender = mc.fontRenderer;
			int width = res.getScaledWidth();
			int height = res.getScaledHeight();
			mc.entityRenderer.setupOverlayRendering();

			// draw
			String text = charge+"/"+nump+" MyJ";
			int x = 2;
			int y = 2;
			int color = 0xFFFFFF;
			fontRender.drawStringWithShadow(text, x, y, color);
		}
	}
		
	}
	
	
	
	
}

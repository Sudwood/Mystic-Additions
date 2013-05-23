package client.sudwood.mysticadditions.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
@SideOnly(Side.CLIENT)
public class GuiMysticBud extends GuiScreen{
	
int xSizeOfTexture = 247;
int ySizeOfTexture = 165;
public GuiMysticBud(World world, EntityPlayer player, int x, int y, int z){
}
public void initGui()
{
this.buttonList.clear();

int posX = (this.width - xSizeOfTexture) / 2;
int posY = (this.height - ySizeOfTexture) / 2;

this.buttonList.add(new GuiButton(0, posX+ 40, posY + 10, 50, 20, "Top"));
this.buttonList.add(new GuiButton(0, posX+ 40, posY + 40, 50, 20, "Bottom"));
this.buttonList.add(new GuiButton(0, posX+ 40, posY + 70, 50, 20, "Left"));
this.buttonList.add(new GuiButton(0, posX+ 40, posY + 100, 50, 20, "Right"));
this.buttonList.add(new GuiButton(0, posX+ 40, posY + 130, 50, 20, "Back"));
}
@Override
public void drawScreen(int x, int y, float f)
{
drawDefaultBackground();
String var4 = "/MysticAdditions/mysticbudgui.png";
GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
this.mc.renderEngine.bindTexture(var4);

int posX = (this.width - xSizeOfTexture) / 2;
int posY = (this.height - ySizeOfTexture) / 2;

drawTexturedModalRect(posX, posY, 0, 0, xSizeOfTexture, ySizeOfTexture);
super.drawScreen(x, y, f);
}
public void actionPerformed(GuiButton button)
{
switch(button.id)
{
case 0: System.out.println("0"); break;
case 1: System.out.println("1"); break;
case 2: System.out.println("2"); break;
case 3: System.out.println("3"); break;
case 4: System.out.println("4"); break;
default:
}
}
@Override
protected void keyTyped(char par1, int par2)
{
if (par2 == 1 || par2 == this.mc.gameSettings.keyBindInventory.keyCode)
{
this.mc.thePlayer.closeScreen();
}
}
@Override
public boolean doesGuiPauseGame()
{
return true;
}

}
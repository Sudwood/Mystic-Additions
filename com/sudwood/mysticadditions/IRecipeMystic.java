package com.sudwood.mysticadditions;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IRecipeMystic
{
    /**
     * Used to check if a recipe matches current crafting inventory
     */
    boolean matches(InventoryCraftingMystic craftMatrix, World var2);

    /**
     * Returns an Item that is the result of this recipe
     */
    ItemStack getCraftingResult(InventoryCraftingMystic craftMatrix);

    /**
     * Returns the size of the recipe area
     */
    int getRecipeSize();

    ItemStack getRecipeOutput();
}

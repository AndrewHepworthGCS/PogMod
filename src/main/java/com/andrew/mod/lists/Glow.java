package com.andrew.mod.lists;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Glow extends Item //sub class of the item class, so it can access the files from vanilla minecrafts item class
{
	public Glow(Properties properties)
	{
			super(properties);
	}
	
	@Override //Overriding the fact that vanilla minecraft gives the item an enchanted look from enchanting items only
	public Item asItem() {
		return super.asItem();
	}
@Override
public boolean hasEffect(ItemStack stack)
{
	return true;
}

}
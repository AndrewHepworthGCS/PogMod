package com.andrew.mod.lists;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class FoodList {
	//add any foods into the game. The amount of hunger/saturation they give and any effects.
	@SuppressWarnings("deprecation")
	public static final Food GOLDEN_POTATO = (new Food.Builder().hunger(6).saturation(15F).effect(new EffectInstance(Effects.ABSORPTION, 1200, 4), 1f).effect(new EffectInstance(Effects.REGENERATION, 300, 1), 1f).setAlwaysEdible()).build();
	@SuppressWarnings("deprecation")
	public static final Food ENCHANTED_GOLDEN_POTATO = (new Food.Builder().hunger(8).saturation(18F).effect(new EffectInstance(Effects.ABSORPTION, 1200, 8), 1f).effect(new EffectInstance(Effects.REGENERATION, 300, 3), 1f).effect(new EffectInstance(Effects.RESISTANCE, 300, 2), 1f).effect(new EffectInstance(Effects.STRENGTH, 1200, 2), 1f).setAlwaysEdible()).build();
	@SuppressWarnings("deprecation")
	public static final Food ENCHANTED_GOLDEN_CARROT = (new Food.Builder().hunger(7).saturation(16F).effect(new EffectInstance(Effects.ABSORPTION, 1200, 6), 1f).effect(new EffectInstance(Effects.REGENERATION, 300, 2), 1f).effect(new EffectInstance(Effects.RESISTANCE, 300, 1), 1f).effect(new EffectInstance(Effects.STRENGTH, 1200, 1), 1f)).build();
}
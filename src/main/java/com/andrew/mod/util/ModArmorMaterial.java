package com.andrew.mod.util;

import java.util.function.Supplier;

import com.andrew.mod.lists.ItemList;
import com.andrew.mod.Main;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterial implements IArmorMaterial
{
	/*This creates the material that the armor is made out of (Glass armor set)
All the different settings for the armor material (affects the full set). Armor provided for each piece, durability,
 sound effects, enchantability and knockback resistance */
	   GLASS(Main.MOD_ID + ":glass", 25, new int []{20, 20, 20, 20}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,
			   0.0f, 0.0f, () -> {
		   return Ingredient.fromItems(ItemList.electronic);
	   });
	
	   private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
	   private final String name;
	   private final int maxDamageFactor;
	   private final int[] damageReductionAmountArray;
	   private final int enchantability;
	   private final SoundEvent soundEvent;
	   private final float toughness;
	   private final float knockbackResistance;
	   private final LazyValue<Ingredient> repairMaterial;

	   private ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
	      this.name = name;
	      this.maxDamageFactor = maxDamageFactor;
	      this.damageReductionAmountArray = damageReductionAmountArray;
	      this.enchantability = enchantability;
	      this.soundEvent = soundEvent;
	      this.toughness = toughness;
	      this.knockbackResistance = knockbackResistance;
	      this.repairMaterial = new LazyValue<>(repairMaterial);
	   }
//returns all the different values inputted
	   public int getDurability(EquipmentSlotType slotIn) {
	      return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	   }

	   public int getDamageReductionAmount(EquipmentSlotType slotIn) {
	      return this.damageReductionAmountArray[slotIn.getIndex()];
	   }

	   public int getEnchantability() {
	      return this.enchantability;
	   }

	   public SoundEvent getSoundEvent() {
	      return this.soundEvent;
	   }

	   public Ingredient getRepairMaterial() {
	      return this.repairMaterial.getValue();
	   }

	   @OnlyIn(Dist.CLIENT)
	   public String getName() {
	      return this.name;
	   }

	   public float getToughness() {
	      return this.toughness;
	   }

	   /*
 Gets the percentage of knockback resistance provided by armor of the material. 
	    */
	   public float getKnockbackResistance() {
	      return this.knockbackResistance;
	   }
}

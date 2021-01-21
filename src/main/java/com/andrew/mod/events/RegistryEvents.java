package com.andrew.mod.events;

import org.apache.logging.log4j.Logger;

import com.andrew.mod.Main;
import com.andrew.mod.lists.BlockList;
import com.andrew.mod.lists.FoodList;
import com.andrew.mod.lists.Glow;
import com.andrew.mod.lists.ItemList;
import com.andrew.mod.util.ModArmorMaterial;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents
{
	public static final Logger LOGGER = Main.LOGGER;
	public static final ItemGroup MODDED = Main.MODDED_TAB;
	public static final String MOD_ID = Main.MOD_ID;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) //register items
	{
		event.getRegistry().registerAll //register everything in the brackets below
		(
				ItemList.golden_potato = new Item(new Item.Properties().group(MODDED).food(FoodList.GOLDEN_POTATO)).setRegistryName(location("golden_potato")),
				ItemList.enchanted_golden_potato = new Glow(new Glow.Properties().group(MODDED).food(FoodList.ENCHANTED_GOLDEN_POTATO)).setRegistryName(location("enchanted_golden_potato")),
				ItemList.enchanted_golden_carrot = new Glow(new Glow.Properties().group(MODDED).food(FoodList.ENCHANTED_GOLDEN_CARROT)).setRegistryName(location("enchanted_golden_carrot")),
				ItemList.light_panel = new BlockItem(BlockList.light_panel, new Item.Properties().group(MODDED)).setRegistryName(BlockList.light_panel.getRegistryName()),
				ItemList.light_panel_slab = new BlockItem(BlockList.light_panel_slab, new Item.Properties().group(MODDED)).setRegistryName(BlockList.light_panel_slab.getRegistryName()),
				ItemList.electronic = new Item(new Item.Properties().group(MODDED)).setRegistryName(location("electronic")),
				ItemList.silica_pearl = new Item(new Item.Properties().group(MODDED)).setRegistryName(location("silica_pearl")),
				ItemList.steel_ore = new BlockItem(BlockList.steel_ore, new Item.Properties().group(MODDED)).setRegistryName(BlockList.steel_ore.getRegistryName()),
				ItemList.steel_ingot = new Item(new Item.Properties().group(MODDED)).setRegistryName(location("steel_ingot")),
				ItemList.steel_block = new BlockItem(BlockList.steel_block, new Item.Properties().group(MODDED)).setRegistryName(BlockList.steel_block.getRegistryName()),
				ItemList.swag_glasses = new ArmorItem(ModArmorMaterial.GLASS, EquipmentSlotType.HEAD, new Item.Properties().group(MODDED)).setRegistryName(location("swag_glasses"))
			); //item registries for Items, BlockItems, ArmorItems and Glow items (Enchanted). Set the registry name, properties and item group you find it in the creative inventory.
	}
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) //register blocks
	{
		event.getRegistry().registerAll
		(
				BlockList.light_panel = new Block(Block.Properties.create(Material.GLASS).setLightLevel((lightlevel) -> 15).hardnessAndResistance(1, 0).harvestTool(ToolType.PICKAXE)).setRegistryName(location("light_panel")),
				BlockList.light_panel_slab = new SlabBlock(Block.Properties.from(BlockList.light_panel)).setRegistryName(location("light_panel_slab")),
				BlockList.steel_ore = new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(8, 3).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()).setRegistryName(location("steel_ore")),
				BlockList.steel_block = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(10, 3).harvestTool(ToolType.PICKAXE).harvestLevel(2).setRequiresTool()).setRegistryName(location("steel_block"))
		); //block registries, set the tool required, difficulty to mine, light level it produces and material
	}
	public static ResourceLocation location(String name)
	{
		return new ResourceLocation(MOD_ID, name);
	}
}

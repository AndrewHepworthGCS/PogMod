package com.andrew.mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.andrew.mod.lists.ItemList;
import com.andrew.mod.world.OreGeneration;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Main.MOD_ID)
public class Main
{
	public static Main instance;
	public static final String MOD_ID = "compscimod"; // This Sets MOD_ID to be the mod id
	public static final ItemGroup MODDED_TAB = new Main.Modded("modded_group"); //Creates the ItemGroup Modded Tab
	public static final Logger LOGGER = LogManager.getLogger();
	
	public Main()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup); // Launching setup
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup); //Client Setup
		
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres); //Custom Ore Generation event
	}
	private void setup(final FMLCommonSetupEvent event)
	{
		
	}
	
	private void clientSetup(final FMLClientSetupEvent event)
	{
		
	}
	
	public void onServerStarting(FMLServerStartingEvent event)
	{
		
	}
	
	public static class Modded extends ItemGroup { //Public class extending item group, this is for custom creative inventory tab
		
		public Modded(String name) {
			super(name);
		}
		
		@Override
		public ItemStack createIcon() { //Setting the item group logo to the steel ingot texture
			return new ItemStack(ItemList.steel_ingot);
		}
	}
}

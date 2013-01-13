package com.theswak.sleepytime;

import java.util.logging.Level;

import com.theswak.sleepytime.commands.CommandBedTime;
import com.theswak.sleepytime.handlers.CommandEventHandler;
import com.theswak.sleepytime.handlers.EventHooksHandler;
import com.theswak.sleepytime.handlers.GuiHandler;
import com.theswak.sleepytime.handlers.LogHandler;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ICommand;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy implements IGuiHandler
{	
	/* PREINIT */
	public void preInit(FMLPreInitializationEvent event)
	{	// Configuration File
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			config.load();
		
//			modEnabledFlag = config.get(Configuration.CATEGORY_GENERAL, "ModEnabled", true).getBoolean(true);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally
		{
			config.save();
		}
		
		/* FORGE EVENTS REGISTERS */
		MinecraftForge.EVENT_BUS.register(new EventHooksHandler()); // event handling class
		MinecraftForge.EVENT_BUS.register(new CommandEventHandler());
	}
	
	/* PREINIT */
	public void init(FMLInitializationEvent event)
	{
		LogHandler.init();
		
		initializeBlocks();
		registerBlocks();
		addNames();
		setBlockHarvestLevels();
		addRecipes();
		addSmeltingRecipes();
		addOreDictionaryRecipes();
		addOreDictionaryEntries();
		initAchievements();
	}
	
	/* POSTINIT */
	public void postInit(FMLPostInitializationEvent event)
	{
		LogHandler.log(Level.INFO, "SleepyTime Mod Loaded!");
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}
	
	public void registerRenderInformation()
	{
		// for client-side texture registering
	}
	
	//
	public void initializeBlocks()
	{
		// registering TileEntities
		//TODO
	}
	
	public void registerBlocks()
	{
		// registering Blocks
		//TODO
	}
	
	public void addNames()
	{
		// adding Item's Names
		//TODO
	}
	
	public void setBlockHarvestLevels()
	{
		//TODO
	}
	
	public void addRecipes()
	{
		// adding your Item's Recipes
		//TODO
	}
	
	public void addSmeltingRecipes()
	{
		//TODO
	}
	
	public void addOreDictionaryRecipes()
	{
		//TODO
	}
	
	public void addOreDictionaryEntries()
	{
		//TODO
	}
	
	public void initAchievements()
	{
		//TODO
	}
}

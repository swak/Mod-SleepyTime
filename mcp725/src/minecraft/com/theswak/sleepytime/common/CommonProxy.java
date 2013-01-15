package com.theswak.sleepytime.common;

import java.util.logging.Level;

import com.theswak.sleepytime.SleepyTime;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;


import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class CommonProxy
{	
	/* PREINIT */
	public void preInit(FMLPreInitializationEvent event)
	{	
		// Configuration File
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			config.load();
		} 
		catch (Exception e) { e.printStackTrace(); } 
		finally { config.save(); }
		
		registerHandlers();
	}
	
	/* PREINIT */
	public void init(FMLInitializationEvent event)
	{
		LogHandler.init();
	}
	
	/* POSTINIT */
	public void postInit(FMLPostInitializationEvent event)
	{
		LogHandler.log(Level.INFO, "initialized.");
	}
	
	// for client-side texture registering
	public void registerRenderInformation() {}
	
	/* REGISTER HANDLERS */
	private void registerHandlers()
	{
		/* FORGE EVENTS */
		MinecraftForge.EVENT_BUS.register(new EventHooksHandler());
		MinecraftForge.EVENT_BUS.register(new CommandEventHandler());
	}
}

package com.theswak.sleepytime;

import java.util.HashSet;

import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ICommandManager;
import net.minecraft.src.ModLoader;
import net.minecraft.src.ServerCommandManager;
import net.minecraftforge.common.MinecraftForge;

import com.theswak.sleepytime.commands.*;
import com.theswak.sleepytime.handlers.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.IMCCallback;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarted;
import cpw.mods.fml.common.Mod.ServerStarting;
import cpw.mods.fml.common.Mod.ServerStopping;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;

/**
 * 
 * @author theSwak
 *
 */

@Mod( modid = SleepyTime.ID, name = SleepyTime.MODNAME, version= SleepyTime.VERSION )
@NetworkMod
(
		clientSideRequired = true,
		serverSideRequired = false,
		clientPacketHandlerSpec = @SidedPacketHandler(channels = { SleepyTime.ID }, packetHandler = ClientPacketHandler.class),
		serverPacketHandlerSpec = @SidedPacketHandler(channels = { SleepyTime.ID }, packetHandler = ServerPacketHandler.class)
)
public class SleepyTime
{
	public static final String ID = "SleepyTime";
	public static final String MODNAME = "SleepyTime : the AFK Mod";
	public static final String MCVERSION = "1.4.5";
	public static final String VERSION = "0.2";
	public static final boolean DEBUG_MODE = false;
	
	@SidedProxy(clientSide="com.theswak.sleepytime.ClientProxy", serverSide="com.theswak.sleepytime.CommonProxy")
	public static CommonProxy proxy;
	public static MinecraftServer server;
	
	@Instance(ID)
	public static SleepyTime instance;
	
	//
	public HashSet<Player> onlineplayers;
	
	
	/* IDS for Configuration File */
//	public static boolean modEnabledFlag;
	/* Items */
	//TODO
	/* Items */
	//TODO
	/* Items */
	///TODO
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit(event);
	}
	
	@Init
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
		proxy.registerRenderInformation();
		
		registerHandlers();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}
	
	@ServerStarting
	public void serverStarting(FMLServerStartingEvent event)
	{
		server = ModLoader.getMinecraftServerInstance();
		ICommandManager commandManager = server.getCommandManager();
		ServerCommandManager serverCommandManager = ((ServerCommandManager) commandManager); 
		addCommands(serverCommandManager);
	}

	@ServerStarted
	public void serverStarted(FMLServerStartedEvent event)
	{
	}

	@ServerStopping
	public void serverStopping(FMLServerStoppingEvent event)
	{
	}
	
	
	/* REGISTER HANDLERS */
	private void registerHandlers()
	{
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
		// registers the client and server tick handlers 
		
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		// registers the class that deals with GUI data
	}
	
	/* ADD COMMANDS */
	private void addCommands(ServerCommandManager manager)
	{
		manager.registerCommand(new CommandBedTime());
		manager.registerCommand(new CommandAfk());
	}
}

package com.theswak.sleepytime.commands;

import java.util.logging.Level;

import com.theswak.sleepytime.handlers.LogHandler;

import net.minecraft.src.CommandBase;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.ICommandSender;
import net.minecraft.src.World;

public class CommandBedTime extends CommandBase
{

	@Override
	public String getCommandName()
	{
		return "bedtime";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args)
	{
		EntityPlayerMP playerMP = getCommandSenderAsPlayer(sender);
		World world = playerMP.worldObj;
		
		if(args.length == 0) {
//			LogHandler.log(Level.INFO, "Passed no Arguments");
			checkPlayersList(world);
		} else {
//			LogHandler.log(Level.INFO, "Passing Arguments");
//			int entID = Integer.parseInt(args[0]); // parse first word
//			int x = Integer.parseInt(args[1]); // parse second word
//			int y = Integer.parseInt(args[2]); // parse third word
//			int z = Integer.parseInt(args[3]); // parse fourth word
//			
//			if(!world.isRemote) {
//				Entity entity = EntityList.createEntityByID(entID, world); // creates an entity with the id defined by the player
//				entity.setPosition(x, y, z);
//				world.spawnEntityInWorld(entity);
//			}
			return;
		}
	}
	
	private void checkPlayersList(World world)
	{
		int playerCount = world.playerEntities.size();
		String msgPlayerCount = "Players Online: " + playerCount;
//		float worldtime = world.provider.getWorldTime();
		
		for(int i = 0; i < playerCount; i++)
		{
			EntityPlayerMP player = (EntityPlayerMP)world.playerEntities.get(i);
			player.sendChatToPlayer("Looking to see who is sleeping?");
			player.sendChatToPlayer(msgPlayerCount);
//			LogHandler.log(Level.INFO, player.toString());
		}
	}

}

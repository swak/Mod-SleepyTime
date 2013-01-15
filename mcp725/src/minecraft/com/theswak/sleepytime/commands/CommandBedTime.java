package com.theswak.sleepytime.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

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
			checkPlayersList(world);
		} else {
			return;
		}
	}
	
	private void checkPlayersList(World world)
	{
		int playerCount = world.playerEntities.size();
		for(int i = 0; i < playerCount; i++)
		{
			EntityPlayerMP player = (EntityPlayerMP)world.playerEntities.get(i);
			player.sendChatToPlayer("Looking to see who is sleeping?");
			player.sendChatToPlayer(getTotalSleeping(world, playerCount));
		}
	}
	
	private String getTotalSleeping(World world, int totalplayers)
	{
		String msg = "PLAYERS IN BED: ";
		int totalSleeping = 0;
		
		for(int i = 0; i < totalplayers; i++)
		{
			EntityPlayerMP player = (EntityPlayerMP)world.playerEntities.get(i);
			if(player.isPlayerSleeping()) {
				totalSleeping++;
			}
		}
		return msg + "(" + totalSleeping + "/" + totalplayers + ")";
	}

}

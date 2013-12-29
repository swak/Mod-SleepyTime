package com.theswak.sleepytime.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntityCommandBlock;

public class CommandBedTime extends SleepyCommand
{

	@Override
	public String getCommandName()
	{
		return "bedtime";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender)
	{
		return "displaying a get command usage";
	}
	
	@Override
	public void ProcessPlayer(EntityPlayer player, String[] params)
	{
		player.addChatMessage("PLAYER HI");
	}

	@Override
	public void ProcessCommandBlock(TileEntityCommandBlock commandBlock, String[] params)
	{
	}

	@Override
	public void ProcessServerConsole(ICommandSender console, String[] params)
	{
	}
	
//	public void processCommand(ICommandSender sender, String[] args)
//	{
//		EntityPlayerMP playerMP = getCommandSenderAsPlayer(sender);
//		World world = playerMP.worldObj;
//		
//		if(args.length == 0) {
//			checkPlayersList(world);
//		} else {
//			return;
//		}
//	}
//	
//	private void checkPlayersList(World world)
//	{
//		int playerCount = world.playerEntities.size();
//		for(int i = 0; i < playerCount; i++)
//		{
//			EntityPlayerMP player = (EntityPlayerMP)world.playerEntities.get(i);
//			player.sendChatToPlayer(getTotalSleeping(world, playerCount));
//		}
//	}
//	
//	private String getTotalSleeping(World world, int totalplayers)
//	{
//		String msg = "\u00A7nPLAYERS IN BED: ";
//		int totalSleeping = 0;
//		
//		for(int i = 0; i < totalplayers; i++)
//		{
//			EntityPlayerMP player = (EntityPlayerMP)world.playerEntities.get(i);
//			if(player.isPlayerSleeping()) {
//				totalSleeping++;
//			}
//		}
//		return msg + "(" + totalSleeping + "/" + totalplayers + ")\u00A7r";
//	}

}

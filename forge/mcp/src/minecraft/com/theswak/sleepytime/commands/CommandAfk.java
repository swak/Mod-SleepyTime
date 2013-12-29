package com.theswak.sleepytime.commands;

import java.util.logging.Level;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.world.World;

import com.theswak.sleepytime.common.LogHandler;
import com.theswak.sleepytime.common.PacketHandler;
import com.theswak.sleepytime.common.PlayerInfo;

public class CommandAfk extends SleepyCommand
{

	@Override
	public String getCommandName()
	{
		return "afk";
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

//	@Override
//	public void processCommand(ICommandSender sender, String[] args) {
//		EntityPlayerMP playerMP = getCommandSenderAsPlayer(sender);
//		World world = playerMP.worldObj;
//		
//		if(args.length == 0) {
//			// player forcing away from keyboard status
//			toggleAFK(playerMP);
//		} else { // parse
//			int awaytime = Integer.parseInt(args[0]);
//			if(awaytime > 0) {
//				setAwayTime(playerMP, awaytime);
//			}
//			
//			return;
//		}
//	}
//	
//	private void toggleAFK(EntityPlayerMP player)
//	{
//		int playerCount = player.worldObj.playerEntities.size();
//		for(int i = 0; i < playerCount; i++)
//		{
//			EntityPlayerMP p = (EntityPlayerMP)player.worldObj.playerEntities.get(i);
//			p.sendChatToPlayer("\u00a78" + player.username + " is now idle.");
//		}
//	}
//	
//	private void setAwayTime(EntityPlayerMP player, int timeamount)
//	{		
//		if(timeamount > 0) {
//			Long worldtime = player.worldObj.provider.getWorldTime();
//			Long currentHour = ((worldtime/20)/60);
//			player.sendChatToPlayer("\u00a78" + player.username + " is setting an idle time: " + currentHour.toString() + "+" + timeamount);
//		}
//	}
}

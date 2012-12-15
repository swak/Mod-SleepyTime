package com.theswak.sleepytime.handlers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;

import com.theswak.sleepytime.SleepyTime;

import cpw.mods.fml.common.network.PacketDispatcher;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;



public class EventHooksHandler
{	
	@ForgeSubscribe
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		LogHandler.log(Level.INFO, "onPlayerInteract!");
	}
	
	@ForgeSubscribe
	public void onSleepyTime(PlayerSleepInBedEvent event)
	{
		try {
			if(event.result.OK != null) {
				EntityPlayer player = event.entityPlayer;
				
//				debugPlayerInfo(player);
				sendMessagePacket(player, "sending this string", 1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			LogHandler.log(Level.WARNING, "PlayerSleepInBedEvent caused a crash!");
		}
		
	}
	
	
	
	private void debugPlayerInfo(EntityPlayer player)
	{
		if(!player.equals(null)) {
			String sender = player.getEntityName();
			
			player.sendChatToPlayer(sender.toString() + " is attempting to sleep...");
		
			LogHandler.log(Level.INFO, player.toString()); // debug player object info
			LogHandler.log(Level.INFO, player.getEntityName()); // get players name
			LogHandler.log(Level.INFO, "DEBUG INFO: " + player.worldObj.playerEntities.get(0).toString());
			
		} else {
			LogHandler.log(Level.WARNING, "EntityPlayer not found!");
		}
	}
	
	
	private void sendMessagePacket(EntityPlayer player, String message, int color)
	{
		Packet250CustomPayload packet = new Packet250CustomPayload();
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(byteStream);
		
		try {
			data.writeInt(color);
			data.writeUTF(message);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		packet.channel = SleepyTime.ID;
		packet.data = byteStream.toByteArray();
		packet.length = packet.data.length;
		
		
		LogHandler.log(Level.INFO, player.username);
		PacketDispatcher.sendPacketToServer(packet);
	}
	
	private void playerMovePacket(EntityPlayer player)
	{
		//TODO
	}
}

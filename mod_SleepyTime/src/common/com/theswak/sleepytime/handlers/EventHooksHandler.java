package com.theswak.sleepytime.handlers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;

import com.theswak.sleepytime.SleepyTime;

import cpw.mods.fml.common.network.PacketDispatcher;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.EnumStatus;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;



public class EventHooksHandler
{	
	private Date time;
//	@ForgeSubscribe
//	public void onPlayerInteract(PlayerInteractEvent event)
//	{
//		LogHandler.log(Level.INFO, "onPlayerInteract!");
//	}
	
	@ForgeSubscribe
	public void onSleepyTime(PlayerSleepInBedEvent event)
	{
		if(!event.entityPlayer.worldObj.isRemote && event.entityPlayer instanceof EntityPlayerMP) {
			time = new Date();
			
			EntityPlayerMP playerMP = (EntityPlayerMP) event.entityPlayer;
			World world = playerMP.worldObj;
			
			try {
				if(event.result.OK != null)  {
					sendMessagePacket(playerMP, time, 0);
//					debugPlayerInfo(player);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				LogHandler.log(Level.SEVERE, "PlayerSleepInBedEvent caused a crash!");
			}
		}
	}
	
	
	private void sendMessagePacket(EntityPlayer player, Date time, int type)
	{
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream data = new DataOutputStream(byteStream);
		
		try {
			String message = "DATE: " + time.toString();
			data.writeUTF(message);
			data.writeInt(type);
			
			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = SleepyTime.ID;
			packet.data = byteStream.toByteArray();
			packet.length = packet.data.length;
//			LogHandler.log(Level.INFO, player.username);
			PacketDispatcher.sendPacketToServer(packet);
			
		} catch (IOException ex) {
			ex.printStackTrace();
			LogHandler.log(Level.SEVERE, "sendMessagePacket FAILED!");
		}
	}
	
	
	//////////////////////// DEBUG ////////////////////////
	private void debugPlayerInfo(EntityPlayer player)
	{
		if(!player.equals(null)) {
			String sender = player.getEntityName();
		
			LogHandler.log(Level.INFO, player.toString()); // debug player object info
			LogHandler.log(Level.INFO, player.getEntityName()); // get players name
			LogHandler.log(Level.INFO, "DEBUG INFO: " + player.worldObj.playerEntities.get(0).toString());
			
		} else {
			LogHandler.log(Level.WARNING, "EntityPlayer not found!");
		}
	}
}

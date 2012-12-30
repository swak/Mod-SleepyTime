package com.theswak.sleepytime.handlers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.logging.Level;

import com.theswak.sleepytime.SleepyTime;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.INetworkManager;
import net.minecraft.src.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class ServerPacketHandler implements IPacketHandler
{

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		if (packet.channel.equals(SleepyTime.ID)) {
			try {
				DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data)); // handles incoming data
				EntityPlayer sender = (EntityPlayer) player;
//				Long time = data.readLong();
				String msg = data.readUTF();
				int type = data.readInt();
				
				switch(type)
				{
				case 0:
					LogHandler.log(Level.INFO, "Server received Message Type 0");
					PacketDispatcher.sendPacketToAllInDimension(packet, sender.dimension);
					LogHandler.log(Level.INFO, "SERVERPACKET SENT TO ALL PLAYERS");
					return;
				case 1:
					manager.addToSendQueue(packet);
					LogHandler.log(Level.INFO, "Server received Message Type 1");
					return;
				default:
					LogHandler.log(Level.INFO, "Server received Message Default Catcher");
				}

			} catch(Exception ex) {
				ex.printStackTrace();
				LogHandler.log(Level.SEVERE, "onPacketData on Server has failed!");
			}
		}
	}
	
	// SERVER PACKET METHODS
	private void updatePlayersAwayStatus()
	{
		
	}
}

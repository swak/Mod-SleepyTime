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

				PacketDispatcher.sendPacketToAllPlayers(packet);
				LogHandler.log(Level.INFO, "serverPacketHandler sent");
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}

package com.theswak.sleepytime.handlers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

import com.theswak.sleepytime.SleepyTime;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.INetworkManager;
import net.minecraft.src.Packet250CustomPayload;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

@SideOnly(Side.CLIENT)
public class ClientPacketHandler implements IPacketHandler
{
	public static HashMap<Integer, Integer> entityStatus = new HashMap();
	
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		if(packet.channel.equals(SleepyTime.ID)) {
			handleServerPacket(packet);
		}
	}
		
	private void handleServerPacket(Packet250CustomPayload packet)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		
		try {
			int color = data.readInt();
			String message = data.readUTF();
			
			LogHandler.log(Level.INFO, message);
			LogHandler.log(Level.INFO, "CLIENTPACKET RECEIVED");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

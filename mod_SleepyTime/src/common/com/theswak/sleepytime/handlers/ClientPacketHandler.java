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
		// if packet channel is mod packet
		if(packet.channel.equals(SleepyTime.ID)) { 
			DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
			
			try {
				String msg = data.readUTF();
				int type = data.readInt();
				
				LogHandler.log(Level.INFO, msg + " :: TYPE-" + type);
				

				switch(type)
				{
				case 0: // PACKET FROM SERVER TO ALL PLAYERS
					
					return;
				case 1:
					return;
				case 2:
					return;
				default:
					LogHandler.log(Level.WARNING, "CLIENTPACKET RECEIVED WITH NO TYPE");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
				LogHandler.log(Level.SEVERE, "handleServerPacket has had an issue!");
			}
		}
	}
		
	
	// CLIENT PACKET METHODS
//	private void handleServerPacket(Packet250CustomPayload packet) {}
}

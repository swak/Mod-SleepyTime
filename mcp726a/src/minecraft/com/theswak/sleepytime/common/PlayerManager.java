package com.theswak.sleepytime.common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public class PlayerManager
{
	public List<PlayerInfo> Players;

	private static final PlayerManager instance = new PlayerManager();
	public static final PlayerManager getInstance() { return instance; }

	private PlayerManager() { Players = new ArrayList(); }

	public PlayerInfo getPlayerInfoFromPlayer(EntityPlayer player)
	{
		for(PlayerInfo pi : Players)
		{
			if(pi.Name.equals(player.username))
				return pi;
		}
		return null;
	}
}

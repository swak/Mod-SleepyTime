package com.theswak.sleepytime.common;

import net.minecraft.network.INetworkManager;

public class PlayerInfo
{
	public String Name; // user name of player
	public boolean isAwayFromKeyboard; // is player afk?
	public boolean isSleeping; // is player sleeping?

	public INetworkManager networkManager;

	public PlayerInfo(String name, INetworkManager nm)
	{
		Name = name;
		networkManager = nm;
	}
	
	public void isAwayFromKeyboard(boolean state)
	{
		isAwayFromKeyboard = state;
	}
	
	public void isSleeping(boolean state)
	{
		isSleeping = state;
	}
}

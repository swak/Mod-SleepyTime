package com.theswak.sleepytime.handlers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.theswak.sleepytime.SleepyTime;

import cpw.mods.fml.common.FMLLog;

public class LogHandler
{
	private static Logger sleepytimeLogger = Logger.getLogger(SleepyTime.ID);
	
	public static void init()
	{
		sleepytimeLogger.setParent(FMLLog.getLogger());
	}

	public static void log(Level level, String message)
	{
		sleepytimeLogger.log(level, message);
	}
}


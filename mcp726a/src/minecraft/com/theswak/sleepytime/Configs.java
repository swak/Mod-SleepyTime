package com.theswak.sleepytime;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.logging.Level;

import com.theswak.sleepytime.common.LogHandler;

import net.minecraftforge.common.Configuration;

public class Configs
{
	@Retention(RetentionPolicy.RUNTIME)
	private static @interface CfgId { public boolean block() default false; }

	@Retention(RetentionPolicy.RUNTIME)
	private static @interface CfgBool {}

	/* CONFIGURATIONFILE IDS FOR FORGEBASE */
		//public static @CfgId int itemId = 12000; //example use
		//public static @CfgId(block=true) int blockId = 350; //example use
		//public static @CfgBool boolean booleanConfig = false; //example use
	
	// MOD GENERAL OPTIONS //
	public static @CfgBool boolean onlyOpsSeeStatusUpdates = false;
	public static @CfgBool boolean autoIdleStatus = true;

	/* LOAD CONFIGURATION FILE */
	public static void load(Configuration config)
	{
		try {
			config.load();
			Field[] fields = Configs.class.getFields();
			for(Field field : fields) {
				CfgId annotation = field.getAnnotation(CfgId.class);
				if(annotation != null) {
					int id = field.getInt(null);
					if(annotation.block()){
						id = config.getBlock(field.getName(), id).getInt();
					}else{
						id = config.getItem(field.getName(), id).getInt();
					}
					field.setInt(null, id);
				} else {
					if(field.isAnnotationPresent(CfgBool.class)){
						boolean bool = field.getBoolean(null);
						bool = config.get(Configuration.CATEGORY_GENERAL,
								field.getName(), bool).getBoolean(bool);
						field.setBoolean(null, bool);
					}
				}
			}
		} catch(Exception e) {
			LogHandler.log(Level.WARNING, "could not create configuration file for some reason!");
		} finally {
			config.save();
			LogHandler.log(Level.INFO, "has successfully created/read configuration file");
		}
	}
}

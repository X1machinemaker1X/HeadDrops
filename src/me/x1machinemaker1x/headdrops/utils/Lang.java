package me.x1machinemaker1x.headdrops.utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

public enum Lang {
	
	TITLE("plugin-prefix", "&4[&7HeadDrops&4]: &e"),
	NOT_PLAYER("not-player", "&cYou must be a player to use this command!"),
	NO_PERMISSION("no-permission", "&cYou do not have permission!"),
	NOT_ONLINE("not-online", "&cThat player is not online!"),
	NOT_MOB("not-mob", "&cThat is not a valid mob!"),
	NOT_COMMAND("not-command", "&cThat is not a valid command!"),
	CONFIG_RELOAD("config-reloaded", "&aThe configuration has been reloaded!"),
	PLAYER_HEAD_RECEIVED("you-head-received", "&a%r got %p's head!"),
	MOB_HEAD_RECEIVED("mob-head-received", "&aYou got a %name"),
	HEADINFO("headinfo", "&aYou %state headinfo for %p!"),
	ERROR("error", "&4ERROR: %reason");
	
	private String path;
	private String def;
	private static YamlConfiguration LANG;
	
	/**
	 * Lang enum constructor
	 * @param path The config path
	 * @param start The default string
	 */
	private Lang(String path, String start) {
		this.path = path;
		this.def = start;
	}
	
	/**
	 * Set the (@code YamlConfiguration) to use.
	 * @param config The config to set.
	 */
	public static void setFile(YamlConfiguration config) {
		LANG = config;
	}
	
	@Override
	public String toString() {
		if (this == TITLE)
			return ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path, def)) + " ";
		return ChatColor.translateAlternateColorCodes('&', LANG.getString(this.path, def));
	}
	
	/**
	 * Get the default value of the path
	 * @return The default value of the path.
	 */
	public String getDefault() {
		return this.def;
	}
	
	/**
	 * Get the path to the string
	 * @return The path to the string
	 */
	public String getPath() {
		return this.path;
	}
}

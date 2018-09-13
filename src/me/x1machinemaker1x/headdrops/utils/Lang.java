package me.x1machinemaker1x.headdrops.utils;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

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
	private String message;
	
	private Lang(String path, String def) {
		this.path = path;
		this.message = def;
	}
	
	public String path() {
		return this.path;
	}
	
	public String message() {
		return this.message;
	}
	
	@Override
	public String toString() {
		return ChatColor.translateAlternateColorCodes('&', this.message);
	}
	
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	private static File lfile;
	private static FileConfiguration lconfig;
	public static void setup(Plugin p) {
		lfile = new File(p.getDataFolder(), "lang.yml");
		if (!lfile.exists()) {
			try {
				p.getDataFolder().mkdir();
				lfile.createNewFile();
			} catch (Exception e) {
				p.getLogger().severe("Could not create lang.yml");
				return;
			}
		}
		lconfig = YamlConfiguration.loadConfiguration(lfile);
		for (Lang message : Lang.values()) {
			if (!lconfig.isSet(message.path()))
				lconfig.set(message.path(), message.message());
			else 
				if (!lconfig.getString(message.path()).equals(message.message()))
					message.setMessage(lconfig.getString(message.path()));
		}
		try {
			lconfig.save(lfile);
		} catch (Exception e) {
			p.getLogger().severe("Could not save lang.yml");
		}
	}
}

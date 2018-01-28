/*
 *  Copyright:
 *  2013 Darius Mewes
 */

package me.x1machinemaker1x.headdrops;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.x1machinemaker1x.headdrops.utils.CommandManager;
import me.x1machinemaker1x.headdrops.utils.JSONUtil;
import me.x1machinemaker1x.headdrops.utils.Lang;
import me.x1machinemaker1x.headdrops.utils.Metrics;
import me.x1machinemaker1x.headdrops.utils.Updater;
import me.x1machinemaker1x.headdrops.utils.Updater.UpdateType;

public class HeadDrops extends JavaPlugin implements Listener {

    public static final String PREFIX = ChatColor.GOLD + "(HeadDrops) " + ChatColor.RESET;
    private static final int PROJECT_ID = 47089;
    
    private YamlConfiguration LANG;
    private File LANG_FILE;
    
    private static Logger logger;
    private Metrics m;
    public static File dataFolder;
	private Updater updater;
	private boolean checkForUpdates;
	private boolean autoDownload;

    public void onEnable() {
        initConfig();
        Lang.setup(this);
        JSONUtil.setup(this);
        
        CommandManager cm = new CommandManager(this);
        cm.setup();

        getCommand("headdrops").setExecutor(cm);

        Bukkit.getPluginManager().registerEvents(new EventListener(this), this);

        dataFolder = getDataFolder();
        logger = Bukkit.getLogger();
        checkForUpdates = this.getConfig().getBoolean("check-for-updates");
        autoDownload = this.getConfig().getBoolean("auto-download-updates");

        try {
            m = new Metrics(this);
            m.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (checkForUpdates) {
        	updater = new Updater(this, PROJECT_ID, getFile(), (autoDownload) ? UpdateType.DEFAULT : UpdateType.NO_DOWNLOAD, true);
	        switch (updater.getResult()) {
			case SUCCESS:
				logger.info("The newest version of DecraftingTable has been successfully downloaded!");
				break;
			case DISABLED:
				logger.info("Automatic updating for DecraftingTable has been disabled by a server administrator!");
				break;
			case FAIL_APIKEY:
				logger.severe("The API key for DecraftingTable has been improperly setup!");
				break;
			case FAIL_BADID:
				logger.severe("The project ID provided by the plugin is invalid and does not exist on dev.bukkit.org!");
				break;
			case FAIL_DBO:
				logger.severe("For some reason, the plugin was unable to contact dev.bukkit.org!");
				break;
			case FAIL_DOWNLOAD:
				logger.severe("A new version of DecraftingTable was found but the plugin was unable to download the new version!");
				break;
			case FAIL_NOVERSION:
				logger.severe("The file found of dev.bukkit.org did not contain a recognizable version!");
				break;
			case NO_UPDATE:
				logger.info("No update was found and nothing was downloaded!");
				break;
			case UPDATE_AVAILABLE:
				logger.info("An update was found but nothing was downloaded becuase updates are disabled in the config.yml file!");
				logger.info("You can download the new update here: " + updater.getLatestFileLink());
				break;
			default:
				logger.warning("This should never happen :)");
				break; 
			}
        }
        else {
        	logger.info("Version checking and automatic downloads are disabled in the config!");
        }
    }

    public void reload() {
        this.reloadConfig();
    }

    private void initConfig() {

        String[] parameter = {
                "dropBlank",
                "permissionCheckMob",
                "permissionCheckPlayer",
                "check-for-updates",
                "auto-download-updates",
                "chance.bat",
                "chance.blaze",
                "chance.cave_spider",
                "chance.chicken",
                "chance.cow",
                "chance.creeper",
                "chance.elder_guardian",
                "chance.enderman",
                "chance.endermite",
                "chance.evoker",
                "chance.ender_dragon",
                "chance.ghast",
                "chance.guardian",
                "chance.husk",
                "chance.iron_golem",
                "chance.llama",
                "chance.magma_cube",
                "chance.mushroom_cow",
                "chance.ocelot",
                "chance.parrot",
                "chance.pig",
                "chance.pig_zombie",
                "chance.polar_bear",
                "chance.rabbit",
                "chance.sheep",
                "chance.skeleton",
                "chance.shulker",
                "chance.silverfish",
                "chance.slime",
                "chance.spider",
                "chance.squid",
                "chance.stray",
                "chance.vex",
                "chance.villager",
                "chance.vindicator",
                "chance.witch",
                "chance.wither",
                "chance.wither_skeleton",
                "chance.wolf",
                "chance.player",
                "chance.zombie",
                "chance.zombie_villager"
        };

        Object[] defaultValue = {
                false,
                false,
                false,
                true,
                true,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100,
                100
        };

        for (int i = 0; i < parameter.length; i++) {
            getConfig().addDefault(parameter[i], defaultValue[i]);
        }
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    
    public YamlConfiguration getLang() {
    	return this.LANG;
    }
    
    public File getLangFile() {
    	return this.LANG_FILE;
    }

}

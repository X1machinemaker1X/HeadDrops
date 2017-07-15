/*
 *  Copyright:
 *  2013 Darius Mewes
 */

package me.x1machinemaker1x.headdrops.cmds;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import me.x1machinemaker1x.headdrops.utils.Lang;

public final class reload extends SubCommand {
	
	private Plugin plugin;
	
	public reload(Plugin p) {
		this.plugin = p;
	}

    public void onCommand(CommandSender cs, String[] args) {
    	plugin.reloadConfig();
    	cs.sendMessage(Lang.TITLE.toString() + Lang.CONFIG_RELOAD.toString());
    }
    
    public String name() {
    	return "reload";
    }
    
    public String info() {
    	return "Relaods the configuration";
    }
    
    public String usage() {
    	return "/hd reload";
    }
    
    public String permission() {
    	return "headdrops.reload";
    }
    
    public boolean consoleUse() {
    	return true;
    }
    
    public String[] aliases() {
    	return new String[] { "r", "re" };
    }
    
    public List<Integer> possArgs() {
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(0);
    	return list;
    }

}

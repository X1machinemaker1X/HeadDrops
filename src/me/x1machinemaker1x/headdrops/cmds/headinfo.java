/*
 *  Copyright:
 *  2013 Darius Mewes
 */

package me.x1machinemaker1x.headdrops.cmds;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.x1machinemaker1x.headdrops.utils.Lang;

public class headinfo extends SubCommand {

    private static List<String> active = new ArrayList<String>();

	public void onCommand(CommandSender cs, String[] args) {
    	Player p = (Player) cs;
    	Player target = null;
        if (args.length == 1) {
        	if (!p.hasPermission("headdrops.info.other")) {
        		p.sendMessage(Lang.TITLE.toString() + Lang.NO_PERMISSION.toString());
        		return;
        	}
            target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                p.sendMessage(Lang.TITLE.toString() + Lang.NOT_ONLINE.toString());
                return;
            }
            
        }
        else {
        	target = p;
        }

        if (active.contains(target.getName())) {
            active.remove(target.getName());
            p.sendMessage(Lang.TITLE.toString() + Lang.HEADINFO.toString().replace("%state", "disabled").replace("%p", (target.getUniqueId().equals(p.getUniqueId())) ? p.getName() : target.getName()));
        } else {
            active.add(target.getName());
            p.sendMessage(Lang.TITLE.toString() + Lang.HEADINFO.toString().replace("%state", "enabled").replace("%p", (target.getUniqueId().equals(p.getUniqueId())) ? p.getName() : target.getName()));
        }
    }
    
    public String name() {
    	return "info";
    }
    
    public String info() {
    	return "Toggles showing info for clicked heads";
    }
    
    public String usage() {
    	return "/hd info [player]";
    }
    
    public String permission() {
    	return "headdrops.info";
    }
    
    public boolean consoleUse() {
    	return false;
    }
    
    public String[] aliases() {
    	return new String[] { "i", "ifo" };
    }
    
    public List<Integer> possArgs() {
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(0);
    	list.add(1);
    	return list;
    }

    public static boolean isActive(Player p) {
        return active.contains(p.getName());
    }

}

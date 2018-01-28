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

import me.x1machinemaker1x.headdrops.utils.CSkull;
import me.x1machinemaker1x.headdrops.utils.Lang;

public final class head extends SubCommand {

    public void onCommand(CommandSender cs, String[] args) {
        if (args.length == 1) {
            if (!(cs instanceof Player)) {
            	cs.sendMessage(Lang.TITLE.toString() + Lang.NOT_PLAYER.toString());
            	return;
            }
            final Player p = (Player) cs;
            p.getInventory().addItem(CSkull.getPlayerSkull(args[0]));
            p.sendMessage(Lang.TITLE.toString() + Lang.PLAYER_HEAD_RECEIVED.toString().replace("%r", "You").replace("%p", args[0]));

        } 
        else if (args.length == 2) {
        	if (!cs.hasPermission("headdrop.head.other")) {
        		cs.sendMessage(Lang.TITLE.toString() + Lang.NO_PERMISSION.toString());
        		return;
        	}
			final Player target = Bukkit.getPlayer(args[0]);
            if (target == null) {
                cs.sendMessage(Lang.TITLE.toString() + Lang.NOT_ONLINE.toString());
            } 
            else {
                target.getInventory().addItem(CSkull.getPlayerSkull(args[1]));
                cs.sendMessage(Lang.TITLE.toString() + Lang.PLAYER_HEAD_RECEIVED.toString().replace("%r", target.getName()).replace("%p", args[1]));
            }
        }
    }
    
    public String name() {
    	return "head";
    }
    
    public String info() {
    	return "Gives you or a player a player's head";
    }
    
    public String usage() {
    	return "/hd head [player] <head>";
    }
    
    public String permission() {
    	return "headdrops.head";
    }
    
    public boolean consoleUse() {
    	return true;
    }
    
    public String[] aliases() {
    	return new String[] { "h", "hd" };
    }
    
    public List<Integer> possArgs() {
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	return list;
    }

}

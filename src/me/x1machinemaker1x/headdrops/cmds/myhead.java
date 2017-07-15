/*
 *  Copyright:
 *  2013 Darius Mewes
 */

package me.x1machinemaker1x.headdrops.cmds;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.x1machinemaker1x.headdrops.utils.CSkull;
import me.x1machinemaker1x.headdrops.utils.Lang;

public final class myhead extends SubCommand {

    public void onCommand(CommandSender cs, String[] args) {
        final Player p = (Player) cs;
        p.getInventory().addItem(CSkull.getPlayerSkull(p.getName()));
        p.sendMessage(Lang.TITLE.toString() + Lang.PLAYER_HEAD_RECEIVED.toString().replace("%r", "You").replace("%p", "your"));
    }
    
    public String name() {
    	return "myhead";
    }
    
    public String info() {
    	return "Gives you your own head";
    }
    
    public String usage() {
    	return "/hd myhead";
    }
    
    public String permission() {
    	return "headdrops.myhead";
    }
    
    public boolean consoleUse() {
    	return false;
    }
    
    public String[] aliases() {
    	return new String[] { "me", "m" };
    }
    
    public List<Integer> possArgs() {
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(0);
    	return list;
    }
}

/*
 *  Copyright:
 *  2013 Darius Mewes
 */

package me.x1machinemaker1x.headdrops.cmds;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.x1machinemaker1x.headdrops.CustomSkullType;
import me.x1machinemaker1x.headdrops.utils.Lang;

public final class mobhead extends SubCommand {

	public void onCommand(CommandSender cs, String[] args) {
		final Player p = (Player) cs;

		final String mob = args[0];
		if (mob.equalsIgnoreCase("skeleton"))
			p.getInventory().addItem(new ItemStack(Material.SKULL_ITEM, 1, (byte) 0));
		else if (mob.equalsIgnoreCase("witherskeleton"))
			p.getInventory().addItem(new ItemStack(Material.SKULL_ITEM, 1, (byte) 1));
		else if (mob.equalsIgnoreCase("zombie"))
			p.getInventory().addItem(new ItemStack(Material.SKULL_ITEM, 1, (byte) 2));
		else if (mob.equalsIgnoreCase("creeper"))
			p.getInventory().addItem(new ItemStack(Material.SKULL_ITEM, 1, (byte) 4));
		else if (mob.equalsIgnoreCase("dragon")) 
			p.getInventory().addItem(new ItemStack(Material.SKULL_ITEM, 1, (byte) 5));
		else {
			CustomSkullType cst = CustomSkullType.forGeneralEntityName(mob);
			if (cst == null) {
				p.sendMessage(Lang.TITLE.toString() + Lang.NOT_MOB.toString());
				return;
			} 
			else
				p.getInventory().addItem(cst.getSkull());
		}
		p.sendMessage(Lang.TITLE.toString() + Lang.MOB_HEAD_RECEIVED.toString().replace("%name", args[0] + " head!"));
	}
	
	public String name() {
		return "mobhead";
	}
	
	public String info() {
		return "Gives a mob head";
	}
	
	public String usage() {
		return "/hd mobhead <mobname>";
	}
	
	public String permission() {
		return "headdrops.mobhead";
	}
	
	public boolean consoleUse() {
		return false;
	}
	
	public String[] aliases() {
		return new String[] { "mob", "mh" };
	}
	
	public List<Integer> possArgs() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		return list;
	}
}

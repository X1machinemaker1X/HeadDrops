package me.x1machinemaker1x.headdrops.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import me.x1machinemaker1x.headdrops.cmds.SubCommand;
import me.x1machinemaker1x.headdrops.cmds.head;
import me.x1machinemaker1x.headdrops.cmds.reload;
import me.x1machinemaker1x.headdrops.cmds.headinfo;
import me.x1machinemaker1x.headdrops.cmds.mobhead;
import me.x1machinemaker1x.headdrops.cmds.myhead;

public class CommandManager implements CommandExecutor {
	
	private List<SubCommand> commands;
	private final Plugin plugin;
	
	public CommandManager(Plugin p) {
		this.commands = new ArrayList<SubCommand>();
		this.plugin = p;
	}

	public void setup() {
		commands.add(new head());
		commands.add(new reload(plugin));
		commands.add(new headinfo());
		commands.add(new mobhead());
		commands.add(new myhead());
	}

	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			for (SubCommand c : this.commands) {
				cs.sendMessage(Lang.TITLE.toString() + c.usage() + " (" + aliases(c) + ") - " + c.info());
			}
			return true;
		}
		SubCommand command = get(args[0]);
		if (command == null) {
			cs.sendMessage(Lang.TITLE.toString() + Lang.NOT_COMMAND.toString());
			return true;
		}
		if (!(cs instanceof Player) && !command.consoleUse()) {
			cs.sendMessage(Lang.TITLE.toString() + Lang.NOT_PLAYER.toString());
			return true;
		}
		if (!cs.hasPermission(command.permission())) {
			cs.sendMessage(Lang.TITLE.toString() + Lang.NO_PERMISSION.toString());
			return true;
		}
		List<String> a = new ArrayList<String>();
		a.addAll(Arrays.asList(args));
		a.remove(0);
		args = a.toArray(new String[a.size()]);
		if (!command.possArgs().contains(args.length)) {
			cs.sendMessage(Lang.TITLE.toString() + command.usage());
			return true;
		}
		try {
			command.onCommand(cs, args);
		} catch (Exception e) {
			cs.sendMessage(Lang.ERROR.toString().replace("%reason", "The command wasn't successfully registered!"));
			e.printStackTrace();
		}
		return true;
	}

	private String aliases(SubCommand cmd) {
		String fin = "";
		for (String a : cmd.aliases()) {
			fin += a + " | ";
		}
		return fin.substring(0, fin.lastIndexOf(" | "));
	}

	private SubCommand get(String name) {
		for (SubCommand c : commands) {
			if (c.name().equalsIgnoreCase(name))
				return c;
			for (String alias : c.aliases())
				if (name.equalsIgnoreCase(alias))
					return c;
		}
		return null;
	}
}

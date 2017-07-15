package me.x1machinemaker1x.headdrops.cmds;

import java.util.List;

import org.bukkit.command.CommandSender;

public abstract class SubCommand {
	public abstract void onCommand(CommandSender cs, String[] args);

	public abstract String name();

	public abstract String info();
	
	public abstract String usage();
	
	public abstract String permission();
	
	public abstract boolean consoleUse();

	public abstract String[] aliases();

	public abstract List<Integer> possArgs();

}

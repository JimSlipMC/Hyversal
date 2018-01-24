package me.manny.unity.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.manny.unity.Config;
import me.manny.unity.Unity;

public class MotdCommand implements CommandExecutor {

	public MotdCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		s.sendMessage(ChatColor.YELLOW + "You are now viewing the message of the day: ");
		for(String msg : Config.getInstance().getData().getStringList("Motd")) {
			s.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
		}
		return true;
	}
	
	public void c(CommandSender p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
	
}

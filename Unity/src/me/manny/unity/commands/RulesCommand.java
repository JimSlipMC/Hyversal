package me.manny.unity.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.manny.unity.Unity;

public class RulesCommand implements CommandExecutor {

	public RulesCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		for(String msg : Unity.getInstance().getConfig().getStringList("Commands.Rules")) {
			c(s, msg.replaceAll("%player%", s.getName()));
		}
		return true;
	}
	
	public void c(CommandSender p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
	
}
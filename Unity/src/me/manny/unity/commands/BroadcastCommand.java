package me.manny.unity.commands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.manny.unity.Unity;

public class BroadcastCommand implements CommandExecutor {

	public BroadcastCommand(Unity unity) { }

	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		if(!s.hasPermission("unity.commands." + cmd.getName())) {
			s.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
			return true;
		}
		if(args.length == 0) {
			s.sendMessage(ChatColor.RED + "Usage: /broadcast <Message>");
			return true;
		}
		String message = StringUtils.join(args, ' ');
		message = ChatColor.translateAlternateColorCodes('&', message);
		if(message.length() < 3) {
			s.sendMessage(ChatColor.YELLOW + "Your broadcast must be at least " + ChatColor.GOLD + "3 charactors" + ChatColor.YELLOW + " or above!");
			return true;
		}
		Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_RED + "Broadcast" + ChatColor.DARK_GRAY + "] " + ChatColor.WHITE + message);
		return true;
	}

}

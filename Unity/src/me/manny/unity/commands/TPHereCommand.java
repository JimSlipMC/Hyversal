package me.manny.unity.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.manny.unity.Unity;


public class TPHereCommand implements CommandExecutor {

	public TPHereCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String l, String[] args) {
		if(!s.hasPermission("unity.commands." + cmd.getName())) {
			s.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
			return true;
		}
		if(args.length == 0) {
			s.sendMessage(ChatColor.RED + "Usage: /tp <Player> [Player]");
			return true;
		} 
		Player target = Bukkit.getPlayer(args[0]);

			if(target == null) {
				s.sendMessage(ChatColor.RED + "The player '" + args[0] + "' is not found!");
				return true;
			}
			s.sendMessage(ChatColor.WHITE + target.getName() + ChatColor.YELLOW + " has been teleported to " + ChatColor.WHITE + s.getName() + ChatColor.YELLOW + ".");
			target.teleport((Player)s);
		
		return true;
	}

}

package me.manny.unity.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.manny.unity.Unity;

public class GamemodeCommand implements CommandExecutor {

	public GamemodeCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		if(!s.hasPermission("unity.commands." + cmd.getName())) {
			s.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
			return true;
		}
		if(args.length == 0) {
			c(s, "&cUsage: /gamemode <Gamemode> [Player]");
		} else if(args.length == 1) {
			if(args[0].startsWith("c")) {
				c(s, "&eYour gamemode has been set to &fCreative&e.");
				((Player)s).setGameMode(GameMode.CREATIVE);
			} else if(args[0].startsWith("s")) {
				c(s, "&eYour gamemode has been set to &fSurvival&e.");
				((Player)s).setGameMode(GameMode.SURVIVAL);
			} else if(args[0].startsWith("a")) {
				c(s, "&eYour gamemode has been set to &fAdventure&e.");
				((Player)s).setGameMode(GameMode.ADVENTURE);
			}
		} else if(args.length == 2) {
			Player t = Bukkit.getPlayerExact(args[0]);
			if(t == null) {
				s.sendMessage(ChatColor.RED + "The player '" + args[1] + "' is not found!");
				return true;
			}
			if(args[0].startsWith("c")) {
				c(t, "&eYour gamemode has been set to &fCreative&e.");
				((Player)t).setGameMode(GameMode.CREATIVE);
				c(s, "&eYou have set &f" + t.getName() + "&e gamemode has been set to &dCreative&e.");
				Bukkit.broadcast(ChatColor.WHITE + s.getName() + ChatColor.YELLOW + " has given " + ChatColor.WHITE + t.getName() + ChatColor.YELLOW + " the gamemode &fCreative&e.", "unity.commands." + cmd.getName() + ".admin");
			} else if(args[0].startsWith("s")) {
				c(t, "&eYour gamemode has been set to &fSurvival&e.");
				c(s, "&eYou have set &f" + t.getName() + "&e gamemode has been set to &dSurvival&e.");
				((Player)t).setGameMode(GameMode.SURVIVAL);
				Bukkit.broadcast(ChatColor.WHITE + s.getName() + ChatColor.YELLOW + " has given " + ChatColor.WHITE + t.getName() + ChatColor.YELLOW + " the gamemode &fSurvival&e.", "unity.commands." + cmd.getName() + ".admin");
			} else if(args[0].startsWith("a")) {
				c(t, "&eYour gamemode has been set to &fAdventure&e.");
				c(s, "&eYou have set &f" + t.getName() + "&e gamemode has been set to &dAdventure&e.");
				((Player)t).setGameMode(GameMode.ADVENTURE);
				Bukkit.broadcast(ChatColor.WHITE + s.getName() + ChatColor.YELLOW + " has given " + ChatColor.WHITE + t.getName() + ChatColor.YELLOW + " the gamemode &fAdventure&e.", "unity.commands." + cmd.getName() + ".admin");
			}
		} else {
			c(s, "&cUsage: /gamemode <Gamemode> [Player]");
		}
		return true;
	}
	
	public void c(CommandSender p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
}

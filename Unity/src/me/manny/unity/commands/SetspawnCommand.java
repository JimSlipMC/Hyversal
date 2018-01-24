package me.manny.unity.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.manny.unity.Config;
import me.manny.unity.Unity;

public class SetspawnCommand implements CommandExecutor {
	
	public SetspawnCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
        Player p = (Player) s;               
		if(!s.hasPermission("unity.commands." + cmd.getName())) {
			s.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
			return true;
		}
		Config.getInstance().getData().set("spawn.world", p.getLocation().getWorld().getName());
		Config.getInstance().getData().set("spawn.x", p.getLocation().getX());
		Config.getInstance().getData().set("spawn.y", p.getLocation().getY());
		Config.getInstance().getData().set("spawn.z", p.getLocation().getZ());
		Config.getInstance().saveData();
		Bukkit.broadcast(ChatColor.WHITE + p.getName() + ChatColor.YELLOW + " has updated spawn's location to " + 
		ChatColor.LIGHT_PURPLE + p.getLocation().getBlockX() + ", " + p.getLocation().getBlockY() + ", " + p.getLocation().getBlockZ() + ChatColor.YELLOW + ".", "unity.commands." + cmd.getName());
		return true;
	}
}

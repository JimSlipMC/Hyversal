package me.manny.unity.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.manny.unity.Unity;

public class ClearCommand implements CommandExecutor {

	public ClearCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		if(!s.hasPermission("unity.commands." + cmd.getName())) {
			s.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
			return true;
		}
		if(args.length == 0) {
			s.sendMessage(ChatColor.YELLOW + "You have cleared your inventory.");
			((Player)s).getInventory().clear();
			((Player)s).getInventory().setBoots(null);
			((Player)s).getInventory().setChestplate(null);
			((Player)s).getInventory().setLeggings(null);
			((Player)s).getInventory().setHelmet(null);
			return true;
		}
		Player target = Bukkit.getPlayer(args[0]);
		if(target == null) {
			s.sendMessage(ChatColor.RED + "The player '" + args[0] + "' is not found!");
			return true;
		}
		target.getInventory().clear();
		target.getInventory().setBoots(null);
		target.getInventory().setChestplate(null);
		target.getInventory().setLeggings(null);
		target.getInventory().setHelmet(null);
		s.sendMessage(ChatColor.YELLOW + "You have cleared " + ChatColor.WHITE + target.getName() + ChatColor.YELLOW + "'s inventory.");
		return true;
	}

}

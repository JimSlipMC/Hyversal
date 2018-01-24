package me.manny.unity.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.manny.unity.Unity;

public class ListCommand implements CommandExecutor {

	public ListCommand(Unity unity) { }
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		List<String> online = new ArrayList<String>();
		List<String> donors = new ArrayList<String>();
		int players = (Bukkit.getOnlinePlayers().length);
		for(Player on : Bukkit.getOnlinePlayers()) {
		if(on.hasPermission("unity.staff")) {
				online.add(ChatColor.WHITE + on.getName() + ChatColor.YELLOW);
				if(online.contains(ChatColor.WHITE + "None!")) {
					online.remove(ChatColor.WHITE + "None!");
				}
				if(online.size() < 0) {
					online.add(ChatColor.WHITE + "None!");
				}
		}
				if(!online.contains(on) && on.hasPermission("unity.list.donors")) {
					donors.add(on.getName());	
				}
			
		}
	
		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "------------------------------------");
		sender.sendMessage(ChatColor.YELLOW + "Staff Online" + ChatColor.GOLD + " \u00bb " + ChatColor.WHITE + online.toString().replace("[", "").replace("]", "").replace(", ", ChatColor.YELLOW + ", "));
		sender.sendMessage(ChatColor.YELLOW + "Donators Online" + ChatColor.GOLD + " \u00bb " + ChatColor.WHITE + donors.size()); 
		sender.sendMessage(ChatColor.YELLOW + "There are currently " + ChatColor.GOLD + ChatColor.BOLD + players + ChatColor.YELLOW + " out of " + ChatColor.GOLD + ChatColor.BOLD + Bukkit.getMaxPlayers() + ChatColor.YELLOW + " players.");
		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + "------------------------------------");		return true; 
	}
}
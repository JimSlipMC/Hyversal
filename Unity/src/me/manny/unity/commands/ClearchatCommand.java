package me.manny.unity.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.manny.unity.Unity;
import net.md_5.bungee.api.ChatColor;

public class ClearchatCommand implements CommandExecutor {

	public ClearchatCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		if(!s.hasPermission("unity.commands." + cmd.getName())) {
			s.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
			return true;
		}
		for(Player p : Bukkit.getOnlinePlayers()) {
					if(!p.hasPermission("unity.commands." + cmd.getName())) {
						p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");
						p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");
						p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");
						p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");
						p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");
						p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");p.sendMessage(" ");
					}
		}
		Bukkit.broadcastMessage(ChatColor.YELLOW + "The player " + ChatColor.WHITE + s.getName() + ChatColor.YELLOW + " has cleared the chat.");
		return true;
	}
}

package me.manny.unity.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.manny.unity.Config;
import me.manny.unity.Unity;

public class CoordsCommand implements CommandExecutor {

	public CoordsCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		for(String msg : Config.getInstance().getConfig().getStringList("Coords")) {
			c(s, msg
					.replaceAll("%player%", s.getName())
					);
		}
		return true;
	}
	
	public void c(CommandSender p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
}

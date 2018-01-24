package me.manny.unity.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.manny.unity.Config;
import me.manny.unity.Unity;

public class HelpCommand implements CommandExecutor {

	public HelpCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		for(String msg : Config.getInstance().getConfig().getStringList("Help")) {
			c(s, msg
					.replaceAll("%player%", s.getName())
					.replaceAll("%sharpness%", "" + Unity.getInstance().getConfig().getInt("Enchants.Sharpness"))
					.replaceAll("%power%", "" + Unity.getInstance().getConfig().getInt("Enchants.Power"))
					.replaceAll("%protection%", "" + Unity.getInstance().getConfig().getInt("Enchants.Protection"))
					);
		}//Its configurable for u - help
		return true;
	}
	
	public void c(CommandSender p, String msg) {
		p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
	
}

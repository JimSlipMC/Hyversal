package me.manny.unity.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.manny.unity.Config;
import me.manny.unity.Unity;

public class StoneCommand implements CommandExecutor {

	public StoneCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		if(args.length == 0) {
			s.sendMessage(ChatColor.RED + "Usage: /stone <Cobble|Stone|All|Off|List>");
			return true;
		}
		Player p =(Player)s;
		if(args[0].equalsIgnoreCase("cobble")) {
			if(Config.getInstance().getData().getBoolean(p.getUniqueId() + ".Stone.Cobble") == true) {
				Config.getInstance().getData().set(p.getUniqueId() + ".Stone.Cobble", false);
				Config.getInstance().saveData();
			} else {
				Config.getInstance().getData().set(p.getUniqueId() + ".Stone.Cobble", true);
				Config.getInstance().saveData();	
			}
			p.sendMessage(ChatColor.YELLOW + "You are " + (Config.getInstance().getData().getBoolean(p.getUniqueId() + ".Stone.Cobble") ? ChatColor.GREEN + "now able" : ChatColor.RED + "no longer") + ChatColor.YELLOW + " able to pick up cobble.");
		} else if(args[0].equalsIgnoreCase("stone")) {
			if(Config.getInstance().getData().getBoolean(p.getUniqueId() + ".Stone.Stone") == true) {
				Config.getInstance().getData().set(p.getUniqueId() + ".Stone.Stone", false);
				Config.getInstance().saveData();
			} else {
				Config.getInstance().getData().set(p.getUniqueId() + ".Stone.Stone", true);
				Config.getInstance().saveData();	
			}
			p.sendMessage(ChatColor.YELLOW + "You are " + (Config.getInstance().getData().getBoolean(p.getUniqueId() + ".Stone.Cobble") ? ChatColor.GREEN + "now able" : ChatColor.RED + "no longer") + ChatColor.YELLOW + " able to pick up stone.");
		} else if(args[0].equalsIgnoreCase("all")) { 
			Config.getInstance().getData().set(p.getUniqueId() + ".Stone.Stone", true);
			Config.getInstance().getData().set(p.getUniqueId() + ".Stone.Cobble", true);
			Config.getInstance().saveData();
			p.sendMessage(ChatColor.YELLOW + "You can no longer pick up stone or cobble.");
		} else if(args[0].equalsIgnoreCase("off")) { 
			Config.getInstance().getData().set(p.getUniqueId() + ".Stone.Stone", false);
			Config.getInstance().getData().set(p.getUniqueId() + ".Stone.Cobble", false);
			Config.getInstance().saveData();
			p.sendMessage(ChatColor.YELLOW + "You can now pick up stone or cobble.");
		} else if(args[0].equalsIgnoreCase("list")) {
			p.sendMessage(ChatColor.GOLD.toString() + ChatColor.STRIKETHROUGH + "---------------------------------");
			p.sendMessage(ChatColor.YELLOW + "Block Disabled");
			p.sendMessage(ChatColor.YELLOW + " Stone" + ChatColor.GOLD + " \u00bb " + ChatColor.WHITE + (Config.getInstance().getData().getBoolean(p.getUniqueId() + ".Stone.Stone") ? "Yes" : "No"));
			p.sendMessage(ChatColor.YELLOW + " Cobble" + ChatColor.GOLD + " \u00bb " + ChatColor.WHITE + (Config.getInstance().getData().getBoolean(p.getUniqueId() + ".Stone.Cobble") ? "Yes" : "No"));
			p.sendMessage(ChatColor.GOLD.toString() + ChatColor.STRIKETHROUGH + "---------------------------------");
		} else {
			s.sendMessage(ChatColor.RED + "Manny can't find that sub-command, Logic?");
		}
		return true;
	}

}

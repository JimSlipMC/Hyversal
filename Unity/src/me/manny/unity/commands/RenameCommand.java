package me.manny.unity.commands;


import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import me.manny.unity.Unity;

public class RenameCommand implements CommandExecutor {

	public RenameCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
        Player p = (Player) s;               
		if(!s.hasPermission("unity.commands." + cmd.getName())) {
			s.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
			return true;
		}
		if(args.length < 0) {
			p.sendMessage(ChatColor.RED + "Usage: /rename <Name>");
		} else {
    		if(p.getItemInHand() == null || p.getItemInHand().getType() == Material.AIR) {
    			p.sendMessage(ChatColor.RED + "You must have an item in your hand to rename.");
    			return true;
    		}
    		String message = StringUtils.join(args, ' ');
    		message = ChatColor.translateAlternateColorCodes('&', message);
    		message = this.replaceLast(message, " ", "");
    		
    		
    		p.sendMessage(ChatColor.YELLOW + "You have renamed your sword from '" + ChatColor.WHITE + p.getItemInHand().getItemMeta().getDisplayName() + ChatColor.YELLOW + "' to '" + ChatColor.WHITE + message + ChatColor.YELLOW + "'");
    		ItemMeta rename1 = p.getItemInHand().getItemMeta();
    		rename1.setDisplayName(ChatColor.WHITE + "" + message);
     	    p.getItemInHand().setItemMeta(rename1);
		}
		return true;
	}
	
	private String replaceLast(String string, String from, String to) {
	     int lastIndex = string.lastIndexOf(from);
	     if (lastIndex < 0) return string;
	     String tail = string.substring(lastIndex).replaceFirst(from, to);
	     return string.substring(0, lastIndex) + tail;
	}
}

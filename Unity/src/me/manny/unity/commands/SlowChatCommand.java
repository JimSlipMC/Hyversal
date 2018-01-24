package me.manny.unity.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.google.common.primitives.Ints;

import me.manny.unity.Config;
import me.manny.unity.Unity;
import net.md_5.bungee.api.ChatColor;

public class SlowChatCommand implements CommandExecutor {

	public SlowChatCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		if(!s.hasPermission("unity.commands." + cmd.getName())) {
			s.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
			return true;
		}
		
		if(args.length == 0) {
			s.sendMessage(ChatColor.RED + "Usage: /slowchat <Off|Time>");
			return true;
		}
		if(args[0].equalsIgnoreCase("off")) {
			if(Config.getInstance().getData().getInt("Chat.Slowed") == 0) {
				s.sendMessage(ChatColor.RED + "Chat isn't currently slowed.");
				return true;
			}
			Config.getInstance().getData().set("Chat.Slowed", 0);
			Config.getInstance().saveData();
			Bukkit.broadcastMessage(ChatColor.WHITE + s.getName() + ChatColor.YELLOW + " has " + ChatColor.RED +  "disabled" + ChatColor.YELLOW + " slow chat.");
			return true;
		}
		if(Ints.tryParse(args[0]) == null) {
			s.sendMessage(ChatColor.RED + "The number '" + args[0] + "' is not a valid Integer!");
			return true;
		}
		if(Ints.tryParse(args[0]) < 1) {
			s.sendMessage(ChatColor.RED + "The number must be above one!");
			return true;
		}
		Config.getInstance().getData().set("Chat.Slowed", Ints.tryParse(args[0]));
		Bukkit.broadcastMessage(ChatColor.WHITE + s.getName() + ChatColor.YELLOW + " has delayed chat to " + ChatColor.LIGHT_PURPLE + args[0] + "s" + ChatColor.YELLOW + ".");
        return true;
	}


}

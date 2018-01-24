package me.manny.unity.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.manny.unity.Config;
import me.manny.unity.Unity;
import net.md_5.bungee.api.ChatColor;

public class ToggleChatCommand implements CommandExecutor {
	
	public ToggleChatCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		if(!s.hasPermission("unity.commands." + cmd.getName())) {
			s.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
			return true;
		}
		if(Config.getInstance().getData().getBoolean("Chat.Locked")) {
			Config.getInstance().getData().set("Chat.Locked", false);
			Config.getInstance().saveData();
		} else {
			Config.getInstance().getData().set("Chat.Locked", true);
			Config.getInstance().saveData();
		}
		Bukkit.broadcastMessage(ChatColor.WHITE + s.getName() + ChatColor.YELLOW + " has now " + (Config.getInstance().getData().getBoolean("Chat.Locked") ? ChatColor.RED + "disabled" : ChatColor.GREEN + "enabled") + ChatColor.YELLOW + " Global Chat.");
        return true;
	}


}

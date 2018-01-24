package me.manny.unity.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import de.myzelyam.api.vanish.VanishAPI;
import me.manny.unity.Unity;

public class PingCommand implements CommandExecutor {

	public PingCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String commandLabel, String[] args) {
		if(args.length == 0) {
			
			int ping = ((CraftPlayer)s).getHandle().ping;
			s.sendMessage(ChatColor.YELLOW + "Your latency to the server is " + ChatColor.GOLD + ChatColor.BOLD + ping + "ms" + ChatColor.YELLOW + ".");
			return true;
		}
		Player t = Bukkit.getPlayer(args[0]);
		if(t == null || VanishAPI.isInvisible(t)) {
			s.sendMessage(ChatColor.RED + "The player '" + args[0] + "' is not online!");
			return true;
		}
		int ping = ((CraftPlayer)t).getHandle().ping;
		s.sendMessage(ChatColor.WHITE + t.getName() + ChatColor.YELLOW + "'s latency to the server is " + ChatColor.GOLD + ChatColor.BOLD + ping + "ms" + ChatColor.YELLOW + ".");
        return true;
	}


}

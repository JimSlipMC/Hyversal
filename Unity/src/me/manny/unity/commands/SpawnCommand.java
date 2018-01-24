package me.manny.unity.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.myzelyam.api.vanish.VanishAPI;
import me.manny.unity.Config;
import me.manny.unity.Unity;

public class SpawnCommand implements CommandExecutor {

	public SpawnCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		if(!s.hasPermission("unity.commands." + cmd.getName())) {
			s.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
			return true;
		}
		
        World w = Bukkit.getServer().getWorld(Config.getInstance().getData().getString("spawn.world"));
        double x = Config.getInstance().getData().getDouble("spawn.x");
        double y = Config.getInstance().getData().getDouble("spawn.y");
        double z = Config.getInstance().getData().getDouble("spawn.z");
        
		if(args.length == 0) {
			Player p = (Player)s;
            p.teleport(new Location(w, x, y, z));
            p.sendMessage(ChatColor.YELLOW + "You have been teleported to spawn.");
		} else {
			Player t = Bukkit.getPlayer(args[0]);
			if(t == null || VanishAPI.isInvisible(t)) {
				s.sendMessage(org.bukkit.ChatColor.RED + "The player '" + args[0] + "' is not found!");
				return true;
			}
            t.teleport(new Location(w, x, y, z));
            s.sendMessage(ChatColor.WHITE + t.getName() + ChatColor.YELLOW + " has been teleported to spawn.");
		}
		return true;
	}

}

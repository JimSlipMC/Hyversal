package me.manny.unity.commands;

import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.myzelyam.api.vanish.VanishAPI;
import me.manny.unity.Unity;

public class PlaytimeCommand implements CommandExecutor {
	
	public PlaytimeCommand(Unity unity) { }
	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		if(args.length == 0) {
			long millis = ((Player)s).getStatistic(Statistic.PLAY_ONE_TICK);

			long minute = TimeUnit.MILLISECONDS.toMinutes(millis);
			long hour = TimeUnit.MILLISECONDS.toHours(millis);
			long day = TimeUnit.MILLISECONDS.toDays(millis);
			
			//cringe way to get time by manny 
			//ig everything is cringe in this utils
			String time = (day < 0 ? "" : day + " days, ") + (hour < 0 ? "" : hour + " hours, ") +  (minute < 0 ? "" : minute + " minutes, ");
			s.sendMessage(ChatColor.YELLOW + "Your playtime is currently " + ChatColor.LIGHT_PURPLE + time + ChatColor.YELLOW + ".");
			return true;
		} 
		Player t = Bukkit.getPlayer(args[0]);
		if(t == null || VanishAPI.isInvisible(t)) {
			s.sendMessage(ChatColor.RED + "The player '" + args[0] + "' is not online!");
			return true;
		}
		
		long millis = ((Player)s).getStatistic(Statistic.PLAY_ONE_TICK);

		long minute = TimeUnit.MILLISECONDS.toMinutes(millis);
		long hour = TimeUnit.MILLISECONDS.toHours(millis);
		long day = TimeUnit.MILLISECONDS.toDays(millis);
		
		
		String time = (day < 0 ? "" : day + " days, ") + (hour < 0 ? "" : hour + " hours, ") +  (minute < 0 ? "" : minute + " minutes");
		s.sendMessage(ChatColor.WHITE + t.getName() + ChatColor.YELLOW + "'s player time is is currently " + ChatColor.LIGHT_PURPLE + time + ChatColor.YELLOW + ".");
		return true;
	}
}
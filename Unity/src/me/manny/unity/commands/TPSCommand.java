 package me.manny.unity.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.manny.unity.Unity;
import me.manny.unity.utils.Lag;

public class TPSCommand implements CommandExecutor {

	public TPSCommand(Unity unity) { }
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
	  {
	    double tps = Lag.getTPS();
	    double lag = Math.round((1.0D - tps / 20.0D) * 100.0D);
	    String check = "";
	    if(tps >= 18.0D) {
	    	check = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "||||||||||" + ChatColor.DARK_GRAY + "]";
	    } else if(tps >= 16) {
	    	check = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "|||||||||" + ChatColor.GRAY + "|" + ChatColor.DARK_GRAY + "]";
	    } else if(tps >= 14) {
	    	check = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "||||||||" + ChatColor.GRAY + "||" + ChatColor.DARK_GRAY + "]";
	    } else if(tps >= 12) {
	    	check = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "|||||||" + ChatColor.GRAY + "|||" + ChatColor.DARK_GRAY + "]";
	    } else if(tps >= 10) {
	    	check = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "||||||" + ChatColor.GRAY + "||||" + ChatColor.DARK_GRAY + "]";
	    } else if(tps >= 8) {
	    	check = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "|||||" + ChatColor.GRAY + "|||||" + ChatColor.DARK_GRAY + "]";
	    } else if(tps >= 6) {
	    	check = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "||||" + ChatColor.GRAY + "||||||" + ChatColor.DARK_GRAY + "]";
	    } else if(tps >= 4) {
	    	check = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "|||" + ChatColor.GRAY + "|||||||" + ChatColor.DARK_GRAY + "]";
	    } else if(tps >= 2) {
	    	check = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "||" + ChatColor.GRAY + "||||||||" + ChatColor.DARK_GRAY + "]";
	    } else if(tps >= 0) {
	    	check = ChatColor.DARK_GRAY + "[" + ChatColor.RED + "||||||||||" + ChatColor.DARK_GRAY + "]";
	    }
	    
	    ChatColor colour;
	      if (tps >= 17.0D) {
	    	  colour = ChatColor.GREEN;
	      
	      }
	      else if (tps >= 15.0D) {
	        colour = ChatColor.YELLOW;
	      } else {
	        colour = ChatColor.RED;
	      
	    }
	      String status1 = "";
	      if(tps >= 17.0D) {
	    	  status1 = ChatColor.GREEN + "Server performance is doing good.";
	      } else if(tps >= 13.0D) {
	    	  status1 = ChatColor.YELLOW + "Server performance is doing semi-good.";
	      } else {
	    	  status1 = ChatColor.RED + "Server performance TPS is low, Server will be lagging a bit!";
	      }
	      sender.sendMessage(ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "------------------------------------------------------");
	      sender.sendMessage(ChatColor.GOLD + "Manny TPS");
	      sender.sendMessage(ChatColor.YELLOW + " TPS" + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + colour + Math.round(tps * 100.0D) / 100.0D);
	      sender.sendMessage(ChatColor.YELLOW + " Check" + ChatColor.DARK_GRAY + ": " + ChatColor.WHITE + check);
	      sender.sendMessage(ChatColor.YELLOW + " Status" + ChatColor.DARK_GRAY + ": " + status1);
	      sender.sendMessage(ChatColor.YELLOW + "The server currently has " + ChatColor.GOLD + ChatColor.BOLD + Math.round(lag * 10000.0D) / 10000.0D + '%' + ChatColor.YELLOW + " server lag..");
	      sender.sendMessage(ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "------------------------------------------------------");
	      
	    return true;
	  
	}

}

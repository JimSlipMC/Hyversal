package me.manny.unity.commands;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import me.manny.unity.Unity;
import net.md_5.bungee.api.ChatColor;

public class FreezeCommand implements CommandExecutor, Listener {

	public static ArrayList<UUID> Frozen = new ArrayList<UUID>();

	public FreezeCommand(Unity unity) {

	}
		

	public FreezeCommand() {
	
	}


	public boolean onCommand(CommandSender s, Command cmd, String L, String[] args) {
		if(!s.hasPermission("unity.commands." + cmd.getName())) {
			s.sendMessage(ChatColor.RED + "You don't have permission to execute this command!");
			return true;
		}
		if(args.length == 0) {
			s.sendMessage(ChatColor.RED + "Usage: /freeze <Player>");
			return true;
		}
		Player target = Bukkit.getPlayerExact(args[0]);
		if(target == null) {
			s.sendMessage(ChatColor.RED + "The player '" + args[0] + "' is not found!");
			return true;
		}
		if(Frozen.contains(target.getUniqueId())) {
			Frozen.remove(target.getUniqueId());
			target.sendMessage(ChatColor.YELLOW + "You are no longer frozen, We apologies for any inconvenience we that we have done.");
			Bukkit.broadcast(ChatColor.YELLOW + "The player " + ChatColor.WHITE + target.getUniqueId() + ChatColor.YELLOW + " has been unfrozen by " + s.getName(), "unity.commands.frozen");
		} else {
			Frozen.add(target.getUniqueId());
			String x = "\u2588";
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(" ");
			target.sendMessage(ChatColor.WHITE + x + x + x + x + ChatColor.RED + x + ChatColor.WHITE + x + x + x + x );
			target.sendMessage(ChatColor.WHITE + x + x + x + ChatColor.RED + x + ChatColor.GOLD + x + ChatColor.RED + x + ChatColor.WHITE + x + x + x + ChatColor.RED + ChatColor.BOLD + " You are currently " + ChatColor.UNDERLINE + "Frozen" + ChatColor.RED + ChatColor.BOLD + "!");
			target.sendMessage(ChatColor.WHITE  + x + x + ChatColor.RED + x + ChatColor.GOLD + x + ChatColor.BLACK + x + ChatColor.GOLD + x + ChatColor.RED + x + ChatColor.WHITE + x + x + " " + ChatColor.GRAY + "You have 3 minutes to join teamspeak!");
			target.sendMessage(ChatColor.WHITE + x + x + ChatColor.RED + x + ChatColor.GOLD + x + ChatColor.BLACK + x + ChatColor.GOLD + x + ChatColor.RED + x + ChatColor.WHITE + x + x);
			target.sendMessage(ChatColor.WHITE + x + ChatColor.RED + x + ChatColor.GOLD + x + x + ChatColor.BLACK + x + ChatColor.GOLD + x + x + ChatColor.RED + x + ChatColor.WHITE + x + ChatColor.RED + " Teamspeak" + ChatColor.GOLD + ": " + ChatColor.WHITE + "ts.unitymc.us");
			target.sendMessage(ChatColor.WHITE + x + ChatColor.RED + x + ChatColor.GOLD + x + x +  x + x + x + ChatColor.RED + x + ChatColor.WHITE + x + " " + ChatColor.RED + "Refusal to cooperate will result in a ban!" + ChatColor.GRAY + " (Manny)");
			target.sendMessage(ChatColor.RED + x + ChatColor.GOLD + x + x + x + ChatColor.BLACK + x + ChatColor.GOLD + x + x + x + ChatColor.RED + x);
			target.sendMessage(ChatColor.RED + x + x + x + x + x + x + x + x + x);
			Bukkit.broadcast(ChatColor.YELLOW + "The player " + ChatColor.WHITE + target.getName() + ChatColor.YELLOW + " has been frozen by " + s.getName(), "unity.commands.frozen");
		}
		return true;
	}
	
	@EventHandler
	public void Move(PlayerQuitEvent e) {
		if(Frozen.contains(e.getPlayer().getUniqueId())) {
			Bukkit.broadcast(ChatColor.YELLOW + "Player " + e.getPlayer().getName() + ChatColor.YELLOW + " has " + ChatColor.RED + ChatColor.BOLD + "QUIT" + ChatColor.YELLOW + " whilst Frozen!", "unity.staff");
		}
	}
	@EventHandler
	public void Move(PlayerMoveEvent e) {
		if(Frozen.contains(e.getPlayer().getUniqueId())) {
			  if ((e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockZ() != e.getTo().getBlockZ())) {
				  e.setTo(e.getFrom());
			  }
		}
	}
	
	@EventHandler
	public void Teleport(PlayerTeleportEvent e) {
		if(Frozen.contains(e.getPlayer().getUniqueId())) {
			  if ((e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockZ() != e.getTo().getBlockZ())) {
				  if(e.getCause() == TeleportCause.ENDER_PEARL) {
					  e.getPlayer().sendMessage(ChatColor.YELLOW + "You are unable to throw enderpearls whilst frozen!");
					  e.setTo(e.getFrom());
				  }
			  }
		}
	}
	
	@EventHandler
	public void Break(BlockBreakEvent e) {
		if(Frozen.contains(e.getPlayer().getUniqueId())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.YELLOW + "You are unable to break blocks whilst frozen!");
		}
	}
	
	@EventHandler
	public void Place(BlockPlaceEvent e) {
		if(Frozen.contains(e.getPlayer().getUniqueId())) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(ChatColor.YELLOW + "You are unable to place blocks whilst frozen!");
		}
	}
	@EventHandler
	public void onEntity(EntityDamageEvent e) {
			if(e.getEntity() instanceof Player) {
				if(Frozen.contains(((Player)e.getEntity()).getUniqueId())) {
				e.setCancelled(true);
			}
		}
	}
    @EventHandler
    public void onCommandPreprocess(final PlayerCommandPreprocessEvent e) {
    	if(Frozen.contains(e.getPlayer().getUniqueId())) {   
    	final String[] fullCommand = e.getMessage().split(" ");
            final String cmd = fullCommand[0].substring(1);
            if ((cmd.equalsIgnoreCase("teams") || cmd.equalsIgnoreCase("t") || cmd.equalsIgnoreCase("c") || cmd.equalsIgnoreCase("clans") ||cmd.equalsIgnoreCase("f") || cmd.toLowerCase().startsWith("faction") || cmd.toLowerCase().startsWith("gang") || cmd.toLowerCase().startsWith("g") || cmd.toLowerCase().startsWith("crew") || cmd.toLowerCase().startsWith("c") || cmd.toLowerCase().startsWith("crews")) && fullCommand.length > 1 &&
            		fullCommand[1].equalsIgnoreCase("home") || fullCommand[1].equalsIgnoreCase("hq")) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.YELLOW + "You cannot execute " + ChatColor.RED + fullCommand[1] + ChatColor.YELLOW + ".");
                
            }//well not for tp but for major comands like /gamemode
        }
    
    }
    
}

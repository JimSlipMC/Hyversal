package me.manny.unity;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.manny.unity.commands.BroadcastCommand;
import me.manny.unity.commands.BroadcastRawCommand;
import me.manny.unity.commands.ClearCommand;
import me.manny.unity.commands.ClearchatCommand;
import me.manny.unity.commands.CoordsCommand;
import me.manny.unity.commands.FreezeCommand;
import me.manny.unity.commands.GMACommand;
import me.manny.unity.commands.GMCCommand;
import me.manny.unity.commands.GMSCommand;
import me.manny.unity.commands.GamemodeCommand;
import me.manny.unity.commands.HelpCommand;
import me.manny.unity.commands.ListCommand;
import me.manny.unity.commands.MotdCommand;
import me.manny.unity.commands.PingCommand;
import me.manny.unity.commands.PlaytimeCommand;
import me.manny.unity.commands.RenameCommand;
import me.manny.unity.commands.RulesCommand;
import me.manny.unity.commands.SetspawnCommand;
import me.manny.unity.commands.SlowChatCommand;
import me.manny.unity.commands.SpawnCommand;
import me.manny.unity.commands.StoneCommand;
import me.manny.unity.commands.TPCommand;
import me.manny.unity.commands.TPHereCommand;
import me.manny.unity.commands.TPSCommand;
import me.manny.unity.commands.ToggleChatCommand;
import me.manny.unity.listeners.ChatListener;
import me.manny.unity.listeners.MotdListener;
import me.manny.unity.listeners.VanishListener;
import me.manny.unity.utils.Lag;
import me.manny.unity.utils.cooldown.Cooldown;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Unity extends JavaPlugin {

	HashMap<Block,Integer> Hashmap = new HashMap<Block,Integer>();
	ArrayList<Block> ArrayList = new ArrayList<Block>();
	
	public static Unity instance;
	public void onEnable() {
		Config.getInstance().setup(this);
		saveConfig();
		reloadConfig();

	
		getCommand("lag").setExecutor(new TPSCommand(this));
		getCommand("bc").setExecutor(new BroadcastCommand(this));
		getCommand("bcraw").setExecutor(new BroadcastRawCommand(this));
		getCommand("cc").setExecutor(new ClearchatCommand(this));
		getCommand("clear").setExecutor(new ClearCommand(this));
		getCommand("coords").setExecutor(new CoordsCommand(this));
		getCommand("ss").setExecutor(new FreezeCommand(this));
		getCommand("gm").setExecutor(new GamemodeCommand(this));
		getCommand("help").setExecutor(new HelpCommand(this));
		getCommand("list").setExecutor(new ListCommand(this));
		getCommand("motd").setExecutor(new MotdCommand(this));
		getCommand("ping").setExecutor(new PingCommand(this));
		getCommand("playtime").setExecutor(new PlaytimeCommand(this));
		
		getCommand("rename").setExecutor(new RenameCommand(this));
		getCommand("rules").setExecutor(new RulesCommand(this));
		getCommand("setspawn").setExecutor(new SetspawnCommand(this));
		getCommand("slowchat").setExecutor(new SlowChatCommand(this));
		getCommand("spawn").setExecutor(new SpawnCommand(this));
		getCommand("tp").setExecutor(new TPCommand(this));
		getCommand("tphere").setExecutor(new TPHereCommand(this));
		getCommand("tc").setExecutor(new ToggleChatCommand(this));
		getCommand("gmc").setExecutor(new GMCCommand(this));
		getCommand("gma").setExecutor(new GMACommand(this));
		getCommand("gms").setExecutor(new GMSCommand(this));
		getCommand("stone").setExecutor(new StoneCommand(this));
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Lag(), 100L, 1L);
		getServer().getPluginManager().registerEvents(new FreezeCommand(), this);
		getServer().getPluginManager().registerEvents(new MotdListener(), this);
		getServer().getPluginManager().registerEvents(new ChatListener(), this);
		getServer().getPluginManager().registerEvents(new VanishListener(), this);
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				Cooldown.handleCooldowns();
			}
		}, 1L, 1L);
		
		new BukkitRunnable() {
			@Override
			public void run() {
				for (final Player p : Bukkit.getOnlinePlayers()) {
					if(FreezeCommand.Frozen.contains(p.getUniqueId())) {
						String x = "\u2588";
						p.sendMessage(" ");
						p.sendMessage(ChatColor.WHITE + x + x + x + x + ChatColor.RED + x + ChatColor.WHITE + x + x + x + x );
						p.sendMessage(ChatColor.WHITE + x + x + x + ChatColor.RED + x + ChatColor.GOLD + x + ChatColor.RED + x + ChatColor.WHITE + x + x + x + ChatColor.RED + ChatColor.BOLD + " You are currently " + ChatColor.UNDERLINE + "Frozen" + ChatColor.RED + ChatColor.BOLD + "!");
						p.sendMessage(ChatColor.WHITE  + x + x + ChatColor.RED + x + ChatColor.GOLD + x + ChatColor.BLACK + x + ChatColor.GOLD + x + ChatColor.RED + x + ChatColor.WHITE + x + x + " " + ChatColor.GRAY + "You have 3 minutes to join teamspeak!");
						p.sendMessage(ChatColor.WHITE + x + x + ChatColor.RED + x + ChatColor.GOLD + x + ChatColor.BLACK + x + ChatColor.GOLD + x + ChatColor.RED + x + ChatColor.WHITE + x + x);
						p.sendMessage(ChatColor.WHITE + x + ChatColor.RED + x + ChatColor.GOLD + x + x + ChatColor.BLACK + x + ChatColor.GOLD + x + x + ChatColor.RED + x + ChatColor.WHITE + x + ChatColor.RED + " Teamspeak" + ChatColor.GOLD + ": " + ChatColor.WHITE + "ts.unitymc.us");
						p.sendMessage(ChatColor.WHITE + x + ChatColor.RED + x + ChatColor.GOLD + x + x +  x + x + x + ChatColor.RED + x + ChatColor.WHITE + x + " " + ChatColor.RED + "Refusal to cooperate will result in a ban!");
						p.sendMessage(ChatColor.RED + x + ChatColor.GOLD + x + x + x + ChatColor.BLACK + x + ChatColor.GOLD + x + x + x + ChatColor.RED + x);
						p.sendMessage(ChatColor.RED + x + x + x + x + x + x + x + x + x);
					}	

				}
			}
		}.runTaskTimerAsynchronously(this, 20L * 20, 20L * 20);
	}
	
	public void onDisable() {
	
	}
	
	public static Unity getInstance() {
		return instance;
	}
}

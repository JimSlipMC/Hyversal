package me.manny.unity.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.manny.unity.Config;

public class MotdListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		for(String msg : Config.getInstance().getData().getStringList("Motd")) {
			e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
		}
	}
}

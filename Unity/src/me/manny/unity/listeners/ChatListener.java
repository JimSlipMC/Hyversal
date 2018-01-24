package me.manny.unity.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.manny.unity.Config;
import me.manny.unity.utils.cooldown.Cooldown;
import net.md_5.bungee.api.ChatColor;

public class ChatListener implements Listener {

	
	@EventHandler(ignoreCancelled = true)
	public void onChat(AsyncPlayerChatEvent e) {
		if(Config.getInstance().getData().getBoolean("Chat.Locked")) {
			if(!e.getPlayer().hasPermission("unity.commands." + "tc")) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.YELLOW + "The chat is currently locked at the moment.");
			}
			return;
		} 
		if(Config.getInstance().getData().getInt("Chat.Slowed") > 0) {
			if(Cooldown.isCooling(e.getPlayer().getUniqueId(), "ChatSlowed")) {
				e.getPlayer().sendMessage(ChatColor.YELLOW + "The chat is currently slowed! You can talk again in " + ChatColor.LIGHT_PURPLE + Cooldown.getRemaining(e.getPlayer().getUniqueId(), "ChatSlowed") + "s" + ChatColor.YELLOW + ".");
				e.setCancelled(true);
				return;
			}
			if(!e.getPlayer().hasPermission("unity.commands." + "slowchat")) {
			Cooldown.add(e.getPlayer().getUniqueId(), "ChatSlowed", Config.getInstance().getData().getInt("Chat.Slowed"), System.currentTimeMillis());
			}
			}
	}
	
}
	
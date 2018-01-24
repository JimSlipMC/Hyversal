package me.manny.unity.listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

import me.manny.unity.Config;

public class VanishListener implements Listener {

	private HCF plugin;

	Short cooktime = (short)150;
	 
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.setGameMode(GameMode.SURVIVAL);
	}
	  @EventHandler
	    public void furnaceBurn(FurnaceBurnEvent event) {
	        Furnace furnace = (Furnace) event.getBlock().getState();
	        furnace.setCookTime(cooktime);
	    }
	 
	    @EventHandler
	    public void furnaceSmeltEvent(FurnaceSmeltEvent event) {
	        Furnace furnace = (Furnace) event.getBlock().getState();
	        furnace.setCookTime(cooktime);
	    }
	 
	    @EventHandler
	    public void onInventoryClick(InventoryClickEvent event) {
	        Block blocktype = event.getWhoClicked().getTargetBlock(null, 10); 
	 
	        if (blocktype.getType() == Material.FURNACE || blocktype.getType() == Material.BURNING_FURNACE) {
	            if ((event.getSlot() == 0 || event.getSlot() == 1) && event.getCursor().getType() != Material.AIR) {
	                Furnace furnace = (Furnace) blocktype.getState();
	                furnace.setCookTime(cooktime);
	            }
	        }
	    }
	    
	    @EventHandler
	    public void pickup(PlayerPickupItemEvent e) {
	    	if(e.getItem().getItemStack().getType() == Material.STONE) {
	    		if(Config.getInstance().getData().getBoolean(e.getPlayer().getUniqueId() + ".Stone.Stone") == true) {
	    			e.setCancelled(true);
	    		}
	    	} else if(e.getItem().getItemStack().getType() == Material.COBBLESTONE) {
	    		if(Config.getInstance().getData().getBoolean(e.getPlayer().getUniqueId() + ".Stone.Cobble") == true) {
	    			e.setCancelled(true);
	    		}
	    	}
	    }
}

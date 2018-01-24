package me.manny.unity;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class Config {

	static Config instance = new Config();
	
	public static Config getInstance() {
		return instance;
	}
	
	Plugin p;
	
	FileConfiguration config;
	File cfile;
	
	FileConfiguration data;
	File dfile;
	
	
	//Create files on load
	public void setup(Plugin p) {
		cfile = new File(p.getDataFolder(), "config.yml");
		config = p.getConfig();
		config.options().copyDefaults(true);
		saveConfig();
		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();
		}
		
		dfile = new File(p.getDataFolder(), "storage.yml");
		
		if (!dfile.exists()) {
			try {
				dfile.createNewFile();
			}
			catch (IOException e) {
				Bukkit.getServer().getLogger().severe(ChatColor.RED + "Unable to load Storage.yml, Maybe it is already loaded?");
			}
		}
		
		data = YamlConfiguration.loadConfiguration(dfile);
		

	}
	
	//Get files Section
	public FileConfiguration getData() {
		return data;
	}
	

	//Reload files Section
	public void reloadConfig() {
		config = YamlConfiguration.loadConfiguration(cfile);
	}
	
	public void reloadData() {
		data = YamlConfiguration.loadConfiguration(dfile);
	}

	public FileConfiguration getConfig() {
		return config;
	}
	//Saving files Section
	public void saveConfig() {
		try {
			config.save(cfile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
		}
	}
	
	public void saveData() {
		try {
			data.save(dfile);
		}
		catch (IOException e) {
			Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save storage.yml!");
		}
	}
	

	
}
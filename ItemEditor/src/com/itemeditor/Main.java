package com.itemeditor;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	public static Main getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		
		Bukkit.getServer().getConsoleSender().sendMessage("§e-------------------------------");
		Bukkit.getServer().getConsoleSender().sendMessage("§e----------- §aItem§cEditor §e-----------");
		Bukkit.getServer().getConsoleSender().sendMessage("§e-------------------------------");
		
		events();
		commands();
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
	
	private void events() {
		
	}
	
	private void commands() {
		getCommand("itemeditor").setExecutor(new Commands());
		getCommand("itemeditor").setTabCompleter(new Commands());
	}
	

}

package com.itemeditor.cmds;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.itemeditor.Commands;

public class SetName_Command {
	
	public void setName(Player player, Command cmd, String label, String[] args) {
		
		if(!player.hasPermission("itemeditor.setname")) {
			Commands.sendMessage(player, "§cYou are not permitted to do this.");
			return;
		}
		
		if (args.length == 0) {
			Commands.sendMessage(player, "§cYou must specify a name for the specific item.");
			return;
		}
		
		String str = "";
		
		for (int i = 0 ; i < args.length ; i++) {
			str += args[i] + " ";
		}
				
		String name = str.trim();
		ItemStack is = player.getItemInHand();
		
		if(is == null || is.getType() == Material.AIR) {
			Commands.sendMessage(player, "§cYou don't have any item in your hand.");
			return;
		}
		
		ItemMeta m = is.getItemMeta();
		m.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		is.setItemMeta(m);
		
		Commands.sendMessage(player, "§aThe item name has been changed to §r" + m.getDisplayName() + "§e...");
		
	}


}

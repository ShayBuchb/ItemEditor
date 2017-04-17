package com.itemeditor.cmds;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.itemeditor.Commands;

public class Reset_Command {
	
	public void reset(Player player, Command cmd, String label, String[] args) {
		if(!player.hasPermission("itemeditor.reset")) {
			Commands.sendMessage(player, "§cYou are not permitted to do this.");
			return;
		}
		
		ItemStack is = player.getItemInHand();
		
		if(is == null || is.getType() == Material.AIR) {
			Commands.sendMessage(player, "§cYou don't have any item in your hand.");
			return;
		}
		
		ItemMeta m = is.getItemMeta();
		m.setDisplayName(is.getType().toString().substring(0, 1).toUpperCase().toString() + is.getType().toString().substring(1).toLowerCase().replaceAll("_", " "));
		m.setLore(null);
		is.setItemMeta(m);
		
		Commands.sendMessage(player, "§aThe item details has been reset§e...");

		
	}

}

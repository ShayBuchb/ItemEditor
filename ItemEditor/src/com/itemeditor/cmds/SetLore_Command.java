package com.itemeditor.cmds;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.itemeditor.Commands;
import com.itemeditor.Main;

public class SetLore_Command {
	
	public void setLore(Player player, Command cmd, String label, String[] args) {
		if(!player.hasPermission("itemeditor.setlore")) {
			Commands.sendMessage(player, "§cYou are not permitted to do this.");
			return;
		}
		
		if (args.length == 0) {
			Commands.sendMessage(player, "§cYou must specify a lore for the specific item.");
			return;
		}
		
		String str = "";
		
		
		for (int i = 0 ; i < args.length ; i++) {
			str += args[i] + " ";
			
		}
		
		
		ItemStack is = player.getItemInHand();
		
		if(is == null || is.getType() == Material.AIR) {
			Commands.sendMessage(player, "§cYou don't have any item in your hand.");
			return;
		}
		
		String lore = str.trim().replaceAll("&", "§");
		String finallore = lore.replaceAll(";", "  §rNEWLINE  ");
				
		ItemMeta m = is.getItemMeta();
		m.setLore(Arrays.asList(lore.split(";")));
		is.setItemMeta(m);
		
		Commands.sendMessage(player, "§aThe item lore has been changed to §r" + finallore + "§e...");
	
	}
	
}


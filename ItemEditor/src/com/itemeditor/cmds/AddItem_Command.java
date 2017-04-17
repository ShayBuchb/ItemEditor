package com.itemeditor.cmds;

import java.util.Arrays;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.itemeditor.Commands;

public class AddItem_Command {
	
	public void addItem(Player player, Command cmd, String label, String[] args) {
		
		if(!player.hasPermission("itemeditor.additem")) {
			Commands.sendMessage(player, "§cYou are not permitted to do this.");
			return;
		}
		
		if(args.length == 0) {
			Commands.sendMessage(player, "§cCurrent usage: /itemeditor additem {ID} {OPTIONAL-NAME} {OPTIONAL-LORE}");
			return;
		}
		
		if(args.length == 1) {
			Material mat = Material.matchMaterial(args[0]);
			
			if(mat == null) {
				Commands.sendMessage(player, "§cCouldn't find any item with the id §e" + args[0] + "§c.");
				return;
			}
			
			ItemStack is = new ItemStack(mat);
			player.getInventory().addItem(is);
			Commands.sendMessage(player, "§aThe item has been added successfully to your inventory.");
			return;
		}
		
		Material mat = Material.matchMaterial(args[0]);
		
		if(mat == null) {
			Commands.sendMessage(player, "§cCouldn't find any item with the id §e" + args[0] + "§c.");
			return;
		}
		
		ItemStack is = new ItemStack(mat);
		
		String name = "";
		String lore = "";
		int num = 1;
		
		for(int i = 1 ; i < args.length ; i++) {
			if(args[i].contains(".,")) break;
			name += args[i] + " ";
			num++;
		}
		
		for(int i = num ; i < args.length ; i++) {
			lore += args[i] + " ";
		}
		
		ItemMeta m = is.getItemMeta();
		m.setDisplayName(ChatColor.translateAlternateColorCodes('&', name).replaceAll(".,", "").trim());
		m.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', lore).replaceAll("., ", "").split(";")));
		is.setItemMeta(m);
		player.getInventory().addItem(is);
		Commands.sendMessage(player, "§aThe item has been added successfully to your inventory.");
	}

}

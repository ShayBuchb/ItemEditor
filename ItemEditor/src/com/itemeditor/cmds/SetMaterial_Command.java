package com.itemeditor.cmds;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.itemeditor.Commands;

public class SetMaterial_Command {
	
	public void setMaterial(Player player, String[] args) {
		if(args.length == 0)
		{
			Commands.sendMessage(player, "§cCurrent Usage: §e/itemeditor setmaterial <mat>");
			return;
		}
		
		Material mat = Material.getMaterial(args[0]);
		
		if(mat == null)
		{
			Commands.sendMessage(player, "§cA material with the name §e" + args[0] + " §cdoesn't exist.");
			return;
		}
		
		ItemStack is = player.getItemInHand();
		
		if(is == null || is.getType() == Material.AIR)
		{
			Commands.sendMessage(player, "§cYou don't have any item in your hand so you can not change his type.");
			return;
		}
		
		is.setType(mat);
		Commands.sendMessage(player, "§aYou have changed your item material to: §e" + mat.toString() + "§a.");
		
	}

}

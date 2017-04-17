package com.itemeditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.itemeditor.cmds.AddItem_Command;
import com.itemeditor.cmds.Reset_Command;
import com.itemeditor.cmds.SetLore_Command;
import com.itemeditor.cmds.SetName_Command;

public class Commands implements CommandExecutor {
	
	private static String prefix = "§e[§aItem§cEditor§e]§r ";

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		if(!(arg0 instanceof Player)) {
			arg0.sendMessage("§cYou must be a player to use this command.");
			return true;
		}
		
		Player player = (Player) arg0;
		
		if(!player.hasPermission("itemeditor.help")) {
			sendMessage(player, "§cYou are not permitted to do this.");
			return false;
		}
		if (arg3.length == 0) {
			help(player);
			return false;
		}
		
		String label = arg3[0];
		List<String> list = new ArrayList<>(Arrays.asList(arg3));
		list.remove(0);
		String[] args = list.toArray(new String[list.size()]);
		
		if (StringUtils.equalsIgnoreCase(label, "setname", "sn", "setitemname")) {
			new SetName_Command().setName(player, arg1, arg2, args);
		} else if (StringUtils.equalsIgnoreCase(label, "setlore", "sl", "setitemlore")) {
			new SetLore_Command().setLore(player, arg1, arg2, args);
		} else if (StringUtils.equalsIgnoreCase(label, "reset", "r", "resetitem")) { 
			new Reset_Command().reset(player, arg1, arg2, args);
		} else if (StringUtils.equalsIgnoreCase(label, "add", "ai", "additem")) {
			new AddItem_Command().addItem(player, arg1, arg2, args);
		}
		  else {
			help(player);
		}
		
		return false;
	}

	private void help(Player player) {
		player.sendMessage("§7==== §aItem§cEditor §aHelp §7=====");
		sendCommand(player, "setname/sn/setitemname", "{NAME}");
		sendCommand(player, "setlore/sl/setitemlore", "{LORE}");
		sendCommand(player, "reset/r/resetitem", "");
		sendCommand(player, "add/ai/additem", "{ID} {OPTIONAL-NAME} {OPTIONAL-LORE}");
		
	}
	
	public static void sendMessage(Player player, String msg) {
		player.sendMessage(prefix + msg);
	}
	
	private void sendCommand(Player player, String sub, String usage) {
		String root = "/itemeditor";
		player.sendMessage("§e" + root + " §7" + sub + usage);
	}
	
	
	
}

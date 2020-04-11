package com.palmtreefever.Jeconomy.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.palmtreefever.Jeconomy.Main;
import com.palmtreefever.Jeconomy.utils.Get_Balance;

public class Balance extends Get_Balance implements CommandExecutor {
	
	public Balance(Main main) {
		super(main);
	}

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    //String player = sender.getName(); 
		Player requester = (Player) sender;
	    String senderUUID = Bukkit.getPlayer(sender.getName()).getUniqueId().toString(); 
	    if (cmd.getName().equalsIgnoreCase("balance")) {
			if (args.length == 0) { // balance
				getBalance(requester, senderUUID, requester.getName().toString());
				return true;
			} else if (args.length == 1) { // balance <player>
				OfflinePlayer target = Bukkit.getOfflinePlayer(args[0]);
				String targetUUID = Bukkit.getOfflinePlayer(target.getName()).getUniqueId().toString();
				getBalance(requester, targetUUID, target.getName().toString());
				return true;
			}
		}
		return false;
	}
}
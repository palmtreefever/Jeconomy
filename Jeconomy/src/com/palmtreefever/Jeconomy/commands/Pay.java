package com.palmtreefever.Jeconomy.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.palmtreefever.Jeconomy.Main;
import com.palmtreefever.Jeconomy.utils.Subtract_Balance;

public class Pay extends Subtract_Balance implements CommandExecutor {
	
	public Pay(Main main) {
		super(main);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if(!(sender instanceof Player)) {
  		  sender.sendMessage("In game command only!");
			return true;
		}
		if (!(args.length==2)) { // pay or /pay name
			sender.sendMessage("/pay <name> amount");
			return true;
		} else if (args.length == 2) { // pay <player> #
			OfflinePlayer reciever = Bukkit.getOfflinePlayer(args[0]);
			if (!reciever.isOnline()) {
				sender.sendMessage("Player must be online!");
				return true;
			} else {
				if(sender.getName().equals(reciever.getName())) {
					sender.sendMessage("You cannot pay yourself!");
					return true;
				}
				String recieverUUID = Bukkit.getPlayer(reciever.getName()).getUniqueId().toString();
				String senderUUID = Bukkit.getPlayer(sender.getName()).getUniqueId().toString();
				Player senderP = (Player) sender;
				float toSub;
				try {
					toSub = Float.parseFloat(args[1].replaceAll("[^0-9.]", "")); //they can do /pay palmtreefever -100LOL and itll pay palmtreefever 100 ;)
				} catch (NumberFormatException e) {
					sender.sendMessage("/pay <name> #");
					return true;
				}
				if(!canSubADMIN(senderP, senderUUID, sender.getName(), toSub)) { // check to see if they have enough money
					return true;
				}	
				subBalanceADMIN(senderP, senderUUID, sender.getName(), toSub);
				sender.sendMessage("You have sent " + reciever.getName() + " $" + toSub + "!");
				float toAdd = toSub;
				Player recieverO = Bukkit.getPlayer(reciever.getName());
				addBalanceADMIN2(recieverO, recieverUUID, reciever.getName(), toAdd);
				recieverO.sendMessage("You have recieved $" + toAdd + " from " + sender.getName() + "!");
				return true;
			}
		}
		return false;
	}
}
package com.palmtreefever.Jeconomy.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;
import com.palmtreefever.Jeconomy.Main;
import com.palmtreefever.Jeconomy.utils.Add_Balance;

public class Transfer extends Add_Balance implements CommandExecutor {
	
	public Transfer(Main main) {
		super(main);
	}
	
    Economy Essentialsecon = main.getEconomy();
    float balanceTransfer = 0;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if (cmd.getName().equalsIgnoreCase("transfer")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("In game command only!");
				return true;
			}
			Player player = (Player) sender;
		    String senderUUID = Bukkit.getPlayer(sender.getName()).getUniqueId().toString(); 
			if (args.length == 0) { // transfer
				if (!config.contains(senderUUID)) { // If they don't exist in our database, add them
					config.set(senderUUID, 0);
				}
					try {
						if (Essentialsecon.hasMore(player.getName().toString(), 0)) { // If their balance in Essential is more than 0
							balanceTransfer = (float) Essentialsecon.getMoney(player.getName().toString()); // Saves their Essential balance
							//Essentialsecon.resetBalance(player.getName().toString()); // Wipes their Essentials balance
							Essentialsecon.subtract(player.getName().toString(), balanceTransfer);
							addBalanceADMIN(player, senderUUID, player.getName(), balanceTransfer); // adds balance
							player.sendMessage("Successfully transfered your vault balance to the new economy!");
							return true;
						} else {
							player.sendMessage("Balance has already been transferred!");
							return true;
						}
					} catch (NoLoanPermittedException
							| UserDoesNotExistException e) {
						e.printStackTrace();
					}
			} else { // transfer something something etc.
				player.sendMessage("Do /transfer");
				return true;
			}
		}
		return false;
	}
} // Future small optimization; ! for the if, so the rest is only read if they have over $0 4/12
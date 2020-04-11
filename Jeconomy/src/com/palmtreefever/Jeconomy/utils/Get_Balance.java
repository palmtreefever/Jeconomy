package com.palmtreefever.Jeconomy.utils;

import org.bukkit.entity.Player;

import com.palmtreefever.Jeconomy.Main;

public class Get_Balance extends File_Handler {

	public Get_Balance(Main main) {
		super(main, "player_balances.yml");
	}
	
	public void getBalance(Player requester, String balancersUUID, String balancersName) { // get balance associated with someones UUID
		if(!config.contains(balancersUUID)) {
			requester.sendMessage("Player isn't in the database!");
			return;
		} else {
		int bal = config.getInt(balancersUUID);
		requester.sendMessage(balancersName + " balance is " + bal); 		
		return;
		}
	}
	
	public void getBalanceN(String playersUUID) { // get balance of sender from Nations
		// search yml file for UUID if doesnt exist return doesn't exist
		return;
	}

}
package com.palmtreefever.Jeconomy.utils;

import org.bukkit.entity.Player;

import com.palmtreefever.Jeconomy.Main;

public class Get_Balance extends File_Handler {

	public Get_Balance(Main main) {
		super(main, "player_balances.yml");
	}

	public void getBalance(Player requester, String balancersUUID, String balancersName) { // get balance associated with someones UUID
		if(!Main.Balances.containsKey(balancersUUID)) {
			requester.sendMessage("Player isn't in the database!");
			if(requester.isOnline() && requester.getUniqueId().toString().equals(balancersUUID)) {
				//System.out.print(Main.Balances.keySet());
				main.setup_entry.createEntry(balancersUUID);	
			}
			return;
		} else {
			float bal = Main.Balances.get(balancersUUID).balance;
			requester.sendMessage(balancersName + " balance is $" + bal);
			return;
		}
	}

	public void getBalanceN(String townName) { // get balance of sender from town
		// search seperate yml file for Town if doesnt exist return doesn't exist
		return;
	} 
	
	
	public float getBalanceT(Player requester, String balancersUUID, String balancersName) { // get balance associated with someones UUID
		if(!Main.Balances.containsKey(balancersUUID)) {
			requester.sendMessage("Player isn't in the database!");
			if(requester.isOnline() && requester.getUniqueId().toString().equals(balancersUUID)) {
				//System.out.print(Main.Balances.keySet());
				main.setup_entry.createEntry(balancersUUID);	
				float bal1 = Main.Balances.get(balancersUUID).balance;
				return bal1;
			}
			return 0;
		} else {
			float bal = Main.Balances.get(balancersUUID).balance;
			//requester.sendMessage(balancersName + " balance is $" + bal);
			return bal;
		}
	}
	
	

}
//so if they do /bal <player>
// and no balance say player isnt in database and dont create it UNTIL they join to avoid false player names that never join

/*
 * for loading in Towns balance into seperate hashmap maybe make the seperate hashmap in Towns
 * and have it just load the Towns name and its balance and call the hashmap from here?
 * 
 * 
 * 
 * 
 * 
 */
package com.palmtreefever.Jeconomy.utils;

import org.bukkit.entity.Player;

import com.palmtreefever.Jeconomy.Main;

public class Add_Balance extends File_Handler {

	public Add_Balance(Main main) {
		super(main, "player_balances.yml");
	}
	//Town balances stored in town data
	
	public void addBalanceADMIN(Player player, String playersUUID, String playersName, float balanceToAdd) { // add balance from server to a player
		Balances balance = Main.Balances.get(playersUUID);
		balance.balance = balance.balance + balanceToAdd;
		return;
	}
	//I think this ^ is all i need for players as id call subtract when needed and town has its own add balance
}
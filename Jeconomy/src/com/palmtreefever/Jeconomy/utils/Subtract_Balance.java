package com.palmtreefever.Jeconomy.utils;

import org.bukkit.entity.Player;

import com.palmtreefever.Jeconomy.Main;

public class Subtract_Balance extends File_Handler {

	public Subtract_Balance(Main main) {
		super(main, "player_balances.yml");
	} 
	//subtract from player
	public void subBalanceADMIN(Player player, String playersUUID, String playersName, float balanceToSub) { // sub balance from server to a player
		Balances balance = Main.Balances.get(playersUUID);
		balance.balance = balance.balance - balanceToSub;
		return;
	}
	//check if can subtract that amount from player
	public boolean canSubADMIN(Player player, String playersUUID, String playersName, float balanceToSub) { // sub balance from server to a player
		Balances balance = Main.Balances.get(playersUUID);
		if(balance.balance >= balanceToSub) {
			if(balanceToSub != 0) {
			return true;
			} else {
				player.sendMessage("You cannot send 0!");
				return false;
			}
		} else {
			player.sendMessage("You do not have enough money!");
			return false;
		}
	}
	//since im retarded and couldnt use the actual add balance class cause i already extended this class into Pay
	public void addBalanceADMIN2(Player player, String playersUUID, String playersName, float balanceToAdd) { // add balance from server to a player
		Balances balance = Main.Balances.get(playersUUID);
		balance.balance = balance.balance + balanceToAdd;
		return;
	}
}
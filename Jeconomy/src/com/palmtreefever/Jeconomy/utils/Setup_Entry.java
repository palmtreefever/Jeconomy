package com.palmtreefever.Jeconomy.utils;

import com.palmtreefever.Jeconomy.Main;

public class Setup_Entry {
	
	public static void createEntry(String newPlayerUUID) {
		Balances balance = new Balances(); //this is causing error w/o static probably because im making a new balance when one already exists
		Main.Balances.put(newPlayerUUID, balance);
		balance.playerUUID = newPlayerUUID;
		balance.balance = 5;
		return;
	}
}
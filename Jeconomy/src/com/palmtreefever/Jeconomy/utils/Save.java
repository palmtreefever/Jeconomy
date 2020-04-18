package com.palmtreefever.Jeconomy.utils;

import com.palmtreefever.Jeconomy.Main;

public class Save extends File_Handler {
	public Save(Main main) {
		super(main, "player_balances.yml");
	}
	
	public void saveB(Balances balance) {
		config.set(balance.playerUUID + ".uuid", balance.playerUUID);
		config.set(balance.playerUUID + ".balance", balance.balance);
		this.Save_File();
	}

	public void load() {
		System.out.println("Loaded Save Class for Jeconomy!");
		return;
	}
}
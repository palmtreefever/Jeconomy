package com.palmtreefever.Jeconomy.utils;

import com.palmtreefever.Jeconomy.Main;

public class Setup_Entry extends File_Handler {
	
	public Setup_Entry(Main main) {
		super(main, "player_balances.yml");
	}
	

	public void createEntry(String newPlayerUUID) {
		config.set(newPlayerUUID, 100);
		return;
	}
}
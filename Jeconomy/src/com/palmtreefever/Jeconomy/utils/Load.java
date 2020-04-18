package com.palmtreefever.Jeconomy.utils;

import com.palmtreefever.Jeconomy.Main;

public class Load extends File_Handler{
	public Load(Main main) {
		super(main, "player_balances.yml");
	}
	
	public void loadBalances() {
		for(String key : config.getKeys(false)){
			Integer pbalance = config.getInt(key+".balance");
			
			Balances balance = new Balances();
			Main.Balances.put(key, balance);
			
			balance.playerUUID = key;
			balance.balance = pbalance;
		}
	}
}
// Maybe instead of loading ALL players into the hashmap on enable, load them into the hashmap as they get on the server?
// but then cant see lets say Notchs balance even though he played before and has an balance.
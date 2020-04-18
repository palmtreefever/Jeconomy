package com.palmtreefever.Jeconomy;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.earth2me.essentials.api.Economy;
import com.palmtreefever.Jeconomy.commands.Balance;
import com.palmtreefever.Jeconomy.commands.Pay;
import com.palmtreefever.Jeconomy.commands.Transfer;
import com.palmtreefever.Jeconomy.utils.Add_Balance;
import com.palmtreefever.Jeconomy.utils.Get_Balance;
import com.palmtreefever.Jeconomy.utils.Load;
import com.palmtreefever.Jeconomy.utils.Save;
import com.palmtreefever.Jeconomy.utils.Setup_Entry;
import com.palmtreefever.Jeconomy.utils.Balances;
import com.palmtreefever.Jeconomy.utils.Subtract_Balance;


public class Main extends JavaPlugin implements Listener {
	
	private Economy Essentialsecon;
	public Setup_Entry setup_entry;
	protected Get_Balance get_balance;
	protected Add_Balance add_balance;
	public Subtract_Balance subtract_balance;
	
	public static HashMap<String, Balances> Balances = new HashMap<>();
	Save save = new Save(this);
	Load load = new Load(this);
	
	public void onEnable() {
		getCommand("balance").setExecutor(new Balance(this));
		getCommand("pay").setExecutor(new Pay(this));
		getCommand("transfer").setExecutor(new Transfer(this));
		Bukkit.getPluginManager().registerEvents(this, this);
		if(!getDataFolder().exists()) {
			getDataFolder().mkdirs();
		}
		this.get_balance = new Get_Balance(this);
		this.add_balance = new Add_Balance(this);
		load.loadBalances();
		loadConfig();
	}

	public void onDisable() {
		saveDefaultConfig(); //saves config.yml
		get_balance.Save_File();
		add_balance.Save_File();
		for (Balances balance : Balances.values()) {
			save.saveB(balance); //Saves all data in the hashmap into towns.yml 
		}
	}

	private void loadConfig() {
		saveDefaultConfig();
	}

	public Economy getEconomy() {
		return Essentialsecon;
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (e.getPlayer().hasPlayedBefore()) {
			return;
		} else {
			setup_entry.createEntry(e.getPlayer().getUniqueId().toString());
			return;
		}
	}
}
/**
 * CMDS
 * topbalance (future)
 * 
 * config.yml change the starting balance in Setup_Entry 
 * FUTURE^
 * 
 */
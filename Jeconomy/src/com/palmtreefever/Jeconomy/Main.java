package com.palmtreefever.Jeconomy;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.palmtreefever.Jeconomy.commands.Balance;
import com.palmtreefever.Jeconomy.commands.Pay;
import com.palmtreefever.Jeconomy.utils.Get_Balance;
import com.palmtreefever.Jeconomy.utils.Setup_Entry;

public class Main extends JavaPlugin implements Listener {
	
	private Setup_Entry setup_entry;
	protected Get_Balance get_balance;

	//public static HashMap<String, Balances> Balances = new HashMap<>();

	public void onEnable() {
		getCommand("balance").setExecutor(new Balance(this));
		getCommand("pay").setExecutor(new Pay());
		Bukkit.getPluginManager().registerEvents(this, this);
		if(!getDataFolder().exists()) {
			getDataFolder().mkdirs();
		}
		this.setup_entry = new Setup_Entry(this);
		this.get_balance = new Get_Balance(this);
		loadConfig();
	}

	public void onDisable() {
		saveDefaultConfig(); //saves config.yml
		setup_entry.Save_File();
		get_balance.Save_File();
	}

	private void loadConfig() {
		saveDefaultConfig();
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if (e.getPlayer().hasPlayedBefore()) {
			return;
		} else {
			setup_entry.createEntry(e.getPlayer().getUniqueId().toString());
		}

	}
	
}
/**
 * CMDS
 * balance
 * pay <name> #
 * topbalance (future)
 * 
 * methods
 * subtract bal from player
 * balance bal for alias
 * 
 * APay <player> $ (server pays a player if they voted for example)
 * (Future method)^
 * 
 * 
 * 
 */
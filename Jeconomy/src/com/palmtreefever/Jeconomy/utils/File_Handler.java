package com.palmtreefever.Jeconomy.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.palmtreefever.Jeconomy.Main;

public class File_Handler {
	protected Main main; //protected only accessed by children classes (extends File_Handler)
	private File file;
	protected FileConfiguration config;
	
	public File_Handler(Main main, String fileName) {
		this.main = main;
		this.file = new File(main.getDataFolder(), fileName);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		this.config = YamlConfiguration.loadConfiguration(file);
	}
	
	public void Save_File() {
		try {
			config.save(file);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
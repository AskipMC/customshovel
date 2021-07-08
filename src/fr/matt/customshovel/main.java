package fr.matt.customshovel;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{

	@Override
	public void onEnable() {
		System.out.println("Le plugin CustomShovel vient de s'allumer !");
		getCommand("customshovel").setExecutor(new Commands());
		Bukkit.getPluginManager().registerEvents(new MineSnowEvent(), this);
		Bukkit.getPluginManager().registerEvents(new RighClickShovel(), this);
	}
	@Override
	public void onDisable() {
		System.out.println("Le plugin CustomShovel vient de s'éteindre !");
	}
	
}

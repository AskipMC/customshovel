package fr.matt.customshovel;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		// Commande : customshovel Pseudo (--> Give 1 custom shovel)
		
		if(args.length!=1) return false;
		
		Player player = Bukkit.getPlayer(args[0]);
		if(player==null) return false;
		
		ItemStack shovel = new ItemStack(Material.DIAMOND_SPADE, 1);
		ItemMeta shovelM = shovel.getItemMeta();
		shovelM.setDisplayName(ChatColor.GREEN + "Custom Shovel");
		shovelM.setLore(Arrays.asList(" ",ChatColor.BLUE + "Stock : 0"," "));
		shovel.setItemMeta(shovelM);
		
		player.getInventory().addItem(shovel);
		
		
		
		return false;
	}

}

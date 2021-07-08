package fr.matt.customshovel;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class MineSnowEvent implements Listener {
	
	@EventHandler
	public void onMineSnow(BlockBreakEvent e) {
		
		if(e.getBlock().getType()!=Material.SNOW_BLOCK && e.getBlock().getType()!=Material.SNOW) return;
		
		Player player = e.getPlayer();
		ItemStack current = player.getInventory().getItemInHand();
		
		if(!current.hasItemMeta()) return;
		if(!current.getItemMeta().hasDisplayName()) return;
		if(current.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Custom Shovel")) {
			
			ItemMeta meta = current.getItemMeta();
			List<String> lore = meta.getLore();
			String stockline = lore.get(1);
			
			String[] split = stockline.split(": ");
			String stockString = split[1];
			int stock = Integer.parseInt(stockString);
			stock++;
			
			meta.setLore(Arrays.asList(" ",ChatColor.BLUE + "Stock : " + stock ," "));
			current.setItemMeta(meta);
			player.updateInventory();
			
			
		}
		
		
	}

}

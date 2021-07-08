package fr.matt.customshovel;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RighClickShovel implements Listener {
	
	@EventHandler
	public void onRighClick(PlayerInteractEvent e) {
		
		if(e.getAction()==Action.RIGHT_CLICK_AIR || e.getAction()==Action.RIGHT_CLICK_BLOCK) {
			
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
				if(!(stock-->0)) {
					player.sendMessage(ChatColor.RED + "Vous n'avez plus de stock !");
					return;
				}
				
				meta.setLore(Arrays.asList(" ",ChatColor.BLUE + "Stock : " + stock ," "));
				current.setItemMeta(meta);
				player.updateInventory();
				
				
				Snowball projectile = player.launchProjectile(Snowball.class);
				player.sendMessage(ChatColor.GREEN + "Vous venez de lancer une boule de neige !");
				
			}
			
			
		}
		
		
	}

}

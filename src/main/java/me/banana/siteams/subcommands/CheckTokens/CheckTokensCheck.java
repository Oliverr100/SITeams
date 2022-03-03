package me.banana.siteams.subcommands.CheckTokens;

import me.banana.siteams.GTC;
import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Objects;

public class CheckTokensCheck {
    public static void check(Player player) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i < 9; i++) {
            Location chestLocation = GTC.getVolcanoChestLocation(i, player.getWorld());
            if (chestLocation.getBlock().getType().equals(Material.CHEST)) {
                Chest chest = (Chest) chestLocation.getBlock().getState();
                ItemStack itemstack = new ItemStack(Material.NAUTILUS_SHELL);
                int amount = 0;

                if (chest.getInventory().contains(Material.NAUTILUS_SHELL)) {
                    for (int i3 = 0; i3 < chest.getInventory().getSize(); i3++) {
                        if(!Objects.isNull(chest.getInventory().getItem(i3))) {
                            amount += Objects.requireNonNull(chest.getInventory().getItem(i3)).getAmount();
                        }
                    }
                }
                String team = String.valueOf(GTC.isValidTeam(String.valueOf(i)));
                map.put(GTC.isValidTeam(String.valueOf(i)), amount);
                if(!(map.get(GTC.isValidTeam(String.valueOf(i))) == 0)) {
                    for(Player p : Bukkit.getOnlinePlayers()) {
                        p.sendMessage(GTC.getColor(team) + "Team " + team + " redeemed " + ChatColor.BOLD + "" + ChatColor.GOLD + map.get(GTC.isValidTeam(String.valueOf(i))) + ChatColor.RESET + ChatColor.AQUA + " Shell" + ChatColor.GOLD + " Tokens");
                    }
                }
                chestLocation.getBlock().setType(Material.AIR);
            }
        }
    }
}


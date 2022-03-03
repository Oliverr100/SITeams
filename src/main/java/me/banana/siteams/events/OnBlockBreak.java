package me.banana.siteams.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class OnBlockBreak implements Listener {

    private static boolean DisableCauldron = false;
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
        if(DisableCauldron){
            if(e.getBlock().getType().equals(Material.CAULDRON)){
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.RED + "no break cauldron");
                Bukkit.getLogger().warning(e.getPlayer() + " tried to break a cauldron during the cauldron game");
            }
        }
    }

    public static void DisableCauldronBreak(boolean minigame) {
        DisableCauldron = minigame;
    }
}

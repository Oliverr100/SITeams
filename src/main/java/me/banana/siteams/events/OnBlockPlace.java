package me.banana.siteams.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class OnBlockPlace implements Listener {

    private static boolean DisableCauldron = false;
    @EventHandler
    public void onBlockBreak(BlockPlaceEvent e){
        if(DisableCauldron){
            if(e.getBlock().getType().equals(Material.CAULDRON)){
                e.setCancelled(true);
            }
        }
    }

    public static void DisableCauldronPlace(boolean minigame) {
        DisableCauldron = minigame;
    }
}

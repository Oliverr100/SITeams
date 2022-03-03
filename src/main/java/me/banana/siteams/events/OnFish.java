package me.banana.siteams.events;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

import java.util.Objects;

public class OnFish implements Listener {
    @EventHandler
    public void onPlayerFish(PlayerFishEvent e) {
        //makse sure players can't catch NAUTILUS_SHELL
        try {
            Item item = (Item) Objects.requireNonNull(e.getCaught());
            if(item.getItemStack().getType().equals(Material.NAUTILUS_SHELL)){
            e.getCaught().remove();
            e.setCancelled(true);
            }
        } catch (Exception ignored){
        }
    }
}

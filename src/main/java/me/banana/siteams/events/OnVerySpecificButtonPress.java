package me.banana.siteams.events;

import me.banana.siteams.Commands.TeamCommand;
import me.banana.siteams.utils.ScoreboardUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.Powerable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;


public class OnVerySpecificButtonPress implements Listener {
    @EventHandler
    public void onButtonPress(PlayerInteractEvent e){

        if((Objects.requireNonNull(e.getClickedBlock())).getType().equals(Material.STONE_BUTTON)){
            Player p = e.getPlayer();
            if(e.getClickedBlock().getLocation().equals(new Location(e.getPlayer().getWorld(), 67d, 87d, -322d))){
                Powerable button = (Powerable) e.getClickedBlock().getState().getBlockData();
                if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && !(button.isPowered())){
                    ScoreboardUtil.updateScore(TeamCommand.getTeam(e.getPlayer()), 1);



                }
            }
        }
    }
}

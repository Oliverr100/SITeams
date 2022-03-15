package me.banana.siteams.events;

import me.banana.siteams.Commands.TeamCommand;
import me.banana.siteams.utils.ScoreboardUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener {
    public Player bopper;
    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        if(e.getEntity().getKiller() != null){
             bopper = e.getEntity().getKiller();
             ScoreboardUtil.updateScore(TeamCommand.getTeam(bopper), 1);
        }
    }
}

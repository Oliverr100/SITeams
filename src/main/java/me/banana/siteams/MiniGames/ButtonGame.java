package me.banana.siteams.MiniGames;


import me.banana.siteams.subcommands.MinigameCommands.Countdown;
import me.banana.siteams.utils.ScoreboardUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

import java.util.Objects;


public class ButtonGame {

    static Objective objective;

    public static void buttonGame(String[] args) {
        if(args[0].equalsIgnoreCase("start")) {
            Countdown.CountdownStart();
            objective = Objects.requireNonNull(ScoreboardUtil.startScoreBoard());
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.setScoreboard(Objects.requireNonNull(objective.getScoreboard()));
            }

            Bukkit.getLogger().info("ScoreBoards for ButtonGame Activated     ... probably");
        }
        if(args[0].equalsIgnoreCase("stop")){
            objective.unregister();
            for(Player p : Bukkit.getOnlinePlayers()){
                p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
            }

        }
    }

}

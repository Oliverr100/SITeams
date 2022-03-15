package me.banana.siteams.MiniGames;

import me.banana.siteams.subcommands.MinigameCommands.Countdown;
import me.banana.siteams.utils.ScoreboardUtil;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Objective;

import java.util.Objects;



public class CountKills {

    static Objective objective;

    public static void countKills(String[] args){
        if(args[0].equalsIgnoreCase("start")) {
            Countdown.CountdownStart();
            objective = Objects.requireNonNull(ScoreboardUtil.startScoreBoard("Kills"));

            Bukkit.getLogger().info("ScoreBoards for ButtonGame Activated     ... probably");
        }
        if(args[0].equalsIgnoreCase("stop")){
            ScoreboardUtil.stopScoreboard("Kills");
        }
    }
}

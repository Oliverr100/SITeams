package me.banana.siteams.MiniGames;

import me.banana.siteams.events.OnBlockBreak;
import me.banana.siteams.events.OnBlockPlace;
import me.banana.siteams.subcommands.MinigameCommands.Countdown;

public class CauldronGame {
    //disable players from breaking or placing cauldrons
    public static void cauldronGame(String[] args) {
        if(args[0].equalsIgnoreCase("start")) {
            Countdown.CountdownStart();
            OnBlockBreak.DisableCauldronBreak(true);
            OnBlockPlace.DisableCauldronPlace(true);
        }else if (args[0].equalsIgnoreCase("stop")) {
            OnBlockBreak.DisableCauldronBreak(false);
            OnBlockPlace.DisableCauldronPlace(false);
        }
    }
}

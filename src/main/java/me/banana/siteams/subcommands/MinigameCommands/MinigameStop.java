package me.banana.siteams.subcommands.MinigameCommands;

import me.banana.siteams.MiniGames.ButtonGame;
import me.banana.siteams.MiniGames.CauldronGame;
import me.banana.siteams.MiniGames.CountKills;
import me.banana.siteams.MiniGames.HideAndSeek;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static me.banana.siteams.Commands.MinigameCommand.isStarted;

public class MinigameStop {
    public static void minigameStop(Player p, String[] args){
        if (args.length >= 2) {
            if (args[1].equalsIgnoreCase("hideandseek")) {
                if(!(isStarted())) {
                    Bukkit.getScheduler().cancelTask( HideAndSeek.getID());
                    p.sendMessage("task should have canceled" + HideAndSeek.getID());
                }
                p.sendMessage(String.valueOf(isStarted()));
            } else if (args[1].equalsIgnoreCase("buttonGame")) {
                ButtonGame.buttonGame(args);
            } else if (args[1].equalsIgnoreCase("cauldronGame")) {
                CauldronGame.cauldronGame(args);
            } else if (args[1].equalsIgnoreCase("CountKills")) {
                CountKills.countKills(args);

        } else {
            p.sendMessage(ChatColor.RED + "Specify a Minigame");
        }
    }
}
}

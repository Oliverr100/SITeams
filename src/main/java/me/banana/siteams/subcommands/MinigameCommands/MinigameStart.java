package me.banana.siteams.subcommands.MinigameCommands;

import me.banana.siteams.MiniGames.ButtonGame;
import me.banana.siteams.MiniGames.CauldronGame;
import me.banana.siteams.MiniGames.CountKills;
import me.banana.siteams.MiniGames.HideAndSeek;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

public class MinigameStart {

    public static void minigameStart(Player p, String[] args) {
        if (args.length >= 2) {
            if (args[1].equalsIgnoreCase("hideandseek")) {
                HideAndSeek.hideandSeek(args, p);
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

package me.banana.siteams.MiniGames;

import me.banana.siteams.Commands.MinigameCommand;
import me.banana.siteams.SITeams;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import static me.banana.siteams.Commands.MinigameCommand.isStarted;

public class HideAndSeek {

    public static int taskID;
    public static BukkitScheduler scheduler;

    public static void hideandSeek(String[] args, Player p){
        if (isStarted()) {
            scheduler = SITeams.getPlugin().getServer().getScheduler();
            MinigameCommand.started = false;
            taskID = (scheduler.scheduleSyncRepeatingTask(SITeams.getPlugin(), () -> {
                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (args[3].equals(players.getName())) {
                        for (Player tplayers : Bukkit.getOnlinePlayers()) {
                            tplayers.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.DARK_AQUA + "" + ChatColor.UNDERLINE + tplayers.getLocation().distance(players.getLocation())));
                        }
                        break;
                    }
                }
            }, 0L, 1L));
    } else p.sendMessage(ChatColor.RED + "Minigame already started");
    }

    public static int getID(){
        return taskID;
    }
}
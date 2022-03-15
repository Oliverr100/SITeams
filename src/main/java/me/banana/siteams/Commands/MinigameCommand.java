package me.banana.siteams.Commands;

import me.banana.siteams.subcommands.MinigameCommands.Countdown;
import me.banana.siteams.subcommands.MinigameCommands.MinigameStart;
import me.banana.siteams.subcommands.MinigameCommands.MinigameStop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MinigameCommand implements CommandExecutor {

    public static boolean started;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player p && args.length > 0 ){
            switch (args[0]) {
                case "start" -> {
                    started = true;
                    MinigameStart.minigameStart(p, args);
                }
                case "stop" -> {
                    started = false;
                    MinigameStop.minigameStop(p, args);
                }
                case "countdown" -> Countdown.CountdownStart();
            }
        }
        return true;
    }
    public static boolean isStarted() {
        return started;
    }
}

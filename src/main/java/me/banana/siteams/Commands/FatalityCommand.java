package me.banana.siteams.Commands;

import me.banana.siteams.GTC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class FatalityCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length == 2){
            String team1 = GTC.isValidTeam(args[0]);
            String team2 = GTC.isValidTeam(args[1]);
            if(team1 != null && team2 != null){
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rg removemember -w \"TotalDouglasIsland\" fatality_arena -a");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rg addmember -w \"TotalDouglasIsland\" fatality_arena g:" + team1);
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rg addmember -w \"TotalDouglasIsland\" fatality_arena g:" + team2);
            }
        }
        return true;
    }
}

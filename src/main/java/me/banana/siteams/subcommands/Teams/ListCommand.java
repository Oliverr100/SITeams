package me.banana.siteams.subcommands.Teams;

import me.banana.siteams.GTC;
import me.banana.siteams.SITeams;
import me.banana.siteams.Commands.TeamCommand;
import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.banana.siteams.Commands.TeamCommand.getTeam;

public class ListCommand {

    public static void listCommand(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        PersistentDataContainer data = p.getPersistentDataContainer();
        if (args.length == 1) {
            StringBuilder result = new StringBuilder();
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (TeamCommand.getTeam(players).equals(TeamCommand.getTeam(p))) {
                    result.append(GTC.getTeamColor(players)).append(players.getDisplayName()).append(" ");
                }
            }
            if (result.toString().equals("")) {
                p.sendMessage("Nobody is on " + GTC.getTeamColor(p) + getTeam(p) + " Team");
            } else {
                p.sendMessage(result.toString());

            }
        } else {
            String team = args[1].toLowerCase().substring(0, 1).toUpperCase() + args[1].toLowerCase().substring(1);
            String currentTeam = data.get(new NamespacedKey(SITeams.getPlugin(), "team"), PersistentDataType.STRING);
            List<String> teamcolors = new ArrayList<>(Arrays.asList( "BronzeBarns", "ScarletSpoons", "OrangeOtters", "YellowYoshis", "LimeLuigis", "CobaltChefs", "PinkPeppers", "MagentaMarios", "BronzeBarns", "None"));  //make a list of the teamcolors


            if (teamcolors.contains(team)) {
                StringBuilder result = new StringBuilder();
                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (TeamCommand.getTeam(players).equals(team)) {
                        result.append(GTC.getTeamColor(players)).append(players.getDisplayName()).append(" ");
                    }
                }
                if (result.toString().equals("")) {
                    p.sendMessage(ChatColor.RED + "Nobody is on " + GTC.getColor(team) + team + " Team");
                } else {
                    p.sendMessage(result.toString());
                }
            } else {
                p.sendMessage(ChatColor.RED + "Invalid Team");
            }

        }
    }
}

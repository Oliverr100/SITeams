package me.banana.siteams.subcommands.Teams;

import me.banana.siteams.GTC;
import me.banana.siteams.Commands.TeamCommand;
import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpCommand {
    static int count = 0;
    public static void tpcommand( CommandSender sender, String[] args) {
        Player pLoc = (Player) sender;
        if (args.length > 2) {                   //team tp blue bananababoo
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p.getName().equalsIgnoreCase(args[2])) {
                    pLoc = p;
                    break;
                }
            }
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (TeamCommand.getTeam(p).equalsIgnoreCase(args[1])) {
                    p.teleport(pLoc.getLocation());
                    count += 1;
                }
            }
        } else if(args.length == 2) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (TeamCommand.getTeam(p).equalsIgnoreCase(args[1])) {
                    p.teleport(pLoc.getLocation());
                    count += 1;
                }
            }

        } else {
            if (args.length < 1) {
                pLoc.sendMessage(ChatColor.RED + "Invalid Team");
            } else if(count == 0){
                pLoc.sendMessage(ChatColor.RED + "Nobody on " + (GTC.getColor(args[1].toLowerCase().substring(0,1).toUpperCase() + args[1].toLowerCase().substring(1))) + (args[1].toLowerCase().substring(0,1).toUpperCase() + args[1].toLowerCase().substring(1)) + " Team");
            }
        }
    }
}

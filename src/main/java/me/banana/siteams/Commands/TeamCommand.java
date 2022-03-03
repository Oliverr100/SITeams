package me.banana.siteams.Commands;

import me.banana.siteams.GTC;
import me.banana.siteams.SITeams;
import me.banana.siteams.subcommands.Teams.JoinCommand;
import me.banana.siteams.subcommands.Teams.ListCommand;
import me.banana.siteams.subcommands.Teams.PointsCommand;
import me.banana.siteams.subcommands.Teams.TpCommand;
import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TeamCommand implements CommandExecutor {

    public static String getTeam(Player player){
        return (Objects.requireNonNull(player.getPersistentDataContainer().get(new NamespacedKey(SITeams.getPlugin(), "team"), PersistentDataType.STRING)));
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (sender instanceof Player p) {      // if there is arguments and sender is a player

            //execute correct command
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("join")) {
                    JoinCommand.joinCommand(sender, args);
                } else if (args[0].equalsIgnoreCase("tp")) {
                    TpCommand.tpcommand(sender, args);
                } else if (args[0].equalsIgnoreCase("points")) {
                    PointsCommand.pointsCommand(sender, args);
                }else if (args[0].equalsIgnoreCase("list")) {
                    ListCommand.listCommand(sender, args);
                } else {
                    for(Player player : Bukkit.getOnlinePlayers()){
                        if(args[0].equals(player.getDisplayName())){
                            p.sendMessage(GTC.getTeamColor(player) + player.getDisplayName() + ChatColor.GRAY + " is on " + GTC.getTeamColor(player) + getTeam(player) + " Team");
                        }
                    }
                }
            } else if (getTeam(p).equals("none")) {
                p.sendMessage(ChatColor.GRAY + "You aren't on a team");
            } else {
                p.sendMessage(ChatColor.GRAY + "You are on " + GTC.getTeamColor(p) + getTeam(p) + " Team");
            }
        }
        return true;
    }
}

package me.banana.siteams.subcommands.Teams;

import me.banana.siteams.GTC;
import me.banana.siteams.SITeams;
import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.*;

public class JoinCommand {

    public static void joinCommand(CommandSender sender, String[] args) {
        List<String> teamcolors = new ArrayList<>( Arrays.asList("BronzeBarns", "ScarletSpoons", "OrangeOtters", "YellowYoshis", "LimeLuigis", "CobaltChefs", "PinkPeppers", "MagentaMarios", "BronzeBarns", "None"));  //make a list of the teamcolors
        Player p = (Player) sender;
        String team = args[1].toLowerCase(); //get team and make sure capitalization is correct
        String targetp;
        if(args.length == 2){
            targetp = p.getName();
        } else {
            targetp = args[2];       //get player wanted to join a team
        }
        if(teamcolors.contains(GTC.isValidTeam(team))) {
            team = GTC.isValidTeam(args[1]);
        for(Player onlineplayer : Bukkit.getOnlinePlayers()){   //check if player exists and is online
            if(onlineplayer.getName().equals(targetp) ) {
                Player rp = onlineplayer.getPlayer();
                assert rp != null;

                //make and store the team to a PersistentDataContainer
                PersistentDataContainer data = rp.getPersistentDataContainer();
                String currentTeam = data.get(new NamespacedKey(SITeams.getPlugin(), "team"), PersistentDataType.STRING);
                assert currentTeam != null;
                if(currentTeam.equals(team)){
                    p.sendMessage(GTC.getTeamColor(rp) + rp.getDisplayName() + " is already on Team " + GTC.getTeamColor(rp) + team);
                    p.playSound(p.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 100, 10);

                } else {
                    data.set(new NamespacedKey(SITeams.getPlugin(), "team"), PersistentDataType.STRING, team);
                    for(Player ppl : Bukkit.getOnlinePlayers()) {
                        if(ppl.isOp() && (!ppl.equals(p))){
                            ppl.sendMessage(GTC.getTeamColor(rp) + rp.getDisplayName() + " joined Team " + team);
                        }
                    }
                    p.sendMessage(GTC.getTeamColor(rp) + rp.getDisplayName() + " joined Team " + team);
                    if(!p.equals(rp)) {
                        rp.sendMessage(GTC.getTeamColor(rp) + "Joined Team " + team);    //alert players that they joined team
                    }
                    p.setPlayerListName(GTC.getTeamColor(p) + p.getDisplayName());
                }
            }
        }
        } else {
                p.sendMessage(ChatColor.RED + "Invalid team");
            }
    }




}



package me.banana.siteams.subcommands.Teams;

import me.banana.siteams.GTC;
import me.banana.siteams.utils.PointsStorageUtil;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PointsCommand {
    public static void pointsCommand(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(p.isOp()) {
            if (args.length == 4) {             // if 4
                switch (args[1]) {              //switch for "readability" according to intellij apparently ill change back if need be
                    case "set":
                        if (GTC.getTeamNames().contains(GTC.isValidTeam(args[2].toLowerCase()))) {            //convoluted way to check if team is valid
                            PointsStorageUtil.setPoints(args[2].toLowerCase(), Integer.parseInt(args[3]));
                            try {
                                PointsStorageUtil.savePoints();
                                p.sendMessage(GTC.getColor(args[2].toLowerCase()) + "Team " + GTC.isValidTeam(args[2].toLowerCase()) + " now has " + ChatColor.GOLD + PointsStorageUtil.getPoints(args[2].toLowerCase()) + " Points.");
                            } catch (Exception e) {
                                p.sendMessage("Points not saved, check console and tell banana");                       //make sure to log to console if borked
                                Bukkit.getLogger().warning(Arrays.toString(e.getStackTrace()));
                            }
                        }
                        break;
                    case "add":
                        if (GTC.getTeamNames().contains(GTC.isValidTeam(args[2].toLowerCase()))) {            //convoluted way to check if team is valid
                            PointsStorageUtil.setPoints(args[2].toLowerCase(), Integer.parseInt(args[3]) + PointsStorageUtil.getPoints(args[2].toLowerCase()));
                            try {
                                PointsStorageUtil.savePoints();
                                p.sendMessage(GTC.getColor(args[2].toLowerCase()) + "Added " + ChatColor.GOLD + Integer.parseInt(args[3]) + GTC.getColor(args[2].toLowerCase()) + " Points to team " + GTC.isValidTeam(args[2].toLowerCase())
                                        + ChatColor.GOLD + " (" + PointsStorageUtil.getPoints(args[2].toLowerCase()) + " Total)");
                            } catch (Exception e) {
                                p.sendMessage("Points not saved, check console and tell banana");
                                Bukkit.getLogger().warning(Arrays.toString(e.getStackTrace()));
                            }
                        }
                        break;
                    case "remove":
                        if (GTC.getTeamNames().contains(GTC.isValidTeam(args[2].toLowerCase()))) {            //convoluted way to check if team is valid
                            PointsStorageUtil.setPoints(args[2].toLowerCase(), PointsStorageUtil.getPoints(args[2].toLowerCase()) - Integer.parseInt(args[3]));
                            try {                   //try catch so
                                PointsStorageUtil.savePoints();
                                p.sendMessage(GTC.getColor(args[2].toLowerCase()) + "Removed " + ChatColor.GOLD + Integer.parseInt(args[3]) + GTC.getColor(args[2].toLowerCase()) + " Points " + "from team " + GTC.isValidTeam(args[2])
                                        + ChatColor.GOLD + " (" + PointsStorageUtil.getPoints(args[2].toLowerCase()) + " Total)");
                            } catch (Exception e) {
                                p.sendMessage("Points not saved, check console and tell banana");
                                Bukkit.getLogger().warning(Arrays.toString(e.getStackTrace()));
                            }
                        }
                        break;
                }
            } else if (args.length == 3 && args[1].equalsIgnoreCase("get")) {       //if 3
                if (GTC.getTeamNames().contains(GTC.isValidTeam(args[2].toLowerCase()))) {       //if valid
                    p.sendMessage(GTC.getColor(args[2].toLowerCase()) + "Team " + GTC.isValidTeam(args[2].toLowerCase()) + " has " + ChatColor.GOLD + PointsStorageUtil.getPoints(args[2].toLowerCase()) + " Points.");
                }
            } else if (args.length == 2 && args[1].equalsIgnoreCase("list")) {
                for (int i = 1; i < 9; i++) {
                    String team = String.valueOf(i);
                    p.sendMessage(GTC.getColor(team) + "Team " + GTC.fromNumGetTeam(team) + " has " + ChatColor.GOLD + PointsStorageUtil.getPoints(GTC.fromNumGetTeam(team)) + " Points.");
                }


            }
        } else {
            ArrayList<Integer> points = new ArrayList<>();
            for(int i = 0; i < 8; i++ ){
                p.sendMessage(String.valueOf(points));
                points.add(0, PointsStorageUtil.getPoints(GTC.fromNumGetTeam(String.valueOf(i+1))));
                p.sendMessage(String.valueOf(points));
                Collections.sort(points);
            }
            p.sendMessage(GTC.getColor(GTC.getTeam(p)) + "Your team has " + ChatColor.GOLD + PointsStorageUtil.getPoints(GTC.getTeam(p).toLowerCase()) + " Points" + " ["
            + points.indexOf(GTC.fromTeamGetNUm(GTC.getTeam(p))) + "]"
                    );
        }
    }
}

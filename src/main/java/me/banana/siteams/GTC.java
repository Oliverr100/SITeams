package me.banana.siteams;

import me.banana.siteams.Commands.TeamCommand;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class GTC {
    public static ChatColor getTeamColor(Player player) {
        if (player != null) {
            return switch (TeamCommand.getTeam(player)) {
                case "ScarletSpoons" -> ChatColor.of("#ff2400");
                case "BronzeBarns" -> ChatColor.of("#925b44");
                case "OrangeOtters" -> ChatColor.of("#ff7c00");
                case "YellowYoshis" -> ChatColor.of("#ffd700");
                case "LimeLuigis" -> ChatColor.of("#00ff00");
                case "CobaltChefs" -> ChatColor.of("#106eeb");
                case "MagentaMarios" -> ChatColor.of("#d400ff}");
                case "PinkPeppers" -> ChatColor.of("#FF91A4");
                case "None" -> ChatColor.GRAY;
                default -> null;
            };
        } else return ChatColor.GRAY;
    }

    public static ChatColor getColor(String teamName) {
        teamName = GTC.isValidTeam(teamName.toLowerCase());
            return switch (teamName) {
                case "ScarletSpoons" -> ChatColor.of("#ff2400");
                case "BronzeBarns" -> ChatColor.of("#925b44");
                case "OrangeOtters" -> ChatColor.of("#ff7c00");
                case "YellowYoshis" -> ChatColor.of("#ffd700");
                case "LimeLuigis" -> ChatColor.of("#00ff00");
                case "CobaltChefs" -> ChatColor.of("#106eeb");
                case "MagentaMarios" -> ChatColor.of("#d400ff");
                case "PinkPeppers" -> ChatColor.of("#FF91A4");
                case "None" -> ChatColor.GRAY;
                default -> null;
            };
    }

    public static Location getVolcanoLocation(String teamName, World world) {
        teamName = GTC.isValidTeam(teamName.toLowerCase());
        return switch (teamName) {
            case "ScarletSpoons", "8" -> new Location(world, 5.5, 110, -213.5);
            case "OrangeOtters", "7" -> new Location(world, -17.5, 110, -203.5);
            case "YellowYoshis", "6" -> new Location(world, -37.5, 110, -213.5);
            case "LimeLuigis", "5" -> new Location(world, -50.5, 110, -236.5);
            case "CobaltChefs", "4" -> new Location(world, -40.5, 110, -259.5);
            case "PinkPeppers", "3" -> new Location(world, -17.5, 110, -269.5);
            case "MagentaMarios", "2" -> new Location(world, 5.5, 110, -259.5);
            case "BronzeBarns", "1" -> new Location(world, 15.5, 110, -236.5);
            default -> null;
        };
    }
    public static Location getVolcanoChestLocation(Integer num, World world) {
        return switch (num) {
            case 8 -> new Location(world, 2.5, 111, -216.5);
            case 7-> new Location(world, -17.5, 111, -207.5);
            case 6 -> new Location(world, -37.5, 111, -216.5);
            case 5 -> new Location(world, -46.5, 111, -236.5);
            case 4 -> new Location(world, -37.5, 111, -256.5);
            case 3 -> new Location(world, -17.5, 111, -265.5);
            case 2 -> new Location(world, 2.5, 111, -256.5);
            case 1 -> new Location(world, 11.5, 111, -236.5);
            default -> null;
        };
    }
    public static String isValidTeam(String teamName) {
        teamName = teamName.toLowerCase();
        return switch (teamName) {
            case "1", "bronzebarns" -> "BronzeBarns";
            case "8", "scarletspoons" -> "ScarletSpoons";
            case "7", "orangeotters" -> "OrangeOtters";
            case "6", "yellowyoshis" -> "YellowYoshis";
            case "5", "limeluigis" -> "LimeLuigis";
            case "4", "cobaltchefs" -> "CobaltChefs";
            case "3", "pinkpeppers" -> "PinkPeppers";
            case "2", "magentamarios" ->"MagentaMarios";
            case "none" -> "None";
            default -> null;
        };
    }
    public static String fromNumGetTeam(String teamName) {
        teamName = teamName.toLowerCase();
        return switch (teamName) {
            case "1" -> "BronzeBarns";
            case "2" -> "ScarletSpoons";
            case "3" -> "OrangeOtters";
            case "4" -> "YellowYoshis";
            case "5" -> "LimeLuigis";
            case "6" -> "CobaltChefs";
            case "7" -> "PinkPeppers" ;
            case "8" ->"MagentaMarios";
            case "none" -> "None";
            default -> null;
        };
    }
    public static Integer fromTeamGetNUm(String teamName) {
        return switch (teamName) {
            case "BronzeBarns" -> 1;
            case "ScarletSpoons" -> 2;
            case "OrangeOtters" -> 3;
            case "YellowYoshis" -> 4;
            case "LimeLuigis" -> 5;
            case "CobaltChefs" -> 6;
            case "PinkPeppers" -> 7 ;
            case "MagentaMarios" -> 8;
            case "none" -> null;
            default -> null;
        };
    }

    public static List<String> getTeamNames() {
        return new ArrayList<>( Arrays.asList("BronzeBarns", "ScarletSpoons", "OrangeOtters", "YellowYoshis", "LimeLuigis", "CobaltChefs", "PinkPeppers", "MagentaMarios", "BronzeBarns", "None"));  //make a list of the teamcolors
    }

    public static org.bukkit.ChatColor translateColor(ChatColor x) {
        return org.bukkit.ChatColor.getByChar(x.getName());
    }
    public static String getTeam(Player p) {
        PersistentDataContainer data = p.getPersistentDataContainer();
        return((Objects.requireNonNull(data.get(new NamespacedKey(SITeams.getPlugin(), "team"), PersistentDataType.STRING))).toLowerCase());
    }


}

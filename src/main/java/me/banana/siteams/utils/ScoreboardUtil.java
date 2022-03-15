package me.banana.siteams.utils;

import me.banana.siteams.GTC;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.Arrays;
import java.util.Objects;

public class ScoreboardUtil {

    public static Score score1;
    public static Score score2;
    public static Score score3;
    public static Score score4;
    public static Score score5;
    public static Score score6;
    public static Score score7;
    public static Score score8;


    public static Objective startScoreBoard(String name){//Name is case sensitive make sure its right
        try {
            ScoreboardManager manager = Bukkit.getScoreboardManager();
            assert manager != null;
            Scoreboard board = manager.getNewScoreboard();
            final Objective objective = board.registerNewObjective(name, "dummy", (ChatColor.GOLD + "Points"));
            objective.setDisplayName(ChatColor.GOLD + name);
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);

            Team team1 = board.registerNewTeam("BronzeBarns");
            team1.setPrefix(GTC.getColor("BronzeBarns") + "BronzeBarns");
            Team team2 = board.registerNewTeam("ScarletSpoons");
            team2.setPrefix(GTC.getColor("ScarletSpoons") + "ScarletSpoons");
            Team team3 = board.registerNewTeam("OrangeOtters");
            team3.setPrefix(GTC.getColor("OrangeOtters") + "OrangeOtters");
            Team team4 = board.registerNewTeam("YellowYoshis");
            team4.setPrefix(GTC.getColor("YellowYoshis") + "YellowYoshis");
            Team team5 = board.registerNewTeam("LimeLuigis");
            team5.setPrefix(GTC.getColor("LimeLuigis") + "Limeluigis");
            Team team6 = board.registerNewTeam("CobaltChefs");
            team6.setPrefix(GTC.getColor("CobaltChefs") + "CobaltChefs");
            Team team7 = board.registerNewTeam("MagentaMarios");
            team7.setPrefix(GTC.getColor("MagentaMarios") + "MagentaMarios");
            Team team8 = board.registerNewTeam("PinkPeppers");
            team8.setPrefix(GTC.getColor("PinkPeppers") + "PinkPeppers");
            team1.addEntry(ChatColor.translateAlternateColorCodes('&', "&1"));
            team2.addEntry(ChatColor.translateAlternateColorCodes('&', "&2"));
            team3.addEntry(ChatColor.translateAlternateColorCodes('&', "&3"));
            team4.addEntry(ChatColor.translateAlternateColorCodes('&', "&4"));
            team5.addEntry(ChatColor.translateAlternateColorCodes('&', "&5"));
            team6.addEntry(ChatColor.translateAlternateColorCodes('&', "&6"));
            team7.addEntry(ChatColor.translateAlternateColorCodes('&', "&7"));
            team8.addEntry(ChatColor.translateAlternateColorCodes('&', "&8"));
            score1 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&1"));
            score2 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&2"));
            score3 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&3"));
            score4 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&4"));
            score5 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&5"));
            score6 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&6"));
            score7 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&7"));
            score8 = objective.getScore(ChatColor.translateAlternateColorCodes('&', "&8"));
            score2.setScore(0);
            score1.setScore(0);
            score3.setScore(0);
            score4.setScore(0);
            score5.setScore(0);
            score6.setScore(0);
            score7.setScore(0);
            score8.setScore(0);
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.setScoreboard(Objects.requireNonNull(objective.getScoreboard()));
            }
            return objective;
        } catch(NullPointerException e) {
            Bukkit.getLogger().warning("Scoreboard Failed to Activate / is null, go show the error log below to banana");
            Bukkit.getLogger().warning(Arrays.toString(e.getStackTrace()));
            return null;
        }
    }
    public static void updateScore(String team, Integer increment){
        switch (team) {
            case "ScarletSpoons" -> score2.setScore(score2.getScore() + increment);
            case "BronzeBarns" -> score1.setScore(score1.getScore() + increment);
            case "OrangeOtters" -> score3.setScore(score3.getScore() + increment);
            case "YellowYoshis" -> score4.setScore(score4.getScore() + increment);
            case "LimeLuigis" -> score5.setScore(score5.getScore() + increment);
            case "CobaltChefs" -> score6.setScore(score6.getScore() + increment);
            case "MagentaMarios" -> score7.setScore(score7.getScore() + increment);
            case "PinkPeppers" -> score8.setScore(score8.getScore() + increment);
        };
    }
    public static void stopScoreboard(String name){
        Objects.requireNonNull(ScoreboardUtil.startScoreBoard(name)).unregister();
        for(Player p : Bukkit.getOnlinePlayers()){
            p.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
        }
    }
}


package me.banana.siteams.subcommands.MinigameCommands;

import me.banana.siteams.SITeams;
import me.banana.siteams.events.OnMove;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Countdown {
    public static int id;
    static int i = 3;
    public static void CountdownStart(){
        i = 3;
        id = Bukkit.getScheduler().scheduleSyncRepeatingTask(SITeams.getPlugin(), new Runnable() {
            @Override
            public void run() {
                if(i==0){
                    CountdownStop();
                }
                for(Player p : Bukkit.getOnlinePlayers()){
                    OnMove.freeze();
                    if(i == 0){
                        p.sendTitle(ChatColor.GOLD + "GO", "", 2, 20, 4);
                        OnMove.unfreeze();
                    }else if(i==1){
                        p.sendTitle(ChatColor.GREEN + String.valueOf(i), "", 2, 20, 4);
                    }else if(i==2){
                        p.sendTitle(ChatColor.YELLOW + String.valueOf(i), "", 2, 20, 4);
                    }else if(i==3){
                        p.sendTitle(ChatColor.RED + String.valueOf(i), "", 2, 20, 4);
                    }

                }
                i--;
            }
        }, 0, 20);
    }
    public static void CountdownStop(){
        Bukkit.getScheduler().cancelTask(id);
    }
}

package me.banana.siteams.Commands;

import com.Zrips.CMI.CMI;
import org.bukkit.Bukkit;
import net.md_5.bungee.api.ChatColor;import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TimerCommand implements CommandExecutor {

    int Total_time;
    private int timeSecs;
    private int timeMin;
    private int timeHour;
    private int placeValue;
    int length;
    String timeRequest = "Timer not started";
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player p && p .isOp()) {
            //get player

            Objects.requireNonNull(p.getPlayer());
            length = args.length;

            if(args.length == 0){
                p.sendMessage(timeRequest);
                return true;
            }
            //Boss bar stuff
            if (args[0].equals("start")) {
                if(args.length == 2){
                    timeSecs = Integer.parseInt(args[1]);
                    Total_time = timeSecs;
                    placeValue = 1;
                }else if(args.length == 3){
                    timeMin = Integer.parseInt(args[1]);
                    try {
                        timeSecs = Integer.parseInt(args[2]);
                        placeValue = 2;
                    } catch(NumberFormatException e) {
                        placeValue = 1;
                        timeSecs = Integer.parseInt(args[1]);
                        timeMin = 0;
                    }
                    Total_time = timeMin*60 + timeSecs;
                }else if(args.length == 4){
                    timeHour = Integer.parseInt(args[1]);
                    timeMin = Integer.parseInt(args[2]);
                    try {
                        timeSecs = Integer.parseInt(args[3]);
                        placeValue = 3;
                    } catch(NumberFormatException e) {
                        placeValue = 2;
                        timeHour = 0;
                        timeMin = Integer.parseInt(args[1]);
                        timeSecs = Integer.parseInt(args[2]);
                    }
                    Total_time = timeHour*60*60 + timeMin*60 + timeSecs;
                }

                if(timeSecs == 0) timeSecs = 1;
                Timer(Total_time, p, args);
            } else
            if (args[0].equals("stop")) {
                if(args.length == 2){
                    CMI.getInstance().performCommand(p, "cmi bossbarmsg all -cancel:" + args[1]);
                    p.sendMessage(ChatColor.RED + "Timer " + args[1] + " stopped");
                } else {
                    p.sendMessage(ChatColor.RED + "Timer stopped");
                    CMI.getInstance().performCommand(p, "cmi bossbarmsg all -cancel:Timer");
                }
            }
        } else{
            if (args[0].equals("stop")) {
                Bukkit.getLogger().info("tried to cancle timer");
            }
        }
        return true;
    }

    public void Timer(int Total_time, Player p, String[] args) {
        if(args.length == 3 && placeValue == 1) {
            String arg2 = args[2];
            StringBuilder arg2n = new StringBuilder();
            for (int i = 0; i < arg2.length(); i++) {

                if (String.valueOf(arg2.charAt(i)).equals("_")) {
                    arg2n.append(" ");
                } else {
                    arg2n.append(arg2.charAt(i));
                }
            }
            p.sendMessage(String.valueOf(arg2n));
            CMI.getInstance().performCommand(p, ("cmi bossbarmsg all &6" + arg2n + " -n:" + "Timer" + " -c:blue -s:1 -pcmd:" + "\"timer stop;;cmi broadcast\"" +" -sec:" + "-" + Total_time));
            p.sendMessage(String.valueOf(Total_time));
        }else if(args.length == 4 && placeValue == 2) {
            String arg3 = args[3];
            StringBuilder arg3n = new StringBuilder();
            for (int i = 0; i < arg3.length(); i++) {
                if (String.valueOf(arg3.charAt(i)).equals("_")) {
                    arg3n.append(" ");
                } else {
                    arg3n.append(arg3.charAt(i));
                }
            }
            CMI.getInstance().performCommand(p, ("cmi bossbarmsg all &6" + arg3n + " -n:" + "Timer" + " -c:blue -s:1 -pcmd:" + "\"timer stop\"" + " -sec:" + "-" + Total_time));
            p.sendMessage(String.valueOf(Total_time));
        }else if(args.length == 5 && placeValue == 3) {
            String arg4 = args[4];
            StringBuilder arg4n = new StringBuilder();
            for (int i = 0; i < arg4.length(); i++) {
                if (String.valueOf(arg4.charAt(i)).equals("_")) {
                    arg4n.append(" ");
                } else {
                    arg4n.append(arg4.charAt(i));
                }
            }
            CMI.getInstance().performCommand(p, ("cmi bossbarmsg all &6" + arg4n + " -n:" + "Timer" + " -c:blue -s:1 -pcmd:" + "\"timer stop\"" + "-sec:" + "-" + Total_time));
            p.sendMessage(String.valueOf(Total_time));
        }else {
            CMI.getInstance().performCommand(p, ("cmi bossbarmsg all &6" + "Timer" + " -n:Timer -c:blue -s:1 -pcmd:" + "\"timer stop\"" + " -sec:" + "-" + Total_time));
            p.sendMessage(String.valueOf(Total_time));
        }
        timeSecs = 0;
        timeMin = 0;
        timeHour = 0;
    }
}


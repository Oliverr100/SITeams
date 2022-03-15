package me.banana.siteams.AutoCompleate;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamTabCompleation implements TabCompleter {
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        if (args.length == 1) {
            if(!("join" + "chat" + "tp" + "points").contains(args[0])){
              ArrayList<String> array = new ArrayList<>();
              for(Player player : Bukkit.getOnlinePlayers()){
                  array.add(player.getDisplayName());
              }
            return array;
            }
            return new ArrayList<>(Arrays.asList("join", "tp","points"));
        } else
        if(args[0].equalsIgnoreCase("Points") && sender.isOp() && args.length <= 2){
            return new ArrayList<>(Arrays.asList("get", "set", "add", "remove", "list"));
        }
        if ((args[0].equals("join") || args[0].equals("tp") || args[1].equals("get") || args[1].equals("set") || args[1].equals("add") || args[1].equals("remove")) || args[1].equals("list") && sender.isOp() && args.length <= 3) {
            return new ArrayList<>(Arrays.asList("bronzebarns", "scarletspoons", "orangeotters", "yellowyoshis", "limeluigis", "cobaltchefs", "pinkpeppers", "magentamarios", "none"));
        }
            return null;
    }
}

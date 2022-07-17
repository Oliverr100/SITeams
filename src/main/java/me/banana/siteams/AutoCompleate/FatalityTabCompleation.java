package me.banana.siteams.AutoCompleate;

import me.banana.siteams.GTC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FatalityTabCompleation implements TabCompleter {
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        Player p = (Player) sender;
        if(p.isOp()) {
            if (args.length == 0) {
                return GTC.getTeamNames();
            } else if (args.length == 1) {
                return GTC.getTeamNames();
            } else return null;
        } else {
            return null;
        }
    }
}

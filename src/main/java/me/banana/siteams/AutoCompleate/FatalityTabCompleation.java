package me.banana.siteams.AutoCompleate;

import me.banana.siteams.GTC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FatalityTabCompleation implements TabCompleter {
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if(args.length == 1)    { return GTC.getTeamNames(); }
        else if(args.length == 2)   { return GTC.getTeamNames(); }
        else return null;
    }
}

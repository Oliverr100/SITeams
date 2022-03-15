package me.banana.siteams.AutoCompleate;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinigameTabCompleation implements TabCompleter {
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if(args.length == 1)    { return new ArrayList<>(Arrays.asList("start", "stop", "countdown")); }
        else if(args.length == 2)   { return new ArrayList<>(List.of("ButtonGame", "CauldronGame", "CountKills")); }

        return null;
    }
}

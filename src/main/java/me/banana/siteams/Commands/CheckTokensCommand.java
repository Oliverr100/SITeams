package me.banana.siteams.Commands;

import me.banana.siteams.subcommands.CheckTokens.CheckTokensCheck;
import me.banana.siteams.subcommands.CheckTokens.CheckTokensSpawn;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CheckTokensCommand implements CommandExecutor{

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player p && args.length > 0){
            if(args[0].equalsIgnoreCase("spawn")) CheckTokensSpawn.spawn(p);
            else if (args[0].equalsIgnoreCase("check")) CheckTokensCheck.check(p);
        }
        return true;
    }
}




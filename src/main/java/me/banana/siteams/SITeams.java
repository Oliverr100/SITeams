package me.banana.siteams;

import com.Zrips.CMI.CMI;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import me.banana.siteams.Commands.CheckTokensCommand;
import me.banana.siteams.Commands.MinigameCommand;
import me.banana.siteams.Commands.TeamCommand;
import me.banana.siteams.Commands.TimerCommand;
import me.banana.siteams.events.OnJoin;
import me.banana.siteams.events.OnMove;
import me.banana.siteams.events.OnVerySpecificButtonPress;
import me.banana.siteams.events.OnFish;
import me.banana.siteams.utils.PointsStorageUtil;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public final class SITeams extends JavaPlugin {
    public static SITeams getPlugin() { return plugin; }
    public static LuckPerms LPapi;
    public static CMI CMIapi;

    static SITeams plugin;
    public static WorldGuardPlugin getWorldGuard() {
        Plugin plugin = getPlugin().getServer().getPluginManager().getPlugin("WorldGuard");


        if(!(plugin instanceof WorldGuardPlugin)){
            return null;
        }
        Bukkit.getLogger().info("WorldGuard Integration Enabled");
    return (WorldGuardPlugin) plugin;
    }
   @Override
    public void onEnable() {
         //Plugin startup logic
        plugin = this;
       String path = String.valueOf(SITeams.getPlugin().getDataFolder().getAbsoluteFile());
       File file = new File(path + "/points.json");
       file.getParentFile().mkdir();
       if(!file.exists()) {
           try {
               file.createNewFile();
               PointsStorageUtil.savePoints();


           } catch (IOException e) {
               Bukkit.getLogger().warning("Json Failed to Create!     go yell at banana");
               Bukkit.getLogger().warning(Arrays.toString(e.getStackTrace()));
           }
       }

        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            LPapi = provider.getProvider();
        }
       RegisteredServiceProvider<CMI> cmiprovider = Bukkit.getServicesManager().getRegistration(CMI.class);
       if (cmiprovider != null) {
       CMIapi = cmiprovider.getProvider();
       }

       try{
           PointsStorageUtil.getPointsFromFile();
       } catch (IOException e) {
           Bukkit.getLogger().warning("Points.json failed to load, go yell at banana");
           Bukkit.getLogger().warning(Arrays.toString(e.getStackTrace()));
       }


        //register stuff
        getServer().getPluginManager().registerEvents(new OnJoin(), this);
        getServer().getPluginManager().registerEvents(new OnMove(), this);
        getServer().getPluginManager().registerEvents(new OnVerySpecificButtonPress(), this);
        getServer().getPluginManager().registerEvents(new OnFish(), this);
        Objects.requireNonNull(this.getCommand("team")).setExecutor(new TeamCommand());
        Objects.requireNonNull(this.getCommand("team")).setTabCompleter(new TeamTabCompleation());
        Objects.requireNonNull(this.getCommand("minigame")).setExecutor(new MinigameCommand());
       Objects.requireNonNull(this.getCommand("minigame")).setTabCompleter(new MinigameTabCompleation());
        Objects.requireNonNull(this.getCommand("Timer")).setExecutor(new TimerCommand());
       Objects.requireNonNull(this.getCommand("checktokens")).setExecutor(new CheckTokensCommand());

       getLogger().info("Survival Island Plugin Started (" + this.getDescription().getVersion() + ")");
    }
    public static World getWorld(){
        return(Bukkit.getWorlds().get(0));
    }

}

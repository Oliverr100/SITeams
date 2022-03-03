package me.banana.siteams.events;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import me.banana.siteams.GTC;
import me.banana.siteams.SITeams;
import me.banana.siteams.Commands.TeamCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class OnMove implements Listener {


    Location pos1;
    Location pos2;
    static Player player;
    public static boolean isfreeze;

    WorldGuardPlugin wgp = SITeams.getWorldGuard();
    @EventHandler
    public void moveEvent(PlayerMoveEvent e){
        Player player = e.getPlayer();              //when player moves check if in region
        enterRegion(player);
        if(isfreeze){
            e.setTo(e.getFrom());
        }

    }
    
    public void enterRegion(Player player){
        LocalPlayer localPlayer = wgp.wrapPlayer(player);           //get worldguard version of player
        BlockVector3 playerVector = localPlayer.getLocation().toVector().toBlockPoint();
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regions = container.get(localPlayer.getWorld());
        assert regions != null;
        ProtectedRegion volcanoRegion = regions.getRegion("volcano");
        ApplicableRegionSet applicableRegionset = regions.getApplicableRegions(playerVector);
        if(applicableRegionset.getRegions().contains(volcanoRegion)){
            player.teleport(GTC.getVolcanoLocation(TeamCommand.getTeam(player), player.getWorld()));
        }

    }

    public static void freeze(){
        isfreeze = true;
        Bukkit.getLogger().info("Freeze On");
    }
    public static void unfreeze(){
        isfreeze = false;
        Bukkit.getLogger().info("freeze Off");
    }

}

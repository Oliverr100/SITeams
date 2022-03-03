package me.banana.siteams.events;

import me.banana.siteams.SITeams;
import me.banana.siteams.GTC;
import net.luckperms.api.model.user.User;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;

import static me.banana.siteams.SITeams.LPapi;


public class OnJoin implements Listener {
                                                //when a player joins make sure they have all needed data
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(!p.getPersistentDataContainer().has(new NamespacedKey(SITeams.getPlugin(), "team"), PersistentDataType.STRING)) {
            p.getPersistentDataContainer().set(new NamespacedKey(SITeams.getPlugin(), "team"), PersistentDataType.STRING, "None");
        }
        if(!p.getPersistentDataContainer().has(new NamespacedKey(SITeams.getPlugin(), "teamChatEnabled"), PersistentDataType.INTEGER)) {
            p.getPersistentDataContainer().set(new NamespacedKey(SITeams.getPlugin(), "teamChatEnabled"), PersistentDataType.INTEGER, 0);
        }
        p.setPlayerListName(GTC.getTeamColor(e.getPlayer()) + p.getDisplayName());
        User LPUser = LPapi.getPlayerAdapter(Player.class).getUser(p);
        String group = LPUser.getPrimaryGroup();


        //add checking user permissions to join a group
    }

}

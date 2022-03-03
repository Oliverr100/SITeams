package me.banana.siteams.subcommands.CheckTokens;

import me.banana.siteams.GTC;
import org.bukkit.*;
import org.bukkit.entity.Player;

import java.util.Objects;

public class CheckTokensSpawn {

    public static void spawn(Player player){
        Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(255, 215, 0), 2.0F);
        for(int i = 1; i < 9; i++){
            Location chestlocation = GTC.getVolcanoChestLocation(i, player.getWorld());
            chestlocation.getBlock().setType(Material.CHEST);
            chestlocation.setZ((chestlocation.getZ() - 1.5));
            chestlocation.setX((chestlocation.getX()));
            chestlocation.setY(chestlocation.getY() + .5);
            for(int i2 = 0; i2 <360; i2+=3){
                chestlocation.setZ(chestlocation.getZ() + Math.cos(i2)*3);
                chestlocation.setX(chestlocation.getX() + Math.sin(i2)*3);
                Objects.requireNonNull(chestlocation.getWorld()).spawnParticle(Particle.REDSTONE, chestlocation, 2, dustOptions);
                Objects.requireNonNull(chestlocation.getWorld()).spawnParticle(Particle.LAVA, chestlocation, 1);
            }
        }


    }


}

package me.banana.siteams.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.banana.siteams.SITeams;
import org.bukkit.Bukkit;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.HashMap;

public class PointsStorageUtil {
    private static HashMap<String, Integer> map = new HashMap<>();

    static {
        map.put("scarletspoons", 0);
        map.put("orangeotters", 0);
        map.put("bronzebarns", 0);
        map.put("yellowyoshis", 0);
        map.put("limeluigis", 0);
        map.put("cobaltchefs", 0);
        map.put("pinkpeppers", 0);
        map.put("magentamarios", 0);
    }

    public static void getPointsFromFile() throws IOException {
        Gson gson = new Gson();
        File file = new File(SITeams.getPlugin().getDataFolder().getAbsoluteFile() + "/points.json");
        Reader reader = Files.newBufferedReader(file.toPath());
        Type typeOf = new TypeToken<HashMap<String, Integer>>() {}.getType();
        map = gson.fromJson(reader, typeOf);
    }


    public static void setPoints(String team, long points){
        map.computeIfPresent(team, (t, v) -> v = Math.toIntExact(points));
    }

    public static Integer getPoints(String team){
        team = team.toLowerCase();
        return map.get(team.toLowerCase());
    }

    public static void savePoints() {
        Gson gson = new Gson();
        File file = new File(SITeams.getPlugin().getDataFolder().getAbsoluteFile() + "/points.json");
        file.getParentFile().mkdir();
        Writer writer;
        try {
            writer = new FileWriter(file, false);
            gson.toJson(map, writer);
            writer.flush();
            writer.close();
            Bukkit.getLogger().info("Points Saved");
        } catch (IOException e) {
            Bukkit.getLogger().warning("Points not saved for some reason go ask banana idk man sorry");
        }
    }

}

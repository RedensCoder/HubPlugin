package com.pherment.pspawn;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class HubConfig {
    private static File file;
    private static FileConfiguration hubConfig;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("pSpawn").getDataFolder(), "HubConfig.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        hubConfig = YamlConfiguration.loadConfiguration(file);
    }

    public static void save() {
        try {
            hubConfig.save(file);
        } catch (IOException e) {
            System.out.println("File couldn't save!");
        }
    }

    public static void reload() {
        hubConfig = YamlConfiguration.loadConfiguration(file);
    }

    /* ===== GETTERS & SETTERS ===== */

    public static FileConfiguration getHubConfig() {
        return hubConfig;
    }
}

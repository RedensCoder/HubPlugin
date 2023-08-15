package com.pherment.pspawn;

import com.pherment.pspawn.commands.pCommands;
import com.pherment.pspawn.commands.pTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class PSpawn extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[pSpawn] Plugin enabled!");

        HubConfig.setup();
        HubConfig.getHubConfig().options().copyDefaults(true);
        if (HubConfig.getHubConfig().getString("location") == null) {
            System.out.println("Hub not location!");
        }
        HubConfig.save();

        getCommand("hub").setExecutor(new pCommands());
        getCommand("hub").setTabCompleter(new pTabCompleter());
    }

    @Override
    public void onDisable() {
        System.out.println("[pSpawn] Plugin disabled!");
    }
}

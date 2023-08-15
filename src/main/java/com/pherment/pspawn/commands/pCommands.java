package com.pherment.pspawn.commands;

import com.pherment.pspawn.HubConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class pCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (args.length != 0 && args[0].equals("set") && player.isOp()) {
            if (HubConfig.getHubConfig().getLocation("location") == null) {
                HubConfig.getHubConfig().addDefault("location", player.getLocation());
                HubConfig.save();
            } else {
                HubConfig.getHubConfig().set("location", player.getLocation());
                HubConfig.save();
            }

            player.sendMessage("Hub installed!");
            return true;
        } else if (args.length == 0) {
            player.teleport(HubConfig.getHubConfig().getLocation("location"));

            return true;
        }

        return false;
    }
}

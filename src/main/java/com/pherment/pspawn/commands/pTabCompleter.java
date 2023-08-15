package com.pherment.pspawn.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class pTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return List.of(
                    "hub",
                    "spawn",
                    "lobby"
            );
        }

        if (args.length == 1 && sender.isOp()) {
            return List.of(
                    "set"
            );
        }

        return null;
    }
}

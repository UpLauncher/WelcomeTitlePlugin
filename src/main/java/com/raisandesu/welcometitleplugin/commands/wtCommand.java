package com.raisandesu.welcometitleplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.raisandesu.welcometitleplugin.welcometitleplugin;

import net.md_5.bungee.api.ChatColor;

public class wtCommand implements CommandExecutor {
    private final welcometitleplugin wt;

    public wtCommand(welcometitleplugin wt) {
        this.wt = wt;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        var prefix = ChatColor.GREEN +  wt.getConfig().getString("messages.prefix") + ChatColor.RESET + " ";
        try {
        if (args[0].contains("version")) {
            if (sender instanceof Player) {
                Player runner = (Player) sender;
                if (runner.hasPermission("wt.commands.standard")) {
                runner.sendMessage(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.version-title")));
                runner.sendMessage(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.version-wt")) + " " + wt.getDescription().getVersion() + " / " + ChatColor.translateAlternateColorCodes('&',  wt.getConfig().getString("messages.version-bukkit")) + " " + Bukkit.getVersion());
                } else {
                    var message = prefix + wt.getConfig().getString("messages.no-permission");

                    runner.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                }
            } else {
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.version-title")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.version-wt")) + " " + wt.getDescription().getVersion() + " / " + ChatColor.translateAlternateColorCodes('&',  wt.getConfig().getString("messages.version-bukkit")) + " " + Bukkit.getVersion());
            }
        } else {    
            if (sender instanceof Player) {
                Player runner = (Player) sender;
                if (runner.hasPermission("wt.commands.standard")) {
                runner.sendMessage(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-title")));
                runner.sendMessage(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-desc")));
                runner.sendMessage(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-cmd1")));
                runner.sendMessage(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-cmd2")));
                runner.sendMessage(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-cmd3")));
                } else {
                    var message = prefix + wt.getConfig().getString("messages.no-permission");

                    runner.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                }
            } else {
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-title")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-desc")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-cmd1")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-cmd2")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-cmd3")));
            }
        }
        } catch (Exception e) {
            if (sender instanceof Player) {
                Player runner = (Player) sender;
                if (runner.hasPermission("wt.commands.standard")) {
                    runner.sendMessage(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-title")));
                    runner.sendMessage(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-desc")));
                    runner.sendMessage(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-cmd1")));
                    runner.sendMessage(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-cmd2")));
                    runner.sendMessage(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-cmd3")));
                } else {
                    var message = prefix + wt.getConfig().getString("messages.no-permission");

                    runner.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                }
            } else {
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-title")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-desc")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-cmd1")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-cmd2")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&', wt.getConfig().getString("messages.help-cmd3")));
            }
        }

        return true;
    }
}

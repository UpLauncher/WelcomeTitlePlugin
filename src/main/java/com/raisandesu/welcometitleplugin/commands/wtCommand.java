package com.raisandesu.welcometitleplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.raisandesu.welcometitleplugin.welcometitleplugin;

import net.md_5.bungee.api.ChatColor;

public class wtCommand implements CommandExecutor {
    private final welcometitleplugin plugin;

    public wtCommand(welcometitleplugin wt) {
        this.plugin = wt;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        var prefix = ChatColor.GREEN +  plugin.getConfig().getString("messages.prefix") + ChatColor.RESET + " ";
        try {
        if (args[0].contains("version")) {
            if (sender instanceof Player) {
                Player runner = (Player) sender;
                if (runner.hasPermission("wt.commands.standard")) {
                runner.sendMessage(ChatColor.AQUA + "WelcomeTitlePlugin");
                runner.sendMessage("バージョン: 1.0.0 / Bukkit: " + Bukkit.getVersion());
                } else {
                    var message = prefix + plugin.getConfig().getString("messages.no-permission");

                    runner.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                }
            } else {
                this.plugin.logger.info(ChatColor.AQUA + "WelcomeTitlePlugin");
                this.plugin.logger.info("バージョン: 1.0.0 / Bukkit: " + Bukkit.getVersion());
            }
        } else {    
            if (sender instanceof Player) {
                Player runner = (Player) sender;
                if (runner.hasPermission("wt.commands.standard")) {
                runner.sendMessage(ChatColor.AQUA + "WelcomeTitlePlugin - ヘルプ");
                runner.sendMessage("以下のコマンドを使用して、このプラグインを操作します。");
                runner.sendMessage(ChatColor.RED + "/wt help" + ChatColor.RESET + " このヘルプを表示します。");
                runner.sendMessage(ChatColor.RED + "/wt version" + ChatColor.RESET + " このプラグインのバージョンを表示します。");
                runner.sendMessage(ChatColor.RED + "/wtreload" + ChatColor.RESET + " このプラグインの設定を再読み込みします。");
                } else {
                    var message = prefix + plugin.getConfig().getString("messages.no-permission");

                    runner.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                }
            } else {
                this.plugin.logger.info(ChatColor.AQUA + "WelcomeTitlePlugin - ヘルプ");
                this.plugin.logger.info("以下のコマンドを使用して、このプラグインを操作します。");
                this.plugin.logger.info(ChatColor.RED + "/wt help" + ChatColor.RESET + " このヘルプを表示します。");
                this.plugin.logger.info(ChatColor.RED + "/wt version" + ChatColor.RESET + " このプラグインのバージョンを表示します。");
                this.plugin.logger.info(ChatColor.RED + "/wtreload" + ChatColor.RESET + " このプラグインの設定を再読み込みします。");
            }
        }
        } catch (Exception e) {
            if (sender instanceof Player) {
                Player runner = (Player) sender;
                if (runner.hasPermission("wt.commands.standard")) {
                runner.sendMessage(ChatColor.AQUA + "WelcomeTitlePlugin - ヘルプ");
                runner.sendMessage("以下のコマンドを使用して、このプラグインを操作します。");
                runner.sendMessage(ChatColor.RED + "/wt help" + ChatColor.RESET + " このヘルプを表示します。");
                runner.sendMessage(ChatColor.RED + "/wt version" + ChatColor.RESET + " このプラグインのバージョンを表示します。");
                runner.sendMessage(ChatColor.RED + "/wtreload" + ChatColor.RESET + " このプラグインの設定を再読み込みします。");
                } else {
                    var message = prefix + plugin.getConfig().getString("messages.no-permission");

                    runner.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                }
            } else {
                this.plugin.logger.info(ChatColor.AQUA + "WelcomeTitlePlugin - ヘルプ");
                this.plugin.logger.info("以下のコマンドを使用して、このプラグインを操作します。");
                this.plugin.logger.info(ChatColor.RED + "/wt help" + ChatColor.RESET + " このヘルプを表示します。");
                this.plugin.logger.info(ChatColor.RED + "/wt version" + ChatColor.RESET + " このプラグインのバージョンを表示します。");
                this.plugin.logger.info(ChatColor.RED + "/wtreload" + ChatColor.RESET + " このプラグインの設定を再読み込みします。");
            }
        }

        return true;
    }
}

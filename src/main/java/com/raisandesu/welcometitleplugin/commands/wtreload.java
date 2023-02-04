package com.raisandesu.welcometitleplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.raisandesu.welcometitleplugin.welcometitleplugin;

import net.md_5.bungee.api.ChatColor;

public class wtreload implements CommandExecutor {
    private final welcometitleplugin wt;

    public wtreload(welcometitleplugin wt) {
        this.wt = wt;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        var prefix = ChatColor.GREEN + wt.getConfig().getString("messages.prefix") + ChatColor.RESET + " ";
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("wt.reload")) {
                this.wt.logger.info("設定の再読み込みが開始されます...");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + wt.getConfig().getString("messages.reloading")));
                this.wt.logger.info("設定を再読み込みしています...");
                wt.reloadConfig();
                this.wt.logger.info("設定を再読み込みしました。");
                this.wt.logger.info("設定の再読み込みが完了しました。");
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix + wt.getConfig().getString("messages.reloaded")));
            } else {
                var message = prefix + wt.getConfig().getString("messages.no-permission");

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
            }
        } else {
            this.wt.logger.info("設定の再読み込みが開始されます...");
                this.wt.logger.info("設定を再読み込みしています...");
                wt.reloadConfig();
                this.wt.logger.info("設定を再読み込みしました。");
                this.wt.logger.info("設定の再読み込みが完了しました。");
        }
        
        return true;
    }
}

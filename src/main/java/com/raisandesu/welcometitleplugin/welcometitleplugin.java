package com.raisandesu.welcometitleplugin;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.raisandesu.welcometitleplugin.commands.*;

import net.md_5.bungee.api.ChatColor;

public final class welcometitleplugin extends JavaPlugin implements Listener {
    public final Logger logger = this.getLogger();
    public welcometitleplugin wt;

    @Override
    public void onEnable() {
        var version = getDescription().getVersion();
        var prefix = ChatColor.GREEN + this.getConfig().getString("messages.prefix");
        this.saveDefaultConfig();
        if (Bukkit.getVersion().contains("Spigot")) {
            logger.info("");
            logger.info(ChatColor.GREEN + " \\ \\      / /_   _|");
            logger.info(ChatColor.GREEN + "  \\ \\ /\\ / /  | |   " + ChatColor.AQUA + "WT" + ChatColor.GREEN + " version " + version);
            if (this.getConfig().getString("messages.plugin-enabling-info-first") == "") {
                logger.info(ChatColor.GREEN + "   \\ V  V /   | |   Bukkit - Spigot " + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("messages.plugin-enabling-info-final")));
            } else {
                logger.info(ChatColor.GREEN + "   \\ V  V /   | |  " + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("messages.plugin-enabling-info-first") + " Bukkit - Spigot"));

            }
            logger.info(ChatColor.GREEN + "    \\_/\\_/    |_|");   
            logger.info("");
            logger.warning(ChatColor.translateAlternateColorCodes('&', prefix + this.getConfig().getString("messages.purpur-title")));
            logger.warning(ChatColor.translateAlternateColorCodes('&', prefix + this.getConfig().getString("messages.purpur-desc1")));
            logger.warning(ChatColor.translateAlternateColorCodes('&', prefix + this.getConfig().getString("messages.purpur-desc2")));
            logger.warning(ChatColor.translateAlternateColorCodes('&', prefix + this.getConfig().getString("messages.purpur-desc3")));
        } else if (Bukkit.getVersion().contains("Paper")) {
            logger.info(ChatColor.GREEN + " \\ \\      / /_   _|");
            logger.info(ChatColor.GREEN + "  \\ \\ /\\ / /  | |   " + ChatColor.AQUA + "WT" + ChatColor.GREEN + " version " + version);
            if (this.getConfig().getString("messages.plugin-enabling-info-first") == "") {
                logger.info(ChatColor.GREEN + "   \\ V  V /   | |   Bukkit - Paper " + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("messages.plugin-enabling-info-final")));
            } else {
                logger.info(ChatColor.GREEN + "   \\ V  V /   | |  " + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("messages.plugin-enabling-info-first")) + " Bukkit - Paper");

            }
            logger.info(ChatColor.GREEN + "    \\_/\\_/    |_|");
            logger.warning(ChatColor.translateAlternateColorCodes('&', prefix + this.getConfig().getString("messages.purpur-title")));
            logger.warning(ChatColor.translateAlternateColorCodes('&', prefix + this.getConfig().getString("messages.purpur-desc1")));
            logger.warning(ChatColor.translateAlternateColorCodes('&', prefix + this.getConfig().getString("messages.purpur-desc2")));
            logger.warning(ChatColor.translateAlternateColorCodes('&', prefix + this.getConfig().getString("messages.purpur-desc3")));
        } else if (Bukkit.getVersion().contains("Purpur")) {
            logger.info(ChatColor.GREEN + " \\ \\      / /_   _|");
            logger.info(ChatColor.GREEN + "  \\ \\ /\\ / /  | |   " + ChatColor.AQUA + "WT" + ChatColor.GREEN + " version " + version);
            if (this.getConfig().getString("messages.plugin-enabling-info-first") == "") {
                logger.info(ChatColor.GREEN + "   \\ V  V /   | |   Bukkit - Purpur " + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("messages.plugin-enabling-info-final")));
            } else {
                logger.info(ChatColor.GREEN + "   \\ V  V /   | |  " + ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("messages.plugin-enabling-info-first")) + " Bukkit - Purpur");

            }
            logger.info(ChatColor.GREEN + "    \\_/\\_/    |_|");
        } else {
            logger.warning(ChatColor.translateAlternateColorCodes('&', prefix + this.getConfig().getString("messages.unknown-title")));
            logger.warning(ChatColor.translateAlternateColorCodes('&', prefix + this.getConfig().getString("messages.unknown-desc1")));
            logger.warning(ChatColor.translateAlternateColorCodes('&', prefix + this.getConfig().getString("messages.unknown-desc2")));
            this.getPluginLoader().disablePlugin(wt);
        }
        logger.info(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("messages.plugin-enabled")));
        getServer().getPluginManager().registerEvents(new userjoined(this), this);
        getCommand("wtreload").setExecutor(new wtreload(this));
        getCommand("wt").setExecutor(new wtCommand(this));
    }

    @Override
    public void onDisable() {
        logger.info(ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("messages.plugin-disabled")));
        Bukkit.getScheduler().cancelTasks(this);
    }

}

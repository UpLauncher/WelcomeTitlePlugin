package com.raisandesu.welcometitleplugin;

import java.util.logging.Logger;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.raisandesu.welcometitleplugin.commands.*;

import net.md_5.bungee.api.ChatColor;

import java.awt.*;
import java.awt.image.BufferedImage;

public final class welcometitleplugin extends JavaPlugin implements Listener {
    public final Logger logger = this.getLogger();
    public welcometitleplugin wt;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        if (Bukkit.getVersion().contains("Spigot")) {
            logger.info("");
            logger.info(ChatColor.GREEN + " \\ \\      / /_   _|");
            logger.info(ChatColor.GREEN + "  \\ \\ /\\ / /  | |   " + ChatColor.AQUA + "WT" + ChatColor.GREEN + " version 1.0.0");
            logger.info(ChatColor.GREEN + "   \\ V  V /   | |   Bukkit - Spigot で実行中");
            logger.info(ChatColor.GREEN + "    \\_/\\_/    |_|");   
            logger.info("");
            logger.warning("-------Purpurを使用する-------");
            logger.warning("Purpur を使用することで、Paper より高いパフォーマンス");
            logger.warning("と便利で簡単な機能を手に入れることができます。");
            logger.warning("tpsbar がデフォルトでついていたり、サーバー名を変更できます。");
        } else if (Bukkit.getVersion().contains("Paper")) {
            logger.info(ChatColor.GREEN + " \\ \\      / /_   _|");
            logger.info(ChatColor.GREEN + "  \\ \\ /\\ / /  | |   " + ChatColor.AQUA + "WT" + ChatColor.GREEN + " version 1.0.0");
            logger.info(ChatColor.GREEN + "   \\ V  V /   | |   Bukkit - Paper で実行中");
            logger.info(ChatColor.GREEN + "    \\_/\\_/    |_|");
            logger.warning("-------Purpurを使用する-------");
            logger.warning("Purpur を使用することで、Paper より高いパフォーマンス");
            logger.warning("と便利で簡単な機能を手に入れることができます。");
            logger.warning("tpsbar がデフォルトでついていたり、サーバー名を変更できます。");
        } else if (Bukkit.getVersion().contains("Purpur")) {
            logger.info(ChatColor.GREEN + " \\ \\      / /_   _|");
            logger.info(ChatColor.GREEN + "  \\ \\ /\\ / /  | |   " + ChatColor.AQUA + "WT" + ChatColor.GREEN + " version 1.0.0");
            logger.info(ChatColor.GREEN + "   \\ V  V /   | |   Bukkit - Purpur で実行中");
            logger.info(ChatColor.GREEN + "    \\_/\\_/    |_|");
        } else {
            logger.warning("-------不明なBukkit-------");
            logger.warning("この不明な Bukkit では、確認されていないため実行できません。");
            logger.warning("Purpur をおすすめします: https://purpurmc.org");
            this.getPluginLoader().disablePlugin(wt);
        }
        logger.info(ChatColor.AQUA + "WelcomeTitlePlugin " + ChatColor.GREEN + "が有効になりました。");
        getServer().getPluginManager().registerEvents(new userjoined(this), this);
        getCommand("wtreload").setExecutor(new wtreload(this));
        getCommand("wt").setExecutor(new wtCommand(this));
    }

    @Override
    public void onDisable() {
        logger.info("WelcomeTitlePlugin が無効になりました。");
        Bukkit.getScheduler().cancelTasks(this);
    }

}

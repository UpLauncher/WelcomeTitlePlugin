package tech.raic.welcometitleplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tech.raic.welcometitleplugin.welcometitleplugin;

import net.md_5.bungee.api.ChatColor;

public class wtCommand implements CommandExecutor {
    private final welcometitleplugin wt;

    public wtCommand(welcometitleplugin wt) {
        this.wt = wt;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        var prefix = ChatColor.GREEN + wt.getConfig().getString("messages.prefix") + ChatColor.RESET
                + " ";
        try {
            if (args[0].contains("version")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.hasPermission("wt.commands.standard")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                wt.getConfig().getString("messages.version-title")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                wt.getConfig().getString("messages.version-wt")) + " "
                                + wt.getDescription().getVersion() + " / "
                                + ChatColor.translateAlternateColorCodes('&',
                                        wt.getConfig().getString("messages.version-bukkit"))
                                + " " + Bukkit.getVersion());
                    } else {
                        var message = prefix + wt.getConfig().getString("messages.no-permission");

                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                    }
                } else {
                    this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                            wt.getConfig().getString("messages.version-title")));
                    this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                            wt.getConfig().getString("messages.version-wt")) + " "
                            + wt.getDescription().getVersion() + " / "
                            + ChatColor.translateAlternateColorCodes('&',
                                    wt.getConfig().getString("messages.version-bukkit"))
                            + " " + Bukkit.getVersion());
                }
            } else if (args[0].contains("reload")) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.hasPermission("wt.reload")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                prefix + wt.getConfig().getString("messages.reloading")));
                        wt.reloadConfig();
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                prefix + wt.getConfig().getString("messages.reloaded")));
                    } else {
                        var message = prefix + wt.getConfig().getString("messages.no-permission");

                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                    }
                } else {
                    this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                            prefix + wt.getConfig().getString("messages.reloading")));
                    wt.reloadConfig();
                    this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                            prefix + wt.getConfig().getString("messages.reloaded")));
                }
            } else {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (player.hasPermission("wt.commands.standard")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                wt.getConfig().getString("messages.help-title")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                wt.getConfig().getString("messages.help-desc")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                wt.getConfig().getString("messages.help-cmd1")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                wt.getConfig().getString("messages.help-cmd2")));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                wt.getConfig().getString("messages.help-cmd3")));
                    } else {
                        var message = prefix + wt.getConfig().getString("messages.no-permission");

                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                    }
                } else {
                    this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                            wt.getConfig().getString("messages.help-title")));
                    this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                            wt.getConfig().getString("messages.help-desc")));
                    this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                            wt.getConfig().getString("messages.help-cmd1")));
                    this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                            wt.getConfig().getString("messages.help-cmd2")));
                    this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                            wt.getConfig().getString("messages.help-cmd3")));
                }
            }
        } catch (

        Exception e) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("wt.commands.standard")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            wt.getConfig().getString("messages.help-title")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            wt.getConfig().getString("messages.help-desc")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            wt.getConfig().getString("messages.help-cmd1")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            wt.getConfig().getString("messages.help-cmd2")));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                            wt.getConfig().getString("messages.help-cmd3")));
                } else {
                    var message = prefix + wt.getConfig().getString("messages.no-permission");

                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
                }
            } else {
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                        wt.getConfig().getString("messages.help-title")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                        wt.getConfig().getString("messages.help-desc")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                        wt.getConfig().getString("messages.help-cmd1")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                        wt.getConfig().getString("messages.help-cmd2")));
                this.wt.logger.info(ChatColor.translateAlternateColorCodes('&',
                        wt.getConfig().getString("messages.help-cmd3")));
            }
        }

        return true;
    }
}

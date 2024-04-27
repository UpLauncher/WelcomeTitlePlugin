package tech.raic.welcometitleplugin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import net.md_5.bungee.api.ChatColor;

public class userjoined implements Listener {
    private final welcometitleplugin wt;

    public userjoined(welcometitleplugin wt) {
        this.wt = wt;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        var player = event.getPlayer();
        var enabled = wt.getConfig().getString("enabled");

        if (enabled.contains("true") && player.hasPermission("wt.show")) {
            var title = wt.getConfig().getString("welcome-title.title");
            var subtitle = wt.getConfig().getString("welcome-title.sub-title");
            var fadein = Integer.parseInt(wt.getConfig().getString("welcome-title.fadein"));
            var stay = Integer.parseInt(wt.getConfig().getString("welcome-title.time"));
            var fadeout = Integer.parseInt(wt.getConfig().getString("welcome-title.fadeout"));

            player.sendTitle(ChatColor.translateAlternateColorCodes('&', title),
                    ChatColor.translateAlternateColorCodes('&', subtitle), fadein, stay, fadeout);
        }
    }
}

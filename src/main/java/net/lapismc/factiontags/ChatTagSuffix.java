package net.lapismc.factiontags;

import com.dthielke.herochat.ChannelChatEvent;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class ChatTagSuffix implements Listener {

    private Config config;

    ChatTagSuffix(Plugin p, Config config) {
        Bukkit.getPluginManager().registerEvents(this, p);
        this.config = config;
    }

    @EventHandler
    public void onPlayerChat(ChannelChatEvent e) {
        Player p = e.getSender().getPlayer();
        e.setFormat(e.getFormat().replace("{tags_suffix}", getReplacement(p)));
    }

    private String getReplacement(Player sender) {
        MPlayer usender = MPlayer.get(sender);
        Faction faction = usender.getFaction();
        if (faction.isNone()) {
            return "";
        }
        return config.TAG_SUFFIX;
    }
}

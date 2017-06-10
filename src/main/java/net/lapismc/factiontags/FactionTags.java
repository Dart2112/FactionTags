package net.lapismc.factiontags;

import com.massivecraft.factions.chat.ChatFormatter;
import org.bukkit.plugin.java.JavaPlugin;

public class FactionTags extends JavaPlugin {

    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("Factions") != null) {
            ChatFormatter.registerTag(ChatTagSuffix.get());
            ChatFormatter.registerTag(ChatTagPrefix.get());
        }
    }
}

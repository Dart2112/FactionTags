package net.lapismc.factiontags;

import org.bukkit.plugin.java.JavaPlugin;

public class FactionTags extends JavaPlugin {

    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("Factions") != null) {
            ChatTagSuffix.get().setActive(true);
            ChatTagPrefix.get().setActive(true);
        }
    }
}

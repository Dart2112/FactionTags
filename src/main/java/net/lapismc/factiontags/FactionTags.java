package net.lapismc.factiontags;

import org.bukkit.plugin.java.JavaPlugin;

public class FactionTags extends JavaPlugin {

    Config config = new Config(this);

    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("Factions") != null) {
            new ChatTagSuffix(this, config);
            new ChatTagPrefix(this, config);
        }
    }
}

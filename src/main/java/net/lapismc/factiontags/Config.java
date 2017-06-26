package net.lapismc.factiontags;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Config extends CoreConfig {
    String TAG_PREFIX;
    String TAG_SUFFIX;

    Config(JavaPlugin plugin) {
        super(plugin);
    }

    protected void setDefaults() {
        setDefault("Chat_Tag.Prefix", "&8[&9");
        setDefault("Chat_Tag.Suffix", "&8]&7=");
    }

    protected void loadSettings() {
        TAG_PREFIX = ChatColor.translateAlternateColorCodes('&', this.config.getString("Chat_Tag.Prefix"));
        TAG_SUFFIX = ChatColor.translateAlternateColorCodes('&', this.config.getString("Chat_Tag.Suffix"));
    }

}

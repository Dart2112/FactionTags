package net.lapismc.factiontags;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Config extends CoreConfig {
    static String TAG_PREFIX;
    static String TAG_SUFFIX;

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

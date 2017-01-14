package net.lapismc.factiontags;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Config
        extends CoreConfig {
    public static String TAG_PREFIX;
    public static String TAG_SUFFIX;

    public Config(JavaPlugin plugin) {
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

    public void save() {
        try {
            this.config.save(this.configFile);
        } catch (IOException e) {
            this.logger.log(Level.WARNING, "Could not save config.yml", e);
        }
    }
}

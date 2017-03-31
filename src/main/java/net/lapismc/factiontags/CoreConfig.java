package net.lapismc.factiontags;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public abstract class CoreConfig {

    final FileConfiguration config;

    CoreConfig(JavaPlugin plugin) {
        this(plugin, "config.yml");
    }

    private CoreConfig(JavaPlugin plugin, String fileName) {
        plugin.getDataFolder().mkdirs();
        File configFile = new File(plugin.getDataFolder(), fileName);
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                plugin.getLogger().log(Level.SEVERE, "Could not create " + fileName, e);
            }
        }
        this.config = YamlConfiguration.loadConfiguration(configFile);

        setDefaults();
        try {
            this.config.save(configFile);
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Could not save " + fileName, e);
        }
        loadSettings();
    }

    protected abstract void setDefaults();

    protected abstract void loadSettings();

    void setDefault(String setting, Object defaultValue) {
        if (!this.config.contains(setting)) {
            this.config.set(setting, defaultValue);
        }
    }
}

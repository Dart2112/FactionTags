package net.lapismc.factiontags;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class CoreConfig
{
  protected final FileConfiguration config;
  protected final File configFile;
  protected final Logger logger;
  
  public CoreConfig(JavaPlugin plugin)
  {
    this(plugin, "config.yml");
  }
  
  public CoreConfig(JavaPlugin plugin, String fileName)
  {
    this.logger = plugin.getLogger();
    plugin.getDataFolder().mkdirs();
    this.configFile = new File(plugin.getDataFolder(), fileName);
    if (!this.configFile.exists()) {
      try
      {
        this.configFile.createNewFile();
      }
      catch (IOException e)
      {
        plugin.getLogger().log(Level.SEVERE, "Could not create " + fileName, e);
      }
    }
    this.config = YamlConfiguration.loadConfiguration(this.configFile);
    
    setDefaults();
    try
    {
      this.config.save(this.configFile);
    }
    catch (IOException e)
    {
      plugin.getLogger().log(Level.SEVERE, "Could not save " + fileName, e);
    }
    loadSettings();
  }
  
  protected abstract void setDefaults();
  
  protected abstract void loadSettings();
  
  protected void setDefault(String setting, Object defaultValue)
  {
    if (!this.config.contains(setting)) {
      this.config.set(setting, defaultValue);
    }
  }
}

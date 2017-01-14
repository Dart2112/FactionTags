package net.lapismc.factiontags;

import com.massivecraft.factions.chat.ChatFormatter;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FactionTags
  extends JavaPlugin
{
  private Config config;
  
  public void onLoad()
  {
    this.config = new Config(this);
  }
  
  public void onEnable()
  {
    if (getServer().getPluginManager().getPlugin("Factions") != null)
    {
      ChatFormatter.registerTag(ChatTagSuffix.get());
      ChatFormatter.registerTag(ChatTagPrefix.get());
    }
  }
  
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if ((!(sender instanceof Player)) && (command.getName().equalsIgnoreCase("factiontags")))
    {
      this.config = new Config(this);
      sender.sendMessage("Reloaded!");
      return true;
    }
    return false;
  }
}

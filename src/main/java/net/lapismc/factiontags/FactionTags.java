package net.lapismc.factiontags;

import com.massivecraft.factions.chat.ChatFormatter;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FactionTags extends JavaPlugin {

    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("Factions") != null) {
            ChatFormatter.registerTag(ChatTagSuffix.get());
            ChatFormatter.registerTag(ChatTagPrefix.get());
        }
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) && (command.getName().equalsIgnoreCase("factiontags"))) {
            sender.sendMessage("Reloaded!");
            return true;
        }
        return false;
    }
}

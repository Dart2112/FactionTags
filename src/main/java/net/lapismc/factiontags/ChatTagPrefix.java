package net.lapismc.factiontags;

import com.massivecraft.factions.chat.ChatTagAbstract;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import org.bukkit.command.CommandSender;

public class ChatTagPrefix extends ChatTagAbstract {
    private static ChatTagPrefix i = new ChatTagPrefix();

    private ChatTagPrefix() {
        super("factions_prefix");
    }

    static ChatTagPrefix get() {
        return i;
    }

    public String getReplacement(CommandSender sender, CommandSender recipient) {
        MPlayer usender = MPlayer.get(sender);

        Faction faction = usender.getFaction();
        if (faction.isNone()) {
            return "";
        }
        return Config.TAG_PREFIX;
    }
}

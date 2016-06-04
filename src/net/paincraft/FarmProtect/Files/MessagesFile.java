package net.paincraft.FarmProtect.Files;

import net.paincraft.FarmProtect.Main;
import net.paincraft.FarmProtect.Utilities.ConfigUtil;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

/**
 * 
 * @author ElSheriff
 *
 */

public class MessagesFile implements Listener {
    public static Main plugin;
  
    public MessagesFile(Main instance) {
    plugin = instance;
    }

    public static void loadMessagesConfig() {
    plugin.messagesFile = new ConfigUtil(Main.getInstance(), null, "messages.yml");

    FileConfiguration fileConfiguration = plugin.messagesFile.getConfig();

    fileConfiguration.options().header("Customize all messages to your liking.");
    fileConfiguration.addDefault("messages.only-player", "&cError: &fYou must be a player to execute this command.");
    fileConfiguration.addDefault("messages.reload-config", "&aThe configuration has been successfully reloaded.");
    fileConfiguration.addDefault("messages.no-premission", "&cError: &fYou do not have permission to execute this command.");

    fileConfiguration.options().copyHeader(true);
    fileConfiguration.options().copyDefaults(true);

    plugin.messagesFile.saveConfig();
    plugin.messagesFile.reloadConfig();
    }}
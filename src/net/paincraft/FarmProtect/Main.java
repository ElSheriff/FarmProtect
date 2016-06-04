package net.paincraft.FarmProtect;

import net.paincraft.FarmProtect.Commands.FarmProtectCommand;
import net.paincraft.FarmProtect.Files.MessagesFile;
import net.paincraft.FarmProtect.Listeners.EntityInteractListener;
import net.paincraft.FarmProtect.Listeners.PlayerInteractListener;
import net.paincraft.FarmProtect.Utilities.ConfigUtil;
import net.paincraft.FarmProtect.Utilities.UpdateCheckerUtil;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author ElSheriff
 *
 */

public class Main extends JavaPlugin implements Listener {
    private static Main instance;
    public static ConfigUtil messagesFile;

    public static Main getInstance() {
    return instance;
    }

    public void startPlugin() {
    registerCommands();
    registerFiles();
    loadFiles();
    registerListeners();
    }

    @Override
    public void onEnable() {
    instance = this;
    getServer().getConsoleSender().sendMessage(UpdateCheckerUtil.getInstance().ConsoleUpdateChecker());

    startPlugin();
    saveDefaultConfig();
    }

    @Override
    public void onDisable() {
    saveDefaultConfig();
    }

    // Register the commands of the plugin.
    public void registerCommands() {
    getCommand("farmprotect").setExecutor(new FarmProtectCommand(this));

    getServer().getPluginManager().registerEvents(new FarmProtectCommand(this), this);
    }

    // Register the files of the plugin.
    public void registerFiles() {
    getServer().getPluginManager().registerEvents(new MessagesFile(this), this);
    }

    // Load the files of the plugin.
    public void loadFiles() {
    MessagesFile.loadMessagesConfig();
    }

    // Register the listeners of the plugin.
    public void registerListeners() {
    getServer().getPluginManager().registerEvents(this, this);
    getServer().getPluginManager().registerEvents(new EntityInteractListener(this), this);
    getServer().getPluginManager().registerEvents(new PlayerInteractListener(this), this);
    }}
package net.paincraft.FarmProtect.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigUtil {
    private static JavaPlugin plugin;
    private static FileConfiguration config;
    private static File configFile;
    private static String folderName;
    private static String fileName;
  
    public ConfigUtil(JavaPlugin instance, String folderName, String fileName) {
    this.plugin = instance;
    this.folderName = folderName;
    this.fileName = fileName;
    }
  
    public void createFile(String message, String header) {
    reloadConfig();
    saveConfig();
    loadConfig(message);
    if (header != null) {
    this.plugin.getLogger().info(header);
    }}
  
    public FileConfiguration getConfig() {
    if (this.config == null) {
    reloadConfig();
    }
    return this.config;
    }
  
    public void loadConfig(String message) {
    this.config.options().header(message);
    this.config.options().copyDefaults(true);
    saveConfig();
    }
  
    public void reloadConfig() {
    if (this.configFile == null) {
    if ((this.folderName != null) && (!this.folderName.isEmpty())) {
    this.configFile = new File(this.plugin.getDataFolder() + File.separator + this.folderName, this.fileName);
    } else {
    this.configFile = new File(this.plugin.getDataFolder(), this.fileName);
    }}
    this.config = YamlConfiguration.loadConfiguration(this.configFile);
    }
  
    public void saveConfig() {
    if ((this.config == null) || (this.configFile == null)) {
    return;
    }
    try {
    getConfig().save(this.configFile);
    } catch (IOException exception) {
    this.plugin.getLogger().log(Level.SEVERE, "Could not save config to " + this.configFile, exception);
    }}}
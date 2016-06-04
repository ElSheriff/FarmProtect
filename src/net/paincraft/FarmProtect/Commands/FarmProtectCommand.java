package net.paincraft.FarmProtect.Commands;

import net.paincraft.FarmProtect.Main;
import net.paincraft.FarmProtect.Utilities.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

/**
 * 
 * @author ElSheriff
 *
 */

public class FarmProtectCommand implements CommandExecutor, Listener {
    public static Main plugin;

    public FarmProtectCommand(Main instance) {
    this.plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] arguments) {
    if (!(sender instanceof Player)) {
    sender.sendMessage(ColorUtil.getColor(plugin.messagesFile.getConfig().getString("messages.only-player")));
    return true;
    }
    Player player = (Player)sender;
    if (command.getName().equalsIgnoreCase("farmprotect")) {
    if (arguments.length < 1) {
    player.sendMessage("§2§m====================================");
    player.sendMessage("§f ");
    player.sendMessage(" §9FarmProtect §6by §dElSheriff");
    player.sendMessage(" §aReload Configuration: §e/farmprotect reload");
    player.sendMessage("§f ");
    player.sendMessage("§2§m====================================");
    } else if (player.hasPermission("farmprotect.command.reload")) {
    if (arguments[0] == "reload") {}
    plugin.reloadConfig();
    plugin.saveDefaultConfig();
    // Message reload config.
    player.sendMessage(ColorUtil.getColor(plugin.messagesFile.getConfig().getString("messages.reload-config")));
    } else {
    // Message no-permission.
    player.sendMessage(ColorUtil.getColor(plugin.messagesFile.getConfig().getString("messages.no-premission")));
    }}
    return false;
    }}
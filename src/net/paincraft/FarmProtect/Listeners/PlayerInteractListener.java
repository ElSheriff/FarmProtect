package net.paincraft.FarmProtect.Listeners;

import net.paincraft.FarmProtect.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * 
 * @author ElSheriff
 *
 */

public class PlayerInteractListener implements Listener {
    public static Main plugin;

    public PlayerInteractListener(Main instance) {
    this.plugin = instance;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
    Player player = (Player)event.getPlayer();
    if (plugin.getConfig().getBoolean("options.enabled", true) && (!player.hasPermission(plugin.getConfig().getString("options.permission"))) && (event.getAction() == Action.PHYSICAL) && (event.getClickedBlock().getType() == Material.SOIL) && (plugin.getConfig().getStringList("support-worlds").contains(player.getWorld().getName()))) {
    event.setCancelled(true);
    } else {
    event.setCancelled(false);
    }}}
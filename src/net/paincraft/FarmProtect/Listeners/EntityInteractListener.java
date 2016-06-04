package net.paincraft.FarmProtect.Listeners;

import net.paincraft.FarmProtect.Main;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;

/**
 * 
 * @author ElSheriff
 *
 */

public class EntityInteractListener implements Listener {
    public static Main plugin;

    public EntityInteractListener(Main instance) {
    this.plugin = instance;
    }

    @EventHandler
    public void onEntityInteract(EntityInteractEvent event) {
    if (plugin.getConfig().getBoolean("options.enabled", true) && (!event.getEntity().hasPermission(plugin.getConfig().getString("options.permission")) && (event.getEntityType() != EntityType.PLAYER) && (event.getBlock().getType() == Material.SOIL) && (plugin.getConfig().getStringList("support-worlds").contains(event.getEntity().getWorld().getName())))) {
    event.setCancelled(true);
    } else {
    event.setCancelled(false);
    }}}
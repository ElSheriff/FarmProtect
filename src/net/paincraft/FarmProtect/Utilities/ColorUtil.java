package net.paincraft.FarmProtect.Utilities;

import org.bukkit.ChatColor;

/**
 * 
 * @author ElSheriff
 *
 */

public class ColorUtil {

    // ColorAPI getColor(String);
    public static String getColor(String message) {
    return ChatColor.translateAlternateColorCodes('&', message);
    }

    // ColorAPI getColorConsole(String);
    public static String getColorConsole(String message) {
    return message.replaceAll("&", "\u00A7");
    }}
package com.thejoeyl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatManager extends JavaPlugin implements Listener {

    @EventHandler
    public void badWords(AsyncPlayerChatEvent event) {
        for (String word : event.getMessage().split(" ")) {
            if (!getConfig().getStringList("badwords").contains(word)) continue;
            
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "DONT CURSE!");
        }
    }

    public void onEnable() {
        //Copy default config if not existing
        getConfig().options().copyDefaults(true);
        saveConfig();
        
        // Registering listeners
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new ListenerToStaff(),this);
        getServer().getPluginManager().registerEvents(new ChatColorCheck(),this);
        
        //Registering commands
        getCommand("warn").setExecutor(new Warn());
        getCommand("warnings").setExecutor(new Warnings());
        getCommand("warningsremove").setExecutor(new WarningsRemove());
        getCommand("warningsclear").setExecutor(new WarningsClear());
        getCommand("sthelp").setExecutor(new StaffHelp());
        getCommand("hetisstil").setExecutor(new Memes());
        getCommand("chatcolorblue").setExecutor(new ColorChat());
        getCommand("chatcolorreset").setExecutor(new ColorChat());
        getCommand("chatcolorred").setExecutor(new ColorChat());
        getCommand("chatcoloryellow").setExecutor(new ColorChat());
    }
}

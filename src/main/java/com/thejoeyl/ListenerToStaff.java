package com.thejoeyl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ListenerToStaff implements Listener {
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();
        if (message.toLowerCase().contains("staff")) {
            String staffMessage = message.toLowerCase().replace("staff",
                    ChatColor.GREEN + "staff" + ChatColor.RESET);
            
            event.setCancelled(true);
            Bukkit.broadcast("<" + player.getName() + "> " + staffMessage, "ChatManager.staff");
            Bukkit.broadcast("<" + player.getName() + "> " + chat, "ChatManager.default");
        }
    }
}

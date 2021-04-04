package de.legoshi.speedplugin.listener;

import de.legoshi.speedplugin.utils.NametagChanger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

      @EventHandler
      public void onChat(AsyncPlayerChatEvent event) {
            event.setCancelled(true);
            for(Player all : Bukkit.getOnlinePlayers())
                  all.sendMessage(NametagChanger.getTag(event.getPlayer()) + event.getPlayer().getName() + ": " + ChatColor.WHITE + event.getMessage());
      }

}

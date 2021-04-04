package de.legoshi.speedplugin.listener;

import de.legoshi.speedplugin.Speedplugin;
import de.legoshi.speedplugin.utils.NametagChanger;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

      @EventHandler
      public void onJoin(PlayerJoinEvent event) {

            Player player = event.getPlayer();
            NametagChanger.setTag(player);

            event.setJoinMessage(ChatColor.GREEN + event.getPlayer().getName() + " just joined!");

            Speedplugin.getInstance().playerObjectManager.joinPlayer(player);
            Speedplugin.getInstance().checkPointManager.joinPlayer(player);
            Speedplugin.getInstance().inventoryObjectManager.joinPlayer(player);
            Speedplugin.getInstance().inventoryObject.setBuild(player);

      }
}

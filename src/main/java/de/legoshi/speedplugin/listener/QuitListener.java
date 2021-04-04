package de.legoshi.speedplugin.listener;

import de.legoshi.speedplugin.Speedplugin;
import de.legoshi.speedplugin.checkpoint.CheckPointManager;
import de.legoshi.speedplugin.inventory.InventoryObjectManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

      @EventHandler
      public void onQuit(PlayerQuitEvent event) {

            CheckPointManager cpo = Speedplugin.getInstance().checkPointManager;
            InventoryObjectManager iom = Speedplugin.getInstance().inventoryObjectManager;

            event.setQuitMessage(ChatColor.RED + event.getPlayer().getName() + " just left!");

            Player p = event.getPlayer();
            cpo.getCheckpoint().remove(p);
            iom.getInventoryObjectManager().remove(p);

      }
}

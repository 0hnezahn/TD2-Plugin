package de.legoshi.speedplugin.listener;

import de.legoshi.speedplugin.Speedplugin;
import de.legoshi.speedplugin.clicker.ItemClickManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBlockDestroyListener implements Listener {

      @EventHandler
      public void onDestroy(BlockBreakEvent e) {
            ItemClickManager iM = Speedplugin.getInstance().itemClickManager;

            if(!e.getPlayer().hasPermission("build")) return;

            if(iM.isCorrectItem(e.getPlayer())) {
                  e.setCancelled(true);
            }
      }
}

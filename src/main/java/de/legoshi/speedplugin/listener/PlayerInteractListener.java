package de.legoshi.speedplugin.listener;

import de.legoshi.speedplugin.Speedplugin;
import de.legoshi.speedplugin.clicker.ItemClickManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

      @EventHandler
      public void onItemInHand(PlayerInteractEvent e) {

            Player p = e.getPlayer();
            Action a = e.getAction();
            ItemClickManager iM = Speedplugin.getInstance().itemClickManager;

            if((Action.RIGHT_CLICK_AIR == a || Action.RIGHT_CLICK_BLOCK == a) && !(iM.isHandEmpty(p))) {

                  iM.redDyeRight(e);

            } else if((Action.LEFT_CLICK_AIR == a || Action.LEFT_CLICK_BLOCK == a) && !(iM.isHandEmpty(p))) {

                  iM.redDyeLeft(e);

            }
      }
}

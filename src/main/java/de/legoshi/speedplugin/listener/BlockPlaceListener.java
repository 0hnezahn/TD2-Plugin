package de.legoshi.speedplugin.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

      @EventHandler
      public void onBlockPlace(BlockPlaceEvent event) {

            if(!event.getPlayer().hasPermission("build")) return;

            //no fire no tnt
            if( event.getBlockPlaced().getType().equals(Material.FIRE) ||
                event.getBlockPlaced().getType().equals(Material.TNT) ||
                event.getBlockPlaced().getType().equals(Material.BARRIER) ||
                event.getBlockPlaced().getType().equals(Material.COMMAND) ||
                event.getBlockPlaced().getType().equals(Material.OBSERVER) ||
                event.getBlockPlaced().getType().equals(Material.PISTON_STICKY_BASE)) {

                  event.getPlayer().sendMessage("You cant place this Block.");
                  event.setCancelled(true);
                  return;

            }

      }

}

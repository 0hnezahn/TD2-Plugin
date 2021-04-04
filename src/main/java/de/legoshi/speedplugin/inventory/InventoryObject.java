package de.legoshi.speedplugin.inventory;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class InventoryObject {

      Player player;
      Inventory inventory;
      String mode;

      public InventoryObject(Player player) {
            this.player = player;
            this.inventory = player.getInventory();
            mode = "build";
      }

      public InventoryObject() {}

      public Player getPlayer() {
            return this.player;
      }

      public Inventory getInventory() {
            return this.inventory;
      }

      public String getMode() {
            return this.mode;
      }

      public void setBuild(Player player) {
            player.getInventory().clear();
            this.mode = "build";

            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§l§6Practice");

            ItemStack red = new ItemStack(Material.INK_SACK, 1, (short)1);
            ItemMeta metared = red.getItemMeta();
            metared.setLore(lore);
            metared.setDisplayName("§lCheckpoint");
            red.setItemMeta(metared);

            ItemStack arrow = new ItemStack(Material.ARROW, 1);
            ItemStack redstone = new ItemStack(Material.REDSTONE, 1);

            player.getInventory().setItem(0, red);
            //player.getInventory().setItem(7, redstone);
            //player.getInventory().setItem(8, arrow);

      }

}

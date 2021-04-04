package de.legoshi.speedplugin;

import de.legoshi.speedplugin.checkpoint.CheckPointManager;
import de.legoshi.speedplugin.clicker.ItemClickManager;
import de.legoshi.speedplugin.inventory.InventoryObject;
import de.legoshi.speedplugin.inventory.InventoryObjectManager;
import de.legoshi.speedplugin.listener.*;
import de.legoshi.speedplugin.playerutils.PlayerObjectManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Speedplugin extends JavaPlugin {

      public static Speedplugin instance;
      public CheckPointManager checkPointManager;
      public ItemClickManager itemClickManager;
      public PlayerObjectManager playerObjectManager;
      public InventoryObjectManager inventoryObjectManager;
      public InventoryObject inventoryObject;

      @Override
      public void onEnable() {
            instance = this;

            checkPointManager = new CheckPointManager();
            itemClickManager = new ItemClickManager();
            playerObjectManager = new PlayerObjectManager();
            inventoryObjectManager = new InventoryObjectManager();
            inventoryObject = new InventoryObject();


            CommandRegistration();
            ListenerRegistration();

      }

      private void ListenerRegistration() {
            PluginManager pm = Bukkit.getPluginManager();
            pm.registerEvents(new JoinListener(), this);
            pm.registerEvents(new QuitListener(), this);
            pm.registerEvents(new PlayerInteractListener(), this);
            pm.registerEvents(new PlayerBlockDestroyListener(), this);
            pm.registerEvents(new BlockPlaceListener(), this);
            pm.registerEvents(new CancelListener(), this);
            pm.registerEvents(new ChatListener(), this);
      }

      @Override
      public void onDisable() {
            // Plugin shutdown logic
      }

      private void CommandRegistration() {

            getCommand("potspeed").setExecutor(new SpeedCommand());

      }

      public static Speedplugin getInstance() {
            return instance;
      }
}

package de.legoshi.speedplugin.playerutils;

import org.bukkit.entity.Player;


public class PlayerObject {

      Player player;

      public PlayerObject(Player player) {
            this.player = player;
      }

      public Player getPlayer() {
            return this.player;
      }

}

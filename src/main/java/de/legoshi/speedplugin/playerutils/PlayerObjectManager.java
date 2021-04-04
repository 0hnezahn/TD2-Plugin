package de.legoshi.speedplugin.playerutils;

import com.sun.deploy.cache.BaseLocalApplicationProperties;
import de.legoshi.speedplugin.Speedplugin;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerObjectManager {

      HashMap<Player, PlayerObject> playerObject;

      public PlayerObjectManager() {
            this.playerObject = new HashMap<Player, PlayerObject>();
      }

      public HashMap<Player, PlayerObject> getPlayerObject() {
            return this.playerObject;
      }

      public void joinPlayer(Player player) {
            PlayerObjectManager playerObjectManager = Speedplugin.getInstance().playerObjectManager;
            playerObjectManager.playerObject.put(player, new PlayerObject(player));
      }

}

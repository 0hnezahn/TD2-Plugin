package de.legoshi.speedplugin.checkpoint;

import de.legoshi.speedplugin.Speedplugin;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CheckPointManager {

      HashMap<Player, CheckPointObject> checkpoint;

      public CheckPointManager() {
            this.checkpoint = new HashMap<Player, CheckPointObject>();
      }

      public HashMap<Player, CheckPointObject> getCheckpoint() {
            return this.checkpoint;
      }

      public void joinPlayer(Player player) {
            CheckPointManager checkPointManager = Speedplugin.getInstance().checkPointManager;
            checkPointManager.getCheckpoint().put(player, new CheckPointObject(player));
      }
}

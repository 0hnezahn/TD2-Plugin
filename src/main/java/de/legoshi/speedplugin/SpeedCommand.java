package de.legoshi.speedplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SpeedCommand implements CommandExecutor {

      @Override
      public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if(!(sender instanceof Player)) return false;

            Player player = ((Player) sender).getPlayer();

            if(args.length == 0) {

                  player.sendMessage("Syntax /potspeed <speedvalue>");
                  return false;

            }

            int speed = 0;

            try {

                  speed = Integer.parseInt(args[0]);
                  if(speed>100 || speed<0) {

                        player.sendMessage("Please enter a number from 0-100");
                        return false;

                  }

            } catch (NumberFormatException e) {

                  player.sendMessage("Please enter a number");
                  return false;

            }

            player.addPotionEffect(PotionEffectType.SPEED.createEffect(100000, speed));
            player.sendMessage("Successfully set your speed to " + (speed+1));

            return false;

      }

}

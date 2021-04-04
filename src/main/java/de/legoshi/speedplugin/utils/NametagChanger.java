package de.legoshi.speedplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import org.bukkit.scoreboard.NameTagVisibility;

public class NametagChanger {

      private static Team team;
      private static Scoreboard scoreboard;

      public static void changePlayerName(Player player, String prefix, String suffix, TeamAction action) {
            if (player.getScoreboard() == null || prefix == null || suffix == null || action == null) {
                  return;
            }

            scoreboard = player.getScoreboard();

            if (scoreboard.getTeam(player.getName()) == null) {
                  scoreboard.registerNewTeam(player.getName());
            }

            team = scoreboard.getTeam(player.getName());
            team.setPrefix(Color(prefix));
            team.setSuffix(Color(suffix));
            team.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.ALWAYS);

            switch (action) {
                  case CREATE:
                        team.addPlayer(player);
                        break;
                  case UPDATE:
                        team.unregister();
                        scoreboard.registerNewTeam(player.getName());
                        team = scoreboard.getTeam(player.getName());
                        team.setPrefix(Color(prefix));
                        team.setSuffix(Color(suffix));
                        team.setNameTagVisibility(NameTagVisibility.ALWAYS);
                        team.addPlayer(player);
                        break;
                  case DESTROY:
                        team.unregister();
                        break;
            }
      }

      private static String Color(String input) {
            return ChatColor.translateAlternateColorCodes('&', input);
      }

      public static void setTag(Player player) {
            if (player.isOp()) {
                  NametagChanger.changePlayerName(player, "&8[&c&lA&8] &7", "", TeamAction.CREATE);
            } else if(player.hasPermission("build+")) {
                  NametagChanger.changePlayerName(player, "&8[&2&lB+&8] &7", "", TeamAction.CREATE);
            } else if(player.hasPermission("build")) {
                  NametagChanger.changePlayerName(player, "&8[&aB&8] &7", "", TeamAction.CREATE);
            } else { NametagChanger.changePlayerName(player, "&8[&7V&8] &7", "", TeamAction.CREATE); }
      }

      public static String getTag(Player player) {
            if (player.isOp()) {
                  return Color("&8[&c&lA&8] &7");
            } else if(player.hasPermission("build+")) {
                  return Color("&8[&2&lB+&8] &7");
            } else if(player.hasPermission("build")) {
                 return Color("&8[&aB&8] &7");
            } else { return "&8[&7V&8] &7"; }
      }

}

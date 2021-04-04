package de.legoshi.speedplugin.clicker;

import de.legoshi.speedplugin.Speedplugin;
import de.legoshi.speedplugin.checkpoint.CheckPointObject;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.apache.commons.lang3.Range;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;
import org.bukkit.permissions.Permission;

import java.util.ArrayList;
import java.util.Objects;

public class ItemClickManager {

      private ItemStack red = new ItemStack(Material.INK_SACK, 1, (short) 1);
      private MaterialData redData = red.getData();

      public void redDyeRight(PlayerInteractEvent e) {

            Player p = e.getPlayer();

            if ((getItemInHandData(p).equals(redData))) {
                  CheckPointObject cpo = Speedplugin.getInstance().checkPointManager.getCheckpoint().get(p);

                  e.setCancelled(true);

                  if (cpo.getLocation() != null) {

                        Location l = cpo.getLocation();
                        p.teleport(l);

                  } else {
                        p.sendMessage("No Checkpoint set!");
                  }
            }
      }

      public void redDyeLeft(PlayerInteractEvent e) {

            Player p = e.getPlayer();

            if ((getItemInHandData(p).equals(redData))) {
                  CheckPointObject cpo = Speedplugin.getInstance().checkPointManager.getCheckpoint().get(p);
                  cpo.setLocation(p.getLocation());
                  p.sendMessage("Checkpoint set!");
            }

      }

      private boolean checkPlayerPos(Player p) {

            double xPos = Math.abs(p.getLocation().getX());
            double zPos = Math.abs(p.getLocation().getZ());

            double widePos = 0.0001;
            double wideNeg = 0.0001;

            //saves only floatingpoint numbers into x and z
            double x = xPos - (int) Math.floor(xPos);
            double z = zPos - (int) Math.floor(zPos);

            //block size
            Range<Double> blockRangeX = Range.between(0.3000 - wideNeg, 0.3000 + widePos);
            Range<Double> blockRangeZ = Range.between(0.7000 - wideNeg, 0.7000 + widePos);
            //ladder size (1.8 only)
            Range<Double> ladderRangeX = Range.between(0.4249 - wideNeg, 0.4249 + widePos);
            Range<Double> ladderRangeZ = Range.between(0.5750 - wideNeg, 0.5750 + widePos);
            //trapdoor size
            Range<Double> trapdoorRangeX = Range.between(0.5125 - wideNeg, 0.5125 + widePos);
            Range<Double> trapdoorRangeZ = Range.between(0.4874 - wideNeg, 0.4874 + widePos);
            //shortpane size (1.8 only)
            Range<Double> paneSmallRangeX = Range.between(0.7999 - wideNeg, 0.7999 + widePos);
            Range<Double> paneSmallRangeZ = Range.between(0.2000 - wideNeg, 0.2000 + widePos);
            //longpane size
            Range<Double> paneLongRangeX = Range.between(0.8624 - wideNeg, 0.8624 + widePos);
            Range<Double> paneLongRangeZ = Range.between(0.1375 - wideNeg, 0.1375 + widePos);
            //fence size
            Range<Double> fenceRangeX = Range.between(0.9249 - wideNeg, 0.9249 + widePos);
            Range<Double> fenceRangeZ = Range.between(0.0750 - wideNeg, 0.0750 + widePos);
            //cobblewall size
            Range<Double> cobblewallRangeX = Range.between(0.0499 - wideNeg, 0.0499 + widePos);
            Range<Double> cobblewallRangeZ = Range.between(0.9500 - wideNeg, 0.9500 + widePos);
            //anvil size
            Range<Double> anvilRangeX = Range.between(0.1749 - wideNeg, 0.1749 + widePos);
            Range<Double> anvilRangeZ = Range.between(0.8250 - wideNeg, 0.8250 + widePos);
            //chest size
            Range<Double> chestRangeX = Range.between(0.2374 - wideNeg, 0.2374 + widePos);
            Range<Double> chestRangeZ = Range.between(0.7625 - wideNeg, 0.7625 + widePos);
            //pistonhead size
            Range<Double> pistonHeadRangeX = Range.between(0.5499 - wideNeg, 0.5499 + widePos);
            Range<Double> pistonHeadRangeZ = Range.between(0.4500 - wideNeg, 0.4500 + widePos);
            //cocaoBean1 size
            Range<Double> cocaoBeanOneRangeX = Range.between(0.6124 - wideNeg, 0.6124 + widePos);
            Range<Double> cocaoBeanOneRangeZ = Range.between(0.3875 - wideNeg, 0.3875 + widePos);
            //cocaoBean2 size
            Range<Double> cocaoBeanTwoRangeX = Range.between(0.7374 - wideNeg, 0.7374 + widePos);
            Range<Double> cocaoBeanTwoRangeZ = Range.between(0.2625 - wideNeg, 0.2625 + widePos);
            //flowerpot size
            Range<Double> flowerpotRangeX = Range.between(0.9874 - wideNeg, 0.9874 + widePos);
            Range<Double> flowerpotRangeZ = Range.between(0.0125 - wideNeg, 0.0125 + widePos);

            //checking x coord of player to be not in the range of any forbidden positions
            if (blockRangeX.contains(x) || blockRangeZ.contains(x) ||
                ladderRangeX.contains(x) || ladderRangeZ.contains(x) ||
                trapdoorRangeX.contains(x) || trapdoorRangeZ.contains(x) ||
                paneSmallRangeX.contains(x) || paneSmallRangeZ.contains(x) ||
                paneLongRangeX.contains(x) || paneLongRangeZ.contains(x) ||
                fenceRangeX.contains(x) || fenceRangeZ.contains(x) ||
                cobblewallRangeX.contains(x) || cobblewallRangeZ.contains(x) ||
                anvilRangeX.contains(x) || anvilRangeZ.contains(x) ||
                chestRangeX.contains(x) || chestRangeZ.contains(x) ||
                pistonHeadRangeX.contains(x) || pistonHeadRangeZ.contains(x) ||
                cocaoBeanOneRangeX.contains(x) || cocaoBeanOneRangeZ.contains(x) ||
                cocaoBeanTwoRangeX.contains(x) || cocaoBeanTwoRangeZ.contains(x) ||
                flowerpotRangeX.contains(x) || flowerpotRangeZ.contains(x)) {

                  return false;

            }

            //checking z coord of player to be not in the range of any forbidden positions
            if( blockRangeX.contains(z) || blockRangeZ.contains(z) ||
                ladderRangeX.contains(z) || ladderRangeZ.contains(z) ||
                trapdoorRangeX.contains(z) || trapdoorRangeZ.contains(z) ||
                paneSmallRangeX.contains(z) || paneSmallRangeZ.contains(z) ||
                paneLongRangeX.contains(z) || paneLongRangeZ.contains(z) ||
                fenceRangeX.contains(z) || fenceRangeZ.contains(z) ||
                cobblewallRangeX.contains(z) || cobblewallRangeZ.contains(z) ||
                anvilRangeX.contains(z) || anvilRangeZ.contains(z) ||
                chestRangeX.contains(z) || chestRangeZ.contains(z) ||
                pistonHeadRangeX.contains(z) || pistonHeadRangeZ.contains(z) ||
                cocaoBeanOneRangeX.contains(z) || cocaoBeanOneRangeZ.contains(z) ||
                cocaoBeanTwoRangeX.contains(z) || cocaoBeanTwoRangeZ.contains(z) ||
                flowerpotRangeX.contains(z) || flowerpotRangeZ.contains(z) ) {

                  return false;

            }

            return true;

      }

      public Material getItemInHandMaterial(Player p) {
            return Objects.requireNonNull(p.getInventory().getItem(p.getInventory().getHeldItemSlot())).getType();
      }

      public ItemStack getItemInHandItemStack(Player p) {
            return Objects.requireNonNull(p.getInventory().getItem(p.getInventory().getHeldItemSlot()));
      }

      public MaterialData getItemInHandData(Player p) {
            return Objects.requireNonNull(p.getInventory().getItem(p.getInventory().getHeldItemSlot()).getData());
      }

      public boolean isPracticeItem(Player p) {
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("§l§6Practice");
            return Objects.equals(Objects.requireNonNull(Objects.requireNonNull(
                p.getInventory().getItem(p.getInventory().getHeldItemSlot())).getItemMeta()).getLore(), lore);
      }

      public boolean isHandEmpty(Player p) {
            ItemStack itemstack = p.getInventory().getItem(p.getInventory().getHeldItemSlot());
            return itemstack == null;
      }

      public boolean isCorrectItem(Player p) {
            if (!(isHandEmpty(p))) {
                  return isPracticeItem(p);
            }
            return false;
      }


}

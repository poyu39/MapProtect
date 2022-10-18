package com.poyu39.mapprotect.Command;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class PlayerSignMap implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
    if (!(sender instanceof Player)) {
      return false;
    }
    if (commandLabel.equalsIgnoreCase("map")) {
      System.out.println("test");
      Player player = (Player) sender;
      if (args[0].equals("sign")) {
        getSignName(player, args[1]);
      }
    }
    return false;
  }

  public void getSignName(Player player, String playerName) {
    ItemStack items = player.getInventory().getItemInMainHand();
    if (items.getType().equals(Material.FILLED_MAP)) {
      ItemMeta meta = items.getItemMeta();
      if (meta.hasLore()) {
        player.sendMessage(ChatColor.RED + "此地圖已經簽名！無法再次簽名");
      } else {
        ArrayList<String> signName = new ArrayList<>();
        signName.add(ChatColor.YELLOW + "[此地圖受到 " + playerName + " 保護中]");
        meta.setLore(signName);
        items.setItemMeta(meta);
      }
    } else {
      player.sendMessage(ChatColor.RED + "錯誤！只能對地圖簽名");
    }
  }
}

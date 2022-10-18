package com.poyu39.mapprotect.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;

public class CartographyTable implements Listener {
  @EventHandler
  public void onClick(InventoryClickEvent event) {
    if (event.getView().getType().equals(InventoryType.CARTOGRAPHY) && event.getCurrentItem() != null) {
      Player player = (Player) event.getWhoClicked();
      ItemStack items = event.getCurrentItem();
      ItemMeta meta = Objects.requireNonNull(items).getItemMeta();
      if (items.getType().equals(Material.FILLED_MAP) && meta.hasLore()) {
        List<String> itemLore = meta.getLore();
        String signName = itemLore.get(0);
        int firstIndex = signName.indexOf(" ", 0);
        int lastIndex = signName.indexOf(" ", firstIndex + 1);
        signName = signName.substring(firstIndex + 1, lastIndex);
        System.out.println(signName);
        System.out.println(player.getName());
        if (!(signName.equals(player.getName()))) {
          event.setCancelled(true);
          event.getWhoClicked().sendMessage(ChatColor.RED + "你沒有權限進行複製。");
        }
      }
    }
  }

  /*
  @EventHandler
  public void onItemCraft(PrepareItemCraftEvent event) {
    ItemStack[] items = event.getInventory().getMatrix();
    for (ItemStack item : items) {
      if (item != null && item.getType() == Material.MAP) {
        event.getInventory().setResult(new ItemStack(Material.AIR));
      }
    }
  }
  */
}

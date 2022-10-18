package com.poyu39.mapprotect;

import com.poyu39.mapprotect.Command.PlayerSignMap;
import com.poyu39.mapprotect.Listener.CartographyTable;
import org.bukkit.plugin.java.JavaPlugin;

public final class MapProtect extends JavaPlugin {

  public static MapProtect mapProtect;
  @Override
  public void onEnable() {
    mapProtect = this;
    this.getLogger().info("已啟用MapProtect");

    getServer().getPluginManager().registerEvents(new CartographyTable(), this);
    getCommand("MapProtect").setExecutor(new PlayerSignMap());
  }
}

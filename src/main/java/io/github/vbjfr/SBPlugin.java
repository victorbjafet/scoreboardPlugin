package io.github.vbjfr;

import org.bukkit.plugin.java.JavaPlugin;

public class SBPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Scoreboard Plugin enabled");
        this.getCommand("sb").setExecutor(new CommandSB());
        this.getCommand("sb").setTabCompleter(new TabCompleterSB());
    }
    @Override
    public void onDisable() {
        getLogger().info("Scoreboard Plugin disabled");
    }


}
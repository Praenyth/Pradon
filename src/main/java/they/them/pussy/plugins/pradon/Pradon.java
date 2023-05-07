package they.them.pussy.plugins.pradon;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import they.them.pussy.plugins.pradon.commands.PradonCommand;
import they.them.pussy.plugins.pradon.listeners.GameSwitchListener;
import they.them.pussy.plugins.pradon.listeners.PlayerHungerLossListener;
import they.them.pussy.plugins.pradon.listeners.PlayerPickupListener;
import they.them.pussy.plugins.pradon.runnables.GameActiveRunnable;

import java.util.HashMap;
import java.util.Map;

public final class Pradon extends JavaPlugin {

    public static Pradon instance;
    public static boolean active = false;
    public static GameActiveRunnable runnable = new GameActiveRunnable();
    public static Component messagePrefix = Component.text("Pradon - ").color(NamedTextColor.GREEN);
    public static Map<Player, Material> playerItems = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new GameSwitchListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerPickupListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerHungerLossListener(), this);

        instance.getConfig().options().copyDefaults();
        instance.saveDefaultConfig();

        PradonCommand.register();
    }

    @Override
    public void onDisable() {}
}

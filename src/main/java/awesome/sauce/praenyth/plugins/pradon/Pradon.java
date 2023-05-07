package awesome.sauce.praenyth.plugins.pradon;

import awesome.sauce.praenyth.plugins.pradon.commands.PradonCommand;
import awesome.sauce.praenyth.plugins.pradon.events.PradonGameToggleEvent;
import awesome.sauce.praenyth.plugins.pradon.listeners.GameSwitchListener;
import awesome.sauce.praenyth.plugins.pradon.listeners.PlayerDeathListener;
import awesome.sauce.praenyth.plugins.pradon.listeners.PlayerHungerLossListener;
import awesome.sauce.praenyth.plugins.pradon.listeners.PlayerPickupListener;
import awesome.sauce.praenyth.plugins.pradon.runnables.GameActiveRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class Pradon extends JavaPlugin {

    public static Pradon instance;
    public static boolean active = false;
    public static GameActiveRunnable runnable = new GameActiveRunnable();
    public static Component messagePrefix = Component.text("Pradon - ").color(NamedTextColor.GREEN);
    public static Map<Player, Material> playerItems = new HashMap<>();
    public static PradonGameToggleEvent gameToggleEvent;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new GameSwitchListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerPickupListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerHungerLossListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathListener(), this);

        instance.getConfig().options().copyDefaults();
        instance.saveDefaultConfig();

        PradonCommand.register();
    }

    @Override
    public void onDisable() {}
}

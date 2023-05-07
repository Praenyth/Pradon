package they.them.pussy.plugins.pradon;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.plugin.java.JavaPlugin;
import they.them.pussy.plugins.pradon.commands.PradonCommand;
import they.them.pussy.plugins.pradon.listeners.GameSwitchListener;
import they.them.pussy.plugins.pradon.runnables.GameActiveRunnable;

public final class Pradon extends JavaPlugin {

    public static Pradon instance;
    public static boolean active = false;
    public static GameActiveRunnable runnable = new GameActiveRunnable();
    public static Component messagePrefix = Component.text("Pradon - ").color(NamedTextColor.GREEN);

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getServer().getPluginManager().registerEvents(new GameSwitchListener(), this);

        instance.getConfig().options().copyDefaults();
        instance.saveDefaultConfig();

        PradonCommand.register();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

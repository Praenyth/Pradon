package they.them.pussy.plugins.pradon.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import they.them.pussy.plugins.pradon.Pradon;
import they.them.pussy.plugins.pradon.events.PradonGameToggleEvent;

public class GameSwitchListener implements Listener {

    @EventHandler
    public void onGameSwitch(PradonGameToggleEvent event) {
        if (event.isActive()) {
            // Start game
            for (Player pl : Bukkit.getOnlinePlayers()) {
                for (PotionEffect potionEffect : pl.getActivePotionEffects()) {
                    pl.removePotionEffect(potionEffect.getType());
                }
                pl.getInventory().clear();
                pl.sendMessage(
                        Pradon.messagePrefix
                                .append(
                                        Component.text(
                                                "The game has started!", NamedTextColor.GREEN
                                        )
                                )
                );
            }
            Pradon.runnable.start();
            Pradon.active = true;
        } else {
            // Stop game
            for (Player pl : Bukkit.getOnlinePlayers()) {
                pl.getInventory().clear();
                pl.sendMessage(
                        Pradon.messagePrefix
                                .append(
                                        Component.text(
                                                "The game has ended!", NamedTextColor.GREEN
                                        )
                                )
                );
            }
            Pradon.runnable.cancel();
            Pradon.active = false;
        }
    }
}

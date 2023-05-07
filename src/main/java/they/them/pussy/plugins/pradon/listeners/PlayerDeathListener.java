package they.them.pussy.plugins.pradon.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import they.them.pussy.plugins.pradon.Pradon;
import they.them.pussy.plugins.pradon.api.PlayerChecks;
import they.them.pussy.plugins.pradon.events.PradonGameToggleEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        if (Pradon.active) {
            event.setCancelled(true);
            event.getEntity().getInventory().clear();
            event.getEntity().setGameMode(GameMode.SPECTATOR);
            if (PlayerChecks.checkForLastPlayer()) {
                Pradon.gameToggleEvent = new PradonGameToggleEvent(false);
                Pradon.gameToggleEvent.callEvent();
            }
        }

    }

}

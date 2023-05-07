package awesome.sauce.praenyth.plugins.pradon.listeners;

import awesome.sauce.praenyth.plugins.pradon.api.PlayerChecks;
import awesome.sauce.praenyth.plugins.pradon.events.PradonGameToggleEvent;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import awesome.sauce.praenyth.plugins.pradon.Pradon;

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

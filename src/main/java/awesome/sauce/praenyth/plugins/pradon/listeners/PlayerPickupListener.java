package awesome.sauce.praenyth.plugins.pradon.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;
import awesome.sauce.praenyth.plugins.pradon.Pradon;

public class PlayerPickupListener implements Listener {

    @EventHandler
    public void onPlayerPickup(PlayerAttemptPickupItemEvent event) {

        if (Pradon.active) {
            if (Pradon.playerItems.get(event.getPlayer()) == null) return;
            if (!Pradon.playerItems.get(event.getPlayer())
                    .equals(event.getItem().getItemStack().getType())) {
                event.setCancelled(true);
            }
        }

    }

}

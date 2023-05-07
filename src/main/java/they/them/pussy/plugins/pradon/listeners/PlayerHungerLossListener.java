package they.them.pussy.plugins.pradon.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import they.them.pussy.plugins.pradon.Pradon;

public class PlayerHungerLossListener implements Listener {

    @EventHandler
    public void onPlayerHungerLoss(FoodLevelChangeEvent event) {

        if (Pradon.active) {
            Player player = (Player) event.getEntity();
            player.setFoodLevel(20);
            player.setSaturation(0);
            event.setCancelled(true);
        }

    }

}

package they.them.pussy.plugins.pradon.runnables;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import they.them.pussy.plugins.pradon.Pradon;

public class GameActiveRunnable extends BukkitRunnable {

    public void start() {
        Pradon.runnable.runTaskTimer(Pradon.instance, 0, 20L * Pradon.instance.getConfig().getInt("Item-Give-Delay"));
    }

    public void cancel() {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.getInventory().clear();
            if (pl.getGameMode().equals(GameMode.SURVIVAL)) {
                for (Player pla : Bukkit.getOnlinePlayers()) {
                    pla.sendMessage(
                            Pradon.messagePrefix
                                    .append(Component.text(pl.getName()+" has won the game!").color(NamedTextColor.GREEN))
                    );
                }
            }
            pl.setGameMode(GameMode.SPECTATOR);
        }
        super.cancel();
    }

    @Override
    public void run() {
        for (Player pl : Bukkit.getOnlinePlayers()) {
            pl.sendMessage(
                    Pradon.messagePrefix
                            .append(Component.text("You've been given your item!"))
            );
            Material item = Material.valueOf(
                    Pradon.instance.getConfig().getStringList("Items")
                            .get(
                                    (int) (Math.random() * Pradon.instance.getConfig().getStringList("Items").size())
                            )
            );
            for (int i = 1; i <= 36; i++) {
                pl.getWorld().dropItemNaturally(
                        pl.getLocation(),
                        new ItemStack(item, item.getMaxStackSize())
                );
            }

            Pradon.playerItems.put(pl, item);

        }
    }
}

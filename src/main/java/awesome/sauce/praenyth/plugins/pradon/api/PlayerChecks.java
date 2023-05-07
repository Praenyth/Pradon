package awesome.sauce.praenyth.plugins.pradon.api;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerChecks {

    public static boolean checkForLastPlayer() {

        List<Player> players = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {

            if (player.getGameMode().equals(GameMode.SURVIVAL) || player.getGameMode().equals(GameMode.ADVENTURE)) {
                players.add(player);
            }

        }

        if (players.size() <= 1) {
            return true;
        } else {
            return false;
        }

    }

}

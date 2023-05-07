package awesome.sauce.praenyth.plugins.pradon.api;

import org.bukkit.Material;
import awesome.sauce.praenyth.plugins.pradon.Pradon;

public class Config {
    public static void setAndSaveConfig(String path, Object value) {

        Pradon.instance.getConfig().set(path, value);
        SettingsCache settingsCache = new SettingsCache();
        settingsCache.giveDelay = Pradon.instance.getConfig().getInt("Item-Give-Delay");
        for (String item : Pradon.instance.getConfig().getStringList("Items")) {
            settingsCache.items.add(Material.getMaterial(item));
        }
        Pradon.instance.saveConfig();
        Pradon.instance.reloadConfig();
    }

}

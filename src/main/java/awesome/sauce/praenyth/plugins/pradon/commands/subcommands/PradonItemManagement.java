package awesome.sauce.praenyth.plugins.pradon.commands.subcommands;

import awesome.sauce.praenyth.plugins.pradon.api.Config;
import cloud.commandframework.annotations.Argument;
import cloud.commandframework.annotations.CommandDescription;
import cloud.commandframework.annotations.CommandMethod;
import cloud.commandframework.annotations.CommandPermission;
import cloud.commandframework.context.CommandContext;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import awesome.sauce.praenyth.plugins.pradon.Pradon;

import java.util.ArrayList;
import java.util.List;

public class PradonItemManagement {

    @CommandMethod("pradon additem <addItem>")
    @CommandDescription("Add an item to the list of items that can be given")
    @CommandPermission("pradon.admin.additem")
    public void addItem(CommandContext<CommandSender> context, @Argument(value = "addItem") Material addItem) {

        context.getSender().sendMessage(
                Pradon.messagePrefix
                        .append(
                                Component.text(
                                        "The item "+addItem.toString()+" has been added to the list of items that can be given!", NamedTextColor.GREEN
                                )
                        )
        );

        List<Material> items = new ArrayList<>();
        for (String item : Pradon.instance.getConfig().getStringList("Items")) {
            items.add(Material.getMaterial(item));
        }
        items.add(addItem);

        List<String> sItems = new ArrayList<>();
        for (Material item : items) {
            sItems.add(item.toString());
        }

        Config.setAndSaveConfig("Items", sItems);

    }

    @CommandMethod("pradon removeitem <removeItem>")
    @CommandDescription("Add an item to the list of items that can be given")
    @CommandPermission("pradon.admin.removeitem")
    public void removeItem(CommandContext<CommandSender> context, @Argument(value = "removeItem") Material removeItem) {

        context.getSender().sendMessage(
                Pradon.messagePrefix
                        .append(
                                Component.text(
                                        "The item "+removeItem.toString()+" has been removed from the list of items that can be given!", NamedTextColor.GREEN
                                )
                        )
        );

        List<Material> items = new ArrayList<>();
        for (String item : Pradon.instance.getConfig().getStringList("Items")) {
            items.add(Material.getMaterial(item));
        }
        items.remove(removeItem);

        List<String> sItems = new ArrayList<>();
        for (Material item : items) {
            sItems.add(item.toString());
        }

        Config.setAndSaveConfig("Items", sItems);

    }

}

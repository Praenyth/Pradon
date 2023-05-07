package awesome.sauce.praenyth.plugins.pradon.commands.subcommands;

import awesome.sauce.praenyth.plugins.pradon.Pradon;
import awesome.sauce.praenyth.plugins.pradon.api.Config;
import cloud.commandframework.annotations.Argument;
import cloud.commandframework.annotations.CommandDescription;
import cloud.commandframework.annotations.CommandMethod;
import cloud.commandframework.annotations.CommandPermission;
import cloud.commandframework.context.CommandContext;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;

public class PradonGiveDelay {

    @CommandMethod("pradon setGiveDelaySeconds <giveDelay>")
    @CommandDescription("Sets the give delay in seconds")
    @CommandPermission("pradon.admin.setgivedelay")
    public void giveDelay(CommandContext<CommandSender> context, @Argument(value = "giveDelay") int giveDelay) {

        Config.setAndSaveConfig("Item-Give-Delay", giveDelay);
        context.getSender().sendMessage(
                Pradon.messagePrefix
                        .append(Component.text("The give delay has been set to "+giveDelay+" seconds!"))
        );

    }

}

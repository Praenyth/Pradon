package they.them.pussy.plugins.pradon.commands.subcommands;

import cloud.commandframework.annotations.Argument;
import cloud.commandframework.annotations.CommandDescription;
import cloud.commandframework.annotations.CommandMethod;
import cloud.commandframework.context.CommandContext;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import they.them.pussy.plugins.pradon.Pradon;
import they.them.pussy.plugins.pradon.api.Config;

public class PradonGiveDelay {

    @CommandMethod("pradon setGiveDelaySeconds <giveDelay>")
    @CommandDescription("Sets the give delay in seconds")
    public void giveDelay(CommandContext<CommandSender> context, @Argument(value = "giveDelay") int giveDelay) {

        Config.setAndSaveConfig("Item-Give-Delay", giveDelay);
        context.getSender().sendMessage(
                Pradon.messagePrefix
                        .append(Component.text("The give delay has been set to "+giveDelay+" seconds!"))
        );

    }

}

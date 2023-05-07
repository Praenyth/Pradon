package awesome.sauce.praenyth.plugins.pradon.commands;

import awesome.sauce.praenyth.plugins.pradon.commands.subcommands.PradonToggle;
import cloud.commandframework.annotations.AnnotationParser;
import cloud.commandframework.annotations.CommandMethod;
import cloud.commandframework.context.CommandContext;
import cloud.commandframework.execution.CommandExecutionCoordinator;
import cloud.commandframework.meta.SimpleCommandMeta;
import cloud.commandframework.paper.PaperCommandManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;
import awesome.sauce.praenyth.plugins.pradon.Pradon;
import awesome.sauce.praenyth.plugins.pradon.commands.subcommands.PradonGiveDelay;
import awesome.sauce.praenyth.plugins.pradon.commands.subcommands.PradonItemManagement;

import java.util.function.Function;

public class PradonCommand {

    /**
     * Registers all commands of the plugin
     * @author Prae
     */
    public static void register() {
        final PaperCommandManager commandManager;
        AnnotationParser<CommandSender> annotationParser;
        try {

            commandManager = new PaperCommandManager(
                    Pradon.instance,
                    CommandExecutionCoordinator.simpleCoordinator(),
                    Function.identity(),
                    Function.identity()
            );

            annotationParser = new AnnotationParser<>(
                    commandManager,
                    CommandSender.class,
                    parameters -> SimpleCommandMeta.empty()
            );

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        // Register subcommands
        annotationParser.parse(new PradonToggle());
        annotationParser.parse(new PradonGiveDelay());
        annotationParser.parse(new PradonItemManagement());

    }

    @CommandMethod("pradon")
    public void pradon(CommandContext<CommandSender> sender) {

        sender.getSender().sendMessage(
                Pradon.messagePrefix
                        .append(Component.text("Pradon! A plugin made by Prae!").color(NamedTextColor.GREEN))
        );

    }

}

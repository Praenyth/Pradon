package they.them.pussy.plugins.pradon.commands.subcommands;

import cloud.commandframework.annotations.Argument;
import cloud.commandframework.annotations.CommandDescription;
import cloud.commandframework.annotations.CommandMethod;
import they.them.pussy.plugins.pradon.events.PradonGameToggleEvent;

public class PradonToggle {

    @CommandMethod("pradon toggle <gameToggle>")
    @CommandDescription("Toggle the game")
    public void start(@Argument(value = "gameToggle") boolean gameToggle) {
        PradonGameToggleEvent event = new PradonGameToggleEvent(gameToggle);
        event.callEvent();
    }

}

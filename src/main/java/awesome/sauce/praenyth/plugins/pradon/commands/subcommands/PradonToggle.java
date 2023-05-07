package awesome.sauce.praenyth.plugins.pradon.commands.subcommands;

import cloud.commandframework.annotations.Argument;
import cloud.commandframework.annotations.CommandDescription;
import cloud.commandframework.annotations.CommandMethod;
import cloud.commandframework.annotations.CommandPermission;
import awesome.sauce.praenyth.plugins.pradon.Pradon;
import awesome.sauce.praenyth.plugins.pradon.events.PradonGameToggleEvent;

public class PradonToggle {

    @CommandMethod("pradon toggle <gameToggle>")
    @CommandDescription("Toggle the game")
    @CommandPermission("pradon.admin.togglegame")
    public void start(@Argument(value = "gameToggle") boolean gameToggle) {
        Pradon.gameToggleEvent = new PradonGameToggleEvent(gameToggle);
        Pradon.gameToggleEvent.callEvent();
    }

}

package command;

import Game.Game;

public class GameStart extends Command {

    Game game = new Game();

    public String execute() {
        game.Game();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}

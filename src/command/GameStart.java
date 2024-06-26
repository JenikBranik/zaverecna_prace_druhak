package command;

import Game.Game;

/**
 * Class starting the game
 */
public class GameStart extends Command {

    Game game = new Game();

    /**
     * Method to execute the game
     * @return start the game
     */
    public String execute() {
        game.Game();
        return "";
    }

    /**
     * Method for exit console
     * @return does not turn off the program
     */
    @Override
    public boolean exit() {
        return false;
    }
}

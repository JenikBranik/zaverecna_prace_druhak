package command;

/**
 * Class for help player
 */
public class Help extends Command {

    /**
     * Returns input commands
     * @return commmands
     */
    public String execute() {
        return "start, exit";
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

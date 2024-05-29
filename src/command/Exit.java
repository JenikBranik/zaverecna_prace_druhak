package command;

/**
 *  Class returning exit from program
 */
public class Exit extends Command{
    public String execute(){
        return "Exit...";
    }


    /**
     * Treatment method to close the program
     * @return does not turn off the program
     */
    @Override
    public boolean exit() {
        return true;
    }
}

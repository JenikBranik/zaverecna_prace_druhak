package command;

public class Exit extends Command{
    public String execute(){
        return "Exit...";
    }


    /**
     * Metoda na osetreni, aby se program vypl
     * @return vypne program
     */
    @Override
    public boolean exit() {
        return true;
    }
}

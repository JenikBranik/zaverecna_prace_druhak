package command;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class returning history of commands
 */
public class CommandHistory extends Command {
    /**
     * Methods returning commands
     * @return empty String
     */
    @Override
    public String execute() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("commandHistory.txt"));
            String lines;
            while ((lines = br.readLine()) != null) {
                System.out.println(lines);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    /**
     * A method for cleaning so that the program does not run
     * @return does not turn off the program
     */
    @Override
    public boolean exit() {
        return false;
    }
}

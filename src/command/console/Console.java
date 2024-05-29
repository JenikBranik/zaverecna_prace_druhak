package command.console;

import command.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class for invoke some commands
 */
public class Console {
    // Kontrola exitu
    private boolean exit = false;

    // Pomocny seznam pro vytvoreni a nacteni ruznych metod
    private HashMap<String, Command> map = new HashMap<>();

    // Nazev txt souboru
    public static String commandHistory = "commandHistory.txt";

    /**
     * Load map of commands
     */
    public void inicializace() {
        map.put("start", new GameStart());
        map.put("exit", new Exit());
        map.put("help", new Help());
        map.put("history", new CommandHistory());
    }

    private Scanner scanner = new Scanner(System.in);

    /**
     * Main method of process
     */
    private void to_do() {
        System.out.print(">>");
        String command = scanner.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        saveCommand(command);
        if (map.containsKey(command)) {
            System.out.println(">> " + map.get(command).execute());
            exit = map.get(command).exit();
        } else {
            System.out.println(">> Undefined command");
        }
    }

    /**
     * Start console
     */
    public void start() {
        System.out.println("Welcome, try some command");
        inicializace();
        try {
            resetFileAfterCommand();
            do {
                to_do();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Stores individual commands written in console
     *
     * @param command Value, what's gonna save to file
     */
    public void saveCommand(String command) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(commandHistory, true))) {
            bw.write(command);
            bw.newLine();
        } catch (Exception e) {

        }


    }

    /**
     * Reset file with history of file into
     */
    private void resetFileAfterCommand() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(commandHistory, false))) {
        } catch (Exception e) {
        }
    }
}
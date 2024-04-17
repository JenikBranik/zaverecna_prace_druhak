package command.console;

import command.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Trida na vyvolavani nekterych prikazu
 */
public class Console {
    // Kontrola exitu
    private boolean exit = false;

    // Pomocny seznam pro vytvoreni a nacteni ruznych metod
    private HashMap<String, Command> map = new HashMap<>();

    // Nazev txt souboru
    public static String commandHistory = "commandHistory.txt";

    /**
     * Načtení mapy příkazů
     */
    public void inicializace() {
        map.put("showfield", new ShowField());
        map.put("exit", new Exit());
    }

    private Scanner scanner = new Scanner(System.in);

    /**
     * Hlavní metoda celého procesu
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
            System.out.println(">> Nedefinovany prikaz");
        }
    }

    /**
     * Spustí konzoli
     */
    public void start() {
        System.out.println("Vítej, zadej nějaký příkaz");
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
     * Uklada jednotlive prikazy zapsane do console
     *
     * @param command Hodnota, ktera se ulozi do souboru
     */
    public void saveCommand(String command) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(commandHistory, true))) {
            bw.write(command);
            bw.newLine();
        } catch (Exception e) {

        }


    }

    /**
     * Resetuje soubor s historii prikazu po spusteni konzole.
     */
    private void resetFileAfterCommand() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(commandHistory, false))) {
        } catch (Exception e) {
        }
    }
}
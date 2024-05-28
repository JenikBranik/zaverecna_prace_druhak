import Player.Player;
import gameField.Field;
import Player.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public void Game() {
        Scanner sc = new Scanner(System.in);
        Field field = new Field();
        readJson rJson = new readJson();
        createJson cJson = new createJson();
        WinnerCheck wc = new WinnerCheck();

        cJson.metoda();
        rJson.readJson();
        // Přidat hráče do hry
        for (int i = 0; i < rJson.usernames.size(); i++) {
            field.addPlayer(rJson.usernames.get(i));
        }

        // Vygenerovat hrací pole
        System.out.println("Kolik párů chceš vytvořit?");
        int countOfPairs = sc.nextInt();
        sc.nextLine(); // Clear the newline character

        // Zadat vlastní symboly
        ArrayList<String> customSymbols = new ArrayList<>();
        System.out.println("Kolik vlastních symbolů chceš přidat?");
        int customCount = sc.nextInt();
        sc.nextLine(); // Clear the newline character

        for (int i = 0; i < customCount; i++) {
            System.out.println("Zadej symbol č. " + (i + 1) + ":");
            customSymbols.add(sc.nextLine());
        }

        // Generovat pole s uživatelskými symboly
        field.generateField(countOfPairs, customSymbols);

        // Určit prvního hráče
        Player firstPlayer = field.getCurrentPlayer();
        System.out.println("Začíná hráč: " + firstPlayer.getUsername());

        // Zahájit hru
        while (field.gameContinue()) {
            field.showField();
        }

        String winner = wc.winner(field.players);
        if (winner.equals("Nikdo")) {
            System.out.println(winner + " nevyhrál!");
        } else {
            System.out.println(winner + " vyhrál(a)!");
        }
    }
}
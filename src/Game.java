import Player.Player;
import gameField.Field;
import Player.*;

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
        System.out.println("Kolik párů chceš vytvoři? ");
        field.generateField(sc.nextInt());

        // Určit prvního hráče
        Player firstPlayer = field.getCurrentPlayer();
        System.out.println("Začíná hráč: " + firstPlayer.getUsername());


        // Zahájit hru
        while (field.gameContinue()) {
            field.showField();
        }
        if (wc.winner(field.players) == "Nikdo") {
            System.out.println(wc.winner(field.players) + " nevyhál!");
        }else {
            System.out.println(wc.winner(field.players) + " vyhál(a)!");
        }
    }
}
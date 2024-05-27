import Player.Player;
import Player.SetAll;
import Player.countOfUsers;
import gameField.Field;

import java.util.Scanner;

public class Game {public void Game() {
    Scanner sc = new Scanner(System.in);
    Field field = new Field();
    countOfUsers cou = new countOfUsers();
    int numPlayers = cou.getCountOfUsers();

    // Přidat hráče do hry
    for (int i = 0; i < numPlayers; i++) {
        SetAll setAll = new SetAll();
        String playerName = setAll.getUsername();
        field.addPlayer(playerName);
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
}
}
import Player.createJson;
import Player.readJson;
import command.console.Console;
import gameField.AdderCards;
import gameFunctions.addingPairs;
import gameFunctions.checkerPairs;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        AdderCards ad = new AdderCards();
        ad.numberOfPairs();

        createJson json = new createJson();
        json.metoda();
        readJson json2 = new readJson();
        json2.readJson();
    }
}
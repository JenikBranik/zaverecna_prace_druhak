package Game;

import Player.Player;
import command.console.Console;
import gameField.AdderCards;
import gameField.Field;
import Player.*;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Class to run game on
 */
public class Game {

    /**
     * Game launcher
     * @return game structure
     */
    public String Game() {

        try {
        Scanner sc = new Scanner(System.in);
        Field field = new Field();
        readJson rJson = new readJson();
        CreateJson cJson = new CreateJson();
        WinnerCheck wc = new WinnerCheck();
        AdderCards ac = new AdderCards();
        int counOfPairs;
        Console console = new Console();

        cJson.createJson();
        rJson.readJson();

        for (int i = 0; i < rJson.usernames.size(); i++) {
            field.addPlayer(rJson.usernames.get(i));
        }

        counOfPairs = ac.numberOfPairs();


        ArrayList<String> customSymbols = new ArrayList<>();
        System.out.println(">> How many custom symbols do you want to add?");
        int customCount = 0;

        try {
            while (customCount == 0) {
                customCount = sc.nextInt();
                if (customCount == 0) {
                    break;
                }
                else if (customCount < 0) {
                    System.out.println(">> You can't add negative number of symbols");
                    customCount = 0;
                } else if (customCount>counOfPairs)  {
                    System.out.println(">> You can't add more than " + counOfPairs + " symbols");
                    customCount = 0;
                }
                System.out.println(">> You can't add negative number of symbols or more than " + counOfPairs + " symbols");
            }
        }catch (Exception e) {
            customCount = 1;
        }


        console.saveCommand(String.valueOf(customCount));

        sc.nextLine();

        for (int i = 0; i < customCount; i++) {
            System.out.println(">> Add symbol number " + (i + 1) + ":");
            customSymbols.add(sc.nextLine());
            console.saveCommand(customSymbols.get(i));
        }

        ac.addCard(counOfPairs);


        field.generateField(counOfPairs, customSymbols);


        Player firstPlayer = field.getCurrentPlayer();
        System.out.println(">> Start player: " + firstPlayer.getUsername());


        while (field.gameContinue()) {
            field.showField();
        }

        String winner = wc.winner(field.players);
        if (winner.equals("Nobody")) {
            System.out.println(winner + " won");
        } else {
            System.out.println(winner + " won! Excelent work");
        }
        return "";
    }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
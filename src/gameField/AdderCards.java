package gameField;

import command.console.Console;

import java.util.Scanner;

public class AdderCards {
    Console console = new Console();

    public int numberOfPairs() {
        Scanner sc = new Scanner(System.in);
        System.out.println(">> Enter the number of pairs you want to generate");
        System.out.print(">> ");
        int countOfPairs = sc.nextInt();
        console.saveCommand(String.valueOf(countOfPairs));
        return countOfPairs;
    }

    public String addCard(int cOP) {
        generateField gf = new generateField();
        gf.generateField(cOP);
        return "";
    }
}
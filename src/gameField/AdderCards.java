package gameField;

import java.util.Scanner;

public class AdderCards {

    public int numberOfPairs() {
        Scanner sc = new Scanner(System.in);
        System.out.println(">> Zadej počet dvojic, který chceš vygenerovat");
        System.out.print(">> ");
        int countOfPairs = sc.nextInt();
        addCard(countOfPairs);
        return countOfPairs;
    }

    public String addCard(int cOP) {
        Field f = new Field();
        f.generateField(cOP);
        for (int i = 0; i < 5; i++) {
            f.showField();
        }
        return "";
    }
}
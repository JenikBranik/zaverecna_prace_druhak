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
        generateField gf = new generateField();
        Field f = new Field();
        gf.generateField(cOP);
        return "";
    }
}
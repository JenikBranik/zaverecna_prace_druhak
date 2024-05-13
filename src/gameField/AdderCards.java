package gameField;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import gameFunctions.*;

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
        addingPairs aP = new addingPairs();
        f.showField(cOP, aP.genPairs);
        return "";
    }
}

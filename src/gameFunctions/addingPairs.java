package gameFunctions;

import java.util.ArrayList;
import java.util.Random;

public class addingPairs {

    public ArrayList<Pairs> genPairs = new ArrayList<>();
    public ArrayList<String> Pairs = new ArrayList<>();

    public void setGenPairs(int countOfPairs) {
        int pairs = countOfPairs * 2;
        int row = 4;
        int column;
        boolean fullRow;
        Random r = new Random();
        int index = 0;
        generateLetters gL = new generateLetters();
        gL.setGeneratedPairs(countOfPairs);
        try {
            if (pairs % 4 != 0) {
                column = (pairs / 4) + 1;
                fullRow = false;
            } else {
                column = pairs / 4;
                fullRow = true;
            }
            System.out.println(column);
            System.out.println(row);

            if (fullRow) {
                for (int i = 1; i <= row; i++) {

                    for (int j = 1; j <= column; j++) {
                        int random = r.nextInt(gL.generatedPairs.size());
                        String symbol = gL.generatedPairs.get(random).symbol;
                        Pairs p = new Pairs(symbol, gL.generatedPairs.get(random).isGuessed, i, j);
                        genPairs.add(p);
                        Pairs.add(symbol);
                        System.out.println(genPairs.get(index).symbol + " " + genPairs.get(index).col + " " + genPairs.get(index).row + " " + genPairs.get(index).isGuessed);
                        index++;
                    }
                }
            } else if (countOfPairs == 1) {
                for (int i = 1; i <= 2; i++) {
                    String symbol = gL.generatedPairs.get(0).symbol;
                    Pairs p = new Pairs(symbol, gL.generatedPairs.get(0).isGuessed,i,1);
                    genPairs.add(p);
                    System.out.println(genPairs.get(index).symbol + " " + genPairs.get(index).col + " " + genPairs.get(index).row + " " + genPairs.get(index).isGuessed);
                    index++;
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println(">> Neco se nepodarilo");
        }
    }
}

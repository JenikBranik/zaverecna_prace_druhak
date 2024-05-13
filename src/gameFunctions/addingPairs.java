package gameFunctions;

import java.util.ArrayList;
import java.util.Random;

public class addingPairs {

    public ArrayList<Pairs> genPairs = new ArrayList<>();
    public ArrayList<String> Pairs = new ArrayList<>();

    public void setGenPairs(int countOfPairs) {
        int pairs = countOfPairs * 2;
        int row;
        int column = 4;
        boolean fullRow;
        Random r = new Random();
        int index = 0;
        generateLetters gL = new generateLetters();
        gL.setGeneratedPairs(countOfPairs);
        try {
            if (pairs % 4 != 0) {
                row = (pairs / 4) + 1;
                fullRow = false;
            } else {
                row = pairs / 4;
                fullRow = true;
            }

            if (fullRow) {
                for (int i = 1; i <= row; i++) {
                    for (int j = 1; j <= column; j++) {
                        int random = r.nextInt(gL.generatedPairs.size());
                        String symbol = gL.generatedPairs.get(random).symbol;
                        Pairs p = new Pairs(symbol, gL.generatedPairs.get(random).isGuessed, i, j);
                        for (int k = 0; k < Pairs.size(); k++) {
                            if (Pairs.get(k).equals(symbol)){
                                gL.generatedPairs.remove(random);
                            }
                        }
                        Pairs.add(symbol);
                        genPairs.add(p);
                        System.out.println(genPairs.get(index).symbol + " " + genPairs.get(index).row + " " + genPairs.get(index).col + " " + genPairs.get(index).isGuessed);
                        index++;
                    }
                }
            } else if (countOfPairs == 1) {
                for (int i = 1; i <= 2; i++) {
                    String symbol = gL.generatedPairs.get(0).symbol;
                    Pairs p = new Pairs(symbol, gL.generatedPairs.get(0).isGuessed, 1, i);
                    genPairs.add(p);
                    System.out.println(genPairs.get(index).symbol + " " + genPairs.get(index).row + " " + genPairs.get(index).col + " " + genPairs.get(index).isGuessed);
                    index++;
                }
            } else {
                for (int i = 1; i <= row-1; i++) {
                    for (int j = 1; j <= column; j++) {
                        int random = r.nextInt(gL.generatedPairs.size());
                        String symbol = gL.generatedPairs.get(random).symbol;
                        Pairs p = new Pairs(symbol, gL.generatedPairs.get(random).isGuessed, i, j);
                        for (int k = 0; k < Pairs.size(); k++) {
                            if (Pairs.get(k).equals(symbol)){
                                gL.generatedPairs.remove(random);
                            }
                        }
                        genPairs.add(p);
                        Pairs.add(symbol);
                        System.out.println(genPairs.get(index).symbol + " " + genPairs.get(index).row + " " + genPairs.get(index).col + " " + genPairs.get(index).isGuessed);
                        index++;
                    }
                }
                for (int i = 1; i <= 2; i++) {
                    int random = r.nextInt(gL.generatedPairs.size());
                    String symbol = gL.generatedPairs.get(random).symbol;
                    Pairs p = new Pairs(symbol, gL.generatedPairs.get(random).isGuessed, row, i);
                    for (int k = 0; k < Pairs.size(); k++) {
                        if (Pairs.get(k).equals(symbol)){
                            gL.generatedPairs.remove(random);
                        }
                    }
                    genPairs.add(p);
                    Pairs.add(symbol);
                    System.out.println(genPairs.get(index).symbol + " " + genPairs.get(index).row + " " + genPairs.get(index).col + " " + genPairs.get(index).isGuessed);
                    index++;
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println(">> Neco se nepodarilo");
        }
    }
}

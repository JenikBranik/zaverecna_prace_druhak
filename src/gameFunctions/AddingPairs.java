package gameFunctions;

import java.util.ArrayList;
import java.util.Random;

/**
 * Adding pairs on positions
 */

public class AddingPairs {

    public ArrayList<Pairs> genPairs = new ArrayList<>();
    public ArrayList<String> Pairs = new ArrayList<>();

    /**
     * Generate symbols on position, normal generated symbols and custom symbols
     * @param countOfPairs Count of pairs
     * @param customSymbols Custom symbol
     */
    public void setGenPairs(int countOfPairs, ArrayList<String> customSymbols) {
        int pairs = countOfPairs * 2;
        int row;
        int column = 4;
        boolean fullRow;
        Random r = new Random();
        int index = 0;
        GenerateLetters gL = new GenerateLetters();

        // Přidáme vlastní symboly
        gL.addCustomSymbols(customSymbols);

        // Generujeme zbývající páry
        int remainingPairs = countOfPairs - customSymbols.size();
        gL.setGeneratedPairs(remainingPairs);

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
                        if (index >= pairs) break;
                        int random = r.nextInt(gL.generatedPairs.size());
                        String symbol = gL.generatedPairs.get(random).symbol;
                        Pairs p = new Pairs(symbol, gL.generatedPairs.get(random).isGuessed, i, j);
                        for (int k = 0; k < Pairs.size(); k++) {
                            if (Pairs.get(k).equals(symbol)) {
                                gL.generatedPairs.remove(random);
                            }
                        }
                        Pairs.add(symbol);
                        genPairs.add(p);
                        index++;
                    }
                }
            } else if (countOfPairs == 1) {
                for (int i = 1; i <= 2; i++) {
                    String symbol = gL.generatedPairs.get(0).symbol;
                    Pairs p = new Pairs(symbol, gL.generatedPairs.get(0).isGuessed, 1, i);
                    genPairs.add(p);
                }
            } else {
                for (int i = 1; i <= row - 1; i++) {
                    for (int j = 1; j <= column; j++) {
                        if (index >= pairs) break;
                        int random = r.nextInt(gL.generatedPairs.size());
                        String symbol = gL.generatedPairs.get(random).symbol;
                        Pairs p = new Pairs(symbol, gL.generatedPairs.get(random).isGuessed, i, j);
                        for (int k = 0; k < Pairs.size(); k++) {
                            if (Pairs.get(k).equals(symbol)) {
                                gL.generatedPairs.remove(random);
                            }
                        }
                        genPairs.add(p);
                        Pairs.add(symbol);
                        index++;
                    }
                }
                for (int i = 1; i <= 2; i++) {
                    if (index >= pairs) break;
                    int random = r.nextInt(gL.generatedPairs.size());
                    String symbol = gL.generatedPairs.get(random).symbol;
                    Pairs p = new Pairs(symbol, gL.generatedPairs.get(random).isGuessed, row, i);
                    for (int k = 0; k < Pairs.size(); k++) {
                        if (Pairs.get(k).equals(symbol)) {
                            gL.generatedPairs.remove(random);
                        }
                    }
                    genPairs.add(p);
                    Pairs.add(symbol);
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println(">> Something went wrong");
        }
    }
}
package gameField;

import gameFunctions.AddingPairs;
import gameFunctions.Pairs;
import gameFunctions.GuessPosition;


/**
 * Checking pairs in the game
 */

public class CheckPairOnField {
    private AddingPairs aP;

    /**
     * Constructor for checking the pairs
     * @param aP Entrance of class with symbols
     */
    public CheckPairOnField(AddingPairs aP) {
        this.aP = aP;
    }

    /**
     * Checking the symbols
     * @param first First symbol
     * @param second Second symbol
     * @return True or False, dependet on input values
     */

    public boolean checkPair(GuessPosition first, GuessPosition second) {
        String symbol1 = getSymbolAt(first);
        String symbol2 = getSymbolAt(second);
        return symbol1.equals(symbol2);
    }

    /**
     * Reveal symbol on the specific position
     * @param gP guess the player
     * @return Symbol dependet on guess, shows symbols on right place on field
     */

    public String getSymbolAt(GuessPosition gP) {
        for (Pairs pair : aP.genPairs) {
            if (pair.getRow() == gP.getRow() && pair.getCol() == gP.getColumn()) {
                return pair.getSymbol();
            }
        }
        return "~";
    }
}
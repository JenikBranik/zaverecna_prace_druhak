package gameField;

import gameFunctions.Pairs;
import gameFunctions.addingPairs;
import gameFunctions.guessPosition;

public class CheckPairOnField {
    private addingPairs aP;

    public CheckPairOnField(addingPairs aP) {
        this.aP = aP;
    }

    public boolean checkPair(guessPosition first, guessPosition second) {
        String symbol1 = getSymbolAt(first);
        String symbol2 = getSymbolAt(second);
        return symbol1.equals(symbol2);
    }

    public String getSymbolAt(guessPosition gP) {
        for (Pairs pair : aP.genPairs) {
            if (pair.getRow() == gP.getRow() && pair.getCol() == gP.getColumn()) {
                return pair.getSymbol();
            }
        }
        return "~";
    }
}
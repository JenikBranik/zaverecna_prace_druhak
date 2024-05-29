package gameFunctions;

/**
 * Defines symbols
 */

public class Symbol {
    String symbol;
    boolean isGuessed;

    public Symbol(String symbol, boolean isGuessed) {
        this.symbol = symbol;
        this.isGuessed = isGuessed;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isGuessed() {
        return isGuessed;
    }

    public void setGuessed(boolean guessed) {
        isGuessed = guessed;
    }

    public void reveal() {
        isGuessed = true;
    }

    public void hide() {
        isGuessed = false;
    }
}

package gameFunctions;

/**
 * Defined pairs
 */

public class Pairs extends Symbol {
    protected int row;
    protected int col;

    /**
     * Constructor for pairs
     * @param symbol symbol
     * @param isGuessed truth/false about guessed symbols
     * @param row row
     * @param col column
     */

    public Pairs(String symbol, boolean isGuessed, int row, int col) {
        super(symbol, isGuessed);
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}

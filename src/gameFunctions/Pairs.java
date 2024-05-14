package gameFunctions;

public class Pairs extends Symbol {
    protected int row;
    protected int col;

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

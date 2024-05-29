package gameFunctions;

/**
 * Defines guess position
 */

public class GuessPosition {
    public int row;
    public int column;

    public GuessPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // setter
    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    //getter
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
package gameField;

public class generateField {

    public void generateField(int addCard) {
        addCard += addCard;
        int rows = (addCard + 3) / 4;
        int cols = 4;
        String space = " ";

        for (int column = 0; column < cols + 1; column++) {
            if (column == 0) {
                System.out.print(space.repeat(4));
            } else {
                System.out.print(column + space.repeat(3));
            }
        }
        System.out.println();
        System.out.println();

        for (int row = 1; row <= rows; row++) {
            if (row >= 10) {
                System.out.print(row + space.repeat(2));
            } else {
                System.out.print(row + space.repeat(3));
            }
            for (int col = 1; col <= cols; col++) {
                if ((row - 1) * cols + col > addCard) break; // Pokud přesáhne počet karet
                System.out.print("~" + space.repeat(3));
            }

            System.out.println();
            System.out.println();
        }
    }
}

package gameField;

import gameFunctions.addingPairs;

public class Field {
    public static final String space = " ";
    public String nextSymbol = "~";


    public void showField(int addCard) {
        addingPairs aP = new addingPairs();
        aP.setGenPairs(addCard);
        for (int column = 0; column < 5; column++) {
            if (column == 0) {
                System.out.print(space.repeat(4));
            } else {
                System.out.print(column + space.repeat(3));
            }
        }
        System.out.println();
        System.out.println();
        for (int row = 0; row < addCard / 2; row++) {
            if (row >= 10) {
                System.out.print(row + 1 + space.repeat(2));
            } else {
                System.out.print(row + 1 + space.repeat(3));
            }
            for (int i = 0; i < 4; i++) {
                nextSymbol = aP.genPairs.get(i).getSymbol();
                System.out.print(nextSymbol + space.repeat(3));
            }

            System.out.println();
            System.out.println();
        }
        if (addCard % 2 != 0) {

            if (addCard / 2 > 10 && addCard / 2 < 10) {
                System.out.print(addCard / 2 + 1 + space.repeat(2));
            } else {
                System.out.print(addCard / 2 + 1 + space.repeat(3));
            }
            System.out.print(nextSymbol + space.repeat(3));
            System.out.print(nextSymbol + space.repeat(3));
        }
    }
}


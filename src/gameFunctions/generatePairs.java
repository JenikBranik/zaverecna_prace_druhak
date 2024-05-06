package gameFunctions;

import java.util.ArrayList;

public class generatePairs {

     ArrayList<Symbol> generatedPairs = new ArrayList<>();

    public ArrayList<Symbol> setGeneratedPairs(int countOfPairs) {
        char startChar = 65;
        char endChar = 121;
        int counter = 0;
        String returnChar;
        for (int i = 0; i < countOfPairs; i++) {
            char currentChar = (char) (startChar + i);
            returnChar = String.valueOf(currentChar);
            if (currentChar > 90) {
                currentChar += 6;
                returnChar = String.valueOf(currentChar);
                if (currentChar > endChar) {
                    char add = (char) (startChar + counter);
                    returnChar = String.valueOf(startChar) + String.valueOf(add);
                    counter++;
                }
            }
            Symbol s = new Symbol(returnChar,false);
            generatedPairs.add(s);
        }
        for (int i = 0; i < countOfPairs; i++) {
            System.out.print(generatedPairs.get(i).symbol + " ");
            System.out.println(generatedPairs.get(i).isGuessed);
        }
        return generatedPairs;
    }

}
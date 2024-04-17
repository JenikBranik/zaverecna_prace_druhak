package gameFunctions;

import java.util.ArrayList;
import java.util.List;

public class generatePairs {


    public List<String> generatePairs(int numberOfPairs) {
        List<String> motifs = new ArrayList<>();
        char currentMotif = 'A';
        for (int i = 0; i < numberOfPairs; i++) {
            motifs.add(String.valueOf(currentMotif));
            motifs.add(String.valueOf(currentMotif));
            currentMotif++;
        }
        return motifs;
    }
}

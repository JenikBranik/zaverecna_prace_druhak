import Player.*;
import gameFunctions.GenerateLetters;
import gameFunctions.Symbol;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class UnitTest {

    @Test
    public void tieTest() {
        // Prepare test data
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Alice", 10));
        players.add(new Player("Bob", 10));

        // Create instance of WinnerCheck
        WinnerCheck winnerCheck = new WinnerCheck();

        String result = winnerCheck.winner(players);

        assertEquals("Nobody", result);
    }

    @Test
    public void singlePlayerTest() {
        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Alice", 10));

        WinnerCheck winnerCheck = new WinnerCheck();

        String result = winnerCheck.winner(players);

        assertEquals("Alice", result);
    }

    @Test
    public void testSetGeneratedPairsWithSmallCount() {
        GenerateLetters gl = new GenerateLetters();
        ArrayList<Symbol> result = gl.setGeneratedPairs(5);
        ArrayList<Symbol> expected = new ArrayList<>();
        expected.add(new Symbol("A", false));
        expected.add(new Symbol("B", false));
        expected.add(new Symbol("C", false));
        expected.add(new Symbol("D", false));
        expected.add(new Symbol("E", false));

        assertEquals(expected, result);
    }



}
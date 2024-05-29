package Player;

import java.util.ArrayList;

/**
 * Class checking the player, who won
 */

public class WinnerCheck {

    /**
     * Mehod checking winner
     * @param players List of all players
     * @return Winner of the game, if some won, if not, there is option of nobody wons
     */

    public String winner(ArrayList<Player> players) {
        int max = 0;
        String winner = "";
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() > max) {
                max = players.get(i).getScore();
                winner = players.get(i).getUsername();
            } else if (players.get(i).getScore() == max) {
                winner = "Nobody";
            }
        }
        return winner;
    }
}

package Player;

import java.util.ArrayList;

public class WinnerCheck {
    private ArrayList<Integer> score;

    public String winner(ArrayList<Player> players) {
        int max = 0;
        String winner = "";
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getScore() > max) {
                max = players.get(i).getScore();
                winner = players.get(i).getUsername();
            } else if (players.get(i).getScore() == max) {
                winner = "Nikdo";
            }
        }
        return winner;
    }
}

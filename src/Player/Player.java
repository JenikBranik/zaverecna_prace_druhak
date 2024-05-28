package Player;

public class Player {
    String username;
    int ID;
    int score=0;

    public Player() {
    }
    public Player(String username, int ID) {
        this.username = username;
        this.ID = ID;
        this.score=0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score=score;
    }
}

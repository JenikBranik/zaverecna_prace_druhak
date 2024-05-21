package Player;

public class Player {
    String username;
    int ID;

    public Player() {
    }
    public Player(String username, int ID) {
        this.username = username;
        this.ID = ID;
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
}

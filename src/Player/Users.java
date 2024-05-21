package Player;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<Player> users;

    // Defaultní konstruktor potřebný pro Jackson
    public Users() {
    }

    public Users(ArrayList<Player> users) {
        this.users = users;
    }

    public List<Player> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Player> users) {
        this.users = users;
    }
}
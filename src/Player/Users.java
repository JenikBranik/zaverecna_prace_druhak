package Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Class defines User head in JSON files
 */

public class Users {
    private List<Player> users;

    /**
     * Constructor for Jackson addon
     */

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
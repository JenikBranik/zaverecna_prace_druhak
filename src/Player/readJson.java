package Player;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class on reading the JSON file
 */

public class readJson {
    ObjectMapper mapper = new ObjectMapper();
    public ArrayList<String> usernames = new ArrayList<>();

    /**
     * Method on reading JSON file
     * @return Usernames of all added players
     */

    public ArrayList<String> readJson() {
        try {
            Users users = mapper.readValue(new File("players.json"), Users.class);

            for (Player player : users.getUsers()) {
                usernames.add(player.getUsername());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usernames;
    }
}
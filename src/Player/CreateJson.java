package Player;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Create JSON file
 */
public class CreateJson {

    /**
     *  Create defines JSON file
     */
    public void createJson() {
        CountOfUsers countOfUsers = new CountOfUsers();
        countOfUsers.getCountOfUsers();
        SetAll setAll = new SetAll();

        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < countOfUsers.countOfUsers; i++) {
            setAll.getUsername(i+1);
            players.add(new Player(setAll.username, players.size() + 1));
        }

        Users usersWrapper = new Users(players);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(new File("players.json"), usersWrapper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package Player;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class createJson {

    public void metoda() {
        countOfUsers countOfUsers = new countOfUsers();
        countOfUsers.getCountOfUsers();
        SetAll setAll = new SetAll();

        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < countOfUsers.countOfUsers; i++) {
            setAll.getUsername();
            players.add(new Player(setAll.username, players.size() + 1));
        }

        Users usersWrapper = new Users(players);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);  // Pro pěkné formátování JSON

        try {
            mapper.writeValue(new File("players.json"), usersWrapper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
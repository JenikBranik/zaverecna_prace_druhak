package Player;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class readJson {
    ObjectMapper mapper = new ObjectMapper();
    ArrayList<String> usernames = new ArrayList<>();

    public void readJson() {
        try {
            // Přečteme JSON soubor a deserializujeme jej do objektu Users
            Users users = mapper.readValue(new File("players.json"), Users.class);

            // Pro každého hráče v seznamu extrahujeme username a přidáme do ArrayListu
            for (Player player : users.getUsers()) {
                usernames.add(player.getUsername());
            }

            // Vypsání uživatelských jmen
            for (String username : usernames) {
                System.out.println(username);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
package Player;

import command.console.Console;

import java.util.Scanner;

/**
 * Defines count of users
 */

public class CountOfUsers {

    protected int countOfUsers;
    Console console = new Console();

    /**
     * Asks for count of players
     * @return number of players
     */

    public int getCountOfUsers(){
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println(">> How many players gonna play? ");
            countOfUsers = sc.nextInt();
            console.saveCommand(String.valueOf(countOfUsers));
        }catch(Exception e){
            e.printStackTrace();
        }
        return countOfUsers;
    }
}

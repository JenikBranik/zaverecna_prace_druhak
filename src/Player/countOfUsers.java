package Player;

import command.console.Console;

import java.util.Scanner;

public class countOfUsers {

    protected int countOfUsers;
    Console console = new Console();

    public int getCountOfUsers(){
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println(">> Kolik uživatelů bude hrát? ");
            countOfUsers = sc.nextInt();
            console.saveCommand(String.valueOf(countOfUsers));
        }catch(Exception e){
            e.printStackTrace();
        }
        return countOfUsers;
    }
}

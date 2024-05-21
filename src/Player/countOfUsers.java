package Player;

import java.util.Scanner;

public class countOfUsers {

    protected int countOfUsers;

    public int getCountOfUsers(){
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println(">> Kolik uživatelů bude hrát? ");
            countOfUsers = sc.nextInt();
        }catch(Exception e){
            e.printStackTrace();
        }
        return countOfUsers;
    }
}

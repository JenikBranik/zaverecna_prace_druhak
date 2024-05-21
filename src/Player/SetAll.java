package Player;

import java.util.Scanner;

public class SetAll {

    protected String username;

    public String getUsername(){

        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(">> Jaké chce mít uživatel jméno? ");
            username = sc.nextLine();
        }catch (Exception e){
            e.printStackTrace();
        }
        return username;
    }
}

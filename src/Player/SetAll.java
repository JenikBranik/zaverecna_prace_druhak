package Player;

import java.util.Scanner;

/**
 * Class setting players
 */
public class SetAll {

    protected String username;

    /**
     * Method setting players
     * @param index index for recognize
     * @return Username for entry
     */
    public String getUsername(int index){

        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(">> What name does the player"+index+" want to have? ");
            username = sc.nextLine();
        }catch (Exception e){
            return " ";
        }
        return username;
    }
}

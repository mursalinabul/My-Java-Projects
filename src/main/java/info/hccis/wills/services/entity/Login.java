package info.hccis.wills.services.entity;

import info.hccis.util.CisUtility;
import java.util.HashMap;

/**
 * This class will contain the hashMap with names and password
 *
 * @author AFM Mursalin
 * @since Mar. 8, 2022
 */
public class Login {
    
    public boolean isValid = false;
    
    public String userEnteredName;

    private HashMap<String, String> userMap = new HashMap();

    private String[] userNameArray = {"John", "Steve", "Bonnie", "Kylie", "Logan", "Robert"};
    private String[] passwordArray = {"1111", "2222", "3333", "4444", "5555", "6666"};

    /**
     * This method will put the name and password in HashMap
     *
     * @author AFM Mursalin
     * @since Mar. 8, 2022
     */
    public void loadCredential() {
        for (int i = 0; i < userNameArray.length; i++) {

            userMap.put(userNameArray[i], passwordArray[i]);

        }

    }

    public boolean login() {

        

        userEnteredName = CisUtility.getInputString("Username:");

        if (userMap.containsKey(userEnteredName)) {

            String userEnteredPassword = CisUtility.getInputString("Password:");

            if (userMap.containsValue(userEnteredPassword)) {

                isValid = true;

            } else {

                System.out.println("Invalid login, please try again.");
            }

        } else {

            System.out.println("Invalid login, please try again.");

        }

        return isValid;
    }

}

package loginPage.dataUser;

import java.util.HashMap;

public class hardcodedUser {

    private static final HashMap <String, User> userData = new HashMap<>();

    // Hardcode user
    static {
        userData.put("Putera", new User("Puterayasa", "putera123", Role.ADMIN));
        userData.put("Arya", new User ("Aryawikananda", "arya321", Role.CUSTOMER));
        userData.put("Eri", new User ("Eriwidura", "eri333", Role.CUSTOMER));
    }

    // method untuk menemukan user dari username
    public static User temukanUser(String usersname) {
        for (User user : userData.values()) {
            if (user.getUsername().equals(usersname)) {
                return user;
            }
        }
        return null;
    }

}

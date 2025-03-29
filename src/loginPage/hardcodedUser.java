package loginPage;

import java.util.HashMap;

public class hardcodedUser {
    private static final HashMap <String, User> userData = new HashMap<>();

    static {
        userData.put("Putera", new User("Puterayasa", "putera123", Role.ADMIN));
        userData.put("Arya", new User ("Aryawikananda", "arya321", Role.CUSTOMER));
        userData.put("Eri", new User ("Eriwidura", "eri333", Role.CUSTOMER));
    }

    public static User findUser(String findUser) {
        for (User user : userData.values()) {
            if (user.getUsername().equals(findUser)) {
                return user;
            }
        }
        return null;
    }
}

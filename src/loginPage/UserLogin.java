package loginPage;

import java.util.HashMap;
import java.util.Map;

public class UserLogin {
    // HashMap untuk menyimpan username dan password berdasarkan role pengguna
    private static final Map<Role, String[]> users = new HashMap<>();
    // Inisialisasi data pengguna dengan hardcoded values
    static {
        users.put(Role.ADMIN, new String[]{"Puterayasa", "puteraterbaik123"});
        users.put(Role.CUSTOMER, new String[]{"Aryawikananda", "aryaterbaik123"});
    }
    // Method untuk memvalidasi login berdasarkan role, username, dan password
    public static boolean authentication (Role role, String username, String password){
        return users.containsKey(role) && users.get(role)[0].equals(username) && users.get(role)[1].equals((password));
    }
}

package loginPage;

import java.util.Scanner;

public class AuthenticationUser {
    public static void authenticationUser (){
        Scanner scanner = new Scanner (System.in);

        System.out.print("Masukkan role / peran anda (hanya admin atau customer): ");
        String roleInput = scanner.nextLine().toUpperCase();

        Role role;
        try {
            role = Role.valueOf(roleInput);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Peran tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan username anda: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password anda: ");
        String password = scanner.nextLine();

        checkUser(role, username, password);

    }

    private static void checkUser (Role role, String username, String password){
        User user = hardcodedUser.findUser(username);

        if (user == null) System.out.println("Username tidak ditemukan!");
        else if (user.getRole() != role) System.out.println("Peran tidak sesuai!");
        else if (!user.getPassword().equals(password)) System.out.println("Password salah!");
        else ;
    }
}

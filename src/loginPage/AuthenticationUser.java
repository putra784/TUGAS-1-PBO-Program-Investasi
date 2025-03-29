package loginPage;

import java.util.Scanner;

public class AuthenticationUser {
    public static void authenticationUser (){
        Scanner scanner = new Scanner (System.in);

        System.out.print("Masukkan role / bagian anda (admin / customer): ");
        String roleInput = scanner.nextLine().toUpperCase();

        Role role;
        try {
            role = Role.valueOf(roleInput);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Bagian tidak ditemukan!");
            System.exit(1);
            return;
        }

        System.out.print("Masukkan username anda: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password anda: ");
        String password = scanner.nextLine();

        User user = hardcodedUser.findUser(username);

        if (user == null) System.out.println("Username tidak ditemukan!");
        else if (user.getRole() != role) System.out.println("Peran tidak sesuai!");
        else if (!user.getPassword().equals(password)) System.out.println("Password salah!");
        else System.out.println("Gai");;


    }
}

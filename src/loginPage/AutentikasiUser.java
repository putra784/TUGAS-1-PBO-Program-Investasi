package loginPage;

import menu.MenuHandler;
import java.util.Scanner;

public class AutentikasiUser {

    static MenuHandler menuHandler = new MenuHandler();

    public static void autentikasiUser (){
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

        cekUser(role, username, password, roleInput);

    }

    private static void cekUser (Role role, String username, String password, String roleInput){
        User user = hardcodedUser.findUser(username);

        if (user == null) System.out.println("Username tidak ditemukan!");
        else if (user.getRole() != role) System.out.println("Peran tidak sesuai!");
        else if (!user.getPassword().equals(password)) System.out.println("Password salah!");
        else {
            if (roleInput.equals("CUSTOMER")) menuHandler.displayCustomerMenu();
            else menuHandler.displayAdminMenu();
        }
    }
}

package loginPage;

import menu.MenuHandler;
import utility.InputUser; // <- Import utility InputUser

public class AutentikasiUser {

    public static void autentikasiUser() {
        String roleInput = InputUser.nextLine("Masukkan role / peran anda (hanya admin atau customer): ").toUpperCase();

        Role role;
        try {
            role = Role.valueOf(roleInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Peran tidak ditemukan!");
            return;
        }

        String username = InputUser.nextLine("Masukkan username anda: ");
        String password = InputUser.nextLine("Masukkan password anda: ");

        cekUser(role, username, password, roleInput);
    }

    private static void cekUser(Role role, String username, String password, String roleInput) {
        User user = hardcodedUser.findUser(username);

        if (user == null) {
            System.out.println("Username tidak ditemukan!");
        } else if (user.getRole() != role) {
            System.out.println("Peran tidak sesuai!");
        } else if (!user.getPassword().equals(password)) {
            System.out.println("Password salah!");
        } else {
            if (roleInput.equals("CUSTOMER")) {
                MenuHandler.displayCustomerMenu();
            } else {
                MenuHandler.displayAdminMenu();
            }
        }
    }
}

package loginPage;

import loginPage.dataUser.Role;
import loginPage.dataUser.User;
import loginPage.dataUser.hardcodedUser;
import menu.MenuHandler;
import utility.InputUser;

public class AutentikasiUser {

    // method pemanggilan untuk handle input user
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

    // method untuk pengecekan user
    private static void cekUser(Role role, String username, String password, String roleInput) {
        User user = hardcodedUser.temukanUser(username);

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

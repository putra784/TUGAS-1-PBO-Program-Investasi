package loginPage;

import loginPage.dataUser.Role;
import loginPage.dataUser.User;
import loginPage.dataUser.hardcodedUser;
import menu.MenuHandler;
import utility.InputUser;

public class AutentikasiUser {

    public static void autentikasiUser() {
        Role role;
        String roleInput;

        // LOOP untuk input role sampai valid
        while (true) {
            roleInput = InputUser.nextLine("Masukkan role / peran anda (hanya admin atau customer): ").toUpperCase();
            try {
                role = Role.valueOf(roleInput);
                break; // keluar loop jika role valid
            } catch (IllegalArgumentException e) {
                System.out.println("Peran tidak ditemukan! Silakan coba lagi.\n");
            }
        }

        // LOOP untuk input username sampai valid
        User user;
        while (true) {
            String username = InputUser.nextLine("Masukkan username anda: ");
            user = hardcodedUser.temukanUser(username);

            if (user == null) {
                System.out.println("Username tidak ditemukan! Silakan coba lagi.\n");
            } else if (user.getRole() != role) {
                System.out.println("Peran tidak sesuai dengan akun ini! Silakan coba username lain.\n");
            } else {
                break; // username ditemukan dan cocok dengan role
            }
        }

        // LOOP untuk input password sampai benar
        while (true) {
            String password = InputUser.nextLine("Masukkan password anda: ");
            if (!user.getPassword().equals(password)) {
                System.out.println("Password salah! Silakan coba lagi.\n");
            } else {
                // login berhasil
                System.out.println("Login berhasil sebagai " + roleInput + "!");
                if (roleInput.equals("CUSTOMER")) {
                    MenuHandler.displayCustomerMenu();
                } else {
                    MenuHandler.displayAdminMenu();
                }
                break;
            }
        }
    }
}

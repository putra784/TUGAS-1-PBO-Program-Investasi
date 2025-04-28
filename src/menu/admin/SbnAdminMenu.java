package menu.admin;

import menu.MenuHandler;
import menu.admin.sbn.TambahSbn;
import utility.InputUser;

public class SbnAdminMenu {

    // Tampilan pilihan menu sbn admin
    public static void displaySbnAdminMenu() {
        System.out.println("|==============================|");
        System.out.println("|        MENU SBN ADMIN        |");
        System.out.println("|==============================|");
        System.out.println("|1. Tambah SBN                 |");
        System.out.println("|2. Kembali                    |");
        System.out.println("|==============================|");

        int pilihMenu = inputPilihan();
        choice(pilihMenu);
    }

    private static int inputPilihan() {
        while (true) {
            String input = InputUser.nextLine("Pilih menu SBN yang anda inginkan: ");
            try {
                int pilihMenu = Integer.parseInt(input);
                return pilihMenu;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka yang sesuai!");
            }
        }
    }

    // Method untuk mencari tahu pilihan
    private static void choice(int pilihMenu) {
        switch (pilihMenu) {
            case 1 : TambahSbn.tambahSbn();
            case 2 : MenuHandler.displayAdminMenu();
            default : {
                System.out.println("Masukkan pilihan yang valid!");
                displaySbnAdminMenu();
            }
        }
    }
}

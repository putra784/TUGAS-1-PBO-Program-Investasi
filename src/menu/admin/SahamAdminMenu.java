package menu.admin;

import java.util.Scanner;

import menu.MenuHandler;
import menu.admin.saham.*;

public class SahamAdminMenu {

    // Tampilan pilihan menu saham admin
    public static void displaySahamAdminMenu(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("|==============================|");
        System.out.println("|       MENU SAHAM ADMIN       |");
        System.out.println("|==============================|");
        System.out.println("|1. Tambah Saham               |");
        System.out.println("|2. Ubah Harga Saham           |");
        System.out.println("|3. Kembali                    |");
        System.out.println("|==============================|");
        System.out.print("Pilih menu saham yang anda inginkan: ");
        int chooseAdminMenu = scanner.nextInt();
        pilihan(chooseAdminMenu);
    }

    // Method untuk mencari tahu pilihan
    private static void pilihan(int chooseAdminMenu) {
        switch (chooseAdminMenu) {
            case 1 : TambahSaham.tambahSahamBaru();
            case 2 : UbahHargaSaham.ubahHarga();
            case 3 : MenuHandler.displayAdminMenu();
            default : {
                System.out.println("Pilih menu yang valid");
                displaySahamAdminMenu();
            }
        }
    }
}

package menu;

import utility.InputUser;
import menu.admin.*;
import menu.customer.*;
import menu.customer.portofolio.PortofolioLists;

public class MenuHandler {

    // Method untuk menampilkan pilihan admin
    public static void displayAdminMenu() {
        System.out.println("|==============================|");
        System.out.println("|          MENU ADMIN          |");
        System.out.println("|==============================|");
        System.out.println("|1. Saham                      |");
        System.out.println("|2. SBN                        |");
        System.out.println("|3. Logout                     |");
        System.out.println("|==============================|");

        int chooseMenu = InputUser.nextInt("Pilih menu yang anda inginkan: ");
        pilihanAdmin(chooseMenu);
    }

    // Method untuk menampilkan pilihan customer
    public static void displayCustomerMenu() {
        System.out.println("|===================================|");
        System.out.println("|           MENU CUSTOMER           |");
        System.out.println("|===================================|");
        System.out.println("|1. Beli Saham                      |");
        System.out.println("|2. Jual Saham                      |");
        System.out.println("|3. Beli SBN                        |");
        System.out.println("|4. Simulasi SBN                    |");
        System.out.println("|5. Portofolio Customer             |");
        System.out.println("|6. Logout                          |");
        System.out.println("|===================================|");

        int chooseMenu = InputUser.nextInt("Pilih menu yang anda inginkan: ");
        pilihanCustomer(chooseMenu);
    }

    // Method untuk mencari tahu pilihan customer
    private static void pilihanCustomer(int chooseMenu) {
        switch (chooseMenu) {
            case 1 -> BeliSaham.pilihSaham();
            case 2 -> JualSaham.jualSaham();
            case 3 -> BeliSbn.prosesPembelian();
            case 4 -> SimulasiSbn.simulasiSbn();
            case 5 -> PortofolioLists.displayPortofolioFull();
            case 6 -> {
                System.out.println("Anda berhasil logout");
                System.exit(0);
            }
            default -> {
                System.out.println("Masukkan pilihan yang valid!");
                displayCustomerMenu();
            }
        }
    }

    // Method untuk mencari tahu pilihan admin
    private static void pilihanAdmin(int chooseMenu) {
        switch (chooseMenu) {
            case 1 -> SahamAdminMenu.displaySahamAdminMenu();
            case 2 -> SbnAdminMenu.displaySbnAdminMenu();
            case 3 -> {
                System.out.println("Anda berhasil logout");
                System.exit(0);
            }
            default -> {
                System.out.println("Masukkan pilihan yang valid!");
                displayAdminMenu();
            }
        }
    }
}

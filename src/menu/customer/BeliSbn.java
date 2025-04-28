package menu.customer;

import menu.MenuHandler;
import menu.customer.portofolio.PortofolioLists;
import menu.customer.portofolio.PortofolioSbnCustomer;
import menu.sbnLists.SBN;
import menu.sbnLists.SbnLists;
import utility.InputUser;

import java.util.ArrayList;

public class BeliSbn {

    public static void prosesPembelian() {
        while (true) {
            tampilkanDaftarSbn();
            SBN sbnTerpilih = inputSbn();
            int jumlahUnit = inputJumlahUnit();

            simpanKePortofolio(sbnTerpilih, jumlahUnit);

            if (!lanjutBeli()) {
                break;
            }
        }
    }

    private static void tampilkanDaftarSbn() {
        System.out.println("=== Daftar SBN yang Tersedia ===");
        SbnLists.displayDaftarSBN();
    }

    private static SBN inputSbn() {
        ArrayList<SBN> daftarSbn = SbnLists.getDaftarSBN();
        SBN sbnTerpilih = null;
        while (sbnTerpilih == null) {
            String kodeSbn = InputUser.nextLine("Masukkan kode SBN yang ingin dibeli: ");

            for (SBN sbn : daftarSbn) {
                if (sbn.getKodeSbn().equalsIgnoreCase(kodeSbn)) {
                    sbnTerpilih = sbn;
                    break;
                }
            }

            if (sbnTerpilih == null) {
                System.out.println("Kode SBN tidak valid, coba lagi.");
            }
        }
        return sbnTerpilih;
    }

    private static int inputJumlahUnit() {
        int jumlahUnit = 0;
        while (true) {
            String input = InputUser.nextLine("Masukkan jumlah unit yang ingin dibeli: ");
            try {
                jumlahUnit = Integer.parseInt(input);
                if (jumlahUnit > 0) {
                    break;
                } else {
                    System.out.println("Jumlah unit harus lebih dari 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
        return jumlahUnit;
    }

    private static void simpanKePortofolio(SBN sbn, int jumlahUnit) {
        PortofolioSbnCustomer portofolio = new PortofolioSbnCustomer(sbn, jumlahUnit);
        PortofolioLists.addPortofolioSbn(portofolio);
        System.out.println("Pembelian berhasil ditambahkan ke portofolio Anda!\n");
    }

    private static boolean lanjutBeli() {
        while (true) {
            System.out.println("\n1. Lanjutkan membeli SBN");
            System.out.println("2. Kembali ke menu utama");
            String pilihan = InputUser.nextLine("Pilih: ");

            if (pilihan.equals("1")) {
                return true;
            } else if (pilihan.equals("2")) {
                MenuHandler.displayCustomerMenu();
                return false;
            } else {
                System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
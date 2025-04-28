package menu.customer;

import java.util.ArrayList;
import menu.MenuHandler;
import menu.customer.portofolio.PortofolioLists;
import menu.customer.portofolio.PortofolioSahamCustomer;
import menu.sahamLists.Saham;
import menu.sahamLists.SahamLists;
import utility.InputUser;

public class BeliSaham {

    private static final ArrayList<Saham> daftarSaham = SahamLists.getSahamList();

    // method utama untuk proses pembelian saham
    public static void pilihSaham() {
        boolean lanjut = true;
        while (lanjut) {
            tampilkanDaftarSaham();
            String kodeSaham = InputUser.nextLine("Masukkan kode saham yang ingin Anda beli: ").toUpperCase();
            int jumlahLembar = inputJumlahLembar();
            prosesPembelian(kodeSaham, jumlahLembar);
            lanjut = tanyaPilihanLanjutan();
        }
    }

    // menampilkan daftar saham
    private static void tampilkanDaftarSaham() {
        System.out.println("=== Daftar Saham ===");
        SahamLists.displaySaham();
    }

    // input jumlah lembar yang ingin dibeli
    private static int inputJumlahLembar() {
        while (true) {
            String input = InputUser.nextLine("Masukkan jumlah lembar yang ingin Anda beli: ");
            try {
                int jumlah = Integer.parseInt(input);
                if (jumlah > 0) {
                    return jumlah;
                } else {
                    System.out.println("Jumlah lembar harus lebih dari 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
            }
        }
    }

    // proses pembelian saham berdasarkan kode dan jumlah lembar
    private static void prosesPembelian(String kodeSaham, int jumlahLembar) {
        Saham sahamTerpilih = cariSahamByKode(kodeSaham);
        if (sahamTerpilih != null) {
            tambahKePortofolio(sahamTerpilih, jumlahLembar);
        } else {
            System.out.println("Kode saham tidak ditemukan!\n");
        }
    }

    // mencari saham berdasarkan kode
    private static Saham cariSahamByKode(String kode) {
        for (Saham saham : daftarSaham) {
            if (saham.getCode().equalsIgnoreCase(kode)) {
                return saham;
            }
        }
        return null;
    }

    // menambahkan saham yang dibeli ke portofolio
    private static void tambahKePortofolio(Saham saham, int jumlahLembar) {
        PortofolioSahamCustomer portofolio = new PortofolioSahamCustomer(
                saham.getCode(),
                saham.getCompanyName(),
                jumlahLembar,
                saham.getHarga()
        );
        PortofolioLists.addPortofolioSaham(portofolio);
        System.out.println("Pembelian berhasil! Data dapat dicek pada menu portofolio.\n");
    }

    // tanya user ingin beli lagi atau kembali ke menu
    private static boolean tanyaPilihanLanjutan() {
        while (true) {
            System.out.println("\nApa yang ingin Anda lakukan selanjutnya:");
            System.out.println("1. Membeli saham lagi");
            System.out.println("2. Kembali ke menu utama");
            String input = InputUser.nextLine("Masukkan pilihan Anda: ");

            try {
                int pilihan = Integer.parseInt(input);
                if (pilihan == 1) {
                    System.out.println("\nMengulang program pembelian...\n");
                    return true;
                } else if (pilihan == 2) {
                    MenuHandler.displayCustomerMenu();
                    return false;
                } else {
                    System.out.println("Pilihan hanya 1 atau 2. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka 1 atau 2.");
            }
        }
    }
}
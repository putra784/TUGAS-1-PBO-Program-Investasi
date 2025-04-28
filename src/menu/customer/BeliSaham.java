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
            Saham sahamTerpilih = inputKodeSaham(); // pengecekan kode langsung di sini
            int jumlahLembar = inputJumlahLembar();
            tambahKePortofolio(sahamTerpilih, jumlahLembar);
            lanjut = tanyaPilihanLanjutan();
        }
    }

    // menampilkan daftar saham
    private static void tampilkanDaftarSaham() {
        System.out.println("Daftar Saham");
        SahamLists.displaySaham();
    }

    // input kode saham yang valid
    private static Saham inputKodeSaham() {
        while (true) {
            String kodeSaham = InputUser.nextLine("Masukkan kode saham yang ingin Anda beli: ").toUpperCase();
            Saham sahamTerpilih = cariSahamByKode(kodeSaham);
            if (sahamTerpilih != null) {
                return sahamTerpilih;
            } else {
                System.out.println("Kode saham tidak ditemukan. Silakan masukkan kode yang valid.\n");
            }
        }
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

    // mencari saham berdasarkan kode
    private static Saham cariSahamByKode(String kode) {
        for (Saham saham : daftarSaham) {
            if (saham.getKode().equalsIgnoreCase(kode)) {
                return saham;
            }
        }
        return null;
    }

    // Menambahkan saham yang dibeli ke portofolio
    private static void tambahKePortofolio(Saham saham, int jumlahLembar) {
        // Cari apakah saham tersebut sudah ada di portofolio
        PortofolioSahamCustomer existingPortofolio = cariPortofolioSaham(saham.getKode());

        if (existingPortofolio != null) {
            // Jika sudah ada, tambahkan jumlah lembar saham yang dibeli
            int totalLembar = existingPortofolio.getJumlahLembar() + jumlahLembar;
            existingPortofolio.setJumlahLembar(totalLembar);
            System.out.println("Jumlah lembar saham yang sudah ada diperbarui! Total lembar: " + totalLembar);
        } else {
            // Jika belum ada, tambahkan saham baru ke portofolio
            PortofolioSahamCustomer newPortofolio = new PortofolioSahamCustomer(
                    saham.getKode(),
                    saham.getNamaPerusahaan(),
                    jumlahLembar,
                    saham.getHarga()
            );
            PortofolioLists.addPortofolioSaham(newPortofolio);
            System.out.println("Pembelian saham baru berhasil! Data dapat dicek pada menu portofolio.");
        }
    }

    // Mencari portofolio saham berdasarkan kode saham
    private static PortofolioSahamCustomer cariPortofolioSaham(String kodeSaham) {
        for (PortofolioSahamCustomer portofolio : PortofolioLists.getPortofolioSahamList()) {
            if (portofolio.getSahamCodeCustomer().equals(kodeSaham)) {
                return portofolio;
            }
        }
        return null;
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
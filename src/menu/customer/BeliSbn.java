package menu.customer;

import menu.MenuHandler;
import menu.customer.portofolio.PortofolioLists;
import menu.customer.portofolio.PortofolioSbnCustomer;
import menu.sbnLists.SBN;
import menu.sbnLists.SbnLists;
import utility.InputUser;

import java.util.ArrayList;

public class BeliSbn {

    // Method utama untuk proses pembelian SBN
    public static void prosesPembelian() {
        while (true) {
            displayDaftarSbn();
            SBN sbnTerpilih = inputSbn();
            double nominalInvestasi = inputNominalInvestasi();

            simpanKePortofolio(sbnTerpilih, nominalInvestasi);

            if (!lanjutBeli()) {
                break;
            }
        }
    }

    // Menampilkan daftar SBN
    private static void displayDaftarSbn() {
        System.out.println("Daftar SBN yang Tersedia:");
        SbnLists.displayDaftarSBN();
    }

    // Input SBN yang diinginkan pengguna dan pengecekan
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

    // Input nominal investasi yang diinginkan pengguna
    private static double inputNominalInvestasi() {
        double nominalInvestasi;

        while (true) {
            String input = InputUser.nextLine("Masukkan nominal investasi yang ingin dibeli (minimal Rp1.000.000): ");
            try {
                nominalInvestasi = Double.parseDouble(input);
                if (nominalInvestasi >= 1000000) {
                    break;
                } else {
                    System.out.println("Nominal investasi minimal Rp1.000.000.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
        return nominalInvestasi;
    }

    // Proses penyimpanan kedalam portofolio
    private static void simpanKePortofolio(SBN sbn, double nominalInvestasi) {
        // Cari apakah SBN sudah ada dalam portofolio
        PortofolioSbnCustomer existingPortofolio = cariPortofolioSbn(sbn.getKodeSbn());

        if (existingPortofolio != null) {
            // Jika SBN sudah ada, tambahkan unit baru ke portofolio yang sudah ada
            existingPortofolio.tambahUnit(nominalInvestasi, sbn);
            System.out.println("Jumlah unit SBN yang sudah ada diperbarui!\n");
        } else {
            // Jika SBN belum ada, buat portofolio baru dan tambahkan ke daftar
            PortofolioSbnCustomer newPortofolio = new PortofolioSbnCustomer(sbn, nominalInvestasi);
            PortofolioLists.addPortofolioSbn(newPortofolio);
            System.out.println("Pembelian SBN baru berhasil ditambahkan ke portofolio Anda!\n");
        }
    }

    // Mencari portofolio SBN berdasarkan kode SBN
    private static PortofolioSbnCustomer cariPortofolioSbn(String kodeSbn) {
        for (PortofolioSbnCustomer portofolioSbn : PortofolioLists.portofolioSbnList) {
            if (portofolioSbn.getSbn().getKodeSbn().equals(kodeSbn)) {
                return portofolioSbn;
            }
        }
        return null;
    }

    // Validasi apakah lanjut beli atau tidak
    private static boolean lanjutBeli() {
        while (true) {
            System.out.println("1. Lanjutkan membeli SBN");
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
package menu.customer;

import menu.MenuHandler;
import menu.sbnLists.SBN;
import menu.sbnLists.SbnLists;
import utility.InputUser;

import java.util.ArrayList;

public class SimulasiSbn {

    // Method utama simulasi SBN
    public static void simulasiSbn() {
        while (true) {
            displayDaftarSbn();
            SBN sbnTerpilih = inputSbn();
            double nominalInvestasi = inputNominalInvestasi();

            hitungDanTampilkanSimulasi(sbnTerpilih, nominalInvestasi);

            if (!lanjutSimulasi()) {
                break;
            }
        }
    }

    // Menampilkan daftar SBN yang tersedia
    private static void displayDaftarSbn() {
        System.out.println("Daftar SBN untuk Simulasi");
        SbnLists.displayDaftarSBN();
    }

    // Input SBN yang dipilih user
    private static SBN inputSbn() {
        ArrayList<SBN> daftarSbn = SbnLists.getDaftarSBN();
        SBN sbnTerpilih = null;

        while (sbnTerpilih == null) {
            String kodeSbn = InputUser.nextLine("Masukkan kode SBN untuk simulasi: ");

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

    // Input nominal investasi
    private static double inputNominalInvestasi() {
        double nominal;

        while (true) {
            String input = InputUser.nextLine("Masukkan nominal investasi (minimal Rp1.000.000): ");
            try {
                nominal = Double.parseDouble(input);
                if (validasiNominal(nominal)) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
            }
        }
        return nominal;
    }

    // Method khusus untuk validasi nominal
    private static boolean validasiNominal(double nominal) {
        if (nominal < 1_000_000) {
            System.out.println("Nominal investasi harus minimal Rp1.000.000. Silakan coba lagi.");
            return false;
        }
        return true;
    }

    // Hitung dan tampilkan hasil simulasi
    private static void hitungDanTampilkanSimulasi(SBN sbn, double nominalInvestasi) {
        double bungaTahunan = sbn.getBunga();
        double kuponPerBulan = (bungaTahunan / 100) / 12 * 0.9 * nominalInvestasi;

        System.out.println("\nHasil Simulasi: ");
        System.out.println("Jenis SBN: " + sbn.getJenisSbn());
        System.out.printf("Nominal Investasi: Rp%.2f\n", nominalInvestasi);
        System.out.printf("Estimasi Kupon per Bulan: Rp%.2f\n", kuponPerBulan);
        System.out.println("------------------------------\n");
    }

    // Validasi lanjut simulasi atau kembali
    private static boolean lanjutSimulasi() {
        while (true) {
            System.out.println("\n1. Simulasi SBN lagi");
            System.out.println("2. Kembali ke menu utama");
            String pilihan = InputUser.nextLine("Pilih: ");

            if (pilihan.equals("1")) {
                return true;
            } else if (pilihan.equals("2")) {
                MenuHandler.displayCustomerMenu();
                return false;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
    }
}

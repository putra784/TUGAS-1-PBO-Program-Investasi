package menu.admin.saham;

import menu.admin.SahamAdminMenu;
import menu.sahamLists.SahamLists;
import utility.InputUser;
import menu.sahamLists.Saham;

public class TambahSaham {

    // Method untuk membaca input pengguna
    public static void tambahSahamBaru() {
        String kodeSahamBaru = InputUser.nextLine("Masukkan kode saham yang ingin anda tambahkan: ");
        String perusahaanSahamBaru = InputUser.nextLine("Masukkan nama perusahaannya: ");
        String hargaPerLembar = InputUser.nextLine("Masukkan harga per-lembar saham: ");
        prosesTambahSaham(kodeSahamBaru, perusahaanSahamBaru, hargaPerLembar);
    }

    // Method pada proses penambahan saham kedalam daftar saham
    private static void prosesTambahSaham(String kodeSaham, String namaPerusahaan, String hargaPerLembar) {
        if (!isNumber(hargaPerLembar)) {
            System.out.println("Input harga tidak valid! Silakan ulang kembali.");
            tambahSahamBaru();
            return;
        }

        if (kodeValidasi(kodeSaham)) {
            System.out.println("Kode saham sudah ada! Tidak bisa menambahkan saham yang sama.");
            tambahSahamBaru();
            return;
        }

        double harga = Double.parseDouble(hargaPerLembar);
        Saham sahamBaru = new Saham(kodeSaham, namaPerusahaan, harga);
        SahamLists.getSahamList().add(sahamBaru);
        System.out.println("Saham berhasil ditambahkan!");
        System.out.println("Berikut tampilan saham setelah ditambahkan:");
        SahamLists.displaySaham();

        validasiMenu();
    }

    // Validasi input berupa angka
    private static boolean isNumber(String hargaPerLembar) {
        if (hargaPerLembar == null || hargaPerLembar.isEmpty()) return false;
        for (char c : hargaPerLembar.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private static boolean kodeValidasi(String kodeSaham) {
        for (Saham saham : SahamLists.getSahamList()) {
            if (saham.getKode().equalsIgnoreCase(kodeSaham)) {
                return true;
            }
        }
        return false;
    }

    // Validasi menu lanjut atau kembali
    private static void validasiMenu() {
        while (true) {
            System.out.println("Apa yang ingin anda lakukan selanjutnya?");
            System.out.println("1. Lanjut menambah saham");
            System.out.println("2. Kembali ke menu saham");
            String menu = InputUser.nextLine("Masukkan pilihan anda: ");

            if (menu.equals("1")) {
                tambahSahamBaru();
                break;
            } else if (menu.equals("2")) {
                SahamAdminMenu.displaySahamAdminMenu();
                break;
            } else {
                System.out.println("Input tidak valid. Silakan ketik '1' atau '2' saja.");
            }
        }
    }
}
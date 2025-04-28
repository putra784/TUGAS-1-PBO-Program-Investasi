package menu.admin.saham;

import menu.sahamLists.Saham;
import menu.sahamLists.SahamLists;
import utility.InputUser;

public class UbahHargaSaham {

    // Method untuk menerima input user
    public static void ubahHarga() {
        System.out.println("Daftar saham yang ada:");
        SahamLists.displaySaham();

        String kodeShm = InputUser.nextLine("Masukkan kode saham yang ingin anda ubah: ");
        String hargaBaru = InputUser.nextLine(String.format("Masukkan harga saham %s per-lembar yang baru: ", kodeShm));
        prosesUbahHarga(kodeShm, hargaBaru);
    }

    // Proses pengubahan harga pada daftar saham
    private static void prosesUbahHarga(String kodeShm, String hargaBaru) {
        if (isNumber(hargaBaru)) {
            double hargaAkhir = Double.parseDouble(hargaBaru);
            boolean berhasil = false;

            for (Saham saham : SahamLists.getSahamList()) {
                if (saham.getKode().equalsIgnoreCase(kodeShm)) {
                    saham.setHarga(hargaAkhir);
                    berhasil = true;
                    break;
                }
            }

            if (berhasil) {
                System.out.printf("Harga saham %s berhasil diubah!%n", kodeShm);
                SahamLists.displaySaham();
                validasiMenu(); // Pindah validasi ke method terpisah
            } else {
                System.out.println("Kode saham tidak ditemukan!");
                ubahHarga();
            }
        } else {
            System.out.println("Input tidak valid! Silakan ulang kembali!");
            ubahHarga();
        }
    }

    // Validasi input berupa angka
    private static boolean isNumber(String hargaBaru) {
        if (hargaBaru == null || hargaBaru.isEmpty()) return false;
        for (char c : hargaBaru.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    // Validasi menu setelah pengubahan harga
    private static void validasiMenu() {
        while (true) {
            System.out.println("Apa yang ingin anda lakukan selanjutnya?");
            System.out.println("1. Ubah harga saham lain");
            System.out.println("2. Kembali ke menu saham admin");
            String pilihan = InputUser.nextLine("Masukkan pilihan anda: ").trim();

            if (pilihan.equals("1")) {
                ubahHarga();
                break;
            } else if (pilihan.equals("2")) {
                menu.admin.SahamAdminMenu.displaySahamAdminMenu();
                break;
            } else {
                System.out.println("Input tidak valid. Silakan ketik '1' atau '2' saja.");
            }
        }
    }
}

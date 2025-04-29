package menu.admin.sbn;

import menu.admin.SbnAdminMenu;
import menu.sbnLists.SBN;
import menu.sbnLists.SbnLists;
import utility.InputUser;

public class TambahSbn {

    public static void tambahSbn() {
        while (true) {
            String kodeSbn = inputKodeSbn();
            String jenisSbn = inputJenisSbn();
            double hargaPerUnit = inputHargaPerUnit();
            double bunga = inputBunga();
            int tenor = inputTenor();

            SBN sbnBaru = new SBN(kodeSbn, jenisSbn, hargaPerUnit, bunga, tenor);
            SbnLists.getDaftarSBN().add(sbnBaru);

            System.out.println("\nSBN baru berhasil ditambahkan!\n");
            SbnLists.displayDaftarSBN();

            if (!validasiMenu()) {
                return;
            }
        }
    }

    private static boolean validasiMenu() {
        while (true) {
            System.out.println("\nApa yang ingin dilakukan selanjutnya?");
            System.out.println("1. Lanjut menambahkan SBN");
            System.out.println("2. Kembali ke menu SBN");
            String pilihan = InputUser.nextLine("Masukkan pilihan anda: ");
            if (pilihan.equals("1")) {
                return true;  // biarkan loop di tambahSbn() lanjut
            } else if (pilihan.equals("2")) {
                SbnAdminMenu.displaySbnAdminMenu();
                return false;
            } else {
                System.out.println("Pilihan tidak valid. Silakan pilih 1 atau 2.");
            }
        }
    }

    private static String inputKodeSbn() {
        while (true) {
            String kode = InputUser.nextLine("Masukkan kode SBN (misal: ORI024): ").trim().toUpperCase();
            if (kode.isEmpty()) {
                System.out.println("Kode SBN tidak boleh kosong.");
                continue;
            }

            boolean kodeSudahAda = SbnLists.getDaftarSBN().stream()
                    .anyMatch(sbn -> sbn.getKodeSbn().equalsIgnoreCase(kode));
            if (kodeSudahAda) {
                System.out.println("Kode SBN sudah ada. Silakan masukkan kode lain.");
                continue;
            }

            return kode;
        }
    }

    private static String inputJenisSbn() {
        while (true) {
            String jenis = InputUser.nextLine("Masukkan jenis SBN: ").trim();
            if (!jenis.isEmpty()) {
                return jenis;
            }
            System.out.println("Jenis SBN tidak boleh kosong.");
        }
    }

    private static double inputHargaPerUnit() {
        while (true) {
            String input = InputUser.nextLine("Masukkan harga per unit SBN (minimal Rp1.000.000): ");
            try {
                double harga = Double.parseDouble(input);
                if (harga >= 1000000) {
                    return harga;
                } else {
                    System.out.println("Harga harus minimal Rp1.000.000.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
            }
        }
    }

    private static double inputBunga() {
        while (true) {
            String input = InputUser.nextLine("Masukkan bunga tahunan (%): ");
            try {
                double bunga = Double.parseDouble(input);
                if (bunga > 0) {
                    return bunga;
                } else {
                    System.out.println("Bunga harus lebih dari 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
            }
        }
    }

    private static int inputTenor() {
        while (true) {
            String input = InputUser.nextLine("Masukkan tenor (tahun): ");
            try {
                int tenor = Integer.parseInt(input);
                if (tenor > 0) {
                    return tenor;
                } else {
                    System.out.println("Tenor harus lebih dari 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka bulat positif.");
            }
        }
    }
}
package menu.customer;

import menu.MenuHandler;
import menu.customer.portofolio.PortofolioLists;
import menu.customer.portofolio.PortofolioSahamCustomer;
import utility.InputUser;

public class JualSaham {

    // Method utama untuk menjalankan proses jual saham
    public static void jualSaham() {
        if (isPortofolioKosong()) {
            tampilkanPesanPortofolioKosong();
            System.exit(0);
        }

        tampilkanPortofolio();

        String kodeSaham = mintaInputKodeSaham();
        int jumlahLembar = mintaInputJumlahLembar();

        validasiDanProsesJual(kodeSaham, jumlahLembar);
    }

    // Cek apakah portofolio kosong
    private static boolean isPortofolioKosong() {
        return PortofolioLists.portofolioSahamList == null ||
                PortofolioLists.portofolioSahamList.isEmpty();
    }

    // Menampilkan pesan ketika portofolio kosong
    private static void tampilkanPesanPortofolioKosong() {
        System.out.println("Anda tidak memiliki saham pada portofolio anda!");
        System.out.println("Silahkan beli terlebih dahulu!");
    }

    // Menampilkan daftar saham yang dimiliki pengguna
    private static void tampilkanPortofolio() {
        System.out.println("Berikut deretan saham yang anda miliki saat ini:");
        PortofolioLists.displayPortofolioShm();
    }

    // Meminta input kode saham dari user
    private static String mintaInputKodeSaham() {
        return InputUser.nextLine("Masukkan kode saham yang ingin anda jual: ").toUpperCase();
    }

    // Meminta input jumlah lembar saham dari user
    private static int mintaInputJumlahLembar() {
        int jumlahLembar;
        while (true) {
            String input = InputUser.nextLine("Masukkan jumlah lembar yang ingin anda jual: ");
            try {
                jumlahLembar = Integer.parseInt(input);
                if (jumlahLembar <= 0) {
                    System.out.println("Jumlah lembar harus lebih dari 0.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka yang benar.");
            }
        }
        return jumlahLembar;
    }

    // Validasi kode saham yang diinput dan lanjutkan ke proses jual
    private static void validasiDanProsesJual(String kodeSaham, int jumlahLembar) {
        PortofolioSahamCustomer portofolio = cariKodeSaham(kodeSaham);

        if (portofolio == null) {
            System.out.println("Saham tersebut tidak ada dalam portofolio anda! Silakan ulang kembali");
            jualSaham();
            return;
        }

        prosesPenjualan(portofolio, jumlahLembar);
    }

    // Proses penjualan saham
    private static void prosesPenjualan(PortofolioSahamCustomer portofolio, int jumlahLembar) {
        int lembarSebelum = portofolio.getJumlahLembar();

        if (lembarSebelum < jumlahLembar) {
            System.out.println("\nJumlah lembar yang anda miliki tidak mencukupi");
            System.out.println("Silakan kurangi jumlah lembar atau pilih saham lain!\n");
            jualSaham();
            return;
        }

        int lembarSetelah = lembarSebelum - jumlahLembar;
        portofolio.setJumlahLembar(lembarSetelah);

        if (lembarSetelah == 0) {
            PortofolioLists.getPortofolioSahamList().remove(portofolio);
            System.out.println("Seluruh saham berhasil dijual");
        } else {
            System.out.printf("%d lembar saham %s berhasil dijual, sisa lembar = %d%n",
                    jumlahLembar, portofolio.getSahamCodeCustomer(), lembarSetelah);
        }

        tampilkanPilihanSetelahJual();
    }

    // Mencari saham berdasarkan kode saham yang dimasukkan
    private static PortofolioSahamCustomer cariKodeSaham(String kodeSaham) {
        for (PortofolioSahamCustomer portofolio : PortofolioLists.getPortofolioSahamList()) {
            if (portofolio.getSahamCodeCustomer().equals(kodeSaham)) {
                return portofolio;
            }
        }
        return null;
    }

    // Menampilkan validasi menu pilihan setelah berhasil menjual saham
    private static void tampilkanPilihanSetelahJual() {
        while (true) {
            System.out.println("\nApa yang ingin anda lakukan selanjutnya?");
            System.out.println("1. Menjual saham lagi");
            System.out.println("2. Kembali ke menu utama");
            String pilihan = InputUser.nextLine("Masukkan pilihan anda disini: ");

            if (pilihan.equals("1")) {
                System.out.println("Anda berhasil mengulang program!\n");
                jualSaham();
                break;
            } else if (pilihan.equals("2")) {
                MenuHandler.displayCustomerMenu();
                break;
            } else {
                System.out.println("Input tidak valid. Silakan ketik '1' atau '2' saja.");
            }
        }
    }
}

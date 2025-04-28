package menu.customer;

import menu.MenuHandler;
import menu.customer.portofolio.PortofolioSahamCustomer;
import menu.customer.portofolio.PortofolioLists;
import utility.InputUser;

public class JualSaham {

    public static void jualSaham() {

        if (PortofolioLists.portofolioSahamList == null ||
                PortofolioLists.portofolioSahamList.isEmpty()) {
            System.out.println("Anda tidak memiliki saham pada portofolio anda!");
            System.out.println("Silahkan beli terlebih dahulu!");
            System.exit(0);
        } else {
            System.out.println("Berikut deretan saham yang anda miliki saat ini:");
            PortofolioLists.displayPortofolioShm();

            String kodeShm = InputUser.nextLine("Masukkan kode saham yang ingin anda jual: ").toUpperCase();

            int jumlahLembar = inputJumlahLembar();
            validasiKode(kodeShm, jumlahLembar);
        }
    }

    private static int inputJumlahLembar() {
        int jumlahLembar;
        while (true) {
            String inputLembar = InputUser.nextLine("Masukkan jumlah lembar yang ingin anda jual: ");
            try {
                jumlahLembar = Integer.parseInt(inputLembar);
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

    private static void validasiKode(String kodeShm, int lembarShm) {
        PortofolioSahamCustomer portofolioCustomer = cariKodeSaham(kodeShm);
        if (portofolioCustomer == null) {
            System.out.println("Saham tersebut tidak ada dalam portofolio anda! Silakan ulang kembali");
            jualSaham();
            return;
        } else {
            prosesJualSaham(kodeShm, lembarShm);
        }
    }

    private static void prosesJualSaham(String kodeShm, int lembarShm) {
        PortofolioSahamCustomer portofolioCustomer = cariKodeSaham(kodeShm);

        int lembarSebelum = portofolioCustomer.getJumlahLembar();

        if (lembarSebelum < lembarShm) {
            System.out.println("\nJumlah lembar yang anda miliki tidak mencukupi");
            System.out.println("Silakan kurangi jumlah lembar atau pilih saham lain!\n");
            jualSaham();
            return;
        } else {
            int lembarSetelah = lembarSebelum - lembarShm;
            portofolioCustomer.setJumlahLembar(lembarSetelah);

            if (lembarSetelah == 0) {
                PortofolioLists.getPortofolioSahamList().remove(portofolioCustomer);
                System.out.println("Seluruh saham berhasil dijual");
            } else {
                System.out.printf("%d lembar saham %s berhasil dijual, sisa lembar = %d%n", lembarShm, kodeShm, lembarSetelah);
            }
        }

        while (true) {
            System.out.println("\nApa yang ingin anda lakukan selanjutnya?");
            System.out.println("1. Menjual saham lagi");
            System.out.println("2. Kembali ke menu utama");
            String menuSelanjutnya = InputUser.nextLine("Masukkan pilihan anda disini: ");

            if (menuSelanjutnya.equals("1")) {
                System.out.println("Anda berhasil mengulang program!\n");
                jualSaham();
                break;
            } else if (menuSelanjutnya.equals("2")) {
                MenuHandler.displayCustomerMenu();
                break;
            } else {
                System.out.println("Input tidak valid. Silakan ketik '1' atau '2' saja.");
            }
        }
    }

    private static PortofolioSahamCustomer cariKodeSaham(String kodeShm) {
        for (PortofolioSahamCustomer prt : PortofolioLists.getPortofolioSahamList()) {
            if (prt.getSahamCodeCustomer().equals(kodeShm)) {
                return prt;
            }
        }
        return null;
    }
}
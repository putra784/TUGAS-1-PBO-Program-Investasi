package menu.customer.portofolio;

import java.util.ArrayList;

// Kelas untuk menyimpan daftar portofolio saham dan SBN
public class PortofolioLists {

    // Daftar portofolio saham dan SBN
    public static ArrayList<PortofolioSahamCustomer> portofolioSahamList = new ArrayList<>();
    public static ArrayList<PortofolioSbnCustomer> portofolioSbnList = new ArrayList<>();

    // Menambahkan portofolio saham
    public static void addPortofolioSaham(PortofolioSahamCustomer portofolio) {
        portofolioSahamList.add(portofolio);
    }

    // Menambahkan portofolio SBN
    public static void addPortofolioSbn(PortofolioSbnCustomer portofolio) {
        portofolioSbnList.add(portofolio);
    }

    // Menampilkan portofolio saham saja
    public static void displayPortofolioShm() {
        if (portofolioSahamList.isEmpty()) {
            System.out.println("\nAnda tidak memiliki saham.");
        } else {
            System.out.println("\nPortofolio Saham Anda:");
            for (PortofolioSahamCustomer saham : portofolioSahamList) {
                saham.displayPortofolio();
            }
        }
    }

    // Menampilkan seluruh portofolio (saham dan SBN)
    public static void displayPortofolioFull() {
        boolean isEmpty = true;

        // Menampilkan portofolio saham
        if (!portofolioSahamList.isEmpty()) {
            System.out.println("\nPortofolio Saham Anda:");
            for (PortofolioSahamCustomer saham : portofolioSahamList) {
                saham.displayPortofolio();
            }
            isEmpty = false;
        } else {
            System.out.println("\nAnda tidak memiliki saham.");
        }

        // Menampilkan portofolio SBN
        if (!portofolioSbnList.isEmpty()) {
            System.out.println("\nPortofolio SBN Anda:");
            for (PortofolioSbnCustomer sbn : portofolioSbnList) {
                sbn.displayPortofolio();
            }
            isEmpty = false;
        } else {
            System.out.println("\nAnda tidak memiliki SBN.");
        }

        // Jika tidak ada portofolio
        if (isEmpty) {
            System.out.println("Anda belum memiliki portofolio. Silakan beli saham atau SBN terlebih dahulu.");
        }
    }

    // Menampilkan daftar portofolio saham yang sudah ada (bila diperlukan)
    public static ArrayList<PortofolioSahamCustomer> getPortofolioSahamList() {
        return portofolioSahamList;
    }
}
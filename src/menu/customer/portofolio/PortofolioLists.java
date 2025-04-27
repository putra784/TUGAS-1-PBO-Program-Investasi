package menu.customer.portofolio;

import java.util.ArrayList;

public class PortofolioLists {

    // List untuk portofolio saham
    public static ArrayList<PortofolioSahamCustomer> portofolioSahamList = new ArrayList<>();

    // List untuk portofolio SBN
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
        System.out.println("\nPortofolio Saham Anda:");
        for (PortofolioSahamCustomer saham : portofolioSahamList) {
            saham.displayPortofolio();
        }
    }

    // Menampilkan seluruh portofolio (saham dan SBN)
    public static void displayPortofolioFull() {
        boolean isEmpty = true;

        // Menampilkan portofolio saham
        if (portofolioSahamList.isEmpty()) {
            System.out.println("\nAnda tidak memiliki saham.");
        } else {
            System.out.println("\nPortofolio Saham Anda:");
            for (PortofolioSahamCustomer saham : portofolioSahamList) {
                saham.displayPortofolio();
            }
            isEmpty = false;
        }

        // Menampilkan portofolio SBN
        if (portofolioSbnList.isEmpty()) {
            System.out.println("\nAnda tidak memiliki SBN.");
        } else {
            System.out.println("\nPortofolio SBN Anda:");
            for (PortofolioSbnCustomer sbn : portofolioSbnList) {
                sbn.displayPortofolio();
            }
            isEmpty = false;
        }

        if (isEmpty) {
            System.out.println("Anda belum memiliki portofolio. Silakan beli saham atau SBN terlebih dahulu.");
        }
    }

    // Getter untuk portofolio saham
    public static ArrayList<PortofolioSahamCustomer> getPortofolioSahamList() {
        return portofolioSahamList;
    }
}
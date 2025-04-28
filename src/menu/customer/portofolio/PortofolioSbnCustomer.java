package menu.customer.portofolio;

import menu.sbnLists.SBN;

import java.text.DecimalFormat;

// Class untuk menyimpan data portofolio SBN Customer
public class PortofolioSbnCustomer {
    private final SBN sbn;
    private final int jumlahUnit;
    private final double kupon;

    public PortofolioSbnCustomer(SBN sbn, int jumlahUnit) {
        this.sbn = sbn;
        this.jumlahUnit = jumlahUnit;
        this.kupon = (sbn.getBunga() / 12) * 0.90 * sbn.getHargaPerUnit() * jumlahUnit;
    }

    public void displayPortofolio() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Kode SBN: " + sbn.getKodeSbn());
        System.out.println("Jenis SBN: " + sbn.getJenisSbn());
        System.out.println("Jumlah Unit: " + jumlahUnit);
        System.out.println("Total Bunga Per Bulan: Rp" + df.format(kupon));
        System.out.println("------------------------------------");
    }
}
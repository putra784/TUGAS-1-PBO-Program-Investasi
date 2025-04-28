package menu.customer.portofolio;

import menu.sbnLists.SBN;
import java.text.DecimalFormat;

// Class untuk menyimpan portofolio SBN customer
public class PortofolioSbnCustomer {
    private final SBN sbn;
    private int jumlahUnit;
    private double kupon;
    private double totalInvestasi;

    public PortofolioSbnCustomer(SBN sbn, double nominalInvestasi) {
        this.sbn = sbn;
        this.jumlahUnit = (int) (nominalInvestasi / sbn.getHargaPerUnit());
        this.totalInvestasi = this.jumlahUnit * sbn.getHargaPerUnit();
        this.kupon = (sbn.getBunga() / 100) / 12 * 0.90 * totalInvestasi;
    }

    public void displayPortofolio() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Kode SBN: " + sbn.getKodeSbn());
        System.out.println("Jenis SBN: " + sbn.getJenisSbn());
        System.out.println("Jumlah Unit: " + jumlahUnit);
        System.out.println("Total Investasi: Rp" + df.format(totalInvestasi));
        System.out.println("Estimasi Kupon per Bulan: Rp" + df.format(kupon));
        System.out.println("------------------------------------");
    }

    // Menambah unit dan memperbarui total investasi serta kupon
    public void tambahUnit(double nominalInvestasi, SBN sbn) {
        int tambahanUnit = (int) (nominalInvestasi / sbn.getHargaPerUnit());
        this.jumlahUnit += tambahanUnit;
        this.totalInvestasi += tambahanUnit * sbn.getHargaPerUnit();
        this.kupon = (sbn.getBunga() / 100) / 12 * 0.90 * totalInvestasi;
    }

    public SBN getSbn() {
        return sbn;
    }
}
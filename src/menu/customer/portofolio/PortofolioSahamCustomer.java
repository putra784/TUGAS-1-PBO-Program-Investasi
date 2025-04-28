package menu.customer.portofolio;

import java.text.NumberFormat;
import java.util.Locale;

public class PortofolioSahamCustomer {
    private static int count = 1;
    private final String kodeSahamCustomer;
    private final String namaSahamCustomer;
    private int jumlahLembar;
    private final double hargaPerLembar;
    private final int nomor;

    public PortofolioSahamCustomer(String kodeSahamCustomer, String namaSahamCustomer, int jumlahLembar, double hargaPerLembar) {
        this.namaSahamCustomer = namaSahamCustomer;
        this.kodeSahamCustomer = kodeSahamCustomer;
        this.jumlahLembar = jumlahLembar;
        this.hargaPerLembar = hargaPerLembar;
        this.nomor = count++;
    }

    public void displayPortofolio() {
        double total = jumlahLembar * hargaPerLembar;
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        String totalFormatted = formatter.format(total);
        System.out.printf("%d. %s - %s || jumlah lembar: %d (%s) || avg: %.2f%n",
                nomor, kodeSahamCustomer, namaSahamCustomer, jumlahLembar, totalFormatted, hargaPerLembar);
    }

    public int getJumlahLembar() {
        return jumlahLembar;
    }

    public void setJumlahLembar(int jumlahLembar) {
        this.jumlahLembar = jumlahLembar;
    }

    public String getSahamCodeCustomer() {
        return kodeSahamCustomer;
    }
}
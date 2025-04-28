package menu.sahamLists;

// Class untuk menyimpan data saham
public class Saham {
    private final String kode;
    private final String namaPerusahaan;
    private double harga;

    public Saham(String kode, String namaPerusahaan, double harga) {
        this.kode = kode;
        this.namaPerusahaan = namaPerusahaan;
        this.harga = harga;
    }

    public String getKode(){
        return kode;
    }

    public String getNamaPerusahaan(){
        return namaPerusahaan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}

package menu.sbnLists;

public class SBN {
   private final String kodeSbn;
   private final String jenisSbn;
   private final double hargaPerUnit;
   private final double bunga;
   private final int tenor;

   public SBN (String kodeSbn, String jenisSbn, double hargaPerUnit, double bunga, int tenor) {
       this.kodeSbn = kodeSbn;
       this.jenisSbn = jenisSbn;
       this.hargaPerUnit = hargaPerUnit;
       this.bunga = bunga;
       this.tenor = tenor;
   }

    @Override
    public String toString() {
        return "Kode: " + kodeSbn + "\n" +
                "Jenis: " + jenisSbn + "\n" +
                "Harga per Unit: Rp" + hargaPerUnit + "\n" +
                "Bunga: " + bunga + "% per tahun\n" +
                "Tenor: " + tenor + " tahun\n" +
                "------------------------------------";
    }

    public String getKodeSbn() {
       return kodeSbn;
    }

    public double getHargaPerUnit() {
        return hargaPerUnit;
    }

    public double getBunga() {
        return bunga;
    }

    public String getJenisSbn() {
       return jenisSbn;
    }

}

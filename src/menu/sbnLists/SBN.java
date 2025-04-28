package menu.sbnLists;

// class untuk menyimpan data SBN
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

    public String getKode() {
       return kodeSbn;
    }

    public int getTenor() {
       return tenor;
    }
}

package menu.sahamLists;

import java.util.ArrayList;


public class SahamLists {
    private static final ArrayList<Saham> sahamList = new ArrayList<>();

    static {
        sahamList.add(new Saham("BBCA", "Bank Central Asia Tbk.", 8500));
        sahamList.add(new Saham("BBRI", "Bank Rakyat Indonesia Persero Tbk.", 3840));
        sahamList.add(new Saham("ANTM", "Aneka Tambang Tbk.", 2130));
        sahamList.add(new Saham("FORE", "PT Fore Kopi Indonesia Tbk.", 366));
        sahamList.add(new Saham("BNBA", "Bank Bumi Arta Tbk.", 630.40));
        sahamList.add(new Saham("RATU", "PT. Raharja Energi Cepu Tbk.", 5650));
        sahamList.add(new Saham("ADRO", "Alamtri Resources Indonesia Tbk.", 1900));
    }

    public static ArrayList<Saham> getSahamList() {
        return sahamList;
    }

    public static void displaySaham() {
        System.out.println("=================================================================================");
        System.out.println("||                                Daftar Saham                                 ||");
        System.out.println("=================================================================================");
        System.out.printf("|| %-3s || %-5s || %-43s || %-12s ||\n", "No", "Kode", "Nama Perusahaan", "Harga");
        System.out.println("=================================================================================");

        int index = 1;
        for (Saham shm : sahamList) {
            System.out.printf(
                    "|| %-3d || %-5s || %-43s || Rp.%-9.2f ||\n",
                    index++,
                    shm.getKode(),
                    shm.getNamaPerusahaan(),
                    shm.getHarga()
            );
        }

        System.out.println("=================================================================================");
    }
}
package menu.sahamLists;

import java.util.ArrayList;


public class SahamLists {
    private static ArrayList<Saham> sahamList = new ArrayList<>();

    static {
        sahamList.add(new Saham("BBCA", "Bank Central Asia Tbk.", 1900));
        sahamList.add(new Saham("BBRI", "Bank Rakyat Indonesia Persero", 1700));
        sahamList.add(new Saham("ANTM", "Aneka Tambang Tbk.", 9000));
        sahamList.add(new Saham("FORE", "PT Fore Kopi Indonesia Tbk.", 450));
        sahamList.add(new Saham("BNBA", "Bank Bumi Arta Tbk.", 630.40));
    }

    public static ArrayList<Saham> getSahamList() {
        return sahamList;
    }

    public static void displaySaham() {
        int index = 1;
        for (Saham shm : sahamList) {
            System.out.println(index++ + ". " + shm);
        }
    }
}
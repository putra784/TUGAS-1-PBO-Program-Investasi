package menu.sbnLists;

import java.util.*;

public class SbnLists {
    private static final ArrayList<SBN> daftarSBN = new ArrayList<>();

    static {
        daftarSBN.add(new SBN("ORI023", "Obligasi Ritel Indonesia Seri ORI023", 1000000, 6.10, 3));
        daftarSBN.add(new SBN("SR018", "Sukuk Ritel Seri SR018", 1000000, 6.25, 3));
        daftarSBN.add(new SBN("ST010", "Sukuk Tabungan Seri ST010", 1000000, 6.30, 2));
        daftarSBN.add(new SBN("FR0091", "SBN Institusi FR0091", 1000000, 7.00, 10));
    }

    public static ArrayList<SBN> getDaftarSBN(){
        return daftarSBN;
    }

    public static void displayDaftarSBN() {
        int index = 1;
        for (SBN sbn : daftarSBN) {
            System.out.println(index++ + ". " + sbn);
        }
    }
}
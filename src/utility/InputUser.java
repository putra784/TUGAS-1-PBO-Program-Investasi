package utility;

import java.util.Scanner;

public class InputUser {
    private static final Scanner scanner = new Scanner(System.in);

    public static String nextLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int nextInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Input tidak valid. " + prompt);
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

}

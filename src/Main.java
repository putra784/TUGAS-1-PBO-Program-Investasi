import java.util.Scanner;
import loginPage.*;

public class Main {

    private static void loginProces (Scanner scanner){
        System.out.print("Masukkan role anda (admin / customer): ");
        Role role;

        try {
            role = Role.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Role yang anda masukkan salah (hanya customer / admin)");
            return;
        }

        System.out.print("Masukkan username anda: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password anda: ");
        String password = scanner.nextLine();

        if (UserLogin.authentication(role, username, password)){

        }
    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Welcome.displayWelcome();
        loginProces(scanner);
    }
}

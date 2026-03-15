import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {

        System.out.println("Password Generator");
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.print("Enter your password length: ");
            int length = scanner.nextInt();
            
            String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";

            Random random = new Random();
            String password = "";
            
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                char randomCharacter = characters.charAt(index);
                password += randomCharacter;
            }
        
        System.out.println("Generated password: " + password);
        System.out.println("Generate another password? (y/n): ");
        String answer = scanner.next();
            
        if (answer.equals("n")) {
            running = false;
        }
    }

        scanner.close();
    }
}
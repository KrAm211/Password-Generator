import java.util.Scanner;
import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {

        System.out.println("Password Generator");
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean running = true;

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
        
        while (running) {
            System.out.print("Enter your password length: ");
            int length = scanner.nextInt();
            
            StringBuilder passwordstring = new StringBuilder();
            
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                char randomCharacter = characters.charAt(index);
                passwordstring.append(randomCharacter);
        }
        
        System.out.println("Generated password: " + passwordstring);
        System.out.print("Generate another password? (y/n): ");
        String answer = scanner.next();
            
        if (answer.equalsIgnoreCase("n")) {
            running = false;
        }
    }

        scanner.close();
    }
}
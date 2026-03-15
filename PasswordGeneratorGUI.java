import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PasswordGeneratorGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Password Generator");

        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());

        JLabel lengthLabel = new JLabel("Password Length:");
        JTextField lengthField = new JTextField(10);

        JButton generateButton = new JButton("Generate Password");

        JTextField passwordfField = new JTextField(20);
        passwordfField.setEditable(false);

        frame.add(lengthLabel);
        frame.add(lengthField);
        frame.add(generateButton);
        frame.add(passwordfField);

        generateButton.addActionListener(e -> {

            String lengthText = lengthField.getText();
            int length = Integer.parseInt(lengthText);

            String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";

            Random random = new Random();
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                System.out.println("I = " + Integer.toString(i));
                int index = random.nextInt(characters.length());
                char randomCharacter = characters.charAt(index);
                password.append(randomCharacter);
                System.out.println("Password: " + password.toString());
            }

            passwordfField.setText(password.toString());
        });

        frame.setVisible(true);
    }
    
}

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PasswordGeneratorGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("NEXUS - Password Generator");
        frame.setSize(450, 175);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel lengthLabel = new JLabel("Password Length:");
        JTextField lengthField = new JTextField(10);
        JCheckBox lowercaseBox = new JCheckBox("Lowercase", true);
        JCheckBox uppercasBox = new JCheckBox("Uppercase", true);
        JCheckBox numbersBox = new JCheckBox("Numbers", true);
        JCheckBox symbolsBox = new JCheckBox("Symbols", true);
        JButton generateButton = new JButton("Generate Password");
        JTextField passwordfField = new JTextField(25);
        passwordfField.setEditable(false);

        frame.add(lengthField);
        frame.add(lengthLabel);
        frame.add(lowercaseBox );
        frame.add(uppercasBox);
        frame.add(numbersBox);
        frame.add(symbolsBox);
        frame.add(generateButton);
        frame.add(passwordfField);

        Random random = new Random();

        generateButton.addActionListener(e -> {
            String lengthText = lengthField.getText();

            int length;

            try {
                length = Integer.parseInt(lengthText);
            } catch (NumberFormatException ex) {
                passwordfField.setText("Please enter numbers only");
                return;
            }

            if (length < 12 || length > 32) {
                passwordfField.setText("Length must be between 12 and 32");
                return;
            }

            StringBuilder characters = new StringBuilder();

            if (lowercaseBox.isSelected()) {
                characters.append("abcdefghijklmnopqrstuvwxyz");
            }
            if (uppercasBox.isSelected()) {
                characters.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            }
            if (numbersBox.isSelected()) {
                characters.append("0123456789");
            }
            if (symbolsBox.isSelected()) {
                characters.append("!@#$%^&* ");
            }
            if (characters.length() == 0) {
                passwordfField.setText("Select at least one character type");
            }

            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                //Print for loop position for debugging
                //System.out.println("I = " + Integer.toString(i));
                int index = random.nextInt(characters.length());
                char randomCharacter = characters.charAt(index);
                password.append(randomCharacter);
                //Print password at this step for debugging
                //System.out.println("Password: " + password.toString());
            }

            passwordfField.setText(password.toString());
        });

        frame.setVisible(true);
    }
    
}

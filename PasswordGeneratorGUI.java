import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

public class PasswordGeneratorGUI {
    public static void main(String[] args) {

        JFrame frame = new JFrame("NEXUS - Password Generator");
        frame.setSize(450, 200);
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
        JButton copyText = new JButton("Copy Password");

        frame.add(lengthField);
        frame.add(lengthLabel);
        frame.add(lowercaseBox );
        frame.add(uppercasBox);
        frame.add(numbersBox);
        frame.add(symbolsBox);
        frame.add(generateButton);
        frame.add(passwordfField);
        frame.add(copyText);

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
                characters.append("!@#$%^&*");
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
        copyText.addActionListener(d -> {
            String myString = (password.toString());
            StringSelection stringSelection = new StringSelection(myString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
        });

            passwordfField.setText(password.toString());
        });

        frame.setVisible(true);
    }
    
}

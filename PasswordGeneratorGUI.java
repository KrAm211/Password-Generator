import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

public class PasswordGeneratorGUI {

    public static int minLength = 12;
    public static int maxLength = 32;
    public static void main(String[] args) {

        JFrame frame = new JFrame("NEXUS - Password Generator");
        frame.setIconImage(new ImageIcon("logo.png").getImage());
        frame.setSize(280, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setResizable(false);

        JLabel lengthLabel = new JLabel("Password Length:");
        JTextField lengthField = new JTextField(10);
        lengthField.setText("12");
        JCheckBox lowercaseBox = new JCheckBox("Lowercase", true);
        JCheckBox uppercaseBox = new JCheckBox("Uppercase", true);
        JCheckBox numbersBox = new JCheckBox("Numbers", true);
        JCheckBox symbolsBox = new JCheckBox("Symbols", true);
        JButton generateButton = new JButton("Generate Password");
        JTextField passwordField = new JTextField(20);
        passwordField.setEditable(false);
        JButton copyText = new JButton("Copy Password");
        copyText.setPreferredSize(new Dimension(150, 25));

        frame.add(lengthLabel);
        frame.add(lengthField);
        frame.add(lowercaseBox );
        frame.add(uppercaseBox);
        frame.add(numbersBox);
        frame.add(symbolsBox);
        frame.add(generateButton);
        frame.add(passwordField);
        frame.add(copyText);

        Random random = new Random();

        generateButton.addActionListener(e -> {
            String lengthText = lengthField.getText();

            int length;

            try {
                length = Integer.parseInt(lengthText);
            } catch (NumberFormatException ex) {
                passwordField.setText("Please enter numbers only!");
                return;
            }

            if (length < minLength || length > maxLength) {
                passwordField.setText(String.format("Length must be between %d and %d!",minLength,maxLength));
                return;
            }

            StringBuilder characters = new StringBuilder();

            if (lowercaseBox.isSelected()) {
                characters.append("abcdefghijklmnopqrstuvwxyz");
            }
            if (uppercaseBox.isSelected()) {
                characters.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            }
            if (numbersBox.isSelected()) {
                characters.append("0123456789");
            }
            if (symbolsBox.isSelected()) {
                characters.append("!@#$%^&*-~_-+={}[]|<,>.?/");
            }
            if (characters.length() == 0) {
                passwordField.setText("Select at least one character type");
                return;
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

            passwordField.setText(password.toString());
            copyText.setBackground(null);

        });

        copyText.addActionListener(d -> {
            String myString = passwordField.getText();

            if (myString.isEmpty()) {
                return;
            }

            StringSelection stringSelection = new StringSelection(myString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            copyText.setText("Copied!");

            Timer timer = new Timer(1000, e -> {
                copyText.setText("Copy Password");
            });
            timer.setRepeats(false);
            timer.start();
            });

        frame.setVisible(true); 

    }
    
}

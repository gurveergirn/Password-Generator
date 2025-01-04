// Rendering the front end 

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class PasswordGeneratorGUI extends JFrame {
    private PasswordGenerator passwordGenerator;

    public PasswordGeneratorGUI() {
        super("Password Generator");

        // Size of the GUI
        setSize(540, 570);

        // Prevent resizable GUI
        setResizable(false);

        // Null layout
        setLayout(null);
        // getContentPane().setBackground(Color.DARK_GRAY);

        // terminate the program when the GUI is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // To center the GUI
        setLocationRelativeTo(null);

        // init password generator
        passwordGenerator = new PasswordGenerator();

        // Render GUI components
        addGuiComponents();
    }

    private void addGuiComponents() {
        // Create title text
        JLabel titleLabel = new JLabel("Password Generator");

        // Font size and bold text
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));

        // Center text
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // x,y coordinates and height/width values
        titleLabel.setBounds(0, 10, 540, 39);

        // Adding these to GUI
        add(titleLabel);

        // Result text area
        JTextArea passwordOutput = new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialong", Font.BOLD, 32));

        // Scrollability if output is too large
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 97, 479, 70);

        // Black border around text area
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        // Password length label
        JLabel passwordLengthLabel = new JLabel("Password Length: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25, 215, 272, 39);
        add(passwordLengthLabel);

        // Password length input prompt
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310, 215, 192, 39);
        add(passwordLengthInputArea);

        // Toggle buttons for uppercase, lowercase, numbers, symbols
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        uppercaseToggle.setBounds(25, 302, 225, 56);
        add(uppercaseToggle);

        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        lowercaseToggle.setBounds(282, 302, 225, 56);
        add(lowercaseToggle);

        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        numbersToggle.setBounds(25, 373, 225, 56);
        add(numbersToggle);

        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        symbolsToggle.setBounds(282, 373, 225, 56);
        add(symbolsToggle);

        // Generate Button
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // generate password only when length is > 0 and one of the toggle buttons is
                // pressed
                if (passwordLengthInputArea.getText().length() <= 0)
                    return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() || uppercaseToggle.isSelected()
                        || numbersToggle.isSelected() || symbolsToggle.isSelected();

                // Generate Password, converts text to an integer value
                int passswordLength = Integer.parseInt(passwordLengthInputArea.getText());
                if (anyToggleSelected) {
                    String generatedPassword = passwordGenerator.generatePassword(passswordLength,
                            uppercaseToggle.isSelected(), lowercaseToggle.isSelected(), numbersToggle.isSelected(),
                            symbolsToggle.isSelected());

                    // Display password to user
                    passwordOutput.setText(generatedPassword);
                }
            }
        });
        add(generateButton);
    }
}

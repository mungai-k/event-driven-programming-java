import javax.swing.*;
import java.awt.*;

public class RegistrationForm extends JFrame {
    private JTextField nameField, emailField;
    private JPasswordField passwordField;
    private JRadioButton maleRadio, femaleRadio, otherRadio;
    private JCheckBox sportsCheck, musicCheck, readingCheck;
    private JComboBox<String> countryBox;
    private JTextArea commentsArea;
    private JLabel statusLabel;

    public RegistrationForm() {
        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel("Registration Form", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(8, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        formPanel.add(new JLabel("Full Name:")); nameField = new JTextField(); formPanel.add(nameField);
        formPanel.add(new JLabel("Email:")); emailField = new JTextField(); formPanel.add(emailField);
        formPanel.add(new JLabel("Password:")); passwordField = new JPasswordField(); formPanel.add(passwordField);

        formPanel.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        maleRadio = new JRadioButton("Male"); femaleRadio = new JRadioButton("Female"); otherRadio = new JRadioButton("Other");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio); genderGroup.add(femaleRadio); genderGroup.add(otherRadio);
        genderPanel.add(maleRadio); genderPanel.add(femaleRadio); genderPanel.add(otherRadio);
        formPanel.add(genderPanel);

        formPanel.add(new JLabel("Interests:"));
        JPanel interestsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        sportsCheck = new JCheckBox("Sports"); musicCheck = new JCheckBox("Music"); readingCheck = new JCheckBox("Reading");
        interestsPanel.add(sportsCheck); interestsPanel.add(musicCheck); interestsPanel.add(readingCheck);
        formPanel.add(interestsPanel);

        formPanel.add(new JLabel("Country:"));
        countryBox = new JComboBox<>(new String[]{"Kenya", "Tanzania", "Uganda", "Rwanda"});
        formPanel.add(countryBox);

        formPanel.add(new JLabel("Comments:"));
        commentsArea = new JTextArea(2, 20);
        formPanel.add(new JScrollPane(commentsArea));

        statusLabel = new JLabel("Status: Ready");
        formPanel.add(statusLabel);
        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton submitButton = new JButton("Submit"); submitButton.setBackground(new Color(100, 200, 100));
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit"); exitButton.setBackground(new Color(255, 150, 150));

        submitButton.addActionListener(e -> handleSubmit());
        clearButton.addActionListener(e -> handleClear(genderGroup));
        exitButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) System.exit(0);
        });

        buttonPanel.add(submitButton); buttonPanel.add(clearButton); buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void handleSubmit() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (name.isEmpty()) { statusLabel.setText("Error: Please enter your name"); statusLabel.setForeground(Color.RED); return; }
        if (email.isEmpty() || !email.contains("@")) { statusLabel.setText("Error: Please enter a valid email"); statusLabel.setForeground(Color.RED); return; }
        if (password.length() < 6) { statusLabel.setText("Error: Password must be at least 6 characters"); statusLabel.setForeground(Color.RED); return; }

        String gender = maleRadio.isSelected() ? "Male" : femaleRadio.isSelected() ? "Female" : otherRadio.isSelected() ? "Other" : "Not specified";
        StringBuilder interests = new StringBuilder();
        if (sportsCheck.isSelected()) interests.append("Sports ");
        if (musicCheck.isSelected()) interests.append("Music ");
        if (readingCheck.isSelected()) interests.append("Reading ");

        String message = "Registration Successful!\n\nName: " + name + "\nEmail: " + email + "\nGender: " + gender +
                "\nInterests: " + (interests.length() > 0 ? interests : "None") + "\nCountry: " + countryBox.getSelectedItem();
        JOptionPane.showMessageDialog(this, message, "Registration Complete", JOptionPane.INFORMATION_MESSAGE);
        statusLabel.setText("Registration submitted successfully!");
        statusLabel.setForeground(new Color(0, 128, 0));
    }

    private void handleClear(ButtonGroup group) {
        nameField.setText(""); emailField.setText(""); passwordField.setText("");
        group.clearSelection();
        sportsCheck.setSelected(false); musicCheck.setSelected(false); readingCheck.setSelected(false);
        countryBox.setSelectedIndex(0); commentsArea.setText("");
        statusLabel.setText("Status: Form cleared"); statusLabel.setForeground(Color.BLACK);
    }

    public static void main(String[] args) { SwingUtilities.invokeLater(() -> new RegistrationForm().setVisible(true)); }
}

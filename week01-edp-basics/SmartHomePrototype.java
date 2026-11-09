import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class SmartHomePrototype extends JFrame {
    private JLabel statusLabel;
    private JTextArea eventLog;
    private JToggleButton lightsToggle;
    private JToggleButton securityToggle;
    private JButton doorButton;

    public SmartHomePrototype() {
        setTitle("Smart Home Controller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        statusLabel = new JLabel("System Ready");
        statusLabel.setFont(new Font("Arial", Font.BOLD, 14));
        statusLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(statusLabel, BorderLayout.NORTH);

        eventLog = new JTextArea(10, 30);
        eventLog.setEditable(false);
        add(new JScrollPane(eventLog), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lightsToggle = new JToggleButton("Lights: OFF");
        lightsToggle.addActionListener(e -> {
            if (lightsToggle.isSelected()) {
                lightsToggle.setText("Lights: ON");
                logEvent("Lights turned ON");
                statusLabel.setText("Lights are on");
            } else {
                lightsToggle.setText("Lights: OFF");
                logEvent("Lights turned OFF");
                statusLabel.setText("Lights are off");
            }
        });

        securityToggle = new JToggleButton("Security: OFF");
        securityToggle.addActionListener(e -> {
            if (securityToggle.isSelected()) {
                securityToggle.setText("Security: ARMED");
                logEvent("Security system ARMED");
                statusLabel.setText("Security armed");
            } else {
                securityToggle.setText("Security: OFF");
                logEvent("Security system DISARMED");
                statusLabel.setText("Security disarmed");
            }
        });

        doorButton = new JButton("Simulate Door Open");
        doorButton.addActionListener(e -> {
            logEvent("Door sensor triggered");
            if (securityToggle.isSelected()) {
                logEvent("ALARM! Intruder detected!");
                statusLabel.setText("ALARM ACTIVE!");
                getContentPane().setBackground(Color.RED);
            } else {
                logEvent("Door opened (no alarm)");
                statusLabel.setText("Door opened");
                getContentPane().setBackground(null);
            }
        });

        controlPanel.add(lightsToggle);
        controlPanel.add(securityToggle);
        controlPanel.add(doorButton);
        add(controlPanel, BorderLayout.SOUTH);

        setSize(450, 400);
        setLocationRelativeTo(null);
    }

    private void logEvent(String event) {
        String timestamp = new Date().toString();
        eventLog.append("[" + timestamp + "] " + event + "\n");
        eventLog.setCaretPosition(eventLog.getDocument().getLength());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SmartHomePrototype().setVisible(true));
    }
}

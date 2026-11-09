import javax.swing.*;
import java.awt.*;

public class FixedDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("EDT Demo GOOD Practice");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new FlowLayout());

            JLabel status = new JLabel("Ready");
            JButton button = new JButton("Do Long Operation");

            button.addActionListener(e -> {
                status.setText("Working...");
                button.setEnabled(false);

                new Thread(() -> {
                    try {
                        Thread.sleep(5000); // Off EDT
                    } catch (InterruptedException ex) {}

                    SwingUtilities.invokeLater(() -> {
                        status.setText("Done!");
                        button.setEnabled(true);
                    });
                }).start();
            });

            frame.add(button);
            frame.add(status);
            frame.setVisible(true);
        });
    }
}

package eventdriven;

import javax.swing.*;
import java.awt.*;

public class EventDrivenCalculator extends JFrame {
    private JTextField display;
    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public EventDrivenCalculator() {
        setTitle("Event-Driven Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setBackground(Color.WHITE);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        buttonPanel.add(createNumberButton("7"));
        buttonPanel.add(createNumberButton("8"));
        buttonPanel.add(createNumberButton("9"));
        buttonPanel.add(createOperatorButton("/"));

        buttonPanel.add(createNumberButton("4"));
        buttonPanel.add(createNumberButton("5"));
        buttonPanel.add(createNumberButton("6"));
        buttonPanel.add(createOperatorButton("*"));

        buttonPanel.add(createNumberButton("1"));
        buttonPanel.add(createNumberButton("2"));
        buttonPanel.add(createNumberButton("3"));
        buttonPanel.add(createOperatorButton("-"));

        buttonPanel.add(createNumberButton("0"));
        buttonPanel.add(createClearButton("C"));
        buttonPanel.add(createEqualsButton("="));
        buttonPanel.add(createOperatorButton("+"));

        add(buttonPanel, BorderLayout.CENTER);
        setSize(350, 450);
        setLocationRelativeTo(null);
    }

    private JButton createNumberButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.addActionListener(e -> {
            if (startNewNumber) {
                display.setText(text);
                startNewNumber = false;
            } else {
                display.setText(display.getText() + text);
            }
        });
        return btn;
    }

    private JButton createOperatorButton(String op) {
        JButton btn = new JButton(op);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.addActionListener(e -> {
            firstOperand = Double.parseDouble(display.getText());
            operator = op;
            startNewNumber = true;
        });
        return btn;
    }

    private JButton createEqualsButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setBackground(new Color(100, 200, 100));
        btn.addActionListener(e -> {
            double secondOperand = Double.parseDouble(display.getText());
            double result = 0;
            switch (operator) {
                case "+": result = firstOperand + secondOperand; break;
                case "-": result = firstOperand - secondOperand; break;
                case "*": result = firstOperand * secondOperand; break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        display.setText("Error");
                        startNewNumber = true;
                        return;
                    }
                    break;
                default: return;
            }
            display.setText(String.valueOf(result));
            startNewNumber = true;
        });
        return btn;
    }

    private JButton createClearButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setBackground(new Color(255, 150, 150));
        btn.addActionListener(e -> {
            display.setText("0");
            firstOperand = 0;
            operator = "";
            startNewNumber = true;
        });
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EventDrivenCalculator().setVisible(true));
    }
}

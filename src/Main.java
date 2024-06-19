import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LockerApplication extends JFrame {
    private String savedPassword = null;
    private JTextField passwordField;
    private JLabel statusLabel;

    public LockerApplication() {
        setTitle("Lock Class");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 3));
        passwordField = new JTextField();
        passwordField.setEditable(false);
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    passwordField.setText(passwordField.getText() + button.getText());
                }
            });
            inputPanel.add(button);
        }
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText("");
            }
        });
        inputPanel.add(clearButton);

        inputPanel.add(passwordField);

        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleEnterButton();
            }
        });
        inputPanel.add(enterButton);

        panel.add(inputPanel, BorderLayout.CENTER);
        statusLabel = new JLabel("Enter Password", SwingConstants.CENTER);
        panel.add(statusLabel, BorderLayout.SOUTH);

        add(panel);
    }

    private void handleEnterButton() {
        String inputPassword = passwordField.getText();

        if (savedPassword == null) {
            savedPassword = inputPassword;
            statusLabel.setText("Password Set");
        } else {
            if (savedPassword.equals(inputPassword)) {
                statusLabel.setText("Correct Password");
            } else {
                statusLabel.setText("Incorrect Password");
            }
        }

        passwordField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LockerApplication().setVisible(true);
            }
        });
    }
}

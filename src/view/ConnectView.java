package view;

import interface_adapter.connect.ConnectController;
import javax.swing.*;
import java.awt.*;

public class ConnectView extends JFrame {
    private JTextArea messageTextArea;
    private final ConnectController connectController;

    public ConnectView(ConnectController connectController) {
        super("Send Message"); // Set the title of the JFrame
        this.connectController = connectController;
        initializeUI();
    }

    private void initializeUI() {
        messageTextArea = new JTextArea(10, 40);
        JButton sendButton = new JButton("Send");

        setLayout(new BorderLayout());
        add(new JScrollPane(messageTextArea), BorderLayout.CENTER); // Add scrollable text area to center

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sendButton);
        add(buttonPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> {
            String message = messageTextArea.getText();
            if (!message.trim().isEmpty()) {
                connectController.handleSendEmailClicked(message);
                messageTextArea.setText("");
                setVisible(false); // Hide the window after sending the message
                dispose(); // Dispose of the window resources
            } else {
                JOptionPane.showMessageDialog(this,
                        "Message is empty. Please enter a message.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        setSize(400, 300); // Set the preferred size of the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ensure the window closes properly
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true); // Make the window visible
    }
}
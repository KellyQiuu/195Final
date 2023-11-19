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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ensure the window closes properly
        this.setSize(300, 200); // Set the preferred size of the window
        this.setLocationRelativeTo(null); // Center the window on the screen
    }

    private void initializeUI() {
        messageTextArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(messageTextArea); // Ensure the text area is scrollable
        JButton sendButton = new JButton("Send Email");

        // Layout setup
        this.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(sendButton);

        // Action setup
        sendButton.addActionListener(e -> {
            String message = messageTextArea.getText();
            if (!message.trim().isEmpty()) {
                connectController.handleSendEmailClicked(message);
                messageTextArea.setText("");
                this.setVisible(false); // Hide this window after sending the message
                this.dispose(); // Dispose of the window resources
            } else {
                JOptionPane.showMessageDialog(this,
                        "Message is empty. Please enter a message.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Adding components to the frame
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}

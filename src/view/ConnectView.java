package view;

import interface_adapter.connect.ConnectController;
import javax.swing.*;
import java.awt.*;

public class ConnectView extends JFrame {
    private JTextArea messageTextArea;
    private JButton connectButton;
    private JButton sendButton;
    private ConnectController connectController;

    public ConnectView(ConnectController connectController) {
        this.connectController = connectController;
        initializeUI();
    }

    private void initializeUI() {
        messageTextArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(messageTextArea);
        connectButton = new JButton("Connect");
        sendButton = new JButton("Send Email");

        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(connectButton);
        buttonPanel.add(sendButton);

        connectButton.addActionListener(e -> {
            messageTextArea.setEnabled(true);
            sendButton.setEnabled(true);
        });

        sendButton.addActionListener(e -> {
            String message = messageTextArea.getText();
            if (!message.trim().isEmpty()) {
                connectController.handleSendEmailClicked(message);
                messageTextArea.setText("");
                messageTextArea.setEnabled(false);
                sendButton.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "Message is empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Connect Feature");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

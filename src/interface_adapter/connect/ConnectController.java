package interface_adapter.connect;

import use_case.connect.ConnectInputBoundary;
import use_case.connect.ConnectInputData;

public class ConnectController {
    private final ConnectInputBoundary connectInputBoundary;
    private String senderUsername; // Assuming this is known/set elsewhere in the application
    private String recipientEmail; // Assuming this is known/set elsewhere in the application

    public ConnectController(ConnectInputBoundary connectInputBoundary, String senderUsername, String recipientEmail) {
        this.connectInputBoundary = connectInputBoundary;
        this.senderUsername = senderUsername;
        this.recipientEmail = recipientEmail;
    }

    /**
     * Handles the event when the "Send Email" button is clicked.
     * @param message The message to be sent.
     */
    public void handleSendEmailClicked(String message) {
        ConnectInputData inputData = new ConnectInputData(senderUsername, recipientEmail, message);
        connectInputBoundary.handleConnect(inputData);
    }

    // Methods to set or update sender and recipient details if needed

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    // Additional methods or logic as needed...
}

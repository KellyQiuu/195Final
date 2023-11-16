package use_case.connect;

public class ConnectInputData {
    private final String senderUsername;
    private final String recipientEmail;
    private final String message;

    public ConnectInputData(String senderUsername, String recipientEmail, String message) {
        this.senderUsername = senderUsername;
        this.recipientEmail = recipientEmail;
        this.message = message;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public String getMessage() {
        return message;
    }
}
